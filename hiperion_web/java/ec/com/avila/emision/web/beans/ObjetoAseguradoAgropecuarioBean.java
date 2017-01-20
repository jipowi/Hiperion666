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
public class ObjetoAseguradoAgropecuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer item;
	private String nombre;
	private String sexo;
	private String raza;
	private String color;
	private Integer edad;
	private BigDecimal montoAsegurado;
	private BigDecimal tasa;

	public ObjetoAseguradoAgropecuarioBean(Integer item, String nombre, String sexo, String raza, String color, Integer edad, BigDecimal montoAsegurado, BigDecimal tasa) {
		this.item = item;
		this.nombre = nombre;
		this.sexo = sexo;
		this.raza = raza;
		this.color = color;
		this.edad = edad;
		this.montoAsegurado = montoAsegurado;
		this.tasa = tasa;

	}

	/**
	 * @return the item
	 */
	public Integer getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Integer item) {
		this.item = item;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the raza
	 */
	public String getRaza() {
		return raza;
	}

	/**
	 * @param raza the raza to set
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	/**
	 * @return the montoAsegurado
	 */
	public BigDecimal getMontoAsegurado() {
		return montoAsegurado;
	}

	/**
	 * @param montoAsegurado the montoAsegurado to set
	 */
	public void setMontoAsegurado(BigDecimal montoAsegurado) {
		this.montoAsegurado = montoAsegurado;
	}

	/**
	 * @return the tasa
	 */
	public BigDecimal getTasa() {
		return tasa;
	}

	/**
	 * @param tasa the tasa to set
	 */
	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
	}

	
}
