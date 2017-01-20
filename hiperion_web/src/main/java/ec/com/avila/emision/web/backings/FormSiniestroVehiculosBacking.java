package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;

import ec.com.avila.emision.web.beans.FormSiniestroVehiculosBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.DireccionService;
import ec.com.avila.hiperion.servicio.PolizaService;
import ec.com.avila.hiperion.servicio.ProvinciaService;
import ec.com.avila.hiperion.servicio.TipoDireccionService;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

@ManagedBean
@ViewScoped
public class FormSiniestroVehiculosBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{formSiniestroVehiculosBean}")
	private FormSiniestroVehiculosBean formSiniestroVehiculosBean;

	@EJB
	private ClienteService clienteService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;
	@EJB
	private TipoDireccionService tipoDireccionService;
	@EJB
	private ProvinciaService provinciaService;
	@EJB
	private PolizaService polizaService;
	@EJB
	private DireccionService direccionService;

	private List<SelectItem> tipoPersonaItems;
	private List<SelectItem> tipoIdentificacionItems;

	private List<Cliente> clientes;
	private List<Cliente> clientesObtenidos = new ArrayList<>();
	private List<Poliza> polizas;
	private Cliente clienteObtenido;

	private UploadedFile file;

	Logger log = Logger.getLogger(FormSiniestroVehiculosBacking.class);

	@PostConstruct
	public void inicializar() throws HiperionException {
		obtenerTipoIdentificacion();
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
		Catalogo catalogo = catalogoService.consultarCatalogoById(new Long(1));
		List<DetalleCatalogo> tiposPersona = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : tiposPersona) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tipoPersonaItems.add(selectItem);
		}

		return tipoPersonaItems;
	}

	/**
	 * 
	 * <b> Permite obtener los tipos de Identificaci&oacute;n de una persona Natural. </b>
	 * <p>
	 * [Author: kruger, Date: 13/11/2016]
	 * </p>
	 * 
	 * @return
	 */
	public List<SelectItem> obtenerTipoIdentificacion() {
		try {
			this.tipoIdentificacionItems = new ArrayList<SelectItem>();
			Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
					"ec.gob.avila.hiperion.recursos.catalogoTipoIdentificacion"));
			List<DetalleCatalogo> tiposPersona = catalogo.getDetalleCatalogos();

			for (DetalleCatalogo detalle : tiposPersona) {
				SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
				tipoIdentificacionItems.add(selectItem);
			}
		} catch (HiperionException ex) {
			ex.printStackTrace();
		}

		return tipoIdentificacionItems;
	}

	/**
	 * 
	 * <b> Permite buscar un cliente por medio del numero de identificacion. </b>
	 * <p>
	 * [Author: HIPERION, Date: 16/02/2016]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void buscarCliente() throws HiperionException {
		try {

			if (!formSiniestroVehiculosBean.getIdentificacion().equals("")) {
				clienteObtenido = clienteService.consultarClienteByIdentificacion(formSiniestroVehiculosBean.getIdentificacion());
				polizas = polizaService.consultarPolizasByCliente(clienteObtenido.getIdCliente());
				if (clienteObtenido == null) {
					MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.buscar"));
				}
			}

		} catch (HiperionException e) {
			log.error("Error al momento de buscar clientes", e);
			throw new HiperionException(e);
		}
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	/**
	 * @return the clientesObtenidos
	 */
	public List<Cliente> getClientesObtenidos() {
		return clientesObtenidos;
	}

	/**
	 * @param clientesObtenidos
	 *            the clientesObtenidos to set
	 */
	public void setClientesObtenidos(List<Cliente> clientesObtenidos) {
		this.clientesObtenidos = clientesObtenidos;
	}

	/**
	 * @return the tipoIdentificacionItems
	 */
	public List<SelectItem> getTipoIdentificacionItems() {
		return tipoIdentificacionItems;
	}

	/**
	 * @param tipoIdentificacionItems
	 *            the tipoIdentificacionItems to set
	 */
	public void setTipoIdentificacionItems(List<SelectItem> tipoIdentificacionItems) {
		this.tipoIdentificacionItems = tipoIdentificacionItems;
	}

	/**
	 * @return the file
	 */
	public UploadedFile getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(UploadedFile file) {
		this.file = file;
	}

	/**
	 * @return the clienteObtenido
	 */
	public Cliente getClienteObtenido() {
		return clienteObtenido;
	}

	/**
	 * @param clienteObtenido
	 *            the clienteObtenido to set
	 */
	public void setClienteObtenido(Cliente clienteObtenido) {
		this.clienteObtenido = clienteObtenido;
	}

	/**
	 * @return the polizas
	 */
	public List<Poliza> getPolizas() {
		return polizas;
	}

	/**
	 * @param polizas
	 *            the polizas to set
	 */
	public void setPolizas(List<Poliza> polizas) {
		this.polizas = polizas;
	}

	/**
	 * @return the formSiniestroVehiculosBean
	 */
	public FormSiniestroVehiculosBean getFormSiniestroVehiculosBean() {
		return formSiniestroVehiculosBean;
	}

	/**
	 * @param formSiniestroVehiculosBean
	 *            the formSiniestroVehiculosBean to set
	 */
	public void setFormSiniestroVehiculosBean(FormSiniestroVehiculosBean formSiniestroVehiculosBean) {
		this.formSiniestroVehiculosBean = formSiniestroVehiculosBean;
	}

}
