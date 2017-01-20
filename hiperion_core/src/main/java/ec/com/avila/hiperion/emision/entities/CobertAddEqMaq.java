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
 * The persistent class for the cobert_add_eq_maq database table.
 * 
 */
@Entity
@Table(name = "cobert_add_eq_maq")
@NamedQuery(name = "CobertAddEqMaq.findAll", query = "SELECT c FROM CobertAddEqMaq c")
public class CobertAddEqMaq extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_ad_eq_maq")
	private Integer idCobertAdEqMaq;

	@Column(name = "cobertura_add_eq_maq")
	private String coberturaAddEqMaq;

	// bi-directional many-to-one association to RamoEquipoMaquinaria
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_equipo_maquinaria")
	private RamoEquipoMaquinaria ramoEquipoMaquinaria;

	public CobertAddEqMaq() {
	}

	public Integer getIdCobertAdEqMaq() {
		return this.idCobertAdEqMaq;
	}

	public void setIdCobertAdEqMaq(Integer idCobertAdEqMaq) {
		this.idCobertAdEqMaq = idCobertAdEqMaq;
	}

	public String getCoberturaAddEqMaq() {
		return this.coberturaAddEqMaq;
	}

	public void setCoberturaAddEqMaq(String coberturaAddEqMaq) {
		this.coberturaAddEqMaq = coberturaAddEqMaq;
	}

	public RamoEquipoMaquinaria getRamoEquipoMaquinaria() {
		return this.ramoEquipoMaquinaria;
	}

	public void setRamoEquipoMaquinaria(RamoEquipoMaquinaria ramoEquipoMaquinaria) {
		this.ramoEquipoMaquinaria = ramoEquipoMaquinaria;
	}

}