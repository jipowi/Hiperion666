/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ec.com.avila.emision.web.beans.DetalleAnexoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.DetalleAnexo;
import ec.com.avila.hiperion.entities.Ramo;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.model.AnexosDataModel;

/**
 * <b> Clase que sirve de soporte para un objeto manejado dentro de la aplicacion, permite implementar los conportamientos especificos de la pagina
 * </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Feb 9, 2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class AsistenciaMedicaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private RamoService ramoService;

	private AnexosDataModel anexosDataModel;
	private List<DetalleAnexo> anexos;

	private List<DetalleAnexoBean> limitesCostosBeneficios;
	private List<DetalleAnexoBean> limitesCostosBenAdd;
	private List<DetalleAnexoBean> limitesCostosMaternidad;
	private DetalleAnexoBean[] selectLimitesCostosBeneficios;
	private DetalleAnexoBean[] selectLimitesCostosBenAdd;
	private DetalleAnexoBean[] selectLimitesCostosMaternidad;

	@PostConstruct
	public void inicializar() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("AM");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
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
	 */
	public AnexosDataModel obtenerLimitesCostosBeneficios() {
		limitesCostosBeneficios = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 4 && anexo.getTitulo().getIdTitulo() == 3)
					limitesCostosBeneficios.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(limitesCostosBeneficios);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener los Limites y Costos con titulo Maternidad del Ramo Asistencia Medica. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerLimitesCostosBenAdd() {
		limitesCostosBenAdd = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 4 && anexo.getTitulo().getIdTitulo() == 4)
					limitesCostosBenAdd.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(limitesCostosBenAdd);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener los Limites y Costos con titulo Beneficios Adicionales del Ramo Asistencia Medica. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerLimitesCostosMaternidad() {
		limitesCostosMaternidad = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 4 && anexo.getTitulo().getIdTitulo() == 5)
					limitesCostosMaternidad.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(limitesCostosMaternidad);
		}

		return anexosDataModel;
	}

	public void guardar() {
	}

	/**
	 * @return the selectLimitesCostosBeneficios
	 */
	public DetalleAnexoBean[] getSelectLimitesCostosBeneficios() {
		return selectLimitesCostosBeneficios;
	}

	/**
	 * @param selectLimitesCostosBeneficios
	 *            the selectLimitesCostosBeneficios to set
	 */
	public void setSelectLimitesCostosBeneficios(DetalleAnexoBean[] selectLimitesCostosBeneficios) {
		this.selectLimitesCostosBeneficios = selectLimitesCostosBeneficios;
	}

	/**
	 * @return the selectLimitesCostosBenAdd
	 */
	public DetalleAnexoBean[] getSelectLimitesCostosBenAdd() {
		return selectLimitesCostosBenAdd;
	}

	/**
	 * @param selectLimitesCostosBenAdd
	 *            the selectLimitesCostosBenAdd to set
	 */
	public void setSelectLimitesCostosBenAdd(DetalleAnexoBean[] selectLimitesCostosBenAdd) {
		this.selectLimitesCostosBenAdd = selectLimitesCostosBenAdd;
	}

	/**
	 * @return the selectLimitesCostosMaternidad
	 */
	public DetalleAnexoBean[] getSelectLimitesCostosMaternidad() {
		return selectLimitesCostosMaternidad;
	}

	/**
	 * @param selectLimitesCostosMaternidad
	 *            the selectLimitesCostosMaternidad to set
	 */
	public void setSelectLimitesCostosMaternidad(DetalleAnexoBean[] selectLimitesCostosMaternidad) {
		this.selectLimitesCostosMaternidad = selectLimitesCostosMaternidad;
	}
}
