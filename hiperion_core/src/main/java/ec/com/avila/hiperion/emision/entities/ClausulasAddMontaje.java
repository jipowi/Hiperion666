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
 * The persistent class for the clausulas_add_montaje database table.
 * 
 */
@Entity
@Table(name = "clausulas_add_montaje")
@NamedQuery(name = "ClausulasAddMontaje.findAll", query = "SELECT c FROM ClausulasAddMontaje c")
public class ClausulasAddMontaje extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clausula_ad_montaje")
	private Integer idClausulaAdMontaje;

	@Column(name = "clausula_add_montaje")
	private String clausulaAddMontaje;

	@Column(name = "num_dias_montaje")
	private Integer numDiasMontaje;

	// bi-directional many-to-one association to RamoRiesgoMontaje
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_riesgo_montaje")
	private RamoRiesgoMontaje ramoRiesgoMontaje;

	public ClausulasAddMontaje() {
	}

	public Integer getIdClausulaAdMontaje() {
		return this.idClausulaAdMontaje;
	}

	public void setIdClausulaAdMontaje(Integer idClausulaAdMontaje) {
		this.idClausulaAdMontaje = idClausulaAdMontaje;
	}

	public String getClausulaAddMontaje() {
		return this.clausulaAddMontaje;
	}

	public void setClausulaAddMontaje(String clausulaAddMontaje) {
		this.clausulaAddMontaje = clausulaAddMontaje;
	}

	public Integer getNumDiasMontaje() {
		return this.numDiasMontaje;
	}

	public void setNumDiasMontaje(Integer numDiasMontaje) {
		this.numDiasMontaje = numDiasMontaje;
	}

	public RamoRiesgoMontaje getRamoRiesgoMontaje() {
		return this.ramoRiesgoMontaje;
	}

	public void setRamoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) {
		this.ramoRiesgoMontaje = ramoRiesgoMontaje;
	}

}