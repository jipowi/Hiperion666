/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.primefaces.event.RowEditEvent;

import ec.com.avila.emision.web.beans.AseguradoraBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.PersonaContactoAseguradoraDTO;
import ec.com.avila.hiperion.dto.RamoDTO;
import ec.com.avila.hiperion.emision.entities.Aseguradora;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.Contacto;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoAseguradora;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.AseguradoraService;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.servlet.ReportServlet;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>permite manejar las operaciones necesarias para manejar la logica de las aseguradoras</b>
 * 
 * @author kruger
 * @version 1.0,Dec 21, 2013
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class AseguradoraBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{aseguradoraBean}")
	private AseguradoraBean aseguradoraBean;

	@EJB
	private AseguradoraService aseguradoraService;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	private List<SelectItem> aseguradorasItems;

	@Resource(mappedName = "java:/AvilaSgsDS")
	private DataSource dataSource;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	private String rutaReporte;
	private List<SelectItem> ramoItems;
	private ArrayList<RamoDTO> ramoList = new ArrayList<RamoDTO>();
	private ArrayList<PersonaContactoAseguradoraDTO> contactoList = new ArrayList<PersonaContactoAseguradoraDTO>();
	private String nombreRamo;
	private BigDecimal comision;
	private String nombre;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String identificacion;
	private String cargo;
	private String email;
	private String telefonoContacto;

	@PostConstruct
	public void inicializar() throws HiperionException {
		// consultarAseguradoras();
	}

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @throws SQLException
	 * 
	 */
	public void cargarReporte(String tipoReporte) throws SQLException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		Map<String, Object> parametros = new HashMap<String, Object>();
		if (tipoReporte.equals("pdf"))
			parametros.put("TIPO_REPORTE", "pdf");
		else
			parametros.put("TIPO_REPORTE", "excel");

		request.getSession().setAttribute(ReportServlet.OBJETO_REPORTE, parametros);
	}

	/**
	 * 
	 * <b> Permite agregar un nuevo ramo asociado a la aseguradora </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 10, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public void addRamo() throws HiperionException {

		Long idRamo = aseguradoraBean.getIdRamo();
		Ramo ramoTemp = aseguradoraService.consultarRamoById(idRamo);
		BigDecimal zero = new BigDecimal("0");
		Integer cont = 0;
		if (ramoTemp == null || this.comision.compareTo(zero) == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("Es necesario agregar un ramo y un valor"));
		} else {
			for (RamoDTO ramoDTO : ramoList) {
				if (ramoDTO.getIdRamo() == idRamo) {
					cont++;
				}
			}
			if (cont > 0) {
				MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("No se permiten ingresar ramos repetidos"));
			} else {
				RamoDTO item = new RamoDTO(idRamo, ramoTemp.getNombreRamo(), this.comision);
				ramoList.add(item);
				nombreRamo = "";
				comision = new BigDecimal(0.0);
			}
		}
	}

	/**
	 * 
	 * <b> Permite editar una ramo ingresado </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 10, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void editRamo(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((RamoDTO) event.getObject()).getNombreRamo());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un ramo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 10, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void cancelRamo(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		ramoList.remove((RamoDTO) event.getObject());
	}

	/**
	 * 
	 * <b> Pemrite agregar un contacto </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addContacto() {

		if (contactoList == null) {
			contactoList = new ArrayList<>();
		}

		PersonaContactoAseguradoraDTO item = new PersonaContactoAseguradoraDTO(this.nombre, this.apellidoMaterno, this.apellidoPaterno,
				this.identificacion, this.cargo, this.email, this.telefonoContacto);

		contactoList.add(item);

		this.nombre = "";
		this.apellidoMaterno = "";
		this.apellidoPaterno = "";
		this.identificacion = "";
		this.cargo = "";
		this.email = "";
		this.telefonoContacto = "";

		return null;
	}

	/**
	 * 
	 * <b> Permite editar un contacto una vez ingresado </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((PersonaContactoAseguradoraDTO) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un contacto </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		contactoList.remove((PersonaContactoAseguradoraDTO) event.getObject());
	}

	/**
	 * 
	 * <b> Permite guardar una aseguradora en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 10, 2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarAseguradora() throws HiperionException {
		Usuario usuario = usuarioBean.getSessionUser();
		boolean save = false;
		Aseguradora aseguradora = aseguradoraService.consultarAseguradoraByCodigo(aseguradoraBean.getCodAseguradora().toString());

		if (aseguradora == null) {
			save = true;
			aseguradora = new Aseguradora();
		}

		aseguradora.setCodigoAseguradora(aseguradoraBean.getCodAseguradora().toString());
		aseguradora.setDirecion(aseguradoraBean.getDireccion());
		aseguradora.setEmailAseguradora(aseguradoraBean.getMailAseguradora());
		aseguradora.setRuc(aseguradoraBean.getRuc());
		aseguradora.setTelfConvencionalAseg((aseguradoraBean.getTelefono()));
		aseguradora.setIdUsuarioCreacion(usuario.getIdUsuario());
		aseguradora.setFechaCreacion(new Date());
		aseguradora.setEstado(EstadoEnum.A);

		if (contactoList != null) {
			List<Cliente> contactosAseguradora = new ArrayList<>();

			for (PersonaContactoAseguradoraDTO contactoAseguradora : contactoList) {

				Cliente persona = new Cliente();

				persona.setNombrePersona(contactoAseguradora.getNombre());
				persona.setApellidoPaterno(contactoAseguradora.getApellidoPaterno());
				persona.setApellidoMaterno(contactoAseguradora.getApellidoMaterno());
				persona.setIdentificacionPersona(contactoAseguradora.getIdentificacion());
				persona.setActividadProfesion(contactoAseguradora.getCargo());
				persona.setIdUsuarioCreacion(usuario.getIdUsuario());
				persona.setFechaCreacion(new Date());
				persona.setEstado(EstadoEnum.A);

				Contacto contactoTelefono = new Contacto();
				contactoTelefono.setTipoContacto("TELEFONO");
				contactoTelefono.setDescripcionContacto(contactoAseguradora.getTelefonoContacto());

				Contacto contactoMail = new Contacto();
				contactoMail.setTipoContacto("MAIL");
				contactoMail.setDescripcionContacto(contactoAseguradora.getEmail());

				List<Contacto> contactos = new ArrayList<Contacto>();

				contactos.add(contactoTelefono);
				contactos.add(contactoMail);

				persona.setContactos(contactos);

				contactosAseguradora.add(persona);
			}

			List<RamoAseguradora> ramos = new ArrayList<>();
			for (RamoDTO ramoDTO : ramoList) {
				RamoAseguradora ramoAseg = new RamoAseguradora();
				Ramo ramo = new Ramo();
				ramo.setNombreRamo(ramoDTO.getNombreRamo());
				ramo.setIdRamo(ramoDTO.getIdRamo());

				ramoAseg.setRamo(ramo);
				ramoAseg.setEstado("A");
				ramoAseg.setFechaCreacion(new Date());
				ramoAseg.setIdUsuarioCreacion(usuario.getIdUsuario());

				ramoAseg.setComision(ramoDTO.getComision());
				ramos.add(ramoAseg);
			}

			aseguradora.setRamoAseguradoras(ramos);

			aseguradoraService.guardarAseguradora(aseguradora, contactosAseguradora, ramos, save);

			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.aseguradora"));
			aseguradoraBean.setRuc(null);
			aseguradoraBean.setTelefono(null);
			aseguradoraBean.setDireccion(null);
			aseguradoraBean.setTelefono(null);
			aseguradoraBean.setMailAseguradora(null);
			contactoList = new ArrayList<>();

			aseguradora = new Aseguradora();
			contactosAseguradora = new ArrayList<>();
			ramos = new ArrayList<>();

		} else {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("Es necesario agregar contactos para la aseguradora"));
		}
	}

	/**
	 * 
	 * <b> Permite consultar las aseguradoras ingresadas en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 17, 2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void consultarAseguradoras() throws HiperionException {

		contactoList = new ArrayList<>();
		Aseguradora aseguradora = aseguradoraService.consultarAseguradoraByRucAseg(aseguradoraBean.getRuc(), aseguradoraBean.getCodAseguradora());
		if (aseguradora != null) {

			aseguradoraBean.setRuc(aseguradora.getRuc());
			aseguradoraBean.setDireccion(aseguradora.getDirecion());
			aseguradoraBean.setMailAseguradora(aseguradora.getEmailAseguradora());
			aseguradoraBean.setTelefono(aseguradora.getTelfConvencionalAseg());

			aseguradoraBean.setActivarNewAseguradora(true);

			// Obtener contactos de la aseguradora seleccionada
			List<Cliente> clientesAseguradora = aseguradoraService.consultarClienteByAseguradora(aseguradora.getCodigoAseguradora());

			for (Cliente cliente : clientesAseguradora) {
				PersonaContactoAseguradoraDTO personaDTO = new PersonaContactoAseguradoraDTO();

				personaDTO.setNombre(cliente.getNombrePersona());
				personaDTO.setIdentificacion(cliente.getIdentificacionPersona());
				personaDTO.setApellidoPaterno(cliente.getApellidoPaterno());
				personaDTO.setApellidoMaterno(cliente.getApellidoMaterno());
				personaDTO.setCargo(cliente.getActividadProfesion());

				contactoList.add(personaDTO);
			}

			List<RamoAseguradora> ramosAsegList = aseguradoraService.consultarRamoAseguradora(aseguradora.getIdAseguradora());
			for (RamoAseguradora ramoAseguradora : ramosAsegList) {
				RamoDTO ramoDTO = new RamoDTO();
				ramoDTO.setIdRamo(ramoAseguradora.getRamo().getIdRamo());
				ramoDTO.setNombreRamo(ramoAseguradora.getRamo().getNombreRamo());
				ramoDTO.setComision(ramoAseguradora.getComision());

				ramoList.add(ramoDTO);
			}

		} else {
			aseguradoraBean.setDireccion(null);
			aseguradoraBean.setMailAseguradora(null);
			aseguradoraBean.setTelefono(null);
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.war.aseguradora"));
			aseguradoraBean.setActivarNewAseguradora(true);
		}
	}

	/**
	 * 
	 * <b> Permite activar la pantalla para crear una nueva aseguradora </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 18, 2014]
	 * </p>
	 * 
	 */
	public void crearAseguradora() {
		aseguradoraBean.setActivarNewAseguradora(true);
	}

	/**
	 * @return the aseguradoraBean
	 */
	public AseguradoraBean getAseguradoraBean() {
		return aseguradoraBean;
	}

	/**
	 * @param aseguradoraBean
	 *            the aseguradoraBean to set
	 */
	public void setAseguradoraBean(AseguradoraBean aseguradoraBean) {
		this.aseguradoraBean = aseguradoraBean;
	}

	/**
	 * @return the aseguradorasItems
	 * @throws HiperionException
	 */
	public List<SelectItem> getAseguradorasItems() throws HiperionException {

		if (this.aseguradorasItems == null) {
			this.aseguradorasItems = new ArrayList<SelectItem>();
		}

		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoAseguradoras"));

		List<DetalleCatalogo> aseguradoras = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : aseguradoras) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			aseguradorasItems.add(selectItem);
		}

		return aseguradorasItems;
	}

	/**
	 * @param aseguradorasItems
	 *            the aseguradorasItems to set
	 */
	public void setAseguradorasItems(List<SelectItem> aseguradorasItems) {
		this.aseguradorasItems = aseguradorasItems;
	}

	/**
	 * @return the rutaReporte
	 */
	public String getRutaReporte() {
		return rutaReporte;
	}

	/**
	 * @param rutaReporte
	 *            the rutaReporte to set
	 */
	public void setRutaReporte(String rutaReporte) {
		this.rutaReporte = rutaReporte;
	}

	/**
	 * @return the usuarioBean
	 */
	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	/**
	 * @param usuarioBean
	 *            the usuarioBean to set
	 */
	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	/**
	 * @return the ramoItems
	 * @throws HiperionException
	 */
	public List<SelectItem> getRamoItems() throws HiperionException {
		this.ramoItems = new ArrayList<SelectItem>();
		List<Ramo> ramos = aseguradoraService.consultarRamos();

		for (Ramo ramo : ramos) {
			SelectItem selectItem = new SelectItem(ramo.getIdRamo(), ramo.getNombreRamo());
			ramoItems.add(selectItem);
		}

		return ramoItems;
	}

	/**
	 * @param ramoItems
	 *            the ramoItems to set
	 */
	public void setRamoItems(List<SelectItem> ramoItems) {
		this.ramoItems = ramoItems;
	}

	/**
	 * @return the ramoList
	 */
	public ArrayList<RamoDTO> getRamoList() {
		return ramoList;
	}

	/**
	 * @param ramoList
	 *            the ramoList to set
	 */
	public void setRamoList(ArrayList<RamoDTO> ramoList) {
		this.ramoList = ramoList;
	}

	/**
	 * @return the nombreRamo
	 */
	public String getNombreRamo() {
		return nombreRamo;
	}

	/**
	 * @param nombreRamo
	 *            the nombreRamo to set
	 */
	public void setNombreRamo(String nombreRamo) {
		this.nombreRamo = nombreRamo.toUpperCase();
	}

	/**
	 * @return the comision
	 */
	public BigDecimal getComision() {
		return comision;
	}

	/**
	 * @param comision
	 *            the comision to set
	 */
	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno
	 *            the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno
	 *            the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion
	 *            the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefonoContacto
	 */
	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	/**
	 * @param telefonoContacto
	 *            the telefonoContacto to set
	 */
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	/**
	 * @return the contactoList
	 */
	public ArrayList<PersonaContactoAseguradoraDTO> getContactoList() {
		return contactoList;
	}

	/**
	 * @param contactoList
	 *            the contactoList to set
	 */
	public void setContactoList(ArrayList<PersonaContactoAseguradoraDTO> contactoList) {
		this.contactoList = contactoList;
	}

}
