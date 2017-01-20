/**
 * 
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada;

/**
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla RamoGarantiaAduanera </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,10/08/2014
 * @since JDK1.6
 */
@Local
public interface RamoIncendioLineasAliadaService {

	/**
	 * 
	 * <b> Permite guadar los registros en la tabla RamoIncendioLineasAliadas </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 10/08/2014]
	 * </p>
	 * 
	 * @param ramoIncendioLineasAliada
	 * @throws HiperionException
	 */
	public void guardarRamoIncendioLineasAliada(RamoIncendioLineasAliada ramoIncendioLineasAliada, Poliza poliza) throws HiperionException;

	/**
	 * 
	 * <b> Permite Obtener la lista de RamoIncendioLineasAliada que se encuentren en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 10/08/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoIncendioLineasAliada> consultarRamoIncendioLineasAliada() throws HiperionException;

}
