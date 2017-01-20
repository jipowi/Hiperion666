/**
 * 
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.TipoDireccion;

/**
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla TipoDireccion. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,08/06/2014
 * @since JDK1.6
 */
@Local
public interface TipoDireccionService {

	/**
	 * 
	 * <b> Permite obtener lista de todos los tipo de direccion que se encuentran registrados en el sistema.. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 08/06/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<TipoDireccion> consultarTiposDireccion() throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar el tipo de direccion por Codigo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 22/06/2014]
	 * </p>
	 * 
	 * @param codTipoDireccion
	 *            - c&oacute;digo del tipo de direcci&ocaute;n.
	 * @return Objeto de tipo TipoDireccion.
	 * @throws HiperionException
	 *             - Excepci&oacte;n del Servicio.
	 */
	public TipoDireccion consultarTipoDireccionByCodigo(String codTipoDireccion) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar el tipo de direccion por la Descripci&oacute;n. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 * @param descripcion
	 *            - descripci&oacute;n de la direcci&oacuten;
	 * @return Objeto de tipo TipoDireccion
	 * @throws HiperionException
	 *             - Excepci&oacte;n del Servicio.
	 */
	public TipoDireccion consultarTipoDireccionByDescripcion(String descripcion) throws HiperionException;
}
