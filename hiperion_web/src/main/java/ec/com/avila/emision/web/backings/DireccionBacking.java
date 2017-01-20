package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;

import ec.com.avila.emision.web.beans.DireccionBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.CantonDTO;
import ec.com.avila.hiperion.dto.DireccionDTO;
import ec.com.avila.hiperion.dto.ParroquiaDTO;
import ec.com.avila.hiperion.dto.ProvinciaDTO;
import ec.com.avila.hiperion.emision.entities.Provincia;
import ec.com.avila.hiperion.emision.entities.TipoDireccion;
import ec.com.avila.hiperion.servicio.ProvinciaService;
import ec.com.avila.hiperion.servicio.TipoDireccionService;

@ManagedBean(name = "direccionBacking")
@ViewScoped
public class DireccionBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{direccionBean}")
	private DireccionBean direccionBean;

	@EJB
	private TipoDireccionService tipoDireccionService;
	@EJB
	private ProvinciaService provinciaService;

	private List<ProvinciaDTO> provinciasDTO;
	private List<CantonDTO> cantonesDTO;
	private List<ParroquiaDTO> parroquiasDTO;
	private List<DireccionDTO> direcciones;
	private List<SelectItem> tipoDireccionItems;


	@PostConstruct
	public void inicializar() {
		obtenerProvincias();
		setDirecciones(new ArrayList<DireccionDTO>());
		direccionBean.setDireccionesRegistradas(new ArrayList<DireccionDTO>());
		obtenerTiposDireccion();
	}

	/**
	 * 
	 * <b> Permite obtener el catalogo de provincias. </b>
	 * <p>
	 * [Author: kruger, Date: Oct 4, 2016]
	 * </p>
	 * 
	 */
	public void obtenerProvincias() {
		try {
			this.provinciasDTO = new ArrayList<ProvinciaDTO>();
			List<Provincia> provincias = provinciaService.consultarProvincias();

			if (provincias != null && provincias.size() > 0) {
				for (Provincia provincia : provincias) {
					ProvinciaDTO provinciaDto = new ProvinciaDTO(provincia.getCodigo(), provincia.getNombreProvincia());
					provinciasDTO.add(provinciaDto);
				}

				ProvinciaDTO provinciaDto = provinciasDTO.get(0);
				direccionBean.setProvinciaDTO(provinciaDto);
			}
		} catch (HiperionException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite Obtener los Tipos de Direcci&oacute;n que se deben registrar en el sistema (Cobro, Domicilio y Oficina). </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 * @return - lista de direcciones de tipo SelectItem.
	 */
	public List<SelectItem> obtenerTiposDireccion() {
		try {
			this.tipoDireccionItems = new ArrayList<SelectItem>();
			List<TipoDireccion> tiposDireccion = tipoDireccionService.consultarTiposDireccion();
			for (TipoDireccion tipoDireccion : tiposDireccion) {
				SelectItem selectItem = new SelectItem(tipoDireccion.getCodigoTipoDireccion(), tipoDireccion.getDescTipoDireccion());
				tipoDireccionItems.add(selectItem);
			}
		} catch (HiperionException ex) {
			ex.printStackTrace();
		}

		return tipoDireccionItems;
	}



	/**
	 * 
	 * <b> Permite refrescar todos los campos que se solicita paara registrar una Direcci&oacute;n, ya que si existe una cancelaci&oacute;n la misma
	 * no debe ser registrada. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 12/08/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void cancelarDireccion() {
		// Permite refrescar el combo de Tipo Direccion.
		direccionBean.setCodTipoDireccion(null);
		RequestContext.getCurrentInstance().reset("direccionFormId:inputDireccionDlgId");
	}

	/**
	 * 
	 * <b> Permite eliminar una Direcci&oacute;n ya registrada para el Cliente. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 * @param tipoDireccion
	 *            - tipo de Direcci&oacte;n (Cobro, Domicilio o Oficina).
	 * @throws HiperionException
	 *             - Excepci&oacute;n del Servicio.
	 */
	public void eliminarDireccion(String tipoDireccion) {
		try {

			// Elimana de la lista de direcciones.
			for (int i = 0; i < direcciones.size(); i++) {
				if (direcciones.get(i).getTipoDireccion().equals(tipoDireccion))
					direcciones.remove(i);
			}

			// ELimina de la lista de Direcciones Regitradas (Direcciones que ya fueron Guardadas).
			if (direccionBean.getDireccionesRegistradas() != null && direccionBean.getDireccionesRegistradas().size() > 0) {
				for (int j = 0; j < direccionBean.getDireccionesRegistradas().size(); j++) {
					if (direccionBean.getDireccionesRegistradas().get(j).equals(tipoDireccion)) {
						direccionBean.getDireccionesRegistradas().remove(j);
					}

				}
			}

			// Obtenemos nuevamente el tipo de Direccion que ya fue Registrado en el Sistema para Guardarlo nuevamente de ser necesario.
			TipoDireccion direccion = tipoDireccionService.consultarTipoDireccionByDescripcion(tipoDireccion);
			SelectItem selectItem = new SelectItem(direccion.getCodigoTipoDireccion(), direccion.getDescTipoDireccion());
			tipoDireccionItems.add(selectItem);

			// Permite Ordenar la lista de tipos de Direccion.
			Collections.sort(tipoDireccionItems, new Comparator<SelectItem>() {
				public int compare(SelectItem selectItem1, SelectItem selectItem2) {
					String sItem1Label = selectItem1.getLabel();
					String sItem2Label = selectItem2.getLabel();
					return (sItem1Label.compareTo(sItem2Label));
				}
			});
		} catch (HiperionException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite cancelar la o las direcciones que se quiso guardar en el sistema. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 12/08/2014]
	 * </p>
	 * 
	 */
	public void cancelarDirecciones() {
		direcciones = new ArrayList<DireccionDTO>();
		if (direccionBean.getDireccionesRegistradas().size() > 0) {
			for (DireccionDTO direccionDto : direccionBean.getDireccionesRegistradas())
				direcciones.add(direccionDto);
			setTipoDireccionItems(obtenerTiposDireccionNoRegistradas(direcciones));
		} else {
			obtenerTiposDireccion();
		}

	}

	/**
	 * 
	 * <b> Permite obtener una lista de direcciones que aun no han sido registrada para el cliente.</b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 * @param direcciones
	 *            - lista de direcciones a ser registradas.
	 * @return
	 */
	private List<SelectItem> obtenerTiposDireccionNoRegistradas(List<DireccionDTO> direcciones) {
		List<SelectItem> tipoDireccionItems = obtenerTiposDireccion();
		for (DireccionDTO direccion : direcciones) {
			for (int i = 0; i < tipoDireccionItems.size(); i++) {
				if (direccion.getTipoDireccion().equals(tipoDireccionItems.get(i).getLabel())) {
					tipoDireccionItems.remove(i);
				}
			}
		}

		return tipoDireccionItems;
	}

	
	public void refresh() {
	}

	/**
	 * @return the provinciasDto
	 */
	public List<ProvinciaDTO> getProvinciasDTO() {
		return provinciasDTO;
	}

	/**
	 * @return the cantonesDto
	 */
	public List<CantonDTO> getCantonesDTO() {
		return cantonesDTO;
	}

	/**
	 * @return the direccionBean
	 */
	public DireccionBean getDireccionBean() {
		return direccionBean;
	}

	public List<ParroquiaDTO> getParroquiasDTO() {
		return parroquiasDTO;
	}

	/**
	 * @param direccionBean
	 *            the direccionBean to set
	 */
	public void setDireccionBean(DireccionBean direccionBean) {
		this.direccionBean = direccionBean;
	}

	/**
	 * @return the direcciones
	 */
	public List<DireccionDTO> getDirecciones() {
		return direcciones;
	}

	/**
	 * @param direcciones
	 *            the direcciones to set
	 */
	public void setDirecciones(List<DireccionDTO> direcciones) {
		this.direcciones = direcciones;
	}

	public List<SelectItem> getTipoDireccionItems() {
		return tipoDireccionItems;
	}

	public void setTipoDireccionItems(List<SelectItem> tipoDireccionItems) {
		this.tipoDireccionItems = tipoDireccionItems;
	}
}
