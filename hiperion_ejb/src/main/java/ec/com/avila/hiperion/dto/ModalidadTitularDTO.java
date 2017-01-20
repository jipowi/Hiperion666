/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Mar 23, 2014
 * @since JDK1.6
 */
public class ModalidadTitularDTO {

	public String nombre;
	public String cedula;
	public Date fechaNacimiento;
	public Integer edad;
	public BigDecimal primaNeta;
	public Integer grupo;
	public BigDecimal valorGrupo;

	
	
	/**
	 * @param nombre
	 * @param cedula
	 * @param fechaNacimiento
	 * @param edad
	 * @param primaNeta
	 * @param grupo
	 * @param valorGrupo
	 */
	public ModalidadTitularDTO(String nombre, String cedula, Date fechaNacimiento, Integer edad, BigDecimal primaNeta, Integer grupo, BigDecimal valorGrupo) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.primaNeta = primaNeta;
		this.grupo = grupo;
		this.valorGrupo = valorGrupo;
	}

	
	// Geters and Setters
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
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 *            the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}

	/**
	 * @param edad
	 *            the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	/**
	 * @return the primaNeta
	 */
	public BigDecimal getPrimaNeta() {
		return primaNeta;
	}

	/**
	 * @param primaNeta
	 *            the primaNeta to set
	 */
	public void setPrimaNeta(BigDecimal primaNeta) {
		this.primaNeta = primaNeta;
	}

	/**
	 * @return the grupo
	 */
	public Integer getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo
	 *            the grupo to set
	 */
	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the valorGrupo
	 */
	public BigDecimal getValorGrupo() {
		return valorGrupo;
	}

	/**
	 * @param valorGrupo
	 *            the valorGrupo to set
	 */
	public void setValorGrupo(BigDecimal valorGrupo) {
		this.valorGrupo = valorGrupo;
	}

}
