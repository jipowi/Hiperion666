/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ObjAsegTransporteDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.RamoTransporteDao;
import ec.com.avila.hiperion.emision.entities.ObjAsegTransporte;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoTransporte;
import ec.com.avila.hiperion.servicio.RamoTransporteService;

/**
 * <b> Servicio que implementa las operaciones en la tabla RamoTransporte </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,30/12/2013
 * @since JDK1.6
 */
@Stateless
public class RamoTransporteServiceImpl implements RamoTransporteService {

	@EJB
	private RamoTransporteDao ramoTranspoteDao;
	@EJB
	private ObjAsegTransporteDao objAsegTransporteDao;
	
	@EJB
	private PagoPolizaDao pagoPolizaDao;

	public void guardarRamoTransporte(RamoTransporte transporte, Poliza poliza) throws HiperionException {
		
		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);
		ramoTranspoteDao.persist(transporte);
		for (ObjAsegTransporte objeto : transporte.getObjAsegTransportes()) {
			objAsegTransporteDao.persist(objeto);
		}

	}

	public List<RamoTransporte> consultarRamoTransporte() throws HiperionException {
		return ramoTranspoteDao.findAll();
	}

}
