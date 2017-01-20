/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.dao.ContactoDao;
import ec.com.avila.hiperion.emision.entities.Contacto;

/**
 * 
 * <b>
 * Clase que implementa operaciones de la tabla Contacto.
 * </b>
 *  
 * @author kruger
 * @version 1.0,Oct 6, 2016
 * @since JDK1.6
 */

@Stateless
public class ContactoDaoImpl extends GenericDAOImpl<Contacto, Long> implements ContactoDao {

	Logger log = Logger.getLogger(ContactoDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;


	
}
