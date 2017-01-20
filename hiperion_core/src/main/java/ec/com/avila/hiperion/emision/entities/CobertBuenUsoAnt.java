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
 * The persistent class for the cobert_buen_uso_ant database table.
 * 
 */
@Entity
@Table(name = "cobert_buen_uso_ant")
@NamedQuery(name = "CobertBuenUsoAnt.findAll", query = "SELECT c FROM CobertBuenUsoAnt c")
public class CobertBuenUsoAnt extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_buen_uso_ant")
	private Integer idCobertBuenUsoAnt;

	@Column(name = "cobertura_anticipo")
	private String coberturaAnticipo;

	// bi-directional many-to-one association to RamoBuenUsoAnt
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ind_buen_uso_ant")
	private RamoBuenUsoAnt ramoBuenUsoAnt;

	public CobertBuenUsoAnt() {
	}

	public Integer getIdCobertBuenUsoAnt() {
		return this.idCobertBuenUsoAnt;
	}

	public void setIdCobertBuenUsoAnt(Integer idCobertBuenUsoAnt) {
		this.idCobertBuenUsoAnt = idCobertBuenUsoAnt;
	}

	public String getCoberturaAnticipo() {
		return this.coberturaAnticipo;
	}

	public void setCoberturaAnticipo(String coberturaAnticipo) {
		this.coberturaAnticipo = coberturaAnticipo;
	}


	public RamoBuenUsoAnt getRamoBuenUsoAnt() {
		return this.ramoBuenUsoAnt;
	}

	public void setRamoBuenUsoAnt(RamoBuenUsoAnt ramoBuenUsoAnt) {
		this.ramoBuenUsoAnt = ramoBuenUsoAnt;
	}

}