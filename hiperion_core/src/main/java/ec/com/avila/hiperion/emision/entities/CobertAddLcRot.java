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
 * The persistent class for the cobert_add_lc_rot database table.
 * 
 */
@Entity
@Table(name = "cobert_add_lc_rot")
@NamedQuery(name = "CobertAddLcRot.findAll", query = "SELECT c FROM CobertAddLcRot c")
public class CobertAddLcRot extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_ad_cesante")
	private Integer idCobertAdCesante;

	@Column(name = "cobertura_add_lc_rotura")
	private String coberturaAddLcRotura;

	// bi-directional many-to-one association to RamoLcRotMaq
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cesante")
	private RamoLcRotMaq ramoLcRotMaq;

	public CobertAddLcRot() {
	}

	public Integer getIdCobertAdCesante() {
		return this.idCobertAdCesante;
	}

	public void setIdCobertAdCesante(Integer idCobertAdCesante) {
		this.idCobertAdCesante = idCobertAdCesante;
	}

	public String getCoberturaAddLcRotura() {
		return this.coberturaAddLcRotura;
	}

	public void setCoberturaAddLcRotura(String coberturaAddLcRotura) {
		this.coberturaAddLcRotura = coberturaAddLcRotura;
	}

	public RamoLcRotMaq getRamoLcRotMaq() {
		return this.ramoLcRotMaq;
	}

	public void setRamoLcRotMaq(RamoLcRotMaq ramoLcRotMaq) {
		this.ramoLcRotMaq = ramoLcRotMaq;
	}

}