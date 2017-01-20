package ec.com.avila.hiperion.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.GenericDAO;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private final Class<T> persistentClass;

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T findById(ID id) {
		return getEntityManager().find(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getEntityManager().createQuery("select o from " + persistentClass.getCanonicalName() + " o").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(String queryName, Object... params) {

		Query qry = getEntityManager().createNamedQuery(queryName);

		int index = 0;

		for (Object p : params) {
			qry.setParameter(index++, p);
		}

		return qry.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQueryAndNamedParams(String queryName, Map<String, ? extends Object> params) {

		Query qry = getEntityManager().createNamedQuery(queryName);

		for (String key : params.keySet()) {
			qry.setParameter(key, params.get(key));
		}

		return qry.getResultList();

	}

	@Override
	public T update(T entity) throws HiperionException {
		try {
			return getEntityManager().merge(entity);
		} catch (Throwable ex) {
			throw new HiperionException(ex);
		}
	}

	@Override
	public void delete(T entity) throws HiperionException {
		try {
			getEntityManager().remove(entity);
		} catch (Throwable ex) {
			throw new HiperionException(ex);
		}
	}

	@Override
	public void delete(ID id) throws HiperionException {
		T obj = findById(id);
		delete(obj);
	}

	@Override
	public void persist(T entity) throws HiperionException {
		try {
			getEntityManager().persist(entity);
		} catch (Throwable ex) {
			throw new HiperionException(ex);
		}
	}

	public EntityManager getEntityManager() {
		return this.em;
	}

}
