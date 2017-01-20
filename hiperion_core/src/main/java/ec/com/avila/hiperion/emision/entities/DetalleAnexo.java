package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the detalle_anexo database table.
 * 
 */
@Entity
@Table(name = "detalle_anexo")
@NamedQuery(name = "DetalleAnexo.findAll", query = "SELECT d FROM DetalleAnexo d")
public class DetalleAnexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_anexo")
	private Long idDetalleAnexo;

	@Column(name = "nombre_detalle_anexo")
	private String nombreDetalleAnexo;

	// bi-directional many-to-one association to Anexo
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_anexo")
	private Anexo anexo;

	// bi-directional many-to-one association to Ramo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ramo")
	private Ramo ramo;

	// bi-directional many-to-one association to Titulo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_titulo")
	private Titulo titulo;

	public DetalleAnexo() {
	}

	public Long getIdDetalleAnexo() {
		return this.idDetalleAnexo;
	}

	public void setIdDetalleAnexo(Long idDetalleAnexo) {
		this.idDetalleAnexo = idDetalleAnexo;
	}

	public String getNombreDetalleAnexo() {
		return this.nombreDetalleAnexo;
	}

	public void setNombreDetalleAnexo(String nombreDetalleAnexo) {
		this.nombreDetalleAnexo = nombreDetalleAnexo;
	}

	public Anexo getAnexo() {
		return this.anexo;
	}

	public void setAnexo(Anexo anexo) {
		this.anexo = anexo;
	}

	public Ramo getRamo() {
		return this.ramo;
	}

	public void setRamo(Ramo ramo) {
		this.ramo = ramo;
	}

	public Titulo getTitulo() {
		return this.titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

}