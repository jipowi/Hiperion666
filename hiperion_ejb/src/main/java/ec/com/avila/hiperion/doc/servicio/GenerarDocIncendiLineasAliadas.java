/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada;

/**
 * <b> Interface de generación del documento PDF </b>
 * 
 * @author Franklin Pozo B.
 * @version 1.0,23/03/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocIncendiLineasAliadas {

	/**
	 * 
	 * <b> Permite generar el XML del ramo Incendio lineas Aliadas </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 23/03/2015]
	 * </p>
	 * 
	 * @param incendioLineasAliada
	 * @return
	 * @throws HiperionException
	 */
	public String generarXmlIncendioLineasAliadas(RamoIncendioLineasAliada incendioLineasAliada) throws HiperionException;

}
