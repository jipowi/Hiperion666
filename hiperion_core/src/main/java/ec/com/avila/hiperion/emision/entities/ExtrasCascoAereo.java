package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.math.BigDecimal;

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
 * The persistent class for the extras_casco_aereo database table.
 * 
 */
@Entity
@Table(name = "extras_casco_aereo")
@NamedQuery(name = "ExtrasCascoAereo.findAll", query = "SELECT e FROM ExtrasCascoAereo e")
public class ExtrasCascoAereo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_extra_casco_aereo")
	private Integer idExtraCascoAereo;

	@Column(name = "valor_extra_aereo")
	private BigDecimal valorExtraAereo;

	@Column(name = "extra_casco_aereo")
	private String extra;

	// bi-directional many-to-one association to RamoCascoAereo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_casco_aereo")
	private RamoCascoAereo ramoCascoAereo;

	public ExtrasCascoAereo() {
	}

	public Integer getIdExtraCascoAereo() {
		return this.idExtraCascoAereo;
	}

	public void setIdExtraCascoAereo(Integer idExtraCascoAereo) {
		this.idExtraCascoAereo = idExtraCascoAereo;
	}

	public BigDecimal getValorExtraAereo() {
		return this.valorExtraAereo;
	}

	public void setValorExtraAereo(BigDecimal valorExtraAereo) {
		this.valorExtraAereo = valorExtraAereo;
	}

	public RamoCascoAereo getRamoCascoAereo() {
		return this.ramoCascoAereo;
	}

	public void setRamoCascoAereo(RamoCascoAereo ramoCascoAereo) {
		this.ramoCascoAereo = ramoCascoAereo;
	}

	/**
	 * @return the extra
	 */
	public String getExtra() {
		return extra;
	}

	/**
	 * @param extra
	 *            the extra to set
	 */
	public void setExtra(String extra) {
		this.extra = extra;
	}

}