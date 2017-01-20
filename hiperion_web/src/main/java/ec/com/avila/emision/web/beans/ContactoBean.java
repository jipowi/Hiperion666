/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.com.avila.hiperion.dto.ContactoDTO;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,31/10/2014
 * @since JDK1.6
 */
@ManagedBean(name = "contactoBean")
@ViewScoped
public class ContactoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tipoContacto;
	private String descripcionContacto;

	private Integer longitudDescripcionContacto;

	private List<ContactoDTO> contactosDTO;

	/**
	 * @return the contactosDTO
	 */
	public List<ContactoDTO> getContactosDTO() {
		return contactosDTO;
	}

	/**
	 * @param contactosDTO
	 *            the contactosDTO to set
	 */
	public void setContactosDTO(List<ContactoDTO> contactosDTO) {
		this.contactosDTO = contactosDTO;
	}

	/**
	 * @return the tipoContacto
	 */
	public String getTipoContacto() {
		return tipoContacto;
	}

	/**
	 * @param tipoContacto
	 *            the tipoContacto to set
	 */
	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	/**
	 * @return the descripcionContacto
	 */
	public String getDescripcionContacto() {
		return descripcionContacto;
	}

	/**
	 * @param descripcionContacto
	 *            the descripcionContacto to set
	 */
	public void setDescripcionContacto(String descripcionContacto) {
		this.descripcionContacto = descripcionContacto;
	}

	/**
	 * @return the longitudDescripcionContacto
	 */
	public Integer getLongitudDescripcionContacto() {
		return longitudDescripcionContacto;
	}

	/**
	 * @param longitudDescripcionContacto
	 *            the longitudDescripcionContacto to set
	 */
	public void setLongitudDescripcionContacto(Integer longitudDescripcionContacto) {
		this.longitudDescripcionContacto = longitudDescripcionContacto;
	}
}
