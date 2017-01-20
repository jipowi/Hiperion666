/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClienteDao;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.Contacto;
import ec.com.avila.hiperion.emision.entities.Direccion;
import ec.com.avila.hiperion.enumeration.EstadoEnum;

/**
 * 
 * <b> Clase que implementa operaciones de la tabla Cliente </b>
 * 
 * @author Dario Vinueza
 * @version 1.0, Nov 9, 2013
 * @since JDK1.6
 */
@Stateless
public class ClienteDaoImpl extends GenericDAOImpl<Cliente, Long> implements ClienteDao {

	Logger log = Logger.getLogger(ClienteDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.ClienteDao#consultarClienteByIdentificacion()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Cliente consultarClienteByIdentificacion(String identificacion) throws HiperionException {
		Query query = em.createNamedQuery("Cliente.findByIdentificacion");
		query.setParameter("identificacion", identificacion);

		List<Cliente> clientes = query.getResultList();

		if (!clientes.isEmpty()) {
			return clientes.get(0);
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.ClienteDao#consultarClienteByApellido(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> consultarClienteByApellido(String apellido) throws HiperionException {
		Query query = em.createNamedQuery("Cliente.findByApellido");
		query.setParameter("apellido", "%" + apellido + "%");
		List<Cliente> clientes = query.getResultList();
		return clientes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.ClienteDao#consultarClienteByAseguradora(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> consultarClienteByAseguradora(String aseguradora) throws HiperionException {
		Query query = em.createNamedQuery("Cliente.findByAseguradora");
		query.setParameter("aseguradora", aseguradora);
		query.setParameter("estado", EstadoEnum.A);

		List<Cliente> clientes = query.getResultList();

		if (!clientes.isEmpty()) {
			return clientes;
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.ClienteDao#consultarClienteByNombres(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> consultarClienteByNombres(String nombre) throws HiperionException {
		Query query = em.createNamedQuery("Cliente.findByNombres");
		query.setParameter("nombre", "%" + nombre + "%");
		List<Cliente> clientes = query.getResultList();

		return clientes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.ClienteDao#consularDireccionByCliente(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Direccion> consularDireccionByCliente(Integer idCliente) throws HiperionException {
		Query query = em.createNamedQuery("Direccion.findCliente");
		query.setParameter("idCliente", idCliente);
		List<Direccion> direcciones = query.getResultList();

		return direcciones;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.ClienteDao#consultarContactoByCliente(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contacto> consultarContactoByCliente(Integer idCliente) throws HiperionException {
		Query query = em.createNamedQuery("Contacto.findByCliente");
		query.setParameter("idCliente", idCliente);
		List<Contacto> contactos = query.getResultList();

		return contactos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.ClienteDao#consultarByRazonSocial(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> consultarByRazonSocial(String razonSocial) throws HiperionException {

		Query query = em.createNamedQuery("Cliente.findByRazonSocial");
		query.setParameter("razonSocial", "%" + razonSocial + "%");
		List<Cliente> nombreEmpresa = query.getResultList();
		return nombreEmpresa;
	}

}
