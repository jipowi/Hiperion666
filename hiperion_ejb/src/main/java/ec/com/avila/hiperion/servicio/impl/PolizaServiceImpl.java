/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.dao.AseguradoraDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.servicio.PolizaService;

/**
 * <b> Servicio que implementa las operaciones sobre la tabla Poliza </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@Stateless
public class PolizaServiceImpl implements PolizaService {

	@EJB
	private PolizaDao polizaDao;

	@EJB
	private AseguradoraDao aseguradoraDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.PolizaService#consultarPolizasByCliente(java.lang.Integer)
	 */
	@Override
	public List<Poliza> consultarPolizasByCliente(Integer idcliente) {
		return polizaDao.consultarPolizasByCliente(idcliente);
	}

	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.servicio.PolizaService#obtenerReporteFechas(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Poliza> obtenerReporteFechas(Date fechaDesde, Date fechaHasta) {
		return polizaDao.obtenerReporteFechas(fechaDesde, fechaHasta);
	}

}
