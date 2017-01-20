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
 * The persistent class for the cobert_riesgos database table.
 * 
 */
@Entity
@Table(name = "cobert_riesgos")
@NamedQuery(name = "CobertRiesgo.findAll", query = "SELECT c FROM CobertRiesgo c")
public class CobertRiesgo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_riesgos")
	private Integer idCobertRiesgos;

	@Column(name = "cobertura_riesgos")
	private String coberturaRiesgos;

	// bi-directional many-to-one association to RamoRiesgosEsp
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_riesgo")
	private RamoRiesgosEsp ramoRiesgosEsp;

	public CobertRiesgo() {
	}

	public Integer getIdCobertRiesgos() {
		return this.idCobertRiesgos;
	}

	public void setIdCobertRiesgos(Integer idCobertRiesgos) {
		this.idCobertRiesgos = idCobertRiesgos;
	}

	public String getCoberturaRiesgos() {
		return this.coberturaRiesgos;
	}

	public void setCoberturaRiesgos(String coberturaRiesgos) {
		this.coberturaRiesgos = coberturaRiesgos;
	}

	public RamoRiesgosEsp getRamoRiesgosEsp() {
		return this.ramoRiesgosEsp;
	}

	public void setRamoRiesgosEsp(RamoRiesgosEsp ramoRiesgosEsp) {
		this.ramoRiesgosEsp = ramoRiesgosEsp;
	}

}