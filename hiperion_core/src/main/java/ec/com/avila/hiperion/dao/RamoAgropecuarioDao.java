/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.ArchivoBase;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;

/**
 * <b> Interfaz local de la tabla RAMO_AGROPECUARIO para realizar las operaciones necesarias. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,09/03/2014
 * @since JDK1.6
 */

@Local
public interface RamoAgropecuarioDao extends GenericDAO<RamoAgropecuario, Long> {

	/**
	 * 
	 * <b> Permite guardar un archivo en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 19, 2014]
	 * </p>
	 * 
	 * @param file
	 * @throws HiperionException
	 */
	public void guardarArchivoPoliza(ArchivoBase file) throws HiperionException;

}
