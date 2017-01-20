package ec.com.avila.hiperion.mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * <b> Utilitario para obtener mensajes de archivos de propiedades< </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Oct 9, 2014
 * @since JDK1.6
 */
public class Utils {
	// Unica variable de la clase
	private static Utils INSTANCIA = new Utils();

	// Constructor Privado Singleton
	private Utils() {

	}

	/**
	 * 
	 * <b> Devuelve una instancia de la clase Utils </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 9, 2014]
	 * </p>
	 *
	 * @return
	 */
	public static Utils getInstancia() {
		return INSTANCIA;
	}

	public static Properties properties;

	/**
	 * 
	 * <b> ermite obtener el valor de una propiedad del archivo de propiedades. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 9, 2014]
	 * </p>
	 *
	 * @param key
	 * @return
	 */
	public String obtenerPropiedad(String key) {
		if (properties == null) {
			InputStream inputStream = new Utils().getClass().getClassLoader().getResourceAsStream("mail.properties");
			try {
				properties = new Properties();
				properties.load(inputStream);
				inputStream.close();
			} catch (IOException e) {
				return null;
			}
		}
		return properties.getProperty(key);
	}
}
