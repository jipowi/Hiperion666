/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.com.avila.emision.web.beans.AnexosRamoBean;
import ec.com.avila.emision.web.domain.ClausulaAdicional;
import ec.com.avila.emision.web.domain.Cobertura;
import ec.com.avila.emision.web.domain.CondicionEspecial;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.DetalleAnexo;
import ec.com.avila.hiperion.entities.Ramo;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo ACCIDENTES PERSONALES. </b>
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

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;
	@ManagedProperty(value = "#{anexosRamoBean}")
	private AnexosRamoBean anexosRamoBean;

	private List<DetalleAnexo> anexos;
	private List<ClausulaAdicional> clausulasAdicionales;
	private List<ClausulaAdicional> selectClausulasAdicionales;
	private List<Cobertura> coberturas;
	private List<Cobertura> selectCoberturas;
	private List<CondicionEspecial> condicionesEspeciales;
	private List<CondicionEspecial> selectCondicionesEspeciales;

	@PostConstruct
	public void init() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("AP");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
		}

		clausulasAdicionales = anexosRamoBean.obtenerClausulasAdicionales(anexos);
		coberturas = anexosRamoBean.obtenerCoberturas(anexos);
		condicionesEspeciales = anexosRamoBean.obtenerCondicionesEspeciales(anexos);
	}

	public void guardar() {
		// Clausulas Adicionales
		if (getSelectClausulasAdicionales() != null && getSelectClausulasAdicionales().size() > 0) {
			System.out.println("Clausulas Adicionales");
			for (ClausulaAdicional clausula : getSelectClausulasAdicionales()) {
				System.out.println(clausula);
			}
		}

		// Coberturas
		if (getSelectCoberturas() != null && getSelectCoberturas().size() > 0) {
			System.out.println("Coberturas");
			for (Cobertura cobertura : getSelectCoberturas()) {
				System.out.println(cobertura);
			}
		}

		// Condiciones Especiales
		if (getSelectCondicionesEspeciales() != null && getSelectCondicionesEspeciales().size() > 0) {
			System.out.println("Condiciones Especiales");
			for (CondicionEspecial condicionEspecial : getSelectCondicionesEspeciales()) {
				System.out.println(condicionEspecial);
			}
		}
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
	 * @return the anexosRamoBean
	 */
	public AnexosRamoBean getAnexosRamoBean() {
		return anexosRamoBean;
	}

	/**
	 * @param anexosRamoBean
	 *            the anexosRamoBean to set
	 */
	public void setAnexosRamoBean(AnexosRamoBean anexosRamoBean) {
		this.anexosRamoBean = anexosRamoBean;
	}

	/**
	 * @return the clausulasAdicionales
	 */
	public List<ClausulaAdicional> getClausulasAdicionales() {
		return clausulasAdicionales;
	}

	/**
	 * @return the selectClausulasAdicionales
	 */
	public List<ClausulaAdicional> getSelectClausulasAdicionales() {
		return selectClausulasAdicionales;
	}

	/**
	 * @param selectClausulasAdicionales
	 *            the selectClausulasAdicionales to set
	 */
	public void setSelectClausulasAdicionales(List<ClausulaAdicional> selectClausulasAdicionales) {
		this.selectClausulasAdicionales = selectClausulasAdicionales;
	}

	/**
	 * @return the selectCoberturas
	 */
	public List<Cobertura> getSelectCoberturas() {
		return selectCoberturas;
	}

	/**
	 * @param selectCoberturas
	 *            the selectCoberturas to set
	 */
	public void setSelectCoberturas(List<Cobertura> selectCoberturas) {
		this.selectCoberturas = selectCoberturas;
	}

	/**
	 * @return the coberturas
	 */
	public List<Cobertura> getCoberturas() {
		return coberturas;
	}

	/**
	 * @return the selectCondicionesEspeciales
	 */
	public List<CondicionEspecial> getSelectCondicionesEspeciales() {
		return selectCondicionesEspeciales;
	}

	/**
	 * @param selectCondicionesEspeciales
	 *            the selectCondicionesEspeciales to set
	 */
	public void setSelectCondicionesEspeciales(List<CondicionEspecial> selectCondicionesEspeciales) {
		this.selectCondicionesEspeciales = selectCondicionesEspeciales;
	}

	/**
	 * @return the condicionesEspeciales
	 */
	public List<CondicionEspecial> getCondicionesEspeciales() {
		return condicionesEspeciales;
	}
}
