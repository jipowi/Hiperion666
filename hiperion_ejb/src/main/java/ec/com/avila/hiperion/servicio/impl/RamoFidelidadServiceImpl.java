/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddFidelidadDao;
import ec.com.avila.hiperion.dao.CoberturaFidelidadDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoFidelidadDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddFidelidad;
import ec.com.avila.hiperion.emision.entities.CobertFidelidad;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoFidelidad;
import ec.com.avila.hiperion.servicio.RamoFidelidadService;

/**
 * <b> Permite implementar las operaciones del servicio de fidelidad. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoFidelidadServiceImpl implements RamoFidelidadService {

	@EJB
	private RamoFidelidadDao ramoFidelidadDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private CoberturaFidelidadDao coberturaFidelidadDao;
	@EJB
	private ClausulaAddFidelidadDao clausulaAddFidelidadDao;

	public void guardarRamoFidelidad(RamoFidelidad ramoFidelidad, Poliza poliza) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoFidelidad.setPoliza(poliza);

		ramoFidelidadDao.persist(ramoFidelidad);

		for (ClausulasAddFidelidad clausula : ramoFidelidad.getClausulasAddFidelidads()) {
			clausula.setRamoFidelidad(ramoFidelidad);
			clausulaAddFidelidadDao.persist(clausula);
		}

		for (CobertFidelidad cobertura : ramoFidelidad.getCobertFidelidads()) {
			cobertura.setRamoFidelidad(ramoFidelidad);
			coberturaFidelidadDao.persist(cobertura);
		}

	}

	public List<RamoFidelidad> consultarRamoFidelidad() throws HiperionException {
		return ramoFidelidadDao.findAll();
	}

	public void modificarRamoFidelidad(RamoFidelidad ramoFidelidad) throws HiperionException {

		ramoFidelidadDao.update(ramoFidelidad);

	}

}
