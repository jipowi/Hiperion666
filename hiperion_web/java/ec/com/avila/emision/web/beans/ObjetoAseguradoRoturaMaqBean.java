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
public class ObjetoAseguradoRoturaMaqBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private String direccion;
	private String giroNegocio;
	private String descripcionObjeto;
	private String maquinariaAsegurada;
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
	public ObjetoAseguradoRoturaMaqBean(Integer numeroItem, String ubicacionRiesgo, String direccion, String giroNegocio, String descripcionObjeto,
			String maquinariaAsegurada, BigDecimal total) {

		this.numeroItem = numeroItem;
		this.ubicacionRiesgo = ubicacionRiesgo;
		this.direccion = direccion;
		this.giroNegocio = giroNegocio;
		this.descripcionObjeto = descripcionObjeto;
		this.maquinariaAsegurada = maquinariaAsegurada;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the giroNegocio
	 */
	public String getGiroNegocio() {
		return giroNegocio;
	}

	/**
	 * @param giroNegocio
	 *            the giroNegocio to set
	 */
	public void setGiroNegocio(String giroNegocio) {
		this.giroNegocio = giroNegocio;
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
	 * @return the maquinariaAsegurada
	 */
	public String getMaquinariaAsegurada() {
		return maquinariaAsegurada;
	}

	/**
	 * @param maquinariaAsegurada
	 *            the maquinariaAsegurada to set
	 */
	public void setMaquinariaAsegurada(String maquinariaAsegurada) {
		this.maquinariaAsegurada = maquinariaAsegurada;
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
