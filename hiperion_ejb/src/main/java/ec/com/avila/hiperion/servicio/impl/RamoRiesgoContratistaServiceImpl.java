/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddRiesgoContratistaDao;
import ec.com.avila.hiperion.dao.CoberturaRiesgoContratistaDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoRiesgoContratistaDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddContratista;
import ec.com.avila.hiperion.emision.entities.CobertContratista;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoContratista;
import ec.com.avila.hiperion.servicio.RamoRiesgoContratistaService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoRiesgoContratistaServiceImpl implements RamoRiesgoContratistaService {

	@EJB
	private RamoRiesgoContratistaDao ramoRiesgoContratistaDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private ClausulaAddRiesgoContratistaDao clausulaAddDao;
	@EJB
	private CoberturaRiesgoContratistaDao coberturaDao;

	public void guardarRamoRiesgoContratista(RamoRiesgoContratista ramoRiesgoContratista, Poliza poliza) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoRiesgoContratista.setPoliza(poliza);

		ramoRiesgoContratistaDao.persist(ramoRiesgoContratista);

		for (ClausulasAddContratista clausula : ramoRiesgoContratista.getClausulasAddContratistas()) {
			clausula.setRamoRiesgoContratista(ramoRiesgoContratista);
			clausulaAddDao.persist(clausula);
		}

		for (CobertContratista cobertura : ramoRiesgoContratista.getCobertContratistas()) {
			cobertura.setRamoRiesgoContratista(ramoRiesgoContratista);
			coberturaDao.persist(cobertura);
		}

	}

	public List<RamoRiesgoContratista> consultarRamoRiesgoContratista() throws HiperionException {
		return ramoRiesgoContratistaDao.findAll();
	}

}
