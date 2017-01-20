/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddCascoAereoDao;
import ec.com.avila.hiperion.dao.CoberturaAddCascoAereoDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoCascoAereoDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddCascoAereo;
import ec.com.avila.hiperion.emision.entities.CobertAddCascoAereo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoCascoAereo;
import ec.com.avila.hiperion.servicio.RamoCascoAereoService;

/**
 * <b> Permite implentar las interfaces para las operaciones en casco aereo. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoCascoAereoServiceImpl implements RamoCascoAereoService {

	@EJB
	private RamoCascoAereoDao ramoCascoAereoDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private ClausulaAddCascoAereoDao clausulaAddCascoAereoDao;
	@EJB
	private CoberturaAddCascoAereoDao coberturaAddCascoAereoDao;
	@EJB
	private FinanciamientoDao financiamientoDao;

	public void guardarRamoCascoAereo(RamoCascoAereo ramoCascoAereo, Poliza poliza) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoCascoAereo.setPoliza(poliza);

		ramoCascoAereoDao.persist(ramoCascoAereo);

		if (!ramoCascoAereo.getClausulasAddCascoAereos().isEmpty()) {
			for (ClausulasAddCascoAereo clausula : ramoCascoAereo.getClausulasAddCascoAereos()) {
				clausula.setRamoCascoAereo(ramoCascoAereo);
				clausulaAddCascoAereoDao.persist(clausula);
			}
		}
		if (!ramoCascoAereo.getCobertAddCascoAereos().isEmpty()) {

			for (CobertAddCascoAereo cobertura : ramoCascoAereo.getCobertAddCascoAereos()) {
				cobertura.setRamoCascoAereo(ramoCascoAereo);
				coberturaAddCascoAereoDao.persist(cobertura);
			}
		}

	}

	public List<RamoCascoAereo> consultarRamoCascoAereo() throws HiperionException {
		return ramoCascoAereoDao.findAll();
	}

}
