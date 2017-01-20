/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddRoturaMaquinariaDao;
import ec.com.avila.hiperion.dao.CoberturaAddRoturaMaquinariaDao;
import ec.com.avila.hiperion.dao.CoberturaRoturaMaquinariaDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.ObjAsegRoturaMaquinariaDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoRoturaMaquinariaDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddRotura;
import ec.com.avila.hiperion.emision.entities.CobertAddRotura;
import ec.com.avila.hiperion.emision.entities.CobertRotura;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.ObjAsegRotura;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoRoturaMaquinaria;
import ec.com.avila.hiperion.servicio.RamoRoturaMaquinariaService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoRoturaMaquinariaServiceImpl implements RamoRoturaMaquinariaService {

	@EJB
	private RamoRoturaMaquinariaDao ramoRoturaMaquinariaDao;
	@EJB
	private ObjAsegRoturaMaquinariaDao objAsegRoturaMaquinariaDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private ClausulaAddRoturaMaquinariaDao clausulaAddDao;
	@EJB
	private CoberturaRoturaMaquinariaDao coberturaDao;
	@EJB
	private CoberturaAddRoturaMaquinariaDao coberturaAddDao;

	public void guardarRamoRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria, Poliza poliza) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoRoturaMaquinaria.setPoliza(poliza);

		ramoRoturaMaquinariaDao.persist(ramoRoturaMaquinaria);

		for (ClausulasAddRotura clausula : ramoRoturaMaquinaria.getClausulasAddRoturas()) {
			clausula.setRamoRoturaMaquinaria(ramoRoturaMaquinaria);
			clausulaAddDao.persist(clausula);
		}

		for (CobertRotura cobertura : ramoRoturaMaquinaria.getCobertRoturas()) {
			cobertura.setRamoRoturaMaquinaria(ramoRoturaMaquinaria);
			coberturaDao.persist(cobertura);
		}

		for (CobertAddRotura cobertura : ramoRoturaMaquinaria.getCobertAddRoturas()) {
			cobertura.setRamoRoturaMaquinaria(ramoRoturaMaquinaria);
			coberturaAddDao.persist(cobertura);
		}

		for (ObjAsegRotura objeto : ramoRoturaMaquinaria.getObjAsegRoturas()) {
			objAsegRoturaMaquinariaDao.persist(objeto);
		}
	}

	public List<RamoRoturaMaquinaria> consultarRamoRoturaMaquinaria() throws HiperionException {
		return ramoRoturaMaquinariaDao.findAll();
	}

}
