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
 * The persistent class for the cobert_add_casco database table.
 * 
 */
@Entity
@Table(name = "cobert_add_casco")
@NamedQuery(name = "CobertAddCasco.findAll", query = "SELECT c FROM CobertAddCasco c")
public class CobertAddCasco extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_ad_casco")
	private Integer idCobertAdCasco;

	@Column(name = "cobertura_casco")
	private String coberturaCasco;

	// bi-directional many-to-one association to RamoCascoMaritimo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_casco")
	private RamoCascoMaritimo ramoCascoMaritimo;

	public CobertAddCasco() {
	}

	public Integer getIdCobertAdCasco() {
		return this.idCobertAdCasco;
	}

	public void setIdCobertAdCasco(Integer idCobertAdCasco) {
		this.idCobertAdCasco = idCobertAdCasco;
	}

	public String getCoberturaCasco() {
		return this.coberturaCasco;
	}

	public void setCoberturaCasco(String coberturaCasco) {
		this.coberturaCasco = coberturaCasco;
	}

	public RamoCascoMaritimo getRamoCascoMaritimo() {
		return this.ramoCascoMaritimo;
	}

	public void setRamoCascoMaritimo(RamoCascoMaritimo ramoCascoMaritimo) {
		this.ramoCascoMaritimo = ramoCascoMaritimo;
	}

}