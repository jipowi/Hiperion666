package ec.com.avila.hiperion.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b> Permite presentar las claususlas adicionales con un checkBox de seleccion. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,31/05/2015
 * @since JDK1.6
 */
public class CoberturaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cobertura;
	private Boolean seleccion;
	private BigDecimal valorCobertura;

	/**
	 * @return the valorCobertura
	 */
	public BigDecimal getValorCobertura() {
		return valorCobertura;
	}

	/**
	 * @param valorCobertura
	 *            the valorCobertura to set
	 */
	public void setValorCobertura(BigDecimal valorCobertura) {
		this.valorCobertura = valorCobertura;
	}

	/**
	 * @return the cobertura
	 */
	public String getCobertura() {
		return cobertura;
	}

	/**
	 * @param cobertura
	 *            the cobertura to set
	 */
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
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
