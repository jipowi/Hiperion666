/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;

/**
 * <b> Permite presentar las Condiciones especiales con un checkBox de seleccion </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,10/06/2015
 * @since JDK1.6
 */
public class CondicionEspecialDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	public String condicionEspecial;
	private Boolean seleccion;

	/**
	 * @return the condicionEspecial
	 */
	public String getCondicionEspecial() {
		return condicionEspecial;
	}

	/**
	 * @param condicionEspecial
	 *            the condicionEspecial to set
	 */
	public void setCondicionEspecial(String condicionEspecial) {
		this.condicionEspecial = condicionEspecial;
	}

	/**
	 * @return the seleccion
	 */
	public Boolean getSeleccion() {
		return seleccion;
	}

	/**
	 * @param seleccion the seleccion to set
	 */
	public void setSeleccion(Boolean seleccion) {
		this.seleccion = seleccion;
	}

}
