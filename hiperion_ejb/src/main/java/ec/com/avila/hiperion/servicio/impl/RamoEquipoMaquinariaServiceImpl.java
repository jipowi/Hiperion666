/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ObjAsegEquipoMaquinariaDao;
import ec.com.avila.hiperion.dao.RamoEquipoMaquinariaDao;
import ec.com.avila.hiperion.emision.entities.ObjAsegEquipoMaq;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoEquipoMaquinaria;
import ec.com.avila.hiperion.servicio.RamoEquipoMaquinariaService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoEquipoMaquinariaServiceImpl implements RamoEquipoMaquinariaService {

	@EJB
	private ObjAsegEquipoMaquinariaDao asegEquipoMaquinariaDao;
	@EJB
	private RamoEquipoMaquinariaDao ramoEquipoMaquinariaDao;

	public void guardarRamoEquipoMaquinaria(RamoEquipoMaquinaria ramoEquipoMaquinaria, Poliza poliza) throws HiperionException {
		
		ramoEquipoMaquinariaDao.persist(ramoEquipoMaquinaria);
		
		for (ObjAsegEquipoMaq objeto : ramoEquipoMaquinaria.getObjAsegEquipoMaqs()) {
			asegEquipoMaquinariaDao.persist(objeto);
		}
	}

	public List<RamoEquipoMaquinaria> consultarRamoEquipoMaquinaria() throws HiperionException {
		return ramoEquipoMaquinariaDao.findAll();
	}

}
