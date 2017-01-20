/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.backings;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.com.avila.hiperion.emision.entities.Usuario;

/**
 * <b> Permite adminitrar la seguridad de la aplicacion </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Nov 8, 2014
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class SessionBacking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
