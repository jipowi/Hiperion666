package ec.com.avila.hiperion.web.util;

import org.apache.log4j.Logger;

public class EmisionUtil {


	private static Integer longitudClientes = 3;

	Logger log = Logger.getLogger(EmisionUtil.class);

	/**
	 * 
	 * <b> Permite Obtener el Codigo del Cliente que se registra en AVILA. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 11, 2014]
	 * </p>
	 * 
	 * @param codigo
	 * @return
	 */
	public static String obtenerCodigoCliente(Integer codigo) {
		int codigoLength = String.valueOf(codigo).length();
		int cantCeros = longitudClientes - codigoLength;
		StringBuffer sb = new StringBuffer(cantCeros + 1);
		sb.append("AV");
		for (int i = 0; i <= cantCeros; i++) {
			sb.append("0");
		}

		return sb.toString() + codigo;
	}

	/**
	 * 
	 * <b> Permite obtener el codigo de sinistro. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 13/12/2015]
	 * </p>
	 * 
	 * @param codigo
	 * @return codigo de siniestro
	 */
	public static String obtenerCodigoSiniestro(Integer codigo) {
		int codigoLength = String.valueOf(codigo).length();
		int cantCeros = longitudClientes - codigoLength;
		StringBuffer sb = new StringBuffer(cantCeros + 1);
		sb.append("AV-S");
		for (int i = 0; i <= cantCeros; i++) {
			sb.append("0");
		}

		return sb.toString() + codigo;
	}

}
