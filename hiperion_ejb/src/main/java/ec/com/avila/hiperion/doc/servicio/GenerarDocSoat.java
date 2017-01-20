/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoSoat;

/**
 * <b> Interfaz de generacion del documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,28/05/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocSoat {

	/**
	 * 
	 * <b> Permite generar el XML del Rotura de maquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 28/05/2015]
	 * </p>
	 * 
	 * @param ramoSoat
	 * @return
	 * @throws HiperionException
	 */
	String generarXmlSoat(RamoSoat ramoSoat) throws HiperionException;

}
