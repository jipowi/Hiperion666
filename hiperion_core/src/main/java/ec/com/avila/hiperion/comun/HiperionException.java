/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.comun;

/**
 * <b> Clase con la exception para el proyecto</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Jan 19, 2014
 * @since JDK1.6
 */

public class HiperionException extends Exception {

	private static final long serialVersionUID = 1L;

	public HiperionException() {
		super();
	}

	public HiperionException(String message) {
		super(message);
	}

	public HiperionException(String message, Throwable cause) {
		super(message, cause);
	}

	public HiperionException(Throwable cause) {
		super(cause);
	}
}
