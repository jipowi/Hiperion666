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
 * The persistent class for the cobert_eq_maq database table.
 * 
 */
@Entity
@Table(name = "cobert_eq_maq")
@NamedQuery(name = "CobertEqMaq.findAll", query = "SELECT c FROM CobertEqMaq c")
public class CobertEqMaq extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_eq_maq")
	private Integer idCobertEqMaq;

	@Column(name = "cobertura_eq_maq")
	private String coberturaEqMaq;

	// bi-directional many-to-one association to RamoEquipoMaquinaria
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_equipo_maquinaria")
	private RamoEquipoMaquinaria ramoEquipoMaquinaria;

	public CobertEqMaq() {
	}

	public Integer getIdCobertEqMaq() {
		return this.idCobertEqMaq;
	}

	public void setIdCobertEqMaq(Integer idCobertEqMaq) {
		this.idCobertEqMaq = idCobertEqMaq;
	}

	public String getCoberturaEqMaq() {
		return this.coberturaEqMaq;
	}

	public void setCoberturaEqMaq(String coberturaEqMaq) {
		this.coberturaEqMaq = coberturaEqMaq;
	}

	public RamoEquipoMaquinaria getRamoEquipoMaquinaria() {
		return this.ramoEquipoMaquinaria;
	}

	public void setRamoEquipoMaquinaria(RamoEquipoMaquinaria ramoEquipoMaquinaria) {
		this.ramoEquipoMaquinaria = ramoEquipoMaquinaria;
	}

}