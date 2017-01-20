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
 * The persistent class for the cla_add_lc_rot database table.
 * 
 */
@Entity
@Table(name = "cla_add_lc_rot")
@NamedQuery(name = "ClaAddLcRot.findAll", query = "SELECT c FROM ClaAddLcRot c")
public class ClaAddLcRot extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clausula_ad_cesante")
	private Integer idClausulaAdCesante;

	@Column(name = "clausula_add_lc_rotura")
	private String clausulaAddLcRotura;

	@Column(name = "num_dias_cla_lc_rotura")
	private Integer numDiasClaLcRotura;

	// bi-directional many-to-one association to RamoLcRotMaq
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cesante")
	private RamoLcRotMaq ramoLcRotMaq;

	public ClaAddLcRot() {
	}

	public Integer getIdClausulaAdCesante() {
		return this.idClausulaAdCesante;
	}

	public void setIdClausulaAdCesante(Integer idClausulaAdCesante) {
		this.idClausulaAdCesante = idClausulaAdCesante;
	}

	public String getClausulaAddLcRotura() {
		return this.clausulaAddLcRotura;
	}

	public void setClausulaAddLcRotura(String clausulaAddLcRotura) {
		this.clausulaAddLcRotura = clausulaAddLcRotura;
	}

	public Integer getNumDiasClaLcRotura() {
		return this.numDiasClaLcRotura;
	}

	public void setNumDiasClaLcRotura(Integer numDiasClaLcRotura) {
		this.numDiasClaLcRotura = numDiasClaLcRotura;
	}

	public RamoLcRotMaq getRamoLcRotMaq() {
		return this.ramoLcRotMaq;
	}

	public void setRamoLcRotMaq(RamoLcRotMaq ramoLcRotMaq) {
		this.ramoLcRotMaq = ramoLcRotMaq;
	}

}