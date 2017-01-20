/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;

/**
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla Ramo</b>
 * 
 * @author Susana Diaz
 * @version 1.0,16/01/2014
 * @since JDK1.6
 */
@Local
public interface RamoService {

	/**
	 * 
	 * <b> Permite Obtener el Ramo en base al codigo del Ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 09/03/2014]
	 * </p>
	 * 
	 * @param codigoRamo
	 *            - C&oacute;digo del Ramo
	 * @return - Ramo
	 * @throws HiperionException
	 *             - Excepci&oacute;n del servicio
	 */
	public Ramo consultarRamoPorCodigo(String codigoRamo) throws HiperionException;

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
