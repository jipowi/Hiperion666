/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;

/**
 * <b>Permite implementar las operaciones de la tabla PagoPoliza </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@Stateless
public class PagoPolizaDaoImpl extends GenericDAOImpl<PagoPoliza, Long> implements PagoPolizaDao {

	Logger log = Logger.getLogger(PagoPolizaDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

}
