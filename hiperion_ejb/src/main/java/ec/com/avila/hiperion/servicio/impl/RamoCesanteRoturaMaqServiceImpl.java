/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddLcRoturaMaquinariaDao;
import ec.com.avila.hiperion.dao.CoberturaAddLcRoturaMaquinariaDao;
import ec.com.avila.hiperion.dao.CoberturaLcRoturaMaquinariaDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.ObjAsegLcRoturaMaquinariaDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoCesanteRoturaMaqDao;
import ec.com.avila.hiperion.emision.entities.ClaAddLcRot;
import ec.com.avila.hiperion.emision.entities.CobertAddLcRot;
import ec.com.avila.hiperion.emision.entities.CobertLcRot;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.ObjAsegLcRotMaq;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoLcRotMaq;
import ec.com.avila.hiperion.servicio.RamoCesanteRoturaMaqService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoCesanteRoturaMaqServiceImpl implements RamoCesanteRoturaMaqService {

	@EJB
	private RamoCesanteRoturaMaqDao ramoCesanteRoturaMaqDao;

	@EJB
	private ObjAsegLcRoturaMaquinariaDao asegLcRoturaMaquinariaDao;
	
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private ClausulaAddLcRoturaMaquinariaDao clausulaAddDao;
	@EJB
	private CoberturaLcRoturaMaquinariaDao coberturaDao;
	@EJB
	private CoberturaAddLcRoturaMaquinariaDao coberturaAddDao;

	public void guardarRamoCesanteRoturaMaq(RamoLcRotMaq ramoCesanteRoturaMaq, Poliza poliza) throws HiperionException {
		
		
		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoCesanteRoturaMaq.setPoliza(poliza);
		
		ramoCesanteRoturaMaqDao.persist(ramoCesanteRoturaMaq);

		for (ClaAddLcRot clausula : ramoCesanteRoturaMaq.getClaAddLcRots()) {
			clausula.setRamoLcRotMaq(ramoCesanteRoturaMaq);
			clausulaAddDao.persist(clausula);
		}

		for (CobertLcRot cobertura : ramoCesanteRoturaMaq.getCobertLcRots()) {
			cobertura.setRamoLcRotMaq(ramoCesanteRoturaMaq);
			coberturaDao.persist(cobertura);
		}
		
		for (CobertAddLcRot cobertura : ramoCesanteRoturaMaq.getCobertAddLcRots()) {
			cobertura.setRamoLcRotMaq(ramoCesanteRoturaMaq);
			coberturaAddDao.persist(cobertura);
		}
		
		for (ObjAsegLcRotMaq objeto : ramoCesanteRoturaMaq.getObjAsegLcRotMaqs()) {
			asegLcRoturaMaquinariaDao.persist(objeto);
		}
	}

	public List<RamoLcRotMaq> consultarRamoCesanteRoturaMaq() throws HiperionException {
		return ramoCesanteRoturaMaqDao.findAll();
	}

}
