/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.beans;

/**
 * <b> Permite manejar la infroamcion de los paises</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Apr 12, 2014
 * @since JDK1.6
 */

public class PaisDto {

	private String nombre;
	private String bandera;

	/**
	 * @param nombre
	 * @param bandera
	 * @param numero
	 */
	public PaisDto(String nombre, String bandera) {
		super();
		this.nombre = nombre;
		this.bandera = bandera;
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
	 * @return the bandera
	 */
	public String getBandera() {
		return bandera;
	}

	/**
	 * @param bandera
	 *            the bandera to set
	 */
	public void setBandera(String bandera) {
		this.bandera = bandera;
	}

}
