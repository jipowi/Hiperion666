/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.DetalleCatalogoDao;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;

/**
 * 
 * <b> Implemtacion del servicio de Detalle de catalogo </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 1, 2014
 * @since JDK1.6
 */
@Stateless
public class DetalleCatalogoServiceImpl implements DetalleCatalogoService {

	@EJB
	private DetalleCatalogoDao detalleCatalgoDao;

	public DetalleCatalogoServiceImpl() {
	}

	public List<DetalleCatalogo> consultarDetalleCatalogoByCodCatalogo(Long idCatalogo) throws HiperionException {
		return detalleCatalgoDao.consultarDetalleCatalogoByCodCatalogo(idCatalogo);
	}

	public List<DetalleCatalogo> consultarDetalleCatalogoByDepCatalogo(String codDepCatalogo, String codDepDetCatalogo) throws HiperionException {
		return detalleCatalgoDao.consultarDetalleCatalogoByDepCatalogo(codDepCatalogo, codDepDetCatalogo);
	}

	public List<DetalleCatalogo> consultarDetalleCatalogo() throws HiperionException {
		return detalleCatalgoDao.consultarDetalleCatalogo();
	}

	public void guardarDetalleCatalogo(DetalleCatalogo detalle) throws HiperionException {
		detalleCatalgoDao.guardarDetalleCatalogo(detalle);
	}

	public void modificarDetalleCatalogo(DetalleCatalogo detalle) throws HiperionException {
		detalleCatalgoDao.modificarDetalleCatalogo(detalle);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.DetalleCatalogoServiceRemote#consultarDetalleCatalogoByCodDetalle(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<DetalleCatalogo> consultarDetalleCatalogoByCodDetalle(String codDepCatalogo, Long idCatalogo) throws HiperionException {
		return detalleCatalgoDao.consultarDetalleCatalogoByCodDetalle(codDepCatalogo, idCatalogo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.DetalleCatalogoService#consultarDetalleByCatalogoAndDetalle(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public DetalleCatalogo consultarDetalleByCatalogoAndDetalle(Integer codCatalogo, Integer codDetCalogo) throws HiperionException {
		return detalleCatalgoDao.consultarDetalleByCatalogoAndDetalle(codCatalogo, codDetCalogo);
	}

}
