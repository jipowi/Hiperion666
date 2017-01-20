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
 * The persistent class for the cobert_add_riesgos database table.
 * 
 */
@Entity
@Table(name = "cobert_add_riesgos")
@NamedQuery(name = "CobertAddRiesgo.findAll", query = "SELECT c FROM CobertAddRiesgo c")
public class CobertAddRiesgo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_ad_riesgos")
	private Integer idCobertAdRiesgos;

	@Column(name = "cobertura_add_riesgos")
	private String coberturaAddRiesgos;

	// bi-directional many-to-one association to RamoRiesgosEsp
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_riesgo")
	private RamoRiesgosEsp ramoRiesgosEsp;

	public CobertAddRiesgo() {
	}

	public Integer getIdCobertAdRiesgos() {
		return this.idCobertAdRiesgos;
	}

	public void setIdCobertAdRiesgos(Integer idCobertAdRiesgos) {
		this.idCobertAdRiesgos = idCobertAdRiesgos;
	}

	public String getCoberturaAddRiesgos() {
		return this.coberturaAddRiesgos;
	}

	public void setCoberturaAddRiesgos(String coberturaAddRiesgos) {
		this.coberturaAddRiesgos = coberturaAddRiesgos;
	}

	public RamoRiesgosEsp getRamoRiesgosEsp() {
		return this.ramoRiesgosEsp;
	}

	public void setRamoRiesgosEsp(RamoRiesgosEsp ramoRiesgosEsp) {
		this.ramoRiesgosEsp = ramoRiesgosEsp;
	}

}