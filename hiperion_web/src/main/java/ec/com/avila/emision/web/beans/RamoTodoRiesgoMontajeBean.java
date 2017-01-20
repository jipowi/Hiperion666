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

import org.dom4j.Text;
import org.primefaces.event.RowEditEvent;

import ec.com.avila.hiperion.dto.ObjetoAseguradoMontajeDTO;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples</b> . </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,23/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoTodoRiesgoMontajeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Tabla Todo Riesgo Montaje
	private BigDecimal tasa;
	private Integer periodoConstruccion;
	private Integer periodoMantenimiento;
	private Text fileCronograma;
	private Text filePolizaVigente;
	private Text fileEstudiosSuelos;
	private Text fileFormulario;
	private Boolean cronograma;
	private Boolean estudioSuelo;
	private Boolean formularioSeguro;

	// Tabla Deducibles
	private BigDecimal porcentajeConstruccionA;
	private BigDecimal minimoA;
	private BigDecimal porcentajeConstruccionB;
	private BigDecimal minimoB;
	private BigDecimal porcentajeConstruccionC;
	private BigDecimal minimoC;
	private BigDecimal porcentajeConstruccionD;
	private BigDecimal minimoD;
	private BigDecimal porcentajeConstruccionG;
	private BigDecimal minimoG;

	// Objeto Asegurado
	private String detalle;

	private static final ArrayList<ObjetoAseguradoMontajeDTO> orderList = new ArrayList<ObjetoAseguradoMontajeDTO>();
	
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
	 * @return the porcentajeConstruccionA
	 */
	public BigDecimal getPorcentajeConstruccionA() {
		return porcentajeConstruccionA;
	}

	/**
	 * @param porcentajeConstruccionA
	 *            the porcentajeConstruccionA to set
	 */
	public void setPorcentajeConstruccionA(BigDecimal porcentajeConstruccionA) {
		this.porcentajeConstruccionA = porcentajeConstruccionA;
	}

	/**
	 * @return the minimoA
	 */
	public BigDecimal getMinimoA() {
		return minimoA;
	}

	/**
	 * @param minimoA
	 *            the minimoA to set
	 */
	public void setMinimoA(BigDecimal minimoA) {
		this.minimoA = minimoA;
	}

	/**
	 * @return the porcentajeConstruccionB
	 */
	public BigDecimal getPorcentajeConstruccionB() {
		return porcentajeConstruccionB;
	}

	/**
	 * @param porcentajeConstruccionB
	 *            the porcentajeConstruccionB to set
	 */
	public void setPorcentajeConstruccionB(BigDecimal porcentajeConstruccionB) {
		this.porcentajeConstruccionB = porcentajeConstruccionB;
	}

	/**
	 * @return the minimoB
	 */
	public BigDecimal getMinimoB() {
		return minimoB;
	}

	/**
	 * @param minimoB
	 *            the minimoB to set
	 */
	public void setMinimoB(BigDecimal minimoB) {
		this.minimoB = minimoB;
	}

	/**
	 * @return the porcentajeConstruccionC
	 */
	public BigDecimal getPorcentajeConstruccionC() {
		return porcentajeConstruccionC;
	}

	/**
	 * @param porcentajeConstruccionC
	 *            the porcentajeConstruccionC to set
	 */
	public void setPorcentajeConstruccionC(BigDecimal porcentajeConstruccionC) {
		this.porcentajeConstruccionC = porcentajeConstruccionC;
	}

	/**
	 * @return the minimoC
	 */
	public BigDecimal getMinimoC() {
		return minimoC;
	}

	/**
	 * @param minimoC
	 *            the minimoC to set
	 */
	public void setMinimoC(BigDecimal minimoC) {
		this.minimoC = minimoC;
	}

	/**
	 * @return the porcentajeConstruccionD
	 */
	public BigDecimal getPorcentajeConstruccionD() {
		return porcentajeConstruccionD;
	}

	/**
	 * @param porcentajeConstruccionD
	 *            the porcentajeConstruccionD to set
	 */
	public void setPorcentajeConstruccionD(BigDecimal porcentajeConstruccionD) {
		this.porcentajeConstruccionD = porcentajeConstruccionD;
	}

	/**
	 * @return the minimoD
	 */
	public BigDecimal getMinimoD() {
		return minimoD;
	}

	/**
	 * @param minimoD
	 *            the minimoD to set
	 */
	public void setMinimoD(BigDecimal minimoD) {
		this.minimoD = minimoD;
	}

	/**
	 * @return the porcentajeConstruccionG
	 */
	public BigDecimal getPorcentajeConstruccionG() {
		return porcentajeConstruccionG;
	}

	/**
	 * @param porcentajeConstruccionG
	 *            the porcentajeConstruccionG to set
	 */
	public void setPorcentajeConstruccionG(BigDecimal porcentajeConstruccionG) {
		this.porcentajeConstruccionG = porcentajeConstruccionG;
	}

	/**
	 * @return the minimoG
	 */
	public BigDecimal getMinimoG() {
		return minimoG;
	}

	/**
	 * @param minimoG
	 *            the minimoG to set
	 */
	public void setMinimoG(BigDecimal minimoG) {
		this.minimoG = minimoG;
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
	 * @return the fileCronograma
	 */
	public Text getFileCronograma() {
		return fileCronograma;
	}

	/**
	 * @param fileCronograma
	 *            the fileCronograma to set
	 */
	public void setFileCronograma(Text fileCronograma) {
		this.fileCronograma = fileCronograma;
	}

	/**
	 * @return the filePolizaVigente
	 */
	public Text getFilePolizaVigente() {
		return filePolizaVigente;
	}

	/**
	 * @param filePolizaVigente
	 *            the filePolizaVigente to set
	 */
	public void setFilePolizaVigente(Text filePolizaVigente) {
		this.filePolizaVigente = filePolizaVigente;
	}

	/**
	 * @return the fileEstudiosSuelos
	 */
	public Text getFileEstudiosSuelos() {
		return fileEstudiosSuelos;
	}

	/**
	 * @param fileEstudiosSuelos
	 *            the fileEstudiosSuelos to set
	 */
	public void setFileEstudiosSuelos(Text fileEstudiosSuelos) {
		this.fileEstudiosSuelos = fileEstudiosSuelos;
	}

	/**
	 * @return the fileFormulario
	 */
	public Text getFileFormulario() {
		return fileFormulario;
	}

	/**
	 * @param fileFormulario
	 *            the fileFormulario to set
	 */
	public void setFileFormulario(Text fileFormulario) {
		this.fileFormulario = fileFormulario;
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
	 * @return the orderlist
	 */
	public ArrayList<ObjetoAseguradoMontajeDTO> getOrderlist() {
		return orderList;
	}

	/**
	 * @return the cronograma
	 */
	public Boolean getCronograma() {
		return cronograma;
	}

	/**
	 * @param cronograma
	 *            the cronograma to set
	 */
	public void setCronograma(Boolean cronograma) {
		this.cronograma = cronograma;
	}

	/**
	 * @return the estudioSuelo
	 */
	public Boolean getEstudioSuelo() {
		return estudioSuelo;
	}

	/**
	 * @param estudioSuelo
	 *            the estudioSuelo to set
	 */
	public void setEstudioSuelo(Boolean estudioSuelo) {
		this.estudioSuelo = estudioSuelo;
	}

	/**
	 * @return the formularioSeguro
	 */
	public Boolean getFormularioSeguro() {
		return formularioSeguro;
	}

	/**
	 * @param formularioSeguro
	 *            the formularioSeguro to set
	 */
	public void setFormularioSeguro(Boolean formularioSeguro) {
		this.formularioSeguro = formularioSeguro;
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
		ObjetoAseguradoMontajeDTO orderitem = new ObjetoAseguradoMontajeDTO(this.detalle);

		orderList.add(orderitem);

		detalle = "";
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
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoMontajeDTO) event.getObject()).getDetalle());
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
		orderList.remove((ObjetoAseguradoMontajeDTO) event.getObject());
	}
}
