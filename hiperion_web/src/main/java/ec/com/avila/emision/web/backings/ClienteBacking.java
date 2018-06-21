package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

import ec.com.avila.emision.web.beans.ClienteBean;
import ec.com.avila.emision.web.beans.ContactoBean;
import ec.com.avila.emision.web.beans.DireccionBean;
import ec.com.avila.emision.web.validator.ValidatorCedula;
import ec.com.avila.emision.web.validator.ValidatorRuc;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ContactoDTO;
import ec.com.avila.hiperion.dto.DireccionDTO;
import ec.com.avila.hiperion.dto.ProvinciaDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.Contacto;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Direccion;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.Provincia;
import ec.com.avila.hiperion.emision.entities.TipoDireccion;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.DireccionService;
import ec.com.avila.hiperion.servicio.PolizaService;
import ec.com.avila.hiperion.servicio.ProvinciaService;
import ec.com.avila.hiperion.servicio.TipoDireccionService;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.EmisionUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

@ManagedBean
@ViewScoped
public class ClienteBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{clienteBean}")
	private ClienteBean clienteBean;

	@ManagedProperty(value = "#{direccionBean}")
	private DireccionBean direccionBean;

	@ManagedProperty(value = "#{contactoBean}")
	private ContactoBean contactoBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

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

	private DireccionDTO direccionDto;
	private List<DireccionDTO> direccionesDTO = new ArrayList<>();
	private List<Cliente> clientes;
	private List<Cliente> clientesObtenidos = new ArrayList<>();
	private List<Poliza> polizas;
	private Cliente clienteObtenido;

	private boolean activarPanelPersonaNatural;
	private boolean activarPanelPersonaJuridica;
	private boolean activarPanelDireccionCobro;
	private boolean activarPanelDireccionDomicilio;
	private boolean activarPanelDireccionOficina;
	private boolean save = true;
	private boolean editar = false;

	private Usuario usuario;

	private UploadedFile file;

	Logger log = Logger.getLogger(ClienteBacking.class);

	@PostConstruct
	public void inicializar() throws HiperionException {
		usuario = usuarioBean.getSessionUser();
		obtenerTipoIdentificacion();
	}

	/**
	 * 
	 * <b> Permite obtener el codigo de un nuevo cliente que se va a registrar en la Base de Avila. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 12/09/2014]
	 * </p>
	 * 
	 */
	public void obtenerCodigoCliente() {
		try {
			setClientes(clienteService.consultarClientes());
			clienteBean.setCodigoCliente(EmisionUtil.obtenerCodigoCliente(clientes.size() + 1));

		} catch (HiperionException e) {
			e.printStackTrace();
		}
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
	 * [Author: Dario Vinueza, Date: 13/09/2014]
	 * </p>
	 * 
	 * @return - Lista de Tipos de Identificaci&oacute;n.
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
	 * <b> Permite validar el n&uacute;mero de caracteres de un campo seg&uacute;n el tipo de identificaci&oacute;n. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 19, 2014]
	 * </p>
	 * 
	 * @param tipoPersona
	 *            - Tipo de Persona: Natural o Juridica
	 */
	public void selectTipoPersona(Integer tipoPersona) {

		// Persona Natural
		if (tipoPersona == 1) {
			setActivarPanelPersonaNatural(true);
			setActivarPanelPersonaJuridica(false);
			clienteBean.setIdentificacion("");
			// Persona Juridica
		} else if (tipoPersona == 2) {
			clienteBean.setTipoIdentificacion("2");
			setActivarPanelPersonaJuridica(true);
			setActivarPanelPersonaNatural(false);
		}
	}

	/**
	 * 
	 * <b> Permite editar los datos del cliente. </b>
	 * <p>
	 * [Author: kruger, Date: 12/12/2016]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void editarCliente() throws HiperionException {

		direccionesDTO = new ArrayList<>();
		save = false;
		editar = true;

		if (clienteBean.getIdentificacion().equals("")) {
			MessagesController.addWarn(null, "Ingresar el número de identificación.");
		} else {
			clienteObtenido = clienteService.consultarClienteByIdentificacion(clienteBean.getIdentificacion());

			clienteBean.setCodigoCliente(clienteObtenido.getCodigoCliente());
			clienteBean.setTipoPersona(Integer.parseInt(clienteObtenido.getTipoPersona()));
			clienteBean.setTipoIdentificacion(clienteObtenido.getTipoIdentificacion());
			List<Contacto> contactos = clienteService.consultarContactoByCliente(clienteObtenido.getIdCliente());
			List<ContactoDTO> contactoDTOs = new ArrayList<>();
			for (Contacto contacto : contactos) {
				ContactoDTO contactoDTO = new ContactoDTO();
				contactoDTO.setDescripcionContacto(contacto.getDescripcionContacto());
				contactoDTO.setTipoContacto(contacto.getTipoContacto());
				contactoDTO.setIdContacto(contacto.getIdContacto());

				contactoDTOs.add(contactoDTO);
			}
			contactoBean.setContactosDTO(contactoDTOs);
			List<Direccion> direcciones = clienteService.consularDireccionByCliente(clienteObtenido.getIdCliente());
			for (Direccion direccion : direcciones) {
				DireccionDTO direccionDTO = new DireccionDTO();

				direccionDTO.setIdDireccion(direccion.getIdDireccion());
				direccionDTO.setCallePrincipal(direccion.getCallePrincipal());
				direccionDTO.setCalleSecundaria(direccion.getCalleSecundaria());
				direccionDTO.setNumeracion(direccion.getNumeracion());
				direccionDTO.setReferencia(direccion.getReferencia());

				ProvinciaDTO provinciaDTO = new ProvinciaDTO();
				provinciaDTO.setCodProvincia(direccion.getProvincia().getCodigo());
				provinciaDTO.setNombre(direccion.getProvincia().getNombreProvincia());

				direccionDTO.setProvinciaDTO(provinciaDTO);

				TipoDireccion tipoDireccion = tipoDireccionService.consultarTipoDireccionByDescripcion(direccion.getTipoDireccion()
						.getDescTipoDireccion());
				direccionDTO.setTipoDireccion(tipoDireccion.getDescTipoDireccion());

				direccionesDTO.add(direccionDTO);
			}

		}

	}

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 12/08/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void agregarDireccion() throws HiperionException {

		String codTipoDireccion = direccionBean.getCodTipoDireccion();

		try {

			TipoDireccion tipoDireccion = tipoDireccionService.consultarTipoDireccionByCodigo(codTipoDireccion);
			direccionBean.setTipoDireccion(tipoDireccion.getDescTipoDireccion());

			direccionDto = new DireccionDTO();
			direccionDto.setProvinciaDTO(direccionBean.getProvinciaDTO());
			direccionDto.setCodTipoDireccion(codTipoDireccion);

			direccionBean.setTipoDireccion(tipoDireccion.getDescTipoDireccion());

			direccionDto.setTipoDireccion(direccionBean.getTipoDireccion());
			direccionDto.setCallePrincipal(direccionBean.getCallePrincipal());
			direccionDto.setNumeracion(direccionBean.getNumeracion());
			direccionDto.setCalleSecundaria(direccionBean.getCalleSecundaria());
			direccionDto.setReferencia(direccionBean.getReferencia());
			// Contacto Telefonico
			direccionDto.setTelefonoConvencional(direccionBean.getTelefonoConvencional());
			direccionDto.setTelefonoMovil(direccionBean.getTelefonoMovil());

			direccionesDTO.add(direccionDto);

		} catch (HiperionException e) {
			throw new HiperionException(e);
		}
	}

	/**
	 * 
	 * <b> Permite visualizar en pantalla el registro de la Direcci&oacte;n que fue modificado. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 * @param event
	 *            - parametro a ser modificado.
	 */
	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Direccion Modificada", ((DireccionDTO) event.getObject()).getTipoDireccion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite visualizar en pantalla el registro de la Direcci&oacte;n que no se modifico (se cancelo) </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 * @param event
	 *            - parametro que no se modifico.
	 */
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Direccion Eliminada", ((DireccionDTO) event.getObject()).getTipoDireccion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		direccionesDTO.remove((DireccionDTO) event.getObject());
	}

	/**
	 * 
	 * <b> Permite buscar cliente por medio de ingreso de parametros en la pantalla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void buscarClientes() throws HiperionException {
		try {
			List<Cliente> clientesTemp = new ArrayList<>();

			Cliente clienteObtenido = new Cliente();
			if (clienteBean.isActivarCedula() || clienteBean.isActivarRuc()) {

				if (clienteBean.getRuc().equals("")) {
					clienteObtenido = clienteService.consultarClienteByIdentificacion(clienteBean.getIdentificacion());
				} else {
					clienteObtenido = clienteService.consultarClienteByIdentificacion(clienteBean.getRuc());
				}
				if (clienteObtenido != null) {
					List<Direccion> direcciones = clienteService.consularDireccionByCliente(clienteObtenido.getIdCliente());
					clienteObtenido.setDireccions(direcciones);

					List<Contacto> contactos = clienteService.consultarContactoByCliente(clienteObtenido.getIdCliente());
					clienteObtenido.setContactos(contactos);
					clientesObtenidos.add(clienteObtenido);
				} else {
					MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.buscar"));
				}
			}

			if (clienteBean.isActivarNombre()) {
				clientesTemp = clienteService.consultarClienteByNombres(clienteBean.getNombre());
			}

			if (clienteBean.isActivarApellido()) {
				clientesTemp = clienteService.consultarClienteByApellido(clienteBean.getApePaterno());
			}
			if (clienteBean.isActivarRazonSocial()) {
				clientesTemp = clienteService.consultarByRazonSocial(clienteBean.getRazonSocial());
			}

			if (!clientesTemp.isEmpty()) {
				for (Cliente cliente : clientesTemp) {
					List<Direccion> direcciones = clienteService.consularDireccionByCliente(cliente.getIdCliente());
					cliente.setDireccions(direcciones);

					List<Contacto> contactos = clienteService.consultarContactoByCliente(cliente.getIdCliente());
					cliente.setContactos(contactos);
					clientesObtenidos.add(cliente);
				}
			} else {
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
	 * 
	 * <b> Permite Guardar a un Nuevo Cliente.. </b>
	 * <p>
	 * [Author: kruger, Date: 11/11/2016]
	 * </p>
	 * 
	 */
	public void guardarCliente() {
		try {

			Integer tipoIdentificacion = Integer.parseInt(clienteBean.getTipoIdentificacion());

			if (tipoIdentificacion == 1) {
				clienteObtenido = clienteService.consultarClienteByIdentificacion(clienteBean.getIdentificacion());
			} else {
				clienteObtenido = clienteService.consultarClienteByIdentificacion(clienteBean.getRuc());
			}

			if (clienteObtenido != null) {
				MessagesController.addError(null, "Ya existe un cliente con el mismo numero de indentificación.");
			} else {

				if (tipoIdentificacion == 2 && clienteBean.getIdentificacion().length() != 13) {
					MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensage.error.tamanioRuc"));
				} else {

					if (validarDocumentos(clienteBean.getIdentificacion(), tipoIdentificacion)) {
						// Direccion del Cliente
						if (direccionesDTO != null && direccionesDTO.size() > 0) {

							Cliente cliente = new Cliente();
							if (editar) {
								cliente = clienteObtenido;

								if (cliente.getTipoPersona().equals("1")) {
									activarPanelPersonaNatural = true;
								} else {
									activarPanelPersonaJuridica = true;
								}

							} else {

								cliente.setCodigoCliente(clienteBean.getCodigoCliente());

								cliente.setTipoIdentificacion(clienteBean.getTipoIdentificacion());
								cliente.setIdentificacionPersona(clienteBean.getIdentificacion());
								// Tipo de Persona
								int tipoPersona = clienteBean.getTipoPersona();
								if (tipoPersona == 1) {
									// Persona Natural
									cliente.setIdentificacionPersona(clienteBean.getIdentificacion());
									cliente.setNombrePersona(clienteBean.getNombre());
									cliente.setApellidoPaterno(clienteBean.getApePaterno());
									cliente.setApellidoMaterno(clienteBean.getApeMaterno());
									cliente.setActividadProfesion(clienteBean.getActividadProfecion());
									cliente.setFechaNacimiento(clienteBean.getFechaNacimiento());
								} else {
									// Persona Juridica
									cliente.setRazonSocial(clienteBean.getRazonSocial());
									cliente.setNombrePersona(clienteBean.getNombreJuridico());
									cliente.setApellidoPaterno(clienteBean.getApePaternoJuridico());
									cliente.setApellidoMaterno(clienteBean.getApeMaternoJuridico());
								}
								cliente.setTipoPersona(clienteBean.getTipoPersona().toString());
							}
							// Direcciones del Cliente
							List<Direccion> direcciones = new ArrayList<Direccion>();
							for (DireccionDTO direccionDto : direccionesDTO) {
								Direccion direccion = new Direccion();

								direccion.setCliente(cliente);
								TipoDireccion tipoDireccion = tipoDireccionService.consultarTipoDireccionByDescripcion(direccionDto
										.getTipoDireccion());
								direccion.setTipoDireccion(tipoDireccion);

								// Provincia
								Provincia provincia = provinciaService.consultarProvinciaPorCodigo(direccionDto.getProvinciaDTO().getCodProvincia());
								direccion.setProvincia(provincia);

								// Calles y Numeracion
								if (direccionDto.getIdDireccion() != null) {
									direccion.setIdDireccion(direccionDto.getIdDireccion());
								}
								direccion.setCallePrincipal(direccionDto.getCallePrincipal());
								direccion.setNumeracion(direccionDto.getNumeracion());
								direccion.setCalleSecundaria(direccionDto.getCalleSecundaria());
								direccion.setReferencia(direccionDto.getReferencia());

								direcciones.add(direccion);
							}

							cliente.setDireccions(direcciones);

							List<Contacto> contactos = new ArrayList<>();
							for (ContactoDTO contactoDTO : contactoBean.getContactosDTO()) {
								Contacto contacto = new Contacto();
								contacto.setIdContacto(contactoDTO.getIdContacto());
								contacto.setCliente(cliente);
								contacto.setTipoContacto(contactoDTO.getTipoContacto());
								contacto.setDescripcionContacto(contactoDTO.getDescripcionContacto());
								contactos.add(contacto);

							}
							cliente.setContactos(contactos);
							// Guardamos al Cliente
							cliente.setIdUsuarioCreacion(usuario.getIdUsuario());
							cliente.setFechaCreacion(new Date());
							cliente.setEstado(EstadoEnum.A);
							if (editar) {
								save = false;
							}
							clienteService.guardarCliente(cliente, save);

							if (editar) {
								clienteService.actualizarContactos(contactos, cliente.getIdCliente());
								direccionService.actualizarDirecciones(direcciones, cliente.getIdCliente());
							} else {
								clienteService.guardarContactos(contactos);
								direccionService.guardarDirecciones(direcciones);
							}

							MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.cliente"));
							direcciones = new ArrayList<>();
							direccionBean.setDireccionesRegistradas(null);
							contactos = new ArrayList<>();
							contactoBean.setContactosDTO(null);

							direccionBean.setCallePrincipal(null);
							direccionBean.setCalleSecundaria(null);
							direccionBean.setNumeracion(null);
							direccionBean.setReferencia(null);

						} else {
							MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.direccion"));
						}
					} else {
						MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensage.error.identificacionNoValido"));
					}

				}
			}

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite validar el numero de identificacion tanto para cedula como ruc </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 02/02/2015]
	 * </p>
	 * 
	 * @param identificacion
	 * @param tipoIdentificacion
	 * @return
	 */
	public Boolean validarDocumentos(String identificacion, Integer tipoIdentificacion) {
		Boolean pasaValidacion = false;

		if (clienteBean.getTipoPersona() == 1) {
			if (tipoIdentificacion == 1) {
				pasaValidacion = ValidatorCedula.getInstancia().validateCedula(identificacion);
			} else if (tipoIdentificacion == 2) {
				pasaValidacion = ValidatorRuc.getInstancia().validateRUC(identificacion);
			}
		} else {
			pasaValidacion = ValidatorRuc.getInstancia().validateRUC(identificacion);
		}

		return pasaValidacion;
	}

	/**
	 * 
	 * <b> Permite cargar un archiv Excel y guardar la informacion en la Base de datos </b>
	 * <p>
	 * [Author: HIPERION, Date: 04/02/2016]
	 * </p>
	 * 
	 * @param event
	 */
	public void cargaArchivoExcel(FileUploadEvent event) {
		if (event.getFile() != null) {
			try {
				UploadedFile file = event.getFile();
				POIFSFileSystem fsFileSystem = new POIFSFileSystem(file.getInputstream());
				HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
				lecturaExcel(workBook);
			} catch (Exception e) {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("msg.error.archivo.vacio"));
			}
		} else {
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("msg.error.archivo.vacio"));
		}
	}

	/**
	 * 
	 * <b> Se encarga de procesar los datos del archivo excel a memoria. </b>
	 * <p>
	 * [Author: HIPERION, Date: 04/02/2016]
	 * </p>
	 * 
	 * @param archivoXLS
	 */
	public void lecturaExcel(HSSFWorkbook archivoXLS) {

		save = true;

		HSSFSheet hssfSheet = archivoXLS.getSheetAt(0);
		Iterator<Row> rowIterator = hssfSheet.rowIterator();

		int contador = 1;
		while (rowIterator.hasNext()) {
			HSSFRow hssfRow = (HSSFRow) rowIterator.next();
			Cliente cliente = new Cliente();
			Direccion direccion = new Direccion();
			try {

				if (hssfRow.getCell(0).getStringCellValue().contentEquals("TIPO PERSONA")) {
					hssfRow = (HSSFRow) rowIterator.next();
				}

				String tipoPersona = hssfRow.getCell(0).getStringCellValue();
				String tipoIdentificacion = hssfRow.getCell(1).getStringCellValue();
				String primerNombre = hssfRow.getCell(2).getStringCellValue();
				String segundoNombre = hssfRow.getCell(3).getStringCellValue();
				String apellidoPaterno = hssfRow.getCell(4).getStringCellValue();
				String apellidoMaterno = hssfRow.getCell(5).getStringCellValue();
				String identificacion = hssfRow.getCell(6).toString();
				Date fechaNacimiento = hssfRow.getCell(7).getDateCellValue();
				String razonSocial = hssfRow.getCell(8).getStringCellValue();
				String provinciaExcel = hssfRow.getCell(9).getStringCellValue();
				String callePrincipal = hssfRow.getCell(10).getStringCellValue();
				String numeracion = hssfRow.getCell(11).getStringCellValue();
				String calleSecundaria = hssfRow.getCell(12).getStringCellValue();
				String referencia = hssfRow.getCell(13).getStringCellValue();
				String telefono = hssfRow.getCell(14).getStringCellValue();
				String mail = hssfRow.getCell(15).getStringCellValue();

				cliente.setTipoPersona(tipoPersona);
				cliente.setTipoIdentificacion(tipoIdentificacion);
				cliente.setNombrePersona(primerNombre + " " + segundoNombre);
				cliente.setApellidoPaterno(apellidoPaterno);
				cliente.setApellidoMaterno(apellidoMaterno);
				cliente.setRazonSocial(razonSocial);
				cliente.setIdentificacionPersona(identificacion);
				cliente.setFechaNacimiento(fechaNacimiento);

				// DIRECCION
				Provincia provincia = new Provincia();
				Long idProvincia = new Long(provinciaExcel);
				provincia = direccionService.obtenerProvinciaById(idProvincia);

				direccion.setProvincia(provincia);
				direccion.setCallePrincipal(callePrincipal);
				direccion.setNumeracion(numeracion);
				direccion.setCalleSecundaria(calleSecundaria);
				direccion.setReferencia(referencia);

				// CONTACTOS
				List<Contacto> contactos = new ArrayList<>();
				Contacto contactoTelf = new Contacto();
				contactoTelf.setTipoContacto("TELEFONO");
				contactoTelf.setDescripcionContacto(telefono);

				Contacto contactoMail = new Contacto();
				contactoMail.setTipoContacto("MAIL");
				contactoMail.setDescripcionContacto(mail);

				cliente.setIdUsuarioCreacion(usuario.getIdUsuario());
				cliente.setFechaCreacion(new Date());
				cliente.setEstado(EstadoEnum.A);

				List<Cliente> clientesTemp = clienteService.consultarClientes();
				cliente.setCodigoCliente(EmisionUtil.obtenerCodigoCliente(clientesTemp.size() + 1));

				clienteService.guardarCliente(cliente, save);

				List<Direccion> direcciones = new ArrayList<>();
				direccion.setCliente(cliente);
				direcciones.add(direccion);
				cliente.setDireccions(direcciones);

				direccionService.guardarDirecciones(direcciones);

				contactoTelf.setCliente(cliente);
				contactoMail.setCliente(cliente);
				contactos.add(contactoTelf);
				contactos.add(contactoMail);
				clienteService.guardarContactos(contactos);

			} catch (Exception e) {
				log.error("Error al cargar la fila: " + contador + "causa: " + e);

			}
			contador++;

		}

	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	/**
	 * @return the direccionBean
	 */
	public DireccionBean getDireccionBean() {
		return direccionBean;
	}

	/**
	 * @param direccionBean
	 *            the direccionBean to set
	 */
	public void setDireccionBean(DireccionBean direccionBean) {
		this.direccionBean = direccionBean;
	}

	/**
	 * @return the contactoBean
	 */
	public ContactoBean getContactoBean() {
		return contactoBean;
	}

	/**
	 * @param contactoBean
	 *            the contactoBean to set
	 */
	public void setContactoBean(ContactoBean contactoBean) {
		this.contactoBean = contactoBean;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean getActivarPanelPersonaNatural() {
		return activarPanelPersonaNatural;
	}

	public void setActivarPanelPersonaNatural(boolean activarPanelPersonaNatural) {
		this.activarPanelPersonaNatural = activarPanelPersonaNatural;
	}

	public boolean getActivarPanelPersonaJuridica() {
		return activarPanelPersonaJuridica;
	}

	public void setActivarPanelPersonaJuridica(boolean activarPanelPersonaJuridica) {
		this.activarPanelPersonaJuridica = activarPanelPersonaJuridica;
	}

	/**
	 * @return the activarPanelDireccionDomicilio
	 */
	public boolean getActivarPanelDireccionDomicilio() {
		return activarPanelDireccionDomicilio;
	}

	/**
	 * @param activarPanelDireccionDomicilio
	 *            the activarPanelDireccionDomicilio to set
	 */
	public void setActivarPanelDireccionDomicilio(boolean activarPanelDireccionDomicilio) {
		this.activarPanelDireccionDomicilio = activarPanelDireccionDomicilio;
	}

	/**
	 * @return the activarPanelDireccionCobro
	 */
	public boolean getActivarPanelDireccionCobro() {
		return activarPanelDireccionCobro;
	}

	/**
	 * @param activarPanelDireccionCobro
	 *            the activarPanelDireccionCobro to set
	 */
	public void setActivarPanelDireccionCobro(boolean activarPanelDireccionCobro) {
		this.activarPanelDireccionCobro = activarPanelDireccionCobro;
	}

	/**
	 * @return the activarPanelDireccionOficina
	 */
	public boolean getActivarPanelDireccionOficina() {
		return activarPanelDireccionOficina;
	}

	/**
	 * @param activarPanelDireccionOficina
	 *            the activarPanelDireccionOficina to set
	 */
	public void setActivarPanelDireccionOficina(boolean activarPanelDireccionOficina) {
		this.activarPanelDireccionOficina = activarPanelDireccionOficina;
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
	 * @return the direccionesDTO
	 */
	public List<DireccionDTO> getDireccionesDTO() {
		return direccionesDTO;
	}

	/**
	 * @param direccionesDTO
	 *            the direccionesDTO to set
	 */
	public void setDireccionesDTO(List<DireccionDTO> direccionesDTO) {
		this.direccionesDTO = direccionesDTO;
	}

}
