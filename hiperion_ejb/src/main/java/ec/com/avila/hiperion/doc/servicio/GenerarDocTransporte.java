/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoTransporte;

/**
 * <b> Interfaz de generacion del documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,02/06/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocTransporte {

	/**
	 * 
	 * <b> Permite Generar el XML Transporte </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 02/06/2015]
	 * </p>
	 * 
	 * @param ramoTransporte
	 * @return
	 * @throws HiperionException
	 */
	String generarXmlTransporte(RamoTransporte ramoTransporte) throws HiperionException;

}
