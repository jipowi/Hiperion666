/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.ClausulasAddAccPer;
import ec.com.avila.hiperion.emision.entities.CobertAccPer;
import ec.com.avila.hiperion.emision.entities.CondEspAccPer;
import ec.com.avila.hiperion.emision.entities.GrupoAccPersonale;
import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;

/**
 * <b> Interface local de la tabla RamoAccidentesPersonale </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,30/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoAccidentesPersonalesDao extends GenericDAO<RamoAccidentesPersonale, Long> {

	/**
	 * 
	 * <b> Permite consultar el ramoAccidentePersonales mediante el idPoliza. </b>
	 * <p>
	 * [Author: kruger, Date: 23/11/2016]
	 * </p>
	 * 
	 * @param ipPoliza
	 * @return
	 * @throws HiperionException
	 */
	public RamoAccidentesPersonale consultarRamo(Integer ipPoliza) throws HiperionException;

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
