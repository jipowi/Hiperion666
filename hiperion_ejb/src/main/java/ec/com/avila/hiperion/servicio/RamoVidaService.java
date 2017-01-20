/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoVida;

/**
 * <b> Servicio de Interfaz local para ralizar las operaciones sobre la tabla RamoVida </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,30/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoVidaService {

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla RamoVida </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 30/12/2013]
	 * </p>
	 * 
	 * @param vida
	 * @throws HiperionException
	 */
	public void guardarRamoVida(RamoVida ramoVida, Poliza poliza) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de RamoVida que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 30/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoVida> consultarRamoVida() throws HiperionException;

}
