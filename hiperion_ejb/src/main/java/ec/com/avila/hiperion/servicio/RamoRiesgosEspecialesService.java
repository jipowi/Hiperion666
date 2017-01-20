/**
 * 
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoRiesgosEsp;

/**
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla RamoRiesgoEspeciales< </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,24/10/2014
 * @since JDK1.6
 */
@Local
public interface RamoRiesgosEspecialesService {

	/**
	 * 
	 * <b> Permite guardar objetos en la tabla RamoRiesgEsp en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 24/10/2014]
	 * </p>
	 * 
	 * @param ramoRiesgosEsp
	 * @throws HiperionException
	 */
	
	public void guardarRamoRiesgosEspeciales(RamoRiesgosEsp ramoRiesgosEsp, Poliza poliza) throws HiperionException;

	/**
	 * 
	 * <b> Servicio de interface local para realizar las operaciones sobre la tabla RamoRiesgoEsp </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 24/10/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */

	public List<RamoRiesgosEsp> consultarRamoRiesgoEspeciales() throws HiperionException;
}
