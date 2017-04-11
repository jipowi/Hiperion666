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
import ec.com.avila.hiperion.dao.GrupoAPDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoAccidentesPersonalesDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddAccPer;
import ec.com.avila.hiperion.emision.entities.CobertAccPer;
import ec.com.avila.hiperion.emision.entities.CondEspAccPer;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.GrupoAccPersonale;
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
	@EJB
	private GrupoAPDao grupoAPDao;

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
	public void guardarRamoAccidentesPersonales(RamoAccidentesPersonale ramoAccidentesPersonales, Poliza poliza, List<GrupoAccPersonale> grupos, List<CobertAccPer> coberturas,
			List<CondEspAccPer> condiciones, List<ClausulasAddAccPer> clausulas) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		Boolean guardar = false;

		if (pagoPoliza != null) {
			pagoPolizaDao.persist(pagoPoliza);

			for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
				financiamiento.setPagoPoliza(pagoPoliza);
				financiamientoDao.persist(financiamiento);
			}
		}

		polizaDao.persist(poliza);

		if (ramoAccidentesPersonales.getIdAccidentes() != null) {
			ramoAccidentesPersonalesDao.update(ramoAccidentesPersonales);
		} else {
			ramoAccidentesPersonalesDao.persist(ramoAccidentesPersonales);
			guardar = true;
		}

		if (guardar) {
			// GRUPOS
			for (GrupoAccPersonale grupo : grupos) {
				grupo.setRamoAccidentesPersonale(ramoAccidentesPersonales);
				grupoAPDao.persist(grupo);
			}
			// CLAUSULAS ADICIONALES
			if (clausulas != null) {
				for (ClausulasAddAccPer clausula : clausulas) {
					clausula.setRamoAccidentesPersonale(ramoAccidentesPersonales);
					clausulaAddAccPerDao.persist(clausula);
				}
			}

			// CONDICIONES ESPECIALES
			if (condiciones != null) {
				for (CondEspAccPer condicion : condiciones) {
					condicion.setRamoAccidentesPersonale(ramoAccidentesPersonales);
					conAccPerDao.persist(condicion);
				}
			}
		} else {
			List<GrupoAccPersonale> gruposDB = ramoAccidentesPersonalesDao.cosultarGruposByRamo(ramoAccidentesPersonales.getIdAccidentes());
			// Eliminar Grupos
			for (GrupoAccPersonale grupo : gruposDB) {
				grupo.setRamoAccidentesPersonale(ramoAccidentesPersonales);
				grupoAPDao.delete(grupo);
			}
			// Insertar Grupos
			for (GrupoAccPersonale grupo : grupos) {
				grupo.setRamoAccidentesPersonale(ramoAccidentesPersonales);
				grupoAPDao.persist(grupo);
			}

			List<CobertAccPer> coberturasBD = ramoAccidentesPersonalesDao.consultarCoberturasByRamo(ramoAccidentesPersonales.getIdAccidentes());
			// Eliminar Coberturas
			for (CobertAccPer cobertura : coberturasBD) {
				cobertura.setRamoAccidentesPersonale(ramoAccidentesPersonales);
				coberturaAccPerDao.delete(cobertura);
			}
			// Insertar Coberturas
			for (CobertAccPer cobertura : coberturas) {
				cobertura.setRamoAccidentesPersonale(ramoAccidentesPersonales);
				coberturaAccPerDao.persist(cobertura);
			}
		}

	}
}
