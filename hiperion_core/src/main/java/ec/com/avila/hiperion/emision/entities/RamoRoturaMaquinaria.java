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
 * The persistent class for the ramo_rotura_maquinaria database table.
 * 
 */
@Entity
@Table(name = "ramo_rotura_maquinaria")
@NamedQuery(name = "RamoRoturaMaquinaria.findAll", query = "SELECT r FROM RamoRoturaMaquinaria r")
public class RamoRoturaMaquinaria extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rotura")
	private Integer idRotura;

	@Column(name = "deduc_minimo_aseg_rot_maq")
	private BigDecimal deducMinimoAsegRotMaq;

	@Column(name = "deduc_minimo_siniestro_rot")
	private BigDecimal deducMinimoSiniestroRot;

	@Column(name = "deduc_siniestro_rot_maq")
	private BigDecimal deducSiniestroRotMaq;

	@Column(name = "tasa_rot_maq")
	private BigDecimal tasaRotMaq;

	// bi-directional many-to-one association to ClausulasAddRotura
	@OneToMany(mappedBy = "ramoRoturaMaquinaria")
	private List<ClausulasAddRotura> clausulasAddRoturas;

	// bi-directional many-to-one association to CobertAddRotura
	@OneToMany(mappedBy = "ramoRoturaMaquinaria")
	private List<CobertAddRotura> cobertAddRoturas;

	// bi-directional many-to-one association to CobertRotura
	@OneToMany(mappedBy = "ramoRoturaMaquinaria")
	private List<CobertRotura> cobertRoturas;

	// bi-directional many-to-one association to ObjAsegRotura
	@OneToMany(mappedBy = "ramoRoturaMaquinaria")
	private List<ObjAsegRotura> objAsegRoturas;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoRoturaMaquinaria() {
	}

	public Integer getIdRotura() {
		return this.idRotura;
	}

	public void setIdRotura(Integer idRotura) {
		this.idRotura = idRotura;
	}

	public BigDecimal getDeducMinimoAsegRotMaq() {
		return this.deducMinimoAsegRotMaq;
	}

	public void setDeducMinimoAsegRotMaq(BigDecimal deducMinimoAsegRotMaq) {
		this.deducMinimoAsegRotMaq = deducMinimoAsegRotMaq;
	}

	public BigDecimal getDeducMinimoSiniestroRot() {
		return this.deducMinimoSiniestroRot;
	}

	public void setDeducMinimoSiniestroRot(BigDecimal deducMinimoSiniestroRot) {
		this.deducMinimoSiniestroRot = deducMinimoSiniestroRot;
	}

	public BigDecimal getDeducSiniestroRotMaq() {
		return this.deducSiniestroRotMaq;
	}

	public void setDeducSiniestroRotMaq(BigDecimal deducSiniestroRotMaq) {
		this.deducSiniestroRotMaq = deducSiniestroRotMaq;
	}

	public BigDecimal getTasaRotMaq() {
		return this.tasaRotMaq;
	}

	public void setTasaRotMaq(BigDecimal tasaRotMaq) {
		this.tasaRotMaq = tasaRotMaq;
	}

	public List<ClausulasAddRotura> getClausulasAddRoturas() {
		return this.clausulasAddRoturas;
	}

	public void setClausulasAddRoturas(List<ClausulasAddRotura> clausulasAddRoturas) {
		this.clausulasAddRoturas = clausulasAddRoturas;
	}

	public ClausulasAddRotura addClausulasAddRotura(ClausulasAddRotura clausulasAddRotura) {
		getClausulasAddRoturas().add(clausulasAddRotura);
		clausulasAddRotura.setRamoRoturaMaquinaria(this);

		return clausulasAddRotura;
	}

	public ClausulasAddRotura removeClausulasAddRotura(ClausulasAddRotura clausulasAddRotura) {
		getClausulasAddRoturas().remove(clausulasAddRotura);
		clausulasAddRotura.setRamoRoturaMaquinaria(null);

		return clausulasAddRotura;
	}

	public List<CobertAddRotura> getCobertAddRoturas() {
		return this.cobertAddRoturas;
	}

	public void setCobertAddRoturas(List<CobertAddRotura> cobertAddRoturas) {
		this.cobertAddRoturas = cobertAddRoturas;
	}

	public CobertAddRotura addCobertAddRotura(CobertAddRotura cobertAddRotura) {
		getCobertAddRoturas().add(cobertAddRotura);
		cobertAddRotura.setRamoRoturaMaquinaria(this);

		return cobertAddRotura;
	}

	public CobertAddRotura removeCobertAddRotura(CobertAddRotura cobertAddRotura) {
		getCobertAddRoturas().remove(cobertAddRotura);
		cobertAddRotura.setRamoRoturaMaquinaria(null);

		return cobertAddRotura;
	}

	public List<CobertRotura> getCobertRoturas() {
		return this.cobertRoturas;
	}

	public void setCobertRoturas(List<CobertRotura> cobertRoturas) {
		this.cobertRoturas = cobertRoturas;
	}

	public CobertRotura addCobertRotura(CobertRotura cobertRotura) {
		getCobertRoturas().add(cobertRotura);
		cobertRotura.setRamoRoturaMaquinaria(this);

		return cobertRotura;
	}

	public CobertRotura removeCobertRotura(CobertRotura cobertRotura) {
		getCobertRoturas().remove(cobertRotura);
		cobertRotura.setRamoRoturaMaquinaria(null);

		return cobertRotura;
	}

	public List<ObjAsegRotura> getObjAsegRoturas() {
		return this.objAsegRoturas;
	}

	public void setObjAsegRoturas(List<ObjAsegRotura> objAsegRoturas) {
		this.objAsegRoturas = objAsegRoturas;
	}

	public ObjAsegRotura addObjAsegRotura(ObjAsegRotura objAsegRotura) {
		getObjAsegRoturas().add(objAsegRotura);
		objAsegRotura.setRamoRoturaMaquinaria(this);

		return objAsegRotura;
	}

	public ObjAsegRotura removeObjAsegRotura(ObjAsegRotura objAsegRotura) {
		getObjAsegRoturas().remove(objAsegRotura);
		objAsegRotura.setRamoRoturaMaquinaria(null);

		return objAsegRotura;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}