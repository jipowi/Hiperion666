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
 * The persistent class for the clausulas_add_robo database table.
 * 
 */
@Entity
@Table(name = "clausulas_add_robo")
@NamedQuery(name = "ClausulasAddRobo.findAll", query = "SELECT c FROM ClausulasAddRobo c")
public class ClausulasAddRobo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clausula_ad_robo")
	private Integer idClausulaAdRobo;

	@Column(name = "clausula_add_robo")
	private String clausulaAddRobo;

	@Column(name = "num_dias_robo")
	private Integer numDiasRobo;

	// bi-directional many-to-one association to RamoRoboAsalto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_robo")
	private RamoRoboAsalto ramoRoboAsalto;

	public ClausulasAddRobo() {
	}

	public Integer getIdClausulaAdRobo() {
		return this.idClausulaAdRobo;
	}

	public void setIdClausulaAdRobo(Integer idClausulaAdRobo) {
		this.idClausulaAdRobo = idClausulaAdRobo;
	}

	public String getClausulaAddRobo() {
		return this.clausulaAddRobo;
	}

	public void setClausulaAddRobo(String clausulaAddRobo) {
		this.clausulaAddRobo = clausulaAddRobo;
	}

	public Integer getNumDiasRobo() {
		return this.numDiasRobo;
	}

	public void setNumDiasRobo(Integer numDiasRobo) {
		this.numDiasRobo = numDiasRobo;
	}

	public RamoRoboAsalto getRamoRoboAsalto() {
		return this.ramoRoboAsalto;
	}

	public void setRamoRoboAsalto(RamoRoboAsalto ramoRoboAsalto) {
		this.ramoRoboAsalto = ramoRoboAsalto;
	}

}