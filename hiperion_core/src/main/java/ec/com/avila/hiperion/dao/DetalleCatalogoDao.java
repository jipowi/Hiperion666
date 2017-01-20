/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;

/**
 * 
 * <b> Interfaz local de la tabla DetalleCatalogo para realizar las operaciones necesarias</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@Local
public interface DetalleCatalogoDao extends GenericDAO<DetalleCatalogo, Long> {

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla
	 * <p>
	 * [Author: Paul Jimemenez, Date: Dec 18, 2013]
	 * </p>
	 * 
	 * @param idCatalogo
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogoByCodCatalogo(Long idCatalogo) throws HiperionException;

	/**
	 * 
	 * <b> Catalogo utilizado para consultar los registros por medio del ID_CATALOGO y del COD_DEP_DETALLE_CATALOGO </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 28, 2014]
	 * </p>
	 * 
	 * @param codDepCatalogo
	 * @param idCatalogo
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogoByCodDetalle(String codDepCatalogo, Long idCatalogo) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar el detalle de un catalogo mediante el ingreso del codigo de dependencia del catalogo y el codigo de dependencia del detalle del catalogo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param codDepDetCalogo
	 *            - codigo de Dependencia del Catalogo
	 * @param codDepDetCalogo
	 *            - codigo de Dependencia del Detalle del Catalogo
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogoByDepCatalogo(String codDepCatalogo, String codDepDetCalogo) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar un detalle de catalogo por medio del idCatalogo y idDetalle </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 27, 2014]
	 * </p>
	 * 
	 * @param codCatalogo
	 * @param codDetCalogo
	 * @return
	 * @throws HiperionException
	 */
	public DetalleCatalogo consultarDetalleByCatalogoAndDetalle(Integer codCatalogo, Integer codDetCalogo) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar el detalle de catologo mediante el ingreso. del codigo de catalogo</b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Dec 18, 2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogo() throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar el detalle del catalogo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 18, 2013]
	 * </p>
	 * 
	 * @param detalle
	 * @throws HiperionException
	 */
	public void guardarDetalleCatalogo(DetalleCatalogo detalle) throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar los datos de la tabla DetalleCatalogo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param detalle
	 * @throws HiperionException
	 */
	public void modificarDetalleCatalogo(DetalleCatalogo detalle) throws HiperionException;
}
