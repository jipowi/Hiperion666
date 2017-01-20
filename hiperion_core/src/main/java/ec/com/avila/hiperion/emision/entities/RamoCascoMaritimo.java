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
 * The persistent class for the ramo_casco_maritimo database table.
 * 
 */
@Entity
@Table(name = "ramo_casco_maritimo")
@NamedQuery(name = "RamoCascoMaritimo.findAll", query = "SELECT r FROM RamoCascoMaritimo r")
public class RamoCascoMaritimo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_casco")
	private Integer idCasco;

	@Column(name = "anio_constr_maritimo")
	private Integer anioConstrMaritimo;

	private BigDecimal avaluo;

	private String bandera;

	@Column(name = "clase_embarcacion")
	private String claseEmbarcacion;

	@Column(name = "deduc_minimo_maritimo")
	private BigDecimal deducMinimoMaritimo;

	@Column(name = "deduc_siniestro_maritimo")
	private BigDecimal deducSiniestroMaritimo;

	private String eslora;

	@Column(name = "item_maritimo")
	private Integer itemMaritimo;

	private String localidad;

	private String manga;

	@Column(name = "marca_motor_maritimo")
	private String marcaMotorMaritimo;

	@Column(name = "nombre_nave")
	private String nombreNave;

	@Column(name = "numero_registro")
	private String numeroRegistro;

	@Column(name = "otros_maritimo")
	private BigDecimal otrosMaritimo;

	private String puntal;

	private String superestructura;

	@Column(name = "tasa_maritimo")
	private BigDecimal tasaMaritimo;

	@Column(name = "tonelaje_bruto")
	private BigDecimal tonelajeBruto;

	@Column(name = "total_maritimo")
	private BigDecimal totalMaritimo;

	@Column(name = "valor_casco_maritimo")
	private BigDecimal valorCascoMaritimo;

	@Column(name = "valor_maquinaria_maritimo")
	private BigDecimal valorMaquinariaMaritimo;

	@Column(name = "valor_redes")
	private BigDecimal valorRedes;

	@Column(name = "zona_navegacion")
	private String zonaNavegacion;

	// bi-directional many-to-one association to ClausulasAddCasco
	@OneToMany(mappedBy = "ramoCascoMaritimo")
	private List<ClausulasAddCasco> clausulasAddCascos;

	// bi-directional many-to-one association to CobertAddCasco
	@OneToMany(mappedBy = "ramoCascoMaritimo")
	private List<CobertAddCasco> cobertAddCascos;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoCascoMaritimo() {
	}

	public Integer getIdCasco() {
		return this.idCasco;
	}

	public void setIdCasco(Integer idCasco) {
		this.idCasco = idCasco;
	}

	public Integer getAnioConstrMaritimo() {
		return this.anioConstrMaritimo;
	}

	public void setAnioConstrMaritimo(Integer anioConstrMaritimo) {
		this.anioConstrMaritimo = anioConstrMaritimo;
	}

	public BigDecimal getAvaluo() {
		return this.avaluo;
	}

	public void setAvaluo(BigDecimal avaluo) {
		this.avaluo = avaluo;
	}

	public String getBandera() {
		return this.bandera;
	}

	public void setBandera(String bandera) {
		this.bandera = bandera;
	}

	public String getClaseEmbarcacion() {
		return this.claseEmbarcacion;
	}

	public void setClaseEmbarcacion(String claseEmbarcacion) {
		this.claseEmbarcacion = claseEmbarcacion;
	}

	public BigDecimal getDeducMinimoMaritimo() {
		return this.deducMinimoMaritimo;
	}

	public void setDeducMinimoMaritimo(BigDecimal deducMinimoMaritimo) {
		this.deducMinimoMaritimo = deducMinimoMaritimo;
	}

	public BigDecimal getDeducSiniestroMaritimo() {
		return this.deducSiniestroMaritimo;
	}

	public void setDeducSiniestroMaritimo(BigDecimal deducSiniestroMaritimo) {
		this.deducSiniestroMaritimo = deducSiniestroMaritimo;
	}

	public String getEslora() {
		return this.eslora;
	}

	public void setEslora(String eslora) {
		this.eslora = eslora;
	}

	public Integer getItemMaritimo() {
		return this.itemMaritimo;
	}

	public void setItemMaritimo(Integer itemMaritimo) {
		this.itemMaritimo = itemMaritimo;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getManga() {
		return this.manga;
	}

	public void setManga(String manga) {
		this.manga = manga;
	}

	public String getMarcaMotorMaritimo() {
		return this.marcaMotorMaritimo;
	}

	public void setMarcaMotorMaritimo(String marcaMotorMaritimo) {
		this.marcaMotorMaritimo = marcaMotorMaritimo;
	}

	public String getNombreNave() {
		return this.nombreNave;
	}

	public void setNombreNave(String nombreNave) {
		this.nombreNave = nombreNave;
	}

	public String getNumeroRegistro() {
		return this.numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public BigDecimal getOtrosMaritimo() {
		return this.otrosMaritimo;
	}

	public void setOtrosMaritimo(BigDecimal otrosMaritimo) {
		this.otrosMaritimo = otrosMaritimo;
	}

	public String getPuntal() {
		return this.puntal;
	}

	public void setPuntal(String puntal) {
		this.puntal = puntal;
	}

	public String getSuperestructura() {
		return this.superestructura;
	}

	public void setSuperestructura(String superestructura) {
		this.superestructura = superestructura;
	}

	public BigDecimal getTasaMaritimo() {
		return this.tasaMaritimo;
	}

	public void setTasaMaritimo(BigDecimal tasaMaritimo) {
		this.tasaMaritimo = tasaMaritimo;
	}

	public BigDecimal getTonelajeBruto() {
		return this.tonelajeBruto;
	}

	public void setTonelajeBruto(BigDecimal tonelajeBruto) {
		this.tonelajeBruto = tonelajeBruto;
	}

	public BigDecimal getTotalMaritimo() {
		return this.totalMaritimo;
	}

	public void setTotalMaritimo(BigDecimal totalMaritimo) {
		this.totalMaritimo = totalMaritimo;
	}

	public BigDecimal getValorCascoMaritimo() {
		return this.valorCascoMaritimo;
	}

	public void setValorCascoMaritimo(BigDecimal valorCascoMaritimo) {
		this.valorCascoMaritimo = valorCascoMaritimo;
	}

	public BigDecimal getValorMaquinariaMaritimo() {
		return this.valorMaquinariaMaritimo;
	}

	public void setValorMaquinariaMaritimo(BigDecimal valorMaquinariaMaritimo) {
		this.valorMaquinariaMaritimo = valorMaquinariaMaritimo;
	}

	public BigDecimal getValorRedes() {
		return this.valorRedes;
	}

	public void setValorRedes(BigDecimal valorRedes) {
		this.valorRedes = valorRedes;
	}

	public String getZonaNavegacion() {
		return this.zonaNavegacion;
	}

	public void setZonaNavegacion(String zonaNavegacion) {
		this.zonaNavegacion = zonaNavegacion;
	}

	public List<ClausulasAddCasco> getClausulasAddCascos() {
		return this.clausulasAddCascos;
	}

	public void setClausulasAddCascos(List<ClausulasAddCasco> clausulasAddCascos) {
		this.clausulasAddCascos = clausulasAddCascos;
	}

	public ClausulasAddCasco addClausulasAddCasco(ClausulasAddCasco clausulasAddCasco) {
		getClausulasAddCascos().add(clausulasAddCasco);
		clausulasAddCasco.setRamoCascoMaritimo(this);

		return clausulasAddCasco;
	}

	public ClausulasAddCasco removeClausulasAddCasco(ClausulasAddCasco clausulasAddCasco) {
		getClausulasAddCascos().remove(clausulasAddCasco);
		clausulasAddCasco.setRamoCascoMaritimo(null);

		return clausulasAddCasco;
	}

	public List<CobertAddCasco> getCobertAddCascos() {
		return this.cobertAddCascos;
	}

	public void setCobertAddCascos(List<CobertAddCasco> cobertAddCascos) {
		this.cobertAddCascos = cobertAddCascos;
	}

	public CobertAddCasco addCobertAddCasco(CobertAddCasco cobertAddCasco) {
		getCobertAddCascos().add(cobertAddCasco);
		cobertAddCasco.setRamoCascoMaritimo(this);

		return cobertAddCasco;
	}

	public CobertAddCasco removeCobertAddCasco(CobertAddCasco cobertAddCasco) {
		getCobertAddCascos().remove(cobertAddCasco);
		cobertAddCasco.setRamoCascoMaritimo(null);

		return cobertAddCasco;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}