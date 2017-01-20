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
 * The persistent class for the cobert_rotura database table.
 * 
 */
@Entity
@Table(name = "cobert_rotura")
@NamedQuery(name = "CobertRotura.findAll", query = "SELECT c FROM CobertRotura c")
public class CobertRotura extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_rotura")
	private Integer idCobertRotura;

	@Column(name = "cobertura_rotura")
	private String coberturaRotura;

	// bi-directional many-to-one association to RamoRoturaMaquinaria
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rotura")
	private RamoRoturaMaquinaria ramoRoturaMaquinaria;

	public CobertRotura() {
	}

	public Integer getIdCobertRotura() {
		return this.idCobertRotura;
	}

	public void setIdCobertRotura(Integer idCobertRotura) {
		this.idCobertRotura = idCobertRotura;
	}

	public String getCoberturaRotura() {
		return this.coberturaRotura;
	}

	public void setCoberturaRotura(String coberturaRotura) {
		this.coberturaRotura = coberturaRotura;
	}

	public RamoRoturaMaquinaria getRamoRoturaMaquinaria() {
		return this.ramoRoturaMaquinaria;
	}

	public void setRamoRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) {
		this.ramoRoturaMaquinaria = ramoRoturaMaquinaria;
	}

}