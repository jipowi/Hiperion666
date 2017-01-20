/**
 * 
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClienteDao;
import ec.com.avila.hiperion.dao.DireccionDao;
import ec.com.avila.hiperion.dao.ProvinciaDao;
import ec.com.avila.hiperion.emision.entities.Direccion;
import ec.com.avila.hiperion.emision.entities.Provincia;
import ec.com.avila.hiperion.servicio.DireccionService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,10/09/2014
 * @since JDK1.6
 */
@Stateless
public class DireccionServiceImpl implements DireccionService {

	@EJB
	private DireccionDao direccionDao;

	@EJB
	private ProvinciaDao provinciaDao;

	@EJB
	private ClienteDao clienteDao;

	public DireccionServiceImpl() {
	}

	public void guardarDireccion(Direccion direccion) throws HiperionException {
		direccionDao.persist(direccion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.DireccionService#guardarDirecciones(java.util.List)
	 */
	@Override
	public void guardarDirecciones(List<Direccion> direcciones) throws HiperionException {

		for (Direccion direccion : direcciones) {
			direccionDao.persist(direccion);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.DireccionService#obtenerProvinciaById(java.lang.Long)
	 */
	@Override
	public Provincia obtenerProvinciaById(Long idProvincia) throws HiperionException {
		return provinciaDao.findById(idProvincia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.DireccionService#obtenerDireccionById(java.lang.Long)
	 */
	@Override
	public Direccion obtenerDireccionById(Long idDireccion) throws HiperionException {
		return direccionDao.findById(idDireccion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.DireccionService#actualizarDirecciones(java.util.List)
	 */
	@Override
	public void actualizarDirecciones(List<Direccion> direcciones, Integer idCliente) throws HiperionException {

		List<Direccion> direccionesTemp = clienteDao.consularDireccionByCliente(idCliente);
		if (!direccionesTemp.isEmpty()) {
			for (Direccion direccion : direccionesTemp) {
				direccionDao.delete(direccion);
			}
		}
		for (Direccion direccion : direcciones) {
			if (direccion.getIdDireccion() != null) {
				direccionDao.update(direccion);
			} else {
				direccionDao.persist(direccion);
			}
		}
	}

}
