/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.ObjAsegDineroVal;

/**
 * <b> Interfaz local de la tabla ObjAsegDineroValores para realizar las operaciones necesarias </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,04/11/2014
 * @since JDK1.6
 */
@Local
public interface ObjAsegDineroValoresDao extends GenericDAO<ObjAsegDineroVal, Long> {

}
