/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoLcIncendio;

/**
 * <b> Interface de generación del documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,13/05/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocLuCesanIncendioLineasAliadas {

	/**
	 * 
	 * <b> Permite generar el XML del ramo Lucro Cesante Incendio Lineas Aliadas </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 13/05/2015]
	 * </p>
	 * 
	 * @param lcIncendio
	 * @return
	 * @throws HiperionException
	 */
	public String generarXmlLucCesIncendioLineasAliadas(RamoLcIncendio lcIncendio) throws HiperionException;

}
