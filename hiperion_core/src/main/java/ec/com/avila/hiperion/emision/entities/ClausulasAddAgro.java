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
 * The persistent class for the clausulas_add_agro database table.
 * 
 */
@Entity
@Table(name = "clausulas_add_agro")
@NamedQuery(name = "ClausulasAddAgro.findAll", query = "SELECT c FROM ClausulasAddAgro c")
public class ClausulasAddAgro extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clausula_ad")
	private Integer idClausulaAd;

	@Column(name = "clausula_add_agro")
	private String clausulaAddAgro;

	@Column(name = "num_dias_agro")
	private Integer numDiasAgro;


	// bi-directional many-to-one association to RamoAgropecuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_agropecuario")
	private RamoAgropecuario ramoAgropecuario;

	public ClausulasAddAgro() {
	}

	public Integer getIdClausulaAd() {
		return this.idClausulaAd;
	}

	public void setIdClausulaAd(Integer idClausulaAd) {
		this.idClausulaAd = idClausulaAd;
	}

	public String getClausulaAddAgro() {
		return this.clausulaAddAgro;
	}

	public void setClausulaAddAgro(String clausulaAddAgro) {
		this.clausulaAddAgro = clausulaAddAgro;
	}

	public Integer getNumDiasAgro() {
		return this.numDiasAgro;
	}

	public void setNumDiasAgro(Integer numDiasAgro) {
		this.numDiasAgro = numDiasAgro;
	}

	public RamoAgropecuario getRamoAgropecuario() {
		return this.ramoAgropecuario;
	}

	public void setRamoAgropecuario(RamoAgropecuario ramoAgropecuario) {
		this.ramoAgropecuario = ramoAgropecuario;
	}

	

}