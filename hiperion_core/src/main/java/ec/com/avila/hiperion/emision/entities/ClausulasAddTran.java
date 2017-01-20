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
 * The persistent class for the clausulas_add_trans database table.
 * 
 */
@Entity
@Table(name = "clausulas_add_trans")
@NamedQuery(name = "ClausulasAddTran.findAll", query = "SELECT c FROM ClausulasAddTran c")
public class ClausulasAddTran extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clausula_ad_transporte")
	private Integer idClausulaAdTransporte;

	@Column(name = "clausula_trans")
	private String clausulaTrans;

	@Column(name = "num_dias_trans")
	private Integer numDiasTrans;

	// bi-directional many-to-one association to RamoTransporte
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_transporte")
	private RamoTransporte ramoTransporte;

	public ClausulasAddTran() {
	}

	public Integer getIdClausulaAdTransporte() {
		return this.idClausulaAdTransporte;
	}

	public void setIdClausulaAdTransporte(Integer idClausulaAdTransporte) {
		this.idClausulaAdTransporte = idClausulaAdTransporte;
	}

	public String getClausulaTrans() {
		return this.clausulaTrans;
	}

	public void setClausulaTrans(String clausulaTrans) {
		this.clausulaTrans = clausulaTrans;
	}

	public Integer getNumDiasTrans() {
		return this.numDiasTrans;
	}

	public void setNumDiasTrans(Integer numDiasTrans) {
		this.numDiasTrans = numDiasTrans;
	}

	public RamoTransporte getRamoTransporte() {
		return this.ramoTransporte;
	}

	public void setRamoTransporte(RamoTransporte ramoTransporte) {
		this.ramoTransporte = ramoTransporte;
	}

}