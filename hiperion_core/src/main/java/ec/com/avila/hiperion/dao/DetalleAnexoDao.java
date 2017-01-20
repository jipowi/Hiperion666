/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;

/**
 * 
 * <b> Interfaz local de la tabla DetalleAnexo para realizar las operaciones necesarias</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@Local
public interface DetalleAnexoDao extends GenericDAO<DetalleAnexo, Long> {

	/**
	 * 
	 * <b> Permite consultar los detalles de anexos con un titulo determinado. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 15/01/2015]
	 * </p>
	 * 
	 * @param idDetalle
	 * @param idTitulo
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleAnexo> consultarDetallesByTitulo(Long idRamo, Long idTitulo) throws HiperionException;

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
