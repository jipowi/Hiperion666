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
 * The persistent class for the ramo_casco_aereo database table.
 * 
 */
@Entity
@Table(name = "ramo_casco_aereo")
@NamedQuery(name = "RamoCascoAereo.findAll", query = "SELECT r FROM RamoCascoAereo r")
public class RamoCascoAereo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_casco_aereo")
	private Integer idCascoAereo;

	@Column(name = "anio_construccion_aereo")
	private Integer anioConstruccionAereo;

	@Column(name = "deduc_minimo_siniestro_aereo")
	private BigDecimal deducMinimoSiniestroAereo;

	@Column(name = "deduc_siniestro_aereo")
	private BigDecimal deducSiniestroAereo;

	@Column(name = "horas_voladas")
	private Integer horasVoladas;

	@Column(name = "item_aereo")
	private Integer itemAereo;

	@Column(name = "marca_aereo")
	private String marcaAereo;

	@Column(name = "marca_motor_aereo")
	private String marcaMotorAereo;

	private String matricula;

	@Column(name = "maxima_carga_aereo")
	private BigDecimal maximaCargaAereo;

	@Column(name = "peso_maximo_aereo")
	private BigDecimal pesoMaximoAereo;

	@Column(name = "tasa_casco_aereo")
	private BigDecimal tasaCascoAereo;

	@Column(name = "tipo_modelo_aereo")
	private String tipoModeloAereo;

	@Column(name = "tipo_motor_aereo")
	private String tipoMotorAereo;

	@Column(name = "total_asegurado_aereo")
	private BigDecimal totalAseguradoAereo;

	@Column(name = "valor_casco_aereo")
	private BigDecimal valorCascoAereo;

	// bi-directional many-to-one association to ClausulasAddCascoAereo
	@OneToMany(mappedBy = "ramoCascoAereo")
	private List<ClausulasAddCascoAereo> clausulasAddCascoAereos;

	// bi-directional many-to-one association to CobertAddCascoAereo
	@OneToMany(mappedBy = "ramoCascoAereo")
	private List<CobertAddCascoAereo> cobertAddCascoAereos;

	// bi-directional many-to-one association to CobertCascoAereo
	@OneToMany(mappedBy = "ramoCascoAereo")
	private List<CobertCascoAereo> cobertCascoAereo;

	// bi-directional many-to-one association to ExtrasCascoAereo
	@OneToMany(mappedBy = "ramoCascoAereo")
	private List<ExtrasCascoAereo> extrasCascoAereos;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoCascoAereo() {
	}

	public Integer getIdCascoAereo() {
		return this.idCascoAereo;
	}

	public void setIdCascoAereo(Integer idCascoAereo) {
		this.idCascoAereo = idCascoAereo;
	}

	public Integer getAnioConstruccionAereo() {
		return this.anioConstruccionAereo;
	}

	public void setAnioConstruccionAereo(Integer anioConstruccionAereo) {
		this.anioConstruccionAereo = anioConstruccionAereo;
	}

	public BigDecimal getDeducMinimoSiniestroAereo() {
		return this.deducMinimoSiniestroAereo;
	}

	public void setDeducMinimoSiniestroAereo(BigDecimal deducMinimoSiniestroAereo) {
		this.deducMinimoSiniestroAereo = deducMinimoSiniestroAereo;
	}

	public BigDecimal getDeducSiniestroAereo() {
		return this.deducSiniestroAereo;
	}

	public void setDeducSiniestroAereo(BigDecimal deducSiniestroAereo) {
		this.deducSiniestroAereo = deducSiniestroAereo;
	}

	public Integer getHorasVoladas() {
		return this.horasVoladas;
	}

	public void setHorasVoladas(Integer horasVoladas) {
		this.horasVoladas = horasVoladas;
	}

	public Integer getItemAereo() {
		return this.itemAereo;
	}

	public void setItemAereo(Integer itemAereo) {
		this.itemAereo = itemAereo;
	}

	public String getMarcaAereo() {
		return this.marcaAereo;
	}

	public void setMarcaAereo(String marcaAereo) {
		this.marcaAereo = marcaAereo;
	}

	public String getMarcaMotorAereo() {
		return this.marcaMotorAereo;
	}

	public void setMarcaMotorAereo(String marcaMotorAereo) {
		this.marcaMotorAereo = marcaMotorAereo;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public BigDecimal getMaximaCargaAereo() {
		return this.maximaCargaAereo;
	}

	public void setMaximaCargaAereo(BigDecimal maximaCargaAereo) {
		this.maximaCargaAereo = maximaCargaAereo;
	}

	public BigDecimal getPesoMaximoAereo() {
		return this.pesoMaximoAereo;
	}

	public void setPesoMaximoAereo(BigDecimal pesoMaximoAereo) {
		this.pesoMaximoAereo = pesoMaximoAereo;
	}

	public BigDecimal getTasaCascoAereo() {
		return this.tasaCascoAereo;
	}

	public void setTasaCascoAereo(BigDecimal tasaCascoAereo) {
		this.tasaCascoAereo = tasaCascoAereo;
	}

	public String getTipoModeloAereo() {
		return this.tipoModeloAereo;
	}

	public void setTipoModeloAereo(String tipoModeloAereo) {
		this.tipoModeloAereo = tipoModeloAereo;
	}

	public String getTipoMotorAereo() {
		return this.tipoMotorAereo;
	}

	public void setTipoMotorAereo(String tipoMotorAereo) {
		this.tipoMotorAereo = tipoMotorAereo;
	}

	public BigDecimal getTotalAseguradoAereo() {
		return this.totalAseguradoAereo;
	}

	public void setTotalAseguradoAereo(BigDecimal totalAseguradoAereo) {
		this.totalAseguradoAereo = totalAseguradoAereo;
	}

	public BigDecimal getValorCascoAereo() {
		return this.valorCascoAereo;
	}

	public void setValorCascoAereo(BigDecimal valorCascoAereo) {
		this.valorCascoAereo = valorCascoAereo;
	}

	public List<ClausulasAddCascoAereo> getClausulasAddCascoAereos() {
		return this.clausulasAddCascoAereos;
	}

	public void setClausulasAddCascoAereos(List<ClausulasAddCascoAereo> clausulasAddCascoAereos) {
		this.clausulasAddCascoAereos = clausulasAddCascoAereos;
	}

	public ClausulasAddCascoAereo addClausulasAddCascoAereo(ClausulasAddCascoAereo clausulasAddCascoAereo) {
		getClausulasAddCascoAereos().add(clausulasAddCascoAereo);
		clausulasAddCascoAereo.setRamoCascoAereo(this);

		return clausulasAddCascoAereo;
	}

	public ClausulasAddCascoAereo removeClausulasAddCascoAereo(ClausulasAddCascoAereo clausulasAddCascoAereo) {
		getClausulasAddCascoAereos().remove(clausulasAddCascoAereo);
		clausulasAddCascoAereo.setRamoCascoAereo(null);

		return clausulasAddCascoAereo;
	}

	public List<CobertAddCascoAereo> getCobertAddCascoAereos() {
		return this.cobertAddCascoAereos;
	}

	public void setCobertAddCascoAereos(List<CobertAddCascoAereo> cobertAddCascoAereos) {
		this.cobertAddCascoAereos = cobertAddCascoAereos;
	}

	public CobertAddCascoAereo addCobertAddCascoAereo(CobertAddCascoAereo cobertAddCascoAereo) {
		getCobertAddCascoAereos().add(cobertAddCascoAereo);
		cobertAddCascoAereo.setRamoCascoAereo(this);

		return cobertAddCascoAereo;
	}

	public CobertAddCascoAereo removeCobertAddCascoAereo(CobertAddCascoAereo cobertAddCascoAereo) {
		getCobertAddCascoAereos().remove(cobertAddCascoAereo);
		cobertAddCascoAereo.setRamoCascoAereo(null);

		return cobertAddCascoAereo;
	}

	public List<ExtrasCascoAereo> getExtrasCascoAereos() {
		return this.extrasCascoAereos;
	}

	public void setExtrasCascoAereos(List<ExtrasCascoAereo> extrasCascoAereos) {
		this.extrasCascoAereos = extrasCascoAereos;
	}

	public ExtrasCascoAereo addExtrasCascoAereo(ExtrasCascoAereo extrasCascoAereo) {
		getExtrasCascoAereos().add(extrasCascoAereo);
		extrasCascoAereo.setRamoCascoAereo(this);

		return extrasCascoAereo;
	}

	public ExtrasCascoAereo removeExtrasCascoAereo(ExtrasCascoAereo extrasCascoAereo) {
		getExtrasCascoAereos().remove(extrasCascoAereo);
		extrasCascoAereo.setRamoCascoAereo(null);

		return extrasCascoAereo;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

	/**
	 * @return the cobertCascoAereo
	 */
	public List<CobertCascoAereo> getCobertCascoAereo() {
		return cobertCascoAereo;
	}

	/**
	 * @param cobertCascoAereo
	 *            the cobertCascoAereo to set
	 */
	public void setCobertCascoAereo(List<CobertCascoAereo> cobertCascoAereo) {
		this.cobertCascoAereo = cobertCascoAereo;
	}

}