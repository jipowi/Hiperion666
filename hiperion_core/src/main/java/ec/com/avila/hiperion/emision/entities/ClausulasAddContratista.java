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
 * The persistent class for the clausulas_add_contratista database table.
 * 
 */
@Entity
@Table(name = "clausulas_add_contratista")
@NamedQuery(name = "ClausulasAddContratista.findAll", query = "SELECT c FROM ClausulasAddContratista c")
public class ClausulasAddContratista extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clausula_ad_contratista")
	private Integer idClausulaAdContratista;

	@Column(name = "clausula_add_contratista")
	private String clausulaAddContratista;

	@Column(name = "num_dias_contratista")
	private Integer numDiasContratista;

	// bi-directional many-to-one association to RamoRiesgoContratista
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contratista")
	private RamoRiesgoContratista ramoRiesgoContratista;

	public ClausulasAddContratista() {
	}

	public Integer getIdClausulaAdContratista() {
		return this.idClausulaAdContratista;
	}

	public void setIdClausulaAdContratista(Integer idClausulaAdContratista) {
		this.idClausulaAdContratista = idClausulaAdContratista;
	}

	public String getClausulaAddContratista() {
		return this.clausulaAddContratista;
	}

	public void setClausulaAddContratista(String clausulaAddContratista) {
		this.clausulaAddContratista = clausulaAddContratista;
	}

	public Integer getNumDiasContratista() {
		return this.numDiasContratista;
	}

	public void setNumDiasContratista(Integer numDiasContratista) {
		this.numDiasContratista = numDiasContratista;
	}

	public RamoRiesgoContratista getRamoRiesgoContratista() {
		return this.ramoRiesgoContratista;
	}

	public void setRamoRiesgoContratista(RamoRiesgoContratista ramoRiesgoContratista) {
		this.ramoRiesgoContratista = ramoRiesgoContratista;
	}

}