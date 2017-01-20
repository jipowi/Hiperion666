/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.CobertLcRot;

/**
 * <b> Interface local de la tabla CobertLcRotura Maquinaria que permite realizar las operaciones necesarias </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,15/01/2014
 * @since JDK1.6
 */
@Local
public interface CoberturaLcRoturaMaquinariaDao extends GenericDAO<CobertLcRot, Long> {

}
