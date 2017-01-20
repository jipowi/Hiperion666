/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoTransporte;

/**
 * <b> Servicio de Interface local para realizar las operaciones sobre la tabla RamoTransporte </b>
 * 
 * @author Franklin
 * @version 1.0,30/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoTransporteService {

	/**
	 * 
	 * 
	 * <b> Permite guardar registros en la tabla RamoTranspote </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 30/12/2013]
	 * </p>
	 * 
	 * @param transporte
	 * @throws HiperionException
	 */
	public void guardarRamoTransporte(RamoTransporte ramoTransporte, Poliza poliza) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de RamoTransporte que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Franklin, Date: 30/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoTransporte> consultarRamoTransporte() throws HiperionException;

}
