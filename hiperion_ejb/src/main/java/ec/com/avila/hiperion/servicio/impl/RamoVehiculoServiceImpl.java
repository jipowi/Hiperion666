/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddVehiculoDao;
import ec.com.avila.hiperion.dao.CondicionEspVehiculoDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoVehiculoDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddDinero;
import ec.com.avila.hiperion.emision.entities.ClausulasAddVh;
import ec.com.avila.hiperion.emision.entities.CobertDineroVal;
import ec.com.avila.hiperion.emision.entities.CondEspAccPer;
import ec.com.avila.hiperion.emision.entities.CondEspVh;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoVehiculo;
import ec.com.avila.hiperion.servicio.RamoVehiculoService;

/**
 * <b> Servicio que implementa las operaciones de la tabla RamoVehiculo. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,29/12/2013
 * @since JDK1.6
 */
@Stateless
public class RamoVehiculoServiceImpl implements RamoVehiculoService {

	@EJB
	private RamoVehiculoDao ramoVehiculoDao;

	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;

	@EJB
	private ClausulaAddVehiculoDao clausulaAddVehiculoDao;

	@EJB
	private CondicionEspVehiculoDao condicionEspVehiculoDao;

	public void guardarRamoVehiculo(RamoVehiculo vehiculo, Poliza poliza) throws HiperionException {
		ramoVehiculoDao.persist(vehiculo);
		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		vehiculo.setPoliza(poliza);

		ramoVehiculoDao.persist(vehiculo);

		for (ClausulasAddVh clausula : vehiculo.getClausulasAddVhs()) {
			clausula.setRamoVehiculo(vehiculo);
			clausulaAddVehiculoDao.persist(clausula);
		}

		for (CondEspVh condicion : vehiculo.getCondEspVhs()) {
			condicion.setRamoVehiculo(vehiculo);
			condicionEspVehiculoDao.persist(condicion);
		}

	}

	public List<RamoVehiculo> consultarRamoVehiculo() throws HiperionException {
		return ramoVehiculoDao.findAll();
	}

}
