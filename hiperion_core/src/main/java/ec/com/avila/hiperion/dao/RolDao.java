/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Rol;
import ec.com.avila.hiperion.emision.entities.Usuario;

/**
 * <b> Interfaz local para operaciones sobre la tabla de roles </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 10, 2014
 * @since JDK1.6
 */
@Local
public interface RolDao extends GenericDAO<Rol, Long> {

	/**
	 * 
	 * <b> Permite consultar los roles que tiene un usuario </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 10, 2014]
	 * </p>
	 * 
	 * @param usuario
	 * @return
	 * @throws HiperionException
	 */
	public List<Rol> consultarRolByUsuario(Usuario usuario) throws HiperionException;
}
