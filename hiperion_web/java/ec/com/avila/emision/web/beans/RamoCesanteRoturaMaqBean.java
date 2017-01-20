/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,16/01/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class RamoCesanteRoturaMaqBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private BigDecimal utilidadBruta;
	private BigDecimal gastosExtraordinarios;
	private BigDecimal fleteAereo;
	private BigDecimal tasa;
	private String filePolizaVigente;
	private String fileCondicionesGenerales;
	private String periodoIndemnizacion;

	// Tabla Objeto asegurado
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private BigDecimal valorAsegurado;
	private String descripcionObjeto;

	private static final ArrayList<ObjetoAseguradoCesanteRoturaMaqBean> orderList = new ArrayList<ObjetoAseguradoCesanteRoturaMaqBean>();

	// Campo Agregado de acuerdo al modelo
	private String formaPago;

	// Tabla CoberturasCesante
	private String coberturaCeaante;
	private BigDecimal valorCesante;

	// Tabla Coberturas adicioneales cesante esta tabla no esta declarada en las entidades
	private String coberturaAddCesante;
	private BigDecimal valorAddCesante;

	// Tabla Clausula adicional cesante esta tabla no esta declarada en las entidades
	private String clausula;
	private BigDecimal valor;
	private Integer numeroDias;
	
	//Deducibles
	private int numeroDiasDeducible;
	private BigDecimal minPorcentajeValorAsegurado;
	private BigDecimal minimo;
	

	// Getters and Setters
	
	/**
	 * @return the utilidadBruta
	 */
	public BigDecimal getUtilidadBruta() {
		return utilidadBruta;
	}

	/**
	 * @return the numeroDiasDeducible
	 */
	public int getNumeroDiasDeducible() {
		return numeroDiasDeducible;
	}

	/**
	 * @param numeroDiasDeducible the numeroDiasDeducible to set
	 */
	public void setNumeroDiasDeducible(int numeroDiasDeducible) {
		this.numeroDiasDeducible = numeroDiasDeducible;
	}

	/**
	 * @return the minPorcentajeValorAsegurado
	 */
	public BigDecimal getMinPorcentajeValorAsegurado() {
		return minPorcentajeValorAsegurado;
	}

	/**
	 * @param minPorcentajeValorAsegurado the minPorcentajeValorAsegurado to set
	 */
	public void setMinPorcentajeValorAsegurado(BigDecimal minPorcentajeValorAsegurado) {
		this.minPorcentajeValorAsegurado = minPorcentajeValorAsegurado;
	}

	/**
	 * @return the minimo
	 */
	public BigDecimal getMinimo() {
		return minimo;
	}

	/**
	 * @param minimo the minimo to set
	 */
	public void setMinimo(BigDecimal minimo) {
		this.minimo = minimo;
	}

	/**
	 * @param utilidadBruta
	 *            the utilidadBruta to set
	 */
	public void setUtilidadBruta(BigDecimal utilidadBruta) {
		this.utilidadBruta = utilidadBruta;
	}

	/**
	 * @return the gastosExtraordinarios
	 */
	public BigDecimal getGastosExtraordinarios() {
		return gastosExtraordinarios;
	}

	/**
	 * @param gastosExtraordinarios
	 *            the gastosExtraordinarios to set
	 */
	public void setGastosExtraordinarios(BigDecimal gastosExtraordinarios) {
		this.gastosExtraordinarios = gastosExtraordinarios;
	}

	/**
	 * @return the fleteAereo
	 */
	public BigDecimal getFleteAereo() {
		return fleteAereo;
	}

	/**
	 * @param fleteAereo
	 *            the fleteAereo to set
	 */
	public void setFleteAereo(BigDecimal fleteAereo) {
		this.fleteAereo = fleteAereo;
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
	 * @return the numeroItem
	 */
	public Integer getNumeroItem() {
		return numeroItem;
	}

	/**
	 * @param numeroItem
	 *            the numeroItem to set
	 */
	public void setNumeroItem(Integer numeroItem) {
		this.numeroItem = numeroItem;
	}

	/**
	 * @return the ubicacionRiesgo
	 */
	public String getUbicacionRiesgo() {
		return ubicacionRiesgo;
	}

	/**
	 * @param ubicacionRiesgo
	 *            the ubicacionRiesgo to set
	 */
	public void setUbicacionRiesgo(String ubicacionRiesgo) {
		this.ubicacionRiesgo = ubicacionRiesgo;
	}

	/**
	 * @return the descripcionObjeto
	 */
	public String getDescripcionObjeto() {
		return descripcionObjeto;
	}

	/**
	 * @param descripcionObjeto
	 *            the descripcionObjeto to set
	 */
	public void setDescripcionObjeto(String descripcionObjeto) {
		this.descripcionObjeto = descripcionObjeto;
	}

	/**
	 * @return the formaPago
	 */
	public String getFormaPago() {
		return formaPago;
	}

	/**
	 * @param formaPago
	 *            the formaPago to set
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	/**
	 * @return the coberturaCeaante
	 */
	public String getCoberturaCeaante() {
		return coberturaCeaante;
	}

	/**
	 * @param coberturaCeaante
	 *            the coberturaCeaante to set
	 */
	public void setCoberturaCeaante(String coberturaCeaante) {
		this.coberturaCeaante = coberturaCeaante;
	}

	/**
	 * @return the valorCesante
	 */
	public BigDecimal getValorCesante() {
		return valorCesante;
	}

	/**
	 * @param valorCesante
	 *            the valorCesante to set
	 */
	public void setValorCesante(BigDecimal valorCesante) {
		this.valorCesante = valorCesante;
	}

	/**
	 * @return the coberturaAddCesante
	 */
	public String getCoberturaAddCesante() {
		return coberturaAddCesante;
	}

	/**
	 * @param coberturaAddCesante
	 *            the coberturaAddCesante to set
	 */
	public void setCoberturaAddCesante(String coberturaAddCesante) {
		this.coberturaAddCesante = coberturaAddCesante;
	}

	/**
	 * @return the valorAddCesante
	 */
	public BigDecimal getValorAddCesante() {
		return valorAddCesante;
	}

	/**
	 * @param valorAddCesante
	 *            the valorAddCesante to set
	 */
	public void setValorAddCesante(BigDecimal valorAddCesante) {
		this.valorAddCesante = valorAddCesante;
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
	 * @return the periodoIndemnizacion
	 */
	public String getPeriodoIndemnizacion() {
		return periodoIndemnizacion;
	}

	/**
	 * @param periodoIndemnizacion
	 *            the periodoIndemnizacion to set
	 */
	public void setPeriodoIndemnizacion(String periodoIndemnizacion) {
		this.periodoIndemnizacion = periodoIndemnizacion;
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
	
	

	/**
	 * @return the valorAsegurado
	 */
	public BigDecimal getValorAsegurado() {
		return valorAsegurado;
	}

	/**
	 * @param valorAsegurado the valorAsegurado to set
	 */
	public void setValorAsegurado(BigDecimal valorAsegurado) {
		this.valorAsegurado = valorAsegurado;
	}

	/**
	 * @return the orderlist
	 */
	public ArrayList<ObjetoAseguradoCesanteRoturaMaqBean> getOrderlist() {
		return orderList;
	}

	/**
	 * 
	 * <b> Permite agregar un objeto asegurado a la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addAction() {
		ObjetoAseguradoCesanteRoturaMaqBean orderitem = new ObjetoAseguradoCesanteRoturaMaqBean(this.numeroItem, this.ubicacionRiesgo, this.valorAsegurado, this.descripcionObjeto);
		orderList.add(orderitem);

		numeroItem = 0;
		ubicacionRiesgo = "";
		valorAsegurado = new BigDecimal(0);
		descripcionObjeto = "";

		return null;
	}

	/**
	 * 
	 * <b> Permite editar un objeto asegurado </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoCesanteRoturaMaqBean) event.getObject()).getNumeroItem().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite remover un objeto asegurado de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		orderList.remove((ObjetoAseguradoCesanteRoturaMaqBean) event.getObject());
	}

}
