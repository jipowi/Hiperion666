/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.RamoLcIncendio;

/**
 * <b> Interface local de la tabla RamoLucroCesanteIncendio que permite realizar las operaciones necesarias </b>
 * 
 * @author Susana Diaz
 * @version 1.0,15/01/2014
 * @since JDK1.6
 */
@Local
public interface RamoLucroCesanteIncendioDao extends GenericDAO<RamoLcIncendio, Long> {

}
