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
 * The persistent class for the cobert_add_incendio database table.
 * 
 */
@Entity
@Table(name = "cobert_add_incendio")
@NamedQuery(name = "CobertAddIncendio.findAll", query = "SELECT c FROM CobertAddIncendio c")
public class CobertAddIncendio extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_ad_ramo_inc")
	private Integer idCobertAdRamoInc;

	@Column(name = "cobertura_add_incendio")
	private String coberturaAddIncendio;

	// bi-directional many-to-one association to RamoIncendioLineasAliada
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_incendio")
	private RamoIncendioLineasAliada ramoIncendioLineasAliada;

	public CobertAddIncendio() {
	}

	public Integer getIdCobertAdRamoInc() {
		return this.idCobertAdRamoInc;
	}

	public void setIdCobertAdRamoInc(Integer idCobertAdRamoInc) {
		this.idCobertAdRamoInc = idCobertAdRamoInc;
	}

	public String getCoberturaAddIncendio() {
		return this.coberturaAddIncendio;
	}

	public void setCoberturaAddIncendio(String coberturaAddIncendio) {
		this.coberturaAddIncendio = coberturaAddIncendio;
	}

	public RamoIncendioLineasAliada getRamoIncendioLineasAliada() {
		return this.ramoIncendioLineasAliada;
	}

	public void setRamoIncendioLineasAliada(RamoIncendioLineasAliada ramoIncendioLineasAliada) {
		this.ramoIncendioLineasAliada = ramoIncendioLineasAliada;
	}

}