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
 * The persistent class for the grupo_vida database table.
 * 
 */
@Entity
@Table(name = "grupo_vida")
@NamedQuery(name = "GrupoVida.findAll", query = "SELECT g FROM GrupoVida g")
public class GrupoVida extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_grupo_vida")
	private Integer idGrupoVida;

	@Column(name = "actividad_vida")
	private String actividadVida;

	@Column(name = "deduc_grupo_vida")
	private BigDecimal deducGrupoVida;

	@Column(name = "nombre_grupo_vida")
	private String nombreGrupoVida;

	@Column(name = "numero_personas_vida")
	private Integer numeroPersonasVida;

	@Column(name = "valor_grupo_vida")
	private BigDecimal valorGrupoVida;

	// bi-directional many-to-one association to RamoVida
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vida")
	private RamoVida ramoVida;

	// bi-directional many-to-one association to MiembrosGrupoVida
	@OneToMany(mappedBy = "grupoVida")
	private List<MiembrosGrupoVida> miembrosGrupoVidas;

	public GrupoVida() {
	}

	public Integer getIdGrupoVida() {
		return this.idGrupoVida;
	}

	public void setIdGrupoVida(Integer idGrupoVida) {
		this.idGrupoVida = idGrupoVida;
	}

	public String getActividadVida() {
		return this.actividadVida;
	}

	public void setActividadVida(String actividadVida) {
		this.actividadVida = actividadVida;
	}

	public BigDecimal getDeducGrupoVida() {
		return this.deducGrupoVida;
	}

	public void setDeducGrupoVida(BigDecimal deducGrupoVida) {
		this.deducGrupoVida = deducGrupoVida;
	}

	public String getNombreGrupoVida() {
		return this.nombreGrupoVida;
	}

	public void setNombreGrupoVida(String nombreGrupoVida) {
		this.nombreGrupoVida = nombreGrupoVida;
	}

	public Integer getNumeroPersonasVida() {
		return this.numeroPersonasVida;
	}

	public void setNumeroPersonasVida(Integer numeroPersonasVida) {
		this.numeroPersonasVida = numeroPersonasVida;
	}

	public BigDecimal getValorGrupoVida() {
		return this.valorGrupoVida;
	}

	public void setValorGrupoVida(BigDecimal valorGrupoVida) {
		this.valorGrupoVida = valorGrupoVida;
	}

	public RamoVida getRamoVida() {
		return this.ramoVida;
	}

	public void setRamoVida(RamoVida ramoVida) {
		this.ramoVida = ramoVida;
	}

	public List<MiembrosGrupoVida> getMiembrosGrupoVidas() {
		return this.miembrosGrupoVidas;
	}

	public void setMiembrosGrupoVidas(List<MiembrosGrupoVida> miembrosGrupoVidas) {
		this.miembrosGrupoVidas = miembrosGrupoVidas;
	}

	public MiembrosGrupoVida addMiembrosGrupoVida(MiembrosGrupoVida miembrosGrupoVida) {
		getMiembrosGrupoVidas().add(miembrosGrupoVida);
		miembrosGrupoVida.setGrupoVida(this);

		return miembrosGrupoVida;
	}

	public MiembrosGrupoVida removeMiembrosGrupoVida(MiembrosGrupoVida miembrosGrupoVida) {
		getMiembrosGrupoVidas().remove(miembrosGrupoVida);
		miembrosGrupoVida.setGrupoVida(null);

		return miembrosGrupoVida;
	}

}