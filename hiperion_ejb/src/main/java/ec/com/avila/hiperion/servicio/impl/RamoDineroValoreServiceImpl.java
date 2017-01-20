/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddDineroDao;
import ec.com.avila.hiperion.dao.CoberturaDineroDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.ObjAsegDineroValoresDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoDineroValoreDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddDinero;
import ec.com.avila.hiperion.emision.entities.CobertDineroVal;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.ObjAsegDineroVal;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoDineroValore;
import ec.com.avila.hiperion.servicio.RamoDineroValoreService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoDineroValoreServiceImpl implements RamoDineroValoreService {

	@EJB
	private RamoDineroValoreDao ramoDineroValoreDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private ObjAsegDineroValoresDao objAsegDineroValoresDao;
	@EJB
	private ClausulaAddDineroDao clausulaAddDineroDao;
	@EJB
	private CoberturaDineroDao coberturaDineroDao;

	public void guardarRamoDineroValore(RamoDineroValore ramoDineroValore, Poliza poliza) throws HiperionException {
		
		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoDineroValore.setPoliza(poliza);
		
		ramoDineroValoreDao.persist(ramoDineroValore);

		for (ClausulasAddDinero clausula : ramoDineroValore.getClausulasAddDineros()) {
			clausula.setRamoDineroValore(ramoDineroValore);
			clausulaAddDineroDao.persist(clausula);
		}

		for (CobertDineroVal cobertura : ramoDineroValore.getCobertDineroVals()) {
			cobertura.setRamoDineroValore(ramoDineroValore);
			coberturaDineroDao.persist(cobertura);
		}
		
				
		for (ObjAsegDineroVal objeto : ramoDineroValore.getObjAsegDineroVals()) {
			objAsegDineroValoresDao.persist(objeto);
		}
	}

	public List<RamoDineroValore> consultarRamoDineroValore() throws HiperionException {
		return ramoDineroValoreDao.findAll();
	}

}
