package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the grupo_acc_personales database table.
 * 
 */
@Entity
@Table(name = "grupo_acc_personales")
@NamedQuery(name = "GrupoAccPersonale.findAll", query = "SELECT g FROM GrupoAccPersonale g")
public class GrupoAccPersonale extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_grupo_accp")
	private Integer idGrupoAccp;

	@Column(name = "actividad_acc")
	private String actividadAcc;

	@Column(name = "deduc_grupo_acc")
	private BigDecimal deducGrupoAcc;

	@Column(name = "nombre_grupo_acc")
	private String nombreGrupoAcc;

	@Column(name = "numero_personas_acc")
	private Integer numeroPersonasAcc;

	@Column(name = "valor_grupo_acc")
	private BigDecimal valorGrupoAcc;

	// bi-directional many-to-one association to RamoAccidentesPersonale
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_accidentes")
	private RamoAccidentesPersonale ramoAccidentesPersonale;

	// bi-directional many-to-one association to MiembrosGrupoAcc
	@OneToMany(mappedBy = "grupoAccPersonale")
	private List<MiembrosGrupoAcc> miembrosGrupoAccs;

	public GrupoAccPersonale() {
	}

	public Integer getIdGrupoAccp() {
		return this.idGrupoAccp;
	}

	public void setIdGrupoAccp(Integer idGrupoAccp) {
		this.idGrupoAccp = idGrupoAccp;
	}

	public String getActividadAcc() {
		return this.actividadAcc;
	}

	public void setActividadAcc(String actividadAcc) {
		this.actividadAcc = actividadAcc;
	}

	public BigDecimal getDeducGrupoAcc() {
		return this.deducGrupoAcc;
	}

	public void setDeducGrupoAcc(BigDecimal deducGrupoAcc) {
		this.deducGrupoAcc = deducGrupoAcc;
	}

	public String getNombreGrupoAcc() {
		return this.nombreGrupoAcc;
	}

	public void setNombreGrupoAcc(String nombreGrupoAcc) {
		this.nombreGrupoAcc = nombreGrupoAcc;
	}

	public Integer getNumeroPersonasAcc() {
		return this.numeroPersonasAcc;
	}

	public void setNumeroPersonasAcc(Integer numeroPersonasAcc) {
		this.numeroPersonasAcc = numeroPersonasAcc;
	}

	public BigDecimal getValorGrupoAcc() {
		return this.valorGrupoAcc;
	}

	public void setValorGrupoAcc(BigDecimal valorGrupoAcc) {
		this.valorGrupoAcc = valorGrupoAcc;
	}

	public RamoAccidentesPersonale getRamoAccidentesPersonale() {
		return this.ramoAccidentesPersonale;
	}

	public void setRamoAccidentesPersonale(RamoAccidentesPersonale ramoAccidentesPersonale) {
		this.ramoAccidentesPersonale = ramoAccidentesPersonale;
	}

	public List<MiembrosGrupoAcc> getMiembrosGrupoAccs() {
		return this.miembrosGrupoAccs;
	}

	public void setMiembrosGrupoAccs(List<MiembrosGrupoAcc> miembrosGrupoAccs) {
		this.miembrosGrupoAccs = miembrosGrupoAccs;
	}

	public MiembrosGrupoAcc addMiembrosGrupoAcc(MiembrosGrupoAcc miembrosGrupoAcc) {
		getMiembrosGrupoAccs().add(miembrosGrupoAcc);
		miembrosGrupoAcc.setGrupoAccPersonale(this);

		return miembrosGrupoAcc;
	}

	public MiembrosGrupoAcc removeMiembrosGrupoAcc(MiembrosGrupoAcc miembrosGrupoAcc) {
		getMiembrosGrupoAccs().remove(miembrosGrupoAcc);
		miembrosGrupoAcc.setGrupoAccPersonale(null);

		return miembrosGrupoAcc;
	}

}