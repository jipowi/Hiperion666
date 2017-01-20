/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ec.com.avila.hiperion.dto.ObjetoAseguradoResponsabilidadDTO;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/01/2014
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class RamoResponsabilidadCivilBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private BigDecimal limiteUnico;
	private BigDecimal tasa;
	private String filePolizaVigente;

	// Tabla Objeto Asegurado responsabilidad civil
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private String descripcionObjeto;

	private static final ArrayList<ObjetoAseguradoResponsabilidadDTO> objetoList = new ArrayList<ObjetoAseguradoResponsabilidadDTO>();

	// Tabla Cobertura Responsabilidad Civil
	private String cebertura;
	private BigDecimal valorCoberturaRespCivil;

	// Tabla Clausulas Adicionales Responsabilidad Civil
	private String clausula;
	private Integer numeroDias;
	private BigDecimal valorClausulaAddRespCivil;

	private BigDecimal porcentajeValorSiniestro;
	private BigDecimal minimo;
	
	// Cliente - Aseguradora
		private String identificacion;
		private String aseguradora;
		private String nombreCliente;
		private String contactoAseguradora;
		
	// Getters and Setters
		
		
		
	/**
	 * @return the limiteUnico
	 */
	public BigDecimal getLimiteUnico() {
		return limiteUnico;
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
	 * @param limiteUnico
	 *            the limiteUnico to set
	 */
	public void setLimiteUnico(BigDecimal limiteUnico) {
		this.limiteUnico = limiteUnico;
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
	 * @return the valorCoberturaRespCivil
	 */
	public BigDecimal getValorCoberturaRespCivil() {
		return valorCoberturaRespCivil;
	}

	/**
	 * @param valorCoberturaRespCivil
	 *            the valorCoberturaRespCivil to set
	 */
	public void setValorCoberturaRespCivil(BigDecimal valorCoberturaRespCivil) {
		this.valorCoberturaRespCivil = valorCoberturaRespCivil;
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
	 * @return the valorClausulaAddRespCivil
	 */
	public BigDecimal getValorClausulaAddRespCivil() {
		return valorClausulaAddRespCivil;
	}

	/**
	 * @param valorClausulaAddRespCivil
	 *            the valorClausulaAddRespCivil to set
	 */
	public void setValorClausulaAddRespCivil(BigDecimal valorClausulaAddRespCivil) {
		this.valorClausulaAddRespCivil = valorClausulaAddRespCivil;
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
	 * 
	 * <b> Permite agregar un objeto asegurado a la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addAction() {
		ObjetoAseguradoResponsabilidadDTO orderitem = new ObjetoAseguradoResponsabilidadDTO(this.numeroItem, this.ubicacionRiesgo,
				this.descripcionObjeto);
		objetoList.add(orderitem);

		numeroItem = 0;
		ubicacionRiesgo = "";
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
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoResponsabilidadDTO) event.getObject()).getNumeroItem().toString());
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
		objetoList.remove((ObjetoAseguradoResponsabilidadDTO) event.getObject());
	}

	/**
	 * @return the objetolist
	 */
	public ArrayList<ObjetoAseguradoResponsabilidadDTO> getObjetolist() {
		return objetoList;
	}

}
