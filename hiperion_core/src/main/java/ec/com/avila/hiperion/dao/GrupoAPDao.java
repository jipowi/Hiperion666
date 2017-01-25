/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.GrupoAccPersonale;

/**
 * 
 * <b> Interface local de la tabla GrupoAccPersonale que permite realizar las operaciones necesarias </b>
 * 
 * @author kruger
 * @version 1.0,24/01/2017
 * @since JDK1.6
 */
@Local
public interface GrupoAPDao extends GenericDAO<GrupoAccPersonale, Long> {

}
