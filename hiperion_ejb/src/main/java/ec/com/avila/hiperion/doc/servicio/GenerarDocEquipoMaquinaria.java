/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoEquipoMaquinaria;

/**
 * <b> Interface de generación del documento PDF< </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,23/03/2015
 * @since JDK1.6
 */
@Local
public interface GenerarDocEquipoMaquinaria {

	/**
	 * 
	 * <b> Permite generar el XML del ramo Equipo Maquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 23/03/2015]
	 * </p>
	 * 
	 * @param equipoMaquinaria
	 * @return
	 * @throws HiperionException
	 */
	public String generarXmlEquipoMaquinaria(RamoEquipoMaquinaria equipoMaquinaria) throws HiperionException;

}
