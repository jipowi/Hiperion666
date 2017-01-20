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
 * The persistent class for the cobert_casco_aereo database table.
 * 
 */
@Entity
@Table(name = "cobert_casco_aereo")
@NamedQuery(name = "CobertCascoAereo.findAll", query = "SELECT c FROM CobertCascoAereo c")
public class CobertCascoAereo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_aereo")
	private Integer idCobertAereo;

	@Column(name = "cobertura_aereo")
	private String coberturaAereo;

	// bi-directional many-to-one association to RamoCascoAereo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_casco_aereo")
	private RamoCascoAereo ramoCascoAereo;

	public CobertCascoAereo() {
	}

	public Integer getIdCobertAereo() {
		return this.idCobertAereo;
	}

	public void setIdCobertAereo(Integer idCobertAereo) {
		this.idCobertAereo = idCobertAereo;
	}

	public String getCoberturaAereo() {
		return this.coberturaAereo;
	}

	public void setCoberturaAereo(String coberturaAereo) {
		this.coberturaAereo = coberturaAereo;
	}

	/**
	 * @return the ramoCascoAereo
	 */
	public RamoCascoAereo getRamoCascoAereo() {
		return ramoCascoAereo;
	}

	/**
	 * @param ramoCascoAereo
	 *            the ramoCascoAereo to set
	 */
	public void setRamoCascoAereo(RamoCascoAereo ramoCascoAereo) {
		this.ramoCascoAereo = ramoCascoAereo;
	}

	

}