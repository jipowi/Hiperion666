/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.domain;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza.
 * @version 1.0,31/05/2014
 * @since JDK1.6
 */
public class CondicionEspecial {

	private Long id;
	private String nombre;

	/**
	 * 
	 * @param idAnexo
	 * @param nombreDetalleAnexo
	 */
	public CondicionEspecial(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CondicionEspecial [id=" + id + ", nombre=" + nombre + "]";
	}
}
