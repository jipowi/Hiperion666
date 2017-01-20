package ec.com.avila.hiperion.mail;

import java.io.Serializable;

/**
 * 
 * <b> Entidad que reune los atributos para envio de mail </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Oct 9, 2014
 * @since JDK1.6
 */
public class ArchivoAdjunto implements Serializable {
	/**
	 * Serial Verion UID
	 */
	private static final long serialVersionUID = -6921007705681705737L;

	/**
	 * Especifica la ruta y el nombre del archivo.
	 */
	private String nombreCompletoArcAdj;

	/**
	 * Especifica el archivo que se envia por mail.
	 */
	private byte[] archivo;

	/**
	 * Especifica el tipo de archivo.
	 */
	private String tipoArchivo;

	/**
	 * Especifica el nombre del archivo.
	 */
	private String nombreArchivo;
	/**
	 * Especifica el nombre del archivo.
	 */
	private Double tamanioArchivo;

	/**
	 * @return el archivo
	 */
	public byte[] getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo
	 *            el archivo a establecer
	 */
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	/**
	 * @return el nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @param nombreArchivo
	 *            el nombreArchivo a establecer
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * @return el nombreCompletoArcAdj
	 */
	public String getNombreCompletoArcAdj() {
		return nombreCompletoArcAdj;
	}

	/**
	 * @param nombreCompletoArcAdj
	 *            el nombreCompletoArcAdj a establecer
	 */
	public void setNombreCompletoArcAdj(String nombreCompletoArcAdj) {
		this.nombreCompletoArcAdj = nombreCompletoArcAdj;
	}

	/**
	 * @return el tipoArchivo
	 */
	public String getTipoArchivo() {
		return tipoArchivo;
	}

	/**
	 * @param tipoArchivo
	 *            el tipoArchivo a establecer
	 */
	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	/**
	 * @return el tamanioArchivo
	 */
	public Double getTamanioArchivo() {
		return tamanioArchivo;
	}

	/**
	 * @param tamanioArchivo
	 *            el tamanioArchivo a establecer
	 */
	public void setTamanioArchivo(Double tamanioArchivo) {
		this.tamanioArchivo = tamanioArchivo;
	}

}
