
package ec.com.avila.hiperion.dto;

import java.io.Serializable;

/**
 * <b> Permite presentar las claususlas adicionales con un checkBox de seleccion. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,31/05/2015
 * @since JDK1.6
 */
public class ClausulaAdicionalDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String clausula;
	private Boolean seleccion;
	private Integer numDias;
	
	

	/**
	 * @return the numDias
	 */
	public Integer getNumDias() {
		return numDias;
	}

	/**
	 * @param numDias the numDias to set
	 */
	public void setNumDias(Integer numDias) {
		this.numDias = numDias;
	}

	/**
	 * @return the clausula
	 */
	public String getClausula() {
		return clausula;
	}

	/**
	 * @param clausula
	 *            the clausula to set
	 */
	public void setClausula(String clausula) {
		this.clausula = clausula;
	}

	/**
	 * @return the seleccion
	 */
	public Boolean getSeleccion() {
		return seleccion;
	}

	/**
	 * @param seleccion
	 *            the seleccion to set
	 */
	public void setSeleccion(Boolean seleccion) {
		this.seleccion = seleccion;
	}

}
