package ec.com.avila.hiperion.web.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.persistence.Transient;

/**
 * 
 * <b> Mensajes para propiedades de W2F </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Jul 8, 2014
 * @since JDK1.6
 */
public class HiperionMensajes {
	private final static HiperionMensajes INSTANCIA = new HiperionMensajes();
	private final static String BUNDLE_NAME = "ec.com.avila.hiperion.web.util.hiperion";

	@Transient
	private ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);

	public HiperionMensajes() {
		Locale locale = new Locale("");

		resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
	}

	/**
	 * 
	 * <b> Obtener la instancia singleton del controlador de mensajes de internacionalizacion </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 8, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public static HiperionMensajes getInstancia() {
		return INSTANCIA;
	}

	/**
	 * 
	 * <b> Recupera una valor del archivo de propiedades dado la clave </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 8, 2014]
	 * </p>
	 * 
	 * @param key
	 * @return
	 */
	public String getString(final String key) {
		String resultado = "";
		try {
			resultado = resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			resultado = '!' + key + '!';
		}
		return resultado;
	}

	/**
	 * 
	 * <b> Recupera una valor del archivo de propiedades dado la clave como entero Largo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 8, 2014]
	 * </p>
	 * 
	 * @param key
	 * @return
	 */
	public Long getLong(final String key) {
		try {
			return Long.valueOf(resourceBundle.getString(key));
		} catch (MissingResourceException e) {
			return null;
		}
	}

	/**
	 * 
	 * <b> Recupera una valor del archivo de propiedades dado la clave como entero </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 8, 2014]
	 * </p>
	 * 
	 * @param key
	 * @return
	 */
	public Integer getInteger(final String key) {
		try {
			return Integer.valueOf(resourceBundle.getString(key));
		} catch (MissingResourceException e) {
			return null;
		}
	}

	/**
	 * <b>Obtiene un mensaje del archivo de internacionalizaci&oacute;n con ciertos parametros de relleno</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 8, 2014]
	 * </p>
	 * 
	 * @param key
	 *            Clave del archivo de internacionalizacion
	 * @param parameters
	 *            Parametros de relleno
	 * @return Mensaje obtenido desde el archivo de internacionalizacion con los parametros establecidos
	 */
	public String getString(final String key, final String... parameters) {
		try {
			final MessageFormat formatter = new MessageFormat(resourceBundle.getString(key), resourceBundle.getLocale());
			return formatter.format(parameters);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

}
