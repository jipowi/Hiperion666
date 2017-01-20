/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRiesgosEsp;

/** 
 * <b>
 * Interfaz de generacion del documento PDF
 * </b>
 *  
 * @author Franklin Pozo B.
 * @version 1.0,25/05/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocRiesgosEspeciales {
	
	/**
	 * 
	 * <b>
	 * Permite generar el XML del Ramo Riesgos Especiales
	 * </b>
	 * <p>[Author: Franklin Pozo B, Date: 25/05/2015]</p>
	 *
	 * @param ramoRiesgosEsp
	 * @return
	 * @throws HiperionException
	 */

	String generarXmlRiesgosEspeciales(RamoRiesgosEsp ramoRiesgosEsp)throws HiperionException;
}
