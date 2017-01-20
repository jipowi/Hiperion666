/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */

package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.RamoAseguradora;

/**
 * 
 * <b> Interfaz local de la tabla RamoAseguradora para realizar las operaciones necesarias. </b>
 * 
 * @author kruger
 * @version 1.0,21/11/2016
 * @since JDK1.6
 */
@Local
public interface RamoAseguradoraDao extends GenericDAO<RamoAseguradora, Long> {

}
