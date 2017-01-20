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

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.TipoDireccionDao;
import ec.com.avila.hiperion.emision.entities.TipoDireccion;

/**
 * <b> Permite implementar las operaciones de la tabla TipoDireccion. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,08/06/2014
 * @since JDK1.6
 */
@Stateless
public class TipoDireccionDaoImpl implements TipoDireccionDao {

	@PersistenceContext(unitName = "sgs_pu")
	private EntityManager em;

	public TipoDireccionDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<TipoDireccion> consultarTiposDireccion() throws HiperionException {
		return em.createNamedQuery("TipoDireccion.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	public TipoDireccion consultarTipoDireccionByCodigo(String codTipoDireccion) {
		Query query = em.createNamedQuery("TipoDireccion.findCodigo");
		query.setParameter("codTipoDireccion", codTipoDireccion);
		List<TipoDireccion> catalogo = query.getResultList();
		return catalogo.get(0);
	}

	@SuppressWarnings("unchecked")
	public TipoDireccion consultarTipoDireccionByDescripcion(String descripcion) throws HiperionException {
		Query query = em.createNamedQuery("TipoDireccion.findDescripcion");
		query.setParameter("descripcion", descripcion);
		List<TipoDireccion> catalogo = query.getResultList();
		return catalogo.get(0);
	}

}
