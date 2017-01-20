/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.Contacto;

/**
 * 
 * <b> Interfaz local para operaciones sobre la tabla de contacto. </b>
 * 
 * @author kruger
 * @version 1.0,Oct 6, 2016
 * @since JDK1.6
 */

@Local
public interface ContactoDao extends GenericDAO<Contacto, Long> {

}
