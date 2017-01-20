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

import ec.com.avila.hiperion.dto.ObjetoAseguradoEquipoMaqDTO;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoEquipoMaquinaraBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal tasa;
	private BigDecimal minimoSiniestro;
	private BigDecimal porcentajeSiniestro;
	private BigDecimal minimoAsegurado;

	private String filePolizaVigente;

	// Tabla Objeto asegurado Equipo Maquinaria
	private Integer item;
	private String marca;
	private String modelo;
	private Integer anio;
	private String motor;
	private String chasis;
	private String color;
	private BigDecimal valorAsegurado;
	private String serie;

	private static final ArrayList<ObjetoAseguradoEquipoMaqDTO> objetosList = new ArrayList<ObjetoAseguradoEquipoMaqDTO>();

	// Tabla Coberturas Add Equipo Maquinaria

	private String cebertura;
	private BigDecimal valor;

	// Tabla Clausulas adicionales Equipo Maquinaria
	private String clausula;

	// Tabla Cobertura Equipo Maquinaria esta tabla no esta declarada en la entidades
	private String coberturaEquipoMaquinaria;
	private BigDecimal valorCoberturaEquipoMaquinaria;

	// Cliente - Aseguradora
	private String identificacion;
	private String nombreCliente;
	private String aseguradora;
	private String contactoAseguradora;

	// Getters and Setters
	
	

	/**
	 * @return the tasa
	 */
	public BigDecimal getTasa() {
		return tasa;
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
	 * @return the serie
	 */
	public String getSerie() {
		return serie;
	}

	/**
	 * @param serie
	 *            the serie to set
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}

	/**
	 * @param tasa
	 *            the tasa to set
	 */
	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
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
	 * @return the minimoAsegurado
	 */
	public BigDecimal getMinimoAsegurado() {
		return minimoAsegurado;
	}

	/**
	 * @param minimoAsegurado
	 *            the minimoAsegurado to set
	 */
	public void setMinimoAsegurado(BigDecimal minimoAsegurado) {
		this.minimoAsegurado = minimoAsegurado;
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
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 *            the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the anio
	 */
	public Integer getAnio() {
		return anio;
	}

	/**
	 * @param anio
	 *            the anio to set
	 */
	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	/**
	 * @return the motor
	 */
	public String getMotor() {
		return motor;
	}

	/**
	 * @param motor
	 *            the motor to set
	 */
	public void setMotor(String motor) {
		this.motor = motor;
	}

	/**
	 * @return the chasis
	 */
	public String getChasis() {
		return chasis;
	}

	/**
	 * @param chasis
	 *            the chasis to set
	 */
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
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
	 * @return the coberturaEquipoMaquinaria
	 */
	public String getCoberturaEquipoMaquinaria() {
		return coberturaEquipoMaquinaria;
	}

	/**
	 * @param coberturaEquipoMaquinaria
	 *            the coberturaEquipoMaquinaria to set
	 */
	public void setCoberturaEquipoMaquinaria(String coberturaEquipoMaquinaria) {
		this.coberturaEquipoMaquinaria = coberturaEquipoMaquinaria;
	}

	/**
	 * @return the valorCoberturaEquipoMaquinaria
	 */
	public BigDecimal getValorCoberturaEquipoMaquinaria() {
		return valorCoberturaEquipoMaquinaria;
	}

	/**
	 * @param valorCoberturaEquipoMaquinaria
	 *            the valorCoberturaEquipoMaquinaria to set
	 */
	public void setValorCoberturaEquipoMaquinaria(BigDecimal valorCoberturaEquipoMaquinaria) {
		this.valorCoberturaEquipoMaquinaria = valorCoberturaEquipoMaquinaria;
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
	 * @return the orderlist
	 */
	public ArrayList<ObjetoAseguradoEquipoMaqDTO> getObjetoAseguradoList() {
		return objetosList;
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
		ObjetoAseguradoEquipoMaqDTO orderitem = new ObjetoAseguradoEquipoMaqDTO(this.item, this.marca, this.modelo, this.anio, this.motor,
				this.chasis, this.color, this.valorAsegurado, this.serie);

		objetosList.add(orderitem);

		item = 0;
		marca = "";
		modelo = "";
		anio = 0;
		motor = "";
		chasis = "";
		color = "";
		valorAsegurado = new BigDecimal(0);
		serie = "";

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
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoEquipoMaqDTO) event.getObject()).getItem().toString());
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
		objetosList.remove((ObjetoAseguradoEquipoMaqDTO) event.getObject());
	}

}
