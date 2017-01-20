/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt;

/**
 * <b> Interfaz local del para realizar las operaciones en la tabla RamoBuenUsoAnt </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,12/08/2014
 * @since JDK1.6
 */
@Local
public interface RamoBuenUsoAnticipoDao extends GenericDAO<RamoBuenUsoAnt, Long> {

}
