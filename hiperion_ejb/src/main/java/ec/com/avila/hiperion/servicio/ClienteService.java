/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.Contacto;
import ec.com.avila.hiperion.emision.entities.Direccion;

/**
 * 
 * <b> Servicio de Intreface local para realizar operaciones sobre la tabla Cliente</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Local
public interface ClienteService {

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla Cliente. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @param cliente
	 * @throws HiperionException
	 */
	public void guardarCliente(Cliente cliente, boolean save) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar los clientes ingresados </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 08/01/2015]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<Cliente> consultarClientes() throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar el cliente por medio de la cedula de identidad </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param identificacion
	 * @return
	 * @throws HiperionException
	 */
	public Cliente consultarClienteByIdentificacion(String identificacion) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar un cliente por medio de su apellido paterno </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param apellido
	 * @return
	 * @throws HiperionException
	 */
	public List<Cliente> consultarClienteByApellido(String apellido) throws HiperionException;

	/**
	 * 
	 * <b> Permite buscar clientes por nombre y apellido. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 11/01/2016]
	 * </p>
	 * 
	 * @param nombre
	 * @return
	 * @throws HiperionException
	 */
	public List<Cliente> consultarClienteByNombres(String nombre) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar las direcciones de un cliente. </b>
	 * <p>
	 * [Author: kruger, Date: 16/09/2016]
	 * </p>
	 * 
	 * @param idCliente
	 * @return
	 * @throws HiperionException
	 */
	public List<Direccion> consularDireccionByCliente(Integer idCliente) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener los contactos del cliente. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 26/09/2016]
	 * </p>
	 * 
	 * @param idCliente
	 * @return
	 * @throws HiperionException
	 */
	public List<Contacto> consultarContactoByCliente(Integer idCliente) throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar los contactos del cliente. </b>
	 * <p>
	 * [Author: kruger, Date: Oct 6, 2016]
	 * </p>
	 * 
	 * @param contactos
	 * @throws HiperionException
	 */
	public void guardarContactos(List<Contacto> contactos) throws HiperionException;

	/**
	 * 
	 * <b> Permite eliminar los contactos del cliente y actualizar por loos nuevos. </b>
	 * <p>
	 * [Author: kruger, Date: 04/01/2017]
	 * </p>
	 * 
	 * @param contactos
	 * @param idCliente
	 * @throws HiperionException
	 */
	public void actualizarContactos(List<Contacto> contactos, Integer idCliente) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener los clientes por razon social </b>
	 * <p>
	 * [Author: Franklin Pozo , Date: 31/10/2016]
	 * </p>
	 * 
	 * @param razonSocial
	 * @return
	 * @throws HiperionException
	 */
	public List<Cliente> consultarByRazonSocial(String razonSocial) throws HiperionException;
}
