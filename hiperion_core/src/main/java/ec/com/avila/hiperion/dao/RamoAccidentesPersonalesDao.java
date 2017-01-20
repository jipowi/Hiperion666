/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;

/**
 * <b> Interface local de la tabla RamoAccidentesPersonale </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,30/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoAccidentesPersonalesDao extends GenericDAO<RamoAccidentesPersonale, Long> {

	/**
	 * 
	 * <b> Permite consultar el ramoAccidentePersonales mediante el idPoliza. </b>
	 * <p>
	 * [Author: kruger, Date: 23/11/2016]
	 * </p>
	 * 
	 * @param ipPoliza
	 * @return
	 * @throws HiperionException
	 */
	public RamoAccidentesPersonale consultarRamo(Integer ipPoliza) throws HiperionException;
}
