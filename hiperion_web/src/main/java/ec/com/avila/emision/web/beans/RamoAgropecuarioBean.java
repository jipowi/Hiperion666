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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ec.com.avila.hiperion.dto.ObjetoAseguradoGanaderoAgroDTO;
import ec.com.avila.hiperion.dto.ObjetoAseguradoPlantacionAgroDTO;
import ec.com.avila.hiperion.emision.entities.ArchivoBase;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoAgropecuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Tabla RAmo Agropecuario
	private BigDecimal tasa;
	private BigDecimal deducible;
	private BigDecimal valorAsegurado;
	private String detalle;
	private String ubicacion;
	// Tipo de Objeto Asegurado
	private String tipoObjeto;

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

	private ArchivoBase filePolizaVigente;

	private static ArrayList<ObjetoAseguradoGanaderoAgroDTO> objetoAseguradoList = new ArrayList<ObjetoAseguradoGanaderoAgroDTO>();
	private static ArrayList<ObjetoAseguradoPlantacionAgroDTO> objetoAseguradoPlantacionList = new ArrayList<ObjetoAseguradoPlantacionAgroDTO>();
	
	//Cliente aseguradora
	private String identificacion;
	private String nombreCliente;
	private String aseguradora;
	private String contactoAseguradora;
	
	
	
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
	public ArchivoBase getFilePolizaVigente() {
		return filePolizaVigente;
	}

	/**
	 * @param filePolizaVigente
	 *            the filePolizaVigente to set
	 */
	public void setFilePolizaVigente(ArchivoBase filePolizaVigente) {
		this.filePolizaVigente = filePolizaVigente;
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
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle
	 *            the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion
	 *            the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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
	 * @return the objetoAseguradoList
	 */
	public ArrayList<ObjetoAseguradoGanaderoAgroDTO> getObjetoAseguradoList() {
		return objetoAseguradoList;
	}

	/**
	 * @return the objetoAseguradoPlantacionList
	 */
	public ArrayList<ObjetoAseguradoPlantacionAgroDTO> getObjetoAseguradoPlantacionList() {
		return objetoAseguradoPlantacionList;
	}

	/**
	 * @param objetoAseguradoPlantacionList
	 *            the objetoAseguradoPlantacionList to set
	 */
	public static void setObjetoAseguradoPlantacionList(ArrayList<ObjetoAseguradoPlantacionAgroDTO> objetoAseguradoPlantacionList) {
		RamoAgropecuarioBean.objetoAseguradoPlantacionList = objetoAseguradoPlantacionList;
	}

	/**
	 * @param objetoAseguradoList
	 *            the objetoAseguradoList to set
	 */
	public static void setObjetoAseguradoList(ArrayList<ObjetoAseguradoGanaderoAgroDTO> objetoAseguradoList) {
		RamoAgropecuarioBean.objetoAseguradoList = objetoAseguradoList;
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
	public void addGanadero() {
		ObjetoAseguradoGanaderoAgroDTO orderitem = new ObjetoAseguradoGanaderoAgroDTO(this.item, this.nombre, this.sexo, this.raza, this.color,
				this.edad, this.montoAsegurado, this.tasa);
		objetoAseguradoList.add(orderitem);

		item = 0;
		nombre = "";
		sexo = "";
		raza = "";
		color = "";
		edad = 0;
		montoAsegurado = new BigDecimal(0);
		tasa = new BigDecimal(0);
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
	public void addPlantacion() {
		ObjetoAseguradoPlantacionAgroDTO plantacionItem = new ObjetoAseguradoPlantacionAgroDTO(this.detalle, this.ubicacion, this.valorAsegurado);
		objetoAseguradoPlantacionList.add(plantacionItem);

		detalle = "";
		ubicacion = "";

		valorAsegurado = new BigDecimal(0);

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
	public void onEditGanadero(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoGanaderoAgroDTO) event.getObject()).getItem().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
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
	public void onEditPlantacion(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoPlantacionAgroDTO) event.getObject()).getDetalle());
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
	public void onCancelGanadero(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		objetoAseguradoList.remove((ObjetoAseguradoGanaderoAgroDTO) event.getObject());
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
	public void onCancelPlantacion(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		objetoAseguradoPlantacionList.remove((ObjetoAseguradoPlantacionAgroDTO) event.getObject());
	}
	
	/**
	 * @return the tipoObjeto
	 */
	public String getTipoObjeto() {
		return tipoObjeto;
	}

	/**
	 * @param tipoObjeto
	 *            the tipoObjeto to set
	 */
	public void setTipoObjeto(String tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}

}
