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
import ec.com.avila.hiperion.dao.RamoAccidentesPersonalesDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddAccPer;
import ec.com.avila.hiperion.emision.entities.CobertAccPer;
import ec.com.avila.hiperion.emision.entities.CondEspAccPer;
import ec.com.avila.hiperion.emision.entities.GrupoAccPersonale;
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
	public RamoAccidentesPersonale consultarRamoAcc(Integer ipPoliza) throws HiperionException {
		try {
			Query query = em.createNamedQuery("Ramo.findAccByPoliza");
			query.setParameter("idPoliza", ipPoliza);
			RamoAccidentesPersonale ramo = (RamoAccidentesPersonale) query.getSingleResult();

			return ramo;

		} catch (Exception e) {
			log.error("Error no se pudo consultar el Ramo ", e);
			throw new HiperionException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.RamoAccidentesPersonalesDao#cosultarGruposByRamo(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<GrupoAccPersonale> cosultarGruposByRamo(Long idRamo) throws HiperionException {
		try {
			Query query = em.createNamedQuery("GrupoAccP.findByRamo");
			query.setParameter("idRamo", idRamo);

			List<GrupoAccPersonale> grupos = query.getResultList();

			return grupos;
		} catch (Exception e) {
			log.error("Error no se pudo consultar los grupos ", e);
			throw new HiperionException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.RamoAccidentesPersonalesDao#consultarCoberturasByRamo(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CobertAccPer> consultarCoberturasByRamo(Long idRamo) throws HiperionException {
		try {
			Query query = em.createNamedQuery("CoberturaAccP.findByRamo");
			query.setParameter("idRamo", idRamo);

			List<CobertAccPer> coberturas = query.getResultList();

			return coberturas;
		} catch (Exception e) {
			log.error("Error no se pudo consultar las coberturas ", e);
			throw new HiperionException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.RamoAccidentesPersonalesDao#consultarCondicionesByRamo(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CondEspAccPer> consultarCondicionesByRamo(Long idRamo) throws HiperionException {
		try {
			Query query = em.createNamedQuery("CondicionesAccP.findByRamo");
			query.setParameter("idRamo", idRamo);

			List<CondEspAccPer> condiciones = query.getResultList();

			return condiciones;
		} catch (Exception e) {
			log.error("Error no se pudo consultar las condiciones ", e);
			throw new HiperionException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.RamoAccidentesPersonalesDao#consultarClausulasByRamo(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ClausulasAddAccPer> consultarClausulasByRamo(Long idRamo) throws HiperionException {
		try {
			Query query = em.createNamedQuery("ClausulasAccp.findByRamo");
			query.setParameter("idRamo", idRamo);

			List<ClausulasAddAccPer> clausulas = query.getResultList();

			return clausulas;
		} catch (Exception e) {
			log.error("Error no se pudo consultar las clausulas ", e);
			throw new HiperionException(e);
		}
	}

}
