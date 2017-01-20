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
 * The persistent class for the cobert_lc_in database table.
 * 
 */
@Entity
@Table(name = "cobert_lc_in")
@NamedQuery(name = "CobertLcIn.findAll", query = "SELECT c FROM CobertLcIn c")
public class CobertLcIn extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_lucro")
	private Integer idCobertLucro;

	@Column(name = "cobertura_lc_incendio")
	private String coberturaLcIncendio;

	// bi-directional many-to-one association to RamoLcIncendio
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lucro")
	private RamoLcIncendio ramoLcIncendio;

	public CobertLcIn() {
	}

	public Integer getIdCobertLucro() {
		return this.idCobertLucro;
	}

	public void setIdCobertLucro(Integer idCobertLucro) {
		this.idCobertLucro = idCobertLucro;
	}

	public String getCoberturaLcIncendio() {
		return this.coberturaLcIncendio;
	}

	public void setCoberturaLcIncendio(String coberturaLcIncendio) {
		this.coberturaLcIncendio = coberturaLcIncendio;
	}

	public RamoLcIncendio getRamoLcIncendio() {
		return this.ramoLcIncendio;
	}

	public void setRamoLcIncendio(RamoLcIncendio ramoLcIncendio) {
		this.ramoLcIncendio = ramoLcIncendio;
	}

}