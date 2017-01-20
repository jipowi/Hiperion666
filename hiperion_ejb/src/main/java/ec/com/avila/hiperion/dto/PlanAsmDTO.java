/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;

/**
 * <b> Permite manejar la informaciín de los palanes del ramo accidentes personales </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,07/01/2015
 * @since JDK1.6
 */
public class PlanAsmDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nomPlan;
	private Double valorPlan;

	/**
	 * @param nomPlan
	 * @param valorPlan
	 */
	public PlanAsmDTO(String nomPlan, Double valorPlan) {
		super();
		this.nomPlan = nomPlan;
		this.valorPlan = valorPlan;
	}

	/**
	 * @return the nomPlan
	 */
	public String getNomPlan() {
		return nomPlan;
	}

	/**
	 * @param nomPlan
	 *            the nomPlan to set
	 */
	public void setNomPlan(String nomPlan) {
		this.nomPlan = nomPlan;
	}

	/**
	 * @return the valorPlan
	 */
	public Double getValorPlan() {
		return valorPlan;
	}

	/**
	 * @param valorPlan
	 *            the valorPlan to set
	 */
	public void setValorPlan(Double valorPlan) {
		this.valorPlan = valorPlan;
	}

}
