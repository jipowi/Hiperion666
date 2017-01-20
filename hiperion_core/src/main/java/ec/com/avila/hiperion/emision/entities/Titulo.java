package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the titulo database table.
 * 
 */
@Entity
@NamedQuery(name="Titulo.findAll", query="SELECT t FROM Titulo t")
public class Titulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_titulo")
	private Long idTitulo;

	@Column(name="tipo_titulo")
	private String tipoTitulo;

	//bi-directional many-to-one association to DetalleAnexo
	@OneToMany(mappedBy="titulo")
	private List<DetalleAnexo> detalleAnexos;

	public Titulo() {
	}

	public Long getIdTitulo() {
		return this.idTitulo;
	}

	public void setIdTitulo(Long idTitulo) {
		this.idTitulo = idTitulo;
	}

	public String getTipoTitulo() {
		return this.tipoTitulo;
	}

	public void setTipoTitulo(String tipoTitulo) {
		this.tipoTitulo = tipoTitulo;
	}

	public List<DetalleAnexo> getDetalleAnexos() {
		return this.detalleAnexos;
	}

	public void setDetalleAnexos(List<DetalleAnexo> detalleAnexos) {
		this.detalleAnexos = detalleAnexos;
	}

	public DetalleAnexo addDetalleAnexo(DetalleAnexo detalleAnexo) {
		getDetalleAnexos().add(detalleAnexo);
		detalleAnexo.setTitulo(this);

		return detalleAnexo;
	}

	public DetalleAnexo removeDetalleAnexo(DetalleAnexo detalleAnexo) {
		getDetalleAnexos().remove(detalleAnexo);
		detalleAnexo.setTitulo(null);

		return detalleAnexo;
	}

}