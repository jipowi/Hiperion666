/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ProvinciaDao;
import ec.com.avila.hiperion.emision.entities.Provincia;
import ec.com.avila.hiperion.servicio.ProvinciaService;

@Stateless
public class ProvinciaServiceImpl implements ProvinciaService {

	@EJB
	private ProvinciaDao provinciaDao;

	public ProvinciaServiceImpl() {
	}

	public List<Provincia> consultarProvincias() throws HiperionException {
		return provinciaDao.consultarProvincias();
	}

	public Provincia consultarProvinciaPorCodigo(String codProvicia) throws HiperionException {
		return provinciaDao.consultarProvinciaPorCodigo(codProvicia);
	}
}
