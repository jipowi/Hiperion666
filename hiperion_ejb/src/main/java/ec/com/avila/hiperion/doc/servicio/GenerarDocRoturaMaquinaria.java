/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRoturaMaquinaria;

/**
 * <b> Interfaz de generacion del documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,27/05/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocRoturaMaquinaria {

	/**
	 * 
	 * <b> Permite generar el XML del Rotura de maquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 27/05/2015]
	 * </p>
	 * 
	 * @param ramoRoturaMaquinaria
	 * @return
	 * @throws HiperionException
	 */
	String generarXmlRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) throws HiperionException;

}
