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
 * The persistent class for the obj_aseg_fidelidad database table.
 * 
 */
@Entity
@Table(name = "obj_aseg_fidelidad")
@NamedQuery(name = "ObjAsegFidelidad.findAll", query = "SELECT o FROM ObjAsegFidelidad o")
public class ObjAsegFidelidad extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mod_obj_asegurado")
	private Integer idModObjAsegurado;

	@Column(name = "cargo_fidelidad")
	private String cargoFidelidad;

	@Column(name = "nombre_fidelidad")
	private String nombreFidelidad;

	@Column(name = "tipo_modalidad_fidelidad")
	private Integer tipoModalidadFidelidad;

	// bi-directional many-to-one association to RamoFidelidad
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_fidelidad")
	private RamoFidelidad ramoFidelidad;

	public ObjAsegFidelidad() {
	}

	public Integer getIdModObjAsegurado() {
		return this.idModObjAsegurado;
	}

	public void setIdModObjAsegurado(Integer idModObjAsegurado) {
		this.idModObjAsegurado = idModObjAsegurado;
	}

	public String getCargoFidelidad() {
		return this.cargoFidelidad;
	}

	public void setCargoFidelidad(String cargoFidelidad) {
		this.cargoFidelidad = cargoFidelidad;
	}

	public String getNombreFidelidad() {
		return this.nombreFidelidad;
	}

	public void setNombreFidelidad(String nombreFidelidad) {
		this.nombreFidelidad = nombreFidelidad;
	}

	public Integer getTipoModalidadFidelidad() {
		return this.tipoModalidadFidelidad;
	}

	public void setTipoModalidadFidelidad(Integer tipoModalidadFidelidad) {
		this.tipoModalidadFidelidad = tipoModalidadFidelidad;
	}

	public RamoFidelidad getRamoFidelidad() {
		return this.ramoFidelidad;
	}

	public void setRamoFidelidad(RamoFidelidad ramoFidelidad) {
		this.ramoFidelidad = ramoFidelidad;
	}

}