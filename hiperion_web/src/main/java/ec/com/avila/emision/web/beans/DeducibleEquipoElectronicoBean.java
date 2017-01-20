/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.beans;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * <b> Guarda los datos de deducibles de equipo electronico. </b>
 * 
 * @author Franklin Pozo.
 * @version 1.0,04/05/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class DeducibleEquipoElectronicoBean {

	private BigDecimal porcentajeValorSiniestroFijos;
	private BigDecimal minimoFijos;
	private BigDecimal porcentajeValorSiniestroDatos;
	private BigDecimal minimoDatos;
	private Integer numeroDiasOperaciones;
	private BigDecimal porcentajeValorSiniestroPortatiles;
	private BigDecimal minimoPortatiles;
	private BigDecimal porcentajeValorSiniestroCelulares;
	private BigDecimal minimoCelulares;
	private BigDecimal porcentajeValorSiniestroHurto;
	private BigDecimal minimoHurto;
	
	//Getters and Setters
	/**
	 * @return the porcentajeValorSiniestroFijos
	 */
	public BigDecimal getPorcentajeValorSiniestroFijos() {
		return porcentajeValorSiniestroFijos;
	}
	/**
	 * @param porcentajeValorSiniestroFijos the porcentajeValorSiniestroFijos to set
	 */
	public void setPorcentajeValorSiniestroFijos(BigDecimal porcentajeValorSiniestroFijos) {
		this.porcentajeValorSiniestroFijos = porcentajeValorSiniestroFijos;
	}
	/**
	 * @return the minimoFijos
	 */
	public BigDecimal getMinimoFijos() {
		return minimoFijos;
	}
	/**
	 * @param minimoFijos the minimoFijos to set
	 */
	public void setMinimoFijos(BigDecimal minimoFijos) {
		this.minimoFijos = minimoFijos;
	}
	/**
	 * @return the porcentajeValorSiniestroDatos
	 */
	public BigDecimal getPorcentajeValorSiniestroDatos() {
		return porcentajeValorSiniestroDatos;
	}
	/**
	 * @param porcentajeValorSiniestroDatos the porcentajeValorSiniestroDatos to set
	 */
	public void setPorcentajeValorSiniestroDatos(BigDecimal porcentajeValorSiniestroDatos) {
		this.porcentajeValorSiniestroDatos = porcentajeValorSiniestroDatos;
	}
	/**
	 * @return the minimoDatos
	 */
	public BigDecimal getMinimoDatos() {
		return minimoDatos;
	}
	/**
	 * @param minimoDatos the minimoDatos to set
	 */
	public void setMinimoDatos(BigDecimal minimoDatos) {
		this.minimoDatos = minimoDatos;
	}
	/**
	 * @return the numeroDiasOperaciones
	 */
	public Integer getNumeroDiasOperaciones() {
		return numeroDiasOperaciones;
	}
	/**
	 * @param numeroDiasOperaciones the numeroDiasOperaciones to set
	 */
	public void setNumeroDiasOperaciones(Integer numeroDiasOperaciones) {
		this.numeroDiasOperaciones = numeroDiasOperaciones;
	}
	/**
	 * @return the porcentajeValorSiniestroPortatiles
	 */
	public BigDecimal getPorcentajeValorSiniestroPortatiles() {
		return porcentajeValorSiniestroPortatiles;
	}
	/**
	 * @param porcentajeValorSiniestroPortatiles the porcentajeValorSiniestroPortatiles to set
	 */
	public void setPorcentajeValorSiniestroPortatiles(BigDecimal porcentajeValorSiniestroPortatiles) {
		this.porcentajeValorSiniestroPortatiles = porcentajeValorSiniestroPortatiles;
	}
	/**
	 * @return the minimoPortatiles
	 */
	public BigDecimal getMinimoPortatiles() {
		return minimoPortatiles;
	}
	/**
	 * @param minimoPortatiles the minimoPortatiles to set
	 */
	public void setMinimoPortatiles(BigDecimal minimoPortatiles) {
		this.minimoPortatiles = minimoPortatiles;
	}
	/**
	 * @return the porcentajeValorSiniestroCelulares
	 */
	public BigDecimal getPorcentajeValorSiniestroCelulares() {
		return porcentajeValorSiniestroCelulares;
	}
	/**
	 * @param porcentajeValorSiniestroCelulares the porcentajeValorSiniestroCelulares to set
	 */
	public void setPorcentajeValorSiniestroCelulares(BigDecimal porcentajeValorSiniestroCelulares) {
		this.porcentajeValorSiniestroCelulares = porcentajeValorSiniestroCelulares;
	}
	/**
	 * @return the minimoCelulares
	 */
	public BigDecimal getMinimoCelulares() {
		return minimoCelulares;
	}
	/**
	 * @param minimoCelulares the minimoCelulares to set
	 */
	public void setMinimoCelulares(BigDecimal minimoCelulares) {
		this.minimoCelulares = minimoCelulares;
	}
	/**
	 * @return the porcentajeValorSiniestroHurto
	 */
	public BigDecimal getPorcentajeValorSiniestroHurto() {
		return porcentajeValorSiniestroHurto;
	}
	/**
	 * @param porcentajeValorSiniestroHurto the porcentajeValorSiniestroHurto to set
	 */
	public void setPorcentajeValorSiniestroHurto(BigDecimal porcentajeValorSiniestroHurto) {
		this.porcentajeValorSiniestroHurto = porcentajeValorSiniestroHurto;
	}
	/**
	 * @return the minimoHurto
	 */
	public BigDecimal getMinimoHurto() {
		return minimoHurto;
	}
	/**
	 * @param minimoHurto the minimoHurto to set
	 */
	public void setMinimoHurto(BigDecimal minimoHurto) {
		this.minimoHurto = minimoHurto;
	}
	


	
}
