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
 * The persistent class for the ramo_transporte database table.
 * 
 */
@Entity
@Table(name = "ramo_transporte")
@NamedQuery(name = "RamoTransporte.findAll", query = "SELECT r FROM RamoTransporte r")
public class RamoTransporte extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transporte")
	private Integer idTransporte;

	@Column(name = "cond_importantes_transporte")
	private String condImportantesTransporte;

	@Column(name = "embarque_trans")
	private BigDecimal embarqueTrans;

	@Column(name = "minimo_embarque_trans")
	private BigDecimal minimoEmbarqueTrans;

	@Column(name = "minimo_siniestro_trans")
	private BigDecimal minimoSiniestroTrans;

	@Column(name = "siniestro_trans")
	private BigDecimal siniestroTrans;

	@Column(name = "tasa_transporte")
	private BigDecimal tasaTransporte;

	// bi-directional many-to-one association to ClausulasAddTran
	@OneToMany(mappedBy = "ramoTransporte")
	private List<ClausulasAddTran> clausulasAddTrans;

	// bi-directional many-to-one association to CobertTran
	@OneToMany(mappedBy = "ramoTransporte")
	private List<CobertTran> cobertTrans;

	// bi-directional many-to-one association to CondEspTran
	@OneToMany(mappedBy = "ramoTransporte")
	private List<CondEspTran> condEspTrans;

	// bi-directional many-to-one association to ObjAsegTransporte
	@OneToMany(mappedBy = "ramoTransporte")
	private List<ObjAsegTransporte> objAsegTransportes;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoTransporte() {
	}

	public Integer getIdTransporte() {
		return this.idTransporte;
	}

	public void setIdTransporte(Integer idTransporte) {
		this.idTransporte = idTransporte;
	}

	public String getCondImportantesTransporte() {
		return this.condImportantesTransporte;
	}

	public void setCondImportantesTransporte(String condImportantesTransporte) {
		this.condImportantesTransporte = condImportantesTransporte;
	}

	public BigDecimal getEmbarqueTrans() {
		return this.embarqueTrans;
	}

	public void setEmbarqueTrans(BigDecimal embarqueTrans) {
		this.embarqueTrans = embarqueTrans;
	}

	public BigDecimal getMinimoEmbarqueTrans() {
		return this.minimoEmbarqueTrans;
	}

	public void setMinimoEmbarqueTrans(BigDecimal minimoEmbarqueTrans) {
		this.minimoEmbarqueTrans = minimoEmbarqueTrans;
	}

	public BigDecimal getMinimoSiniestroTrans() {
		return this.minimoSiniestroTrans;
	}

	public void setMinimoSiniestroTrans(BigDecimal minimoSiniestroTrans) {
		this.minimoSiniestroTrans = minimoSiniestroTrans;
	}

	public BigDecimal getSiniestroTrans() {
		return this.siniestroTrans;
	}

	public void setSiniestroTrans(BigDecimal siniestroTrans) {
		this.siniestroTrans = siniestroTrans;
	}

	public BigDecimal getTasaTransporte() {
		return this.tasaTransporte;
	}

	public void setTasaTransporte(BigDecimal tasaTransporte) {
		this.tasaTransporte = tasaTransporte;
	}

	public List<ClausulasAddTran> getClausulasAddTrans() {
		return this.clausulasAddTrans;
	}

	public void setClausulasAddTrans(List<ClausulasAddTran> clausulasAddTrans) {
		this.clausulasAddTrans = clausulasAddTrans;
	}

	public ClausulasAddTran addClausulasAddTran(ClausulasAddTran clausulasAddTran) {
		getClausulasAddTrans().add(clausulasAddTran);
		clausulasAddTran.setRamoTransporte(this);

		return clausulasAddTran;
	}

	public ClausulasAddTran removeClausulasAddTran(ClausulasAddTran clausulasAddTran) {
		getClausulasAddTrans().remove(clausulasAddTran);
		clausulasAddTran.setRamoTransporte(null);

		return clausulasAddTran;
	}

	public List<CobertTran> getCobertTrans() {
		return this.cobertTrans;
	}

	public void setCobertTrans(List<CobertTran> cobertTrans) {
		this.cobertTrans = cobertTrans;
	}

	public CobertTran addCobertTran(CobertTran cobertTran) {
		getCobertTrans().add(cobertTran);
		cobertTran.setRamoTransporte(this);

		return cobertTran;
	}

	public CobertTran removeCobertTran(CobertTran cobertTran) {
		getCobertTrans().remove(cobertTran);
		cobertTran.setRamoTransporte(null);

		return cobertTran;
	}

	public List<CondEspTran> getCondEspTrans() {
		return this.condEspTrans;
	}

	public void setCondEspTrans(List<CondEspTran> condEspTrans) {
		this.condEspTrans = condEspTrans;
	}

	public CondEspTran addCondEspTran(CondEspTran condEspTran) {
		getCondEspTrans().add(condEspTran);
		condEspTran.setRamoTransporte(this);

		return condEspTran;
	}

	public CondEspTran removeCondEspTran(CondEspTran condEspTran) {
		getCondEspTrans().remove(condEspTran);
		condEspTran.setRamoTransporte(null);

		return condEspTran;
	}

	public List<ObjAsegTransporte> getObjAsegTransportes() {
		return this.objAsegTransportes;
	}

	public void setObjAsegTransportes(List<ObjAsegTransporte> objAsegTransportes) {
		this.objAsegTransportes = objAsegTransportes;
	}

	public ObjAsegTransporte addObjAsegTransporte(ObjAsegTransporte objAsegTransporte) {
		getObjAsegTransportes().add(objAsegTransporte);
		objAsegTransporte.setRamoTransporte(this);

		return objAsegTransporte;
	}

	public ObjAsegTransporte removeObjAsegTransporte(ObjAsegTransporte objAsegTransporte) {
		getObjAsegTransportes().remove(objAsegTransporte);
		objAsegTransporte.setRamoTransporte(null);

		return objAsegTransporte;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}