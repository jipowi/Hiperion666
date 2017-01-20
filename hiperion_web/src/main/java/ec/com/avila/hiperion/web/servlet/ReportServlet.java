/**
 * Ministerio de Educacion del Ecuador
 * 
 * Producto: Sistema de Gestion de Docentes
 * Creado:  Sep 04, 2014
 * 
 * Todos los Derechos Reservados 2014
 */
package ec.com.avila.hiperion.web.servlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.FileResolver;
import net.sf.jasperreports.engine.util.LocalJasperReportsContext;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.web.resources.Utils;

/**
 * <b>Clase Utilizada para generar los reportes Jasper</b>
 * 
 * @author gyandun
 * @version 1.0
 * @since 1.6
 */
@WebServlet("/report")
public class ReportServlet extends HttpServlet {

	private static final long serialVersionUID = 8795000477609113780L;

	@Resource(mappedName = "java:/AvilaSgsDS")
	private DataSource dataSource;

	Logger log = Logger.getLogger(ReportServlet.class);

	public static final String SUB_REPORT_PREFIX = "/WEB-INF/classes";
	public static final String REPORT_PREFIX = "/report/";
	public static final String REPORT_SUFFIX = ".jasper";
	public static final String REPORT_DEFINITION_SUFFIX = ".jrxml";
	public static final String OBJETO_REPORTE = "minedu_reportes";
	public static final String OBJETO_SUB_REPORTE = "minedu_subReportes";
	public static final String TIPO_REPORTE = "TIPO_REPORTE";
	public static final String NOMBRE_REPORTE = "NOMBRE_REPORTE";

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String reporte = request.getParameter("reporte");
			Map<String, Object> args = (HashMap<String, Object>) request.getSession().getAttribute(OBJETO_REPORTE);
			if (args == null) {
				args = new HashMap<String, Object>();
			}
			if (args.containsKey(NOMBRE_REPORTE)) {
				reporte = (String) args.get(NOMBRE_REPORTE);
				args.remove(NOMBRE_REPORTE);
			}
			JasperReport report = compileReport(reporte);

			String tipoReporte = (String) args.get(TIPO_REPORTE);
			compilarSubReportes(request);

			String url = Utils.getInstancia().obtenerPathCompleto(request);

			args.put("URL_LOGO", url + "/img/logo.png");

			args.put("CIUDAD", "Quito");

