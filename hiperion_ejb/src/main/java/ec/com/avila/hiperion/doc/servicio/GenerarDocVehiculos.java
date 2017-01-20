/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoVehiculo;

/**
 * <b> Interfaz de generacion del documento PDF </b>
 * 
 * @author Franklin Pozo B.
 * @version 1.0,03/06/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocVehiculos {

	/**
	 * 
	 * <b> Permite Generar el XML Vehículos </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 04/06/2015]
	 * </p>
	 * 
	 * @param ramoVehiculo
	 * @return
	 * @throws HiperionException
	 */
	String generarXmlVehiculos(RamoVehiculo ramoVehiculo) throws HiperionException;

}
