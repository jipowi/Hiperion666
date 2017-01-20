package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the poliza database table.
 * 
 */
@Entity
@NamedQuery(name = "Poliza.findAll", query = "SELECT p FROM Poliza p")
public class Poliza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poliza")
	private Integer idPoliza;

	@Column(name = "derecho_emision")
	private BigDecimal derechoEmision;

	@Column(name = "dias_cobertura")
	private Integer diasCobertura;

	private String ejecutivo;

	@Column(name = "estado_poliza")
	private String estadoPoliza;

	@Column(name = "hora_desde")
	private String horaDesde;

	@Column(name = "hora_hasta")
	private String horaHasta;

	@Column(name = "numero_anexo")
	private String numeroAnexo;

	@Column(name = "numero_poliza")
	private BigDecimal numeroPoliza;

	@Column(name = "prima_neta")
	private BigDecimal primaNeta;

	@Column(name = "ramo")
	private String ramo;

	@Column(name = "seguro_campesino")
	private BigDecimal seguroCampesino;

	@Column(name = "suma_asegurada")
	private BigDecimal sumaAsegurada;

	@Column(name = "super_ban_seguros")
	private BigDecimal superBanSeguros;

	@Temporal(TemporalType.DATE)
	@Column(name = "vigencia_desde")
	private Date vigenciaDesde;

	@Temporal(TemporalType.DATE)
	@Column(name = "vigencia_hasta")
	private Date vigenciaHasta;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	// bi-directional many-to-one association to PagoPoliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pago_poliza")
	private PagoPoliza pagoPoliza;

	// bi-directional many-to-one association to RamoAccidentesPersonale
	@OneToMany(mappedBy = "poliza")
	private List<RamoAccidentesPersonale> ramoAccidentesPersonales;

	// bi-directional many-to-one association to RamoAgropecuario
	@OneToMany(mappedBy = "poliza")
	private List<RamoAgropecuario> ramoAgropecuarios;

	// bi-directional many-to-one association to RamoAsistenciaMedica
	@OneToMany(mappedBy = "poliza")
	private List<RamoAsistenciaMedica> ramoAsistenciaMedicas;

	// bi-directional many-to-one association to RamoBuenUsoAnt
	@OneToMany(mappedBy = "poliza")
	private List<RamoBuenUsoAnt> ramoBuenUsoAnts;

	// bi-directional many-to-one association to RamoBuenaCalMat
	@OneToMany(mappedBy = "poliza")
	private List<RamoBuenaCalMat> ramoBuenaCalMats;

	// bi-directional many-to-one association to RamoCascoAereo
	@OneToMany(mappedBy = "poliza")
	private List<RamoCascoAereo> ramoCascoAereos;

	// bi-directional many-to-one association to RamoCascoMaritimo
	@OneToMany(mappedBy = "poliza")
	private List<RamoCascoMaritimo> ramoCascoMaritimos;

	// bi-directional many-to-one association to RamoCumplimientoContrato
	@OneToMany(mappedBy = "poliza")
	private List<RamoCumplimientoContrato> ramoCumplimientoContratos;

	// bi-directional many-to-one association to RamoDineroValore
	@OneToMany(mappedBy = "poliza")
	private List<RamoDineroValore> ramoDineroValores;

	// bi-directional many-to-one association to RamoEquipoElectronico
	@OneToMany(mappedBy = "poliza")
	private List<RamoEquipoElectronico> ramoEquipoElectronicos;

	// bi-directional many-to-one association to RamoEquipoMaquinaria
	@OneToMany(mappedBy = "poliza")
	private List<RamoEquipoMaquinaria> ramoEquipoMaquinarias;

	// bi-directional many-to-one association to RamoFidelidad
	@OneToMany(mappedBy = "poliza")
	private List<RamoFidelidad> ramoFidelidads;

	// bi-directional many-to-one association to RamoGarantiaAduanera
	@OneToMany(mappedBy = "poliza")
	private List<RamoGarantiaAduanera> ramoGarantiaAduaneras;

	// bi-directional many-to-one association to RamoIncendioLineasAliada
	@OneToMany(mappedBy = "poliza")
	private List<RamoIncendioLineasAliada> ramoIncendioLineasAliadas;

	// bi-directional many-to-one association to RamoLcIncendio
	@OneToMany(mappedBy = "poliza")
	private List<RamoLcIncendio> ramoLcIncendios;

	// bi-directional many-to-one association to RamoLcRotMaq
	@OneToMany(mappedBy = "poliza")
	private List<RamoLcRotMaq> ramoLcRotMaqs;

	// bi-directional many-to-one association to RamoResponsabilidadCivil
	@OneToMany(mappedBy = "poliza")
	private List<RamoResponsabilidadCivil> ramoResponsabilidadCivils;

	// bi-directional many-to-one association to RamoRiesgoContratista
	@OneToMany(mappedBy = "poliza")
	private List<RamoRiesgoContratista> ramoRiesgoContratistas;

	// bi-directional many-to-one association to RamoRiesgoMontaje
	@OneToMany(mappedBy = "poliza")
	private List<RamoRiesgoMontaje> ramoRiesgoMontajes;

	// bi-directional many-to-one association to RamoRiesgosEsp
	@OneToMany(mappedBy = "poliza")
	private List<RamoRiesgosEsp> ramoRiesgosEsps;

	// bi-directional many-to-one association to RamoRoboAsalto
	@OneToMany(mappedBy = "poliza")
	private List<RamoRoboAsalto> ramoRoboAsaltos;

	// bi-directional many-to-one association to RamoRoturaMaquinaria
	@OneToMany(mappedBy = "poliza")
	private List<RamoRoturaMaquinaria> ramoRoturaMaquinarias;

	// bi-directional many-to-one association to RamoSoat
	@OneToMany(mappedBy = "poliza")
	private List<RamoSoat> ramoSoats;

	// bi-directional many-to-one association to RamoTransporte
	@OneToMany(mappedBy = "poliza")
	private List<RamoTransporte> ramoTransportes;

	// bi-directional many-to-one association to RamoVehiculo
	@OneToMany(mappedBy = "poliza")
	private List<RamoVehiculo> ramoVehiculos;

	// bi-directional many-to-one association to RamoVida
	@OneToMany(mappedBy = "poliza")
	private List<RamoVida> ramoVidas;

	// bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Poliza() {
	}

	public Integer getIdPoliza() {
		return this.idPoliza;
	}

	public void setIdPoliza(Integer idPoliza) {
		this.idPoliza = idPoliza;
	}

	public BigDecimal getDerechoEmision() {
		return this.derechoEmision;
	}

	public void setDerechoEmision(BigDecimal derechoEmision) {
		this.derechoEmision = derechoEmision;
	}

	public Integer getDiasCobertura() {
		return this.diasCobertura;
	}

	public void setDiasCobertura(Integer diasCobertura) {
		this.diasCobertura = diasCobertura;
	}

	public String getEjecutivo() {
		return this.ejecutivo;
	}

	public void setEjecutivo(String ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public String getEstadoPoliza() {
		return this.estadoPoliza;
	}

	public void setEstadoPoliza(String estadoPoliza) {
		this.estadoPoliza = estadoPoliza;
	}

	public String getHoraDesde() {
		return this.horaDesde;
	}

	public void setHoraDesde(String horaDesde) {
		this.horaDesde = horaDesde;
	}

	public String getHoraHasta() {
		return this.horaHasta;
	}

	public void setHoraHasta(String horaHasta) {
		this.horaHasta = horaHasta;
	}

	public String getNumeroAnexo() {
		return this.numeroAnexo;
	}

	public void setNumeroAnexo(String numeroAnexo) {
		this.numeroAnexo = numeroAnexo;
	}

	public BigDecimal getNumeroPoliza() {
		return this.numeroPoliza;
	}

	public void setNumeroPoliza(BigDecimal numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public BigDecimal getPrimaNeta() {
		return this.primaNeta;
	}

	public void setPrimaNeta(BigDecimal primaNeta) {
		this.primaNeta = primaNeta;
	}

	/**
	 * @return the ramo
	 */
	public String getRamo() {
		return ramo;
	}

	/**
	 * @param ramo
	 *            the ramo to set
	 */
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public BigDecimal getSeguroCampesino() {
		return this.seguroCampesino;
	}

	public void setSeguroCampesino(BigDecimal seguroCampesino) {
		this.seguroCampesino = seguroCampesino;
	}

	public BigDecimal getSumaAsegurada() {
		return this.sumaAsegurada;
	}

	public void setSumaAsegurada(BigDecimal sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public BigDecimal getSuperBanSeguros() {
		return this.superBanSeguros;
	}

	public void setSuperBanSeguros(BigDecimal superBanSeguros) {
		this.superBanSeguros = superBanSeguros;
	}

	public Date getVigenciaDesde() {
		return this.vigenciaDesde;
	}

	public void setVigenciaDesde(Date vigenciaDesde) {
		this.vigenciaDesde = vigenciaDesde;
	}

	public Date getVigenciaHasta() {
		return this.vigenciaHasta;
	}

	public void setVigenciaHasta(Date vigenciaHasta) {
		this.vigenciaHasta = vigenciaHasta;
	}

	public PagoPoliza getPagoPoliza() {
		return this.pagoPoliza;
	}

	public void setPagoPoliza(PagoPoliza pagoPoliza) {
		this.pagoPoliza = pagoPoliza;
	}

	public List<RamoAccidentesPersonale> getRamoAccidentesPersonales() {
		return this.ramoAccidentesPersonales;
	}

	public void setRamoAccidentesPersonales(List<RamoAccidentesPersonale> ramoAccidentesPersonales) {
		this.ramoAccidentesPersonales = ramoAccidentesPersonales;
	}

	public RamoAccidentesPersonale addRamoAccidentesPersonale(RamoAccidentesPersonale ramoAccidentesPersonale) {
		getRamoAccidentesPersonales().add(ramoAccidentesPersonale);
		ramoAccidentesPersonale.setPoliza(this);

		return ramoAccidentesPersonale;
	}

	public RamoAccidentesPersonale removeRamoAccidentesPersonale(RamoAccidentesPersonale ramoAccidentesPersonale) {
		getRamoAccidentesPersonales().remove(ramoAccidentesPersonale);
		ramoAccidentesPersonale.setPoliza(null);

		return ramoAccidentesPersonale;
	}

	public List<RamoAgropecuario> getRamoAgropecuarios() {
		return this.ramoAgropecuarios;
	}

	public void setRamoAgropecuarios(List<RamoAgropecuario> ramoAgropecuarios) {
		this.ramoAgropecuarios = ramoAgropecuarios;
	}

	public RamoAgropecuario addRamoAgropecuario(RamoAgropecuario ramoAgropecuario) {
		getRamoAgropecuarios().add(ramoAgropecuario);
		ramoAgropecuario.setPoliza(this);

		return ramoAgropecuario;
	}

	public RamoAgropecuario removeRamoAgropecuario(RamoAgropecuario ramoAgropecuario) {
		getRamoAgropecuarios().remove(ramoAgropecuario);
		ramoAgropecuario.setPoliza(null);

		return ramoAgropecuario;
	}

	public List<RamoAsistenciaMedica> getRamoAsistenciaMedicas() {
		return this.ramoAsistenciaMedicas;
	}

	public void setRamoAsistenciaMedicas(List<RamoAsistenciaMedica> ramoAsistenciaMedicas) {
		this.ramoAsistenciaMedicas = ramoAsistenciaMedicas;
	}

	public RamoAsistenciaMedica addRamoAsistenciaMedica(RamoAsistenciaMedica ramoAsistenciaMedica) {
		getRamoAsistenciaMedicas().add(ramoAsistenciaMedica);
		ramoAsistenciaMedica.setPoliza(this);

		return ramoAsistenciaMedica;
	}

	public RamoAsistenciaMedica removeRamoAsistenciaMedica(RamoAsistenciaMedica ramoAsistenciaMedica) {
		getRamoAsistenciaMedicas().remove(ramoAsistenciaMedica);
		ramoAsistenciaMedica.setPoliza(null);

		return ramoAsistenciaMedica;
	}

	public List<RamoBuenUsoAnt> getRamoBuenUsoAnts() {
		return this.ramoBuenUsoAnts;
	}

	public void setRamoBuenUsoAnts(List<RamoBuenUsoAnt> ramoBuenUsoAnts) {
		this.ramoBuenUsoAnts = ramoBuenUsoAnts;
	}

	public RamoBuenUsoAnt addRamoBuenUsoAnt(RamoBuenUsoAnt ramoBuenUsoAnt) {
		getRamoBuenUsoAnts().add(ramoBuenUsoAnt);
		ramoBuenUsoAnt.setPoliza(this);

		return ramoBuenUsoAnt;
	}

	public RamoBuenUsoAnt removeRamoBuenUsoAnt(RamoBuenUsoAnt ramoBuenUsoAnt) {
		getRamoBuenUsoAnts().remove(ramoBuenUsoAnt);
		ramoBuenUsoAnt.setPoliza(null);

		return ramoBuenUsoAnt;
	}

	public List<RamoBuenaCalMat> getRamoBuenaCalMats() {
		return this.ramoBuenaCalMats;
	}

	public void setRamoBuenaCalMats(List<RamoBuenaCalMat> ramoBuenaCalMats) {
		this.ramoBuenaCalMats = ramoBuenaCalMats;
	}

	public RamoBuenaCalMat addRamoBuenaCalMat(RamoBuenaCalMat ramoBuenaCalMat) {
		getRamoBuenaCalMats().add(ramoBuenaCalMat);
		ramoBuenaCalMat.setPoliza(this);

		return ramoBuenaCalMat;
	}

	public RamoBuenaCalMat removeRamoBuenaCalMat(RamoBuenaCalMat ramoBuenaCalMat) {
		getRamoBuenaCalMats().remove(ramoBuenaCalMat);
		ramoBuenaCalMat.setPoliza(null);

		return ramoBuenaCalMat;
	}

	public List<RamoCascoAereo> getRamoCascoAereos() {
		return this.ramoCascoAereos;
	}

	public void setRamoCascoAereos(List<RamoCascoAereo> ramoCascoAereos) {
		this.ramoCascoAereos = ramoCascoAereos;
	}

	public RamoCascoAereo addRamoCascoAereo(RamoCascoAereo ramoCascoAereo) {
		getRamoCascoAereos().add(ramoCascoAereo);
		ramoCascoAereo.setPoliza(this);

		return ramoCascoAereo;
	}

	public RamoCascoAereo removeRamoCascoAereo(RamoCascoAereo ramoCascoAereo) {
		getRamoCascoAereos().remove(ramoCascoAereo);
		ramoCascoAereo.setPoliza(null);

		return ramoCascoAereo;
	}

	public List<RamoCascoMaritimo> getRamoCascoMaritimos() {
		return this.ramoCascoMaritimos;
	}

	public void setRamoCascoMaritimos(List<RamoCascoMaritimo> ramoCascoMaritimos) {
		this.ramoCascoMaritimos = ramoCascoMaritimos;
	}

	public RamoCascoMaritimo addRamoCascoMaritimo(RamoCascoMaritimo ramoCascoMaritimo) {
		getRamoCascoMaritimos().add(ramoCascoMaritimo);
		ramoCascoMaritimo.setPoliza(this);

		return ramoCascoMaritimo;
	}

	public RamoCascoMaritimo removeRamoCascoMaritimo(RamoCascoMaritimo ramoCascoMaritimo) {
		getRamoCascoMaritimos().remove(ramoCascoMaritimo);
		ramoCascoMaritimo.setPoliza(null);

		return ramoCascoMaritimo;
	}

	public List<RamoCumplimientoContrato> getRamoCumplimientoContratos() {
		return this.ramoCumplimientoContratos;
	}

	public void setRamoCumplimientoContratos(List<RamoCumplimientoContrato> ramoCumplimientoContratos) {
		this.ramoCumplimientoContratos = ramoCumplimientoContratos;
	}

	public RamoCumplimientoContrato addRamoCumplimientoContrato(RamoCumplimientoContrato ramoCumplimientoContrato) {
		getRamoCumplimientoContratos().add(ramoCumplimientoContrato);
		ramoCumplimientoContrato.setPoliza(this);

		return ramoCumplimientoContrato;
	}

	public RamoCumplimientoContrato removeRamoCumplimientoContrato(RamoCumplimientoContrato ramoCumplimientoContrato) {
		getRamoCumplimientoContratos().remove(ramoCumplimientoContrato);
		ramoCumplimientoContrato.setPoliza(null);

		return ramoCumplimientoContrato;
	}

	public List<RamoDineroValore> getRamoDineroValores() {
		return this.ramoDineroValores;
	}

	public void setRamoDineroValores(List<RamoDineroValore> ramoDineroValores) {
		this.ramoDineroValores = ramoDineroValores;
	}

	public RamoDineroValore addRamoDineroValore(RamoDineroValore ramoDineroValore) {
		getRamoDineroValores().add(ramoDineroValore);
		ramoDineroValore.setPoliza(this);

		return ramoDineroValore;
	}

	public RamoDineroValore removeRamoDineroValore(RamoDineroValore ramoDineroValore) {
		getRamoDineroValores().remove(ramoDineroValore);
		ramoDineroValore.setPoliza(null);

		return ramoDineroValore;
	}

	public List<RamoEquipoElectronico> getRamoEquipoElectronicos() {
		return this.ramoEquipoElectronicos;
	}

	public void setRamoEquipoElectronicos(List<RamoEquipoElectronico> ramoEquipoElectronicos) {
		this.ramoEquipoElectronicos = ramoEquipoElectronicos;
	}

	public RamoEquipoElectronico addRamoEquipoElectronico(RamoEquipoElectronico ramoEquipoElectronico) {
		getRamoEquipoElectronicos().add(ramoEquipoElectronico);
		ramoEquipoElectronico.setPoliza(this);

		return ramoEquipoElectronico;
	}

	public RamoEquipoElectronico removeRamoEquipoElectronico(RamoEquipoElectronico ramoEquipoElectronico) {
		getRamoEquipoElectronicos().remove(ramoEquipoElectronico);
		ramoEquipoElectronico.setPoliza(null);

		return ramoEquipoElectronico;
	}

	public List<RamoEquipoMaquinaria> getRamoEquipoMaquinarias() {
		return this.ramoEquipoMaquinarias;
	}

	public void setRamoEquipoMaquinarias(List<RamoEquipoMaquinaria> ramoEquipoMaquinarias) {
		this.ramoEquipoMaquinarias = ramoEquipoMaquinarias;
	}

	public RamoEquipoMaquinaria addRamoEquipoMaquinaria(RamoEquipoMaquinaria ramoEquipoMaquinaria) {
		getRamoEquipoMaquinarias().add(ramoEquipoMaquinaria);
		ramoEquipoMaquinaria.setPoliza(this);

		return ramoEquipoMaquinaria;
	}

	public RamoEquipoMaquinaria removeRamoEquipoMaquinaria(RamoEquipoMaquinaria ramoEquipoMaquinaria) {
		getRamoEquipoMaquinarias().remove(ramoEquipoMaquinaria);
		ramoEquipoMaquinaria.setPoliza(null);

		return ramoEquipoMaquinaria;
	}

	public List<RamoFidelidad> getRamoFidelidads() {
		return this.ramoFidelidads;
	}

	public void setRamoFidelidads(List<RamoFidelidad> ramoFidelidads) {
		this.ramoFidelidads = ramoFidelidads;
	}

	public RamoFidelidad addRamoFidelidad(RamoFidelidad ramoFidelidad) {
		getRamoFidelidads().add(ramoFidelidad);
		ramoFidelidad.setPoliza(this);

		return ramoFidelidad;
	}

	public RamoFidelidad removeRamoFidelidad(RamoFidelidad ramoFidelidad) {
		getRamoFidelidads().remove(ramoFidelidad);
		ramoFidelidad.setPoliza(null);

		return ramoFidelidad;
	}

	public List<RamoGarantiaAduanera> getRamoGarantiaAduaneras() {
		return this.ramoGarantiaAduaneras;
	}

	public void setRamoGarantiaAduaneras(List<RamoGarantiaAduanera> ramoGarantiaAduaneras) {
		this.ramoGarantiaAduaneras = ramoGarantiaAduaneras;
	}

	public RamoGarantiaAduanera addRamoGarantiaAduanera(RamoGarantiaAduanera ramoGarantiaAduanera) {
		getRamoGarantiaAduaneras().add(ramoGarantiaAduanera);
		ramoGarantiaAduanera.setPoliza(this);

		return ramoGarantiaAduanera;
	}

	public RamoGarantiaAduanera removeRamoGarantiaAduanera(RamoGarantiaAduanera ramoGarantiaAduanera) {
		getRamoGarantiaAduaneras().remove(ramoGarantiaAduanera);
		ramoGarantiaAduanera.setPoliza(null);

		return ramoGarantiaAduanera;
	}

	public List<RamoIncendioLineasAliada> getRamoIncendioLineasAliadas() {
		return this.ramoIncendioLineasAliadas;
	}

	public void setRamoIncendioLineasAliadas(List<RamoIncendioLineasAliada> ramoIncendioLineasAliadas) {
		this.ramoIncendioLineasAliadas = ramoIncendioLineasAliadas;
	}

	public RamoIncendioLineasAliada addRamoIncendioLineasAliada(RamoIncendioLineasAliada ramoIncendioLineasAliada) {
		getRamoIncendioLineasAliadas().add(ramoIncendioLineasAliada);
		ramoIncendioLineasAliada.setPoliza(this);

		return ramoIncendioLineasAliada;
	}

	public RamoIncendioLineasAliada removeRamoIncendioLineasAliada(RamoIncendioLineasAliada ramoIncendioLineasAliada) {
		getRamoIncendioLineasAliadas().remove(ramoIncendioLineasAliada);
		ramoIncendioLineasAliada.setPoliza(null);

		return ramoIncendioLineasAliada;
	}

	public List<RamoLcIncendio> getRamoLcIncendios() {
		return this.ramoLcIncendios;
	}

	public void setRamoLcIncendios(List<RamoLcIncendio> ramoLcIncendios) {
		this.ramoLcIncendios = ramoLcIncendios;
	}

	public RamoLcIncendio addRamoLcIncendio(RamoLcIncendio ramoLcIncendio) {
		getRamoLcIncendios().add(ramoLcIncendio);
		ramoLcIncendio.setPoliza(this);

		return ramoLcIncendio;
	}

	public RamoLcIncendio removeRamoLcIncendio(RamoLcIncendio ramoLcIncendio) {
		getRamoLcIncendios().remove(ramoLcIncendio);
		ramoLcIncendio.setPoliza(null);

		return ramoLcIncendio;
	}

	public List<RamoLcRotMaq> getRamoLcRotMaqs() {
		return this.ramoLcRotMaqs;
	}

	public void setRamoLcRotMaqs(List<RamoLcRotMaq> ramoLcRotMaqs) {
		this.ramoLcRotMaqs = ramoLcRotMaqs;
	}

	public RamoLcRotMaq addRamoLcRotMaq(RamoLcRotMaq ramoLcRotMaq) {
		getRamoLcRotMaqs().add(ramoLcRotMaq);
		ramoLcRotMaq.setPoliza(this);

		return ramoLcRotMaq;
	}

	public RamoLcRotMaq removeRamoLcRotMaq(RamoLcRotMaq ramoLcRotMaq) {
		getRamoLcRotMaqs().remove(ramoLcRotMaq);
		ramoLcRotMaq.setPoliza(null);

		return ramoLcRotMaq;
	}

	public List<RamoResponsabilidadCivil> getRamoResponsabilidadCivils() {
		return this.ramoResponsabilidadCivils;
	}

	public void setRamoResponsabilidadCivils(List<RamoResponsabilidadCivil> ramoResponsabilidadCivils) {
		this.ramoResponsabilidadCivils = ramoResponsabilidadCivils;
	}

	public RamoResponsabilidadCivil addRamoResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil) {
		getRamoResponsabilidadCivils().add(ramoResponsabilidadCivil);
		ramoResponsabilidadCivil.setPoliza(this);

		return ramoResponsabilidadCivil;
	}

	public RamoResponsabilidadCivil removeRamoResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil) {
		getRamoResponsabilidadCivils().remove(ramoResponsabilidadCivil);
		ramoResponsabilidadCivil.setPoliza(null);

		return ramoResponsabilidadCivil;
	}

	public List<RamoRiesgoContratista> getRamoRiesgoContratistas() {
		return this.ramoRiesgoContratistas;
	}

	public void setRamoRiesgoContratistas(List<RamoRiesgoContratista> ramoRiesgoContratistas) {
		this.ramoRiesgoContratistas = ramoRiesgoContratistas;
	}

	public RamoRiesgoContratista addRamoRiesgoContratista(RamoRiesgoContratista ramoRiesgoContratista) {
		getRamoRiesgoContratistas().add(ramoRiesgoContratista);
		ramoRiesgoContratista.setPoliza(this);

		return ramoRiesgoContratista;
	}

	public RamoRiesgoContratista removeRamoRiesgoContratista(RamoRiesgoContratista ramoRiesgoContratista) {
		getRamoRiesgoContratistas().remove(ramoRiesgoContratista);
		ramoRiesgoContratista.setPoliza(null);

		return ramoRiesgoContratista;
	}

	public List<RamoRiesgoMontaje> getRamoRiesgoMontajes() {
		return this.ramoRiesgoMontajes;
	}

	public void setRamoRiesgoMontajes(List<RamoRiesgoMontaje> ramoRiesgoMontajes) {
		this.ramoRiesgoMontajes = ramoRiesgoMontajes;
	}

	public RamoRiesgoMontaje addRamoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) {
		getRamoRiesgoMontajes().add(ramoRiesgoMontaje);
		ramoRiesgoMontaje.setPoliza(this);

		return ramoRiesgoMontaje;
	}

	public RamoRiesgoMontaje removeRamoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) {
		getRamoRiesgoMontajes().remove(ramoRiesgoMontaje);
		ramoRiesgoMontaje.setPoliza(null);

		return ramoRiesgoMontaje;
	}

	public List<RamoRiesgosEsp> getRamoRiesgosEsps() {
		return this.ramoRiesgosEsps;
	}

	public void setRamoRiesgosEsps(List<RamoRiesgosEsp> ramoRiesgosEsps) {
		this.ramoRiesgosEsps = ramoRiesgosEsps;
	}

	public RamoRiesgosEsp addRamoRiesgosEsp(RamoRiesgosEsp ramoRiesgosEsp) {
		getRamoRiesgosEsps().add(ramoRiesgosEsp);
		ramoRiesgosEsp.setPoliza(this);

		return ramoRiesgosEsp;
	}

	public RamoRiesgosEsp removeRamoRiesgosEsp(RamoRiesgosEsp ramoRiesgosEsp) {
		getRamoRiesgosEsps().remove(ramoRiesgosEsp);
		ramoRiesgosEsp.setPoliza(null);

		return ramoRiesgosEsp;
	}

	public List<RamoRoboAsalto> getRamoRoboAsaltos() {
		return this.ramoRoboAsaltos;
	}

	public void setRamoRoboAsaltos(List<RamoRoboAsalto> ramoRoboAsaltos) {
		this.ramoRoboAsaltos = ramoRoboAsaltos;
	}

	public RamoRoboAsalto addRamoRoboAsalto(RamoRoboAsalto ramoRoboAsalto) {
		getRamoRoboAsaltos().add(ramoRoboAsalto);
		ramoRoboAsalto.setPoliza(this);

		return ramoRoboAsalto;
	}

	public RamoRoboAsalto removeRamoRoboAsalto(RamoRoboAsalto ramoRoboAsalto) {
		getRamoRoboAsaltos().remove(ramoRoboAsalto);
		ramoRoboAsalto.setPoliza(null);

		return ramoRoboAsalto;
	}

	public List<RamoRoturaMaquinaria> getRamoRoturaMaquinarias() {
		return this.ramoRoturaMaquinarias;
	}

	public void setRamoRoturaMaquinarias(List<RamoRoturaMaquinaria> ramoRoturaMaquinarias) {
		this.ramoRoturaMaquinarias = ramoRoturaMaquinarias;
	}

	public RamoRoturaMaquinaria addRamoRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) {
		getRamoRoturaMaquinarias().add(ramoRoturaMaquinaria);
		ramoRoturaMaquinaria.setPoliza(this);

		return ramoRoturaMaquinaria;
	}

	public RamoRoturaMaquinaria removeRamoRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) {
		getRamoRoturaMaquinarias().remove(ramoRoturaMaquinaria);
		ramoRoturaMaquinaria.setPoliza(null);

		return ramoRoturaMaquinaria;
	}

	public List<RamoSoat> getRamoSoats() {
		return this.ramoSoats;
	}

	public void setRamoSoats(List<RamoSoat> ramoSoats) {
		this.ramoSoats = ramoSoats;
	}

	public RamoSoat addRamoSoat(RamoSoat ramoSoat) {
		getRamoSoats().add(ramoSoat);
		ramoSoat.setPoliza(this);

		return ramoSoat;
	}

	public RamoSoat removeRamoSoat(RamoSoat ramoSoat) {
		getRamoSoats().remove(ramoSoat);
		ramoSoat.setPoliza(null);

		return ramoSoat;
	}

	public List<RamoTransporte> getRamoTransportes() {
		return this.ramoTransportes;
	}

	public void setRamoTransportes(List<RamoTransporte> ramoTransportes) {
		this.ramoTransportes = ramoTransportes;
	}

	public RamoTransporte addRamoTransporte(RamoTransporte ramoTransporte) {
		getRamoTransportes().add(ramoTransporte);
		ramoTransporte.setPoliza(this);

		return ramoTransporte;
	}

	public RamoTransporte removeRamoTransporte(RamoTransporte ramoTransporte) {
		getRamoTransportes().remove(ramoTransporte);
		ramoTransporte.setPoliza(null);

		return ramoTransporte;
	}

	public List<RamoVehiculo> getRamoVehiculos() {
		return this.ramoVehiculos;
	}

	public void setRamoVehiculos(List<RamoVehiculo> ramoVehiculos) {
		this.ramoVehiculos = ramoVehiculos;
	}

	public RamoVehiculo addRamoVehiculo(RamoVehiculo ramoVehiculo) {
		getRamoVehiculos().add(ramoVehiculo);
		ramoVehiculo.setPoliza(this);

		return ramoVehiculo;
	}

	public RamoVehiculo removeRamoVehiculo(RamoVehiculo ramoVehiculo) {
		getRamoVehiculos().remove(ramoVehiculo);
		ramoVehiculo.setPoliza(null);

		return ramoVehiculo;
	}

	public List<RamoVida> getRamoVidas() {
		return this.ramoVidas;
	}

	public void setRamoVidas(List<RamoVida> ramoVidas) {
		this.ramoVidas = ramoVidas;
	}

	public RamoVida addRamoVida(RamoVida ramoVida) {
		getRamoVidas().add(ramoVida);
		ramoVida.setPoliza(this);

		return ramoVida;
	}

	public RamoVida removeRamoVida(RamoVida ramoVida) {
		getRamoVidas().remove(ramoVida);
		ramoVida.setPoliza(null);

		return ramoVida;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro
	 *            the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}