/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoResponsabilidadCivil;

/**
 * <b> Interface de generación del documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,16/05/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocResponsabilidadCivil {

	/**
	 * 
	 * <b> Permite generar el XML del ramo Responsabilidad Civil </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 16/05/2015]
	 * </p>
	 * 
	 * @param ramoResponsabilidadCivil
	 * @return
	 * @throws HiperionException
	 */

	public String generarXmlResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil) throws HiperionException;

}
