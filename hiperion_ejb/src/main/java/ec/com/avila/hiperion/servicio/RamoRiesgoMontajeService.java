/**
 * 
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje;

/**
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla RamoRiesgoContratista </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,12/10/2014
 * @since JDK1.6
 */
@Local
public interface RamoRiesgoMontajeService {

	/**
	 * 
	 * <b> Permite Obtener la lista de RamoRiesgoMontaje que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 12/10/2014]
	 * </p>
	 * 
	 * @param ramoRiesgoMontaje
	 * @throws HiperionException
	 */
	public void guardarRamoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje, Poliza poliza) throws HiperionException;

	/**
	 * 
	 * <b> Permite Obtener la lista de RamoRiesgoMontaje que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 12/10/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoRiesgoMontaje> consultarRamoRiesgoMontaje() throws HiperionException;

}
