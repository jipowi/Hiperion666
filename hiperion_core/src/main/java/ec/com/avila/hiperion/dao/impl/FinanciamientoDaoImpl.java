/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.emision.entities.Financiamiento;

/**
 * <b>Permite implementar las operaciones de la tabla Financiamiento </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@Stateless
public class FinanciamientoDaoImpl extends GenericDAOImpl<Financiamiento, Long> implements FinanciamientoDao {

	Logger log = Logger.getLogger(FinanciamientoDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

}
