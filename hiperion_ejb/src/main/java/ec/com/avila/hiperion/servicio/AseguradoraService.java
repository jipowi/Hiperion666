/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Aseguradora;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoAseguradora;

/**
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla Aseguradora</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 21, 2013
 * @since JDK1.6
 */
@Local
public interface AseguradoraService {

	/**
	 * 
	 * <b> Permite buscar las asegurdoras por medio del nombre o ruc </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 23, 2014]
	 * </p>
	 * 
	 * @param ruc
	 * @param aseguradora
	 * @return
	 * @throws HiperionException
	 */
	public Aseguradora consultarAseguradoraByRucAseg(String ruc, Integer aseguradora) throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar las aseguradoras con sus respectivos contactos. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 06/07/2015]
	 * </p>
	 * 
	 * @param aseguradora
	 * @param contactos
	 * @throws HiperionException
	 */
	public void guardarAseguradora(Aseguradora aseguradora, List<Cliente> contactos, List<RamoAseguradora> ramos, boolean save) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar la lista de clientes que posee una aseguradora. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 06/07/2015]
	 * </p>
	 * 
	 * @param aseguradora
	 * @return
	 * @throws HiperionException
	 */
	public List<Cliente> consultarClienteByAseguradora(String aseguradora) throws HiperionException;

	/**
	 * 
	 * <b> Permite buscar a aseguradora por medio del ID. </b>
	 * <p>
	 * [Author: HIPERION, Date: 29/02/2016]
	 * </p>
	 * 
	 * @param idAseguradora
	 * @return
	 * @throws HiperionException
	 */
	public Aseguradora consultarAseguradoraById(Long idAseguradora) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar una aseguradora por el codigo. </b>
	 * <p>
	 * [Author: HIPERION, Date: 29/02/2016]
	 * </p>
	 * 
	 * @param codigo
	 * @return
	 * @throws HiperionException
	 */
	public Aseguradora consultarAseguradoraByCodigo(String codigo) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar todos los ramos de la tabla. </b>
	 * <p>
	 * [Author: kruger, Date: 21/11/2016]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<Ramo> consultarRamos() throws HiperionException;

	/**
	 * 
	 * <b> Permite consulta el ramo por id. </b>
	 * <p>
	 * [Author: kruger, Date: 21/11/2016]
	 * </p>
	 * 
	 * @param idRamo
	 * @return
	 * @throws HiperionException
	 */
	public Ramo consultarRamoById(Long idRamo) throws HiperionException;

	/**
	 * 
	 * <b> Permite buscar los ramos por aseguradora ingresdos en la tabla. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 09/01/2017]
	 * </p>
	 * 
	 * @param idAseguradora
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoAseguradora> consultarRamoAseguradora(Long idAseguradora) throws HiperionException;
}
