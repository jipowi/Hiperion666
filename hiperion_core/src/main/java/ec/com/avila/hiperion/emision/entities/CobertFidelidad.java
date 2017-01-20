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
 * The persistent class for the cobert_fidelidad database table.
 * 
 */
@Entity
@Table(name = "cobert_fidelidad")
@NamedQuery(name = "CobertFidelidad.findAll", query = "SELECT c FROM CobertFidelidad c")
public class CobertFidelidad extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_fidelidad")
	private Integer idCobertFidelidad;

	@Column(name = "cobertura_fidelidad")
	private String coberturaFidelidad;

	// bi-directional many-to-one association to RamoFidelidad
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_fidelidad")
	private RamoFidelidad ramoFidelidad;

	public CobertFidelidad() {
	}

	public Integer getIdCobertFidelidad() {
		return this.idCobertFidelidad;
	}

	public void setIdCobertFidelidad(Integer idCobertFidelidad) {
		this.idCobertFidelidad = idCobertFidelidad;
	}

	public String getCoberturaFidelidad() {
		return this.coberturaFidelidad;
	}

	public void setCoberturaFidelidad(String coberturaFidelidad) {
		this.coberturaFidelidad = coberturaFidelidad;
	}

	public RamoFidelidad getRamoFidelidad() {
		return this.ramoFidelidad;
	}

	public void setRamoFidelidad(RamoFidelidad ramoFidelidad) {
		this.ramoFidelidad = ramoFidelidad;
	}

}