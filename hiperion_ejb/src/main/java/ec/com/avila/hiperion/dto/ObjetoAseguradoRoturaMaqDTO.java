/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Mar 2, 2014
 * @since JDK1.6
 */
public class ObjetoAseguradoRoturaMaqDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private String descripcionObjeto;
	private BigDecimal total;

	/**
	 * @param numeroItem
	 * @param ubicacionRiesgo
	 * @param direccion
	 * @param giroNegocio
	 * @param descripcionObjeto
	 * @param maquinariaAsegurada
	 * @param total
	 */
	public ObjetoAseguradoRoturaMaqDTO(Integer numeroItem, String ubicacionRiesgo, String descripcionObjeto, BigDecimal total) {

		this.numeroItem = numeroItem;
		this.ubicacionRiesgo = ubicacionRiesgo;
		this.descripcionObjeto = descripcionObjeto;
		this.total = total;
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
	 * @return the descripcionObjeto
	 */
	public String getDescripcionObjeto() {
		return descripcionObjeto;
	}

	/**
	 * @param descripcionObjeto
	 *            the descripcionObjeto to set
	 */
	public void setDescripcionObjeto(String descripcionObjeto) {
		this.descripcionObjeto = descripcionObjeto;
	}


	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
