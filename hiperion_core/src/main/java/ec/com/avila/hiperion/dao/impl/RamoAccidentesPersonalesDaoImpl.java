/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoAccidentesPersonalesDao;
import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;

/**
 * <b> Permite implementar las operaciones de la tabla RamoAccidentesPersonales </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,31/12/2013
 * @since JDK1.6
 */

@Stateless
public class RamoAccidentesPersonalesDaoImpl extends GenericDAOImpl<RamoAccidentesPersonale, Long> implements RamoAccidentesPersonalesDao {

	Logger log = Logger.getLogger(RamoAccidentesPersonalesDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.RamoAccidentesPersonalesDao#consultarRamo(java.lang.Integer)
	 */
	@Override
	public RamoAccidentesPersonale consultarRamo(Integer ipPoliza) throws HiperionException {
		Query query = em.createNamedQuery("RamoAccByPoliza");
		query.setParameter("idPoliza", ipPoliza);
		RamoAccidentesPersonale ramo = (RamoAccidentesPersonale) query.getSingleResult();

		return ramo;
	}

}