			if (tipoReporte.equals("excel")) {
				ByteArrayOutputStream outByte = new ByteArrayOutputStream();
				escribirXls(dataSource.getConnection(), outByte, reporte, report, args);
				byte[] bytes = outByte.toByteArray();
				response.setContentType("application/ms-excel");
				response.setHeader("Content-Disposition", "inline;filename=" + reporte + ".xls;");
				response.setContentLength(bytes.length);
				response.getOutputStream().write(bytes);
			} else {
				byte[] result = JasperRunManager.runReportToPdf(report, args, dataSource.getConnection());
				response.setContentType("application/pdf");
				response.setContentLength(result.length);
				response.setHeader("Content-Disposition", "inline;filename=" + reporte + ".pdf;");
				response.getOutputStream().write(result);
			}

		} catch (JRException e) {
			log.error("Error: ", e);
		} catch (SQLException e) {
			log.error("Error: ", e);
		}
	}

	/**
	 * 
	 * <b> Permite compilar el reporte.</b> <b> Creado por</b>: Ronny, <b>Fecha:</b> 01/12/2014
	 * 
	 * @param reportName
	 *            nombre del reporte
	 * @return Devuelve el reporte en formato Jasper
	 * @throws JRException
	 *             En caso de error en el proceso
	 */
	private JasperReport compileReport(String reportName) throws JRException {
		JasperReport report = null;
		if (null != getClass().getClassLoader().getResource(REPORT_PREFIX + reportName + REPORT_DEFINITION_SUFFIX)) {
			report = JasperCompileManager.compileReport(getClass().getClassLoader().getResourceAsStream(
					REPORT_PREFIX + reportName + REPORT_DEFINITION_SUFFIX));
		}
		return report;
	}

	/**
	 * 
	 * <b> Permite generar un archivo jasper a partir del .jrxml.</b> <b> Creado por</b>: Ronny, <b>Fecha:</b> 16/09/2014
	 * 
	 * @param file
	 *            Archivo .jasper del reporte
	 * @return Devuelve el archivo temporal
	 * @throws Exception
	 *             En caso de error en el proceso
	 */
	private File compilarReporte(File file) throws Exception {
		JasperDesign design = JRXmlLoader.load(file.getPath());
		File fileTmp = new File(file.getParent() + File.separator + file.getName().replaceAll(".jrxml", ".jasper"));
		fileTmp.createNewFile();
		OutputStream out = new FileOutputStream(fileTmp);
		JasperCompileManager.compileReportToStream(design, out);
		out.close();
		return fileTmp;
	}

	/**
	 * 
	 * <b> Permite compilar subreportes en caso de tenerlos.</b> <b> Creado por</b>: Ronny, <b>Fecha:</b> 16/09/2014
	 * 
	 * @param request
	 *            Solicitud enviada al servlet
	 */
	@SuppressWarnings("unchecked")
	private void compilarSubReportes(HttpServletRequest request) {
		String path = "";
		Map<String, Object> subReportes = (HashMap<String, Object>) request.getSession().getAttribute(OBJETO_SUB_REPORTE);
		if (subReportes != null) {
			for (Object clave : subReportes.keySet()) {
				path = SUB_REPORT_PREFIX + REPORT_PREFIX + clave + REPORT_DEFINITION_SUFFIX;
				String path2 = this.getServletContext().getRealPath(path);
				File file = new File(path2);
				try {
					file.createNewFile();
					compilarReporte(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * <b> Permite obtener el contexto del reporte.</b> <b> Creado por</b>: Ronny, <b>Fecha:</b> 01/12/2014
	 * 
	 * @param file
	 *            Archivo temporal del reporte
	 * @return Devulve LocalJasperReportsContext
	 */
	private LocalJasperReportsContext getReportContext(final File file) {
		FileResolver resolver = new FileResolver() {
			@Override
			public File resolveFile(String filename) {
				return new File(file.getParent() + File.separator + filename);
			}
		};

		LocalJasperReportsContext ctx = new LocalJasperReportsContext(DefaultJasperReportsContext.getInstance());
		ctx.setClassLoader(getClass().getClassLoader());
		ctx.setFileResolver(resolver);
		return ctx;
	}

	/**
	 * 
	 * <b> Incluir documentacion de metodo.</b> <b> Creado por</b>: Ronny, <b>Fecha:</b> 16/10/2014
	 * 
	 * @param conn
	 *            Conexion con el dataSource
	 * @param out
	 *            salida de bytes
	 * @param clave
	 *            Nombre del Reporte
	 * @param jasper
	 *            Jasper Generado
	 * @param parametros
	 *            Parametros que recibe el reporte
	 */
	public void escribirXls(Connection conn, ByteArrayOutputStream out, String clave, JasperReport jasper, Map<String, Object> parametros) {
		try {
			String path = SUB_REPORT_PREFIX + REPORT_PREFIX + clave + REPORT_DEFINITION_SUFFIX;
			String path2 = this.getServletContext().getRealPath(path);
			File file = new File(path2);
			file.createNewFile();
			LocalJasperReportsContext ctx = getReportContext(file);

			JasperReport jasperReport = jasper;
			JasperFillManager fillmgr = JasperFillManager.getInstance(ctx);

			JasperPrint jp = fillmgr.fill(jasperReport, parametros, conn);
			JRXlsExporter exporter = new JRXlsExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER, Boolean.FALSE);
			exporter.exportReport();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

}
