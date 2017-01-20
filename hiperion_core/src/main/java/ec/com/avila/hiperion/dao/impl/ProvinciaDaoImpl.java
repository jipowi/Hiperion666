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
import ec.com.avila.hiperion.dao.ProvinciaDao;
import ec.com.avila.hiperion.emision.entities.Provincia;

/**
 * 
 * <b> Permite implementar las operaciones de la tabla Provincia </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Stateless
public class ProvinciaDaoImpl extends GenericDAOImpl<Provincia, Long> implements ProvinciaDao {

	Logger log = Logger.getLogger(ProvinciaDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	private EntityManager em;

	public ProvinciaDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<Provincia> consultarProvincias() throws HiperionException {
		try {
			return em.createNamedQuery("Provincia.findAll").getResultList();
		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> ProvinciaDaoImpl.consultarProvincias: Line 40", ex);
			throw new HiperionException(ex);
		}
	}

	@SuppressWarnings("unchecked")
	public Provincia consultarProvinciaPorCodigo(String codigo) throws HiperionException {
		try {
			Query query = em.createNamedQuery("Provincia.findByCodProvincia");
			query.setParameter("codigo", codigo);
			List<Provincia> provincias = query.getResultList();
			return provincias.get(0);
		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> ProvinciaDaoImpl.consultarProvinciaPorCodigo: Line 45", ex);
			throw new HiperionException(ex);
		}
	}

	
}
