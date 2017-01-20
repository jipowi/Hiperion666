/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.beans;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Avila Sistemas
 * @version 1.0,04/05/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class TasaEquipoElectronicoBean {
	private BigDecimal tasaFijos;
	private BigDecimal tasaDatos;
	private BigDecimal tasaOperacion;
	private BigDecimal tasaPortatiles;
	private BigDecimal tasaCelulares;
	private BigDecimal tasaHurto;

	// Getters and Setters
	/**
	 * @return the tasaFijos
	 */
	public BigDecimal getTasaFijos() {
		return tasaFijos;
	}

	/**
	 * @param tasaFijos
	 *            the tasaFijos to set
	 */
	public void setTasaFijos(BigDecimal tasaFijos) {
		this.tasaFijos = tasaFijos;
	}

	/**
	 * @return the tasaDatos
	 */
	public BigDecimal getTasaDatos() {
		return tasaDatos;
	}

	/**
	 * @param tasaDatos
	 *            the tasaDatos to set
	 */
	public void setTasaDatos(BigDecimal tasaDatos) {
		this.tasaDatos = tasaDatos;
	}

	/**
	 * @return the tasaOperacion
	 */
	public BigDecimal getTasaOperacion() {
		return tasaOperacion;
	}

	/**
	 * @param tasaOperacion
	 *            the tasaOperacion to set
	 */
	public void setTasaOperacion(BigDecimal tasaOperacion) {
		this.tasaOperacion = tasaOperacion;
	}

	/**
	 * @return the tasaPortatiles
	 */
	public BigDecimal getTasaPortatiles() {
		return tasaPortatiles;
	}

	/**
	 * @param tasaPortatiles
	 *            the tasaPortatiles to set
	 */
	public void setTasaPortatiles(BigDecimal tasaPortatiles) {
		this.tasaPortatiles = tasaPortatiles;
	}

	/**
	 * @return the tasaCelulares
	 */
	public BigDecimal getTasaCelulares() {
		return tasaCelulares;
	}

	/**
	 * @param tasaCelulares
	 *            the tasaCelulares to set
	 */
	public void setTasaCelulares(BigDecimal tasaCelulares) {
		this.tasaCelulares = tasaCelulares;
	}

	/**
	 * @return the tasaHurto
	 */
	public BigDecimal getTasaHurto() {
		return tasaHurto;
	}

	/**
	 * @param tasaHurto
	 *            the tasaHurto to set
	 */
	public void setTasaHurto(BigDecimal tasaHurto) {
		this.tasaHurto = tasaHurto;
	}

}
