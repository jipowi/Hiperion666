/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoCascoAereo;

/**
 * <b> Interface de generación del documento PDF </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/03/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocCascoAereo {

	/**
	 * 
	 * <b> Permite generar el XML del ramo agropecuario. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 18/03/2015]
	 * </p>
	 * 
	 * @param cascoAereo
	 * @return
	 * @throws HiperionException
	 */

	public String generarXmlCascoAereo(RamoCascoAereo cascoAereo) throws HiperionException;

}
