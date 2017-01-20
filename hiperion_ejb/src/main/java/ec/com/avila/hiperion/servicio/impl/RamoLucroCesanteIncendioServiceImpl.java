/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddLcIncendioDao;
import ec.com.avila.hiperion.dao.CoberturaLcIncendioLineasAliadasDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.ObjAsegLcIncendioDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoLucroCesanteIncendioDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddLcIn;
import ec.com.avila.hiperion.emision.entities.CobertLcIn;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.ObjAsegLcIn;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoLcIncendio;
import ec.com.avila.hiperion.servicio.RamoLucroCesanteIncendioService;

/**
 * <b>Servicio que implementa las operacions del DAO para acceso a la tabla RamoLucroCesanteIncendio</b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoLucroCesanteIncendioServiceImpl implements RamoLucroCesanteIncendioService {

	@EJB
	private RamoLucroCesanteIncendioDao ramoLucroCesanteIncendioDao;
	@EJB
	private ObjAsegLcIncendioDao objAsegLcIncendioDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private ClausulaAddLcIncendioDao clausulaAddLcIncendioDao;
	@EJB
	private CoberturaLcIncendioLineasAliadasDao coberturaDao;

	public void guardarRamoLucroCesanteIncendio(RamoLcIncendio ramoLucroCesanteIncendio, Poliza poliza) throws HiperionException {
		
		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoLucroCesanteIncendio.setPoliza(poliza);
		
		ramoLucroCesanteIncendioDao.persist(ramoLucroCesanteIncendio);

		for (ClausulasAddLcIn clausula : ramoLucroCesanteIncendio.getClausulasAddLcIns()) {
			clausula.setRamoLcIncendio(ramoLucroCesanteIncendio);
			clausulaAddLcIncendioDao.persist(clausula);
		}

		for (CobertLcIn cobertura : ramoLucroCesanteIncendio.getCobertLcIns()) {
			cobertura.setRamoLcIncendio(ramoLucroCesanteIncendio);
			coberturaDao.persist(cobertura);
		}
		
		ramoLucroCesanteIncendioDao.persist(ramoLucroCesanteIncendio);
		for (ObjAsegLcIn objeto : ramoLucroCesanteIncendio.getObjAsegLcIns()) {
			objAsegLcIncendioDao.persist(objeto);
		}
	}

	public List<RamoLcIncendio> consultarRamoLucroCesanteIncendio() throws HiperionException {
		return ramoLucroCesanteIncendioDao.findAll();
	}

}
