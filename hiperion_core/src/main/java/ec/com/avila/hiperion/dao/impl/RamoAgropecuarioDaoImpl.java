/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoAgropecuarioDao;
import ec.com.avila.hiperion.emision.entities.ArchivoBase;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;

/**
 * <b> Permite implementar las operaciones de la tabla RAMO_AGROPECUARIO. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,09/03/2014
 * @since JDK1.6
 */

@Stateless
public class RamoAgropecuarioDaoImpl extends GenericDAOImpl<RamoAgropecuario, Long> implements RamoAgropecuarioDao {

	Logger log = Logger.getLogger(RamoAgropecuarioDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.RamoAgropecuarioDao#guardarArchivoPoliza(ec.com.avila.hiperion.emision.entities.ArchivoBase)
	 */
	@Override
	public void guardarArchivoPoliza(ArchivoBase file) throws HiperionException {
		try {

			em.persist(file);

		} catch (Exception e) {
			log.error("Error no se pudo guardar el archivo en el ramo agropecuario ", e);
			throw new HiperionException(e);
		}

	}

}
