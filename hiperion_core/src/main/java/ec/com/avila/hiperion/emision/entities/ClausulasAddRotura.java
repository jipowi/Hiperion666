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
 * The persistent class for the clausulas_add_rotura database table.
 * 
 */
@Entity
@Table(name = "clausulas_add_rotura")
@NamedQuery(name = "ClausulasAddRotura.findAll", query = "SELECT c FROM ClausulasAddRotura c")
public class ClausulasAddRotura extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clausula_ad_rotura")
	private Integer idClausulaAdRotura;

	@Column(name = "clausula_add_rotura")
	private String clausulaAddRotura;

	@Column(name = "num_dias_rotura")
	private Integer numDiasRotura;

	// bi-directional many-to-one association to RamoRoturaMaquinaria
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rotura")
	private RamoRoturaMaquinaria ramoRoturaMaquinaria;

	public ClausulasAddRotura() {
	}

	public Integer getIdClausulaAdRotura() {
		return this.idClausulaAdRotura;
	}

	public void setIdClausulaAdRotura(Integer idClausulaAdRotura) {
		this.idClausulaAdRotura = idClausulaAdRotura;
	}

	public String getClausulaAddRotura() {
		return this.clausulaAddRotura;
	}

	public void setClausulaAddRotura(String clausulaAddRotura) {
		this.clausulaAddRotura = clausulaAddRotura;
	}

	public Integer getNumDiasRotura() {
		return this.numDiasRotura;
	}

	public void setNumDiasRotura(Integer numDiasRotura) {
		this.numDiasRotura = numDiasRotura;
	}

	public RamoRoturaMaquinaria getRamoRoturaMaquinaria() {
		return this.ramoRoturaMaquinaria;
	}

	public void setRamoRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) {
		this.ramoRoturaMaquinaria = ramoRoturaMaquinaria;
	}

}