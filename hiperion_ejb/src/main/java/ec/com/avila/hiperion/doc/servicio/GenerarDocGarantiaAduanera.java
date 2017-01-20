/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoGarantiaAduanera;

/**
 * <b> Interface de generación del documento PDF. </b>
 * 
 * @author Franklin Pozo B.
 * @version 1.0,23/03/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocGarantiaAduanera {

	/**
	 * 
	 * <b> Permite generar el XML del ramo Garantia Aduanera </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 23/03/2015]
	 * </p>
	 * 
	 * @param garantiaAduanera
	 * @return
	 * @throws HiperionException
	 */
	public String generarXmlGarantiaAduanera(RamoGarantiaAduanera garantiaAduanera) throws HiperionException;

}
