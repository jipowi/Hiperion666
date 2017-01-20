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
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,15/01/2014
 * @since JDK1.6
 */
@javax.faces.bean.ManagedBean
@RequestScoped
public class RamoCascoAereoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private String item;
	private String matricula;
	private Integer anioConstruccion;
	private BigDecimal pesoMaximo;
	private Integer numeroAsientos;
	private BigDecimal valorCasco;
	private String marca;
	private String tipoModelo;
	private Integer horasVoladas;
	private BigDecimal maximaCarga;
	private String marcaMotor;
	private String tipoMotor;
	private BigDecimal totalAsegurado;
	private BigDecimal tasa;
	private BigDecimal porcentajeSiniestro;
	private BigDecimal minimoSiniestro;
	private String fileFormulario;
	private String filePolizaVigente;

	// Extras
	private String extra;
	private BigDecimal valorExtra;
	private BigDecimal totalExtra;
	private static final ArrayList<ExtrasCascoAereoBean> extrasList = new ArrayList<ExtrasCascoAereoBean>();

	// Tabla Clausulas adicionales Casco Aereo
	private String clausula;

	// Tabla Cobertura Adicional Casco Aereo
	private String ceberturaAddCascoAereo;
	private BigDecimal valorAddCascoAereo;

	// Tabla Cobertura Casco Aereo
	private String ceberturaCascoAereo;
	private BigDecimal valorCascoAereo;

	// Tabla Cobertura Adiconal Casco Aereo
	private String coberturaAddCascoAereo;
	private BigDecimal valorCoberturaAddCascoAereo;

	// Getters and Setters

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula
	 *            the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
	 * @return the pesoMaximo
	 */
	public BigDecimal getPesoMaximo() {
		return pesoMaximo;
	}

	/**
	 * @param pesoMaximo
	 *            the pesoMaximo to set
	 */
	public void setPesoMaximo(BigDecimal pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	/**
	 * @return the numeroAsientos
	 */
	public Integer getNumeroAsientos() {
		return numeroAsientos;
	}

	/**
	 * @param numeroAsientos
	 *            the numeroAsientos to set
	 */
	public void setNumeroAsientos(Integer numeroAsientos) {
		this.numeroAsientos = numeroAsientos;
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
	 * @return the tipoModelo
	 */
	public String getTipoModelo() {
		return tipoModelo;
	}

	/**
	 * @param tipoModelo
	 *            the tipoModelo to set
	 */
	public void setTipoModelo(String tipoModelo) {
		this.tipoModelo = tipoModelo;
	}

	/**
	 * @return the horasVoladas
	 */
	public Integer getHorasVoladas() {
		return horasVoladas;
	}

	/**
	 * @param horasVoladas
	 *            the horasVoladas to set
	 */
	public void setHorasVoladas(Integer horasVoladas) {
		this.horasVoladas = horasVoladas;
	}

	/**
	 * @return the maximaCarga
	 */
	public BigDecimal getMaximaCarga() {
		return maximaCarga;
	}

	/**
	 * @param maximaCarga
	 *            the maximaCarga to set
	 */
	public void setMaximaCarga(BigDecimal maximaCarga) {
		this.maximaCarga = maximaCarga;
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
	 * @return the tipoMotor
	 */
	public String getTipoMotor() {
		return tipoMotor;
	}

	/**
	 * @param tipoMotor
	 *            the tipoMotor to set
	 */
	public void setTipoMotor(String tipoMotor) {
		this.tipoMotor = tipoMotor;
	}

	/**
	 * @return the totalAsegurado
	 */
	public BigDecimal getTotalAsegurado() {
		return totalAsegurado;
	}

	/**
	 * @param totalAsegurado
	 *            the totalAsegurado to set
	 */
	public void setTotalAsegurado(BigDecimal totalAsegurado) {
		this.totalAsegurado = totalAsegurado;
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
	 * @return the fileFormulario
	 */
	public String getFileFormulario() {
		return fileFormulario;
	}

	/**
	 * @param fileFormulario
	 *            the fileFormulario to set
	 */
	public void setFileFormulario(String fileFormulario) {
		this.fileFormulario = fileFormulario;
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
	 * @return the ceberturaAddCascoAereo
	 */
	public String getCeberturaAddCascoAereo() {
		return ceberturaAddCascoAereo;
	}

	/**
	 * @param ceberturaAddCascoAereo
	 *            the ceberturaAddCascoAereo to set
	 */
	public void setCeberturaAddCascoAereo(String ceberturaAddCascoAereo) {
		this.ceberturaAddCascoAereo = ceberturaAddCascoAereo;
	}

	/**
	 * @return the valorAddCascoAereo
	 */
	public BigDecimal getValorAddCascoAereo() {
		return valorAddCascoAereo;
	}

	/**
	 * @param valorAddCascoAereo
	 *            the valorAddCascoAereo to set
	 */
	public void setValorAddCascoAereo(BigDecimal valorAddCascoAereo) {
		this.valorAddCascoAereo = valorAddCascoAereo;
	}

	/**
	 * @return the ceberturaCascoAereo
	 */
	public String getCeberturaCascoAereo() {
		return ceberturaCascoAereo;
	}

	/**
	 * @param ceberturaCascoAereo
	 *            the ceberturaCascoAereo to set
	 */
	public void setCeberturaCascoAereo(String ceberturaCascoAereo) {
		this.ceberturaCascoAereo = ceberturaCascoAereo;
	}

	/**
	 * @return the valorCascoAereo
	 */
	public BigDecimal getValorCascoAereo() {
		return valorCascoAereo;
	}

	/**
	 * @param valorCascoAereo
	 *            the valorCascoAereo to set
	 */
	public void setValorCascoAereo(BigDecimal valorCascoAereo) {
		this.valorCascoAereo = valorCascoAereo;
	}

	/**
	 * @return the coberturaAddCascoAereo
	 */
	public String getCoberturaAddCascoAereo() {
		return coberturaAddCascoAereo;
	}

	/**
	 * @param coberturaAddCascoAereo
	 *            the coberturaAddCascoAereo to set
	 */
	public void setCoberturaAddCascoAereo(String coberturaAddCascoAereo) {
		this.coberturaAddCascoAereo = coberturaAddCascoAereo;
	}

	/**
	 * @return the valorCoberturaAddCascoAereo
	 */
	public BigDecimal getValorCoberturaAddCascoAereo() {
		return valorCoberturaAddCascoAereo;
	}

	/**
	 * @param valorCoberturaAddCascoAereo
	 *            the valorCoberturaAddCascoAereo to set
	 */
	public void setValorCoberturaAddCascoAereo(BigDecimal valorCoberturaAddCascoAereo) {
		this.valorCoberturaAddCascoAereo = valorCoberturaAddCascoAereo;
	}

	/**
	 * @return the extra
	 */
	public String getExtra() {
		return extra;
	}

	/**
	 * @param extra
	 *            the extra to set
	 */
	public void setExtra(String extra) {
		this.extra = extra;
	}

	/**
	 * @return the valorExtra
	 */
	public BigDecimal getValorExtra() {
		return valorExtra;
	}

	/**
	 * @param valorExtra
	 *            the valorExtra to set
	 */
	public void setValorExtra(BigDecimal valorExtra) {
		this.valorExtra = valorExtra;
	}

	/**
	 * @return the totalExtra
	 */
	public BigDecimal getTotalExtra() {
		return totalExtra;
	}

	/**
	 * @param totalExtra
	 *            the totalExtra to set
	 */
	public void setTotalExtra(BigDecimal totalExtra) {
		this.totalExtra = totalExtra;
	}

	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * @return the extraslist
	 */
	public ArrayList<ExtrasCascoAereoBean> getExtraslist() {
		return extrasList;
	}

	/**
	 * 
	 * <b> Permite agregar un articulo extra </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addAction() {
		ExtrasCascoAereoBean extraItem = new ExtrasCascoAereoBean(this.extra, this.valorExtra);
		extrasList.add(extraItem);

		extra = "";
		valorExtra = new BigDecimal(0);

		return null;
	}

	/**
	 * 
	 * <b> Permite editar un articulo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ExtrasCascoAereoBean) event.getObject()).getExtra());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite remover un articulo de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		extrasList.remove((ExtrasCascoAereoBean) event.getObject());
	}
}
