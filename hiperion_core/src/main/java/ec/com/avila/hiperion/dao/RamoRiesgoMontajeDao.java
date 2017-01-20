/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje;

/**
 * <b> Interface local de la tabla RamoRiesgoMontaje que permite realizar las operaciones necesarias </b> </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,12/10/2014
 * @since JDK1.6
 */

@Local
public interface RamoRiesgoMontajeDao extends GenericDAO<RamoRiesgoMontaje, Long> {

}
