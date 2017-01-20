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
 * The persistent class for the cobert_soat database table.
 * 
 */
@Entity
@Table(name = "cobert_soat")
@NamedQuery(name = "CobertSoat.findAll", query = "SELECT c FROM CobertSoat c")
public class CobertSoat extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_soat")
	private Integer idCobertSoat;

	@Column(name = "cobertura_soat")
	private String coberturaSoat;

	// bi-directional many-to-one association to RamoSoat
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_soat")
	private RamoSoat ramoSoat;

	public CobertSoat() {
	}

	public Integer getIdCobertSoat() {
		return this.idCobertSoat;
	}

	public void setIdCobertSoat(Integer idCobertSoat) {
		this.idCobertSoat = idCobertSoat;
	}

	public String getCoberturaSoat() {
		return this.coberturaSoat;
	}

	public void setCoberturaSoat(String coberturaSoat) {
		this.coberturaSoat = coberturaSoat;
	}

	public RamoSoat getRamoSoat() {
		return this.ramoSoat;
	}

	public void setRamoSoat(RamoSoat ramoSoat) {
		this.ramoSoat = ramoSoat;
	}

}