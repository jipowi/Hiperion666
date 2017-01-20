/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * <b> Agrega varios tipos de mensajes al contexto de JSF </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Jul 28, 2014
 * @since JDK1.6
 */
public class MessagesController {

	/**
	 * <b> Agrega un mensaje informativo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 28, 2014]
	 * </p>
	 * 
	 * @param keyMessage
	 *            - Id del mensaje, este puede ser nulo
	 * @param message
	 *            - Contenido del mensaje
	 */
	public static void addInfo(String keyMessage, String message) {
		FacesContext.getCurrentInstance().addMessage(keyMessage, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message));
	}

	/**
	 * <b> Agrega un mensaje de advertencia</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 28, 2014]
	 * </p>
	 * 
	 * @param keyMessage
	 *            - Id del mensaje, este puede ser nulo
	 * @param message
	 *            - Contenido del mensaje
	 */
	public static void addWarn(String keyMessage, String message) {
		FacesContext.getCurrentInstance().addMessage(keyMessage, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", message));
	}

	/**
	 * <b> Agrega un mensaje de error</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 28, 2014]
	 * </p>
	 * 
	 * @param keyMessage
	 *            - Id del mensaje, este puede ser nulo
	 * @param message
	 *            - Contenido del mensaje
	 */
	public static void addError(String keyMessage, String message) {
		FacesContext.getCurrentInstance().addMessage(keyMessage, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
	}

	/**
	 * <b> Agrega un mensaje de error grave</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 28, 2014]
	 * </p>
	 * 
	 * @param keyMessage
	 *            - Id del mensaje, este puede ser nulo
	 * @param message
	 *            - Contenido del mensaje
	 */
	public static void addFatal(String keyMessage, String message) {
		FacesContext.getCurrentInstance().addMessage(keyMessage, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", message));
	}

	/**
	 * <b> Agrega un mensaje informativo de session</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 28, 2014]
	 * </p>
	 * 
	 * @param keyMessage
	 *            - Id de la variable de sesión utilizada para guardar el mensaje, esta no puede ser nula
	 * @param message
	 *            - Contenido del mensaje
	 */
	public static void addInfoSession(String keyMessage, String message) {
		addMessageSession(keyMessage, message, FacesMessage.SEVERITY_INFO);
	}

	/**
	 * <b> Agrega un mensaje de advertencia a la sesión</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 28, 2014]
	 * </p>
	 * 
	 * @param keyMessage
	 *            - Id de la variable de sesión utilizada para guardar el mensaje, esta no puede ser nula
	 * @param message
	 *            - Contenido del mensaje
	 */
	public static void addWarnSession(String keyMessage, String message) {
		addMessageSession(keyMessage, message, FacesMessage.SEVERITY_WARN);
	}

	/**
	 * <b> Agrega un mensaje de error a la sesión</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 28, 2014]
	 * </p>
	 * 
	 * @param keyMessage
	 *            - Id de la variable de sesión utilizada para guardar el mensaje, esta no puede ser nula
	 * @param message
	 *            - Contenido del mensaje
	 */
	public static void addErrorSession(String keyMessage, String message) {
		addMessageSession(keyMessage, message, FacesMessage.SEVERITY_ERROR);
	}

	/**
	 * <b> Agrega un mensaje de error grave a la sesión</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 28, 2014]
	 * </p>
	 * 
	 * @param keyMessage
	 *            - Id de la variable de sesión utilizada para guardar el mensaje, esta no puede ser nula
	 * @param message
	 *            - Contenido del mensaje
	 */
	public static void addFatalSession(String keyMessage, String message) {
		addMessageSession(keyMessage, message, FacesMessage.SEVERITY_FATAL);
	}

	private static void addMessageSession(String keyMessage, String message, Severity severity) {
		if (keyMessage != null)
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(keyMessage, new FacesMessage(severity, message, message));
	}

	/**
	 * Asigna un mensaje al contexto de JSF previamente almacenado en sesión mediante una clave
	 * 
	 * @param keyMessage
	 */
	public static void viewMessageSession(String keyMessage) {
		if (keyMessage != null) {
			FacesMessage fm = (FacesMessage) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(keyMessage);
			if (fm != null)
				FacesContext.getCurrentInstance().addMessage(keyMessage, fm);
		}
	}
}
