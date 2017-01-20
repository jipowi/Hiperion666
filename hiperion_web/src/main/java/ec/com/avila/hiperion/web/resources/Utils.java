/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.resources;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

/**
 * <b> Contiene metodos utiles para el proyecto </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Oct 12, 2014
 * @since JDK1.6
 */
public class Utils implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Utils INSTANCIA = new Utils();

	// Devuelve la unica instancia de la clase
	public static Utils getInstancia() {
		return INSTANCIA;
	}

	/**
	 * 
	 * <b> Permite obtener el path completo de la aplicacion desplegada </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 12, 2014]
	 * </p>
	 *
	 * @param request
	 * @return
	 */
	public String obtenerPathCompleto(HttpServletRequest request) {
		String url = request.getRequestURL().toString();
		String contextPath = request.getContextPath();
		return url.substring(0, url.indexOf(contextPath)) + contextPath;
	}

}
