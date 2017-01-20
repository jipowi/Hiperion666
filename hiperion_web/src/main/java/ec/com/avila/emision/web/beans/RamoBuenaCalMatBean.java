/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */

/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,15/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoBuenaCalMatBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private String objetoAsegurado;
	private BigDecimal valorContrato;
	private BigDecimal valorPoliza;
	private String sector;
	private String fileContrato;
	private String filePolizaVigente;
	private String fileCondicionesGenerales;

	// Tabla Cobertura materiales
	private String cebertura;
	private BigDecimal valor;
	
	// Cliente - Aseguradora
		private String identificacion;
		private String aseguradora;
		private String nombreCliente;
		private String contactoAseguradora;

	// Getters and Setters
		
		
		
	/**
	 * @return the objetoAsegurado
	 */
	public String getObjetoAsegurado() {
		return objetoAsegurado;
	}

	/**
	 * @return the contactoAseguradora
	 */
	public String getContactoAseguradora() {
		return contactoAseguradora;
	}

	/**
	 * @param contactoAseguradora the contactoAseguradora to set
	 */
	public void setContactoAseguradora(String contactoAseguradora) {
		this.contactoAseguradora = contactoAseguradora;
	}

	/**
	 * @return the aseguradora
	 */
	public String getAseguradora() {
		return aseguradora;
	}

	/**
	 * @param aseguradora the aseguradora to set
	 */
	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}

	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @param objetoAsegurado
	 *            the objetoAsegurado to set
	 */
	public void setObjetoAsegurado(String objetoAsegurado) {
		this.objetoAsegurado = objetoAsegurado;
	}

	/**
	 * @return the valorContrato
	 */
	public BigDecimal getValorContrato() {
		return valorContrato;
	}

	/**
	 * @param valorContrato
	 *            the valorContrato to set
	 */
	public void setValorContrato(BigDecimal valorContrato) {
		this.valorContrato = valorContrato;
	}

	/**
	 * @return the valorPoliza
	 */
	public BigDecimal getValorPoliza() {
		return valorPoliza;
	}

	/**
	 * @param valorPoliza
	 *            the valorPoliza to set
	 */
	public void setValorPoliza(BigDecimal valorPoliza) {
		this.valorPoliza = valorPoliza;
	}

	/**
	 * @return the sector
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * @param sector
	 *            the sector to set
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}

	/**
	 * @return the fileContrato
	 */
	public String getFileContrato() {
		return fileContrato;
	}

	/**
	 * @param fileContrato
	 *            the fileContrato to set
	 */
	public void setFileContrato(String fileContrato) {
		this.fileContrato = fileContrato;
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
	 * @return the cebertura
	 */
	public String getCebertura() {
		return cebertura;
	}

	/**
	 * @param cebertura
	 *            the cebertura to set
	 */
	public void setCebertura(String cebertura) {
		this.cebertura = cebertura;
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
