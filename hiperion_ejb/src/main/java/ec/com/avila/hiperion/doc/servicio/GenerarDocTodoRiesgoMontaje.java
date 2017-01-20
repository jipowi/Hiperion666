/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje;

/**
 * <b> Interfaz de generacion del documento PDF </b>
 * 
 * @author Franklin Pozo B.
 * @version 1.0,02/06/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocTodoRiesgoMontaje {

	/**
	 * 
	 * <b> Permite Generar el XML Todo Riesgo Montaje </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 02/06/2015]
	 * </p>
	 * 
	 * @param ramoRiesgoMontaje
	 * @return
	 * @throws HiperionException
	 */

	String generarXmlTodoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) throws HiperionException;

}
