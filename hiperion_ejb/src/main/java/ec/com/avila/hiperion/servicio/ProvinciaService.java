/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Provincia;

/**
 * 
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla Provincia</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Local
public interface ProvinciaService {

	/**
	 * 
	 * <b> Permite obtener la lista de Provincias que se encuentran en la base de Datos. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 15/06/2014]
	 * </p>
	 * 
	 * @return lista de provincias
	 * @throws HiperionException
	 */
	public List<Provincia> consultarProvincias() throws HiperionException;

	public Provincia consultarProvinciaPorCodigo(String codProvicia) throws HiperionException;
}
