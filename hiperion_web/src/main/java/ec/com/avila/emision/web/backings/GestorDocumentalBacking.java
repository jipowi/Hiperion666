/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.backings;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * <b> Permite manejar el gestor documental y las operaciones que este conlleva </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Nov 3, 2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class GestorDocumentalBacking {
	public String cliente;
	public String cedula;

	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
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

}
