/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.CatalogoDao;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.servicio.CatalogoService;

@Stateless
public class CatalogoServiceImpl implements CatalogoService {

	// @EJB(lookup =
	// "java:global/hiperion_core-1.0/CatalogoDaoImpl!ec.com.avila.hiperion.dao.CatalogoDao")
	@EJB
	private CatalogoDao catalogoDao;

	public CatalogoServiceImpl() {
	}

	public List<Catalogo> consultarCatalogos() throws HiperionException {
		return catalogoDao.findAll();
	}

	public Catalogo consultarCatalogoById(Long idCatalogo) throws HiperionException {
		return catalogoDao.findById(idCatalogo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.CatalogoService#modificarCatalogo(ec.com.avila.hiperion.emision.entities.Catalogo)
	 */
	@Override
	public void modificarCatalogo(Catalogo catalogo) throws HiperionException {
		catalogoDao.update(catalogo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.CatalogoService#guardarCatalogo(ec.com.avila.hiperion.emision.entities.Catalogo)
	 */
	public void guardarCatalogo(Catalogo catalogo) throws HiperionException {
		catalogoDao.persist(catalogo);
	}

}
