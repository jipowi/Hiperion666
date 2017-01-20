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
 * The persistent class for the cobert_aduanera database table.
 * 
 */
@Entity
@Table(name = "cobert_aduanera")
@NamedQuery(name = "CobertAduanera.findAll", query = "SELECT c FROM CobertAduanera c")
public class CobertAduanera extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_aduanera")
	private Integer idCobertAduanera;

	@Column(name = "cobertura_aduanera")
	private String coberturaAduanera;

	// bi-directional many-to-one association to RamoGarantiaAduanera
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aduanera")
	private RamoGarantiaAduanera ramoGarantiaAduanera;

	public CobertAduanera() {
	}

	public Integer getIdCobertAduanera() {
		return this.idCobertAduanera;
	}

	public void setIdCobertAduanera(Integer idCobertAduanera) {
		this.idCobertAduanera = idCobertAduanera;
	}

	public String getCoberturaAduanera() {
		return this.coberturaAduanera;
	}

	public void setCoberturaAduanera(String coberturaAduanera) {
		this.coberturaAduanera = coberturaAduanera;
	}

	public RamoGarantiaAduanera getRamoGarantiaAduanera() {
		return this.ramoGarantiaAduanera;
	}

	public void setRamoGarantiaAduanera(RamoGarantiaAduanera ramoGarantiaAduanera) {
		this.ramoGarantiaAduanera = ramoGarantiaAduanera;
	}

}