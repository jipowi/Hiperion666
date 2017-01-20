/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.CoberturaBuenUsoAntDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoBuenUsoAnticipoDao;
import ec.com.avila.hiperion.emision.entities.CobertBuenUsoAnt;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt;
import ec.com.avila.hiperion.servicio.RamoBuenUsoAnticipoService;

/**
 * <b> Servicio que implementa las operaciones en la tabla Ramo Buen Uso Anticipo. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,13/08/2014
 * @since JDK1.6
 */
@Stateless
public class RamoBuenUsoAnticipoServiceImpl implements RamoBuenUsoAnticipoService {

	@EJB
	private RamoBuenUsoAnticipoDao ramoBuenUsoAnticipoDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private CoberturaBuenUsoAntDao coberturaBuenUsoAntDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoBuenUsoAnticipoService#guardarRamoBuenUsoAnticipo(ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt)
	 */
	@Override
	public void guardarRamoBuenUsoAnticipo(RamoBuenUsoAnt ramoBuenUsoAnt, Poliza poliza) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);
		ramoBuenUsoAnt.setPoliza(poliza);

		ramoBuenUsoAnticipoDao.persist(ramoBuenUsoAnt);

		for (CobertBuenUsoAnt cobertura : ramoBuenUsoAnt.getCobertBuenUsoAnts()) {
			cobertura.setRamoBuenUsoAnt(ramoBuenUsoAnt);
			coberturaBuenUsoAntDao.persist(cobertura);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoBuenUsoAnticipoService#consultarRamoBuenUsoAnticipo()
	 */
	@Override
	public List<RamoBuenUsoAnt> consultarRamoBuenUsoAnticipo() throws HiperionException {
		return ramoBuenUsoAnticipoDao.findAll();
	}

}
