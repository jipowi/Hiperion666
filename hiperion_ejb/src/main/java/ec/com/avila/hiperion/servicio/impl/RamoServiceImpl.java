/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoAccidentesPersonalesDao;
import ec.com.avila.hiperion.dao.RamoDao;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;
import ec.com.avila.hiperion.servicio.RamoService;

/**
 * <b> Servicio que implementa las operaciones en la tabla Ramo Buen Uso de Anticipo </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 21, 2013
 * @since JDK1.6
 */
@Stateless
public class RamoServiceImpl implements RamoService {

	@EJB
	private RamoDao ramoDao;
	@EJB
	private RamoAccidentesPersonalesDao ramoAccDao;

	public void guardarRamo(Ramo ramo) throws HiperionException {
		ramoDao.persist(ramo);
	}

	public List<Ramo> consultarRamo() throws HiperionException {
		return ramoDao.findAll();
	}

	public Ramo consultarRamoPorCodigo(String codigoRamo) throws HiperionException {
		return ramoDao.consultarRamoPorCodigo(codigoRamo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoService#consultarRamo(java.lang.Integer)
	 */
	@Override
	public RamoAccidentesPersonale consultarRamo(Integer ipPoliza) throws HiperionException {
		return ramoAccDao.consultarRamo(ipPoliza);
	}

}
