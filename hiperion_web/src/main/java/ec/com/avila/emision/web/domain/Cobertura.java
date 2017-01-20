/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.domain;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author DARVIN
 * @version 1.0,31/05/2014
 * @since JDK1.6
 */
public class Cobertura {

	private Long id;
	private String nombre;
	private Double Valor;

	/**
	 * 
	 * @param idAnexo
	 * @param nombreDetalleAnexo
	 */
	public Cobertura(Long id, String nombre) {
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

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return Valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(Double valor) {
		Valor = valor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cobertura [id=" + id + ", nombre=" + nombre + ", Valor=" + Valor + "]";
	}
}
