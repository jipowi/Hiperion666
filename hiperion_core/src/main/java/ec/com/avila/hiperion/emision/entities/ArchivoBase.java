package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the archivo_base database table.
 * 
 */
@Entity
@Table(name = "archivo_base")
@NamedQuery(name = "ArchivoBase.findAll", query = "SELECT a FROM ArchivoBase a")
public class ArchivoBase extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_archivo")
	private Integer idArchivo;

	@Column(name = "documento_byte")
	private byte[] documentoByte;

	@Column(name = "mime_type")
	private String mimeType;

	@Column(name = "nombre_archivo")
	private String nombreArchivo;

	@Column(name = "tipo_archivo")
	private String tipoArchivo;

	@Column(name = "tipo_documento")
	private String tipoDocumento;

	// bi-directional many-to-one association to RamoAgropecuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_agropecuario")
	private RamoAgropecuario ramoAgropecuario;

	public ArchivoBase() {
	}

	public Integer getIdArchivo() {
		return this.idArchivo;
	}

	public void setIdArchivo(Integer idArchivo) {
		this.idArchivo = idArchivo;
	}

	public byte[] getDocumentoByte() {
		return this.documentoByte;
	}

	public void setDocumentoByte(byte[] documentoByte) {
		this.documentoByte = documentoByte;
	}

	public String getMimeType() {
		return this.mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getTipoArchivo() {
		return this.tipoArchivo;
	}

	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public RamoAgropecuario getRamoAgropecuario() {
		return this.ramoAgropecuario;
	}

	public void setRamoAgropecuario(RamoAgropecuario ramoAgropecuario) {
		this.ramoAgropecuario = ramoAgropecuario;
	}

}