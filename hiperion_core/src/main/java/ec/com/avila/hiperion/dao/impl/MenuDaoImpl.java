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
import ec.com.avila.hiperion.dao.MenuDao;
import ec.com.avila.hiperion.emision.entities.Menu;
import ec.com.avila.hiperion.emision.entities.Rol;
import ec.com.avila.hiperion.emision.entities.RolMenu;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 10, 2014
 * @since JDK1.6
 */
@Stateless
public class MenuDaoImpl extends GenericDAOImpl<Menu, Long> implements MenuDao {

	Logger log = Logger.getLogger(MenuDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.MenuDao#consultarMenuByRol(ec.com.avila.hiperion.emision.entities.Rol)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RolMenu> consultarMenuByRol(Rol rol) throws HiperionException {
		try {
			Query query = em.createNamedQuery("Menu.findByRol");
			query.setParameter("idRol", rol.getIdRol());
			List<RolMenu> menus = query.getResultList();
			
			return menus;
		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> consultarMenuByRol", ex);
			throw new HiperionException(ex);
		}
	}

}
