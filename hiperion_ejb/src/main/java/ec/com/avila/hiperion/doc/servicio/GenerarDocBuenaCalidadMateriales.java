/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoBuenaCalMat;

/**
 * <b> Interface de generación del documento PDF </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,17/03/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocBuenaCalidadMateriales {

	/**
	 * 
	 * <b> Permite generar elXML del ramo agropecuario </b>
	 * <p>
	 * [Author: Avila Franklin Pozo, Date: 17/03/2015]
	 * </p>
	 * 
	 * @param buenaCalMat
	 * @return
	 * @throws HiperionException
	 */
	public String generarXmlBuenaCalidadMateriales(RamoBuenaCalMat buenaCalMat) throws HiperionException;
}
