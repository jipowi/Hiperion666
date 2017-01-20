/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Mar 2, 2014
 * @since JDK1.6
 */
public class ObjetoAseguradoContratistaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer item;
	private String detalle;

	public ObjetoAseguradoContratistaBean(Integer item, String detalle) {
		this.item = item;
		this.detalle = detalle;
	}

	/**
	 * @return the item
	 */
	public Integer getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(Integer item) {
		this.item = item;
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
