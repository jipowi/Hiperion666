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
 * The persistent class for the ramo_riesgo_montaje database table.
 * 
 */
@Entity
@Table(name = "ramo_riesgo_montaje")
@NamedQuery(name = "RamoRiesgoMontaje.findAll", query = "SELECT r FROM RamoRiesgoMontaje r")
public class RamoRiesgoMontaje extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_riesgo_montaje")
	private Integer idRiesgoMontaje;

	@Column(name = "amparo_a_montaje")
	private BigDecimal amparoAMontaje;

	@Column(name = "amparo_b_montaje")
	private BigDecimal amparoBMontaje;

	@Column(name = "amparo_c_montaje")
	private BigDecimal amparoCMontaje;

	@Column(name = "amparo_d_montaje")
	private BigDecimal amparoDMontaje;

	@Column(name = "amparo_g_montaje")
	private BigDecimal amparoGMontaje;

	@Column(name = "doc_cronograma_montaje")
	private String docCronogramaMontaje;

	@Column(name = "doc_estudio_montaje")
	private String docEstudioMontaje;

	@Column(name = "doc_formulario_montje")
	private String docFormularioMontje;

	@Column(name = "minimo_amparo_a_montaje")
	private BigDecimal minimoAmparoAMontaje;

	@Column(name = "minimo_amparo_b_montaje")
	private BigDecimal minimoAmparoBMontaje;

	@Column(name = "minimo_amparo_c_montaje")
	private BigDecimal minimoAmparoCMontaje;

	@Column(name = "minimo_amparo_d_montaje")
	private BigDecimal minimoAmparoDMontaje;

	@Column(name = "minimo_amparo_g_montaje")
	private BigDecimal minimoAmparoGMontaje;

	@Column(name = "periodo_construc_montaje")
	private Integer periodoConstrucMontaje;

	@Column(name = "periodo_mant_montaje")
	private Integer periodoMantMontaje;

	@Column(name = "tasa_montaje")
	private BigDecimal tasaMontaje;

	// bi-directional many-to-one association to ClausulasAddMontaje
	@OneToMany(mappedBy = "ramoRiesgoMontaje")
	private List<ClausulasAddMontaje> clausulasAddMontajes;

	// bi-directional many-to-one association to CobertMontaje
	@OneToMany(mappedBy = "ramoRiesgoMontaje")
	private List<CobertMontaje> cobertMontajes;

	// bi-directional many-to-one association to ObjAsegMontaje
	@OneToMany(mappedBy = "ramoRiesgoMontaje")
	private List<ObjAsegMontaje> objAsegMontajes;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoRiesgoMontaje() {
	}

	public Integer getIdRiesgoMontaje() {
		return this.idRiesgoMontaje;
	}

	public void setIdRiesgoMontaje(Integer idRiesgoMontaje) {
		this.idRiesgoMontaje = idRiesgoMontaje;
	}

	public BigDecimal getAmparoAMontaje() {
		return this.amparoAMontaje;
	}

	public void setAmparoAMontaje(BigDecimal amparoAMontaje) {
		this.amparoAMontaje = amparoAMontaje;
	}

	public BigDecimal getAmparoBMontaje() {
		return this.amparoBMontaje;
	}

	public void setAmparoBMontaje(BigDecimal amparoBMontaje) {
		this.amparoBMontaje = amparoBMontaje;
	}

	public BigDecimal getAmparoCMontaje() {
		return this.amparoCMontaje;
	}

	public void setAmparoCMontaje(BigDecimal amparoCMontaje) {
		this.amparoCMontaje = amparoCMontaje;
	}

	public BigDecimal getAmparoDMontaje() {
		return this.amparoDMontaje;
	}

	public void setAmparoDMontaje(BigDecimal amparoDMontaje) {
		this.amparoDMontaje = amparoDMontaje;
	}

	public BigDecimal getAmparoGMontaje() {
		return this.amparoGMontaje;
	}

	public void setAmparoGMontaje(BigDecimal amparoGMontaje) {
		this.amparoGMontaje = amparoGMontaje;
	}

	public String getDocCronogramaMontaje() {
		return this.docCronogramaMontaje;
	}

	public void setDocCronogramaMontaje(String docCronogramaMontaje) {
		this.docCronogramaMontaje = docCronogramaMontaje;
	}

	public String getDocEstudioMontaje() {
		return this.docEstudioMontaje;
	}

	public void setDocEstudioMontaje(String docEstudioMontaje) {
		this.docEstudioMontaje = docEstudioMontaje;
	}

	public String getDocFormularioMontje() {
		return this.docFormularioMontje;
	}

	public void setDocFormularioMontje(String docFormularioMontje) {
		this.docFormularioMontje = docFormularioMontje;
	}

	public BigDecimal getMinimoAmparoAMontaje() {
		return this.minimoAmparoAMontaje;
	}

	public void setMinimoAmparoAMontaje(BigDecimal minimoAmparoAMontaje) {
		this.minimoAmparoAMontaje = minimoAmparoAMontaje;
	}

	public BigDecimal getMinimoAmparoBMontaje() {
		return this.minimoAmparoBMontaje;
	}

	public void setMinimoAmparoBMontaje(BigDecimal minimoAmparoBMontaje) {
		this.minimoAmparoBMontaje = minimoAmparoBMontaje;
	}

	public BigDecimal getMinimoAmparoCMontaje() {
		return this.minimoAmparoCMontaje;
	}

	public void setMinimoAmparoCMontaje(BigDecimal minimoAmparoCMontaje) {
		this.minimoAmparoCMontaje = minimoAmparoCMontaje;
	}

	public BigDecimal getMinimoAmparoDMontaje() {
		return this.minimoAmparoDMontaje;
	}

	public void setMinimoAmparoDMontaje(BigDecimal minimoAmparoDMontaje) {
		this.minimoAmparoDMontaje = minimoAmparoDMontaje;
	}

	public BigDecimal getMinimoAmparoGMontaje() {
		return this.minimoAmparoGMontaje;
	}

	public void setMinimoAmparoGMontaje(BigDecimal minimoAmparoGMontaje) {
		this.minimoAmparoGMontaje = minimoAmparoGMontaje;
	}

	public Integer getPeriodoConstrucMontaje() {
		return this.periodoConstrucMontaje;
	}

	public void setPeriodoConstrucMontaje(Integer periodoConstrucMontaje) {
		this.periodoConstrucMontaje = periodoConstrucMontaje;
	}

	public Integer getPeriodoMantMontaje() {
		return this.periodoMantMontaje;
	}

	public void setPeriodoMantMontaje(Integer periodoMantMontaje) {
		this.periodoMantMontaje = periodoMantMontaje;
	}

	public BigDecimal getTasaMontaje() {
		return this.tasaMontaje;
	}

	public void setTasaMontaje(BigDecimal tasaMontaje) {
		this.tasaMontaje = tasaMontaje;
	}

	public List<ClausulasAddMontaje> getClausulasAddMontajes() {
		return this.clausulasAddMontajes;
	}

	public void setClausulasAddMontajes(List<ClausulasAddMontaje> clausulasAddMontajes) {
		this.clausulasAddMontajes = clausulasAddMontajes;
	}

	public ClausulasAddMontaje addClausulasAddMontaje(ClausulasAddMontaje clausulasAddMontaje) {
		getClausulasAddMontajes().add(clausulasAddMontaje);
		clausulasAddMontaje.setRamoRiesgoMontaje(this);

		return clausulasAddMontaje;
	}

	public ClausulasAddMontaje removeClausulasAddMontaje(ClausulasAddMontaje clausulasAddMontaje) {
		getClausulasAddMontajes().remove(clausulasAddMontaje);
		clausulasAddMontaje.setRamoRiesgoMontaje(null);

		return clausulasAddMontaje;
	}

	public List<CobertMontaje> getCobertMontajes() {
		return this.cobertMontajes;
	}

	public void setCobertMontajes(List<CobertMontaje> cobertMontajes) {
		this.cobertMontajes = cobertMontajes;
	}

	public CobertMontaje addCobertMontaje(CobertMontaje cobertMontaje) {
		getCobertMontajes().add(cobertMontaje);
		cobertMontaje.setRamoRiesgoMontaje(this);

		return cobertMontaje;
	}

	public CobertMontaje removeCobertMontaje(CobertMontaje cobertMontaje) {
		getCobertMontajes().remove(cobertMontaje);
		cobertMontaje.setRamoRiesgoMontaje(null);

		return cobertMontaje;
	}

	public List<ObjAsegMontaje> getObjAsegMontajes() {
		return this.objAsegMontajes;
	}

	public void setObjAsegMontajes(List<ObjAsegMontaje> objAsegMontajes) {
		this.objAsegMontajes = objAsegMontajes;
	}

	public ObjAsegMontaje addObjAsegMontaje(ObjAsegMontaje objAsegMontaje) {
		getObjAsegMontajes().add(objAsegMontaje);
		objAsegMontaje.setRamoRiesgoMontaje(this);

		return objAsegMontaje;
	}

	public ObjAsegMontaje removeObjAsegMontaje(ObjAsegMontaje objAsegMontaje) {
		getObjAsegMontajes().remove(objAsegMontaje);
		objAsegMontaje.setRamoRiesgoMontaje(null);

		return objAsegMontaje;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}