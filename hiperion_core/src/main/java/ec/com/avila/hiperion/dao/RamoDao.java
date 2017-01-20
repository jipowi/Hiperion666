/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */

package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Ramo;

/**
 * <b> Interfaz local de la tabla RAMO para realizar las operaciones necesarias</b>
 * 
 * @author Franklin Pozo
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoDao extends GenericDAO<Ramo, Long> {

	/**
	 * 
	 * <b> Permite buscar los ramos por medio del codigo de ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 09/03/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public Ramo consultarRamoPorCodigo(String codigoRamo) throws HiperionException;

}
