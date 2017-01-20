/**
 * 
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.TipoDireccionDao;
import ec.com.avila.hiperion.emision.entities.TipoDireccion;
import ec.com.avila.hiperion.servicio.TipoDireccionService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,08/06/2014
 * @since JDK1.6
 */
@Stateless
public class TipoDireccionServiceImpl implements TipoDireccionService {

	@EJB
	private TipoDireccionDao tipoDireccionDao;

	public TipoDireccionServiceImpl() {
	}

	public List<TipoDireccion> consultarTiposDireccion() throws HiperionException {
		return tipoDireccionDao.consultarTiposDireccion();
	}

	public TipoDireccion consultarTipoDireccionByCodigo(String codTipoDireccion) throws HiperionException {
		return tipoDireccionDao.consultarTipoDireccionByCodigo(codTipoDireccion);
	}

	public TipoDireccion consultarTipoDireccionByDescripcion(String descripcion) throws HiperionException {
		return tipoDireccionDao.consultarTipoDireccionByDescripcion(descripcion);
	}

}
