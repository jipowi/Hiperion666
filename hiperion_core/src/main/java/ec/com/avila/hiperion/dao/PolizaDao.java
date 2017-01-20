/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.Poliza;

/**
 * <b>Interface local de la tabla Poliza para realizar las operaciones necesarias </b>
 * 
 * @author Paul Jimenez
 * @version 1.0, 20/10/2013
 * @since JDK1.6
 */
@Local
public interface PolizaDao extends GenericDAO<Poliza, Long> {

	/**
	 * 
	 * <b> Permite consultar las polizas que tiene un cliente. </b>
	 * <p>
	 * [Author: HIPERION, Date: 18/02/2016]
	 * </p>
	 * 
	 * @param idcliente
	 * @return lista de polizas
	 */
	public List<Poliza> consultarPolizasByCliente(Integer idcliente);

	/**
	 * 
	 * <b> Permite obtener las polizas que se encuentran entre las fechas ingresadas. </b>
	 * <p>
	 * [Author: HIPERION, Date: 24/02/2016]
	 * </p>
	 * 
	 * @param fechaDesde
	 * @param fechaHasta
	 * @return
	 */
	public List<Poliza> obtenerReporteFechas(Date fechaDesde, Date fechaHasta);

}
