/*
 * Copyright 2014 JIPOVI
 Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.com.avila.hiperion.emision.entities.Aseguradora;
import ec.com.avila.hiperion.emision.entities.Cliente;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,06/04/2015
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class FormSiniestroVehiculosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private Aseguradora aseguradora;
	private String ramo;
	private double poliza;
	private String paciente;
	private String parentesco;
	private Date fechaNotificacion;
	private Date fechaIncurrencia;
	private String observaciones;
	private String tipoPersona;
	private String identificacion;
	private String tipoIdentificacion;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the aseguradora
	 */
	public Aseguradora getAseguradora() {
		return aseguradora;
	}

	/**
	 * @param aseguradora
	 *            the aseguradora to set
	 */
	public void setAseguradora(Aseguradora aseguradora) {
		this.aseguradora = aseguradora;
	}

	/**
	 * @return the ramo
	 */
	public String getRamo() {
		return ramo;
	}

	/**
	 * @param ramo
	 *            the ramo to set
	 */
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	/**
	 * @return the poliza
	 */
	public double getPoliza() {
		return poliza;
	}

	/**
	 * @param poliza
	 *            the poliza to set
	 */
	public void setPoliza(double poliza) {
		this.poliza = poliza;
	}

	/**
	 * @return the paciente
	 */
	public String getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente
	 *            the paciente to set
	 */
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	/**
	 * @return the parentesco
	 */
	public String getParentesco() {
		return parentesco;
	}

	/**
	 * @param parentesco
	 *            the parentesco to set
	 */
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	/**
	 * @return the fechaNotificacion
	 */
	public Date getFechaNotificacion() {
		return fechaNotificacion;
	}

	/**
	 * @param fechaNotificacion
	 *            the fechaNotificacion to set
	 */
	public void setFechaNotificacion(Date fechaNotificacion) {
		this.fechaNotificacion = fechaNotificacion;
	}

	/**
	 * @return the fechaIncurrencia
	 */
	public Date getFechaIncurrencia() {
		return fechaIncurrencia;
	}

	/**
	 * @param fechaIncurrencia
	 *            the fechaIncurrencia to set
	 */
	public void setFechaIncurrencia(Date fechaIncurrencia) {
		this.fechaIncurrencia = fechaIncurrencia;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 *            the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the tipoPersona
	 */
	public String getTipoPersona() {
		return tipoPersona;
	}

	/**
	 * @param tipoPersona
	 *            the tipoPersona to set
	 */
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
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
	 * @return the tipoIdentificacion
	 */
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	/**
	 * @param tipoIdentificacion
	 *            the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
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
	 * @return the apePaterno
	 */
	public String getApePaterno() {
		return apePaterno;
	}

	/**
	 * @param apePaterno
	 *            the apePaterno to set
	 */
	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	/**
	 * @return the apeMaterno
	 */
	public String getApeMaterno() {
		return apeMaterno;
	}

	/**
	 * @param apeMaterno
	 *            the apeMaterno to set
	 */
	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

}