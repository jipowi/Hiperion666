package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ramo database table.
 * 
 */
@Entity
@NamedQuery(name="Ramo.findAll", query="SELECT r FROM Ramo r")
public class Ramo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ramo")
	private Long idRamo;

	@Column(name="codigo_ramo")
	private String codigoRamo;

	@Column(name="nombre_ramo")
	private String nombreRamo;

	//bi-directional many-to-one association to RamoAseguradora
	@OneToMany(mappedBy="ramo")
	private List<RamoAseguradora> ramoAseguradoras;

	//bi-directional many-to-one association to DetalleAnexo
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ramo")
	private List<DetalleAnexo> detalleAnexos;

	public Ramo() {
	}

	public Long getIdRamo() {
		return this.idRamo;
	}

	public void setIdRamo(Long idRamo) {
		this.idRamo = idRamo;
	}

	public String getCodigoRamo() {
		return this.codigoRamo;
	}

	public void setCodigoRamo(String codigoRamo) {
		this.codigoRamo = codigoRamo;
	}

	public String getNombreRamo() {
		return this.nombreRamo;
	}

	public void setNombreRamo(String nombreRamo) {
		this.nombreRamo = nombreRamo;
	}

	public List<RamoAseguradora> getRamoAseguradoras() {
		return this.ramoAseguradoras;
	}

	public void setRamoAseguradoras(List<RamoAseguradora> ramoAseguradoras) {
		this.ramoAseguradoras = ramoAseguradoras;
	}

	public RamoAseguradora addRamoAseguradora(RamoAseguradora ramoAseguradora) {
		getRamoAseguradoras().add(ramoAseguradora);
		ramoAseguradora.setRamo(this);

		return ramoAseguradora;
	}

	public RamoAseguradora removeRamoAseguradora(RamoAseguradora ramoAseguradora) {
		getRamoAseguradoras().remove(ramoAseguradora);
		ramoAseguradora.setRamo(null);

		return ramoAseguradora;
	}

	public List<DetalleAnexo> getDetalleAnexos() {
		return this.detalleAnexos;
	}

	public void setDetalleAnexos(List<DetalleAnexo> detalleAnexos) {
		this.detalleAnexos = detalleAnexos;
	}

	public DetalleAnexo addDetalleAnexo(DetalleAnexo detalleAnexo) {
		getDetalleAnexos().add(detalleAnexo);
		detalleAnexo.setRamo(this);

		return detalleAnexo;
	}

	public DetalleAnexo removeDetalleAnexo(DetalleAnexo detalleAnexo) {
		getDetalleAnexos().remove(detalleAnexo);
		detalleAnexo.setRamo(null);

		return detalleAnexo;
	}

}