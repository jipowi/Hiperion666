/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoSoatBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private String asegurado;
	private String tipoVehiculo;
	private String marca;
	private String modelo;
	private String color;
	private String placa;
	private String tipoSoat;
	private Integer pasajeros;
	private String chasis;
	private Integer anio;
	private Integer cilindraje;
	private String fileCertificado;

	// Tabla Cobertura
	private String cobertura;
	private BigDecimal valor;

	// Getters and Setters

	/**
	 * @return the asegurado
	 */
	public String getAsegurado() {
		return asegurado;
	}

	/**
	 * @param asegurado
	 *            the asegurado to set
	 */
	public void setAsegurado(String asegurado) {
		this.asegurado = asegurado;
	}

	/**
	 * @return the tipoVehiculo
	 */
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	/**
	 * @param tipoVehiculo
	 *            the tipoVehiculo to set
	 */
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
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

	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa
	 *            the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return the tipoSoat
	 */
	public String getTipoSoat() {
		return tipoSoat;
	}

	/**
	 * @param tipoSoat the tipoSoat to set
	 */
	public void setTipoSoat(String tipoSoat) {
		this.tipoSoat = tipoSoat;
	}

	/**
	 * @return the pasajeros
	 */
	public Integer getPasajeros() {
		return pasajeros;
	}

	/**
	 * @param pasajeros the pasajeros to set
	 */
	public void setPasajeros(Integer pasajeros) {
		this.pasajeros = pasajeros;
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
	 * @return the cilindraje
	 */
	public Integer getCilindraje() {
		return cilindraje;
	}

	/**
	 * @param cilindraje
	 *            the cilindraje to set
	 */
	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}

	/**
	 * @return the fileCertificado
	 */
	public String getFileCertificado() {
		return fileCertificado;
	}

	/**
	 * @param fileCertificado
	 *            the fileCertificado to set
	 */
	public void setFileCertificado(String fileCertificado) {
		this.fileCertificado = fileCertificado;
	}

	/**
	 * @return the cobertura
	 */
	public String getCobertura() {
		return cobertura;
	}

	/**
	 * @param cobertura
	 *            the cobertura to set
	 */
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
