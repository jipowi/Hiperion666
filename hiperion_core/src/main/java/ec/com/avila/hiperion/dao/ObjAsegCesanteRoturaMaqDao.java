/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.ObjAsegLcRotMaq;

/**
 * <b> Interfaz local de la tabla ObjAsegAgropecuario para realizar las operaciones necesarias </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Oct 25, 2014
 * @since JDK1.6
 */
@Local
public interface ObjAsegCesanteRoturaMaqDao extends GenericDAO<ObjAsegLcRotMaq, Long> {

}
