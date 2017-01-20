/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dto;

import java.util.Date;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Mar 23, 2014
 * @since JDK1.6
 */
public class ModalidadFamiliaDTO {

	public String nombre;
	public String cedula;
	public Date fechaNacimiento;
	public Integer edad;
	public String parentesco;

	/**
	 * @param nombre
	 * @param cedula
	 * @param fechaNacimiento
	 * @param edad
	 * @param pimaNeta
	 * @param parentesco
	 */
	public ModalidadFamiliaDTO(String nombre, String cedula, Date fechaNacimiento, Integer edad, String parentesco) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.parentesco = parentesco;
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

}
