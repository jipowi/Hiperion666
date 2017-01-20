/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoAsistenciaMedica;

/**
 * <b> Servicio de Interfaz local para realizar las operaciones sobre la tabla RamoAstMedica </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,31/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoAstMedicaService {

	/**
	 * 
	 * <b> permite guardar registros en la tabla RamoAstMedica </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 31/12/2013]
	 * </p>
	 * 
	 * @param ramoAsistenciaMedica
	 * @throws HiperionException
	 */
	public void guardarRamoAsistenciaMedica(RamoAsistenciaMedica ramoAsistenciaMedica, Poliza poliza) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de RamoAstMedica que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 31/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoAsistenciaMedica> consultarRamoAsistenciaMedica() throws HiperionException;
	
	/**
	 * 
	 * <b> Permite consultar el id del Titulo por medio del idDetalleAnexo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 16/06/2015]
	 * </p>
	 * 
	 * @param idDetalleAnexo
	 * @return
	 * @throws HiperionException
	 */
	public Long consultarIdTitulo(Long idDetalleAnexo) throws HiperionException;

}
