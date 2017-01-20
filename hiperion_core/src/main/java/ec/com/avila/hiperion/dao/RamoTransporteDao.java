/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.RamoTransporte;

/**
 * <b> Interfaz local de la tabla RamoTransporte para realizar las operaciones necesarias en la base de datos </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,30/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoTransporteDao extends GenericDAO<RamoTransporte, Long> {

}
