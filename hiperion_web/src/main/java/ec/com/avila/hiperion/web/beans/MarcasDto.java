/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.beans;

/**
 * 
 * <b> Permite manejar la informacion de las marcas de vehiculos </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Jun 22, 2014
 * @since JDK1.6
 */
public class MarcasDto {

	private String marca;
	private String logo;

	
	/**
	 * @param marca
	 * @param logo
	 */
	public MarcasDto(String marca, String logo) {
		super();
		this.marca = marca;
		this.logo = logo;
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
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo
	 *            the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

}
