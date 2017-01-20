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
 * The persistent class for the cond_part_riesgos database table.
 * 
 */
@Entity
@Table(name = "cond_part_riesgos")
@NamedQuery(name = "CondPartRiesgo.findAll", query = "SELECT c FROM CondPartRiesgo c")
public class CondPartRiesgo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cond_part_riesgos")
	private Integer idCondPartRiesgos;

	@Column(name = "condicion_part_riesgos")
	private String condicionPartRiesgos;

	// bi-directional many-to-one association to RamoRiesgosEsp
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_riesgo")
	private RamoRiesgosEsp ramoRiesgosEsp;

	public CondPartRiesgo() {
	}

	public Integer getIdCondPartRiesgos() {
		return this.idCondPartRiesgos;
	}

	public void setIdCondPartRiesgos(Integer idCondPartRiesgos) {
		this.idCondPartRiesgos = idCondPartRiesgos;
	}

	public String getCondicionPartRiesgos() {
		return this.condicionPartRiesgos;
	}

	public void setCondicionPartRiesgos(String condicionPartRiesgos) {
		this.condicionPartRiesgos = condicionPartRiesgos;
	}

	public RamoRiesgosEsp getRamoRiesgosEsp() {
		return this.ramoRiesgosEsp;
	}

	public void setRamoRiesgosEsp(RamoRiesgosEsp ramoRiesgosEsp) {
		this.ramoRiesgosEsp = ramoRiesgosEsp;
	}

}