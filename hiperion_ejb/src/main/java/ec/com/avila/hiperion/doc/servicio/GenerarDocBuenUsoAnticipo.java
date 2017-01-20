/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt;

/** 
 * <b>
 * Interface de generación del documento PDF
 * </b>
 *  
 * @author Franklin Pozo 
 * @version 1.0,17/03/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocBuenUsoAnticipo {

	/**
	 * 
	 * <b>
	 * Permite generar el XML de ramo Buen Uso de anticipo.
	 * </b>
	 * <p>[Author: Avila Sistemas, Date: 17/03/2015]</p>
	 *
	 * @param buenUsoAnt
	 * @return
	 * @throws HiperionException
	 */
	public String generarXmlBuenUsoAnticipo(RamoBuenUsoAnt buenUsoAnt) throws HiperionException;
}
