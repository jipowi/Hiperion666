/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoCascoMaritimo;

/**
 * <b> Interface de generación del documento PDF </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/03/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocCascoMaritimo {

	/**
	 * 
	 * <b> Permite generar el XML del ramo casco maritimo </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 18/03/2015]
	 * </p>
	 * 
	 * @param cascoMaritimo
	 * @return
	 * @throws HiperionException
	 */

	public String generarXmlCascoMaritimo(RamoCascoMaritimo cascoMaritimo) throws HiperionException;

}
