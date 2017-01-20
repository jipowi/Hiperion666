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
 * The persistent class for the cobert_add_equipo database table.
 * 
 */
@Entity
@Table(name = "cobert_add_equipo")
@NamedQuery(name = "CobertAddEquipo.findAll", query = "SELECT c FROM CobertAddEquipo c")
public class CobertAddEquipo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_ad_equipo")
	private Integer idCobertAdEquipo;

	@Column(name = "cobertura_add_eq_elec")
	private String coberturaAddEqElec;

	// bi-directional many-to-one association to RamoEquipoElectronico
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_equipo")
	private RamoEquipoElectronico ramoEquipoElectronico;

	public CobertAddEquipo() {
	}

	public Integer getIdCobertAdEquipo() {
		return this.idCobertAdEquipo;
	}

	public void setIdCobertAdEquipo(Integer idCobertAdEquipo) {
		this.idCobertAdEquipo = idCobertAdEquipo;
	}

	public String getCoberturaAddEqElec() {
		return this.coberturaAddEqElec;
	}

	public void setCoberturaAddEqElec(String coberturaAddEqElec) {
		this.coberturaAddEqElec = coberturaAddEqElec;
	}

	public RamoEquipoElectronico getRamoEquipoElectronico() {
		return this.ramoEquipoElectronico;
	}

	public void setRamoEquipoElectronico(RamoEquipoElectronico ramoEquipoElectronico) {
		this.ramoEquipoElectronico = ramoEquipoElectronico;
	}

}