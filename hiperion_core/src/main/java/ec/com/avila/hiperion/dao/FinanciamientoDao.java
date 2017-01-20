/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.Financiamiento;

/**
 * <b>Interface local de la tabla Financiamiento para realizar las operaciones
 * necesarias </b>
 * 
 * @author Paul Jimenez
 * @version 1.0, 20/10/2013
 * @since JDK1.6
 */
@Local
public interface FinanciamientoDao extends GenericDAO<Financiamiento, Long> {

	
}
