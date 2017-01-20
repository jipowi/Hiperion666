/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoLcRotMaq;

/**
 * <b> Interface de generación del documento PDF </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,23/03/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocLucroCesanteRoturaMaquinaria {

	/**
	 * 
	 * <b> Permite generar el XML del ramo lucro cesante rotura de maquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 23/03/2015]
	 * </p>
	 * 
	 * @param ramoLcRotMaq
	 * @return
	 * @throws HiperionException
	 */
	public String generarXmlLucroCesanteRoturaMaquinaria(RamoLcRotMaq ramoLcRotMaq) throws HiperionException;

}
