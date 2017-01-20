package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the miembros_grupo_vida database table.
 * 
 */
@Entity
@Table(name = "miembros_grupo_vida")
@NamedQuery(name = "MiembrosGrupoVida.findAll", query = "SELECT m FROM MiembrosGrupoVida m")
public class MiembrosGrupoVida extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_miembrro_vida")
	private Integer idMiembrroVida;

	@Column(name = "cedula_miembro_vida")
	private String cedulaMiembroVida;

	@Temporal(TemporalType.DATE)
	@Column(name = "edad_miembro_vida")
	private Date edadMiembroVida;

	@Column(name = "modalidad_miembro_vida")
	private String modalidadMiembroVida;

	@Column(name = "nombre_miembro_vida")
	private String nombreMiembroVida;

	@Column(name = "parentezco_miembro_vida")
	private String parentezcoMiembroVida;

	@Column(name = "sexo_miembro_vida")
	private String sexoMiembroVida;

	// bi-directional many-to-one association to GrupoVida
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grupo_vida")
	private GrupoVida grupoVida;

	public MiembrosGrupoVida() {
	}

	public Integer getIdMiembrroVida() {
		return this.idMiembrroVida;
	}

	public void setIdMiembrroVida(Integer idMiembrroVida) {
		this.idMiembrroVida = idMiembrroVida;
	}

	public String getCedulaMiembroVida() {
		return this.cedulaMiembroVida;
	}

	public void setCedulaMiembroVida(String cedulaMiembroVida) {
		this.cedulaMiembroVida = cedulaMiembroVida;
	}

	public Date getEdadMiembroVida() {
		return this.edadMiembroVida;
	}

	public void setEdadMiembroVida(Date edadMiembroVida) {
		this.edadMiembroVida = edadMiembroVida;
	}

	public String getModalidadMiembroVida() {
		return this.modalidadMiembroVida;
	}

	public void setModalidadMiembroVida(String modalidadMiembroVida) {
		this.modalidadMiembroVida = modalidadMiembroVida;
	}

	public String getNombreMiembroVida() {
		return this.nombreMiembroVida;
	}

	public void setNombreMiembroVida(String nombreMiembroVida) {
		this.nombreMiembroVida = nombreMiembroVida;
	}

	public String getParentezcoMiembroVida() {
		return this.parentezcoMiembroVida;
	}

	public void setParentezcoMiembroVida(String parentezcoMiembroVida) {
		this.parentezcoMiembroVida = parentezcoMiembroVida;
	}

	public String getSexoMiembroVida() {
		return this.sexoMiembroVida;
	}

	public void setSexoMiembroVida(String sexoMiembroVida) {
		this.sexoMiembroVida = sexoMiembroVida;
	}

	public GrupoVida getGrupoVida() {
		return this.grupoVida;
	}

	public void setGrupoVida(GrupoVida grupoVida) {
		this.grupoVida = grupoVida;
	}

}