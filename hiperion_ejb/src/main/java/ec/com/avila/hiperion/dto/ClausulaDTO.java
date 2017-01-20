/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;

/**
 * <b> Permite presentar las claususlas con un checkBox de seleccion. </b>
 * 
 * @author Franklin Pozo B.
 * @version 1.0,10/06/2015
 * @since JDK1.6
 */
public class ClausulaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public String clausula;
	public Integer numDias;

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
	 * @return the numDias
	 */
	public Integer getNumDias() {
		return numDias;
	}

	/**
	 * @param numDias
	 *            the numDias to set
	 */
	public void setNumDias(Integer numDias) {
		this.numDias = numDias;
	}

}
