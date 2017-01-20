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
 * The persistent class for the ramo_responsabilidad_civil database table.
 * 
 */
@Entity
@Table(name = "ramo_responsabilidad_civil")
@NamedQuery(name = "RamoResponsabilidadCivil.findAll", query = "SELECT r FROM RamoResponsabilidadCivil r")
public class RamoResponsabilidadCivil extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_responsabilidad")
	private Integer idResponsabilidad;

	@Column(name = "deduc_minimo_resp")
	private BigDecimal deducMinimoResp;

	@Column(name = "deduc_siniestro_resp")
	private BigDecimal deducSiniestroResp;

	@Column(name = "limite_unico_anual_resp")
	private Integer limiteUnicoAnualResp;

	@Column(name = "tasa_resp")
	private BigDecimal tasaResp;

	@Column(name = "tipo_contragarantia_resp")
	private String tipoContragarantiaResp;

	// bi-directional many-to-one association to ClausulasAddResp
	@OneToMany(mappedBy = "ramoResponsabilidadCivil")
	private List<ClausulasAddResp> clausulasAddResps;

	// bi-directional many-to-one association to CobertResp
	@OneToMany(mappedBy = "ramoResponsabilidadCivil")
	private List<CobertResp> cobertResps;

	// bi-directional many-to-one association to ObjAsegResponsabilidad
	@OneToMany(mappedBy = "ramoResponsabilidadCivil")
	private List<ObjAsegResponsabilidad> objAsegResponsabilidads;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoResponsabilidadCivil() {
	}

	public Integer getIdResponsabilidad() {
		return this.idResponsabilidad;
	}

	public void setIdResponsabilidad(Integer idResponsabilidad) {
		this.idResponsabilidad = idResponsabilidad;
	}

	public BigDecimal getDeducMinimoResp() {
		return this.deducMinimoResp;
	}

	public void setDeducMinimoResp(BigDecimal deducMinimoResp) {
		this.deducMinimoResp = deducMinimoResp;
	}

	public BigDecimal getDeducSiniestroResp() {
		return this.deducSiniestroResp;
	}

	public void setDeducSiniestroResp(BigDecimal deducSiniestroResp) {
		this.deducSiniestroResp = deducSiniestroResp;
	}

	public Integer getLimiteUnicoAnualResp() {
		return this.limiteUnicoAnualResp;
	}

	public void setLimiteUnicoAnualResp(Integer limiteUnicoAnualResp) {
		this.limiteUnicoAnualResp = limiteUnicoAnualResp;
	}

	public BigDecimal getTasaResp() {
		return this.tasaResp;
	}

	public void setTasaResp(BigDecimal tasaResp) {
		this.tasaResp = tasaResp;
	}

	public String getTipoContragarantiaResp() {
		return this.tipoContragarantiaResp;
	}

	public void setTipoContragarantiaResp(String tipoContragarantiaResp) {
		this.tipoContragarantiaResp = tipoContragarantiaResp;
	}

	public List<ClausulasAddResp> getClausulasAddResps() {
		return this.clausulasAddResps;
	}

	public void setClausulasAddResps(List<ClausulasAddResp> clausulasAddResps) {
		this.clausulasAddResps = clausulasAddResps;
	}

	public ClausulasAddResp addClausulasAddResp(ClausulasAddResp clausulasAddResp) {
		getClausulasAddResps().add(clausulasAddResp);
		clausulasAddResp.setRamoResponsabilidadCivil(this);

		return clausulasAddResp;
	}

	public ClausulasAddResp removeClausulasAddResp(ClausulasAddResp clausulasAddResp) {
		getClausulasAddResps().remove(clausulasAddResp);
		clausulasAddResp.setRamoResponsabilidadCivil(null);

		return clausulasAddResp;
	}

	public List<CobertResp> getCobertResps() {
		return this.cobertResps;
	}

	public void setCobertResps(List<CobertResp> cobertResps) {
		this.cobertResps = cobertResps;
	}

	public CobertResp addCobertResp(CobertResp cobertResp) {
		getCobertResps().add(cobertResp);
		cobertResp.setRamoResponsabilidadCivil(this);

		return cobertResp;
	}

	public CobertResp removeCobertResp(CobertResp cobertResp) {
		getCobertResps().remove(cobertResp);
		cobertResp.setRamoResponsabilidadCivil(null);

		return cobertResp;
	}

	public List<ObjAsegResponsabilidad> getObjAsegResponsabilidads() {
		return this.objAsegResponsabilidads;
	}

	public void setObjAsegResponsabilidads(List<ObjAsegResponsabilidad> objAsegResponsabilidads) {
		this.objAsegResponsabilidads = objAsegResponsabilidads;
	}

	public ObjAsegResponsabilidad addObjAsegResponsabilidad(ObjAsegResponsabilidad objAsegResponsabilidad) {
		getObjAsegResponsabilidads().add(objAsegResponsabilidad);
		objAsegResponsabilidad.setRamoResponsabilidadCivil(this);

		return objAsegResponsabilidad;
	}

	public ObjAsegResponsabilidad removeObjAsegResponsabilidad(ObjAsegResponsabilidad objAsegResponsabilidad) {
		getObjAsegResponsabilidads().remove(objAsegResponsabilidad);
		objAsegResponsabilidad.setRamoResponsabilidadCivil(null);

		return objAsegResponsabilidad;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}