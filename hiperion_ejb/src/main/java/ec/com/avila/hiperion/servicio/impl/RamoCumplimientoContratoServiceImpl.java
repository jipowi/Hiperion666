/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.CoberturaCumpContratoDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoCumplimientoContratoDao;
import ec.com.avila.hiperion.emision.entities.CobertContrato;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoCumplimientoContrato;
import ec.com.avila.hiperion.servicio.RamoCumplimientoContratoService;

/**
 * 
 * <b> Permite implementar las interfaces del servicio de cumplimiento de contrato. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,24/08/2015
 * @since JDK1.6
 */
@Stateless
public class RamoCumplimientoContratoServiceImpl implements RamoCumplimientoContratoService {

	@EJB
	private RamoCumplimientoContratoDao ramoCumplimientoContratoDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private CoberturaCumpContratoDao coberturaCumpContratoDao;

	public void guardarRamoCumplimientoContrato(RamoCumplimientoContrato ramoCumplimientoContrato, Poliza poliza) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);
		ramoCumplimientoContrato.setPoliza(poliza);

		ramoCumplimientoContratoDao.persist(ramoCumplimientoContrato);

		for (CobertContrato cobertura : ramoCumplimientoContrato.getCobertContratos()) {
			cobertura.setRamoCumplimientoContrato(ramoCumplimientoContrato);
			coberturaCumpContratoDao.persist(cobertura);
		}
	}

	public List<RamoCumplimientoContrato> consultarRamoCumplimientoContrato() throws HiperionException {
		return ramoCumplimientoContratoDao.findAll();
	}

}
