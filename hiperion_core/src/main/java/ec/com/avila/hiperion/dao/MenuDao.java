/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Menu;
import ec.com.avila.hiperion.emision.entities.Rol;
import ec.com.avila.hiperion.emision.entities.RolMenu;

/**
 * <b> Interfaz local para operaciones con la tabla Menu. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 10, 2014
 * @since JDK1.6
 */
@Local
public interface MenuDao extends GenericDAO<Menu, Long> {

	/**
	 * 
	 * <b> Permite consultar los menus a los cuales un rol tiene acceso </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 10, 2014]
	 * </p>
	 * 
	 * @param rol
	 * @return
	 * @throws HiperionException
	 */
	public List<RolMenu> consultarMenuByRol(Rol rol) throws HiperionException;
}
