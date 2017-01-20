package ec.com.avila.hiperion.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.DetalleCatalogoDao;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;

/**
 * 
 * <b> Permite implementar las operaciones de la tabla DetalleCatalogo </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Stateless
public class DetalleCatalogoDaoImpl extends GenericDAOImpl<DetalleCatalogo, Long>implements DetalleCatalogoDao {

	@PersistenceContext(unitName = "sgs_pu")
	private EntityManager em;

	public DetalleCatalogoDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<DetalleCatalogo> consultarDetalleCatalogoByCodCatalogo(Long idCatalogo) {
		Query query = em.createNamedQuery("DetalleCatalogo.findByCodCatalogo");
		query.setParameter("idCatalogo", idCatalogo);
		List<DetalleCatalogo> detalleCatalogo = query.getResultList();

		return detalleCatalogo;
	}

	@SuppressWarnings("unchecked")
	public List<DetalleCatalogo> consultarDetalleCatalogoByDepCatalogo(String codDepCatalogo, String codDepDetCalogo) {
		Query query = em.createNamedQuery("DetalleCatalogo.findByCodDepCatalogo");
		query.setParameter("codDepDetalleCatalogo", codDepCatalogo);
		query.setParameter("codDepDetalleCatalogo", codDepDetCalogo);
		List<DetalleCatalogo> detalleCatalogo = query.getResultList();

		return detalleCatalogo;
	}

	@SuppressWarnings("unchecked")
	public List<DetalleCatalogo> consultarDetalleCatalogo() {
		return em.createNamedQuery("DetalleCatalogo.findAll").getResultList();
	}

	public void guardarDetalleCatalogo(DetalleCatalogo detalle) {
		em.persist(detalle);
	}

	public void modificarDetalleCatalogo(DetalleCatalogo detalle) {
		em.merge(detalle);

	}

	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.dao.DetalleCatalogoDao#consultarDetalleCatalogoByCodDetalle(java.lang.String, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleCatalogo> consultarDetalleCatalogoByCodDetalle(String codDepCatalogo, Long idCatalogo) throws HiperionException {
		
		Query query = em.createNamedQuery("DetalleCatalogo.findByCodigoDetalle");
		query.setParameter("codDepDetalleCatalogo", codDepCatalogo);
		query.setParameter("idCatalogo", idCatalogo);
		List<DetalleCatalogo> detalleCatalogo = query.getResultList();

		return detalleCatalogo;
	}

	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.dao.DetalleCatalogoDao#consultarDetalleByCatalogoAndDetalle(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public DetalleCatalogo consultarDetalleByCatalogoAndDetalle(Integer codCatalogo, Integer codDetCalogo) throws HiperionException {
		
		Query query = em.createNamedQuery("DetalleCatalogo.findByCodCatalogoAndCodDetalle");
		query.setParameter("idCatalogo", new Long(codCatalogo.toString()));
		query.setParameter("codDetalleCatalogo", codDetCalogo.toString());
		
		DetalleCatalogo detalle = (DetalleCatalogo) query.getSingleResult();
		
		return detalle;
	}

	
	
}
