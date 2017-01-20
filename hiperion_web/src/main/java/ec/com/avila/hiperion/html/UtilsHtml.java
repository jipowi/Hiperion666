package ec.com.avila.hiperion.html;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 * <b> Utilitario para el manejo de HTML </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Oct 9, 2014
 * @since JDK1.6
 */
public class UtilsHtml {

	private static UtilsHtml INTANCIA = new UtilsHtml();

	// Singleton
	private UtilsHtml() {

	}

	public static UtilsHtml getInstancia() {
		return INTANCIA;
	}

	/**
	 * 
	 * <b> Permite obtener el contenido HTML de un archivo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 9, 2014]
	 * </p>
	 *
	 * @param nombrePlantilla
	 *            Nombre del archivo a recuperar
	 * @return Devuelve una cadena con el HTML a enviar
	 */
	public String obtenerContenidoHTML(String nombrePlantilla) {
		InputStream streamFile = UtilsHtml.class.getResourceAsStream((nombrePlantilla));
		return obtenerPlantillaHTML(streamFile);
	}

	/**
	 * 
	 * <b> Permite obtener el String con el HTML a enviar. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 9, 2014]
	 * </p>
	 *
	 * @param inputStrem
	 *            Inputsteam del archivo HTML
	 * @return Devuelve una cadena con el HTML a enviar
	 */
	public String obtenerPlantillaHTML(InputStream inputStrem) {
		// Especifica la plantilla encontrada.
		String plantilla = null;
		String descripcion = null;
		try {
			// Controlar el resultado.
			if (inputStrem != null) {
				// Obtener el archivo.
				plantilla = "";
				// Verificar si existe la plantilla.
				BufferedReader in = new BufferedReader(new InputStreamReader(inputStrem));
				while ((descripcion = in.readLine()) != null) {
					plantilla = plantilla.concat(descripcion);
				}
				// Cerrar el stream.
				in.close();
				inputStrem.close();
			}

		} catch (Exception ex) {

		}
		// Retornar el resultado.
		return plantilla;
	}
}
