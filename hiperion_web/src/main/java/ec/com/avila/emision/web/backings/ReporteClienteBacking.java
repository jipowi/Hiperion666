package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.PolizaService;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

@ManagedBean
@ViewScoped
public class ReporteClienteBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ClienteService clienteService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	@EJB
	private PolizaService polizaService;

	private Date fechaDesde;
	private Date fechaHasta;
	private String identificacion;
	private List<Poliza> polizas;
	private Cliente clienteObtenido;
	private boolean activarGrafico = false;

	Logger log = Logger.getLogger(ReporteClienteBacking.class);

	@PostConstruct
	public void init() {
		// createPiePolizas();
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

			if (!identificacion.equals("")) {
				clienteObtenido = clienteService.consultarClienteByIdentificacion(identificacion);
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
	 * @return the fechaDesde
	 */
	public Date getFechaDesde() {
		return fechaDesde;
	}

	/**
	 * @param fechaDesde
	 *            the fechaDesde to set
	 */
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	/**
	 * @return the fechaHasta
	 */
	public Date getFechaHasta() {
		return fechaHasta;
	}

	/**
	 * @param fechaHasta
	 *            the fechaHasta to set
	 */
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	/**
	 * @return the activarGrafico
	 */
	public boolean isActivarGrafico() {
		return activarGrafico;
	}

	/**
	 * @param activarGrafico
	 *            the activarGrafico to set
	 */
	public void setActivarGrafico(boolean activarGrafico) {
		this.activarGrafico = activarGrafico;
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

}
