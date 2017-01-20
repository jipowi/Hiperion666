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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/01/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class RamoRiesgoContratistaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private BigDecimal tasa;
	private Integer periodoConstruccion;
	private Integer periodoMantenimiento;
	private Integer porcentajePeridConst;
	private String fileCronograma;
	private String fileFormulario;
	private String filePolizaVigente;
	private String fileEstudioSuelo;
	private String fileCondicionesGenerales;

	// Tabla Documento_Contratista
	private String documento;
	private String estado;

	// Tabla Clausulas Adicionales_Contratista
	private String clausula;

	// Tabla Coberturas Contratista
	private String cobertura;
	private BigDecimal valorCoberturaRamoRiesgoContratista;

	// Tabla Objeto asegurado contratista
	private Integer item;
	private String detalleObjeto;
	ObjetoAseguradoContratistaBean order;
	private static final ArrayList<ObjetoAseguradoContratistaBean> orderList = new ArrayList<ObjetoAseguradoContratistaBean>();

	// Tabla endosos contratista
	private BigDecimal endoso;
	private BigDecimal valor;

	// Tabla Deducibles Contratista
	private BigDecimal deducible;
	private BigDecimal valorMinimo;
	// Campo que no esta en el modelo pero es parte del deducible
	private BigDecimal porcentajeDeducible;

	/**
	 * @return the valorCoberturaRamoRiesgoContratista
	 */
	public BigDecimal getValorCoberturaRamoRiesgoContratista() {
		return valorCoberturaRamoRiesgoContratista;
	}

	/**
	 * @param valorCoberturaRamoRiesgoContratista
	 *            the valorCoberturaRamoRiesgoContratista to set
	 */
	public void setValorCoberturaRamoRiesgoContratista(BigDecimal valorCoberturaRamoRiesgoContratista) {
		this.valorCoberturaRamoRiesgoContratista = valorCoberturaRamoRiesgoContratista;
	}

	// Getters and Setters

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
	 * @return the periodoConstruccion
	 */
	public Integer getPeriodoConstruccion() {
		return periodoConstruccion;
	}

	/**
	 * @param periodoConstruccion
	 *            the periodoConstruccion to set
	 */
	public void setPeriodoConstruccion(Integer periodoConstruccion) {
		this.periodoConstruccion = periodoConstruccion;
	}

	/**
	 * @return the periodoMantenimiento
	 */
	public Integer getPeriodoMantenimiento() {
		return periodoMantenimiento;
	}

	/**
	 * @param periodoMantenimiento
	 *            the periodoMantenimiento to set
	 */
	public void setPeriodoMantenimiento(Integer periodoMantenimiento) {
		this.periodoMantenimiento = periodoMantenimiento;
	}

	/**
	 * @return the porcentajePeridConst
	 */
	public Integer getPorcentajePeridConst() {
		return porcentajePeridConst;
	}

	/**
	 * @param porcentajePeridConst
	 *            the porcentajePeridConst to set
	 */
	public void setPorcentajePeridConst(Integer porcentajePeridConst) {
		this.porcentajePeridConst = porcentajePeridConst;
	}

	/**
	 * @return the fileCronograma
	 */
	public String getFileCronograma() {
		return fileCronograma;
	}

	/**
	 * @param fileCronograma
	 *            the fileCronograma to set
	 */
	public void setFileCronograma(String fileCronograma) {
		this.fileCronograma = fileCronograma;
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
	 * @return the fileEstudioSuelo
	 */
	public String getFileEstudioSuelo() {
		return fileEstudioSuelo;
	}

	/**
	 * @param fileEstudioSuelo
	 *            the fileEstudioSuelo to set
	 */
	public void setFileEstudioSuelo(String fileEstudioSuelo) {
		this.fileEstudioSuelo = fileEstudioSuelo;
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
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento
	 *            the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
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
	 * @return the valorMinimo
	 */
	public BigDecimal getValorMinimo() {
		return valorMinimo;
	}

	/**
	 * @param valorMinimo
	 *            the valorMinimo to set
	 */
	public void setValorMinimo(BigDecimal valorMinimo) {
		this.valorMinimo = valorMinimo;
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
	 * @return the detalleObjeto
	 */
	public String getDetalleObjeto() {
		return detalleObjeto;
	}

	/**
	 * @param detalleObjeto
	 *            the detalleObjeto to set
	 */
	public void setDetalleObjeto(String detalleObjeto) {
		this.detalleObjeto = detalleObjeto;
	}

	/**
	 * @return the endoso
	 */
	public BigDecimal getEndoso() {
		return endoso;
	}

	/**
	 * @param endoso
	 *            the endoso to set
	 */
	public void setEndoso(BigDecimal endoso) {
		this.endoso = endoso;
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
	 * @return the order
	 */
	public ObjetoAseguradoContratistaBean getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(ObjetoAseguradoContratistaBean order) {
		this.order = order;
	}

	/**
	 * @return the orderlist
	 */
	public ArrayList<ObjetoAseguradoContratistaBean> getOrderlist() {
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
		ObjetoAseguradoContratistaBean orderitem = new ObjetoAseguradoContratistaBean(this.item, this.detalleObjeto);

		orderList.add(orderitem);
		
		item=0;
		detalleObjeto = "";
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
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoContratistaBean) event.getObject()).getItem().toString());
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
		orderList.remove((ObjetoAseguradoContratistaBean) event.getObject());
	}
}
