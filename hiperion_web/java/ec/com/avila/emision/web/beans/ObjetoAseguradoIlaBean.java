/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Mar 2, 2014
 * @since JDK1.6
 */
public class ObjetoAseguradoIlaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private String detalle;
	private BigDecimal valor;

	public ObjetoAseguradoIlaBean(Integer numeroItem, String ubicacionRiesgo, String detalle, BigDecimal valor) {
		super();
		this.numeroItem = numeroItem;
		this.ubicacionRiesgo = ubicacionRiesgo;
		this.detalle = detalle;
		this.valor = valor;
	}

	/**
	 * @return the numeroItem
	 */
	public Integer getNumeroItem() {
		return numeroItem;
	}

	/**
	 * @param numeroItem
	 *            the numeroItem to set
	 */
	public void setNumeroItem(Integer numeroItem) {
		this.numeroItem = numeroItem;
	}

	/**
	 * @return the ubicacionRiesgo
	 */
	public String getUbicacionRiesgo() {
		return ubicacionRiesgo;
	}

	/**
	 * @param ubicacionRiesgo
	 *            the ubicacionRiesgo to set
	 */
	public void setUbicacionRiesgo(String ubicacionRiesgo) {
		this.ubicacionRiesgo = ubicacionRiesgo;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle
	 *            the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
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

}
