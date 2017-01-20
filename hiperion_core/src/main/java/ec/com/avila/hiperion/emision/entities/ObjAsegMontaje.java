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
 * The persistent class for the obj_aseg_montaje database table.
 * 
 */
@Entity
@Table(name = "obj_aseg_montaje")
@NamedQuery(name = "ObjAsegMontaje.findAll", query = "SELECT o FROM ObjAsegMontaje o")
public class ObjAsegMontaje extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_obj_aseg_montaje")
	private Integer idObjAsegMontaje;

	@Column(name = "detalle_obj_montaje")
	private String detalleObjMontaje;

	// bi-directional many-to-one association to RamoRiesgoMontaje
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_riesgo_montaje")
	private RamoRiesgoMontaje ramoRiesgoMontaje;

	public ObjAsegMontaje() {
	}

	public Integer getIdObjAsegMontaje() {
		return this.idObjAsegMontaje;
	}

	public void setIdObjAsegMontaje(Integer idObjAsegMontaje) {
		this.idObjAsegMontaje = idObjAsegMontaje;
	}

	public String getDetalleObjMontaje() {
		return this.detalleObjMontaje;
	}

	public void setDetalleObjMontaje(String detalleObjMontaje) {
		this.detalleObjMontaje = detalleObjMontaje;
	}

	public RamoRiesgoMontaje getRamoRiesgoMontaje() {
		return this.ramoRiesgoMontaje;
	}

	public void setRamoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) {
		this.ramoRiesgoMontaje = ramoRiesgoMontaje;
	}

}