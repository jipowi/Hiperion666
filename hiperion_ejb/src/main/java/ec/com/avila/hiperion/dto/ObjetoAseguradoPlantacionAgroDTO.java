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
public class ObjetoAseguradoPlantacionAgroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String detalle;
	private String ubicacion;
	private BigDecimal valorAsegurado;

	
	public ObjetoAseguradoPlantacionAgroDTO() {
		super();
	}

	public ObjetoAseguradoPlantacionAgroDTO(String detalle, String ubicacion, BigDecimal valorAsegurado) {

		this.valorAsegurado = valorAsegurado;
		this.detalle = detalle;
		this.ubicacion = ubicacion;

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
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion
	 *            the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the valorAsegurado
	 */
	public BigDecimal getValorAsegurado() {
		return valorAsegurado;
	}

	/**
	 * @param valorAsegurado
	 *            the valorAsegurado to set
	 */
	public void setValorAsegurado(BigDecimal valorAsegurado) {
		this.valorAsegurado = valorAsegurado;
	}

}
