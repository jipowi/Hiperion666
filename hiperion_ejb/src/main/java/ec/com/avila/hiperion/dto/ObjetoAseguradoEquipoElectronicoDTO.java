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
public class ObjetoAseguradoEquipoElectronicoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private String descripcion;
	private String detalle;
	private BigDecimal valorObjeto;

	/**
	 * @param numeroItem
	 * @param ubicacionRiesgo
	 * @param descripcion
	 * @param detalle
	 * @param valorObjeto
	 */
	public ObjetoAseguradoEquipoElectronicoDTO(Integer numeroItem, String ubicacionRiesgo, String descripcion, String detalle, BigDecimal valorObjeto) {
		super();
		this.numeroItem = numeroItem;
		this.ubicacionRiesgo = ubicacionRiesgo;
		this.descripcion = descripcion;
		this.detalle = detalle;
		this.valorObjeto = valorObjeto;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the valorObjeto
	 */
	public BigDecimal getValorObjeto() {
		return valorObjeto;
	}

	/**
	 * @param valorObjeto
	 *            the valorObjeto to set
	 */
	public void setValorObjeto(BigDecimal valorObjeto) {
		this.valorObjeto = valorObjeto;
	}

}
