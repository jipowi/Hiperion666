/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao.impl;

import javax.ejb.Stateless;

import ec.com.avila.hiperion.dao.CatalogoDao;
import ec.com.avila.hiperion.emision.entities.Catalogo;

/**
 * 
 * <b> Permite implementar las operaciones de la tabla Catalogo </b>
 * 
 * @author Franklin
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Stateless
public class CatalogoDaoImpl extends GenericDAOImpl<Catalogo, Long> implements CatalogoDao {

}
