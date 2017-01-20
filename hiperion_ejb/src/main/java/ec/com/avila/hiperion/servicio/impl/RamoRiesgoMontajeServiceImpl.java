/**
 * 
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddRiesgoMontajeDao;
import ec.com.avila.hiperion.dao.CoberturaMontajeDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.ObjAsegRiesgoMontajeDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoRiesgoMontajeDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddMontaje;
import ec.com.avila.hiperion.emision.entities.CobertMontaje;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.ObjAsegMontaje;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje;
import ec.com.avila.hiperion.servicio.RamoRiesgoMontajeService;

/**
 * <b> Servicio que implmenta las operaciones sobre la tabla RamoRiesgoMontaje </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,12/10/2014
 * @since JDK1.6
 */
@Stateless
public class RamoRiesgoMontajeServiceImpl implements RamoRiesgoMontajeService {

	@EJB
	private RamoRiesgoMontajeDao ramoRiesgoMontajeDao;
	@EJB
	private ObjAsegRiesgoMontajeDao objAsegRiesgoMontajeDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private ClausulaAddRiesgoMontajeDao clausulaAddDao;
	@EJB
	private CoberturaMontajeDao coberturaDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoRiesgoMontajeService#guardarRamoRiesgoMontaje(ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje)
	 */
	@Override
	public void guardarRamoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje, Poliza poliza) throws HiperionException {
		
		
		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoRiesgoMontaje.setPoliza(poliza);
		
		ramoRiesgoMontajeDao.persist(ramoRiesgoMontaje);
		for (ClausulasAddMontaje clausula : ramoRiesgoMontaje.getClausulasAddMontajes()) {
			clausula.setRamoRiesgoMontaje(ramoRiesgoMontaje);
			clausulaAddDao.persist(clausula);
		}

		for (CobertMontaje cobertura : ramoRiesgoMontaje.getCobertMontajes()) {
			cobertura.setRamoRiesgoMontaje(ramoRiesgoMontaje);
			coberturaDao.persist(cobertura);
		}

		for (ObjAsegMontaje objeto : ramoRiesgoMontaje.getObjAsegMontajes()) {
			objAsegRiesgoMontajeDao.persist(objeto);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoRiesgoMontajeService#consultarRamoRiesgoMontaje()
	 */
	@Override
	public List<RamoRiesgoMontaje> consultarRamoRiesgoMontaje() throws HiperionException {

		return ramoRiesgoMontajeDao.findAll();
	}

}
