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
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

import ec.com.avila.emision.web.beans.PolizaBean;
import ec.com.avila.emision.web.beans.RamoAgropecuarioBean;
import ec.com.avila.emision.web.validator.ValidatorCedula;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.AseguradoraDTO;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.ObjetoAseguradoGanaderoAgroDTO;
import ec.com.avila.hiperion.dto.ObjetoAseguradoPlantacionAgroDTO;
import ec.com.avila.hiperion.dto.TablaAmortizacionDTO;
import ec.com.avila.hiperion.emision.entities.ArchivoBase;
import ec.com.avila.hiperion.emision.entities.Aseguradora;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.ClausulasAddAgro;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.CobertAgro;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.ObjAsegAgropecuario;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.enumeration.RamoEnum;
import ec.com.avila.hiperion.servicio.AseguradoraService;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.RamoAgropecuarioService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ArchivoUtil;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.FechasUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Backing que permite gestionar la informacion que se maneje en las paginas web que utilicen el Ramo Agropecuario. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class AgropecuarioBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private RamoService ramoService;
	@EJB
	private ClienteService clienteService;
	@EJB
	private RamoAgropecuarioService ramoAgropecuarioService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private AseguradoraService aseguradoraService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{ramoAgropecuarioBean}")
	private RamoAgropecuarioBean ramoAgropecuarioBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@ManagedProperty(value = "#{polizaBean}")
	private PolizaBean polizaBean;

	private List<DetalleAnexo> anexos;
	private List<ClausulasAddAgro> clausulasAdicionales;
	private List<ClausulasAddAgro> selectedClausulasAdd;
	private List<CobertAgro> coberturasTransporte;
	private List<CobertAgro> selectedCoberturasTransporte;
	private List<CobertAgro> coberturasVida;
	private List<CobertAgro> selectedCoberturasVida;

	private UploadedFile file;
	private List<SelectItem> sexoItems;
	private List<SelectItem> tipoObjetoItems;
	private List<SelectItem> formasPagoItems;
	private List<SelectItem> bancoItems;
	private List<SelectItem> cuentaBancoItems;
	private List<SelectItem> pagoFinanciadoItems;
	private List<SelectItem> tarjetasCreditoItems;
	private List<SelectItem> aseguradorasItems;
	private List<TablaAmortizacionDTO> tablaAmortizacionList = new ArrayList<TablaAmortizacionDTO>();
	private List<SelectItem> contactosItems = new ArrayList<>();
	private Boolean activarGanadero;
	private Boolean activarPanelPagoContado = false;
	private Boolean activarPanelPagoFinanciado = false;
	private Boolean activarPanelPagoDebitoBancario = false;
	private Boolean activarPanelPagoTarjetaCredito = false;
	private static List<AseguradoraDTO> aseguradorasDTO = new ArrayList<AseguradoraDTO>();

	private Usuario usuario;

	private boolean activarDatosCliente = false;
	private boolean activarDatosAseguradora = false;

	Logger log = Logger.getLogger(AgropecuarioBacking.class);

	RamoAgropecuario agropecuario = new RamoAgropecuario();

	@PostConstruct
	public void inicializar() {
		try {

			Ramo ramo = ramoService.consultarRamoPorCodigo("AGP");

			anexos = ramo.getDetalleAnexos();

			obtenerClausulasAdicionales();
			obtenerCoberturasTransporte();
			obtenerCoberturasVida();

			usuario = usuarioBean.getSessionUser();

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Clausulas Adicionales del Ramo Accidentes Personales. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public void obtenerClausulasAdicionales() {
		clausulasAdicionales = new ArrayList<ClausulasAddAgro>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {

				if (anexo.getAnexo().getIdAnexo() == 1) {
					ClausulasAddAgro clausula = new ClausulasAddAgro();
					clausula.setIdClausulaAd(anexo.getIdDetalleAnexo());
					clausula.setClausulaAddAgro(anexo.getNombreDetalleAnexo());
					clausulasAdicionales.add(clausula);
				}
			}

		}

	}

	/**
	 * 
	 * <b> Permite obtener el numero de dias de cobertura. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 24/02/2016]
	 * </p>
	 * 
	 */
	public void obtenerDias() {
		long dias = FechasUtil.getInstancia().restarFechas(polizaBean.getVigenciaDesde(), polizaBean.getVigenciaHasta());

		polizaBean.setDiasCobertura(Integer.parseInt(Long.toString(dias)));

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
	 * 
	 * <b> Permite buscar los contactos de la aseguradora seleccionada </b>
	 * <p>
	 * [Author: Frankin Pozo B, Date: 29/02/2016]
	 * </p>
	 * 
	 */
	public void buscarContactoAseguradora() {

		buscarContactoAseguradora(ramoAgropecuarioBean.getAseguradora());
	}

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 16/03/2016]
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
	 * [Author: HIPERION, Date: 29/02/2016]
	 * </p>
	 * 
	 */
	public void addAseguradora() {

		try {
			Long idAseguradora = Long.parseLong(ramoAgropecuarioBean.getAseguradora());
			Aseguradora aseguradoraNew = aseguradoraService.consultarAseguradoraByCodigo(ramoAgropecuarioBean.getAseguradora());

			DetalleCatalogo detalleCatalogo = detalleCatalogoService.consultarDetalleByCatalogoAndDetalle(
					HiperionMensajes.getInstancia().getInteger("ec.gob.avila.hiperion.recursos.catalogoAseguradoras"),
					Integer.parseInt(idAseguradora.toString()));

			AseguradoraDTO aseguradoraDTO = new AseguradoraDTO(detalleCatalogo.getDescDetCatalogo(), aseguradoraNew.getDirecion(),
					aseguradoraNew.getEmailAseguradora(), aseguradoraNew.getRuc(), aseguradoraNew.getTelfConvencionalAseg(),
					ramoAgropecuarioBean.getContactoAseguradora());

			aseguradorasDTO.add(aseguradoraDTO);
			// contactosItems.clear();

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
	 * @param aseguradorasItems
	 *            the aseguradorasItems to set
	 */
	public void setAseguradorasItems(List<SelectItem> aseguradorasItems) {
		this.aseguradorasItems = aseguradorasItems;
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
	 * @return the activarPanelPagoContado
	 */
	public Boolean getActivarPanelPagoContado() {
		return activarPanelPagoContado;
	}

	/**
	 * @return the activarPanelPagoFinanciado
	 */
	public Boolean getActivarPanelPagoFinanciado() {
		return activarPanelPagoFinanciado;
	}

	/**
	 * @return the activarPanelPagoDebitoBancario
	 */
	public Boolean getActivarPanelPagoDebitoBancario() {
		return activarPanelPagoDebitoBancario;
	}

	/**
	 * @return the activarPanelPagoTarjetaCredito
	 */
	public Boolean getActivarPanelPagoTarjetaCredito() {
		return activarPanelPagoTarjetaCredito;
	}

	public void onEditTable(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((TablaAmortizacionDTO) event.getObject()).getLetra());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public double redondear(double numero, int decimales) {
		return Math.round(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
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
	 * 
	 * <b> Permite generar una tabla de amortizacion con valores ingresados en la pantalla </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 23/02/2016]
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
	 * <b>Permite obtener las coberturas de transporte </b>
	 * <p>
	 * [Author: DARVIN, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public void obtenerCoberturasTransporte() throws HiperionException {

		coberturasTransporte = new ArrayList<CobertAgro>();

		if (anexos != null && anexos.size() > 0) {
			List<DetalleAnexo> detallesTransporte = new ArrayList<>();
			for (DetalleAnexo detalleAnexo : anexos) {
				if (detalleAnexo.getTitulo() != null) {
					detallesTransporte = ramoAgropecuarioService.consultarDetallesByTitulo(detalleAnexo.getRamo().getIdRamo(), new Long(1));
				}
			}
			for (DetalleAnexo detalle : detallesTransporte) {
				coberturasTransporte.add(new CobertAgro(detalle.getIdDetalleAnexo(), detalle.getNombreDetalleAnexo()));
			}
		}
	}

	/**
	 * 
	 * <b> Permite obtener una lista de formas de pago </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 22/02/2016]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getFormasPagoItems() throws HiperionException {
		this.formasPagoItems = new ArrayList<SelectItem>();
		// Busqueda por el codigo de formas de pago (4)
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
	 * <b> Permite activar los paneles segun la forma de pago que seleccione un usuario </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 22/02/2016]
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
	 * @param activarPanelPagoContado
	 *            the activarPanelPagoContado to set
	 */
	public void setActivarPanelPagoContado(Boolean activarPanelPagoContado) {
		this.activarPanelPagoContado = activarPanelPagoContado;
	}

	/**
	 * @param activarPanelPagoFinanciado
	 *            the activarPanelPagoFinanciado to set
	 */
	public void setActivarPanelPagoFinanciado(Boolean activarPanelPagoFinanciado) {
		this.activarPanelPagoFinanciado = activarPanelPagoFinanciado;
	}

	/**
	 * @param activarPanelPagoDebitoBancario
	 *            the activarPanelPagoDebitoBancario to set
	 */
	public void setActivarPanelPagoDebitoBancario(Boolean activarPanelPagoDebitoBancario) {
		this.activarPanelPagoDebitoBancario = activarPanelPagoDebitoBancario;
	}

	/**
	 * @param activarPanelPagoTarjetaCredito
	 *            the activarPanelPagoTarjetaCredito to set
	 */
	public void setActivarPanelPagoTarjetaCredito(Boolean activarPanelPagoTarjetaCredito) {
		this.activarPanelPagoTarjetaCredito = activarPanelPagoTarjetaCredito;
	}

	/**
	 * 
	 * <b>Permite obtener las coberturas por medio del ramo </b>
	 * <p>
	 * [Author: DARVIN, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public void obtenerCoberturasVida() throws HiperionException {
		coberturasVida = new ArrayList<CobertAgro>();
		if (anexos != null && anexos.size() > 0) {
			List<DetalleAnexo> detallesVida = new ArrayList<>();
			for (DetalleAnexo detalleAnexo : anexos) {
				if (detalleAnexo.getTitulo() != null) {
					detallesVida = ramoAgropecuarioService.consultarDetallesByTitulo(detalleAnexo.getRamo().getIdRamo(), new Long(2));
				}
			}
			for (DetalleAnexo detalle : detallesVida) {
				coberturasVida.add(new CobertAgro(detalle.getIdDetalleAnexo(), detalle.getNombreDetalleAnexo()));
			}
		}
	}

	/**
	 * 
	 * <b> Permite setaer la informacion del ramo antes de guardar en la base </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 28, 2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 * 
	 */
	public void guardarRamo() throws HiperionException {

		try {

			Poliza poliza = setearDatosPoliza();

			// Informacion del Ramo
			agropecuario.setIdUsuarioCreacion(usuario.getIdUsuario());
			agropecuario.setFechaCreacion(new Date());
			agropecuario.setEstado(EstadoEnum.A);

			agropecuario.setTasaAgro(ramoAgropecuarioBean.getTasa());
			agropecuario.setDeducAgro(ramoAgropecuarioBean.getDeducible());

			if (ramoAgropecuarioBean.getObjetoAseguradoPlantacionList().isEmpty() && ramoAgropecuarioBean.getObjetoAseguradoList().isEmpty()) {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save.Obj"));
			} else {
				// Informacion del objeto asegurado
				if (ramoAgropecuarioBean.getTipoObjeto().equals("2") && !ramoAgropecuarioBean.getObjetoAseguradoList().isEmpty()) {

					List<ObjAsegAgropecuario> listObjetos = new ArrayList<>();
					for (ObjetoAseguradoGanaderoAgroDTO objeto : ramoAgropecuarioBean.getObjetoAseguradoList()) {
						ObjAsegAgropecuario objAsegAgropecuario = new ObjAsegAgropecuario();

						objAsegAgropecuario.setRamoAgropecuario(agropecuario);
						objAsegAgropecuario.setItemObjAgro(objeto.getItem());
						objAsegAgropecuario.setNombreObjAgro(objeto.getNombre());
						objAsegAgropecuario.setSexoObjAgro(objeto.getSexo());
						objAsegAgropecuario.setRazaObjAgro(objeto.getRaza());
						objAsegAgropecuario.setColorObjAgro(objeto.getColor());
						objAsegAgropecuario.setEdadObjAgro(objeto.getEdad());
						objAsegAgropecuario.setMontoAsegObjAgro(objeto.getMontoAsegurado());
						objAsegAgropecuario.setTipoObjeto(Integer.parseInt(ramoAgropecuarioBean.getTipoObjeto()));
						objAsegAgropecuario.setIdUsuarioCreacion(usuario.getIdUsuario());
						objAsegAgropecuario.setFechaCreacion(new Date());
						objAsegAgropecuario.setEstado(EstadoEnum.A);
						listObjetos.add(objAsegAgropecuario);
					}
					agropecuario.setObjAsegAgropecuarios(listObjetos);
				}

				if (ramoAgropecuarioBean.getTipoObjeto().equals("1") && !ramoAgropecuarioBean.getObjetoAseguradoPlantacionList().isEmpty()) {

					List<ObjAsegAgropecuario> listObjetos = new ArrayList<>();
					for (ObjetoAseguradoPlantacionAgroDTO objeto : ramoAgropecuarioBean.getObjetoAseguradoPlantacionList()) {
						ObjAsegAgropecuario objAsegAgropecuario = new ObjAsegAgropecuario();

						objAsegAgropecuario.setValorAseguradoAgro(objeto.getValorAsegurado());
						objAsegAgropecuario.setDetalleAgro(objeto.getDetalle());
						objAsegAgropecuario.setUbicacion(objeto.getUbicacion());
						objAsegAgropecuario.setTipoObjeto(Integer.parseInt(ramoAgropecuarioBean.getTipoObjeto()));
						objAsegAgropecuario.setIdUsuarioCreacion(usuario.getIdUsuario());
						objAsegAgropecuario.setFechaCreacion(new Date());
						objAsegAgropecuario.setEstado(EstadoEnum.A);
						listObjetos.add(objAsegAgropecuario);
					}
					agropecuario.setObjAsegAgropecuarios(listObjetos);
				}

			}
			// Archivo
			/*
			 * if (ramoAgropecuarioBean.getFilePolizaVigente() != null) {
			 * ramoAgropecuarioBean.getFilePolizaVigente().setIdUsuarioCreacion(usuario.getIdUsuario());
			 * ramoAgropecuarioBean.getFilePolizaVigente().setFechaCreacion(new Date());
			 * ramoAgropecuarioBean.getFilePolizaVigente().setEstado(EstadoEnum.A);
			 * ramoAgropecuarioService.guardarArchivoPoliza(ramoAgropecuarioBean.getFilePolizaVigente());
			 * 
			 * MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save")); agropecuario = new
			 * RamoAgropecuario(); ramoAgropecuarioBean.getObjetoAseguradoList().clear(); } else { MessagesController.addError(null,
			 * HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.archivoPoliza")); }
			 */

			ramoAgropecuarioService.guardarAgropecuario(agropecuario, poliza);

			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo agropecuario", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new HiperionException(e);
		}
	}

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 29/02/2016]
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

					ramoAgropecuarioBean.setNombreCliente(cliente.getNombrePersona() + " " + cliente.getApellidoPaterno() + " "
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
	 * <b> IPermite buscar un cliente por madio del numero de identificacion. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/02/2016]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void buscarCliente() throws HiperionException {

		Cliente cliente = buscarCliente(ramoAgropecuarioBean.getIdentificacion());

		if (cliente != null) {
			activarDatosCliente = true;
			activarDatosAseguradora = true;
		}
	}

	/**
	 * 
	 * <b> Permite setear las clausulas seleccionadas en el bean. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 13/07/2015]
	 * </p>
	 * 
	 */
	public void setearClausulas() {

		if (selectedClausulasAdd.isEmpty()) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.clausulasAdd"));
		} else {
			agropecuario.setClausulasAddAgros(selectedClausulasAdd);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.clausulasAdd"));
		}
	}

	/**
	 * 
	 * <b> Permite setear las coberturas seleccionadas en el bean. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 13/07/2015]
	 * </p>
	 * 
	 */
	public void setearCoberturas() {
		// Coberturas Transporte

		List<CobertAgro> coberturas = new ArrayList<>();
		if (selectedCoberturasTransporte.isEmpty()) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.coberturas"));
		} else {
			coberturas = selectedCoberturasTransporte;
		}

		// coberturas Vida
		if (selectedCoberturasVida.isEmpty()) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.coberturas"));
		} else {
			for (CobertAgro coberturaVida : selectedCoberturasVida) {
				coberturas.add(coberturaVida);
			}
		}

		agropecuario.setCobertAgros(coberturas);
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
	 * <b> Permite setear los datos de la poliza. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 09/07/2015]
	 * </p>
	 * 
	 * @return
	 */
	public Poliza setearDatosPoliza() {

		Usuario usuario = usuarioBean.getSessionUser();
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
		poliza.setRamo(RamoEnum.R2.getLabel());

		return poliza;
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
	public void onEditClausula(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ClausulaAdicionalDTO) event.getObject()).getClausula());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite controlar la obligatoriedad de los campos dependiendo el tipo de objeto asegurado. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerTipoObjeto() {

		if (ramoAgropecuarioBean.getTipoObjeto().equals("2")) {
			activarGanadero = true;
		} else {
			activarGanadero = false;
		}

	}

	/**
	 * 
	 * <b> Permite cargar el archivo en memoria antes de ser guardado </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Sep 28, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void cargarArchivoPoliza(FileUploadEvent event) {

		if (event.getFile() != null) {

			try {

				UploadedFile file = event.getFile();

				ArchivoBase archivoBase = new ArchivoBase();

				ramoAgropecuarioBean.setFilePolizaVigente(archivoBase);
				ArchivoUtil.getInstancia().agregarArchivo(archivoBase, file);

				FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);

			} catch (Exception e) {
				log.error("Error {}", e);
			}
		}
	}

	/**
	 * 
	 * <b> Permite obtner la lista de sexos disponibles en el catalogo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Sep 27, 2014]
	 * </p>
	 * 
	 * @return
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
	 * @param sexoItems
	 *            the sexoItems to set
	 */
	public void setSexoItems(List<SelectItem> sexoItems) {
		this.sexoItems = sexoItems;
	}

	/**
	 * 
	 * <b> Permite obtener la lista de del los objetos asegurados </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 27/01/2015]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getTipoObjetoItems() throws HiperionException {
		this.tipoObjetoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoTipoObjetoAgropecuario"));
		List<DetalleCatalogo> sexos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : sexos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tipoObjetoItems.add(selectItem);
		}
		return tipoObjetoItems;
	}

	/**
	 * @param tipoObjetoItems
	 *            the tipoObjetoItems to set
	 */
	public void setTipoObjetoItems(List<SelectItem> tipoObjetoItems) {
		this.tipoObjetoItems = tipoObjetoItems;
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
	 * @return the ramoAgropecuarioBean
	 */
	public RamoAgropecuarioBean getRamoAgropecuarioBean() {
		return ramoAgropecuarioBean;
	}

	/**
	 * @param ramoAgropecuarioBean
	 *            the ramoAgropecuarioBean to set
	 */
	public void setRamoAgropecuarioBean(RamoAgropecuarioBean ramoAgropecuarioBean) {
		this.ramoAgropecuarioBean = ramoAgropecuarioBean;
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
	 * 
	 * <b> Permite generar y descargar informacion Ramo Agropecuario PDF. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 01/03/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void descargarAgropecuarioPDF() throws HiperionException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarAchivoPDFAgropecuario(agropecuario));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();

		} catch (Exception e) {
			log.error("Error al momento generar el a hoja de vida en PDF", e);
			throw new HiperionException(e);
		}

	}

	/**
	 * @return the clausulasAdicionales
	 */
	public List<ClausulasAddAgro> getClausulasAdicionales() {
		return clausulasAdicionales;
	}

	/**
	 * @param clausulasAdicionales
	 *            the clausulasAdicionales to set
	 */
	public void setClausulasAdicionales(List<ClausulasAddAgro> clausulasAdicionales) {
		this.clausulasAdicionales = clausulasAdicionales;
	}

	/**
	 * @return the selectedClausulasAdd
	 */
	public List<ClausulasAddAgro> getSelectedClausulasAdd() {
		return selectedClausulasAdd;
	}

	/**
	 * @param selectedClausulasAdd
	 *            the selectedClausulasAdd to set
	 */
	public void setSelectedClausulasAdd(List<ClausulasAddAgro> selectedClausulasAdd) {
		this.selectedClausulasAdd = selectedClausulasAdd;
	}

	/**
	 * @return the activarGanadero
	 */
	public Boolean getActivarGanadero() {
		return activarGanadero;
	}

	/**
	 * @param activarGanadero
	 *            the activarGanadero to set
	 */
	public void setActivarGanadero(Boolean activarGanadero) {
		this.activarGanadero = activarGanadero;
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
	 * 
	 * <b> Permite crear el combo de tipo de cuenta </b>
	 * <p>
	 * [Author:Franklin Pozo B, Date: 25/02/2016]
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
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 25/02/2016]
	 * </p>
	 * 
	 * @return
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
	 * @param tarjetasCreditoItems
	 *            the tarjetasCreditoItems to set
	 */
	public void setTarjetasCreditoItems(List<SelectItem> tarjetasCreditoItems) {
		this.tarjetasCreditoItems = tarjetasCreditoItems;
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
		AgropecuarioBacking.aseguradorasDTO = aseguradorasDTO;
	}

	/**
	 * @return the activarDatosAseguradora
	 */
	public boolean isActivarDatosAseguradora() {
		return activarDatosAseguradora;
	}

	/**
	 * @param activarDatosAseguradora
	 *            the activarDatosAseguradora to set
	 */
	public void setActivarDatosAseguradora(boolean activarDatosAseguradora) {
		this.activarDatosAseguradora = activarDatosAseguradora;
	}

	/**
	 * @param activarDatosCliente
	 *            the activarDatosCliente to set
	 */
	public void setActivarDatosCliente(boolean activarDatosCliente) {
		this.activarDatosCliente = activarDatosCliente;
	}

	/**
	 * @return the coberturasTransporte
	 */
	public List<CobertAgro> getCoberturasTransporte() {
		return coberturasTransporte;
	}

	/**
	 * @param coberturasTransporte
	 *            the coberturasTransporte to set
	 */
	public void setCoberturasTransporte(List<CobertAgro> coberturasTransporte) {
		this.coberturasTransporte = coberturasTransporte;
	}

	/**
	 * @return the selectedCoberturasTransporte
	 */
	public List<CobertAgro> getSelectedCoberturasTransporte() {
		return selectedCoberturasTransporte;
	}

	/**
	 * @param selectedCoberturasTransporte
	 *            the selectedCoberturasTransporte to set
	 */
	public void setSelectedCoberturasTransporte(List<CobertAgro> selectedCoberturasTransporte) {
		this.selectedCoberturasTransporte = selectedCoberturasTransporte;
	}

	/**
	 * @return the coberturasVida
	 */
	public List<CobertAgro> getCoberturasVida() {
		return coberturasVida;
	}

	/**
	 * @param coberturasVida
	 *            the coberturasVida to set
	 */
	public void setCoberturasVida(List<CobertAgro> coberturasVida) {
		this.coberturasVida = coberturasVida;
	}

	/**
	 * @return the selectedCoberturasVida
	 */
	public List<CobertAgro> getSelectedCoberturasVida() {
		return selectedCoberturasVida;
	}

	/**
	 * @param selectedCoberturasVida
	 *            the selectedCoberturasVida to set
	 */
	public void setSelectedCoberturasVida(List<CobertAgro> selectedCoberturasVida) {
		this.selectedCoberturasVida = selectedCoberturasVida;
	}

}
