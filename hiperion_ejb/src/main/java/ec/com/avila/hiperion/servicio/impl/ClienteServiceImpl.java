/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClienteDao;
import ec.com.avila.hiperion.dao.ContactoDao;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.Contacto;
import ec.com.avila.hiperion.emision.entities.Direccion;
import ec.com.avila.hiperion.servicio.ClienteService;

@Stateless
public class ClienteServiceImpl implements ClienteService {

	@EJB
	private ClienteDao clienteDao;
	@EJB
	private ContactoDao contactoDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#consultarClienteByIdentificacion(java.lang.String)
	 */
	@Override
	public Cliente consultarClienteByIdentificacion(String identificacion) throws HiperionException {
		return clienteDao.consultarClienteByIdentificacion(identificacion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#consultarClienteByApellido(java.lang.String)
	 */
	@Override
	public List<Cliente> consultarClienteByApellido(String apellido) throws HiperionException {
		return clienteDao.consultarClienteByApellido(apellido);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#guardarCliente(ec.com.avila.hiperion.emision.entities.Cliente)
	 */
	@Override
	public void guardarCliente(Cliente cliente, boolean save) throws HiperionException {

		if (save)
			clienteDao.persist(cliente);
		else
			clienteDao.update(cliente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#consultarClientes()
	 */
	@Override
	public List<Cliente> consultarClientes() throws HiperionException {
		return clienteDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#consultarClienteByNombres(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Cliente> consultarClienteByNombres(String nombre) throws HiperionException {
		return clienteDao.consultarClienteByNombres(nombre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#consularDireccionByCliente(java.lang.Long)
	 */
	@Override
	public List<Direccion> consularDireccionByCliente(Integer idCliente) throws HiperionException {
		return clienteDao.consularDireccionByCliente(idCliente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#consultarContactoByCliente(java.lang.Integer)
	 */
	@Override
	public List<Contacto> consultarContactoByCliente(Integer idCliente) throws HiperionException {
		return clienteDao.consultarContactoByCliente(idCliente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#consultarByRazonSocial(java.lang.String)
	 */
	@Override
	public List<Cliente> consultarByRazonSocial(String razonSocial) throws HiperionException {

		return clienteDao.consultarByRazonSocial(razonSocial);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#guardarContactos(java.util.List)
	 */
	@Override
	public void guardarContactos(List<Contacto> contactos) throws HiperionException {
		for (Contacto contacto : contactos) {
			contactoDao.persist(contacto);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#actulizarContactos(java.util.List, java.lang.Integer)
	 */
	@Override
	public void actualizarContactos(List<Contacto> contactos, Integer idCliente) throws HiperionException {
		List<Contacto> contactosTemp = consultarContactoByCliente(idCliente);
		if (!contactosTemp.isEmpty()) {
			eliminarContactos(contactosTemp, idCliente);
		}

		for (Contacto contacto : contactos) {
			if (contacto.getIdContacto() != null) {
				contactoDao.update(contacto);
			} else {
				contactoDao.persist(contacto);
			}
		}

	}

	/**
	 * 
	 * <b> Permite eliminar los contactos de la tabla. </b>
	 * <p>
	 * [Author: kruger, Date: 04/01/2017]
	 * </p>
	 * 
	 * @param contactos
	 * @param idCliente
	 * @throws HiperionException
	 */
	private void eliminarContactos(List<Contacto> contactos, Integer idCliente) throws HiperionException {
		for (Contacto contacto : contactos) {
			contactoDao.delete(contacto);
		}
	}
}
