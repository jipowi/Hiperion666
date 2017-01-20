package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;

/**
 * <b>Interface de generación del documento PDF</b>
 * 
 * @author gyandun
 * @version 1.0
 *          <p>
 *          [$Author: gyandun $, $Date: 02/05/2014 $]
 *          </p>
 */
@Local
public interface GenerarDocAgropecuario {

	/**
	 * 
	 * <b> Permite generar el XML del ramo agropecuario. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 15/03/2015]
	 * </p>
	 * 
	 * @param agropecuario
	 * @return
	 * @throws HiperionException
	 */
	String generarXmlAgropecuario(RamoAgropecuario agropecuario) throws HiperionException;

}
