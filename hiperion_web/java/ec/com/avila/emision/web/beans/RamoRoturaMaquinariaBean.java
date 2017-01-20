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
public class RamoRoturaMaquinariaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private BigDecimal tasa;

	private BigDecimal gastosExtraordinarios;
	private BigDecimal fleteAereo;
	private String filePolizaVigente;
	private String fileCondicionesGenerales;

	// Tabla Clausulas adicionales
	private String clausula;
	private BigDecimal valor;
	private Integer numeroDias;

	// Tabla Coberura Adiconal Rotura
	private String cobertura;
	private BigDecimal valorCoberturaAddRotura;

	// Tabla Coberturas Rotura
	private String coberturaRoturaMAquinaria;
	private BigDecimal valorCoberturaRotura;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Tabla Objeto Asegurado
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private String direccion;
	private String giroNegocio;
	private String descripcionObjeto;
	private String maquinariaAsegurada;
	private BigDecimal total;

	private static final ArrayList<ObjetoAseguradoRoturaMaqBean> orderList = new ArrayList<ObjetoAseguradoRoturaMaqBean>();

	// Getters and Setters

	/**
	 * @return the coberturaRoturaMAquinaria
	 */
	public String getCoberturaRoturaMAquinaria() {
		return coberturaRoturaMAquinaria;
	}

	/**
	 * @param coberturaRoturaMAquinaria
	 *            the coberturaRoturaMAquinaria to set
	 */
	public void setCoberturaRoturaMAquinaria(String coberturaRoturaMAquinaria) {
		this.coberturaRoturaMAquinaria = coberturaRoturaMAquinaria;
	}

	/**
	 * @return the serialversionuid /**
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
	 * @return the valorCoberturaAddRotura
	 */
	public BigDecimal getValorCoberturaAddRotura() {
		return valorCoberturaAddRotura;
	}

	/**
	 * @param valorCoberturaAddRotura
	 *            the valorCoberturaAddRotura to set
	 */
	public void setValorCoberturaAddRotura(BigDecimal valorCoberturaAddRotura) {
		this.valorCoberturaAddRotura = valorCoberturaAddRotura;
	}

	/**
	 * @return the cebertura
	 */

	/**
	 * @return the valorCoberturaRotura
	 */
	public BigDecimal getValorCoberturaRotura() {
		return valorCoberturaRotura;
	}

	/**
	 * @param valorCoberturaRotura
	 *            the valorCoberturaRotura to set
	 */
	public void setValorCoberturaRotura(BigDecimal valorCoberturaRotura) {
		this.valorCoberturaRotura = valorCoberturaRotura;
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
	 * @return the giroNegocio
	 */
	public String getGiroNegocio() {
		return giroNegocio;
	}

	/**
	 * @param giroNegocio
	 *            the giroNegocio to set
	 */
	public void setGiroNegocio(String giroNegocio) {
		this.giroNegocio = giroNegocio;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the maquinariaAsegurada
	 */
	public String getMaquinariaAsegurada() {
		return maquinariaAsegurada;
	}

	/**
	 * @param maquinariaAsegurada
	 *            the maquinariaAsegurada to set
	 */
	public void setMaquinariaAsegurada(String maquinariaAsegurada) {
		this.maquinariaAsegurada = maquinariaAsegurada;
	}

	/**
	 * @return the orderlist
	 */
	public ArrayList<ObjetoAseguradoRoturaMaqBean> getOrderlist() {
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
		ObjetoAseguradoRoturaMaqBean orderitem = new ObjetoAseguradoRoturaMaqBean(this.numeroItem, this.ubicacionRiesgo, this.direccion, this.giroNegocio, this.descripcionObjeto,
			this.maquinariaAsegurada, this.total);
		orderList.add(orderitem);

		numeroItem = 0;
		ubicacionRiesgo = "";
		direccion = "";
		giroNegocio = "";
		descripcionObjeto = "";
		maquinariaAsegurada = "";
		total = new BigDecimal(0);

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
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoRoturaMaqBean) event.getObject()).getNumeroItem().toString());
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
		orderList.remove((ObjetoAseguradoRoturaMaqBean) event.getObject());
	}

}
