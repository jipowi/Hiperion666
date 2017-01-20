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
public class ObjetoAseguradoCesanteIlaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private String formaSeguro;
	private BigDecimal utilidad;
	private String detalle;

	public ObjetoAseguradoCesanteIlaDTO(Integer numeroItem, String ubicacionRiesgo, String formaSeguro, BigDecimal utilidad, String detalle) {
		super();
		this.numeroItem = numeroItem;
		this.ubicacionRiesgo = ubicacionRiesgo;
		this.formaSeguro = formaSeguro;
		this.utilidad = utilidad;
		this.detalle = detalle;
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
	 * @return the formaSeguro
	 */
	public String getFormaSeguro() {
		return formaSeguro;
	}

	/**
	 * @param formaSeguro
	 *            the formaSeguro to set
	 */
	public void setFormaSeguro(String formaSeguro) {
		this.formaSeguro = formaSeguro;
	}

	/**
	 * @return the utilidad
	 */
	public BigDecimal getUtilidad() {
		return utilidad;
	}

	/**
	 * @param utilidad
	 *            the utilidad to set
	 */
	public void setUtilidad(BigDecimal utilidad) {
		this.utilidad = utilidad;
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

}
