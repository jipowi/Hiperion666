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

import org.dom4j.Text;
import org.primefaces.event.RowEditEvent;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples</b> . </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,23/02/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
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
	private Text fileCondicionesGenerales;
	private Text fileFormulario;

	// Objeto Asegurado
	private String detalle;

	private static final ArrayList<ObjetoAseguradoMontajeBean> orderList = new ArrayList<ObjetoAseguradoMontajeBean>();

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
	 * @return the fileCondicionesGenerales
	 */
	public Text getFileCondicionesGenerales() {
		return fileCondicionesGenerales;
	}

	/**
	 * @param fileCondicionesGenerales
	 *            the fileCondicionesGenerales to set
	 */
	public void setFileCondicionesGenerales(Text fileCondicionesGenerales) {
		this.fileCondicionesGenerales = fileCondicionesGenerales;
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
	public ArrayList<ObjetoAseguradoMontajeBean> getOrderlist() {
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
		ObjetoAseguradoMontajeBean orderitem = new ObjetoAseguradoMontajeBean(this.detalle);

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
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoMontajeBean) event.getObject()).getDetalle());
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
		orderList.remove((ObjetoAseguradoMontajeBean) event.getObject());
	}
}
