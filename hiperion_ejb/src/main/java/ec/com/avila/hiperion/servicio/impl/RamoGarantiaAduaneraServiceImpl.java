/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.CoberturaAduaneraDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoGarantiaAduaneraDao;
import ec.com.avila.hiperion.emision.entities.CobertAduanera;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoGarantiaAduanera;
import ec.com.avila.hiperion.servicio.RamoGarantiaAduaneraService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoGarantiaAduaneraServiceImpl implements RamoGarantiaAduaneraService {

	@EJB
	private RamoGarantiaAduaneraDao ramoGarantiaAduaneraDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private CoberturaAduaneraDao coberturaAduaneraDao;

	public void guardarRamoGarantiaAduanera(RamoGarantiaAduanera ramoGarantiaAduanera, Poliza poliza) throws HiperionException {
		
		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoGarantiaAduanera.setPoliza(poliza);
		
		ramoGarantiaAduaneraDao.persist(ramoGarantiaAduanera);

	
		for (CobertAduanera cobertura : ramoGarantiaAduanera.getCobertAduaneras()) {
			cobertura.setRamoGarantiaAduanera(ramoGarantiaAduanera);
			coberturaAduaneraDao.persist(cobertura);
		}

	}

	public List<RamoGarantiaAduanera> consultarRamoGarantiaAduanera() throws HiperionException {
		return ramoGarantiaAduaneraDao.findAll();
	}
}
