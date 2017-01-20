/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */

package ec.com.avila.emision.web.beans;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,13/04/2014
 * @since JDK1.6
 */
public class DetalleAnexoBean {

	private Long idAnexo;
	private String nombreDetalleAnexo;

	/**
	 * @param idAnexo
	 * @param nombreDetalleAnexo
	 */
	public DetalleAnexoBean(Long idAnexo, String nombreDetalleAnexo) {
		this.idAnexo = idAnexo;
		this.nombreDetalleAnexo = nombreDetalleAnexo;
	}

	/**
	 * @return the idAnexo
	 */
	public Long getIdAnexo() {
		return idAnexo;
	}

	/**
	 * @param idAnexo
	 *            the idAnexo to set
	 */
	public void setIdAnexo(Long idAnexo) {
		this.idAnexo = idAnexo;
	}

	/**
	 * @return the nombreDetalleAnexo
	 */
	public String getNombreDetalleAnexo() {
		return nombreDetalleAnexo;
	}

	/**
	 * @param nombreDetalleAnexo
	 *            the nombreDetalleAnexo to set
	 */
	public void setNombreDetalleAnexo(String nombreDetalleAnexo) {
		this.nombreDetalleAnexo = nombreDetalleAnexo;
	}
}
