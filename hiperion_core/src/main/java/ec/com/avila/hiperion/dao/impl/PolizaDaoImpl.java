/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.emision.entities.Poliza;

/**
 * <b>Permite implementar las operaciones de la tabla Poliza </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@Stateless
public class PolizaDaoImpl extends GenericDAOImpl<Poliza, Long> implements PolizaDao {

	Logger log = Logger.getLogger(PolizaDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.PolizaDao#consultarPolizasByCliente(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Poliza> consultarPolizasByCliente(Integer idcliente) {
		Query query = em.createNamedQuery("Poliza.findByCliente");
		query.setParameter("idCliente", idcliente);

		List<Poliza> polizas = query.getResultList();

		if (!polizas.isEmpty()) {
			return polizas;
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.PolizaDao#obtenerReporteFechas(java.util.Date, java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Poliza> obtenerReporteFechas(Date fechaDesde, Date fechaHasta) {
		Query query = em.createNamedQuery("Poliza.reporte1");
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta", fechaHasta);

		List<Poliza> polizas = query.getResultList();

		if (!polizas.isEmpty()) {
			return polizas;
		} else {
			return null;
		}
	}

}
