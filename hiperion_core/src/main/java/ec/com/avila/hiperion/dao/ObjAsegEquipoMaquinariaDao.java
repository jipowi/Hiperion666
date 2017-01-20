/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.ObjAsegEquipoMaq;

/**
 * <b> Interfaz local de la tabla ObjAsegEquipoMaquinaria para realizar las operaciones necesarias </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,08/11/2014
 * @since JDK1.6
 */
@Local
public interface ObjAsegEquipoMaquinariaDao extends GenericDAO<ObjAsegEquipoMaq, Long> {

}
