/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * <b> Permite registrar las amortizaciones generadas de un valor determinado. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,15/01/2015
 * @since JDK1.6
 */
public class TablaAmortizacionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String letra;
	private Double valor;
	private Date fechaVencimiento;
	private Integer numeroLetra;

	/**
	 * @return the letra
	 */
	public String getLetra() {
		return letra;
	}

	/**
	 * @param letra
	 *            the letra to set
	 */
	public void setLetra(String letra) {
		this.letra = letra;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * @param fechaVencimiento
	 *            the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	/**
	 * @return the numeroLetra
	 */
	public Integer getNumeroLetra() {
		return numeroLetra;
	}

	/**
	 * @param numeroLetra
	 *            the numeroLetra to set
	 */
	public void setNumeroLetra(Integer numeroLetra) {
		this.numeroLetra = numeroLetra;
	}

}
