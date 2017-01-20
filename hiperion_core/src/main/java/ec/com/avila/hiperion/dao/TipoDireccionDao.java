/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.TipoDireccion;

/**
 * <b> Interfaz local de la tabla TipoDireccion para realizar las operaciones necesarias. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,08/06/2014
 * @since JDK1.6
 */
@Local
public interface TipoDireccionDao {

	/**
	 * 
	 * <b> Permite obtener lista de todos los tipo de direccion que se encuentran registrados en el sistema. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 08/06/2014]
	 * </p>
	 * 
	 * @return Lista de Objetos de tipo TipoDireccion.
	 * @throws HiperionException
	 *             - Excepci&oacute;n del Servicio.
	 */
	public List<TipoDireccion> consultarTiposDireccion() throws HiperionException;

	/**
	 * 
	 * <b>Permite consultar el tipo de direccion por Codigo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 22/06/2014]
	 * </p>
	 * 
	 * @param codTipoDireccion
	 *            - C&oacute;digo del tipo de Direcci&ocaute;n.
	 * @return Objeto de tipo TipoDireccion.
	 * @throws HiperionException
	 *             - Excepci&oacute;n del Servicio.
	 */
	public TipoDireccion consultarTipoDireccionByCodigo(String codTipoDireccion) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar el tipo de direccion por Descripci&oacute;n. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 * @param descripcion
	 *            - Descripci&oacute;n de la Direcci&ocaute;n.
	 * @return Objeto de tipo TipoDireccion.
	 * @throws HiperionException
	 *             - Excepci&oacute;n del Servicio.
	 */
	public TipoDireccion consultarTipoDireccionByDescripcion(String descripcion) throws HiperionException;
}
