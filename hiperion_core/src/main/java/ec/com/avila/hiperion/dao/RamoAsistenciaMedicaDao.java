/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.RamoAsistenciaMedica;

/**
 * <b>Interfaz local para el manejo de las opercaciones correspondientes a la tabla RamoAsistenciaMedica</b>
 * 
 * @author Franklin
 * @version 1.0,30/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoAsistenciaMedicaDao extends GenericDAO<RamoAsistenciaMedica, Long> {

}
