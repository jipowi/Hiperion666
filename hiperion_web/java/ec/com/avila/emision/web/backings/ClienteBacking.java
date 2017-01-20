package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import ec.com.avila.emision.web.beans.ClienteBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Catalogo;
import ec.com.avila.hiperion.entities.Cliente;
import ec.com.avila.hiperion.entities.DetalleCatalogo;
import ec.com.avila.hiperion.entities.Direccion;
import ec.com.avila.hiperion.entities.Persona;
import ec.com.avila.hiperion.entities.TipoDireccion;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.PersonaService;
import ec.com.avila.hiperion.servicio.TipoDireccionService;
import ec.com.avila.hiperion.web.util.EmisionUtil;

@ManagedBean
@RequestScoped
public class ClienteBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{clienteBean}")
	private ClienteBean clienteBean;

	@EJB
	private PersonaService personaService;
	@EJB
	private ClienteService clienteService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private TipoDireccionService tipoDireccionService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	private List<SelectItem> provinciasItems;
	private List<SelectItem> ciudadesItems;
	private List<SelectItem> tipoPersonaItems;
	private List<SelectItem> tipoIdentificacionItems;
	private List<SelectItem> tipoDireccionItems;

	private List<Cliente> clientes;
	private List<Direccion> direcciones;

	private String codigoCliente;
	private int longitudIdentificacion;

	private Boolean activarIdentificacion = true;
	private Boolean activarPanelPersonaNatural;
	private Boolean activarPanelPersonaJuridica;
	private Boolean activarPanelDireccionCobro;
	private Boolean activarPanelDireccionDomicilio;
	private Boolean activarPanelDireccionOficina;

	@PostConstruct
	void inicializar() throws HiperionException {
		setClientes(clienteService.consultarClientes());
	}

	public String getCodigoCliente() {
		this.codigoCliente = EmisionUtil.obtenerCodigoCliente(clientes.size() + 1);
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	/**
	 * 
	 * <b> Permite obtener la lista de Tipos de Persona registrados en el Sistema. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 19, 2014]
	 * </p>
	 * 
	 * @return - Tipos de Persona
	 * @throws HiperionException
	 */
	public List<SelectItem> getTipoPersonaItems() throws HiperionException {
		this.tipoPersonaItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(1);
		List<DetalleCatalogo> tiposPersona = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : tiposPersona) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescripcion());
			tipoPersonaItems.add(selectItem);
		}

		return tipoPersonaItems;
	}

	/**
	 * 
	 * <b> Permite obtener una lista de Tipos de Identificaci&oacute;n de una Persona registrados en el Sistema. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 19, 2014]
	 * </p>
	 * 
	 * @return - Tipo de Identificaciones de una Persona
	 * @throws HiperionException
	 */
	public List<SelectItem> getTipoIdentificacionItems() throws HiperionException {
		this.tipoIdentificacionItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(2);
		List<DetalleCatalogo> tiposPersona = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : tiposPersona) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescripcion());
			tipoIdentificacionItems.add(selectItem);
		}

		return tipoIdentificacionItems;
	}

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 08/06/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getTiposDireccionItems() throws HiperionException {
		this.tipoDireccionItems = new ArrayList<SelectItem>();
		List<TipoDireccion> tiposDireccion = tipoDireccionService.consultarTiposDireccion();

		for (TipoDireccion tipoDireccion : tiposDireccion) {
			SelectItem selectItem = new SelectItem(tipoDireccion.getCodigoTipoDireccion(), tipoDireccion.getDescripcion());
			tipoDireccionItems.add(selectItem);
		}

		return tipoDireccionItems;
	}

	/**
	 * 
	 * <b> Permite obtener una lista de todas la Provincias del Ecuador registradas en el Sistema </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 19, 2014]
	 * </p>
	 * 
	 * @return - Provicnias del Ecuador
	 * @throws HiperionException
	 */
	public List<SelectItem> getProvinciasItems() throws HiperionException {
		this.provinciasItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(3);
		List<DetalleCatalogo> provincias = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalleCatalogo : provincias) {
			SelectItem selectItem = new SelectItem(detalleCatalogo.getCodDetalleCatalogo(), detalleCatalogo.getDescripcion());
			provinciasItems.add(selectItem);
		}

		return provinciasItems;
	}

	/**
	 * 
	 * <b> Permite validar el n&uacute;mero de caracteres de un campo seg&uacute;n el tipo de identificaci&oacute;n. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 19, 2014]
	 * </p>
	 * 
	 * @param tipoPersona
	 *            - Tipo de Persona: Natural o Juridica
	 */
	public void selectTipoPersona(Integer tipoPersona) {
		setActivarIdentificacion(false);
		if (tipoPersona == 1) {
			clienteBean.setTipoIdentificacion("1");
			setLongitudIdentificacion(10);
			setActivarPanelPersonaNatural(true);
			clienteBean.setIdentificacion("");
		} else if (tipoPersona == 2) {
			clienteBean.setTipoIdentificacion("2");
			setLongitudIdentificacion(13);
			setActivarPanelPersonaJuridica(true);
		}
	}

	public void selectTipoDireccion(String tipoDireccion) {
		if (tipoDireccion.equals("COB")) {
			setActivarPanelDireccionCobro(true);
		} else if (tipoDireccion.equals("DOM")) {
			setActivarPanelDireccionDomicilio(true);
		} else if (tipoDireccion.equals("OFI")) {
			setActivarPanelDireccionOficina(true);
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Ciudades del Ecuador registradas en el Sistema, en base a la Provincia seleccionada. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 19, 2014]
	 * </p>
	 * 
	 * @param codigoProvincia
	 *            - C&oacute;digo de la Provincia Seleccionada
	 * @throws HiperionException
	 */
	public void obtenerCiudadesPorProvincia(String codigoProvincia) throws HiperionException {
		this.ciudadesItems = new ArrayList<SelectItem>();
		if (codigoProvincia != null) {
			List<DetalleCatalogo> ciudades = detalleCatalogoService.consultarDetalleCatalogoByDepCatalogo("3", codigoProvincia);
			for (DetalleCatalogo detalleCatalogo : ciudades) {
				SelectItem selectItem = new SelectItem(detalleCatalogo.getCodDetalleCatalogo(), detalleCatalogo.getDescripcion());
				ciudadesItems.add(selectItem);
			}
		}
	}

	/**
	 * 
	 * <b> Permite Guradar a un Nuevo Cliente. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 21, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void guardarCliente(ActionEvent event) {
		Persona persona = new Persona();
		Cliente cliente = new Cliente();
		// Persona Natural
		if (clienteBean.getTipoPersona() == 1) {
			persona.setEmail(clienteBean.getEmailPerNatural());

			// Persona Juridica
		} else if (clienteBean.getTipoPersona() == 2) {
			cliente.setEmail(clienteBean.getEmailPerJuridica());
		}
		persona.setTipoIdentificacion(clienteBean.getTipoIdentificacion());
		persona.setIdentificacion(clienteBean.getIdentificacion());
		// persona.setNombre(clienteBean.getNombre());
		persona.setApellidoPaterno(clienteBean.getApePaterno());
		persona.setApellidoMaterno(clienteBean.getApeMaterno());
		persona.setFechaNacimiento(clienteBean.getFechaNacimiento());

		System.out.println(clienteBean);

		String msg = "Guardado";
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Boolean getActivarIdentificacion() {
		return activarIdentificacion;
	}

	public void setActivarIdentificacion(Boolean activarIdentificacion) {
		this.activarIdentificacion = activarIdentificacion;
	}

	public int getLongitudIdentificacion() {
		return longitudIdentificacion;
	}

	public void setLongitudIdentificacion(int longitudIdentificacion) {
		this.longitudIdentificacion = longitudIdentificacion;
	}

	public Boolean getActivarPanelPersonaNatural() {
		return activarPanelPersonaNatural;
	}

	public void setActivarPanelPersonaNatural(Boolean activarPanelPersonaNatural) {
		this.activarPanelPersonaNatural = activarPanelPersonaNatural;
	}

	public Boolean getActivarPanelPersonaJuridica() {
		return activarPanelPersonaJuridica;
	}

	public void setActivarPanelPersonaJuridica(Boolean activarPanelPersonaJuridica) {
		this.activarPanelPersonaJuridica = activarPanelPersonaJuridica;
	}

	public List<SelectItem> getCiudadesItems() {
		return ciudadesItems;
	}

	public void setCiudadesItems(List<SelectItem> ciudadesItems) {
		this.ciudadesItems = ciudadesItems;
	}

	/**
	 * @return the activarPanelDireccionDomicilio
	 */
	public Boolean getActivarPanelDireccionDomicilio() {
		return activarPanelDireccionDomicilio;
	}

	/**
	 * @param activarPanelDireccionDomicilio
	 *            the activarPanelDireccionDomicilio to set
	 */
	public void setActivarPanelDireccionDomicilio(Boolean activarPanelDireccionDomicilio) {
		this.activarPanelDireccionDomicilio = activarPanelDireccionDomicilio;
	}

	/**
	 * @return the activarPanelDireccionCobro
	 */
	public Boolean getActivarPanelDireccionCobro() {
		return activarPanelDireccionCobro;
	}

	/**
	 * @param activarPanelDireccionCobro
	 *            the activarPanelDireccionCobro to set
	 */
	public void setActivarPanelDireccionCobro(Boolean activarPanelDireccionCobro) {
		this.activarPanelDireccionCobro = activarPanelDireccionCobro;
	}

	/**
	 * @return the activarPanelDireccionOficina
	 */
	public Boolean getActivarPanelDireccionOficina() {
		return activarPanelDireccionOficina;
	}

	/**
	 * @param activarPanelDireccionOficina
	 *            the activarPanelDireccionOficina to set
	 */
	public void setActivarPanelDireccionOficina(Boolean activarPanelDireccionOficina) {
		this.activarPanelDireccionOficina = activarPanelDireccionOficina;
	}

	/**
	 * @return the direcciones
	 */
	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	/**
	 * @param direcciones the direcciones to set
	 */
	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
}
