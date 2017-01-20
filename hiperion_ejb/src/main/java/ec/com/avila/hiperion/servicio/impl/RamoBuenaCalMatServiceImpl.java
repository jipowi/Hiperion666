/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.CoberturaBuenaCalMatDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoBuenaCalMatDao;
import ec.com.avila.hiperion.emision.entities.CobertMateriale;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoBuenaCalMat;
import ec.com.avila.hiperion.servicio.RamoBuenaCalMatService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoBuenaCalMatServiceImpl implements RamoBuenaCalMatService {

	@EJB
	private RamoBuenaCalMatDao ramoBuenaCalMatDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private CoberturaBuenaCalMatDao coberturaBuenaCalMatDao;

	public void guardarRamoBuenaCalMat(RamoBuenaCalMat ramoBuenaCalMat, Poliza poliza) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);
		ramoBuenaCalMat.setPoliza(poliza);

		ramoBuenaCalMatDao.persist(ramoBuenaCalMat);

		for (CobertMateriale cobertura : ramoBuenaCalMat.getCobertMateriales()) {
			cobertura.setRamoBuenaCalMat(ramoBuenaCalMat);
			coberturaBuenaCalMatDao.persist(cobertura);
		}

	}

	public List<RamoBuenaCalMat> consultarRamoBuenaCalMat() throws HiperionException {
		return ramoBuenaCalMatDao.findAll();
	}

}
