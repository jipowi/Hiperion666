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
 * The persistent class for the cobert_contratista database table.
 * 
 */
@Entity
@Table(name = "cobert_contratista")
@NamedQuery(name = "CobertContratista.findAll", query = "SELECT c FROM CobertContratista c")
public class CobertContratista extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_contratista")
	private Integer idCobertContratista;

	@Column(name = "cobertura_contratista")
	private String coberturaContratista;

	// bi-directional many-to-one association to RamoRiesgoContratista
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contratista")
	private RamoRiesgoContratista ramoRiesgoContratista;

	public CobertContratista() {
	}

	public Integer getIdCobertContratista() {
		return this.idCobertContratista;
	}

	public void setIdCobertContratista(Integer idCobertContratista) {
		this.idCobertContratista = idCobertContratista;
	}

	public String getCoberturaContratista() {
		return this.coberturaContratista;
	}

	public void setCoberturaContratista(String coberturaContratista) {
		this.coberturaContratista = coberturaContratista;
	}

	public RamoRiesgoContratista getRamoRiesgoContratista() {
		return this.ramoRiesgoContratista;
	}

	public void setRamoRiesgoContratista(RamoRiesgoContratista ramoRiesgoContratista) {
		this.ramoRiesgoContratista = ramoRiesgoContratista;
	}

}