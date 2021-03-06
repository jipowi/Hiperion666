/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
import ec.com.avila.emision.web.beans.RamoAsistenciaMedicaBean;
import ec.com.avila.emision.web.validator.ValidatorCedula;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.AseguradoraDTO;
import ec.com.avila.hiperion.dto.LimitesCostosDTO;
import ec.com.avila.hiperion.dto.TablaAmortizacionDTO;
import ec.com.avila.hiperion.emision.entities.Aseguradora;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.LimitesCostosAsm;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoAsistenciaMedica;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.enumeration.RamoEnum;
import ec.com.avila.hiperion.servicio.AseguradoraService;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.RamoAstMedicaService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.FechasUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b> Clase que sirve de soporte para un objeto manejado dentro de la aplicacion, permite implementar los conportamientos especificos de la pagina
 * </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Feb 9, 2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class AsistenciaMedicaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private RamoService ramoService;

	@EJB
	private ClienteService clienteService;

	@EJB
	private RamoAstMedicaService ramoAstMedicaService;

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

	@ManagedProperty(value = "#{ramoAsistenciaMedicaBean}")
	private RamoAsistenciaMedicaBean ramoAsistenciaMedicaBean;

	private List<DetalleAnexo> anexos;

	private List<LimitesCostosAsm> limitesCostosBeneficios;
	private List<LimitesCostosAsm> selectedBeneficios;
	private List<LimitesCostosAsm> limitesCostosBenAdd;
	private List<LimitesCostosAsm> selectedBeneficiosAdd;
	private List<LimitesCostosAsm> limitesCostosMaternidad;
	private List<LimitesCostosAsm> selectedCostosMaternidad;

	private List<TablaAmortizacionDTO> tablaAmortizacionList = new ArrayList<TablaAmortizacionDTO>();
	private List<SelectItem> contactosItems = new ArrayList<>();
	private List<SelectItem> pagoFinanciadoItems;
	private List<SelectItem> aseguradorasItems;
	private List<SelectItem> formasPagoItems;
	private List<SelectItem> bancoItems;
	private List<SelectItem> cuentaBancoItems;

	private Boolean activarDatosCliente = false;
	private Boolean activarDatosAseguradora = false;
	private Boolean activarPanelPagoContado = false;
	private Boolean activarPanelPagoFinanciado = false;
	private Boolean activarPanelPagoTarjetaCredito = false;
	private Boolean activarPanelPagoDebitoBancario = false;

	private static List<AseguradoraDTO> aseguradorasDTO = new ArrayList<AseguradoraDTO>();

	private List<SelectItem> parentescoItems;

	RamoAsistenciaMedica asistenciaMedica = new RamoAsistenciaMedica();
	private Usuario usuario;

	Logger log = Logger.getLogger(AsistenciaMedicaBacking.class);

	@PostConstruct
	public void inicializar() {
		try {
			usuario = usuarioBean.getSessionUser();

			Ramo ramo = ramoService.consultarRamoPorCodigo("AM");
			anexos = ramo.getDetalleAnexos();

			obtenerLimitesCostosBeneficios();
			obtenerLimitesCostosBenAdd();
			obtenerLimitesCostosMaternidad();

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 08/03/2016]
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

					ramoAsistenciaMedicaBean.setNombreCliente(cliente.getNombrePersona() + " " + cliente.getApellidoPaterno() + " "
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
	 * <b> Permite buscar un cliente por madio del numero de identificacion. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 01/03/2016]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void buscarCliente() throws HiperionException {

		Cliente cliente = buscarCliente(ramoAsistenciaMedicaBean.getIdentificacion());

		if (cliente != null) {
			activarDatosCliente = true;
			activarDatosAseguradora = true;
		}

	}

	/**
	 * 
	 * <b> Permite obtener los Limites y Costos con titulo Beneficios del Ramo Asistencia Medica. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public void obtenerLimitesCostosBeneficios() throws HiperionException {
		limitesCostosBeneficios = new ArrayList<LimitesCostosAsm>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {

				Long idTitulo = ramoAstMedicaService.consultarIdTitulo(anexo.getIdDetalleAnexo());
				if (anexo.getAnexo().getIdAnexo() == 4 && idTitulo == 3) {
					LimitesCostosAsm limiteCosto = new LimitesCostosAsm();
					limiteCosto.setIdLimiteCostoAsm(anexo.getIdDetalleAnexo());
					limiteCosto.setTipoLimite(1);
					limiteCosto.setEstado(EstadoEnum.A);
					limiteCosto.setFechaCreacion(new Date());
					limiteCosto.setIdUsuarioCreacion(usuario.getIdUsuario());
					limiteCosto.setLimiteCosto(anexo.getNombreDetalleAnexo());

					limitesCostosBeneficios.add(limiteCosto);
				}
			}

		}

	}

	/**
	 * 
	 * <b> Permite obtener los Limites y Costos con titulo Beneficios Add del Ramo Asistencia Medica </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 16/06/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void obtenerLimitesCostosBenAdd() throws HiperionException {
		limitesCostosBenAdd = new ArrayList<LimitesCostosAsm>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {

				Long idTitulo = ramoAstMedicaService.consultarIdTitulo(anexo.getIdDetalleAnexo());
				if (anexo.getAnexo().getIdAnexo() == 4 && idTitulo == 4) {
					LimitesCostosAsm limiteCosto = new LimitesCostosAsm();
					limiteCosto.setIdLimiteCostoAsm(anexo.getIdDetalleAnexo());
					limiteCosto.setLimiteCosto(anexo.getNombreDetalleAnexo());
					limiteCosto.setTipoLimite(2);

					limiteCosto.setEstado(EstadoEnum.A);
					limiteCosto.setFechaCreacion(new Date());
					limiteCosto.setIdUsuarioCreacion(usuario.getIdUsuario());
					limitesCostosBenAdd.add(limiteCosto);
				}
			}
		}
	}

	/**
	 * 
	 * <b> Permite obtener los Limites y Costos con titulo de Materniadad del Ramo Asistencia Medica. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 16/06/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void obtenerLimitesCostosMaternidad() throws HiperionException {
		limitesCostosMaternidad = new ArrayList<LimitesCostosAsm>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {

				Long idTitulo = ramoAstMedicaService.consultarIdTitulo(anexo.getIdDetalleAnexo());
				if (anexo.getAnexo().getIdAnexo() == 4 && idTitulo == 5) {

					LimitesCostosAsm limiteCosto = new LimitesCostosAsm();
					limiteCosto.setIdLimiteCostoAsm(anexo.getIdDetalleAnexo());
					limiteCosto.setLimiteCosto(anexo.getNombreDetalleAnexo());
					limiteCosto.setTipoLimite(3);

					limiteCosto.setEstado(EstadoEnum.A);
					limiteCosto.setFechaCreacion(new Date());
					limiteCosto.setIdUsuarioCreacion(usuario.getIdUsuario());

					limitesCostosMaternidad.add(limiteCosto);
				}
			}
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
		poliza.setRamo(RamoEnum.R3.getLabel());
		poliza.setEjecutivo(usuario.getIdentificacionUsuario());

		return poliza;
	}

	/**
	 * 
	 * <b> Permite guardar los datos del ramo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 25/07/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardar() throws HiperionException {
		try {

			Poliza poliza = setearDatosPoliza();

			asistenciaMedica.setTotalMensualGrupoAsm(ramoAsistenciaMedicaBean.getTotalMensualGrupo());
			asistenciaMedica.setIdUsuarioCreacion(usuario.getIdUsuario());
			asistenciaMedica.setFechaCreacion(new Date());
			asistenciaMedica.setEstado(EstadoEnum.A);

			ramoAstMedicaService.guardarRamoAsistenciaMedica(asistenciaMedica, poliza);

			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo accidentes personales", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new HiperionException(e);
		}

	}

	/**
	 * 
	 * <b> Permite setear los beneficios. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 25/07/2015]
	 * </p>
	 * 
	 */
	public void setearBeneficios() {

		if (selectedBeneficios.isEmpty()) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.beneficios"));
		} else {
			for (LimitesCostosAsm limite : selectedBeneficios) {
				asistenciaMedica.getLimitesCostosAsms().add(limite);
			}
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.beneficios"));
		}

	}

	/**
	 * 
	 * <b> Permite setear los beneficios adicionales. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 25/07/2015]
	 * </p>
	 * 
	 */
	public void setearBeneficiosAdd() {

		if (selectedBeneficiosAdd.isEmpty()) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.beneficiosAdd"));
		} else {
			for (LimitesCostosAsm limite : selectedBeneficiosAdd) {
				asistenciaMedica.getLimitesCostosAsms().add(limite);
			}
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.beneficiosAdd"));
		}

	}

	/**
	 * 
	 * <b> Permite setear los limites y costos de maternidad. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 25/07/2015]
	 * </p>
	 * 
	 */
	public void setearMaternidad() {

		if (selectedCostosMaternidad.isEmpty()) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.maternidad"));
		} else {
			for (LimitesCostosAsm limite : selectedCostosMaternidad) {
				asistenciaMedica.getLimitesCostosAsms().add(limite);
			}
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.maternidad"));
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
	public void onEditBeneficios(RowEditEvent event) {

		FacesMessage msg = new FacesMessage("Item Edited", ((LimitesCostosDTO) event.getObject()).getLimitesCostos());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * @return the parentescoItems
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
	 * 
	 * <b> Permite buscar los contactos de una aseguradora. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 01/03/2016]
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
	 * <b> Permite agresar una nueva aseguradora a la tabla. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 01/03/2016]
	 * </p>
	 * 
	 */
	public void addAseguradora() {

		try {
			Long idAseguradora = Long.parseLong(ramoAsistenciaMedicaBean.getAseguradora());
			Aseguradora aseguradoraNew = aseguradoraService.consultarAseguradoraByCodigo(ramoAsistenciaMedicaBean.getAseguradora());

			DetalleCatalogo detalleCatalogo = detalleCatalogoService.consultarDetalleByCatalogoAndDetalle(
					HiperionMensajes.getInstancia().getInteger("ec.gob.avila.hiperion.recursos.catalogoAseguradoras"),
					Integer.parseInt(idAseguradora.toString()));

			AseguradoraDTO aseguradoraDTO = new AseguradoraDTO(detalleCatalogo.getDescDetCatalogo(), aseguradoraNew.getDirecion(),
					aseguradoraNew.getEmailAseguradora(), aseguradoraNew.getRuc(), aseguradoraNew.getTelfConvencionalAseg(),
					ramoAsistenciaMedicaBean.getContactoAseguradora());

			aseguradorasDTO.add(aseguradoraDTO);
			contactosItems.clear();

		} catch (HiperionException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * <b> Permite eliminar una elemento de la tabla de aseguradoras </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 02/03/2016]
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
	 * <b> Permite obtener una lista de formas de Pago </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 08/03/2016]
	 * </p>
	 * 
	 * @return
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
	 * @return the bancoItems
	 */
	public List<SelectItem> getBancoItems() {
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
	public List<SelectItem> getPagoFinanciadoItems() {
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
	 * @return
	 * @see java.util.List#size()
	 */
	public int size() {
		return bancoItems.size();
	}

	/**
	 * @return
	 * @see java.util.List#isEmpty()
	 */
	public boolean isEmpty() {
		return bancoItems.isEmpty();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		return bancoItems.contains(o);
	}

	/**
	 * @return
	 * @see java.util.List#iterator()
	 */
	public Iterator<SelectItem> iterator() {
		return bancoItems.iterator();
	}

	/**
	 * @return
	 * @see java.util.List#toArray()
	 */
	public Object[] toArray() {
		return bancoItems.toArray();
	}

	/**
	 * @param a
	 * @return
	 * @see java.util.List#toArray(T[])
	 */
	public <T> T[] toArray(T[] a) {
		return bancoItems.toArray(a);
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(SelectItem e) {
		return bancoItems.add(e);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		return bancoItems.remove(o);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.List#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> c) {
		return bancoItems.containsAll(c);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends SelectItem> c) {
		return bancoItems.addAll(c);
	}

	/**
	 * @param index
	 * @param c
	 * @return
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, Collection<? extends SelectItem> c) {
		return bancoItems.addAll(index, c);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> c) {
		return bancoItems.removeAll(c);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		return bancoItems.retainAll(c);
	}

	/**
	 * 
	 * @see java.util.List#clear()
	 */
	public void clear() {
		bancoItems.clear();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		return bancoItems.equals(o);
	}

	/**
	 * @return
	 * @see java.util.List#hashCode()
	 */
	public int hashCode() {
		return bancoItems.hashCode();
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.List#get(int)
	 */
	public SelectItem get(int index) {
		return bancoItems.get(index);
	}

	/**
	 * @param index
	 * @param element
	 * @return
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public SelectItem set(int index, SelectItem element) {
		return bancoItems.set(index, element);
	}

	/**
	 * @param index
	 * @param element
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int index, SelectItem element) {
		bancoItems.add(index, element);
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.List#remove(int)
	 */
	public SelectItem remove(int index) {
		return bancoItems.remove(index);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object o) {
		return bancoItems.indexOf(o);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object o) {
		return bancoItems.lastIndexOf(o);
	}

	/**
	 * @return
	 * @see java.util.List#listIterator()
	 */
	public ListIterator<SelectItem> listIterator() {
		return bancoItems.listIterator();
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<SelectItem> listIterator(int index) {
		return bancoItems.listIterator(index);
	}

	/**
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 * @see java.util.List#subList(int, int)
	 */
	public List<SelectItem> subList(int fromIndex, int toIndex) {
		return bancoItems.subList(fromIndex, toIndex);
	}

	/**
	 * @return the cuentaBancoItems
	 */
	public List<SelectItem> getCuentaBancoItems() {
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
	 * 
	 * <b> Permite activar los paneles segun la forma de pago que selecciono el usuario. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 08/03/2016]
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

	public double redondear(double numero, int decimales) {
		return Math.round(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
	}

	/**
	 * 
	 * <b> Permite obtener el numero de dias de cobertura </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 08/03/2016]
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
	 * [Author: Franklin Pozo B, Date: 08/03/2016]
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
	 * <b> Permite generar una tabla de amortizacion con valores ingresados en la pantalla. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 08/03/2016]
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
	 * [Author: Franklin Pozo B, Date: 08/03/2016]
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
	 * @param formasPagoItems
	 *            the formasPagoItems to set
	 */
	public void setFormasPagoItems(List<SelectItem> formasPagoItems) {
		this.formasPagoItems = formasPagoItems;
	}

	/**
	 * 
	 * <b> Permite buscar los contactos de la aseguradora seleccionada </b>
	 * <p>
	 * [Author: Frankllin Pozo B, Date: 01/03/2016]
	 * </p>
	 * 
	 */
	public void buscarContactoAseguradora() {

		buscarContactoAseguradora(ramoAsistenciaMedicaBean.getAseguradora());
	}

	/**
	 * @param aseguradorasItems
	 *            the aseguradorasItems to set
	 */
	public void setAseguradorasItems(List<SelectItem> aseguradorasItems) {
		this.aseguradorasItems = aseguradorasItems;
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
		AsistenciaMedicaBacking.aseguradorasDTO = aseguradorasDTO;
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
	 * @param parentescoItems
	 *            the parentescoItems to set
	 */
	public void setParentescoItems(List<SelectItem> parentescoItems) {
		this.parentescoItems = parentescoItems;
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
	 * @return the ramoAsistenciaMedicaBean
	 */
	public RamoAsistenciaMedicaBean getRamoAsistenciaMedicaBean() {
		return ramoAsistenciaMedicaBean;
	}

	/**
	 * @param ramoAsistenciaMedicaBean
	 *            the ramoAsistenciaMedicaBean to set
	 */
	public void setRamoAsistenciaMedicaBean(RamoAsistenciaMedicaBean ramoAsistenciaMedicaBean) {
		this.ramoAsistenciaMedicaBean = ramoAsistenciaMedicaBean;
	}

	/**
	 * @return the selectedBeneficios
	 */
	public List<LimitesCostosAsm> getSelectedBeneficios() {
		return selectedBeneficios;
	}

	/**
	 * @param selectedBeneficios
	 *            the selectedBeneficios to set
	 */
	public void setSelectedBeneficios(List<LimitesCostosAsm> selectedBeneficios) {
		this.selectedBeneficios = selectedBeneficios;
	}

	/**
	 * @return the selectedBeneficiosAdd
	 */
	public List<LimitesCostosAsm> getSelectedBeneficiosAdd() {
		return selectedBeneficiosAdd;
	}

	/**
	 * @param selectedBeneficiosAdd
	 *            the selectedBeneficiosAdd to set
	 */
	public void setSelectedBeneficiosAdd(List<LimitesCostosAsm> selectedBeneficiosAdd) {
		this.selectedBeneficiosAdd = selectedBeneficiosAdd;
	}

	/**
	 * @return the selectedCostosMaternidad
	 */
	public List<LimitesCostosAsm> getSelectedCostosMaternidad() {
		return selectedCostosMaternidad;
	}

	/**
	 * @param selectedCostosMaternidad
	 *            the selectedCostosMaternidad to set
	 */
	public void setSelectedCostosMaternidad(List<LimitesCostosAsm> selectedCostosMaternidad) {
		this.selectedCostosMaternidad = selectedCostosMaternidad;
	}

	/**
	 * @return the limitesCostosBeneficios
	 */
	public List<LimitesCostosAsm> getLimitesCostosBeneficios() {
		return limitesCostosBeneficios;
	}

	/**
	 * @param limitesCostosBeneficios the limitesCostosBeneficios to set
	 */
	public void setLimitesCostosBeneficios(List<LimitesCostosAsm> limitesCostosBeneficios) {
		this.limitesCostosBeneficios = limitesCostosBeneficios;
	}

	/**
	 * @return the limitesCostosBenAdd
	 */
	public List<LimitesCostosAsm> getLimitesCostosBenAdd() {
		return limitesCostosBenAdd;
	}

	/**
	 * @param limitesCostosBenAdd the limitesCostosBenAdd to set
	 */
	public void setLimitesCostosBenAdd(List<LimitesCostosAsm> limitesCostosBenAdd) {
		this.limitesCostosBenAdd = limitesCostosBenAdd;
	}

	/**
	 * @return the limitesCostosMaternidad
	 */
	public List<LimitesCostosAsm> getLimitesCostosMaternidad() {
		return limitesCostosMaternidad;
	}

	/**
	 * @param limitesCostosMaternidad the limitesCostosMaternidad to set
	 */
	public void setLimitesCostosMaternidad(List<LimitesCostosAsm> limitesCostosMaternidad) {
		this.limitesCostosMaternidad = limitesCostosMaternidad;
	}

}
