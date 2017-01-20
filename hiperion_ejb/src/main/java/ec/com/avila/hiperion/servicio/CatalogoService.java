/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Catalogo;

/**
 * 
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla Catalogo</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Local
public interface CatalogoService {
	/**
	 * 
	 * <b> Permite obtener la lista de Catalogos que se encuentran en la base de Datos</b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */

	public List<Catalogo> consultarCatalogos() throws HiperionException;

	/**
	 * 
	 * <b> Consulta por codigo Catalogo </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @param idCatalogo
	 * @return
	 * @throws HiperionException
	 */

	public Catalogo consultarCatalogoById(Long idCatalogo) throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar un catalogo </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 30/11/2014]
	 * </p>
	 * 
	 * @param catalogo
	 * @throws HiperionException
	 */
	public void modificarCatalogo(Catalogo catalogo) throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar el catalogoe en la tabla Catalogo </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 30/11/2014]
	 * </p>
	 * 
	 * @param catalogo
	 * @throws HiperionException
	 */
	public void guardarCatalogo(Catalogo catalogo) throws HiperionException;

}