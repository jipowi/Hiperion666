package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import ec.com.avila.emision.web.beans.RamoAccidentesPersonalesBean;
import ec.com.avila.emision.web.validator.ValidatorCedula;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.AseguradoraDTO;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.CondicionEspecialDTO;
import ec.com.avila.hiperion.dto.GrupoAccPersonalesDTO;
import ec.com.avila.hiperion.dto.TablaAmortizacionDTO;
import ec.com.avila.hiperion.emision.entities.Aseguradora;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.ClausulasAddAccPer;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.CobertAccPer;
import ec.com.avila.hiperion.emision.entities.CondEspAccPer;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.GrupoAccPersonale;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.enumeration.RamoEnum;
import ec.com.avila.hiperion.servicio.AseguradoraService;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.PolizaService;
import ec.com.avila.hiperion.servicio.RamoAccidentesPersonalesService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.FechasUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Backing que permite gestionar la informacion que se maneje en las paginas web que utilicen el Ramo ACCIDENTES PERSONALES. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class AccidentesPersonalesBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private RamoService ramoService;

	@EJB
	private ClienteService clienteService;
	@EJB
	private RamoAccidentesPersonalesService ramoAccidentesPersonalesService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private AseguradoraService aseguradoraService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@ManagedProperty(value = "#{polizaBean}")
	private PolizaBean polizaBean;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{ramoAccidentesPersonalesBean}")
	private RamoAccidentesPersonalesBean ramoAccidentesPersonalesBean;

	@EJB
	private PolizaService polizaService;

	private List<DetalleAnexo> anexos;
	private List<ClausulasAddAccPer> clausulasAdicionales;
	private List<ClausulasAddAccPer> selectedClausulasAdd;
	private List<CobertAccPer> coberturas;
	private List<CobertAccPer> selectedCoberturas;
	private List<CondEspAccPer> condicionesEspeciales;
	private List<CondEspAccPer> selectedCondicionesEsp;
	private List<SelectItem> sexoItems;
	private List<SelectItem> parentescoItems;
	private List<SelectItem> contactosItems = new ArrayList<>();
	private List<SelectItem> pagoFinanciadoItems;
	private List<SelectItem> aseguradorasItems;
	private List<SelectItem> formasPagoItems;
	private List<SelectItem> tarjetasCreditoItems;
	private List<SelectItem> bancoItems;
	private List<SelectItem> cuentaBancoItems;
	private List<TablaAmortizacionDTO> tablaAmortizacionList = new ArrayList<TablaAmortizacionDTO>();

	private Boolean activarDatosCliente = false;
	private Boolean activarDatosAseguradora = false;
	private Boolean activarCotizar = true;
	private Boolean activarPresentar = false;
	private Boolean activarAceptar = false;
	private Boolean activarEmitir = false;
	private Boolean activarEntregar = false;
	private Boolean activarDocumentar = false;
	private Boolean polizaActiva = false;
	private static List<AseguradoraDTO> aseguradorasDTO = new ArrayList<AseguradoraDTO>();
	private static List<GrupoAccPersonalesDTO> gruposDTO = new ArrayList<GrupoAccPersonalesDTO>();

	// Tabla Grupos
	private Integer numGrupo;
	private String nomGrupo;
	private Integer numPersonas;
	private String actividad;
	private Double valorGrupo;

	private Usuario usuario;

	RamoAccidentesPersonale accidentesPersonales = new RamoAccidentesPersonale();

	Logger log = Logger.getLogger(AccidentesPersonalesBacking.class);

	@PostConstruct
	public void init() {
		try {
			usuario = usuarioBean.getSessionUser();

			Ramo ramo = ramoService.consultarRamoPorCodigo("AP");
			anexos = ramo.getDetalleAnexos();

			obtenerCoberturas();
			obtenerClausulasAdicionales();
			obtenerCondicionesEspeciales();

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite buscar un cliente por madio del numero de identificacion. </b>
	 * <p>
	 * [Author: HIPERION, Date: 08/02/2016]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void buscarCliente() throws HiperionException {

		Cliente cliente = buscarCliente(ramoAccidentesPersonalesBean.getIdentificacion());

		if (cliente != null) {
			activarDatosCliente = true;
			activarDatosAseguradora = true;
		}
	}

	/**
	 * 
	 * <b> Permite buscar un cliente por medio de la cedula de identidad. </b>
	 * <p>
	 * [Author: HIPERION, Date: 08/02/2016]
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
					List<Poliza> polizas = polizaService.consultarPolizasByCliente(cliente.getIdCliente());

					if (polizas != null) {
						for (Poliza poliza : polizas) {
							if (poliza.getRamo().equals("ACCIDENTES PERSONALES")) {
								polizaActiva = true;
								accidentesPersonales = ramoService.consultarRamo(poliza.getIdPoliza());
								editarRamo();
							} else {
								polizaBean.setEstadoPoliza("COTIZADO");
							}
						}
					}
					ramoAccidentesPersonalesBean.setNombreCliente(cliente.getNombrePersona() + " " + cliente.getApellidoPaterno() + " "
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
	 * <b> Permite obtner la informacion del ramo que fue registrado en la BD. </b>
	 * <p>
	 * [Author: kruger, Date: 18/05/2017]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void editarRamo() throws HiperionException {
		ramoAccidentesPersonalesBean.setPrimaNetaPersona(accidentesPersonales.getPrimaNetaPersona());
		ramoAccidentesPersonalesBean.setPrimaTotalPersona(accidentesPersonales.getPrimaTotalPersona());
		ramoAccidentesPersonalesBean.setFacturacion(accidentesPersonales.getFacturacion());

		List<GrupoAccPersonale> gruposDB = ramoAccidentesPersonalesService.cosultarGruposByRamo(accidentesPersonales.getIdAccidentes());
		for (GrupoAccPersonale grupo : gruposDB) {
			GrupoAccPersonalesDTO grupoDTO = new GrupoAccPersonalesDTO();
			grupoDTO.setActividad(grupo.getActividadAcc());
			grupoDTO.setNomGrupo(grupo.getNombreGrupoAcc());
			grupoDTO.setNumGrupo(grupo.getNumeroPersonasAcc());
			grupoDTO.setValorGrupo(grupo.getValorGrupoAcc());
			gruposDTO.add(grupoDTO);
		}
		
		selectedCoberturas = ramoAccidentesPersonalesService.consultarCoberturasByRamo(accidentesPersonales.getIdAccidentes());
		 
		selectedCondicionesEsp = ramoAccidentesPersonalesService.consultarCondicionesByRamo(accidentesPersonales.getIdAccidentes());
		selectedClausulasAdd = ramoAccidentesPersonalesService.consultarClausulasByRamo(accidentesPersonales.getIdAccidentes());		
	}

	/**
	 * 
	 * <b> Permite buscar los contactos de la aseguradora seleccionada. </b>
	 * <p>
	 * [Author: HIPERION, Date: 08/02/2016]
	 * </p>
	 * 
	 */
	public void buscarContactoAseguradora() {

		buscarContactoAseguradora(ramoAccidentesPersonalesBean.getAseguradora());
	}

	/**
	 * 
	 * <b> Permite buscar los contactos de una aseguradora. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/07/2015]
	 * </p>
	 * 
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
	 * <b> Permite agresar una nueva aseguradora a la tabla. </b>
	 * <p>
	 * [Author: HIPERION, Date: 29/02/2016]
	 * </p>
	 * 
	 */
	public void addAseguradora() {

		try {
			Long idAseguradora = Long.parseLong(ramoAccidentesPersonalesBean.getAseguradora());
			Aseguradora aseguradoraNew = aseguradoraService.consultarAseguradoraByCodigo(ramoAccidentesPersonalesBean.getAseguradora());

			DetalleCatalogo detalleCatalogo = detalleCatalogoService.consultarDetalleByCatalogoAndDetalle(
					HiperionMensajes.getInstancia().getInteger("ec.gob.avila.hiperion.recursos.catalogoAseguradoras"),
					Integer.parseInt(idAseguradora.toString()));

			AseguradoraDTO aseguradoraDTO = new AseguradoraDTO(detalleCatalogo.getDescDetCatalogo(), aseguradoraNew.getDirecion(),
					aseguradoraNew.getEmailAseguradora(), aseguradoraNew.getRuc(), aseguradoraNew.getTelfConvencionalAseg(),
					ramoAccidentesPersonalesBean.getContactoAseguradora());

			aseguradorasDTO.add(aseguradoraDTO);
			contactosItems.clear();

		} catch (HiperionException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * <b> Permite eliminar una elemento de la tabla de aseguradoras. </b>
	 * <p>
	 * [Author: HIPERION, Date: 29/02/2016]
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
	 * <b> Permite generar una tabla de amortizacion con valores ingresados en la pantalla. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 15/01/2015]
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
	 * <b> Permite calcular los valores de super de bancos y seguro campesino </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 24/02/2016]
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

	}

	/**
	 * 
	 * <b> Permite obtener el numero de dias de cobertura. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 11/01/2016]
	 * </p>
	 * 
	 */
	public void obtenerDias() {
		long dias = FechasUtil.getInstancia().restarFechas(polizaBean.getVigenciaDesde(), polizaBean.getVigenciaHasta());

		polizaBean.setDiasCobertura(Integer.parseInt(Long.toString(dias)));

	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla de amortizacion </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditTable(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((TablaAmortizacionDTO) event.getObject()).getLetra());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public double redondear(double numero, int decimales) {
		return Math.round(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
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

		if (activarEmitir) {
			poliza.setNumeroPoliza(polizaBean.getNumeroPoliza());
			poliza.setNumeroAnexo(polizaBean.getNumeroAnexo());
			poliza.setVigenciaDesde(polizaBean.getVigenciaDesde());
			poliza.setVigenciaHasta(polizaBean.getVigenciaHasta());
			poliza.setDiasCobertura(polizaBean.getDiasCobertura());
			poliza.setSumaAsegurada(polizaBean.getSumaAsegurada());
			poliza.setPrimaNeta(BigDecimal.valueOf(polizaBean.getPrimaNeta()));
			poliza.setSuperBanSeguros(polizaBean.getSuperBanSeguros());
			poliza.setSeguroCampesino(BigDecimal.valueOf(polizaBean.getSeguroCampesino()));
			poliza.setDerechoEmision(BigDecimal.valueOf(polizaBean.getDerechoEmision()));

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
		poliza.setRamo(RamoEnum.R1.getLabel());
		poliza.setEjecutivo(usuario.getIdentificacionUsuario());

		return poliza;
	}

	/**
	 * 
	 * <b> Permite obtener las Condiciones Especiales del Anexo de un Ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public void obtenerCondicionesEspeciales() {

		condicionesEspeciales = new ArrayList<CondEspAccPer>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3) {
					CondEspAccPer condicion = new CondEspAccPer();

					condicion.setIdCondicionEspAcc(anexo.getIdDetalleAnexo());
					condicion.setCondicionAcc(anexo.getNombreDetalleAnexo());
					condicionesEspeciales.add(condicion);

				}

			}

		}

	}

	/**
	 * 
	 * <b> Permite obtener las Clausulas Adicionales del Anexo de una Ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/05/2014]
	 * </p>
	 * 
	 * @return
	 */
	public void obtenerClausulasAdicionales() {
		clausulasAdicionales = new ArrayList<ClausulasAddAccPer>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					ClausulasAddAccPer clausula = new ClausulasAddAccPer();
					clausula.setIdClausulaAdAcidente(anexo.getIdDetalleAnexo());
					clausula.setClausulaAccPersonales(anexo.getNombreDetalleAnexo());

					clausulasAdicionales.add(clausula);
				}

			}

		}

	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas del Anexo de un Ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public void obtenerCoberturas() {
		coberturas = new ArrayList<CobertAccPer>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertAccPer cobertura = new CobertAccPer();
					cobertura.setIdCobertura(anexo.getIdDetalleAnexo());
					cobertura.setCoberturaAccPersonales(anexo.getNombreDetalleAnexo());
					coberturas.add(cobertura);
				}

			}
		}

	}

	/**
	 * 
	 * <b> Permite guardar los datos del ramo y la poliza. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 10/07/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {

		try {
			if (polizaActiva) {
				MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("Usted tiene una Poliza Activa para este ramo"));
			} else {

				Poliza poliza = setearDatosPoliza();

				accidentesPersonales.setPrimaNetaPersona(ramoAccidentesPersonalesBean.getPrimaNetaPersona());
				accidentesPersonales.setPrimaTotalPersona(ramoAccidentesPersonalesBean.getPrimaTotalPersona());
				accidentesPersonales.setFacturacion(ramoAccidentesPersonalesBean.getFacturacion());
				accidentesPersonales.setIdUsuarioCreacion(usuario.getIdUsuario());
				accidentesPersonales.setFechaCreacion(new Date());
				accidentesPersonales.setEstado(EstadoEnum.A);

				// Informacion Grupos
				List<GrupoAccPersonale> grupos = new ArrayList<>();
				for (GrupoAccPersonalesDTO grupo : gruposDTO) {
					GrupoAccPersonale grupoDB = new GrupoAccPersonale();

					grupoDB.setNombreGrupoAcc(grupo.getNomGrupo());
					grupoDB.setNumeroPersonasAcc(grupo.getNumPersonas());
					grupoDB.setActividadAcc(grupo.getActividad());
					grupoDB.setDeducGrupoAcc(new BigDecimal(grupo.getValorGrupo()));
					grupoDB.setIdUsuarioCreacion(usuario.getIdUsuario());
					grupoDB.setFechaCreacion(new Date());
					grupoDB.setEstado(EstadoEnum.A);

					grupos.add(grupoDB);
				}

				ramoAccidentesPersonalesService.guardarRamoAccidentesPersonales(accidentesPersonales, poliza, grupos, selectedCoberturas,
						selectedCondicionesEsp, selectedClausulasAdd);

				MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
			}

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo accidentes personales", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new HiperionException(e);
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
	 * <b> Permite editar un registro de la tabla</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditCondicionesEsp(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((CondicionEspecialDTO) event.getObject()).getCondicionEspecial());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * @return the ramoBean
	 */
	public RamoBean getRamoBean() {
		return ramoBean;
	}

	/**
	 * @param ramoBean
	 *            the ramoBean to set
	 */
	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * @return the ramoAccidentesPersonalesBean
	 */
	public RamoAccidentesPersonalesBean getRamoAccidentesPersonalesBean() {
		return ramoAccidentesPersonalesBean;
	}

	/**
	 * @param ramoAccidentesPersonalesBean
	 *            the ramoAccidentesPersonalesBean to set
	 */
	public void setRamoAccidentesPersonalesBean(RamoAccidentesPersonalesBean ramoAccidentesPersonalesBean) {
		this.ramoAccidentesPersonalesBean = ramoAccidentesPersonalesBean;
	}

	/**
	 * @return the parentescoItems
	 * @throws HiperionException
	 */
	public List<SelectItem> getParentescoItems() throws HiperionException {

		this.parentescoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia()
				.getLong("ec.gob.avila.hiperion.recursos.parentesco"));
		List<DetalleCatalogo> parentesco = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : parentesco) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			parentescoItems.add(selectItem);
		}
		return parentescoItems;
	}

	/**
	 * @return the sexoItems
	 * @throws HiperionException
	 */
	public List<SelectItem> getSexoItems() throws HiperionException {
		this.sexoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoSexo"));
		List<DetalleCatalogo> sexos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : sexos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			sexoItems.add(selectItem);
		}

		return sexoItems;
	}

	/**
	 * @param parentescoItems
	 *            the parentescoItems to set
	 */
	public void setParentescoItems(List<SelectItem> parentescoItems) {
		this.parentescoItems = parentescoItems;
	}

	/**
	 * @param sexoItems
	 *            the sexoItems to set
	 */
	public void setSexoItems(List<SelectItem> sexoItems) {
		this.sexoItems = sexoItems;
	}

	/**
	 * @return the coberturas
	 */
	public List<CobertAccPer> getCoberturas() {
		return coberturas;
	}

	/**
	 * @param coberturas
	 *            the coberturas to set
	 */
	public void setCoberturas(List<CobertAccPer> coberturas) {
		this.coberturas = coberturas;
	}

	/**
	 * @return the condicionesEspeciales
	 */
	public List<CondEspAccPer> getCondicionesEspeciales() {
		return condicionesEspeciales;
	}

	/**
	 * @param condicionesEspeciales
	 *            the condicionesEspeciales to set
	 */
	public void setCondicionesEspeciales(List<CondEspAccPer> condicionesEspeciales) {
		this.condicionesEspeciales = condicionesEspeciales;
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
	 * @return the clausulasAdicionales
	 */
	public List<ClausulasAddAccPer> getClausulasAdicionales() {
		return clausulasAdicionales;
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
	 * @param clausulasAdicionales
	 *            the clausulasAdicionales to set
	 */
	public void setClausulasAdicionales(List<ClausulasAddAccPer> clausulasAdicionales) {
		this.clausulasAdicionales = clausulasAdicionales;
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
	 * 
	 * <b> Permite obtener una lista de formas de Pago. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Feb 2, 2014]
	 * </p>
	 * 
	 * @return - Lista de las Formas de Pago
	 * @throws HiperionException
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
	 * 
	 * <b> Permite obtener una lista de las Tarjetas de Credito. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Feb 2, 2014]
	 * </p>
	 * 
	 * @return - Lista de nombres de Tarjetas de Credito
	 * @throws HiperionException
	 */
	public List<SelectItem> getTarjetasCreditoItems() throws HiperionException {
		this.tarjetasCreditoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(new Long(7));
		List<DetalleCatalogo> formasPago = catalogo.getDetalleCatalogos();
		for (DetalleCatalogo detalle : formasPago) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tarjetasCreditoItems.add(selectItem);
		}

		return tarjetasCreditoItems;
	}

	/**
	 * 
	 * <b> metodo que crea el combo de bancos. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 14/01/2015]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
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
	 * 
	 * <b> Permite crear el combo de tipo de cuenta </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 14/01/2015]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
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
		AccidentesPersonalesBacking.aseguradorasDTO = aseguradorasDTO;
	}

	/**
	 * 
	 * <b> Permite agregar un registro de grupo a la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 05/01/2015]
	 * </p>
	 * 
	 * @return
	 */
	public void addGrupo() {
		GrupoAccPersonalesDTO grupo = new GrupoAccPersonalesDTO(this.numGrupo, this.nomGrupo, this.numPersonas, this.actividad, this.valorGrupo);
		gruposDTO.add(grupo);

		numGrupo = 0;
		nomGrupo = "";
		numPersonas = 0;
		actividad = "";
		valorGrupo = 0.0;
	}

	/**
	 * 
	 * <b> Permite editar un grupo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void editarGrupo(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((GrupoAccPersonalesDTO) event.getObject()).getNumGrupo().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite remover un objeto asegurado de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void eliminarGrupo(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		gruposDTO.remove((GrupoAccPersonalesDTO) event.getObject());
	}

	/**
	 * @return the gruposDTO
	 */
	public List<GrupoAccPersonalesDTO> getGruposDTO() {
		return gruposDTO;
	}

	/**
	 * @param gruposDTO
	 *            the gruposDTO to set
	 */
	public static void setGruposDTO(List<GrupoAccPersonalesDTO> gruposDTO) {
		AccidentesPersonalesBacking.gruposDTO = gruposDTO;
	}

	/**
	 * @return the numGrupo
	 */
	public Integer getNumGrupo() {
		return numGrupo;
	}

	/**
	 * @param numGrupo
	 *            the numGrupo to set
	 */
	public void setNumGrupo(Integer numGrupo) {
		this.numGrupo = numGrupo;
	}

	/**
	 * @return the nomGrupo
	 */
	public String getNomGrupo() {
		return nomGrupo;
	}

	/**
	 * @param nomGrupo
	 *            the nomGrupo to set
	 */
	public void setNomGrupo(String nomGrupo) {
		this.nomGrupo = nomGrupo;
	}

	/**
	 * @return the numPersonas
	 */
	public Integer getNumPersonas() {
		return numPersonas;
	}

	/**
	 * @param numPersonas
	 *            the numPersonas to set
	 */
	public void setNumPersonas(Integer numPersonas) {
		this.numPersonas = numPersonas;
	}

	/**
	 * @return the actividad
	 */
	public String getActividad() {
		return actividad;
	}

	/**
	 * @param actividad
	 *            the actividad to set
	 */
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	/**
	 * @return the valorGrupo
	 */
	public Double getValorGrupo() {
		return valorGrupo;
	}

	/**
	 * @param valorGrupo
	 *            the valorGrupo to set
	 */
	public void setValorGrupo(Double valorGrupo) {
		this.valorGrupo = valorGrupo;
	}

	/**
	 * @return the activarCotizar
	 */
	public Boolean getActivarCotizar() {
		return activarCotizar;
	}

	/**
	 * @param activarCotizar
	 *            the activarCotizar to set
	 */
	public void setActivarCotizar(Boolean activarCotizar) {
		this.activarCotizar = activarCotizar;
	}

	/**
	 * @return the activarPresentar
	 */
	public Boolean getActivarPresentar() {
		return activarPresentar;
	}

	/**
	 * @param activarPresentar
	 *            the activarPresentar to set
	 */
	public void setActivarPresentar(Boolean activarPresentar) {
		this.activarPresentar = activarPresentar;
	}

	/**
	 * @return the activarAceptar
	 */
	public Boolean getActivarAceptar() {
		return activarAceptar;
	}

	/**
	 * @param activarAceptar
	 *            the activarAceptar to set
	 */
	public void setActivarAceptar(Boolean activarAceptar) {
		this.activarAceptar = activarAceptar;
	}

	/**
	 * @return the activarEmitir
	 */
	public Boolean getActivarEmitir() {
		return activarEmitir;
	}

	/**
	 * @param activarEmitir
	 *            the activarEmitir to set
	 */
	public void setActivarEmitir(Boolean activarEmitir) {
		this.activarEmitir = activarEmitir;
	}

	/**
	 * @return the activarEntregar
	 */
	public Boolean getActivarEntregar() {
		return activarEntregar;
	}

	/**
	 * @param activarEntregar
	 *            the activarEntregar to set
	 */
	public void setActivarEntregar(Boolean activarEntregar) {
		this.activarEntregar = activarEntregar;
	}

	/**
	 * @return the activarDocumentar
	 */
	public Boolean getActivarDocumentar() {
		return activarDocumentar;
	}

	/**
	 * @param activarDocumentar
	 *            the activarDocumentar to set
	 */
	public void setActivarDocumentar(Boolean activarDocumentar) {
		this.activarDocumentar = activarDocumentar;
	}

	/**
	 * @return the selectedCoberturas
	 */
	public List<CobertAccPer> getSelectedCoberturas() {
		return selectedCoberturas;
	}

	/**
	 * @param selectedCoberturas
	 *            the selectedCoberturas to set
	 */
	public void setSelectedCoberturas(List<CobertAccPer> selectedCoberturas) {
		this.selectedCoberturas = selectedCoberturas;
	}

	/**
	 * @return the selectedCondicionesEsp
	 */
	public List<CondEspAccPer> getSelectedCondicionesEsp() {
		return selectedCondicionesEsp;
	}

	/**
	 * @param selectedCondicionesEsp
	 *            the selectedCondicionesEsp to set
	 */
	public void setSelectedCondicionesEsp(List<CondEspAccPer> selectedCondicionesEsp) {
		this.selectedCondicionesEsp = selectedCondicionesEsp;
	}

	/**
	 * @return the selectedClausulasAdd
	 */
	public List<ClausulasAddAccPer> getSelectedClausulasAdd() {
		return selectedClausulasAdd;
	}

	/**
	 * @param selectedClausulasAdd
	 *            the selectedClausulasAdd to set
	 */
	public void setSelectedClausulasAdd(List<ClausulasAddAccPer> selectedClausulasAdd) {
		this.selectedClausulasAdd = selectedClausulasAdd;
	}

}
