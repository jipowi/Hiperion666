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
 * The persistent class for the ramo_riesgo_contratista database table.
 * 
 */
@Entity
@Table(name = "ramo_riesgo_contratista")
@NamedQuery(name = "RamoRiesgoContratista.findAll", query = "SELECT r FROM RamoRiesgoContratista r")
public class RamoRiesgoContratista extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contratista")
	private Integer idContratista;

	@Column(name = "amparo_a_contratista")
	private BigDecimal amparoAContratista;

	@Column(name = "amparo_b_contratista")
	private BigDecimal amparoBContratista;

	@Column(name = "amparo_c_contratista")
	private BigDecimal amparoCContratista;

	@Column(name = "amparo_d_contratista")
	private BigDecimal amparoDContratista;

	@Column(name = "amparo_g_contratista")
	private BigDecimal amparoGContratista;

	@Column(name = "doc_cronograma_contratista")
	private String docCronogramaContratista;

	@Column(name = "doc_estudio_contratista")
	private String docEstudioContratista;

	@Column(name = "doc_formulario_contratista")
	private String docFormularioContratista;

	@Column(name = "minimo_amparo_a")
	private BigDecimal minimoAmparoA;

	@Column(name = "minimo_amparo_b")
	private BigDecimal minimoAmparoB;

	@Column(name = "minimo_amparo_c")
	private BigDecimal minimoAmparoC;

	@Column(name = "minimo_amparo_d")
	private BigDecimal minimoAmparoD;

	@Column(name = "minimo_amparo_g")
	private BigDecimal minimoAmparoG;

	@Column(name = "period_construccion_contratista")
	private Integer periodConstruccionContratista;

	@Column(name = "period_mant_contratista")
	private Integer periodMantContratista;

	@Column(name = "tasa_perid_const")
	private BigDecimal tasaPeridConst;

	// bi-directional many-to-one association to ClausulasAddContratista
	@OneToMany(mappedBy = "ramoRiesgoContratista")
	private List<ClausulasAddContratista> clausulasAddContratistas;

	// bi-directional many-to-one association to CobertContratista
	@OneToMany(mappedBy = "ramoRiesgoContratista")
	private List<CobertContratista> cobertContratistas;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoRiesgoContratista() {
	}

	public Integer getIdContratista() {
		return this.idContratista;
	}

	public void setIdContratista(Integer idContratista) {
		this.idContratista = idContratista;
	}

	public BigDecimal getAmparoAContratista() {
		return this.amparoAContratista;
	}

	public void setAmparoAContratista(BigDecimal amparoAContratista) {
		this.amparoAContratista = amparoAContratista;
	}

	public BigDecimal getAmparoBContratista() {
		return this.amparoBContratista;
	}

	public void setAmparoBContratista(BigDecimal amparoBContratista) {
		this.amparoBContratista = amparoBContratista;
	}

	public BigDecimal getAmparoCContratista() {
		return this.amparoCContratista;
	}

	public void setAmparoCContratista(BigDecimal amparoCContratista) {
		this.amparoCContratista = amparoCContratista;
	}

	public BigDecimal getAmparoDContratista() {
		return this.amparoDContratista;
	}

	public void setAmparoDContratista(BigDecimal amparoDContratista) {
		this.amparoDContratista = amparoDContratista;
	}

	public BigDecimal getAmparoGContratista() {
		return this.amparoGContratista;
	}

	public void setAmparoGContratista(BigDecimal amparoGContratista) {
		this.amparoGContratista = amparoGContratista;
	}

	public String getDocCronogramaContratista() {
		return this.docCronogramaContratista;
	}

	public void setDocCronogramaContratista(String docCronogramaContratista) {
		this.docCronogramaContratista = docCronogramaContratista;
	}

	public String getDocEstudioContratista() {
		return this.docEstudioContratista;
	}

	public void setDocEstudioContratista(String docEstudioContratista) {
		this.docEstudioContratista = docEstudioContratista;
	}

	public String getDocFormularioContratista() {
		return this.docFormularioContratista;
	}

	public void setDocFormularioContratista(String docFormularioContratista) {
		this.docFormularioContratista = docFormularioContratista;
	}

	public BigDecimal getMinimoAmparoA() {
		return this.minimoAmparoA;
	}

	public void setMinimoAmparoA(BigDecimal minimoAmparoA) {
		this.minimoAmparoA = minimoAmparoA;
	}

	public BigDecimal getMinimoAmparoB() {
		return this.minimoAmparoB;
	}

	public void setMinimoAmparoB(BigDecimal minimoAmparoB) {
		this.minimoAmparoB = minimoAmparoB;
	}

	public BigDecimal getMinimoAmparoC() {
		return this.minimoAmparoC;
	}

	public void setMinimoAmparoC(BigDecimal minimoAmparoC) {
		this.minimoAmparoC = minimoAmparoC;
	}

	public BigDecimal getMinimoAmparoD() {
		return this.minimoAmparoD;
	}

	public void setMinimoAmparoD(BigDecimal minimoAmparoD) {
		this.minimoAmparoD = minimoAmparoD;
	}

	public BigDecimal getMinimoAmparoG() {
		return this.minimoAmparoG;
	}

	public void setMinimoAmparoG(BigDecimal minimoAmparoG) {
		this.minimoAmparoG = minimoAmparoG;
	}

	public Integer getPeriodConstruccionContratista() {
		return this.periodConstruccionContratista;
	}

	public void setPeriodConstruccionContratista(Integer periodConstruccionContratista) {
		this.periodConstruccionContratista = periodConstruccionContratista;
	}

	public Integer getPeriodMantContratista() {
		return this.periodMantContratista;
	}

	public void setPeriodMantContratista(Integer periodMantContratista) {
		this.periodMantContratista = periodMantContratista;
	}

	public BigDecimal getTasaPeridConst() {
		return this.tasaPeridConst;
	}

	public void setTasaPeridConst(BigDecimal tasaPeridConst) {
		this.tasaPeridConst = tasaPeridConst;
	}

	public List<ClausulasAddContratista> getClausulasAddContratistas() {
		return this.clausulasAddContratistas;
	}

	public void setClausulasAddContratistas(List<ClausulasAddContratista> clausulasAddContratistas) {
		this.clausulasAddContratistas = clausulasAddContratistas;
	}

	public ClausulasAddContratista addClausulasAddContratista(ClausulasAddContratista clausulasAddContratista) {
		getClausulasAddContratistas().add(clausulasAddContratista);
		clausulasAddContratista.setRamoRiesgoContratista(this);

		return clausulasAddContratista;
	}

	public ClausulasAddContratista removeClausulasAddContratista(ClausulasAddContratista clausulasAddContratista) {
		getClausulasAddContratistas().remove(clausulasAddContratista);
		clausulasAddContratista.setRamoRiesgoContratista(null);

		return clausulasAddContratista;
	}

	public List<CobertContratista> getCobertContratistas() {
		return this.cobertContratistas;
	}

	public void setCobertContratistas(List<CobertContratista> cobertContratistas) {
		this.cobertContratistas = cobertContratistas;
	}

	public CobertContratista addCobertContratista(CobertContratista cobertContratista) {
		getCobertContratistas().add(cobertContratista);
		cobertContratista.setRamoRiesgoContratista(this);

		return cobertContratista;
	}

	public CobertContratista removeCobertContratista(CobertContratista cobertContratista) {
		getCobertContratistas().remove(cobertContratista);
		cobertContratista.setRamoRiesgoContratista(null);

		return cobertContratista;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}