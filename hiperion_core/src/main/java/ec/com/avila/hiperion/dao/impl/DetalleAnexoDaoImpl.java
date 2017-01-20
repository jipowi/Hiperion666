package ec.com.avila.hiperion.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.DetalleAnexoDao;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.Titulo;

/**
 * 
 * <b> Permite implementar las operaciones de la tabla DetalleAnexo </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Stateless
public class DetalleAnexoDaoImpl extends GenericDAOImpl<DetalleAnexo, Long> implements DetalleAnexoDao {

	@PersistenceContext(unitName = "sgs_pu")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.DetalleAnexoDao#consultarDetallesByTitulo(java.lang.Long, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleAnexo> consultarDetallesByTitulo(Long idRamo, Long idTitulo) throws HiperionException {
		Query query = em.createNamedQuery("DetalleAnexo.findByRamoAndTitulo");
		query.setParameter("idRamo", idRamo);
		query.setParameter("idTitulo", idTitulo);
		List<DetalleAnexo> detalles = query.getResultList();

		return detalles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.DetalleAnexoDao#consultarIdTitulo(java.lang.Long)
	 */
	@Override
	public Long consultarIdTitulo(Long idDetalleAnexo) throws HiperionException {
		Query query = em.createNamedQuery("Titulo.findByIdDetalleAnexo");
		query.setParameter("idDetalleAnexo", idDetalleAnexo);
		Titulo titulo = (Titulo) query.getSingleResult();

		return titulo.getIdTitulo();
	}

}
