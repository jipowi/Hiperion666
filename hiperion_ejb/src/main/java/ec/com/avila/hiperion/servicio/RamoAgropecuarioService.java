/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.ArchivoBase;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;

/**
 * <b> Servicio de Interfaz local que realiza las operaciones sobre la tabla RamoAccidentesPersonales </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,31/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoAgropecuarioService {

	/**
	 * 
	 * <b> Permite consultar el detalle de anexo por id. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 15/01/2015]
	 * </p>
	 * 
	 * @param idDetalle
	 * @throws HiperionException
	 */
	public DetalleAnexo consultarDetalleAnexoById(Long idDetalle) throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar informacion en la tabla RamoAgropecuario </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 15, 2014]
	 * </p>
	 * 
	 * @param ramoAgropecuario
	 * @throws HiperionException
	 */
	public void guardarAgropecuario(RamoAgropecuario ramoAgropecuario, Poliza poliza) throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar un archivo en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 19, 2014]
	 * </p>
	 * 
	 * @param file
	 * @throws HiperionException
	 */
	public void guardarArchivoPoliza(ArchivoBase file) throws HiperionException;
	
	/**
	 * 
	 * <b> Permite consultar los detalles de anexos con un titulo determinado. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 15/01/2015]
	 * </p>
	 * 
	 * @param idRamo
	 * @param idTitulo
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleAnexo> consultarDetallesByTitulo(Long idRamo, Long idTitulo) throws HiperionException;

}
