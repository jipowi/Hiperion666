/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddIncendioDao;
import ec.com.avila.hiperion.dao.CoberturaAddIncendioDao;
import ec.com.avila.hiperion.dao.CoberturaIncendioDao;
import ec.com.avila.hiperion.dao.CondicionEspIncendioDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.ObjAsegIncendioLineasAliadasDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoIncendioLineasAliadaDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddIncendio;
import ec.com.avila.hiperion.emision.entities.CobertAddIncendio;
import ec.com.avila.hiperion.emision.entities.CobertIncendio;
import ec.com.avila.hiperion.emision.entities.CondEspIncendio;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.ObjAsegIncendio;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada;
import ec.com.avila.hiperion.servicio.RamoIncendioLineasAliadaService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,10/08/2014
 * @since JDK1.6
 */
@Stateless
public class RamoIncendioLineasAliadaServiceImpl implements RamoIncendioLineasAliadaService {

	@EJB
	private RamoIncendioLineasAliadaDao ramoIncendioLineasAliadaDao;
	@EJB
	private ObjAsegIncendioLineasAliadasDao incendioLineasAliadasDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private CoberturaIncendioDao coberturaIncendioDao;
	@EJB
	private CoberturaAddIncendioDao coberturaAddIncendioDao;
	@EJB
	private CondicionEspIncendioDao condicionEspIncendioDao;
	@EJB
	private ClausulaAddIncendioDao clausulaAddIncendioDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoIncendioLineasAliadaServiceRemote#guardarRamoIncendioLineasAliada(ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada)
	 */
	@Override
	public void guardarRamoIncendioLineasAliada(RamoIncendioLineasAliada ramoIncendioLineasAliada, Poliza poliza) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoIncendioLineasAliada.setPoliza(poliza);

		ramoIncendioLineasAliadaDao.persist(ramoIncendioLineasAliada);

		for (ObjAsegIncendio objeto : ramoIncendioLineasAliada.getObjAsegIncendios()) {
			incendioLineasAliadasDao.persist(objeto);
		}

		for (CobertIncendio cobertura : ramoIncendioLineasAliada.getCobertIncendios()) {
			cobertura.setRamoIncendioLineasAliada(ramoIncendioLineasAliada);
			coberturaIncendioDao.persist(cobertura);
		}

		for (CobertAddIncendio coberturaAdd : ramoIncendioLineasAliada.getCobertAddIncendios()) {
			coberturaAdd.setRamoIncendioLineasAliada(ramoIncendioLineasAliada);
			coberturaAddIncendioDao.persist(coberturaAdd);
		}

		for (ClausulasAddIncendio clausula : ramoIncendioLineasAliada.getClausulasAddIncendios()) {
			clausula.setRamoIncendioLineasAliada(ramoIncendioLineasAliada);
			clausulaAddIncendioDao.persist(clausula);
		}

		for (CondEspIncendio condicion : ramoIncendioLineasAliada.getCondEspIncendios()) {
			condicion.setRamoIncendioLineasAliada(ramoIncendioLineasAliada);
			condicionEspIncendioDao.persist(condicion);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoIncendioLineasAliadaService#consultarRamoIncendioLineasAliada()
	 */
	@Override
	public List<RamoIncendioLineasAliada> consultarRamoIncendioLineasAliada() throws HiperionException {
		return ramoIncendioLineasAliadaDao.findAll();
	}

}
