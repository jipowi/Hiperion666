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
 * The persistent class for the cobert_trans database table.
 * 
 */
@Entity
@Table(name = "cobert_trans")
@NamedQuery(name = "CobertTran.findAll", query = "SELECT c FROM CobertTran c")
public class CobertTran extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_transporte")
	private Integer idCobertTransporte;

	@Column(name = "cobertura_transporte")
	private String coberturaTransporte;

	// bi-directional many-to-one association to RamoTransporte
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_transporte")
	private RamoTransporte ramoTransporte;

	public CobertTran() {
	}

	public Integer getIdCobertTransporte() {
		return this.idCobertTransporte;
	}

	public void setIdCobertTransporte(Integer idCobertTransporte) {
		this.idCobertTransporte = idCobertTransporte;
	}

	public String getCoberturaTransporte() {
		return this.coberturaTransporte;
	}

	public void setCoberturaTransporte(String coberturaTransporte) {
		this.coberturaTransporte = coberturaTransporte;
	}

	public RamoTransporte getRamoTransporte() {
		return this.ramoTransporte;
	}

	public void setRamoTransporte(RamoTransporte ramoTransporte) {
		this.ramoTransporte = ramoTransporte;
	}

}