/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddAccPerDao;
import ec.com.avila.hiperion.dao.CoberturaAccPerDao;
import ec.com.avila.hiperion.dao.CondicionEspAccPerDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoAccidentesPersonalesDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddAccPer;
import ec.com.avila.hiperion.emision.entities.CobertAccPer;
import ec.com.avila.hiperion.emision.entities.CondEspAccPer;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;
import ec.com.avila.hiperion.servicio.RamoAccidentesPersonalesService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,31/12/2013
 * @since JDK1.6
 */
@Stateless
public class RamoAccidentesPersonalesServiceImpl implements RamoAccidentesPersonalesService {

	@EJB
	private RamoAccidentesPersonalesDao ramoAccidentesPersonalesDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private ClausulaAddAccPerDao clausulaAddAccPerDao;
	@EJB
	private CoberturaAccPerDao coberturaAccPerDao;
	@EJB
	private CondicionEspAccPerDao conAccPerDao;

	public List<RamoAccidentesPersonale> consultarRamoAccidentesPersonales() throws HiperionException {
		return ramoAccidentesPersonalesDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoAccidentesPersonalesService#guardarRamoAccidentesPersonales(ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale,
	 * ec.com.avila.hiperion.emision.entities.Poliza)
	 */
	@Override
	public void guardarRamoAccidentesPersonales(RamoAccidentesPersonale ramoAccidentesPersonales, Poliza poliza) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();

		if (pagoPoliza != null) {
			pagoPolizaDao.persist(pagoPoliza);

			for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
				financiamiento.setPagoPoliza(pagoPoliza);
				financiamientoDao.persist(financiamiento);
			}
		}

		polizaDao.persist(poliza);

		ramoAccidentesPersonales.setPoliza(poliza);

		ramoAccidentesPersonalesDao.persist(ramoAccidentesPersonales);

		if (ramoAccidentesPersonales.getClausulasAddAccPers() != null) {
			for (ClausulasAddAccPer clausula : ramoAccidentesPersonales.getClausulasAddAccPers()) {
				clausula.setRamoAccidentesPersonale(ramoAccidentesPersonales);
				clausulaAddAccPerDao.persist(clausula);
			}
		}
		if (ramoAccidentesPersonales.getCoberturasAcc() != null) {
			for (CobertAccPer cobertura : ramoAccidentesPersonales.getCoberturasAcc()) {
				cobertura.setRamoAccidentesPersonale(ramoAccidentesPersonales);
				coberturaAccPerDao.persist(cobertura);
			}
		}
		if (ramoAccidentesPersonales.getCondicionesEspAcc() != null) {
			for (CondEspAccPer condicion : ramoAccidentesPersonales.getCondicionesEspAcc()) {
				condicion.setRamoAccidentesPersonale(ramoAccidentesPersonales);
				conAccPerDao.persist(condicion);
			}
		}

	}
}
