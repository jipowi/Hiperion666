/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;

/**
 * <b> Permite presentar las garantias de la poliza con un checkBox de seleccion. </b>
 * 
 * @author Franklin Pozo B.
 * @version 1.0,16/06/2015
 * @since JDK1.6
 */
public class GarantiaPolizaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String garantia;
	private Boolean seleccion;

	/**
	 * @return the garantia
	 */
	public String getGarantia() {
		return garantia;
	}

	/**
	 * @param garantia
	 *            the garantia to set
	 */
	public void setGarantia(String garantia) {
		this.garantia = garantia;
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
