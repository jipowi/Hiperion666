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
 * The persistent class for the cobert_add_robo database table.
 * 
 */
@Entity
@Table(name = "cobert_add_robo")
@NamedQuery(name = "CobertAddRobo.findAll", query = "SELECT c FROM CobertAddRobo c")
public class CobertAddRobo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_ad_robo")
	private Integer idCobertAdRobo;

	@Column(name = "cobertura_add_robo")
	private String coberturaAddRobo;

	@Column(name = "valor_cob_add_robo")
	private BigDecimal valorCobAddRobo;

	// bi-directional many-to-one association to RamoRoboAsalto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_robo")
	private RamoRoboAsalto ramoRoboAsalto;

	public CobertAddRobo() {
	}

	public Integer getIdCobertAdRobo() {
		return this.idCobertAdRobo;
	}

	public void setIdCobertAdRobo(Integer idCobertAdRobo) {
		this.idCobertAdRobo = idCobertAdRobo;
	}

	public String getCoberturaAddRobo() {
		return this.coberturaAddRobo;
	}

	public void setCoberturaAddRobo(String coberturaAddRobo) {
		this.coberturaAddRobo = coberturaAddRobo;
	}

	public BigDecimal getValorCobAddRobo() {
		return this.valorCobAddRobo;
	}

	public void setValorCobAddRobo(BigDecimal valorCobAddRobo) {
		this.valorCobAddRobo = valorCobAddRobo;
	}

	public RamoRoboAsalto getRamoRoboAsalto() {
		return this.ramoRoboAsalto;
	}

	public void setRamoRoboAsalto(RamoRoboAsalto ramoRoboAsalto) {
		this.ramoRoboAsalto = ramoRoboAsalto;
	}

}