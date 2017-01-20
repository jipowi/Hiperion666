/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoVidaDao;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoVida;
import ec.com.avila.hiperion.servicio.RamoVidaService;

/**
 * <b> Servicio que implementa las operaciones de la tabla RamoVida </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,30/12/2013
 * @since JDK1.6
 */
@Stateless
public class RamoVidaServiceImpl implements RamoVidaService {

	@EJB
	private RamoVidaDao ramoVidaDao;

	public List<RamoVida> consultarRamoVida() throws HiperionException {
		return ramoVidaDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoVidaService#guardarRamoVida(ec.com.avila.hiperion.emision.entities.RamoVida, ec.com.avila.hiperion.emision.entities.Poliza)
	 */
	@Override
	public void guardarRamoVida(RamoVida ramoVida, Poliza poliza) throws HiperionException {
		ramoVidaDao.persist(ramoVida);

	}

}
