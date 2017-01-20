package ec.com.avila.hiperion.web.util;

public class EmisionUtil {

	private static Integer longitudClientes = 4;

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
		for (int i = 0; i <= cantCeros; i++) {
			sb.append("0");
		}

		return sb.toString() + codigo;
	}
}
