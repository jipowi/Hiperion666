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
 * The persistent class for the clausulas_add_casco database table.
 * 
 */
@Entity
@Table(name = "clausulas_add_casco")
@NamedQuery(name = "ClausulasAddCasco.findAll", query = "SELECT c FROM ClausulasAddCasco c")
public class ClausulasAddCasco extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clausula_ad_casco")
	private Integer idClausulaAdCasco;

	@Column(name = "clausula_add_maritimo")
	private String clausulaAddMaritimo;

	@Column(name = "num_dias_maritimo")
	private Integer numDiasMaritimo;

	// bi-directional many-to-one association to RamoCascoMaritimo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_casco")
	private RamoCascoMaritimo ramoCascoMaritimo;

	public ClausulasAddCasco() {
	}

	public Integer getIdClausulaAdCasco() {
		return this.idClausulaAdCasco;
	}

	public void setIdClausulaAdCasco(Integer idClausulaAdCasco) {
		this.idClausulaAdCasco = idClausulaAdCasco;
	}

	public String getClausulaAddMaritimo() {
		return this.clausulaAddMaritimo;
	}

	public void setClausulaAddMaritimo(String clausulaAddMaritimo) {
		this.clausulaAddMaritimo = clausulaAddMaritimo;
	}

	public Integer getNumDiasMaritimo() {
		return this.numDiasMaritimo;
	}

	public void setNumDiasMaritimo(Integer numDiasMaritimo) {
		this.numDiasMaritimo = numDiasMaritimo;
	}

	public RamoCascoMaritimo getRamoCascoMaritimo() {
		return this.ramoCascoMaritimo;
	}

	public void setRamoCascoMaritimo(RamoCascoMaritimo ramoCascoMaritimo) {
		this.ramoCascoMaritimo = ramoCascoMaritimo;
	}

}