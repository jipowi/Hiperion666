/**
 * Ministerio de Educacion del Ecuador
 * 
 * Producto: Sistema de Gestion de Docentes
 * Creado:  Nov 6, 2014
 * 
 * Todos los Derechos Reservados 2014
 */
package ec.com.avila.hiperion.web.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import ec.com.avila.hiperion.web.resources.Utils;

/**
 * <b>Clase Utilizada para generar los reportes de pdf embedded</b>
 * 
 * @author ronny
 * @verion 1.0
 * @since 1.6
 */
public class ReporteUtil {

	protected JasperReport report;
	protected File file;
	private static ReporteUtil INTANCIA = new ReporteUtil();

	/**
	 * Permite inicializar la clase del reporte, recibiendo el path del reporte.
	 * 
	 * @param reportPath
	 *            Path del reporte
	 * @throws JRException
	 *             Excepcion
	 * @throws IOException
	 *             Excepcion
	 */

	public ReporteUtil(String reportPath) throws JRException, IOException {
		file = new File(reportPath);
	}

	public ReporteUtil() {
	}

	public static ReporteUtil getInstancias() {
		return INTANCIA;
	}

	/**
	 * 
	 * <b> Permite generar el reporte pdf embedded. </b>
	 * <p>
	 * [Author: Ronny Yepez, Date: 28/08/2014]
	 * </p>
	 *
	 * @param nombreReporte
	 *            nombre del reporte a consultar
	 * @param parametros
	 *            filtros seleccionados para cargar el reporte
	 * @return
	 */
	public String generarReporte(String nombreReporte, Map<String, Object> parametros, HttpServletRequest request, Connection conn) {
		String rutaReporte = null;
		String url = Utils.getInstancia().obtenerPathCompleto(request);
		parametros.put("URL_LOGO", url + "/img/logo.png");
		parametros.put("CIUDAD", "Quito");
		try {
			JasperReport report = compileReport(nombreReporte);
			byte[] bytes = null;
			bytes = JasperRunManager.runReportToPdf(report, parametros, conn);
			// Si la carpeta temporal no existe la crea
			File file = new File(request.getServletContext()
					.getRealPath(HiperionMensajes.getInstancia().getString("valor.ruta.archivosTempReportes")));

			if (!file.exists()) {
				file.mkdir();
			}
			rutaReporte = HiperionMensajes.getInstancia().getString("valor.ruta.archivosTempReportes") + nombreReporte + System.currentTimeMillis()
					+ ".pdf";

			String reportPath = request.getServletContext().getRealPath(rutaReporte);

			guardarArchivo(request, bytes, reportPath);
			conn.close();
		} catch (Exception e) {
			request.getSession().setAttribute("error", "Error al generar el reporte solicitado.");
		}
		return rutaReporte;
	}

	public void guardarArchivo(HttpServletRequest request, byte[] bytes, String rutaArchivo) throws IOException {
		eliminarArchivos(request);
		file = new File(rutaArchivo);
		if (file.exists())
			file.delete();
		OutputStream os;
		try {
			os = new FileOutputStream(file);
			os.write(bytes);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void eliminarArchivos(HttpServletRequest request) throws IOException {
		File directorio = new File(request.getServletContext().getRealPath(
				HiperionMensajes.getInstancia().getString("valor.ruta.archivosTempReportes")));
		File[] ficheros = directorio.listFiles();
		for (int x = 0; x < ficheros.length; x++) {
			ficheros[x].delete();
		}
	}

	private JasperReport compileReport(String reportName) throws JRException {
		JasperReport report = null;
		if (null != getClass().getClassLoader().getResource("/report/" + reportName + ".jrxml")) {
			report = JasperCompileManager.compileReport(getClass().getClassLoader().getResourceAsStream("/report/" + reportName + ".jrxml"));
		}
		return report;
	}
}
