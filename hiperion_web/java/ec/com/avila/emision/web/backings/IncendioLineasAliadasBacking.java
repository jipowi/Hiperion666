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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ec.com.avila.emision.web.beans.DetalleAnexoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.DetalleAnexo;
import ec.com.avila.hiperion.entities.Ramo;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.model.AnexosDataModel;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Incendio y/o Lineas
 * Aliadas. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class IncendioLineasAliadasBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private RamoService ramoService;

	private AnexosDataModel anexosDataModel;
	private List<DetalleAnexo> anexos;

	private List<DetalleAnexoBean> clausulasAdicionales;
	private List<DetalleAnexoBean> coberturas;
	private List<DetalleAnexoBean> coberturasAdicionales;
	private List<DetalleAnexoBean> condicionesEspecialesDineroValor;
	private List<DetalleAnexoBean> condicionesEspecialesEdificioInstalaciones;
	private List<DetalleAnexoBean> condicionesMaquinariaEquipos;
	private List<DetalleAnexoBean> condicionesActivosFlotantes;
	private List<DetalleAnexoBean> condicionesMueblesEnseres;
	private DetalleAnexoBean[] selectClausulasAdicionales;
	private DetalleAnexoBean[] selectCoberturas;
	private DetalleAnexoBean[] selectCoberturasAdicionales;
	private DetalleAnexoBean[] selectCondicionesEspecialesDineroValor;
	private DetalleAnexoBean[] selectCondicionesEspecialesEdificioInstalaciones;
	private DetalleAnexoBean[] selectCondicionesMaquinariaEquipos;
	private DetalleAnexoBean[] selectCondicionesActivosFlotantes;
	private DetalleAnexoBean[] selectCondicionesMueblesEnseres;

	@PostConstruct
	public void inicializar() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("ILA");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Clausulas Adicionales del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerClausulasAdicionales() {
		clausulasAdicionales = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1)
					clausulasAdicionales.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(clausulasAdicionales);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCoberturas() {
		coberturas = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2)
					coberturas.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(coberturas);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas Adicionales del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCoberturasAdicionales() {
		coberturasAdicionales = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 6)
					coberturasAdicionales.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(coberturasAdicionales);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Condiciones Especiales con titulo Dinero y Valores del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCondicionesEspecialesDineroValores() {
		condicionesEspecialesDineroValor = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3 && anexo.getTitulo().getIdTitulo() == 8)
					condicionesEspecialesDineroValor.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(condicionesEspecialesDineroValor);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Condiciones Especiales Edificio e Instalaciones del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCondicionesEspecialesEdificioInstalaciones() {
		condicionesEspecialesEdificioInstalaciones = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3 && anexo.getTitulo().getIdTitulo() == 9)
					condicionesEspecialesEdificioInstalaciones.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(condicionesEspecialesEdificioInstalaciones);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Condiciones Especiales con titulo Maquinaria y Equipos del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCondicionesMaquinariaEquipos() {
		condicionesMaquinariaEquipos = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3 && anexo.getTitulo().getIdTitulo() == 10)
					condicionesMaquinariaEquipos.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(condicionesMaquinariaEquipos);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Condiciones Especiales con titulo Mercaderias y/o Activos Flotantes del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCondicionesActivosFlotantes() {
		condicionesActivosFlotantes = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3 && anexo.getTitulo().getIdTitulo() == 11)
					condicionesActivosFlotantes.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(condicionesActivosFlotantes);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Condiciones Especiales con titulo Muebles, Enseres y Equipos de Oficina del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCondicionesMueblesEnseres() {
		condicionesMueblesEnseres = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3 && anexo.getTitulo().getIdTitulo() == 12)
					condicionesMueblesEnseres.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(condicionesMueblesEnseres);
		}

		return anexosDataModel;
	}

	public void guardar() {
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * @return the selectCoberturas
	 */
	public DetalleAnexoBean[] getSelectCoberturas() {
		return selectCoberturas;
	}

	/**
	 * @param selectCoberturas
	 *            the selectCoberturas to set
	 */
	public void setSelectCoberturas(DetalleAnexoBean[] selectCoberturas) {
		this.selectCoberturas = selectCoberturas;
	}

	/**
	 * @return the selectClausulasAdicionales
	 */
	public DetalleAnexoBean[] getSelectClausulasAdicionales() {
		return selectClausulasAdicionales;
	}

	/**
	 * @param selectClausulasAdicionales
	 *            the selectClausulasAdicionales to set
	 */
	public void setSelectClausulasAdicionales(DetalleAnexoBean[] selectClausulasAdicionales) {
		this.selectClausulasAdicionales = selectClausulasAdicionales;
	}

	/**
	 * @return the selectCoberturasAdicionales
	 */
	public DetalleAnexoBean[] getSelectCoberturasAdicionales() {
		return selectCoberturasAdicionales;
	}

	/**
	 * @param selectCoberturasAdicionales
	 *            the selectCoberturasAdicionales to set
	 */
	public void setSelectCoberturasAdicionales(DetalleAnexoBean[] selectCoberturasAdicionales) {
		this.selectCoberturasAdicionales = selectCoberturasAdicionales;
	}

	/**
	 * @return the selectCondicionesEspecialesDineroValor
	 */
	public DetalleAnexoBean[] getSelectCondicionesEspecialesDineroValor() {
		return selectCondicionesEspecialesDineroValor;
	}

	/**
	 * @param selectCondicionesEspecialesDineroValor the selectCondicionesEspecialesDineroValor to set
	 */
	public void setSelectCondicionesEspecialesDineroValor(DetalleAnexoBean[] selectCondicionesEspecialesDineroValor) {
		this.selectCondicionesEspecialesDineroValor = selectCondicionesEspecialesDineroValor;
	}

	/**
	 * @return the selectCondicionesEspecialesEdificioInstalaciones
	 */
	public DetalleAnexoBean[] getSelectCondicionesEspecialesEdificioInstalaciones() {
		return selectCondicionesEspecialesEdificioInstalaciones;
	}

	/**
	 * @param selectCondicionesEspecialesEdificioInstalaciones the selectCondicionesEspecialesEdificioInstalaciones to set
	 */
	public void setSelectCondicionesEspecialesEdificioInstalaciones(DetalleAnexoBean[] selectCondicionesEspecialesEdificioInstalaciones) {
		this.selectCondicionesEspecialesEdificioInstalaciones = selectCondicionesEspecialesEdificioInstalaciones;
	}

	/**
	 * @return the selectCondicionesMaquinariaEquipos
	 */
	public DetalleAnexoBean[] getSelectCondicionesMaquinariaEquipos() {
		return selectCondicionesMaquinariaEquipos;
	}

	/**
	 * @param selectCondicionesMaquinariaEquipos the selectCondicionesMaquinariaEquipos to set
	 */
	public void setSelectCondicionesMaquinariaEquipos(DetalleAnexoBean[] selectCondicionesMaquinariaEquipos) {
		this.selectCondicionesMaquinariaEquipos = selectCondicionesMaquinariaEquipos;
	}

	/**
	 * @return the selectCondicionesActivosFlotantes
	 */
	public DetalleAnexoBean[] getSelectCondicionesActivosFlotantes() {
		return selectCondicionesActivosFlotantes;
	}

	/**
	 * @param selectCondicionesActivosFlotantes the selectCondicionesActivosFlotantes to set
	 */
	public void setSelectCondicionesActivosFlotantes(DetalleAnexoBean[] selectCondicionesActivosFlotantes) {
		this.selectCondicionesActivosFlotantes = selectCondicionesActivosFlotantes;
	}

	/**
	 * @return the selectCondicionesMueblesEnseres
	 */
	public DetalleAnexoBean[] getSelectCondicionesMueblesEnseres() {
		return selectCondicionesMueblesEnseres;
	}

	/**
	 * @param selectCondicionesMueblesEnseres the selectCondicionesMueblesEnseres to set
	 */
	public void setSelectCondicionesMueblesEnseres(DetalleAnexoBean[] selectCondicionesMueblesEnseres) {
		this.selectCondicionesMueblesEnseres = selectCondicionesMueblesEnseres;
	}
}