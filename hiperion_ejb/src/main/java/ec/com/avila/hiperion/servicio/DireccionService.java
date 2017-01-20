/**
 * 
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Direccion;
import ec.com.avila.hiperion.emision.entities.Provincia;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza.
 * @version 1.0,10/09/2014
 * @since JDK1.6
 */
@Local
public interface DireccionService {

	/**
	 * 
	 * <b> Permite guardar un registro de direccion en la base de datos. </b>
	 * <p>
	 * [Author: kruger, Date: Oct 10, 2016]
	 * </p>
	 * 
	 * @param direccion
	 * @throws HiperionException
	 */
	public void guardarDireccion(Direccion direccion) throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar mas de una direccion en la base de datos. </b>
	 * <p>
	 * [Author: kruger, Date: Oct 10, 2016]
	 * </p>
	 * 
	 * @param direcciones
	 * @throws HiperionException
	 */
	public void guardarDirecciones(List<Direccion> direcciones) throws HiperionException;

	/**
	 * 
	 * <b> Permite actualizar las direcciones en la base de datos. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 09/01/2017]
	 * </p>
	 * 
	 * @param direcciones
	 * @param idCliente
	 * @throws HiperionException
	 */
	public void actualizarDirecciones(List<Direccion> direcciones, Integer idCliente) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener una provincia por medio ID. </b>
	 * <p>
	 * [Author: kruger, Date: Oct 10, 2016]
	 * </p>
	 * 
	 * @param idProvincia
	 * @throws HiperionException
	 */
	public Provincia obtenerProvinciaById(Long idProvincia) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la direccion por medio del ID. </b>
	 * <p>
	 * [Author: kruger, Date: 12/12/2016]
	 * </p>
	 * 
	 * @param idDireccion
	 * @return
	 * @throws HiperionException
	 */
	public Direccion obtenerDireccionById(Long idDireccion) throws HiperionException;

}
