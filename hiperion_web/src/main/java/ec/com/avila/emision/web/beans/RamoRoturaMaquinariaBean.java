/**
 * 
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

import ec.com.avila.hiperion.dto.ObjetoAseguradoRoturaMaqDTO;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoRoturaMaquinariaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private BigDecimal tasa;

	private BigDecimal gastosExtraordinarios;
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
	private String descripcionObjeto;
	private BigDecimal total;

	private static final ArrayList<ObjetoAseguradoRoturaMaqDTO> orderList = new ArrayList<ObjetoAseguradoRoturaMaqDTO>();

	// Deducibles
	private BigDecimal porcentajeValorSiniestro;
	private BigDecimal minimoPorcentajeValorAsegurado;
	private BigDecimal minimo;

	// Cliente - Aseguradora
	private String identificacion;
	private String nombreCliente;
	private String aseguradora;
	private String contactoAseguradora;

	// Getters and Setters
	
	

	/**
	 * @return the coberturaRoturaMAquinaria
	 */
	public String getCoberturaRoturaMAquinaria() {
		return coberturaRoturaMAquinaria;
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
	 * @param nombreCliente
	 *            the nombreCliente to set
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
	 * @return the porcentajeValorSiniestro
	 */
	public BigDecimal getPorcentajeValorSiniestro() {
		return porcentajeValorSiniestro;
	}

	/**
	 * @param porcentajeValorSiniestro
	 *            the porcentajeValorSiniestro to set
	 */
	public void setPorcentajeValorSiniestro(BigDecimal porcentajeValorSiniestro) {
		this.porcentajeValorSiniestro = porcentajeValorSiniestro;
	}

	/**
	 * @return the minimoPorcentajeValorAsegurado
	 */
	public BigDecimal getMinimoPorcentajeValorAsegurado() {
		return minimoPorcentajeValorAsegurado;
	}

	/**
	 * @param minimoPorcentajeValorAsegurado
	 *            the minimoPorcentajeValorAsegurado to set
	 */
	public void setMinimoPorcentajeValorAsegurado(BigDecimal minimoPorcentajeValorAsegurado) {
		this.minimoPorcentajeValorAsegurado = minimoPorcentajeValorAsegurado;
	}

	/**
	 * @return the minimo
	 */
	public BigDecimal getMinimo() {
		return minimo;
	}

	/**
	 * @param minimo
	 *            the minimo to set
	 */
	public void setMinimo(BigDecimal minimo) {
		this.minimo = minimo;
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
	 * @return the orderlist
	 */
	public ArrayList<ObjetoAseguradoRoturaMaqDTO> getOrderlist() {
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
		// ObjetoAseguradoRoturaMaqDTO orderitem = new ObjetoAseguradoRoturaMaqDTO(this.numeroItem, this.ubicacionRiesgo, this.descripcionObjeto,
		// this.total);
		// orderList.add(orderitem);

		numeroItem = 0;
		ubicacionRiesgo = "";
		descripcionObjeto = "";
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
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoRoturaMaqDTO) event.getObject()).getNumeroItem().toString());
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
		orderList.remove((ObjetoAseguradoRoturaMaqDTO) event.getObject());
	}

}
