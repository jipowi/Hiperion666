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
 * The persistent class for the cobert_add_casco_aereo database table.
 * 
 */
@Entity
@Table(name = "cobert_add_casco_aereo")
@NamedQuery(name = "CobertAddCascoAereo.findAll", query = "SELECT c FROM CobertAddCascoAereo c")
public class CobertAddCascoAereo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_ad_casco_aereo")
	private Integer idCobertAdCascoAereo;

	@Column(name = "cobertura_add_casco_ereo")
	private String coberturaAddCascoAereo;

	// bi-directional many-to-one association to RamoCascoAereo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_casco_aereo")
	private RamoCascoAereo ramoCascoAereo;

	public CobertAddCascoAereo() {
	}

	public Integer getIdCobertAdCascoAereo() {
		return this.idCobertAdCascoAereo;
	}

	public void setIdCobertAdCascoAereo(Integer idCobertAdCascoAereo) {
		this.idCobertAdCascoAereo = idCobertAdCascoAereo;
	}

	/**
	 * @return the coberturaAddCascoAereo
	 */
	public String getCoberturaAddCascoAereo() {
		return coberturaAddCascoAereo;
	}

	/**
	 * @param coberturaAddCascoAereo
	 *            the coberturaAddCascoAereo to set
	 */
	public void setCoberturaAddCascoAereo(String coberturaAddCascoAereo) {
		this.coberturaAddCascoAereo = coberturaAddCascoAereo;
	}

	public RamoCascoAereo getRamoCascoAereo() {
		return this.ramoCascoAereo;
	}

	public void setRamoCascoAereo(RamoCascoAereo ramoCascoAereo) {
		this.ramoCascoAereo = ramoCascoAereo;
	}

}