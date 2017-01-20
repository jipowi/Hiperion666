/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.CoberturaAddEquipoElectronicoDao;
import ec.com.avila.hiperion.dao.CoberturaEquipoElectronicoDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.ObjAsegEquipoElectronicoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoEquipoElectronicoDao;
import ec.com.avila.hiperion.emision.entities.CobertAddEquipo;
import ec.com.avila.hiperion.emision.entities.CobertEquipo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.ObjAsegEquipo;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoEquipoElectronico;
import ec.com.avila.hiperion.servicio.RamoEquipoElectronicoService;

/**
 * <b>Permite implementar las operaciones necesarias de la tabla RamoEquipoElectronico </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoEquipoElectronicoServiceImpl implements RamoEquipoElectronicoService {

	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private RamoEquipoElectronicoDao ramoEquipoElectronicoDao;
	@EJB
	private CoberturaEquipoElectronicoDao coberturaEquipoElectronicoDao;
	@EJB
	private CoberturaAddEquipoElectronicoDao coberturaAddEquipoElectronicoDao;

	@EJB
	private ObjAsegEquipoElectronicoDao objAsegEquipoElectronicoDao;

	public void guardarRamoEquipoElectronico(RamoEquipoElectronico ramoEquipoElectronico, Poliza poliza) throws HiperionException {
		
		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoEquipoElectronico.setPoliza(poliza);
		
		ramoEquipoElectronicoDao.persist(ramoEquipoElectronico);
		
		for (CobertEquipo cobertura : ramoEquipoElectronico.getCobertEquipos()) {
			cobertura.setRamoEquipoElectronico(ramoEquipoElectronico);
			coberturaEquipoElectronicoDao.persist(cobertura);
		}
		
		for (CobertAddEquipo cobertura : ramoEquipoElectronico.getCobertAddEquipos()) {
			cobertura.setRamoEquipoElectronico(ramoEquipoElectronico);
			coberturaAddEquipoElectronicoDao.persist(cobertura);
		}
		
		for (ObjAsegEquipo objeto : ramoEquipoElectronico.getObjAsegEquipos()) {
			objAsegEquipoElectronicoDao.persist(objeto);
		}
	}

	public List<RamoEquipoElectronico> consultarRamoEquipoElectronico() throws HiperionException {
		return ramoEquipoElectronicoDao.findAll();
	}

}
