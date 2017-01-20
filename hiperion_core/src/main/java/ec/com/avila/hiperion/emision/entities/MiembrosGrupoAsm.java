package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the miembros_grupo_asm database table.
 * 
 */
@Entity
@Table(name = "miembros_grupo_asm")
@NamedQuery(name = "MiembrosGrupoAsm.findAll", query = "SELECT m FROM MiembrosGrupoAsm m")
public class MiembrosGrupoAsm extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_miembro_asm")
	private Integer idMiembroAsm;

	@Column(name = "cedula_miembro_asm")
	private String cedulaMiembroAsm;

	@Temporal(TemporalType.DATE)
	@Column(name = "edad_miembro_asm")
	private Date edadMiembroAsm;

	@Temporal(TemporalType.DATE)
	@Column(name = "modalidad_asm")
	private Date modalidadAsm;

	@Column(name = "nombre_miembro_asm")
	private String nombreMiembroAsm;

	@Column(name = "parentezco_asm")
	private String parentezcoAsm;

	@Column(name = "sexo_miembro_asm")
	private String sexoMiembroAsm;

	// bi-directional many-to-one association to GrupoAsm
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grupo_asm")
	private GrupoAsm grupoAsm;

	public MiembrosGrupoAsm() {
	}

	public Integer getIdMiembroAsm() {
		return this.idMiembroAsm;
	}

	public void setIdMiembroAsm(Integer idMiembroAsm) {
		this.idMiembroAsm = idMiembroAsm;
	}

	public String getCedulaMiembroAsm() {
		return this.cedulaMiembroAsm;
	}

	public void setCedulaMiembroAsm(String cedulaMiembroAsm) {
		this.cedulaMiembroAsm = cedulaMiembroAsm;
	}

	public Date getEdadMiembroAsm() {
		return this.edadMiembroAsm;
	}

	public void setEdadMiembroAsm(Date edadMiembroAsm) {
		this.edadMiembroAsm = edadMiembroAsm;
	}

	public Date getModalidadAsm() {
		return this.modalidadAsm;
	}

	public void setModalidadAsm(Date modalidadAsm) {
		this.modalidadAsm = modalidadAsm;
	}

	public String getNombreMiembroAsm() {
		return this.nombreMiembroAsm;
	}

	public void setNombreMiembroAsm(String nombreMiembroAsm) {
		this.nombreMiembroAsm = nombreMiembroAsm;
	}

	public String getParentezcoAsm() {
		return this.parentezcoAsm;
	}

	public void setParentezcoAsm(String parentezcoAsm) {
		this.parentezcoAsm = parentezcoAsm;
	}

	public String getSexoMiembroAsm() {
		return this.sexoMiembroAsm;
	}

	public void setSexoMiembroAsm(String sexoMiembroAsm) {
		this.sexoMiembroAsm = sexoMiembroAsm;
	}

	public GrupoAsm getGrupoAsm() {
		return this.grupoAsm;
	}

	public void setGrupoAsm(GrupoAsm grupoAsm) {
		this.grupoAsm = grupoAsm;
	}

}