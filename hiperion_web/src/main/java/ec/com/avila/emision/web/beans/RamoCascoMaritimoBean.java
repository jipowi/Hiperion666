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
public class RamoCascoMaritimoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private String nombreNave;
	private String numeroRegistro;
	private String claseEmbarcacion;
	private String bandera;
	private String zonaNavegacion;
	private BigDecimal tonelajeBruto;
	private String eslora;
	private String puntal;
	private Integer anioConstruccion;
	private String manga;
	private String marcaMotor;
	private BigDecimal avaluo;
	private BigDecimal valorCasco;
	private BigDecimal valorMaquina;
	private BigDecimal porcentajeConstruccion;
	private BigDecimal valorRedes;
	private BigDecimal otros;
	private BigDecimal total;
	private BigDecimal tasa;
	private BigDecimal porcentajeSiniestro;
	private BigDecimal minimoSiniestro;
	private String filePolizaVigente;

	// Tabla Coberturas casco
	private String ceberturaCasco;
	private BigDecimal valorCoberturaCasco;

	// Coberturas adicioanles casco
	private String ceberturaAddCasco;
	private BigDecimal valorCoberturaAddCasco;

	// Tabla Clausulas adicionales casco
	private String clausula;
	private BigDecimal valorClausulasAdicioanlesCasco;
	private Integer numeroDias;

	// Cliente - Aseguradora
	private String identificacion;
	private String aseguradora;
	private String nombreCliente;
	private String contactoAseguradora;

	// Getters and Setters

	
	
	/**
	 * @return the porcentajeSiniestro
	 */
	public BigDecimal getPorcentajeSiniestro() {
		return porcentajeSiniestro;
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
	 * @param identificacion
	 *            the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @param porcentajeSiniestro
	 *            the porcentajeSiniestro to set
	 */
	public void setPorcentajeSiniestro(BigDecimal porcentajeSiniestro) {
		this.porcentajeSiniestro = porcentajeSiniestro;
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
	 * @return the nombreNave
	 */
	public String getNombreNave() {
		return nombreNave;
	}

	/**
	 * @param nombreNave
	 *            the nombreNave to set
	 */
	public void setNombreNave(String nombreNave) {
		this.nombreNave = nombreNave;
	}

	/**
	 * @return the numeroRegistro
	 */
	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	/**
	 * @param numeroRegistro
	 *            the numeroRegistro to set
	 */
	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	/**
	 * @return the claseEmbarcacion
	 */
	public String getClaseEmbarcacion() {
		return claseEmbarcacion;
	}

	/**
	 * @param claseEmbarcacion
	 *            the claseEmbarcacion to set
	 */
	public void setClaseEmbarcacion(String claseEmbarcacion) {
		this.claseEmbarcacion = claseEmbarcacion;
	}

	/**
	 * @return the bandera
	 */
	public String getBandera() {
		return bandera;
	}

	/**
	 * @param bandera
	 *            the bandera to set
	 */
	public void setBandera(String bandera) {
		this.bandera = bandera;
	}

	/**
	 * @return the zonaNavegacion
	 */
	public String getZonaNavegacion() {
		return zonaNavegacion;
	}

	/**
	 * @param zonaNavegacion
	 *            the zonaNavegacion to set
	 */
	public void setZonaNavegacion(String zonaNavegacion) {
		this.zonaNavegacion = zonaNavegacion;
	}

	/**
	 * @return the tonelajeBruto
	 */
	public BigDecimal getTonelajeBruto() {
		return tonelajeBruto;
	}

	/**
	 * @param tonelajeBruto
	 *            the tonelajeBruto to set
	 */
	public void setTonelajeBruto(BigDecimal tonelajeBruto) {
		this.tonelajeBruto = tonelajeBruto;
	}

	/**
	 * @return the eslora
	 */
	public String getEslora() {
		return eslora;
	}

	/**
	 * @param eslora
	 *            the eslora to set
	 */
	public void setEslora(String eslora) {
		this.eslora = eslora;
	}

	/**
	 * @return the puntal
	 */
	public String getPuntal() {
		return puntal;
	}

	/**
	 * @param puntal
	 *            the puntal to set
	 */
	public void setPuntal(String puntal) {
		this.puntal = puntal;
	}

	/**
	 * @return the anioConstruccion
	 */
	public Integer getAnioConstruccion() {
		return anioConstruccion;
	}

	/**
	 * @param anioConstruccion
	 *            the anioConstruccion to set
	 */
	public void setAnioConstruccion(Integer anioConstruccion) {
		this.anioConstruccion = anioConstruccion;
	}

	/**
	 * @return the manga
	 */
	public String getManga() {
		return manga;
	}

	/**
	 * @param manga
	 *            the manga to set
	 */
	public void setManga(String manga) {
		this.manga = manga;
	}

	/**
	 * @return the marcaMotor
	 */
	public String getMarcaMotor() {
		return marcaMotor;
	}

	/**
	 * @param marcaMotor
	 *            the marcaMotor to set
	 */
	public void setMarcaMotor(String marcaMotor) {
		this.marcaMotor = marcaMotor;
	}

	/**
	 * @return the avaluo
	 */
	public BigDecimal getAvaluo() {
		return avaluo;
	}

	/**
	 * @param avaluo
	 *            the avaluo to set
	 */
	public void setAvaluo(BigDecimal avaluo) {
		this.avaluo = avaluo;
	}

	/**
	 * @return the valorCasco
	 */
	public BigDecimal getValorCasco() {
		return valorCasco;
	}

	/**
	 * @param valorCasco
	 *            the valorCasco to set
	 */
	public void setValorCasco(BigDecimal valorCasco) {
		this.valorCasco = valorCasco;
	}

	/**
	 * @return the valorMaquina
	 */
	public BigDecimal getValorMaquina() {
		return valorMaquina;
	}

	/**
	 * @param valorMaquina
	 *            the valorMaquina to set
	 */
	public void setValorMaquina(BigDecimal valorMaquina) {
		this.valorMaquina = valorMaquina;
	}

	/**
	 * @return the valorRedes
	 */
	public BigDecimal getValorRedes() {
		return valorRedes;
	}

	/**
	 * @param valorRedes
	 *            the valorRedes to set
	 */
	public void setValorRedes(BigDecimal valorRedes) {
		this.valorRedes = valorRedes;
	}

	/**
	 * @return the otros
	 */
	public BigDecimal getOtros() {
		return otros;
	}

	/**
	 * @param otros
	 *            the otros to set
	 */
	public void setOtros(BigDecimal otros) {
		this.otros = otros;
	}

	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * @return the porcentajeConstruccion
	 */
	public BigDecimal getPorcentajeConstruccion() {
		return porcentajeConstruccion;
	}

	/**
	 * @param porcentajeConstruccion
	 *            the porcentajeConstruccion to set
	 */
	public void setPorcentajeConstruccion(BigDecimal porcentajeConstruccion) {
		this.porcentajeConstruccion = porcentajeConstruccion;
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
	 * @return the ceberturaCasco
	 */
	public String getCeberturaCasco() {
		return ceberturaCasco;
	}

	/**
	 * @param ceberturaCasco
	 *            the ceberturaCasco to set
	 */
	public void setCeberturaCasco(String ceberturaCasco) {
		this.ceberturaCasco = ceberturaCasco;
	}

	/**
	 * @return the valorCoberturaCasco
	 */
	public BigDecimal getValorCoberturaCasco() {
		return valorCoberturaCasco;
	}

	/**
	 * @param valorCoberturaCasco
	 *            the valorCoberturaCasco to set
	 */
	public void setValorCoberturaCasco(BigDecimal valorCoberturaCasco) {
		this.valorCoberturaCasco = valorCoberturaCasco;
	}

	/**
	 * @return the ceberturaAddCasco
	 */
	public String getCeberturaAddCasco() {
		return ceberturaAddCasco;
	}

	/**
	 * @param ceberturaAddCasco
	 *            the ceberturaAddCasco to set
	 */
	public void setCeberturaAddCasco(String ceberturaAddCasco) {
		this.ceberturaAddCasco = ceberturaAddCasco;
	}

	/**
	 * @return the valorCoberturaAddCasco
	 */
	public BigDecimal getValorCoberturaAddCasco() {
		return valorCoberturaAddCasco;
	}

	/**
	 * @param valorCoberturaAddCasco
	 *            the valorCoberturaAddCasco to set
	 */
	public void setValorCoberturaAddCasco(BigDecimal valorCoberturaAddCasco) {
		this.valorCoberturaAddCasco = valorCoberturaAddCasco;
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
	 * @return the valorClausulasAdicioanlesCasco
	 */
	public BigDecimal getValorClausulasAdicioanlesCasco() {
		return valorClausulasAdicioanlesCasco;
	}

	/**
	 * @param valorClausulasAdicioanlesCasco
	 *            the valorClausulasAdicioanlesCasco to set
	 */
	public void setValorClausulasAdicioanlesCasco(BigDecimal valorClausulasAdicioanlesCasco) {
		this.valorClausulasAdicioanlesCasco = valorClausulasAdicioanlesCasco;
	}

	/**
	 * @return the numeroDias
	 */
	public Integer getNumeroDias() {
		return numeroDias;
	}

	/**
	 * @param numeroDias
	 *            the numeroDias to set
	 */
	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

}
