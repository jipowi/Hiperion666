/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddCascoMaritimoDao;
import ec.com.avila.hiperion.dao.CoberturaAddCascoMaritimoDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoCascoMaritimoDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddCasco;
import ec.com.avila.hiperion.emision.entities.CobertAddCasco;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoCascoMaritimo;
import ec.com.avila.hiperion.servicio.RamoCascoMaritimoService;

/**
 * <b>Permite implementar los operaciones que se realizan sobre la tabla RamoCascoMaritimo</b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoCascoMaritimoServiceImpl implements RamoCascoMaritimoService {

	@EJB
	private RamoCascoMaritimoDao ramoCascoMaritimoDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private ClausulaAddCascoMaritimoDao clausulaAddCascoMaritimoDao;
	@EJB
	private CoberturaAddCascoMaritimoDao coberturaAddCascoMaritimoDao;
	@EJB
	private FinanciamientoDao financiamientoDao;


	public void guardarRamoCascoMaritimo(RamoCascoMaritimo ramoCascoMaritimo, Poliza poliza) throws HiperionException {
		
		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoCascoMaritimo.setPoliza(poliza);

		ramoCascoMaritimoDao.persist(ramoCascoMaritimo);

		if (!ramoCascoMaritimo.getClausulasAddCascos().isEmpty()) {
			for (ClausulasAddCasco clausula : ramoCascoMaritimo.getClausulasAddCascos()) {
				clausula.setRamoCascoMaritimo(ramoCascoMaritimo);
				clausulaAddCascoMaritimoDao.persist(clausula);
			}
		}
		if (!ramoCascoMaritimo.getCobertAddCascos().isEmpty()) {

			for (CobertAddCasco cobertura : ramoCascoMaritimo.getCobertAddCascos()) {
				cobertura.setRamoCascoMaritimo(ramoCascoMaritimo);
				coberturaAddCascoMaritimoDao.persist(cobertura);
			}
		}

	}

	public List<RamoCascoMaritimo> consultarRamoCascoMaritimo() throws HiperionException {
		return ramoCascoMaritimoDao.findAll();
	}

}
