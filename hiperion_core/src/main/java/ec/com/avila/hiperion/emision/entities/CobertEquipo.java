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
 * The persistent class for the cobert_equipo database table.
 * 
 */
@Entity
@Table(name = "cobert_equipo")
@NamedQuery(name = "CobertEquipo.findAll", query = "SELECT c FROM CobertEquipo c")
public class CobertEquipo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_equipo")
	private Integer idCobertEquipo;

	@Column(name = "cobertura_eq_elec")
	private String coberturaEqElec;

	// bi-directional many-to-one association to RamoEquipoElectronico
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_equipo")
	private RamoEquipoElectronico ramoEquipoElectronico;

	public CobertEquipo() {
	}

	public Integer getIdCobertEquipo() {
		return this.idCobertEquipo;
	}

	public void setIdCobertEquipo(Integer idCobertEquipo) {
		this.idCobertEquipo = idCobertEquipo;
	}

	public String getCoberturaEqElec() {
		return this.coberturaEqElec;
	}

	public void setCoberturaEqElec(String coberturaEqElec) {
		this.coberturaEqElec = coberturaEqElec;
	}

	public RamoEquipoElectronico getRamoEquipoElectronico() {
		return this.ramoEquipoElectronico;
	}

	public void setRamoEquipoElectronico(RamoEquipoElectronico ramoEquipoElectronico) {
		this.ramoEquipoElectronico = ramoEquipoElectronico;
	}

}