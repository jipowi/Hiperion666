/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Mar 2, 2014
 * @since JDK1.6
 */
public class ObjetoAseguradoResponsabilidadDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private String descripcionObjeto;

	/**
	 * @param numeroItem
	 * @param ubicacionRiesgo
	 * @param direccion
	 * @param descripcionObjeto
	 */
	public ObjetoAseguradoResponsabilidadDTO(Integer numeroItem, String ubicacionRiesgo, String descripcionObjeto) {
		super();
		this.numeroItem = numeroItem;
		this.ubicacionRiesgo = ubicacionRiesgo;
		this.descripcionObjeto = descripcionObjeto;
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

}
