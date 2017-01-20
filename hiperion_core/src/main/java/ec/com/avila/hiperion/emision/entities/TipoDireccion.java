package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_direccion database table.
 * 
 */
@Entity
@Table(name="tipo_direccion")
@NamedQuery(name="TipoDireccion.findAll", query="SELECT t FROM TipoDireccion t")
public class TipoDireccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_direccion")
	private Integer idTipoDireccion;

	@Column(name="codigo_tipo_direccion")
	private String codigoTipoDireccion;

	@Column(name="desc_tipo_direccion")
	private String descTipoDireccion;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="tipoDireccion")
	private List<Direccion> direccions;

	public TipoDireccion() {
	}

	public Integer getIdTipoDireccion() {
		return this.idTipoDireccion;
	}

	public void setIdTipoDireccion(Integer idTipoDireccion) {
		this.idTipoDireccion = idTipoDireccion;
	}

	public String getCodigoTipoDireccion() {
		return this.codigoTipoDireccion;
	}

	public void setCodigoTipoDireccion(String codigoTipoDireccion) {
		this.codigoTipoDireccion = codigoTipoDireccion;
	}

	public String getDescTipoDireccion() {
		return this.descTipoDireccion;
	}

	public void setDescTipoDireccion(String descTipoDireccion) {
		this.descTipoDireccion = descTipoDireccion;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setTipoDireccion(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setTipoDireccion(null);

		return direccion;
	}

}