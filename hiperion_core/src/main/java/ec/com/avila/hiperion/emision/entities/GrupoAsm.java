package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the grupo_asm database table.
 * 
 */
@Entity
@Table(name = "grupo_asm")
@NamedQuery(name = "GrupoAsm.findAll", query = "SELECT g FROM GrupoAsm g")
public class GrupoAsm extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_grupo_asm")
	private Integer idGrupoAsm;

	@Column(name = "nombre_grupo_asm")
	private String nombreGrupoAsm;

	@Column(name = "numero_personas_asm")
	private Integer numeroPersonasAsm;

	// bi-directional many-to-one association to RamoAsistenciaMedica
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ast_medica")
	private RamoAsistenciaMedica ramoAsistenciaMedica;

	// bi-directional many-to-one association to MiembrosGrupoAsm
	@OneToMany(mappedBy = "grupoAsm")
	private List<MiembrosGrupoAsm> miembrosGrupoAsms;

	public GrupoAsm() {
	}

	public Integer getIdGrupoAsm() {
		return this.idGrupoAsm;
	}

	public void setIdGrupoAsm(Integer idGrupoAsm) {
		this.idGrupoAsm = idGrupoAsm;
	}

	public String getNombreGrupoAsm() {
		return this.nombreGrupoAsm;
	}

	public void setNombreGrupoAsm(String nombreGrupoAsm) {
		this.nombreGrupoAsm = nombreGrupoAsm;
	}

	public Integer getNumeroPersonasAsm() {
		return this.numeroPersonasAsm;
	}

	public void setNumeroPersonasAsm(Integer numeroPersonasAsm) {
		this.numeroPersonasAsm = numeroPersonasAsm;
	}

	public RamoAsistenciaMedica getRamoAsistenciaMedica() {
		return this.ramoAsistenciaMedica;
	}

	public void setRamoAsistenciaMedica(RamoAsistenciaMedica ramoAsistenciaMedica) {
		this.ramoAsistenciaMedica = ramoAsistenciaMedica;
	}

	public List<MiembrosGrupoAsm> getMiembrosGrupoAsms() {
		return this.miembrosGrupoAsms;
	}

	public void setMiembrosGrupoAsms(List<MiembrosGrupoAsm> miembrosGrupoAsms) {
		this.miembrosGrupoAsms = miembrosGrupoAsms;
	}

	public MiembrosGrupoAsm addMiembrosGrupoAsm(MiembrosGrupoAsm miembrosGrupoAsm) {
		getMiembrosGrupoAsms().add(miembrosGrupoAsm);
		miembrosGrupoAsm.setGrupoAsm(this);

		return miembrosGrupoAsm;
	}

	public MiembrosGrupoAsm removeMiembrosGrupoAsm(MiembrosGrupoAsm miembrosGrupoAsm) {
		getMiembrosGrupoAsms().remove(miembrosGrupoAsm);
		miembrosGrupoAsm.setGrupoAsm(null);

		return miembrosGrupoAsm;
	}

}