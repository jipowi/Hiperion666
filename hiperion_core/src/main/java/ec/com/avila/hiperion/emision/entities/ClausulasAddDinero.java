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
 * The persistent class for the clausulas_add_dinero database table.
 * 
 */
@Entity
@Table(name = "clausulas_add_dinero")
@NamedQuery(name = "ClausulasAddDinero.findAll", query = "SELECT c FROM ClausulasAddDinero c")
public class ClausulasAddDinero extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clausula_ad_dinero")
	private Integer idClausulaAdDinero;

	@Column(name = "clausula_add_dinero")
	private String clausulaAddDinero;

	@Column(name = "num_dias_dinero")
	private Integer numDiasDinero;

	// bi-directional many-to-one association to RamoDineroValore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dinero")
	private RamoDineroValore ramoDineroValore;

	public ClausulasAddDinero() {
	}

	public Integer getIdClausulaAdDinero() {
		return this.idClausulaAdDinero;
	}

	public void setIdClausulaAdDinero(Integer idClausulaAdDinero) {
		this.idClausulaAdDinero = idClausulaAdDinero;
	}

	public String getClausulaAddDinero() {
		return this.clausulaAddDinero;
	}

	public void setClausulaAddDinero(String clausulaAddDinero) {
		this.clausulaAddDinero = clausulaAddDinero;
	}

	public Integer getNumDiasDinero() {
		return this.numDiasDinero;
	}

	public void setNumDiasDinero(Integer numDiasDinero) {
		this.numDiasDinero = numDiasDinero;
	}

	public RamoDineroValore getRamoDineroValore() {
		return this.ramoDineroValore;
	}

	public void setRamoDineroValore(RamoDineroValore ramoDineroValore) {
		this.ramoDineroValore = ramoDineroValore;
	}

}