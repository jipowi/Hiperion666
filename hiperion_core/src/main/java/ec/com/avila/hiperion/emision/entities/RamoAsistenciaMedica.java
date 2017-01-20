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
 * The persistent class for the ramo_asistencia_medica database table.
 * 
 */
@Entity
@Table(name = "ramo_asistencia_medica")
@NamedQuery(name = "RamoAsistenciaMedica.findAll", query = "SELECT r FROM RamoAsistenciaMedica r")
public class RamoAsistenciaMedica extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ast_medica")
	private Integer idAstMedica;

	@Column(name = "total_mensual_grupo_asm")
	private BigDecimal totalMensualGrupoAsm;

	// bi-directional many-to-one association to CondPartAsm
	@OneToMany(mappedBy = "ramoAsistenciaMedica")
	private List<CondPartAsm> condPartAsms;

	// bi-directional many-to-one association to GrupoAsm
	@OneToMany(mappedBy = "ramoAsistenciaMedica")
	private List<GrupoAsm> grupoAsms;

	// bi-directional many-to-one association to LimitesCostosAsm
	@OneToMany(mappedBy = "ramoAsistenciaMedica")
	private List<LimitesCostosAsm> limitesCostosAsms;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoAsistenciaMedica() {
	}

	public Integer getIdAstMedica() {
		return this.idAstMedica;
	}

	public void setIdAstMedica(Integer idAstMedica) {
		this.idAstMedica = idAstMedica;
	}

	public BigDecimal getTotalMensualGrupoAsm() {
		return this.totalMensualGrupoAsm;
	}

	public void setTotalMensualGrupoAsm(BigDecimal totalMensualGrupoAsm) {
		this.totalMensualGrupoAsm = totalMensualGrupoAsm;
	}

	public List<CondPartAsm> getCondPartAsms() {
		return this.condPartAsms;
	}

	public void setCondPartAsms(List<CondPartAsm> condPartAsms) {
		this.condPartAsms = condPartAsms;
	}

	public CondPartAsm addCondPartAsm(CondPartAsm condPartAsm) {
		getCondPartAsms().add(condPartAsm);
		condPartAsm.setRamoAsistenciaMedica(this);

		return condPartAsm;
	}

	public CondPartAsm removeCondPartAsm(CondPartAsm condPartAsm) {
		getCondPartAsms().remove(condPartAsm);
		condPartAsm.setRamoAsistenciaMedica(null);

		return condPartAsm;
	}

	public List<GrupoAsm> getGrupoAsms() {
		return this.grupoAsms;
	}

	public void setGrupoAsms(List<GrupoAsm> grupoAsms) {
		this.grupoAsms = grupoAsms;
	}

	public GrupoAsm addGrupoAsm(GrupoAsm grupoAsm) {
		getGrupoAsms().add(grupoAsm);
		grupoAsm.setRamoAsistenciaMedica(this);

		return grupoAsm;
	}

	public GrupoAsm removeGrupoAsm(GrupoAsm grupoAsm) {
		getGrupoAsms().remove(grupoAsm);
		grupoAsm.setRamoAsistenciaMedica(null);

		return grupoAsm;
	}

	public List<LimitesCostosAsm> getLimitesCostosAsms() {
		return this.limitesCostosAsms;
	}

	public void setLimitesCostosAsms(List<LimitesCostosAsm> limitesCostosAsms) {
		this.limitesCostosAsms = limitesCostosAsms;
	}

	public LimitesCostosAsm addLimitesCostosAsm(LimitesCostosAsm limitesCostosAsm) {
		getLimitesCostosAsms().add(limitesCostosAsm);
		limitesCostosAsm.setRamoAsistenciaMedica(this);

		return limitesCostosAsm;
	}

	public LimitesCostosAsm removeLimitesCostosAsm(LimitesCostosAsm limitesCostosAsm) {
		getLimitesCostosAsms().remove(limitesCostosAsm);
		limitesCostosAsm.setRamoAsistenciaMedica(null);

		return limitesCostosAsm;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}