/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.ClausulasAddAccPer;
import ec.com.avila.hiperion.emision.entities.CobertAccPer;
import ec.com.avila.hiperion.emision.entities.CondEspAccPer;
import ec.com.avila.hiperion.emision.entities.GrupoAccPersonale;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;

/**
 * <b> Servicio de Interfaz local que realiza las operaciones sobre la tabla RamoAccidentesPersonales </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,31/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoAccidentesPersonalesService {

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla RamoAccidentesPersonales </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 31/12/2013]
	 * </p>
	 * 
	 * @param ramoAccidentesPersonales
	 * @throws HiperionException
	 */
	public void guardarRamoAccidentesPersonales(RamoAccidentesPersonale ramoAccidentesPersonales, Poliza poliza, List<GrupoAccPersonale> grupos, List<CobertAccPer> coberturas,
			List<CondEspAccPer> condiciones, List<ClausulasAddAccPer> clausulas) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de RamoAccidentesPersonales que se encuentran an la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 31/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoAccidentesPersonale> consultarRamoAccidentesPersonales() throws HiperionException;
	
	/**
	 * 
	 * <b> Permite consultar la lista de grupos que posee el ramo. </b>
	 * <p>
	 * [Author: kruger, Date: 10/04/2017]
	 * </p>
	 * 
	 * @param idRamo
	 * @return
	 * @throws HiperionException
	 */
	public List<GrupoAccPersonale> cosultarGruposByRamo(Long idRamo) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de coberturas pertenecientes a un ramo. </b>
	 * <p>
	 * [Author: kruger, Date: 10/04/2017]
	 * </p>
	 * 
	 * @param idRamo
	 * @return
	 * @throws HiperionException
	 */
	public List<CobertAccPer> consultarCoberturasByRamo(Long idRamo) throws HiperionException;
	
	/**
	 * 
	 * <b> Permite obtener la lista de coberturas pertenecientes a un ramo. </b>
	 * <p>
	 * [Author: kruger, Date: 18/05/2017]
	 * </p>
	 * 
	 * @param idRamo
	 * @return
	 * @throws HiperionException
	 */
	public List<CondEspAccPer> consultarCondicionesByRamo(Long idRamo) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de clausulas adicionales pertenecientes a un ramo. </b>
	 * <p>
	 * [Author: kruger, Date: 18/05/2017]
	 * </p>
	 * 
	 * @param idRamo
	 * @return
	 * @throws HiperionException
	 */
	public List<ClausulasAddAccPer> consultarClausulasByRamo(Long idRamo) throws HiperionException;

}
