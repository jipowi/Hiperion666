/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import ec.com.avila.emision.web.beans.PolizaBean;
import ec.com.avila.emision.web.beans.RamoFidelidadBean;
import ec.com.avila.emision.web.validator.ValidatorCedula;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.AseguradoraDTO;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.TablaAmortizacionDTO;
import ec.com.avila.hiperion.emision.entities.Aseguradora;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.ClausulasAddFidelidad;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.CobertFidelidad;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoFidelidad;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.enumeration.RamoEnum;
import ec.com.avila.hiperion.servicio.AseguradoraService;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.RamoFidelidadService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.FechasUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Fidelidad. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class FidelidadBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<SelectItem> sectorItems;
	private List<SelectItem> modalidadItems;

	@ManagedProperty(value = "#{ramoFidelidadBean}")
	private RamoFidelidadBean fidelidadBean;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private ClienteService clienteService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;
	@EJB
	private RamoFidelidadService ramoFidelidadService;

	@ManagedProperty(value = "#{ramoFidelidadBean}")
	private RamoFidelidadBean ramoFidelidadBean;

	@ManagedProperty(value = "#{polizaBean}")
	private PolizaBean polizaBean;

	private Usuario usuario;
	Logger log = Logger.getLogger(FidelidadBacking.class);

	RamoFidelidad ramoFidelidad = new RamoFidelidad();

	private List<DetalleAnexo> anexos;

	private List<CobertFidelidad> coberturas;
	private List<CobertFidelidad> selectedCoberturas;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();
	private List<ClausulasAddFidelidad> clausulasAdicionales;
	private List<ClausulasAddFidelidad> selectedClausulasAdd;
	private List<SelectItem> aseguradorasItems;
	private List<ClausulaAdicionalDTO> clausulasAdicionalesDTO = new ArrayList<>();
	private static List<AseguradoraDTO> aseguradorasDTO = new ArrayList<AseguradoraDTO>();
	private List<TablaAmortizacionDTO> tablaAmortizacionList = new ArrayList<TablaAmortizacionDTO>();
	private List<SelectItem> contactosItems = new ArrayList<>();
	private List<SelectItem> formasPagoItems;
	private List<SelectItem> pagoFinanciadoItems;
	private List<SelectItem> bancoItems;
	private List<SelectItem> cuentaBancoItems;

	private Boolean activarFileModalidad;
	private Boolean activarDatosCliente = false;
	private Boolean activarDatosAseguradora = false;
	private Boolean activarPanelPagoContado = false;
	private Boolean activarPanelPagoFinanciado = false;
	private Boolean activarPanelPagoTarjetaCredito = false;
	private Boolean activarPanelPagoDebitoBancario = false;
	@EJB
	private AseguradoraService aseguradoraService;

	@PostConstruct
	public void inicializar() {
		try {

			usuario = usuarioBean.getSessionUser();

			Ramo ramo = ramoService.consultarRamoPorCodigo("FD");

			anexos = ramo.getDetalleAnexos();

			obtenerCoberturas();
			obtenerClausulasAdicionales();

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite buscar un cliente por madio del numero de identificacion. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 04/04/2016]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void buscarCliente() throws HiperionException {

		Cliente cliente = buscarCliente(ramoFidelidadBean.getIdentificacion());

		if (cliente != null) {
			activarDatosCliente = true;
			activarDatosAseguradora = true;
		}
	}

	/**
	 * 
	 * <b> Permite buscar un cliente por medio de la cedula de identidad. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 04/04/2016]
	 * </p>
	 * 
	 * @param identificacion
	 * @return
	 * @throws HiperionException
	 */
	public Cliente buscarCliente(String identificacion) throws HiperionException {
		try {
			Cliente cliente = new Cliente();

			if (!identificacion.equals("") && ValidatorCedula.getInstancia().validateCedula(identificacion)) {
				cliente = clienteService.consultarClienteByIdentificacion(identificacion);
				if (cliente == null) {
					MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.buscar"));
				} else {

					ramoFidelidadBean.setNombreCliente(cliente.getNombrePersona() + " " + cliente.getApellidoPaterno() + " "
							+ cliente.getApellidoMaterno());
				}
			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensage.error.identificacionNoValido"));
			}

			polizaBean.setCliente(cliente);
			return cliente;

		} catch (HiperionException e) {
			log.error("Error al momento de buscar clientes", e);
			throw new HiperionException(e);
		}
	}

	/**
	 * 
	 * <b> Permite buscar los contactos de la aseguradora seleccionada. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 04/04/2016]
	 * </p>
	 * 
	 */
	public void buscarContactoAseguradora() {

		buscarContactoAseguradora(ramoFidelidadBean.getAseguradora());
	}

	/**
	 * 
	 * <b> Permite buscar los contactos de una aseguradora. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 04/04/2016]
	 * </p>
	 * 
	 * @param aseguradora
	 * @return
	 */
	public List<SelectItem> buscarContactoAseguradora(String aseguradora) {

		try {

			List<Cliente> contactos = aseguradoraService.consultarClienteByAseguradora(aseguradora);

			if (contactos == null) {
				MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.war.contactosAseguradora"));
			} else {
				for (Cliente cliente : contactos) {
					SelectItem selectItem = new SelectItem(cliente.getIdCliente(), cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno()
							+ " " + cliente.getNombrePersona());
					contactosItems.add(selectItem);
				}
			}

		} catch (HiperionException e) {
			e.printStackTrace();
		}
		return contactosItems;

	}

	/**
	 * 
	 * <b> Franklin Pozo B </b>
	 * <p>
	 * [Author: Franklin Pozo , Date: 05/04/2016]
	 * </p>
	 * 
	 */
	public void addAseguradora() {

		try {
			Long idAseguradora = Long.parseLong(ramoFidelidadBean.getAseguradora());
			Aseguradora aseguradoraNew = aseguradoraService.consultarAseguradoraByCodigo(ramoFidelidadBean.getAseguradora());

			DetalleCatalogo detalleCatalogo = detalleCatalogoService.consultarDetalleByCatalogoAndDetalle(
					HiperionMensajes.getInstancia().getInteger("ec.gob.avila.hiperion.recursos.catalogoAseguradoras"),
					Integer.parseInt(idAseguradora.toString()));

			AseguradoraDTO aseguradoraDTO = new AseguradoraDTO(detalleCatalogo.getDescDetCatalogo(), aseguradoraNew.getDirecion(),
					aseguradoraNew.getEmailAseguradora(), aseguradoraNew.getRuc(), aseguradoraNew.getTelfConvencionalAseg(),
					ramoFidelidadBean.getContactoAseguradora());

			aseguradorasDTO.add(aseguradoraDTO);
			contactosItems.clear();

		} catch (HiperionException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * <b> ermite eliminar una elemento de la tabla de aseguradoras </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 05/04/2016]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Aseguradora Eliminada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		aseguradorasDTO.remove((AseguradoraDTO) event.getObject());
	}

	/**
	 * 
	 * <b> Permite activar los paneles segun la forma de pago que selecciono el usuario </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 05/04/2016]
	 * </p>
	 * 
	 */
	public void selectFormaDePago() {
		if (polizaBean.getIdFormaPago() == 1) {
			setActivarPanelPagoContado(true);
		} else if (polizaBean.getIdFormaPago() == 2) {
			setActivarPanelPagoFinanciado(true);
		} else if (polizaBean.getIdFormaPago() == 3) {
			setActivarPanelPagoTarjetaCredito(true);
		} else if (polizaBean.getIdFormaPago() == 4) {
			setActivarPanelPagoDebitoBancario(true);
		}
	}

	/**
	 * 
	 * <b> Permite calcular los valores de super de bancos y seguro campesino </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 05/04/2016]
	 * </p>
	 * 
	 */
	public void calcularValoresPago() {
		if (polizaBean.getPrimaNeta() != null) {
			Double valorSuperBan = redondear((polizaBean.getPrimaNeta() * 0.035), 2);
			Double seguroCampesino = redondear((polizaBean.getPrimaNeta() * 0.005), 2);
			Double emision = redondear((polizaBean.getPrimaNeta() * 0.005), 2);
			Double subtotal = redondear((valorSuperBan + seguroCampesino + emision + polizaBean.getPrimaNeta()), 2);
			Double iva = redondear((subtotal * 0.12), 2);
			Double total = redondear((subtotal + iva), 2);

			polizaBean.setSuperBanSeguros(BigDecimal.valueOf(valorSuperBan));
			polizaBean.setSeguroCampesino(seguroCampesino);
			polizaBean.setSubtotal(BigDecimal.valueOf(subtotal));
			polizaBean.setIva(BigDecimal.valueOf(iva));
			polizaBean.setTotal(BigDecimal.valueOf(total));
			obtenerDias();
		}
		selectFormaDePago();
	}

	/**
	 * 
	 * <b> Redondea los valores decimales </b>
	 * <p>
	 * [Author: Franklin Pozo , Date: 05/04/2016]
	 * </p>
	 * 
	 * @param numero
	 * @param decimales
	 * @return
	 */
	public double redondear(double numero, int decimales) {
		return Math.round(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
	}

	/**
	 * 
	 * <b> Permite obtener el numero de dias de cobertura. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 05/04/2016]
	 * </p>
	 * 
	 */
	public void obtenerDias() {
		long dias = FechasUtil.getInstancia().restarFechas(polizaBean.getVigenciaDesde(), polizaBean.getVigenciaHasta());

		polizaBean.setDiasCobertura(Integer.parseInt(Long.toString(dias)));

	}

	/**
	 * 
	 * <b> Permite generar una tabla de amortizacion con valores ingresados en la pantalla. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 05/04/2016]
	 * </p>
	 * 
	 */
	public void generarTablaAmortizacion() {

		tablaAmortizacionList = new ArrayList<>();

		Double total = polizaBean.getTotal().doubleValue();
		Double numDebitos = polizaBean.getNumeroDebitos().doubleValue();
		Double valorLetras = total / numDebitos;
		valorLetras = redondear(valorLetras, 2);
		polizaBean.setValorDebitos(new BigDecimal(valorLetras));

		int cont = 1;

		for (int i = 0; i < polizaBean.getNumeroDebitos(); i++) {

			TablaAmortizacionDTO tablaAmortizacionDTO = new TablaAmortizacionDTO();
			tablaAmortizacionDTO.setLetra("Letra " + cont);
			tablaAmortizacionDTO.setValor(valorLetras);
			tablaAmortizacionDTO.setNumeroLetra(cont);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(polizaBean.getFechaDebito());
			Date fechaCuota = FechasUtil.getInstancia().sumarMeses(polizaBean.getFechaDebito(), (i + 1));

			tablaAmortizacionDTO.setFechaVencimiento(fechaCuota);

			tablaAmortizacionList.add(tablaAmortizacionDTO);
			cont++;
		}

		polizaBean.setFinanciamientos(tablaAmortizacionList);
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla de amortizacion </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 05/04/2016]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditTable(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((TablaAmortizacionDTO) event.getObject()).getLetra());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite obtener las coberturas del ramo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 * @param anexos
	 */
	public void obtenerCoberturas() {

		coberturas = new ArrayList<CobertFidelidad>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertFidelidad cobertura = new CobertFidelidad();
					cobertura.setIdCobertFidelidad(anexo.getIdDetalleAnexo());
					cobertura.setCoberturaFidelidad(anexo.getNombreDetalleAnexo());

					coberturas.add(cobertura);
				}

			}
		}

	}

	/**
	 * 
	 * <b> Permite obtener las clausulas adicionales del ramo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerClausulasAdicionales() {
		clausulasAdicionales = new ArrayList<ClausulasAddFidelidad>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					ClausulasAddFidelidad clausula = new ClausulasAddFidelidad();
					clausula.setIdClausulaAdFidelidad(anexo.getIdDetalleAnexo());
					clausula.setClausulaFidelidad(anexo.getNombreDetalleAnexo());

					clausulasAdicionales.add(clausula);
				}

			}

		}

	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditCobertura(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((CoberturaDTO) event.getObject()).getCobertura());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditClausulasAdd(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ClausulaAdicionalDTO) event.getObject()).getClausula());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> permite setear las coberturas seleccionadas en el Bean. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/07/2015]
	 * </p>
	 * 
	 */
	public void setearCoberturas() {
		if (selectedCoberturas.isEmpty()) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.coberturas"));
		} else {
			ramoFidelidad.setCobertFidelidads(selectedCoberturas);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.coberturas"));
		}
	}

	/**
	 * 
	 * <b> permite setear las clausualas adicionales seleccionadas. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/07/2015]
	 * </p>
	 * 
	 */
	public void setearClausulasAdd() {

		if (selectedClausulasAdd.isEmpty()) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.clausulasAdd"));
		} else {
			ramoFidelidad.setClausulasAddFidelidads(selectedClausulasAdd);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.clausulasAdd"));
		}

	}

	/**
	 * 
	 * <b> Permite guardar datos en el Ramo Fidelidad en la base datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/08/2014]
	 * </p>
	 * 
	 */
	public void guardarRamo() throws HiperionException {

		try {

			Poliza poliza = setearDatosPoliza();

			ramoFidelidad.setValorColusorio(ramoFidelidadBean.getValorColusorio());
			ramoFidelidad.setValorIndividual(ramoFidelidadBean.getValorIndividual());
			ramoFidelidad.setDeducMinimoFidelidad(ramoFidelidadBean.getMinimoSiniestro());
			ramoFidelidad.setDeducSiniestroFidelidad(ramoFidelidadBean.getPorcentajeValorSiniestro());
			ramoFidelidad.setSectorFidelidad(ramoFidelidadBean.getSector());

			ramoFidelidad.setIdUsuarioCreacion(usuario.getIdUsuario());
			ramoFidelidad.setFechaCreacion(new Date());
			ramoFidelidad.setEstado(EstadoEnum.A);

			ramoFidelidadService.guardarRamoFidelidad(ramoFidelidad, poliza);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo accidentes personales", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new HiperionException(e);
		}
	}

	/**
	 * 
	 * <b> Permite setear los datos de la poliza. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 09/07/2015]
	 * </p>
	 * 
	 * @return
	 */
	public Poliza setearDatosPoliza() {

		Poliza poliza = new Poliza();
		if (polizaBean.getEstadoPoliza().equals("EMITIDO")) {
			poliza.setNumeroPoliza(polizaBean.getNumeroPoliza());
			poliza.setNumeroAnexo(polizaBean.getNumeroAnexo());
			poliza.setEjecutivo(polizaBean.getEjecutivo().getNombreUsuario());
			poliza.setVigenciaDesde(polizaBean.getVigenciaDesde());
			poliza.setVigenciaHasta(polizaBean.getVigenciaHasta());
			poliza.setDiasCobertura(polizaBean.getDiasCobertura());
			poliza.setSumaAsegurada(polizaBean.getSumaAsegurada());
			poliza.setPrimaNeta(BigDecimal.valueOf(polizaBean.getPrimaNeta()));
			poliza.setSuperBanSeguros(polizaBean.getSuperBanSeguros());
			poliza.setSeguroCampesino(BigDecimal.valueOf(polizaBean.getSeguroCampesino()));
			poliza.setDerechoEmision(BigDecimal.valueOf(polizaBean.getDerechoEmision()));
			poliza.setEstadoPoliza("COTIZADO");

			PagoPoliza pagoPoliza = new PagoPoliza();
			pagoPoliza.setNumeroFactura(polizaBean.getNumeroFactura());
			pagoPoliza.setSubtotal(polizaBean.getSubtotal());
			pagoPoliza.setAdicionalSegCampesino(polizaBean.getAdicionalSegCampesino());
			pagoPoliza.setIva(polizaBean.getIva());
			pagoPoliza.setCuotaInicial(polizaBean.getCuotaInicial());
			pagoPoliza.setValorTotalPagoPoliza(polizaBean.getTotal());
			pagoPoliza.setEstado(EstadoEnum.A);
			pagoPoliza.setFechaCreacion(new Date());
			pagoPoliza.setIdUsuarioCreacion(usuario.getIdUsuario());

			List<Financiamiento> financiamientos = new ArrayList<>();
			for (TablaAmortizacionDTO financiamiento : polizaBean.getFinanciamientos()) {
				Financiamiento financiamientoTemp = new Financiamiento();
				financiamientoTemp.setNumeroCuota(financiamiento.getNumeroLetra());
				financiamientoTemp.setValorLetra(BigDecimal.valueOf(financiamiento.getValor()));
				financiamientoTemp.setFechaVencimiento(financiamiento.getFechaVencimiento());

				financiamientos.add(financiamientoTemp);
			}

			pagoPoliza.setFinanciamientos(financiamientos);

			poliza.setPagoPoliza(pagoPoliza);

		}
		poliza.setEstadoPoliza(polizaBean.getEstadoPoliza());
		poliza.setCliente(polizaBean.getCliente());
		poliza.setFechaRegistro(new Date());
		poliza.setRamo(RamoEnum.R12.getLabel());
		poliza.setEjecutivo(usuario.getIdentificacionUsuario());
		return poliza;
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
	 * @return the ramoFidelidadBean
	 */
	public RamoFidelidadBean getRamoFidelidadBean() {
		return ramoFidelidadBean;
	}

	/**
	 * @param ramoFidelidadBean
	 *            the ramoFidelidadBean to set
	 */
	public void setRamoFidelidadBean(RamoFidelidadBean ramoFidelidadBean) {
		this.ramoFidelidadBean = ramoFidelidadBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * 
	 * <b> Permite consultar los sectores que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 30, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getSectorItems() throws HiperionException {

		this.sectorItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoSector"));
		List<DetalleCatalogo> sectores = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : sectores) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			sectorItems.add(selectItem);
		}

		return sectorItems;
	}

	/**
	 * 
	 * <b> permite consultar los tipos de modalidades del ramo fidelidad </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: May 18, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getModalidadItems() throws HiperionException {
		this.modalidadItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoModalidadFidelidad"));
		List<DetalleCatalogo> modalidades = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : modalidades) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			modalidadItems.add(selectItem);
		}

		return modalidadItems;
	}

	/**
	 * 
	 * <b> Permite obtener el tipo de modalidad seleccionada </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: May 18, 2014]
	 * </p>
	 * 
	 */
	public void selectModalidad() {
		if (fidelidadBean.getIdModalidad() == 1)
			setActivarFileModalidad(false);
		else
			setActivarFileModalidad(true);
	}

	/**
	 * @param sectorItems
	 *            the sectorItems to set
	 */
	public void setSectorItems(List<SelectItem> sectorItems) {
		this.sectorItems = sectorItems;
	}

	/**
	 * @return the activarFileModalidad
	 */
	public Boolean getActivarFileModalidad() {
		return activarFileModalidad;
	}

	/**
	 * @param activarFileModalidad
	 *            the activarFileModalidad to set
	 */
	public void setActivarFileModalidad(Boolean activarFileModalidad) {
		this.activarFileModalidad = activarFileModalidad;
	}

	/**
	 * @return the fidelidadBean
	 */
	public RamoFidelidadBean getFidelidadBean() {
		return fidelidadBean;
	}

	/**
	 * @param fidelidadBean
	 *            the fidelidadBean to set
	 */
	public void setFidelidadBean(RamoFidelidadBean fidelidadBean) {
		this.fidelidadBean = fidelidadBean;
	}

	/**
	 * 
	 * <b> Permite generar y descargar informacion Ramo Fidelidad PDF. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 04/05/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarFidelidadPDF() throws HiperionException {

		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarAchivoPDFFidelidad(ramoFidelidad));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();

		} catch (Exception e) {
			log.error("Error al momento generar el a hoja de vida en PDF", e);
			throw new HiperionException(e);
		}

	}

	/**
	 * @return the coberturasDTO
	 */
	public List<CoberturaDTO> getCoberturasDTO() {
		return coberturasDTO;
	}

	/**
	 * @param coberturasDTO
	 *            the coberturasDTO to set
	 */
	public void setCoberturasDTO(List<CoberturaDTO> coberturasDTO) {
		this.coberturasDTO = coberturasDTO;
	}

	/**
	 * @return the clausulasAdicionalesDTO
	 */
	public List<ClausulaAdicionalDTO> getClausulasAdicionalesDTO() {
		return clausulasAdicionalesDTO;
	}

	/**
	 * @param clausulasAdicionalesDTO
	 *            the clausulasAdicionalesDTO to set
	 */
	public void setClausulasAdicionalesDTO(List<ClausulaAdicionalDTO> clausulasAdicionalesDTO) {
		this.clausulasAdicionalesDTO = clausulasAdicionalesDTO;
	}

	/**
	 * @return the polizaBean
	 */
	public PolizaBean getPolizaBean() {
		return polizaBean;
	}

	/**
	 * @param polizaBean
	 *            the polizaBean to set
	 */
	public void setPolizaBean(PolizaBean polizaBean) {
		this.polizaBean = polizaBean;
	}

	/**
	 * @return the activarDatosCliente
	 */
	public Boolean getActivarDatosCliente() {
		return activarDatosCliente;
	}

	/**
	 * @param activarDatosCliente
	 *            the activarDatosCliente to set
	 */
	public void setActivarDatosCliente(Boolean activarDatosCliente) {
		this.activarDatosCliente = activarDatosCliente;
	}

	/**
	 * @return the activarDatosAseguradora
	 */
	public Boolean getActivarDatosAseguradora() {
		return activarDatosAseguradora;
	}

	/**
	 * @param activarDatosAseguradora
	 *            the activarDatosAseguradora to set
	 */
	public void setActivarDatosAseguradora(Boolean activarDatosAseguradora) {
		this.activarDatosAseguradora = activarDatosAseguradora;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the aseguradorasItems
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
	 * @return the contactosItems
	 */
	public List<SelectItem> getContactosItems() {
		return contactosItems;
	}

	/**
	 * @param contactosItems
	 *            the contactosItems to set
	 */
	public void setContactosItems(List<SelectItem> contactosItems) {
		this.contactosItems = contactosItems;
	}

	/**
	 * @return the aseguradorasDTO
	 */
	public List<AseguradoraDTO> getAseguradorasDTO() {
		return aseguradorasDTO;
	}

	/**
	 * @param aseguradorasDTO
	 *            the aseguradorasDTO to set
	 */
	public static void setAseguradorasDTO(List<AseguradoraDTO> aseguradorasDTO) {
		FidelidadBacking.aseguradorasDTO = aseguradorasDTO;
	}

	/**
	 * @return the formasPagoItems
	 */
	public List<SelectItem> getFormasPagoItems() throws HiperionException {
		this.formasPagoItems = new ArrayList<SelectItem>();
		// Busqueda por el Codigo de Formas de Pago (4)
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoFormasPago"));
		List<DetalleCatalogo> formasPago = catalogo.getDetalleCatalogos();
		for (DetalleCatalogo detalle : formasPago) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			formasPagoItems.add(selectItem);
		}

		return formasPagoItems;

	}

	/**
	 * @param formasPagoItems
	 *            the formasPagoItems to set
	 */
	public void setFormasPagoItems(List<SelectItem> formasPagoItems) {
		this.formasPagoItems = formasPagoItems;
	}

	/**
	 * @return the activarPanelPagoContado
	 */
	public Boolean getActivarPanelPagoContado() {
		return activarPanelPagoContado;
	}

	/**
	 * @param activarPanelPagoContado
	 *            the activarPanelPagoContado to set
	 */
	public void setActivarPanelPagoContado(Boolean activarPanelPagoContado) {
		this.activarPanelPagoContado = activarPanelPagoContado;
	}

	/**
	 * @return the activarPanelPagoFinanciado
	 */
	public Boolean getActivarPanelPagoFinanciado() {
		return activarPanelPagoFinanciado;
	}

	/**
	 * @param activarPanelPagoFinanciado
	 *            the activarPanelPagoFinanciado to set
	 */
	public void setActivarPanelPagoFinanciado(Boolean activarPanelPagoFinanciado) {
		this.activarPanelPagoFinanciado = activarPanelPagoFinanciado;
	}

	/**
	 * @return the activarPanelPagoTarjetaCredito
	 */
	public Boolean getActivarPanelPagoTarjetaCredito() {
		return activarPanelPagoTarjetaCredito;
	}

	/**
	 * @param activarPanelPagoTarjetaCredito
	 *            the activarPanelPagoTarjetaCredito to set
	 */
	public void setActivarPanelPagoTarjetaCredito(Boolean activarPanelPagoTarjetaCredito) {
		this.activarPanelPagoTarjetaCredito = activarPanelPagoTarjetaCredito;
	}

	/**
	 * @return the activarPanelPagoDebitoBancario
	 */
	public Boolean getActivarPanelPagoDebitoBancario() {
		return activarPanelPagoDebitoBancario;
	}

	/**
	 * @param activarPanelPagoDebitoBancario
	 *            the activarPanelPagoDebitoBancario to set
	 */
	public void setActivarPanelPagoDebitoBancario(Boolean activarPanelPagoDebitoBancario) {
		this.activarPanelPagoDebitoBancario = activarPanelPagoDebitoBancario;
	}

	/**
	 * @return the pagoFinanciadoItems
	 */
	public List<SelectItem> getPagoFinanciadoItems() throws HiperionException {
		this.pagoFinanciadoItems = new ArrayList<SelectItem>();

		for (int i = 1; i <= 12; i++) {

			SelectItem pago = new SelectItem();
			pago = new SelectItem(i, "" + i);
			pagoFinanciadoItems.add(pago);

		}

		return pagoFinanciadoItems;
	}

	/**
	 * @param pagoFinanciadoItems
	 *            the pagoFinanciadoItems to set
	 */
	public void setPagoFinanciadoItems(List<SelectItem> pagoFinanciadoItems) {
		this.pagoFinanciadoItems = pagoFinanciadoItems;
	}

	/**
	 * @return the bancoItems
	 */
	public List<SelectItem> getBancoItems() throws HiperionException {
		this.bancoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoBancos"));
		List<DetalleCatalogo> banco = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : banco) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			bancoItems.add(selectItem);
		}
		return bancoItems;
	}

	/**
	 * @param bancoItems
	 *            the bancoItems to set
	 */
	public void setBancoItems(List<SelectItem> bancoItems) {
		this.bancoItems = bancoItems;
	}

	/**
	 * @return the cuentaBancoItems
	 */
	public List<SelectItem> getCuentaBancoItems() throws HiperionException {
		this.cuentaBancoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoCuentaBanco"));
		List<DetalleCatalogo> cuentaBanco = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : cuentaBanco) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			cuentaBancoItems.add(selectItem);
		}
		return cuentaBancoItems;
	}

	/**
	 * @param cuentaBancoItems
	 *            the cuentaBancoItems to set
	 */
	public void setCuentaBancoItems(List<SelectItem> cuentaBancoItems) {
		this.cuentaBancoItems = cuentaBancoItems;
	}

	/**
	 * @return the tablaAmortizacionList
	 */
	public List<TablaAmortizacionDTO> getTablaAmortizacionList() {
		return tablaAmortizacionList;
	}

	/**
	 * @param tablaAmortizacionList
	 *            the tablaAmortizacionList to set
	 */
	public void setTablaAmortizacionList(List<TablaAmortizacionDTO> tablaAmortizacionList) {
		this.tablaAmortizacionList = tablaAmortizacionList;
	}

	/**
	 * @return the coberturas
	 */
	public List<CobertFidelidad> getCoberturas() {
		return coberturas;
	}

	/**
	 * @param coberturas
	 *            the coberturas to set
	 */
	public void setCoberturas(List<CobertFidelidad> coberturas) {
		this.coberturas = coberturas;
	}

	/**
	 * @return the selectedCoberturas
	 */
	public List<CobertFidelidad> getSelectedCoberturas() {
		return selectedCoberturas;
	}

	/**
	 * @param selectedCoberturas
	 *            the selectedCoberturas to set
	 */
	public void setSelectedCoberturas(List<CobertFidelidad> selectedCoberturas) {
		this.selectedCoberturas = selectedCoberturas;
	}

	/**
	 * @return the clausulasAdicionales
	 */
	public List<ClausulasAddFidelidad> getClausulasAdicionales() {
		return clausulasAdicionales;
	}

	/**
	 * @param clausulasAdicionales
	 *            the clausulasAdicionales to set
	 */
	public void setClausulasAdicionales(List<ClausulasAddFidelidad> clausulasAdicionales) {
		this.clausulasAdicionales = clausulasAdicionales;
	}

	/**
	 * @return the selectedClausulasAdd
	 */
	public List<ClausulasAddFidelidad> getSelectedClausulasAdd() {
		return selectedClausulasAdd;
	}

	/**
	 * @param selectedClausulasAdd
	 *            the selectedClausulasAdd to set
	 */
	public void setSelectedClausulasAdd(List<ClausulasAddFidelidad> selectedClausulasAdd) {
		this.selectedClausulasAdd = selectedClausulasAdd;
	}

}