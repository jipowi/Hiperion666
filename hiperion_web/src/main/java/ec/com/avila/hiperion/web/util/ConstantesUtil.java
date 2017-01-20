/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.util;

/**
 * <b> Permite definir constantes que se usan en todo el sistema. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,15/03/2015
 * @since JDK1.6
 */
public class ConstantesUtil {

	public final static Long AUTORIZACION_LINEA = 0L;
	public final static Long AUTORIZACION_BATCH = 1L;
	public static final String PARAMETROS_DESCARGADOR_IDENTIFICADOR = "PARAMETROS_DESCARGADOR_IDENTIFICADOR";
	public static final String CONTENT_TYPE_IDENTIFICADOR = "CONTENT_TYPE_IDENTIFICADOR";
	public static final String CONTENIDO_BYTES_IDENTIFICADOR = "CONTENIDO_BYTES_IDENTIFICADOR";
	public static final String NOMBRE_ARCHIVO_IDENTIFICADOR = "NOMBRE_ARCHIVO_IDENTIFICADOR";
	public final static String CONTENT_TYPE_PDF = "application/pdf";
	public final static String CONTENT_TYPE_XML = "text/xml";
	public final static String CONTENT_TYPE_HTML = "text/html";
	public final static String ENCABEZADO_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	public final static String ENCABEZADO_XML_STANDALONE = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
	public final static String ENCABEZADO_ISO_XML = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>";
	public static final String DIRECTORIO_PLANTILLA_XHTML2FO = "/plantillas/xhtml2fo.xsl";
	public final static String PATH_MARCA_AGUA_PDF = "/resources/img/fondo_imprimir.png";
	public final static String PATH_MARCA_AGUA_VACIO_PDF = "/resources/img/vacio.png";
	public static final String PARAM_ACEPTABLE = "aceptable";
	public static final String SLASH = "/";
	public final static String DESCARGADOR_SERVLET = "/descargador.jsf";
	public final static String CONTENT_DISPOSITION = "content-disposition";
	public final static String CONTENT_ATTACHMENT_FILE_NAME = "attachment; filename=";
	public final static String CONTENT_LENGTH = "content-length";
	public final static String TIPO_PDF = ".pdf";
}
