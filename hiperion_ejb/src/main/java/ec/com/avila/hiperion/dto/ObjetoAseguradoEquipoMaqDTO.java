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
public class ObjetoAseguradoEquipoMaqDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer item;
	private String marca;
	private String modelo;
	private Integer anio;
	private String motor;
	private String chasis;
	private String color;
	private BigDecimal valorAsegurado;
	private String serie;

	/**
	 * @param item
	 * @param marca
	 * @param modelo
	 * @param anio
	 * @param motor
	 * @param chasis
	 * @param color
	 * @param valorAsegurado
	 * @param serie
	 */
	public ObjetoAseguradoEquipoMaqDTO(Integer item, String marca, String modelo, Integer anio, String motor, String chasis, String color, BigDecimal valorAsegurado, String serie) {
		super();
		this.item = item;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.motor = motor;
		this.chasis = chasis;
		this.color = color;
		this.valorAsegurado = valorAsegurado;
		this.serie = serie;
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

	/**
	 * @return the serie
	 */
	public String getSerie() {
		return serie;
	}

	/**
	 * @param serie
	 *            the serie to set
	 */
	public void setSerie(String serie) {
		this.serie = serie;
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
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca
	 *            the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 *            the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the anio
	 */
	public Integer getAnio() {
		return anio;
	}

	/**
	 * @param anio
	 *            the anio to set
	 */
	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	/**
	 * @return the motor
	 */
	public String getMotor() {
		return motor;
	}

	/**
	 * @param motor
	 *            the motor to set
	 */
	public void setMotor(String motor) {
		this.motor = motor;
	}

	/**
	 * @return the chasis
	 */
	public String getChasis() {
		return chasis;
	}

	/**
	 * @param chasis
	 *            the chasis to set
	 */
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

}
