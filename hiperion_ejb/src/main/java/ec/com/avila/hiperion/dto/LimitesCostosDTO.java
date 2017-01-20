/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b> Permite presentar los limites y costos con un checkBox de seleccion </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,10/06/2015
 * @since JDK1.6
 */
public class LimitesCostosDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	public String limitesCostos;
	public BigDecimal valor;
	public Boolean seleccion;

	/**
	 * @return the limitesCostos
	 */
	public String getLimitesCostos() {
		return limitesCostos;
	}

	/**
	 * @param limitesCostos
	 *            the limitesCostos to set
	 */
	public void setLimitesCostos(String limitesCostos) {
		this.limitesCostos = limitesCostos;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
