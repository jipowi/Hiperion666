/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.CoberturaSoatDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoSoatDao;
import ec.com.avila.hiperion.emision.entities.CobertSoat;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoSoat;
import ec.com.avila.hiperion.servicio.RamoSoatService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoSoatServiceImpl implements RamoSoatService {

	@EJB
	private RamoSoatDao ramoSoatDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private CoberturaSoatDao coberturaDao;

	public void guardarRamoSoat(RamoSoat ramoSoat, Poliza poliza) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoSoat.setPoliza(poliza);

		ramoSoatDao.persist(ramoSoat);

		for (CobertSoat cobertura : ramoSoat.getCobertSoats()) {
			cobertura.setRamoSoat(ramoSoat);
			coberturaDao.persist(cobertura);
		}

	}

	public List<RamoSoat> consultarRamoSoat() throws HiperionException {
		return ramoSoatDao.findAll();
	}

}
