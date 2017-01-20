package ec.com.avila.hiperion.web.servlet;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.com.avila.hiperion.web.util.ConstantesUtil;

public class Descargador extends HttpServlet {

	private static final long serialVersionUID = -98167344154980690L;

	public void doPost(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException {
		procesarPeticion(pRequest, pResponse);
	}

	public void doGet(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException {
		procesarPeticion(pRequest, pResponse);
	}


	@SuppressWarnings("unchecked")
	private void procesarPeticion(HttpServletRequest pHttpServletRequest, HttpServletResponse pHttpServletResponse) throws ServletException {
		try {
			Map<String, Object> parametrosReporte = (HashMap<String, Object>) pHttpServletRequest.getSession().getAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR);
			String contentType = (String) parametrosReporte.get(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR);
			String nombreArchivo = (String) parametrosReporte.get(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR);
			byte[] contenidoBytes = (byte[]) parametrosReporte.get(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR);

			if (ConstantesUtil.CONTENT_TYPE_PDF.equals(contentType)) {
				pHttpServletResponse.setContentType(contentType);
				pHttpServletResponse.setHeader(ConstantesUtil.CONTENT_DISPOSITION, ConstantesUtil.CONTENT_ATTACHMENT_FILE_NAME + nombreArchivo + ConstantesUtil.TIPO_PDF);
				procesarPeticionPdf(pHttpServletResponse, contenidoBytes);
				return;
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void procesarPeticionPdf(HttpServletResponse pHttpServletResponse, byte[] pContenidoBytes) throws ServletException {
		try {
			if (pContenidoBytes != null) {
				pHttpServletResponse.setHeader(ConstantesUtil.CONTENT_LENGTH, String.valueOf(pContenidoBytes.length));
				OutputStream out = pHttpServletResponse.getOutputStream();
				out.write(pContenidoBytes);
				out.flush();
				out.close();
				pContenidoBytes = null;
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
