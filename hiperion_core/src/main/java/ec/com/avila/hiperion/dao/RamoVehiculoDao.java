/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.RamoVehiculo;

/**
 * <b> Interfaz local de la tabla RamoVehiculos para realizar las operaciones necesarias </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,29/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoVehiculoDao extends GenericDAO<RamoVehiculo, Long> {

}
