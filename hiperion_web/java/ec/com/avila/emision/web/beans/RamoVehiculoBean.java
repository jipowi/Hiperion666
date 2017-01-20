/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,15/01/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class RamoVehiculoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Cabecera de la poliza
	private Integer item;
	private String propietario;
	private String nombreAsegurado;
	private String tipoVehiculo;
	private String detalleVehiculo;
	private String marca;
	private String modelo;
	private String detalleModelo;
	private String color;
	private String placa;
	private String motor;
	private String chasis;
	private Integer anio;
	private String actividad;
	private BigDecimal valorAseguradoCasco;
	private BigDecimal valorTotalItem;
	private BigDecimal tasa;
	private BigDecimal porcentajeDeducible;
	private BigDecimal porcentajeSiniestro;
	private BigDecimal minimoSiniestro;
	private BigDecimal porcentajeValorAsegurado;
	private String consideraciones;
	private String amparoPatrimonial;
	private String coberturaPactoAndino;
	private String asistenciaVehicular;
	private String autoSustituto;
	private String filePolizaVigente;
	private String fileCondicionesGenerales;

	// Tabla Coberturas vehiculos
	private String ceberturaVehiculo;
	private BigDecimal valorVehiculo;

	// Tabla Clausulas Adicional Vehiculos
	private String clausula;

	// Tabla condiciones especiales vehiculos
	private String condicion;

	// Tabla extras vehiculos
	private BigDecimal valor;

	// Getters and Setters
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
	 * @return the propietario
	 */
	public String getPropietario() {
		return propietario;
	}

	/**
	 * @param propietario
	 *            the propietario to set
	 */
	public void setPropietario(String propietario) {
		this.propietario = propietario;
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
	 * @return the detalleVehiculo
	 */
	public String getDetalleVehiculo() {
		return detalleVehiculo;
	}

	/**
	 * @param detalleVehiculo
	 *            the detalleVehiculo to set
	 */
	public void setDetalleVehiculo(String detalleVehiculo) {
		this.detalleVehiculo = detalleVehiculo;
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
	 * @return the detalleModelo
	 */
	public String getDetalleModelo() {
		return detalleModelo;
	}

	/**
	 * @param detalleModelo
	 *            the detalleModelo to set
	 */
	public void setDetalleModelo(String detalleModelo) {
		this.detalleModelo = detalleModelo;
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

	public String getNombreAsegurado() {
		return nombreAsegurado;
	}

	public void setNombreAsegurado(String nombreAsegurado) {
		this.nombreAsegurado = nombreAsegurado;
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
	 * @return the actividad
	 */
	public String getActividad() {
		return actividad;
	}

	/**
	 * @param actividad
	 *            the actividad to set
	 */
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	/**
	 * @return the valorAseguradoCasco
	 */
	public BigDecimal getValorAseguradoCasco() {
		return valorAseguradoCasco;
	}

	/**
	 * @param valorAseguradoCasco
	 *            the valorAseguradoCasco to set
	 */
	public void setValorAseguradoCasco(BigDecimal valorAseguradoCasco) {
		this.valorAseguradoCasco = valorAseguradoCasco;
	}

	/**
	 * @return the valorTotalItem
	 */
	public BigDecimal getValorTotalItem() {
		return valorTotalItem;
	}

	/**
	 * @param valorTotalItem
	 *            the valorTotalItem to set
	 */
	public void setValorTotalItem(BigDecimal valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
	}

	/**
	 * @return the tasa
	 */
	public BigDecimal getTasa() {
		return tasa;
	}

	/**
	 * @param tasa
	 *            the tasa to set
	 */
	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
	}

	/**
	 * @return the porcentajeDeducible
	 */
	public BigDecimal getPorcentajeDeducible() {
		return porcentajeDeducible;
	}

	/**
	 * @param porcentajeDeducible
	 *            the porcentajeDeducible to set
	 */
	public void setPorcentajeDeducible(BigDecimal porcentajeDeducible) {
		this.porcentajeDeducible = porcentajeDeducible;
	}

	/**
	 * @return the porcentajeSiniestro
	 */
	public BigDecimal getPorcentajeSiniestro() {
		return porcentajeSiniestro;
	}

	/**
	 * @param porcentajeSiniestro
	 *            the porcentajeSiniestro to set
	 */
	public void setPorcentajeSiniestro(BigDecimal porcentajeSiniestro) {
		this.porcentajeSiniestro = porcentajeSiniestro;
	}

	/**
	 * @return the minimoSiniestro
	 */
	public BigDecimal getMinimoSiniestro() {
		return minimoSiniestro;
	}

	/**
	 * @param minimoSiniestro
	 *            the minimoSiniestro to set
	 */
	public void setMinimoSiniestro(BigDecimal minimoSiniestro) {
		this.minimoSiniestro = minimoSiniestro;
	}

	/**
	 * @return the porcentajeValorAsegurado
	 */
	public BigDecimal getPorcentajeValorAsegurado() {
		return porcentajeValorAsegurado;
	}

	/**
	 * @param porcentajeValorAsegurado
	 *            the porcentajeValorAsegurado to set
	 */
	public void setPorcentajeValorAsegurado(BigDecimal porcentajeValorAsegurado) {
		this.porcentajeValorAsegurado = porcentajeValorAsegurado;
	}

	/**
	 * @return the consideraciones
	 */
	public String getConsideraciones() {
		return consideraciones;
	}

	/**
	 * @param consideraciones
	 *            the consideraciones to set
	 */
	public void setConsideraciones(String consideraciones) {
		this.consideraciones = consideraciones;
	}

	/**
	 * @return the amparoPatrimonial
	 */
	public String getAmparoPatrimonial() {
		return amparoPatrimonial;
	}

	/**
	 * @param amparoPatrimonial
	 *            the amparoPatrimonial to set
	 */
	public void setAmparoPatrimonial(String amparoPatrimonial) {
		this.amparoPatrimonial = amparoPatrimonial;
	}

	/**
	 * @return the coberturaPactoAndino
	 */
	public String getCoberturaPactoAndino() {
		return coberturaPactoAndino;
	}

	/**
	 * @param coberturaPactoAndino
	 *            the coberturaPactoAndino to set
	 */
	public void setCoberturaPactoAndino(String coberturaPactoAndino) {
		this.coberturaPactoAndino = coberturaPactoAndino;
	}

	/**
	 * @return the asistenciaVehicular
	 */
	public String getAsistenciaVehicular() {
		return asistenciaVehicular;
	}

	/**
	 * @param asistenciaVehicular
	 *            the asistenciaVehicular to set
	 */
	public void setAsistenciaVehicular(String asistenciaVehicular) {
		this.asistenciaVehicular = asistenciaVehicular;
	}

	/**
	 * @return the autoSustituto
	 */
	public String getAutoSustituto() {
		return autoSustituto;
	}

	/**
	 * @param autoSustituto
	 *            the autoSustituto to set
	 */
	public void setAutoSustituto(String autoSustituto) {
		this.autoSustituto = autoSustituto;
	}

	/**
	 * @return the filePolizaVigente
	 */
	public String getFilePolizaVigente() {
		return filePolizaVigente;
	}

	/**
	 * @param filePolizaVigente
	 *            the filePolizaVigente to set
	 */
	public void setFilePolizaVigente(String filePolizaVigente) {
		this.filePolizaVigente = filePolizaVigente;
	}

	/**
	 * @return the fileCondicionesGenerales
	 */
	public String getFileCondicionesGenerales() {
		return fileCondicionesGenerales;
	}

	/**
	 * @param fileCondicionesGenerales
	 *            the fileCondicionesGenerales to set
	 */
	public void setFileCondicionesGenerales(String fileCondicionesGenerales) {
		this.fileCondicionesGenerales = fileCondicionesGenerales;
	}

	/**
	 * @return the ceberturaVehiculo
	 */
	public String getCeberturaVehiculo() {
		return ceberturaVehiculo;
	}

	/**
	 * @param ceberturaVehiculo
	 *            the ceberturaVehiculo to set
	 */
	public void setCeberturaVehiculo(String ceberturaVehiculo) {
		this.ceberturaVehiculo = ceberturaVehiculo;
	}

	/**
	 * @return the valorVehiculo
	 */
	public BigDecimal getValorVehiculo() {
		return valorVehiculo;
	}

	/**
	 * @param valorVehiculo
	 *            the valorVehiculo to set
	 */
	public void setValorVehiculo(BigDecimal valorVehiculo) {
		this.valorVehiculo = valorVehiculo;
	}

	/**
	 * @return the clausula
	 */
	public String getClausula() {
		return clausula;
	}

	/**
	 * @param clausula
	 *            the clausula to set
	 */
	public void setClausula(String clausula) {
		this.clausula = clausula;
	}

	/**
	 * @return the condicion
	 */
	public String getCondicion() {
		return condicion;
	}

	/**
	 * @param condicion
	 *            the condicion to set
	 */
	public void setCondicion(String condicion) {
		this.condicion = condicion;
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
