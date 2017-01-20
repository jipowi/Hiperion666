/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/** 
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *  
 * @author Avila Sistemas
 * @version 1.0,08/03/2014
 * @since JDK1.6
 */
public class DeducibleIncendioLineasAliadasBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal porcentajeTerremoto;
	private BigDecimal porcentajeLluvia;
	private BigDecimal porcentajeVidrios;
	private BigDecimal porcentajeOtrosEventos;
	private BigDecimal minimoTerremoto;
	private BigDecimal minimoLluvia;
	private BigDecimal minimoOtrosEventos;
	private BigDecimal minimoVidriosCristaes;
	/**
	 * @param porcentajeTerremoto
	 * @param porcentajeLluvia
	 * @param porcentajeVidrios
	 * @param porcentajeOtrosEventos
	 * @param minimoTerremoto
	 * @param minimoLluvia
	 * @param minimoOtrosEventos
	 * @param minimoVidriosCristaes
	 */
	public DeducibleIncendioLineasAliadasBean(BigDecimal porcentajeTerremoto, BigDecimal porcentajeLluvia, BigDecimal porcentajeVidrios,
			BigDecimal porcentajeOtrosEventos, BigDecimal minimoTerremoto, BigDecimal minimoLluvia, BigDecimal minimoOtrosEventos,
			BigDecimal minimoVidriosCristaes) {
		super();
		this.porcentajeTerremoto = porcentajeTerremoto;
		this.porcentajeLluvia = porcentajeLluvia;
		this.porcentajeVidrios = porcentajeVidrios;
		this.porcentajeOtrosEventos = porcentajeOtrosEventos;
		this.minimoTerremoto = minimoTerremoto;
		this.minimoLluvia = minimoLluvia;
		this.minimoOtrosEventos = minimoOtrosEventos;
		this.minimoVidriosCristaes = minimoVidriosCristaes;
	}
	
	// Getters and Setters
	/**
	 * @return the porcentajeTerremoto
	 */
	public BigDecimal getPorcentajeTerremoto() {
		return porcentajeTerremoto;
	}
	/**
	 * @param porcentajeTerremoto the porcentajeTerremoto to set
	 */
	public void setPorcentajeTerremoto(BigDecimal porcentajeTerremoto) {
		this.porcentajeTerremoto = porcentajeTerremoto;
	}
	/**
	 * @return the porcentajeLluvia
	 */
	public BigDecimal getPorcentajeLluvia() {
		return porcentajeLluvia;
	}
	/**
	 * @param porcentajeLluvia the porcentajeLluvia to set
	 */
	public void setPorcentajeLluvia(BigDecimal porcentajeLluvia) {
		this.porcentajeLluvia = porcentajeLluvia;
	}
	/**
	 * @return the porcentajeVidrios
	 */
	public BigDecimal getPorcentajeVidrios() {
		return porcentajeVidrios;
	}
	/**
	 * @param porcentajeVidrios the porcentajeVidrios to set
	 */
	public void setPorcentajeVidrios(BigDecimal porcentajeVidrios) {
		this.porcentajeVidrios = porcentajeVidrios;
	}
	/**
	 * @return the porcentajeOtrosEventos
	 */
	public BigDecimal getPorcentajeOtrosEventos() {
		return porcentajeOtrosEventos;
	}
	/**
	 * @param porcentajeOtrosEventos the porcentajeOtrosEventos to set
	 */
	public void setPorcentajeOtrosEventos(BigDecimal porcentajeOtrosEventos) {
		this.porcentajeOtrosEventos = porcentajeOtrosEventos;
	}
	/**
	 * @return the minimoTerremoto
	 */
	public BigDecimal getMinimoTerremoto() {
		return minimoTerremoto;
	}
	/**
	 * @param minimoTerremoto the minimoTerremoto to set
	 */
	public void setMinimoTerremoto(BigDecimal minimoTerremoto) {
		this.minimoTerremoto = minimoTerremoto;
	}
	/**
	 * @return the minimoLluvia
	 */
	public BigDecimal getMinimoLluvia() {
		return minimoLluvia;
	}
	/**
	 * @param minimoLluvia the minimoLluvia to set
	 */
	public void setMinimoLluvia(BigDecimal minimoLluvia) {
		this.minimoLluvia = minimoLluvia;
	}
	/**
	 * @return the minimoOtrosEventos
	 */
	public BigDecimal getMinimoOtrosEventos() {
		return minimoOtrosEventos;
	}
	/**
	 * @param minimoOtrosEventos the minimoOtrosEventos to set
	 */
	public void setMinimoOtrosEventos(BigDecimal minimoOtrosEventos) {
		this.minimoOtrosEventos = minimoOtrosEventos;
	}
	/**
	 * @return the minimoVidriosCristaes
	 */
	public BigDecimal getMinimoVidriosCristaes() {
		return minimoVidriosCristaes;
	}
	/**
	 * @param minimoVidriosCristaes the minimoVidriosCristaes to set
	 */
	public void setMinimoVidriosCristaes(BigDecimal minimoVidriosCristaes) {
		this.minimoVidriosCristaes = minimoVidriosCristaes;
	}
	
	
	

}
