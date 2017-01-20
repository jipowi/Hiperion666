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
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class RamoAgropecuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Tabla RAmo Agropecuario
	private BigDecimal tasa;
	private BigDecimal deducible;
	private String filePolizaVigente;
	private String fileCondicionesGenerales;

	// Tabla Objeto Asegurado
	private Integer item;
	private String nombre;
	private String sexo;
	private String raza;
	private String color;
	private Integer edad;
	private BigDecimal montoAsegurado;

	// Tabla Coberturas
	private String cobertura;
	private BigDecimal valor;
	private Integer numDias;
	private BigDecimal porcentaje;

	// Tabla Clausulas adicionales
	private String clausula;
	private Integer numeroDias;

	private static ArrayList<ObjetoAseguradoAgropecuarioBean> orderList = new ArrayList<ObjetoAseguradoAgropecuarioBean>();

	public ArrayList<ObjetoAseguradoAgropecuarioBean> getOrderList() {
		return orderList;
	}

	/**
	 * @return the tasa
	 */

	// Getters and Setters
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
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
	 * @param sexo
	 *            the sexo to set
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
	 * @param raza
	 *            the raza to set
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
	 * @return the numDias
	 */
	public Integer getNumDias() {
		return numDias;
	}

	/**
	 * @param numDias
	 *            the numDias to set
	 */
	public void setNumDias(Integer numDias) {
		this.numDias = numDias;
	}

	/**
	 * @return the porcentaje
	 */
	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje
	 *            the porcentaje to set
	 */
	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	/**
	 * @return the orderlist
	 */
	public static ArrayList<ObjetoAseguradoAgropecuarioBean> getOrderlist() {
		return orderList;
	}

	/**
	 * @param orderlist
	 *            the orderlist to set
	 */
	public static void setOrderlist(ArrayList<ObjetoAseguradoAgropecuarioBean> orderlist) {
		orderList = orderlist;
	}

	/**
	 * @param color
	 *            the color to set
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
	 * @param edad
	 *            the edad to set
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
	 * @param montoAsegurado
	 *            the montoAsegurado to set
	 */
	public void setMontoAsegurado(BigDecimal montoAsegurado) {
		this.montoAsegurado = montoAsegurado;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the deducible
	 */
	public BigDecimal getDeducible() {
		return deducible;
	}

	/**
	 * @param deducible
	 *            the deducible to set
	 */
	public void setDeducible(BigDecimal deducible) {
		this.deducible = deducible;
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
		ObjetoAseguradoAgropecuarioBean orderitem = new ObjetoAseguradoAgropecuarioBean(this.item, this.nombre, this.sexo, this.raza, this.color,
				this.edad, this.montoAsegurado, this.tasa);
		orderList.add(orderitem);

		item = 0;
		nombre = "";
		sexo = "";
		raza = "";
		color = "";
		edad = 0;
		montoAsegurado = new BigDecimal(0);
		tasa = new BigDecimal(0);
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
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoAgropecuarioBean) event.getObject()).getItem().toString());
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
		orderList.remove((ObjetoAseguradoAgropecuarioBean) event.getObject());
	}
}
