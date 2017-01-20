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
public class DeducibleRoboBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal porcentajeSiniestroRobo;
	private BigDecimal porcentajeSiniestroHurto;
	private BigDecimal porcentajeSiniestroPropiedad;
	private BigDecimal minimoRobo;
	private BigDecimal minimoHurto;
	private BigDecimal minimoPropiedad;

	public DeducibleRoboBean(BigDecimal porcentajeSiniestroRobo, BigDecimal porcentajeSiniestroHurto, BigDecimal porcentajeSiniestroPropiedad,
			BigDecimal minimoRobo, BigDecimal minimoHurto, BigDecimal minimoPropiedad) {
		super();
		this.porcentajeSiniestroRobo = porcentajeSiniestroRobo;
		this.porcentajeSiniestroHurto = porcentajeSiniestroHurto;
		this.porcentajeSiniestroPropiedad = porcentajeSiniestroPropiedad;
		this.minimoRobo = minimoRobo;
		this.minimoHurto = minimoHurto;
		this.minimoPropiedad = minimoPropiedad;
	}

	/**
	 * @return the porcentajeSiniestroRobo
	 */
	public BigDecimal getPorcentajeSiniestroRobo() {
		return porcentajeSiniestroRobo;
	}

	/**
	 * @param porcentajeSiniestroRobo the porcentajeSiniestroRobo to set
	 */
	public void setPorcentajeSiniestroRobo(BigDecimal porcentajeSiniestroRobo) {
		this.porcentajeSiniestroRobo = porcentajeSiniestroRobo;
	}

	/**
	 * @return the porcentajeSiniestroHurto
	 */
	public BigDecimal getPorcentajeSiniestroHurto() {
		return porcentajeSiniestroHurto;
	}

	/**
	 * @param porcentajeSiniestroHurto the porcentajeSiniestroHurto to set
	 */
	public void setPorcentajeSiniestroHurto(BigDecimal porcentajeSiniestroHurto) {
		this.porcentajeSiniestroHurto = porcentajeSiniestroHurto;
	}

	

	/**
	 * @return the porcentajeSiniestroPropiedad
	 */
	public BigDecimal getPorcentajeSiniestroPropiedad() {
		return porcentajeSiniestroPropiedad;
	}

	/**
	 * @param porcentajeSiniestroPropiedad the porcentajeSiniestroPropiedad to set
	 */
	public void setPorcentajeSiniestroPropiedad(BigDecimal porcentajeSiniestroPropiedad) {
		this.porcentajeSiniestroPropiedad = porcentajeSiniestroPropiedad;
	}

	/**
	 * @return the minimoRobo
	 */
	public BigDecimal getMinimoRobo() {
		return minimoRobo;
	}

	/**
	 * @param minimoRobo the minimoRobo to set
	 */
	public void setMinimoRobo(BigDecimal minimoRobo) {
		this.minimoRobo = minimoRobo;
	}

	/**
	 * @return the minimoHurto
	 */
	public BigDecimal getMinimoHurto() {
		return minimoHurto;
	}

	/**
	 * @param minimoHurto the minimoHurto to set
	 */
	public void setMinimoHurto(BigDecimal minimoHurto) {
		this.minimoHurto = minimoHurto;
	}

	/**
	 * @return the minimoPropiedad
	 */
	public BigDecimal getMinimoPropiedad() {
		return minimoPropiedad;
	}

	/**
	 * @param minimoPropiedad the minimoPropiedad to set
	 */
	public void setMinimoPropiedad(BigDecimal minimoPropiedad) {
		this.minimoPropiedad = minimoPropiedad;
	}
	
}
