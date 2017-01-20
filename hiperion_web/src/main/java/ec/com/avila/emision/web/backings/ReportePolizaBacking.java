package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.PolizaService;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

@ManagedBean
@ViewScoped
public class ReportePolizaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ClienteService clienteService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	@EJB
	private PolizaService polizaService;

	private List<Poliza> polizas;

	private Date fechaDesde;
	private Date fechaHasta;
	private String estado;
	private int numEmitidas = 0;
	private int numCotizadas = 0;
	private int numRechazadas = 0;
	private boolean activarGrafico = false;

	private CartesianChartModel ChartPolizas;

	Logger log = Logger.getLogger(ReportePolizaBacking.class);

	@PostConstruct
	public void init() {
		createPiePolizas();
	}

	/**
	 * 
	 * <b> Permite presentar el reporte con los parametros ingresados. </b>
	 * <p>
	 * [Author: HIPERION, Date: 24/02/2016]
	 * </p>
	 * 
	 */
	public void generarReporte() {

		polizas = polizaService.obtenerReporteFechas(fechaDesde, fechaHasta);
		if (polizas == null) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.buscar"));
		} else {

			for (Poliza poliza : polizas) {
				if (poliza.getEstadoPoliza().equals("COTIZADO")) {
					numCotizadas++;
				} else if (poliza.getEstadoPoliza().equals("EMITIDO")) {
					numEmitidas++;
				}
			}
		}
		activarGrafico = true;
		createPiePolizas();
	}

	/**
	 * 
	 * <b> Permite generar el grafico del total de polizas. </b>
	 * <p>
	 * [Author: HIPERION, Date: 15/03/2016]
	 * </p>
	 * 
	 */
	private void createPiePolizas() {

		ChartPolizas = new CartesianChartModel();

		final ChartSeries polizas = new ChartSeries("Estado");
		polizas.set("Cotizadas", numEmitidas);
		polizas.set("Emitidas", numCotizadas);
		polizas.set("Aprobadas", 7);
		polizas.set("Rechazadas", 5);

		ChartPolizas.addSeries(polizas);

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
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the numEmitidas
	 */
	public int getNumEmitidas() {
		return numEmitidas;
	}

	/**
	 * @param numEmitidas
	 *            the numEmitidas to set
	 */
	public void setNumEmitidas(int numEmitidas) {
		this.numEmitidas = numEmitidas;
	}

	/**
	 * @return the numCotizadas
	 */
	public int getNumCotizadas() {
		return numCotizadas;
	}

	/**
	 * @param numCotizadas
	 *            the numCotizadas to set
	 */
	public void setNumCotizadas(int numCotizadas) {
		this.numCotizadas = numCotizadas;
	}

	/**
	 * @return the numRechazadas
	 */
	public int getNumRechazadas() {
		return numRechazadas;
	}

	/**
	 * @param numRechazadas
	 *            the numRechazadas to set
	 */
	public void setNumRechazadas(int numRechazadas) {
		this.numRechazadas = numRechazadas;
	}

	/**
	 * @return the chartPolizas
	 */
	public CartesianChartModel getChartPolizas() {
		return ChartPolizas;
	}

	/**
	 * @param chartPolizas
	 *            the chartPolizas to set
	 */
	public void setChartPolizas(CartesianChartModel chartPolizas) {
		ChartPolizas = chartPolizas;
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

}
