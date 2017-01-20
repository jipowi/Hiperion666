/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddRoboAsaltoDao;
import ec.com.avila.hiperion.dao.CoberturaAddRoboAsaltoDao;
import ec.com.avila.hiperion.dao.CoberturaRoboAsaltoDao;
import ec.com.avila.hiperion.dao.CondicionEspRoboAsaltoDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoRoboAsaltoDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddRobo;
import ec.com.avila.hiperion.emision.entities.CobertAddRobo;
import ec.com.avila.hiperion.emision.entities.CoberturaRobo;
import ec.com.avila.hiperion.emision.entities.CondEspRobo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoRoboAsalto;
import ec.com.avila.hiperion.servicio.RamoRoboAsaltoService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoRoboAsaltoServiceImpl implements RamoRoboAsaltoService {

	@EJB
	private RamoRoboAsaltoDao ramoRoboAsaltoDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private ClausulaAddRoboAsaltoDao clausulaAddDao;
	@EJB
	private CoberturaRoboAsaltoDao coberturaDao;
	@EJB
	private CoberturaAddRoboAsaltoDao coberturaAddDao;
	@EJB
	private CondicionEspRoboAsaltoDao condicionDao;

	public void guardarRamoRoboAsalto(RamoRoboAsalto ramoRoboAsalto, Poliza poliza) throws HiperionException {
		
		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoRoboAsalto.setPoliza(poliza);
		
		ramoRoboAsaltoDao.persist(ramoRoboAsalto);

		for (ClausulasAddRobo clausula : ramoRoboAsalto.getClausulasAddRobos()) {
			clausula.setRamoRoboAsalto(ramoRoboAsalto);
			clausulaAddDao.persist(clausula);
		}

		for (CoberturaRobo cobertura : ramoRoboAsalto.getCoberturaRobos()) {
			cobertura.setRamoRoboAsalto(ramoRoboAsalto);
			coberturaDao.persist(cobertura);
		}
		
		for (CobertAddRobo cobertura : ramoRoboAsalto.getCobertAddRobos()) {
			cobertura.setRamoRoboAsalto(ramoRoboAsalto);
			coberturaAddDao.persist(cobertura);
		}

		for (CondEspRobo condicion : ramoRoboAsalto.getCondEspRobos()) {
			condicion.setRamoRoboAsalto(ramoRoboAsalto);
			condicionDao.persist(condicion);
		}

	}

	public List<RamoRoboAsalto> consultarRamoRoboAsalto() throws HiperionException {
		return ramoRoboAsaltoDao.findAll();
	}

}
