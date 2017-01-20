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
 * The persistent class for the cobert_resp database table.
 * 
 */
@Entity
@Table(name = "cobert_resp")
@NamedQuery(name = "CobertResp.findAll", query = "SELECT c FROM CobertResp c")
public class CobertResp extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_responsabilidad")
	private Integer idCobertResponsabilidad;

	@Column(name = "cobertura_resp")
	private String coberturaResp;

	// bi-directional many-to-one association to RamoResponsabilidadCivil
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_responsabilidad")
	private RamoResponsabilidadCivil ramoResponsabilidadCivil;

	public CobertResp() {
	}

	public Integer getIdCobertResponsabilidad() {
		return this.idCobertResponsabilidad;
	}

	public void setIdCobertResponsabilidad(Integer idCobertResponsabilidad) {
		this.idCobertResponsabilidad = idCobertResponsabilidad;
	}

	public String getCoberturaResp() {
		return this.coberturaResp;
	}

	public void setCoberturaResp(String coberturaResp) {
		this.coberturaResp = coberturaResp;
	}

	public RamoResponsabilidadCivil getRamoResponsabilidadCivil() {
		return this.ramoResponsabilidadCivil;
	}

	public void setRamoResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil) {
		this.ramoResponsabilidadCivil = ramoResponsabilidadCivil;
	}

}