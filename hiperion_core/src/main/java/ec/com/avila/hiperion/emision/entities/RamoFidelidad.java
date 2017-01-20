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
 * The persistent class for the ramo_fidelidad database table.
 * 
 */
@Entity
@Table(name = "ramo_fidelidad")
@NamedQuery(name = "RamoFidelidad.findAll", query = "SELECT r FROM RamoFidelidad r")
public class RamoFidelidad extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fidelidad")
	private Integer idFidelidad;

	@Column(name = "deduc_minimo_fidelidad")
	private BigDecimal deducMinimoFidelidad;

	@Column(name = "deduc_siniestro_fidelidad")
	private BigDecimal deducSiniestroFidelidad;

	@Column(name = "sector_fidelidad")
	private String sectorFidelidad;

	@Column(name = "tasa_fidelidad")
	private BigDecimal tasaFidelidad;

	@Column(name = "valor_colusorio")
	private BigDecimal valorColusorio;

	@Column(name = "valor_individual")
	private BigDecimal valorIndividual;

	// bi-directional many-to-one association to ClausulasAddFidelidad
	@OneToMany(mappedBy = "ramoFidelidad")
	private List<ClausulasAddFidelidad> clausulasAddFidelidads;

	// bi-directional many-to-one association to CobertFidelidad
	@OneToMany(mappedBy = "ramoFidelidad")
	private List<CobertFidelidad> cobertFidelidads;

	// bi-directional many-to-one association to ObjAsegFidelidad
	@OneToMany(mappedBy = "ramoFidelidad")
	private List<ObjAsegFidelidad> objAsegFidelidads;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoFidelidad() {
	}

	public Integer getIdFidelidad() {
		return this.idFidelidad;
	}

	public void setIdFidelidad(Integer idFidelidad) {
		this.idFidelidad = idFidelidad;
	}

	public BigDecimal getDeducMinimoFidelidad() {
		return this.deducMinimoFidelidad;
	}

	public void setDeducMinimoFidelidad(BigDecimal deducMinimoFidelidad) {
		this.deducMinimoFidelidad = deducMinimoFidelidad;
	}

	public BigDecimal getDeducSiniestroFidelidad() {
		return this.deducSiniestroFidelidad;
	}

	public void setDeducSiniestroFidelidad(BigDecimal deducSiniestroFidelidad) {
		this.deducSiniestroFidelidad = deducSiniestroFidelidad;
	}

	public String getSectorFidelidad() {
		return this.sectorFidelidad;
	}

	public void setSectorFidelidad(String sectorFidelidad) {
		this.sectorFidelidad = sectorFidelidad;
	}

	public BigDecimal getTasaFidelidad() {
		return this.tasaFidelidad;
	}

	public void setTasaFidelidad(BigDecimal tasaFidelidad) {
		this.tasaFidelidad = tasaFidelidad;
	}

	public BigDecimal getValorColusorio() {
		return this.valorColusorio;
	}

	public void setValorColusorio(BigDecimal valorColusorio) {
		this.valorColusorio = valorColusorio;
	}

	public BigDecimal getValorIndividual() {
		return this.valorIndividual;
	}

	public void setValorIndividual(BigDecimal valorIndividual) {
		this.valorIndividual = valorIndividual;
	}

	public List<ClausulasAddFidelidad> getClausulasAddFidelidads() {
		return this.clausulasAddFidelidads;
	}

	public void setClausulasAddFidelidads(List<ClausulasAddFidelidad> clausulasAddFidelidads) {
		this.clausulasAddFidelidads = clausulasAddFidelidads;
	}

	public ClausulasAddFidelidad addClausulasAddFidelidad(ClausulasAddFidelidad clausulasAddFidelidad) {
		getClausulasAddFidelidads().add(clausulasAddFidelidad);
		clausulasAddFidelidad.setRamoFidelidad(this);

		return clausulasAddFidelidad;
	}

	public ClausulasAddFidelidad removeClausulasAddFidelidad(ClausulasAddFidelidad clausulasAddFidelidad) {
		getClausulasAddFidelidads().remove(clausulasAddFidelidad);
		clausulasAddFidelidad.setRamoFidelidad(null);

		return clausulasAddFidelidad;
	}

	public List<CobertFidelidad> getCobertFidelidads() {
		return this.cobertFidelidads;
	}

	public void setCobertFidelidads(List<CobertFidelidad> cobertFidelidads) {
		this.cobertFidelidads = cobertFidelidads;
	}

	public CobertFidelidad addCobertFidelidad(CobertFidelidad cobertFidelidad) {
		getCobertFidelidads().add(cobertFidelidad);
		cobertFidelidad.setRamoFidelidad(this);

		return cobertFidelidad;
	}

	public CobertFidelidad removeCobertFidelidad(CobertFidelidad cobertFidelidad) {
		getCobertFidelidads().remove(cobertFidelidad);
		cobertFidelidad.setRamoFidelidad(null);

		return cobertFidelidad;
	}

	public List<ObjAsegFidelidad> getObjAsegFidelidads() {
		return this.objAsegFidelidads;
	}

	public void setObjAsegFidelidads(List<ObjAsegFidelidad> objAsegFidelidads) {
		this.objAsegFidelidads = objAsegFidelidads;
	}

	public ObjAsegFidelidad addObjAsegFidelidad(ObjAsegFidelidad objAsegFidelidad) {
		getObjAsegFidelidads().add(objAsegFidelidad);
		objAsegFidelidad.setRamoFidelidad(this);

		return objAsegFidelidad;
	}

	public ObjAsegFidelidad removeObjAsegFidelidad(ObjAsegFidelidad objAsegFidelidad) {
		getObjAsegFidelidads().remove(objAsegFidelidad);
		objAsegFidelidad.setRamoFidelidad(null);

		return objAsegFidelidad;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}