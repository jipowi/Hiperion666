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
 * The persistent class for the ramo_incendio_lineas_aliadas database table.
 * 
 */
@Entity
@Table(name="ramo_incendio_lineas_aliadas")
@NamedQuery(name="RamoIncendioLineasAliada.findAll", query="SELECT r FROM RamoIncendioLineasAliada r")
public class RamoIncendioLineasAliada extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_incendio")
	private Integer idIncendio;

	@Column(name="consideraciones_imp_incendio")
	private String consideracionesImpIncendio;

	@Column(name="deduc_lluvia")
	private BigDecimal deducLluvia;

	@Column(name="deduc_minimo_lluvia")
	private BigDecimal deducMinimoLluvia;

	@Column(name="deduc_minimo_otros")
	private BigDecimal deducMinimoOtros;

	@Column(name="deduc_minimo_terremoto")
	private BigDecimal deducMinimoTerremoto;

	@Column(name="deduc_minimo_vidrios")
	private BigDecimal deducMinimoVidrios;

	@Column(name="deduc_otros")
	private BigDecimal deducOtros;

	@Column(name="deduc_terremoto")
	private BigDecimal deducTerremoto;

	@Column(name="deduc_vidrios")
	private BigDecimal deducVidrios;


	@Column(name="tasa_autoexplosion")
	private BigDecimal tasaAutoexplosion;

	@Column(name="tasa_cla_electrica")
	private BigDecimal tasaClaElectrica;

	@Column(name="tasa_comprensiva_incendio")
	private BigDecimal tasaComprensivaIncendio;

	@Column(name="tasa_documentos")
	private BigDecimal tasaDocumentos;

	@Column(name="tasa_honorarios")
	private BigDecimal tasaHonorarios;

	@Column(name="tasa_remocion")
	private BigDecimal tasaRemocion;

	@Column(name="tasa_vidrios")
	private BigDecimal tasaVidrios;

	@Column(name="valor_items_incendio")
	private BigDecimal valorItemsIncendio;

	//bi-directional many-to-one association to ClausulasAddIncendio
	@OneToMany(mappedBy="ramoIncendioLineasAliada")
	private List<ClausulasAddIncendio> clausulasAddIncendios;

	//bi-directional many-to-one association to CobertAddIncendio
	@OneToMany(mappedBy="ramoIncendioLineasAliada")
	private List<CobertAddIncendio> cobertAddIncendios;

	//bi-directional many-to-one association to CobertIncendio
	@OneToMany(mappedBy="ramoIncendioLineasAliada")
	private List<CobertIncendio> cobertIncendios;

	//bi-directional many-to-one association to CondEspIncendio
	@OneToMany(mappedBy="ramoIncendioLineasAliada")
	private List<CondEspIncendio> condEspIncendios;

	//bi-directional many-to-one association to ObjAsegIncendio
	@OneToMany(mappedBy="ramoIncendioLineasAliada")
	private List<ObjAsegIncendio> objAsegIncendios;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	public RamoIncendioLineasAliada() {
	}

	public Integer getIdIncendio() {
		return this.idIncendio;
	}

	public void setIdIncendio(Integer idIncendio) {
		this.idIncendio = idIncendio;
	}

	public String getConsideracionesImpIncendio() {
		return this.consideracionesImpIncendio;
	}

	public void setConsideracionesImpIncendio(String consideracionesImpIncendio) {
		this.consideracionesImpIncendio = consideracionesImpIncendio;
	}

	public BigDecimal getDeducLluvia() {
		return this.deducLluvia;
	}

	public void setDeducLluvia(BigDecimal deducLluvia) {
		this.deducLluvia = deducLluvia;
	}

	public BigDecimal getDeducMinimoLluvia() {
		return this.deducMinimoLluvia;
	}

	public void setDeducMinimoLluvia(BigDecimal deducMinimoLluvia) {
		this.deducMinimoLluvia = deducMinimoLluvia;
	}

	public BigDecimal getDeducMinimoOtros() {
		return this.deducMinimoOtros;
	}

	public void setDeducMinimoOtros(BigDecimal deducMinimoOtros) {
		this.deducMinimoOtros = deducMinimoOtros;
	}

	public BigDecimal getDeducMinimoTerremoto() {
		return this.deducMinimoTerremoto;
	}

	public void setDeducMinimoTerremoto(BigDecimal deducMinimoTerremoto) {
		this.deducMinimoTerremoto = deducMinimoTerremoto;
	}

	public BigDecimal getDeducMinimoVidrios() {
		return this.deducMinimoVidrios;
	}

	public void setDeducMinimoVidrios(BigDecimal deducMinimoVidrios) {
		this.deducMinimoVidrios = deducMinimoVidrios;
	}

	public BigDecimal getDeducOtros() {
		return this.deducOtros;
	}

	public void setDeducOtros(BigDecimal deducOtros) {
		this.deducOtros = deducOtros;
	}

	public BigDecimal getDeducTerremoto() {
		return this.deducTerremoto;
	}

	public void setDeducTerremoto(BigDecimal deducTerremoto) {
		this.deducTerremoto = deducTerremoto;
	}

	public BigDecimal getDeducVidrios() {
		return this.deducVidrios;
	}

	public void setDeducVidrios(BigDecimal deducVidrios) {
		this.deducVidrios = deducVidrios;
	}


	public BigDecimal getTasaAutoexplosion() {
		return this.tasaAutoexplosion;
	}

	public void setTasaAutoexplosion(BigDecimal tasaAutoexplosion) {
		this.tasaAutoexplosion = tasaAutoexplosion;
	}

	public BigDecimal getTasaClaElectrica() {
		return this.tasaClaElectrica;
	}

	public void setTasaClaElectrica(BigDecimal tasaClaElectrica) {
		this.tasaClaElectrica = tasaClaElectrica;
	}

	public BigDecimal getTasaComprensivaIncendio() {
		return this.tasaComprensivaIncendio;
	}

	public void setTasaComprensivaIncendio(BigDecimal tasaComprensivaIncendio) {
		this.tasaComprensivaIncendio = tasaComprensivaIncendio;
	}

	public BigDecimal getTasaDocumentos() {
		return this.tasaDocumentos;
	}

	public void setTasaDocumentos(BigDecimal tasaDocumentos) {
		this.tasaDocumentos = tasaDocumentos;
	}

	public BigDecimal getTasaHonorarios() {
		return this.tasaHonorarios;
	}

	public void setTasaHonorarios(BigDecimal tasaHonorarios) {
		this.tasaHonorarios = tasaHonorarios;
	}

	public BigDecimal getTasaRemocion() {
		return this.tasaRemocion;
	}

	public void setTasaRemocion(BigDecimal tasaRemocion) {
		this.tasaRemocion = tasaRemocion;
	}

	public BigDecimal getTasaVidrios() {
		return this.tasaVidrios;
	}

	public void setTasaVidrios(BigDecimal tasaVidrios) {
		this.tasaVidrios = tasaVidrios;
	}

	public BigDecimal getValorItemsIncendio() {
		return this.valorItemsIncendio;
	}

	public void setValorItemsIncendio(BigDecimal valorItemsIncendio) {
		this.valorItemsIncendio = valorItemsIncendio;
	}

	public List<ClausulasAddIncendio> getClausulasAddIncendios() {
		return this.clausulasAddIncendios;
	}

	public void setClausulasAddIncendios(List<ClausulasAddIncendio> clausulasAddIncendios) {
		this.clausulasAddIncendios = clausulasAddIncendios;
	}

	public ClausulasAddIncendio addClausulasAddIncendio(ClausulasAddIncendio clausulasAddIncendio) {
		getClausulasAddIncendios().add(clausulasAddIncendio);
		clausulasAddIncendio.setRamoIncendioLineasAliada(this);

		return clausulasAddIncendio;
	}

	public ClausulasAddIncendio removeClausulasAddIncendio(ClausulasAddIncendio clausulasAddIncendio) {
		getClausulasAddIncendios().remove(clausulasAddIncendio);
		clausulasAddIncendio.setRamoIncendioLineasAliada(null);

		return clausulasAddIncendio;
	}

	public List<CobertAddIncendio> getCobertAddIncendios() {
		return this.cobertAddIncendios;
	}

	public void setCobertAddIncendios(List<CobertAddIncendio> cobertAddIncendios) {
		this.cobertAddIncendios = cobertAddIncendios;
	}

	public CobertAddIncendio addCobertAddIncendio(CobertAddIncendio cobertAddIncendio) {
		getCobertAddIncendios().add(cobertAddIncendio);
		cobertAddIncendio.setRamoIncendioLineasAliada(this);

		return cobertAddIncendio;
	}

	public CobertAddIncendio removeCobertAddIncendio(CobertAddIncendio cobertAddIncendio) {
		getCobertAddIncendios().remove(cobertAddIncendio);
		cobertAddIncendio.setRamoIncendioLineasAliada(null);

		return cobertAddIncendio;
	}

	public List<CobertIncendio> getCobertIncendios() {
		return this.cobertIncendios;
	}

	public void setCobertIncendios(List<CobertIncendio> cobertIncendios) {
		this.cobertIncendios = cobertIncendios;
	}

	public CobertIncendio addCobertIncendio(CobertIncendio cobertIncendio) {
		getCobertIncendios().add(cobertIncendio);
		cobertIncendio.setRamoIncendioLineasAliada(this);

		return cobertIncendio;
	}

	public CobertIncendio removeCobertIncendio(CobertIncendio cobertIncendio) {
		getCobertIncendios().remove(cobertIncendio);
		cobertIncendio.setRamoIncendioLineasAliada(null);

		return cobertIncendio;
	}

	public List<CondEspIncendio> getCondEspIncendios() {
		return this.condEspIncendios;
	}

	public void setCondEspIncendios(List<CondEspIncendio> condEspIncendios) {
		this.condEspIncendios = condEspIncendios;
	}

	public CondEspIncendio addCondEspIncendio(CondEspIncendio condEspIncendio) {
		getCondEspIncendios().add(condEspIncendio);
		condEspIncendio.setRamoIncendioLineasAliada(this);

		return condEspIncendio;
	}

	public CondEspIncendio removeCondEspIncendio(CondEspIncendio condEspIncendio) {
		getCondEspIncendios().remove(condEspIncendio);
		condEspIncendio.setRamoIncendioLineasAliada(null);

		return condEspIncendio;
	}

	public List<ObjAsegIncendio> getObjAsegIncendios() {
		return this.objAsegIncendios;
	}

	public void setObjAsegIncendios(List<ObjAsegIncendio> objAsegIncendios) {
		this.objAsegIncendios = objAsegIncendios;
	}

	public ObjAsegIncendio addObjAsegIncendio(ObjAsegIncendio objAsegIncendio) {
		getObjAsegIncendios().add(objAsegIncendio);
		objAsegIncendio.setRamoIncendioLineasAliada(this);

		return objAsegIncendio;
	}

	public ObjAsegIncendio removeObjAsegIncendio(ObjAsegIncendio objAsegIncendio) {
		getObjAsegIncendios().remove(objAsegIncendio);
		objAsegIncendio.setRamoIncendioLineasAliada(null);

		return objAsegIncendio;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}