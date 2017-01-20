/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoDao;
import ec.com.avila.hiperion.emision.entities.Ramo;

/**
 * <b> Permite implementar las operaciones de la taba Ramo </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Stateless
public class RamoDaoImpl extends GenericDAOImpl<Ramo, Long> implements RamoDao {

	Logger log = Logger.getLogger(RamoDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public Ramo consultarRamoPorCodigo(String codigoRamo) throws HiperionException {
		try {
			Query query = em.createNamedQuery("Ramo.findByCodigoRamo");
			query.setParameter("codigoRamo", codigoRamo);
			List<Ramo> ramos = query.getResultList();
			return ramos.get(0);
		} catch (Exception ex) {
			log.error("Error no se pudo consultar ramo ", ex);
			throw new HiperionException(ex);
		}
	}

}