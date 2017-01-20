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
 * The persistent class for the cobert_lc_rot database table.
 * 
 */
@Entity
@Table(name = "cobert_lc_rot")
@NamedQuery(name = "CobertLcRot.findAll", query = "SELECT c FROM CobertLcRot c")
public class CobertLcRot extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_cesante")
	private Integer idCobertCesante;

	@Column(name = "cobertura_lc_rotura")
	private String coberturaLcRotura;

	// bi-directional many-to-one association to RamoLcRotMaq
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cesante")
	private RamoLcRotMaq ramoLcRotMaq;

	public CobertLcRot() {
	}

	public Integer getIdCobertCesante() {
		return this.idCobertCesante;
	}

	public void setIdCobertCesante(Integer idCobertCesante) {
		this.idCobertCesante = idCobertCesante;
	}

	public String getCoberturaLcRotura() {
		return this.coberturaLcRotura;
	}

	public void setCoberturaLcRotura(String coberturaLcRotura) {
		this.coberturaLcRotura = coberturaLcRotura;
	}

	public RamoLcRotMaq getRamoLcRotMaq() {
		return this.ramoLcRotMaq;
	}

	public void setRamoLcRotMaq(RamoLcRotMaq ramoLcRotMaq) {
		this.ramoLcRotMaq = ramoLcRotMaq;
	}

}