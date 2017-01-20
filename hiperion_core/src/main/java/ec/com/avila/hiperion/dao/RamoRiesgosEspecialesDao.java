/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */ 
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.RamoRiesgosEsp;

/** 
 * <b>
 * Interface local de la tabla RamoRiesgosEsoeciales
 *  que permite realizar las operaciones necesarias
 * </b>
 *  
 * @author Franklin Pozo
 * @version 1.0,18/11/2014
 * @since JDK1.6
 */
@Local
public interface RamoRiesgosEspecialesDao  extends GenericDAO<RamoRiesgosEsp, Long>{

}
