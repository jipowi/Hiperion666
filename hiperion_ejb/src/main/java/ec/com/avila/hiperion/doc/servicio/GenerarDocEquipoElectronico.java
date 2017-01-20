/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoEquipoElectronico;

/**
 * <b> Interface de generación del documento PDF </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,23/03/2015
 * @since JDK1.6
 */

@Local
public interface GenerarDocEquipoElectronico {

	/**
	 * 
	 * <b> Permite generar el XML del ramo Equipo Electronico </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 23/03/2015]
	 * </p>
	 * 
	 * @param equipoElectronico
	 * @return
	 * @throws HiperionException
	 */
	public String generarXmlEquipoElectronico(RamoEquipoElectronico equipoElectronico) throws HiperionException;

}
