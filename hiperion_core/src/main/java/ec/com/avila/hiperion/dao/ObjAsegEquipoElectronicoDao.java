/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.ObjAsegEquipo;

/**
 * <b> Interfaz local de la tabla ObjAsegEquipo para realizar las operaciones necesarias </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,04/11/2014
 * @since JDK1.6
 */
@Local
public interface ObjAsegEquipoElectronicoDao extends GenericDAO<ObjAsegEquipo, Long> {

}
