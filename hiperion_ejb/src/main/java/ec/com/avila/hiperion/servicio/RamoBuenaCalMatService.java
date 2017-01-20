/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoBuenaCalMat;

/**
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla RamoBuenaCalMat</b>
 * 
 * @author Susana Diaz
 * @version 1.0,16/01/2014
 * @since JDK1.6
 */
@Local
public interface RamoBuenaCalMatService {
	/**
	 * 
	 * <b> Permite guardar los registros en la tabla RamoBuenaCalMat. </b>
	 * <p>
	 * [Author: Susana Diaz, Date: 16/01/2014]
	 * </p>
	 * 
	 * @param ramoBuenaCalMat
	 * @throws HiperionException
	 */

	public void guardarRamoBuenaCalMat(RamoBuenaCalMat ramoBuenaCalMat, Poliza poliza) throws HiperionException;

	/**
	 * 
	 * <b> Permite Obtener la lista de RamoBuenaCalMat que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Susana Diaz, Date: 16/01/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoBuenaCalMat> consultarRamoBuenaCalMat() throws HiperionException;

}
