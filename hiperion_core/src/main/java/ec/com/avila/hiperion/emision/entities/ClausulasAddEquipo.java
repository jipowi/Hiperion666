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
 * The persistent class for the clausulas_add_equipo database table.
 * 
 */
@Entity
@Table(name = "clausulas_add_equipo")
@NamedQuery(name = "ClausulasAddEquipo.findAll", query = "SELECT c FROM ClausulasAddEquipo c")
public class ClausulasAddEquipo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clausula_ad_equipo")
	private Integer idClausulaAdEquipo;

	@Column(name = "clausula_eq_elec")
	private String clausulaEqElec;

	// bi-directional many-to-one association to RamoEquipoElectronico
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_equipo")
	private RamoEquipoElectronico ramoEquipoElectronico;

	public ClausulasAddEquipo() {
	}

	public Integer getIdClausulaAdEquipo() {
		return this.idClausulaAdEquipo;
	}

	public void setIdClausulaAdEquipo(Integer idClausulaAdEquipo) {
		this.idClausulaAdEquipo = idClausulaAdEquipo;
	}

	public String getClausulaEqElec() {
		return this.clausulaEqElec;
	}

	public void setClausulaEqElec(String clausulaEqElec) {
		this.clausulaEqElec = clausulaEqElec;
	}

	public RamoEquipoElectronico getRamoEquipoElectronico() {
		return this.ramoEquipoElectronico;
	}

	public void setRamoEquipoElectronico(RamoEquipoElectronico ramoEquipoElectronico) {
		this.ramoEquipoElectronico = ramoEquipoElectronico;
	}

}