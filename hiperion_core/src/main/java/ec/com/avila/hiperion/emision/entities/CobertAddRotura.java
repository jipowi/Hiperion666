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
 * The persistent class for the cobert_add_rotura database table.
 * 
 */
@Entity
@Table(name = "cobert_add_rotura")
@NamedQuery(name = "CobertAddRotura.findAll", query = "SELECT c FROM CobertAddRotura c")
public class CobertAddRotura extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_ad_rotura")
	private Integer idCobertAdRotura;

	@Column(name = "cobertura_add_rotura")
	private String coberturaAddRotura;

	@Column(name = "valor_cob_rotura")
	private BigDecimal valorCobRotura;

	// bi-directional many-to-one association to RamoRoturaMaquinaria
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rotura")
	private RamoRoturaMaquinaria ramoRoturaMaquinaria;

	public CobertAddRotura() {
	}

	public Integer getIdCobertAdRotura() {
		return this.idCobertAdRotura;
	}

	public void setIdCobertAdRotura(Integer idCobertAdRotura) {
		this.idCobertAdRotura = idCobertAdRotura;
	}

	public String getCoberturaAddRotura() {
		return this.coberturaAddRotura;
	}

	public void setCoberturaAddRotura(String coberturaAddRotura) {
		this.coberturaAddRotura = coberturaAddRotura;
	}

	public BigDecimal getValorCobRotura() {
		return this.valorCobRotura;
	}

	public void setValorCobRotura(BigDecimal valorCobRotura) {
		this.valorCobRotura = valorCobRotura;
	}

	public RamoRoturaMaquinaria getRamoRoturaMaquinaria() {
		return this.ramoRoturaMaquinaria;
	}

	public void setRamoRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) {
		this.ramoRoturaMaquinaria = ramoRoturaMaquinaria;
	}

}