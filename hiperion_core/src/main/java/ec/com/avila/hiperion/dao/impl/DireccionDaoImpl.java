/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.dao.DireccionDao;
import ec.com.avila.hiperion.emision.entities.Direccion;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,10/09/2014
 * @since JDK1.6
 */
@Stateless
public class DireccionDaoImpl extends GenericDAOImpl<Direccion, Long> implements DireccionDao {

	Logger log = Logger.getLogger(ClienteDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	
}
