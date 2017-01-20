/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.LimitesCostosAsm;

/**
 * 
 * <b>
 * Interface local de la tabla LimitesCostosAsm que permite realizar las operaciones necesarias.
 * </b>
 *  
 * @author Paul Jimenez
 * @version 1.0,26/07/2015
 * @since JDK1.6
 */
@Local
public interface LimitesCostosAsmDao extends GenericDAO<LimitesCostosAsm, Long> {

}
