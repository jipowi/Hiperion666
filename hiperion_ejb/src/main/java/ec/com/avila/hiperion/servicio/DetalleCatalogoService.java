/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;

/**
 * 
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla Detalle catalogo </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Local
public interface DetalleCatalogoService {

	/**
	 * 
	 * <b> Consulta por codigo de catalogo </b>
	 * <p>
	 * [Author: Franklin, Date: 21/12/2013]
	 * </p>
	 * 
	 * @param idCatalogo
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogoByCodCatalogo(Long idCatalogo) throws HiperionException;

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param codDepCatalogo
	 * @param codDepDetCatalogo
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogoByDepCatalogo(String codDepCatalogo, String codDepDetCatalogo) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de Detalle Catalogos que se encuentra en la base de datos</b>
	 * 
	 * <p>
	 * [Author: Franklin, Date: 21/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogo() throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla Detalle Catalogo </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @param detalle
	 * @throws HiperionException
	 */
	public void guardarDetalleCatalogo(DetalleCatalogo detalle) throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar los registros en la tabla Catalogo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param detalle
	 * @throws HiperionException
	 */
	public void modificarDetalleCatalogo(DetalleCatalogo detalle) throws HiperionException;
	
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

}
