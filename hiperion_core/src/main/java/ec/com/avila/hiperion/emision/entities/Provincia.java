package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the provincia database table.
 * 
 */
@Entity
@NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_provincia")
	private Long idProvincia;

	private String codigo;

	@Column(name = "nombre_provincia")
	private String nombreProvincia;

	// bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy = "provincia")
	private List<Direccion> direccions;

	public Provincia() {
	}

	public Long getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreProvincia() {
		return this.nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setProvincia(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setProvincia(null);

		return direccion;
	}

}