/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;

/**
 * 
 * <b> Permite presentar las Condiciones particulares con un checkBox de seleccion. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/06/2015
 * @since JDK1.6
 */
public class CondicionParticularDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	public String condicionParticular;
	private Boolean seleccion;

	/**
	 * @return the condicionParticular
	 */
	public String getCondicionParticular() {
		return condicionParticular;
	}

	/**
	 * @param condicionParticular
	 *            the condicionParticular to set
	 */
	public void setCondicionParticular(String condicionParticular) {
		this.condicionParticular = condicionParticular;
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
