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
 * The persistent class for the miembros_grupo_acc database table.
 * 
 */
@Entity
@Table(name = "miembros_grupo_acc")
@NamedQuery(name = "MiembrosGrupoAcc.findAll", query = "SELECT m FROM MiembrosGrupoAcc m")
public class MiembrosGrupoAcc extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_miembro_accp")
	private Integer idMiembroAccp;

	@Column(name = "cedula_miembro")
	private String cedulaMiembro;

	@Column(name = "edad_miembro")
	private Integer edadMiembro;

	@Column(name = "modalidad_acc")
	private Integer modalidadAcc;

	@Column(name = "nombre_miembro")
	private String nombreMiembro;

	@Column(name = "parentezco_miembro")
	private String parentezcoMiembro;

	@Column(name = "sexo_miebro")
	private String sexoMiebro;

	// bi-directional many-to-one association to GrupoAccPersonale
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grupo_accp")
	private GrupoAccPersonale grupoAccPersonale;

	public MiembrosGrupoAcc() {
	}

	public Integer getIdMiembroAccp() {
		return this.idMiembroAccp;
	}

	public void setIdMiembroAccp(Integer idMiembroAccp) {
		this.idMiembroAccp = idMiembroAccp;
	}

	public String getCedulaMiembro() {
		return this.cedulaMiembro;
	}

	public void setCedulaMiembro(String cedulaMiembro) {
		this.cedulaMiembro = cedulaMiembro;
	}

	public Integer getEdadMiembro() {
		return this.edadMiembro;
	}

	public void setEdadMiembro(Integer edadMiembro) {
		this.edadMiembro = edadMiembro;
	}

	public Integer getModalidadAcc() {
		return this.modalidadAcc;
	}

	public void setModalidadAcc(Integer modalidadAcc) {
		this.modalidadAcc = modalidadAcc;
	}

	public String getNombreMiembro() {
		return this.nombreMiembro;
	}

	public void setNombreMiembro(String nombreMiembro) {
		this.nombreMiembro = nombreMiembro;
	}

	public String getParentezcoMiembro() {
		return this.parentezcoMiembro;
	}

	public void setParentezcoMiembro(String parentezcoMiembro) {
		this.parentezcoMiembro = parentezcoMiembro;
	}

	public String getSexoMiebro() {
		return this.sexoMiebro;
	}

	public void setSexoMiebro(String sexoMiebro) {
		this.sexoMiebro = sexoMiebro;
	}

	public GrupoAccPersonale getGrupoAccPersonale() {
		return this.grupoAccPersonale;
	}

	public void setGrupoAccPersonale(GrupoAccPersonale grupoAccPersonale) {
		this.grupoAccPersonale = grupoAccPersonale;
	}

}