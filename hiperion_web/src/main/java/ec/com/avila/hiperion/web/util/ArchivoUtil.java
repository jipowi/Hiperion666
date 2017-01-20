/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.util;

import java.io.IOException;
import java.io.Serializable;

import org.primefaces.model.UploadedFile;

import ec.com.avila.hiperion.emision.entities.ArchivoBase;

/**
 * <b> contiene metodos para el manejo de archivos </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Jul 18, 2014
 * @since JDK1.6
 */
public class ArchivoUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static ArchivoUtil INSTANCIA = new ArchivoUtil();

	// Devuelve la unica instancia de la clase
	public static ArchivoUtil getInstancia() {
		return INSTANCIA;
	}

	/**
	 * 
	 * <b> Permite cargar el archivo en memoria antes de ser guardado en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 19, 2014]
	 * </p>
	 * 
	 * @param archivoBase
	 * @param file
	 * @throws IOException
	 */
	public void agregarArchivo(ArchivoBase archivoBase, UploadedFile file) throws IOException {
		archivoBase.setMimeType(file.getContentType());
		archivoBase.setTipoArchivo(file.getFileName().substring(file.getFileName().lastIndexOf(".") + 1));
		archivoBase.setNombreArchivo(file.getFileName());
		archivoBase.setDocumentoByte(file.getContents());
		//archivoBase.setDocumentoStream(file.getInputstream());
	}

}
