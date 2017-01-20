/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoVehiculo;

/**
 * <b> Servicio de interfaz local que realiza las operaciones sobre la tabla RamoVehiculo </b>
 * 
 * @author Franklin
 * @version 1.0,29/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoVehiculoService {

	/**
	 * 
	 * <b> Permite guardar obetos en la tabla RamoVehiculo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param vehiculo
	 * @throws HiperionException
	 */
	public void guardarRamoVehiculo(RamoVehiculo ramoVehiculo,  Poliza poliza) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista del RamoVehiculo que se encuentra en la base de datos. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoVehiculo> consultarRamoVehiculo() throws HiperionException;

}
