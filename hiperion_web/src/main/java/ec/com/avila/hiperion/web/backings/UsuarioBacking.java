package ec.com.avila.hiperion.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import ec.com.avila.emision.web.validator.ValidatorCedula;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.MenuDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Menu;
import ec.com.avila.hiperion.emision.entities.Rol;
import ec.com.avila.hiperion.emision.entities.RolMenu;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.html.UtilsHtml;
import ec.com.avila.hiperion.mail.MailUtil;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.UsuarioService;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.resources.Utils;
import ec.com.avila.hiperion.web.util.FechasUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

@ManagedBean
@SessionScoped
public class UsuarioBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private UsuarioService usuarioServicio;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	private List<SelectItem> rolesItems;

	private MenuModel menumodel = new DefaultMenuModel();
	List<Menu> menuList = new ArrayList<>();
	List<Menu> menuSelectedList = new ArrayList<>();
	List<MenuDTO> menuDTOList = new ArrayList<MenuDTO>();

	Logger log = Logger.getLogger(UsuarioBacking.class);

	@PostConstruct
	public void inicializar() throws HiperionException {
		obtenerMenus();
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	/**
	 * 
	 * <b> Permite autenticar el usuario con la aplicacion </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 6, 2014]
	 * </p>
	 * 
	 * @param actionEvent
	 * @return
	 * @throws HiperionException
	 */
	public String login(ActionEvent actionEvent) throws HiperionException {
		menumodel = new DefaultMenuModel();
		menuList = new ArrayList<>();

		try {
			String salida = HiperionMensajes.getInstancia().getString("valor.navigation.error");

			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage msg = null;
			boolean loggedIn;

			Usuario usuario;

			usuario = usuarioServicio.loginUser(usuarioBean.getNombreUsuario(), usuarioBean.getPassword());

			if (usuario != null) {
				loggedIn = true;
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioBean.getNombreUsuario());
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", usuarioBean.getNombreUsuario());
				salida = HiperionMensajes.getInstancia().getString("valor.navigation.main");
			} else {
				loggedIn = false;
				msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
			}

			// Consultar Roles por usuario
			List<Rol> roles = usuarioServicio.consultarRolByUsuario(usuario);
			// Consultar Menu por roles
			for (Rol rol : roles) {
				List<RolMenu> listRolMenus = usuarioServicio.consultarRolMenus(rol);
				for (RolMenu rolMenu : listRolMenus) {
					menuList.add(rolMenu.getMenu());
				}
			}

			// Agregar menus para el usuario
			List<Menu> listMenuPadres = new ArrayList<>();
			for (Menu menuPadre : menuList) {
				if (menuPadre.getIdPadre() == null) {
					listMenuPadres.add(menuPadre);
				}
			}

			for (Menu menuPadre : listMenuPadres) {
				DefaultSubMenu firstSubmenu = new DefaultSubMenu(menuPadre.getNombreMenu());
				for (Menu menuHijos : menuList) {
					if (menuHijos.getIdPadre() == menuPadre.getIdMenu()) {
						DefaultMenuItem menuItem = new DefaultMenuItem(menuHijos.getNombreMenu());
						menuItem.setUrl(menuHijos.getUrl());

						firstSubmenu.addElement(menuItem);
					}
				}
				menumodel.addElement(firstSubmenu);
			}

			FacesContext.getCurrentInstance().addMessage(null, msg);
			context.addCallbackParam("loggedIn", loggedIn);

			usuarioBean.setSessionUser(usuario);

			return salida;

		} catch (HiperionException e) {
			log.error("Error al momento de hacer login", e);
			throw new HiperionException(e);
		}
	}

	/**
	 * 
	 * <b> Permite enviar mail de confirmacion de creacion de usuario en el sistema. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 21/01/2015]
	 * </p>
	 * 
	 */
	public void enviarMail() {

		String fechaActual = FechasUtil.getInstancia().dateForStringFull(new Date());
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String url = Utils.getInstancia().obtenerPathCompleto(req);

		String mensaje = UtilsHtml.getInstancia().obtenerContenidoHTML("formatoUsuario.html").replace("#{FechaActual}", fechaActual).replace("#{NombreUsuario}", usuarioBean.getNombreApellido())
				.replace("#{Nickname}", usuarioBean.getNickname()).replace("#{Clave}", usuarioBean.getClave()).replace("#{direccion.app}", url);

		log.info(mensaje);

		String correo1 = usuarioBean.getCorreo();
		String correo2 = "fpozo@avila-asociados.com";
		String de = "paulitochevere999@gmail.com";
		String subject = "Confirmacion de cuenta";

		try {
			MailUtil.getInstancia().envioMailBasico(new String[] { correo1, correo2 }, de, subject, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite cargar la lista de menus para seleccionar. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 11/01/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void obtenerMenus() throws HiperionException {
		menuDTOList = new ArrayList<>();

		try {
			List<Menu> menus = usuarioServicio.consultaMenus();

			for (Menu menu : menus) {

				MenuDTO menuDTO = new MenuDTO();

				menuDTO.setIdMenu(menu.getIdMenu());
				menuDTO.setNombreMenu(menu.getNombreMenu());
				menuDTO.setUrl(menu.getUrl());
				if (menu.getIdPadre() != null) {
					menuDTO.setIdPadre(menu.getIdPadre());
				}
				menuDTO.setEstadoMenu(menu.getEstadoMenu());
				menuDTOList.add(menuDTO);
			}

		} catch (HiperionException e) {
			log.error("Error al momento de hacer login", e);
			throw new HiperionException(e);
		}
	}

	/**
	 * 
	 * <b> Permite agregar los menu a usuario que se esta registrando. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 11/01/2015]
	 * </p>
	 * 
	 */
	public void agregarMenus() {
		menuSelectedList = new ArrayList<>();
		for (MenuDTO menuDTO : menuDTOList) {
			if (menuDTO.getSelected()) {
				Menu menu = new Menu();

				menu.setIdMenu(menuDTO.getIdMenu());
				menu.setNombreMenu(menuDTO.getNombreMenu());
				menu.setIdPadre(menuDTO.getIdPadre());
				menu.setUrl(menuDTO.getUrl());
				menu.setEstadoMenu(menuDTO.getEstadoMenu());

				menuSelectedList.add(menu);
			}
		}
	}

	/**
	 * 
	 * <b> Permite guardar usuarios en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 10/01/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 * 
	 */
	public void guardarUsuario() throws HiperionException {
		try {

			if (ValidatorCedula.getInstancia().validateCedula(usuarioBean.getIdentificacion())) {
				// Usuario
				Usuario usuario = new Usuario();
				usuario.setUsuario(usuarioBean.getNickname());
				usuario.setNombreUsuario(usuarioBean.getNombreApellido());
				usuario.setIdentificacionUsuario(usuarioBean.getIdentificacion());
				usuario.setClave(usuarioBean.getClave());
				usuario.setEmailUsuario(usuarioBean.getCorreo());
				usuario.setFechaCreacion(new Date());
				usuario.setEstado(EstadoEnum.A);

				Usuario usuarioCreacion = usuarioBean.getSessionUser();
				usuario.setIdUsuarioCreacion(usuarioCreacion.getIdUsuario());

				// Rol de usuario
				Integer idRol = Integer.parseInt(usuarioBean.getRol());
				DetalleCatalogo detalleCatalogo = detalleCatalogoService.consultarDetalleByCatalogoAndDetalle(HiperionMensajes.getInstancia()
						.getInteger("ec.gob.avila.hiperion.recursos.catalogoRoles"), idRol);
				Rol rol = new Rol();

				rol.setDescripcionRol(detalleCatalogo.getDescDetCatalogo());
				rol.setEstadoRol(EstadoEnum.A);
				rol.setNombreRol(detalleCatalogo.getDescDetCatalogo());

				usuarioServicio.guardarUsuario(usuario, rol, menuSelectedList);

				MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.usuario"));
				enviarMail();

				menuSelectedList = new ArrayList<>();
				usuarioBean.setNickname("");
				usuarioBean.setNombreApellido("");
				usuarioBean.setIdentificacion("");
				usuarioBean.setClave("");
				usuarioBean.setCorreo("");
				usuarioBean.setNickname("");
				usuarioBean.setRol(null);
			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensage.error.identificacionNoValido"));
			}
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el usuario", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));
			throw new HiperionException(e);
		}
	}

	/**
	 * @return the menumodel
	 */
	public MenuModel getMenumodel() {
		return menumodel;
	}

	/**
	 * @param menumodel
	 *            the menumodel to set
	 */
	public void setMenumodel(MenuModel menumodel) {
		this.menumodel = menumodel;
	}

	/**
	 * @return the menuList
	 */
	public List<Menu> getMenuList() {
		return menuList;
	}

	/**
	 * @param menuList
	 *            the menuList to set
	 */
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	/**
	 * @return the rolesItems
	 * @throws HiperionException
	 */
	public List<SelectItem> getRolesItems() throws HiperionException {
		this.rolesItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoRoles"));
		List<DetalleCatalogo> roles = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : roles) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			rolesItems.add(selectItem);
		}

		return rolesItems;
	}

	/**
	 * @param rolesItems
	 *            the rolesItems to set
	 */
	public void setRolesItems(List<SelectItem> rolesItems) {
		this.rolesItems = rolesItems;
	}

	/**
	 * @return the menuDTOList
	 */
	public List<MenuDTO> getMenuDTOList() {
		return menuDTOList;
	}

	/**
	 * @param menuDTOList
	 *            the menuDTOList to set
	 */
	public void setMenuDTOList(List<MenuDTO> menuDTOList) {
		this.menuDTOList = menuDTOList;
	}

}
