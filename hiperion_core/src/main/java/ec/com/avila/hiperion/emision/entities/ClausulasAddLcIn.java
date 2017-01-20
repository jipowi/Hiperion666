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
 * The persistent class for the clausulas_add_lc_in database table.
 * 
 */
@Entity
@Table(name = "clausulas_add_lc_in")
@NamedQuery(name = "ClausulasAddLcIn.findAll", query = "SELECT c FROM ClausulasAddLcIn c")
public class ClausulasAddLcIn extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clausula_ad_lucro")
	private Integer idClausulaAdLucro;

	@Column(name = "clausula_add_lc_incendio")
	private String clausulaAddLcIncendio;

	@Column(name = "num_dias_lc_incendio")
	private Integer numDiasLcIncendio;

	// bi-directional many-to-one association to RamoLcIncendio
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lucro")
	private RamoLcIncendio ramoLcIncendio;

	public ClausulasAddLcIn() {
	}

	public Integer getIdClausulaAdLucro() {
		return this.idClausulaAdLucro;
	}

	public void setIdClausulaAdLucro(Integer idClausulaAdLucro) {
		this.idClausulaAdLucro = idClausulaAdLucro;
	}

	public String getClausulaAddLcIncendio() {
		return this.clausulaAddLcIncendio;
	}

	public void setClausulaAddLcIncendio(String clausulaAddLcIncendio) {
		this.clausulaAddLcIncendio = clausulaAddLcIncendio;
	}

	public Integer getNumDiasLcIncendio() {
		return this.numDiasLcIncendio;
	}

	public void setNumDiasLcIncendio(Integer numDiasLcIncendio) {
		this.numDiasLcIncendio = numDiasLcIncendio;
	}

	public RamoLcIncendio getRamoLcIncendio() {
		return this.ramoLcIncendio;
	}

	public void setRamoLcIncendio(RamoLcIncendio ramoLcIncendio) {
		this.ramoLcIncendio = ramoLcIncendio;
	}

}