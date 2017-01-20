/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRoboAsalto;

/**
 * <b> Interfaz de generacion del documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,25/05/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocRoboAsalto {
	
	/**
	 * 
	 * <b>
	 *  Permite generar el XML del Ramo Robo y/o Asalto
	 * </b>
	 * <p>[Author: Franklin Pozo B, Date: 25/05/2015]</p>
	 *
	 * @param ramoRoboAsalto
	 * @return
	 * @throws HiperionException
	 */
	
	String generarXmlRoboAsalto(RamoRoboAsalto ramoRoboAsalto)throws HiperionException;

}
