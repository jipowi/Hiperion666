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
 * The persistent class for the ramo_equipo_electronico database table.
 * 
 */
@Entity
@Table(name = "ramo_equipo_electronico")
@NamedQuery(name = "RamoEquipoElectronico.findAll", query = "SELECT r FROM RamoEquipoElectronico r")
public class RamoEquipoElectronico extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_equipo")
	private Integer idEquipo;

	@Column(name = "decuc_celular_siniestro")
	private BigDecimal decucCelularSiniestro;

	@Column(name = "deduc_celular_minimo")
	private BigDecimal deducCelularMinimo;

	@Column(name = "deduc_equipo_fijo_minimo")
	private BigDecimal deducEquipoFijoMinimo;

	@Column(name = "deduc_equipo_fijo_siniestro")
	private BigDecimal deducEquipoFijoSiniestro;

	@Column(name = "deduc_equipo_portatil_minimo")
	private BigDecimal deducEquipoPortatilMinimo;

	@Column(name = "deduc_equipo_portatil_siniestro")
	private BigDecimal deducEquipoPortatilSiniestro;

	@Column(name = "deduc_ext_datos_minimo")
	private BigDecimal deducExtDatosMinimo;

	@Column(name = "deduc_ext_datos_siniestro")
	private BigDecimal deducExtDatosSiniestro;

	@Column(name = "deduc_hurto_minimo")
	private BigDecimal deducHurtoMinimo;

	@Column(name = "deduc_hurto_siniestro")
	private BigDecimal deducHurtoSiniestro;

	@Column(name = "deduc_operacion_num_dias")
	private Integer deducOperacionNumDias;

	@Column(name = "suma_asegurada_celulares")
	private BigDecimal sumaAseguradaCelulares;

	@Column(name = "suma_asegurada_fijos")
	private BigDecimal sumaAseguradaFijos;

	@Column(name = "suma_asegurada_otros")
	private BigDecimal sumaAseguradaOtros;

	@Column(name = "suma_asegurada_portatil")
	private BigDecimal sumaAseguradaPortatil;

	@Column(name = "suma_asegurada_total")
	private BigDecimal sumaAseguradaTotal;

	@Column(name = "tasa_celulares")
	private BigDecimal tasaCelulares;

	@Column(name = "tasa_equipos_fijos")
	private BigDecimal tasaEquiposFijos;

	@Column(name = "tasa_equipos_portatiles")
	private BigDecimal tasaEquiposPortatiles;

	@Column(name = "tasa_ext_datos")
	private BigDecimal tasaExtDatos;

	@Column(name = "tasa_hurto_eq_elec")
	private BigDecimal tasaHurtoEqElec;

	@Column(name = "tasa_operacion")
	private BigDecimal tasaOperacion;

	@Column(name = "tasa_otros_eq_elec")
	private BigDecimal tasaOtrosEqElec;

	// bi-directional many-to-one association to ClausulasAddEquipo
	@OneToMany(mappedBy = "ramoEquipoElectronico")
	private List<ClausulasAddEquipo> clausulasAddEquipos;

	// bi-directional many-to-one association to CobertAddEquipo
	@OneToMany(mappedBy = "ramoEquipoElectronico")
	private List<CobertAddEquipo> cobertAddEquipos;

	// bi-directional many-to-one association to CobertEquipo
	@OneToMany(mappedBy = "ramoEquipoElectronico")
	private List<CobertEquipo> cobertEquipos;

	// bi-directional many-to-one association to GarantiaPoliza
	@OneToMany(mappedBy = "ramoEquipoElectronico")
	private List<GarantiaPoliza> garantiaPolizas;

	// bi-directional many-to-one association to ObjAsegEquipo
	@OneToMany(mappedBy = "ramoEquipoElectronico")
	private List<ObjAsegEquipo> objAsegEquipos;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoEquipoElectronico() {
	}

	public Integer getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public BigDecimal getDecucCelularSiniestro() {
		return this.decucCelularSiniestro;
	}

	public void setDecucCelularSiniestro(BigDecimal decucCelularSiniestro) {
		this.decucCelularSiniestro = decucCelularSiniestro;
	}

	public BigDecimal getDeducCelularMinimo() {
		return this.deducCelularMinimo;
	}

	public void setDeducCelularMinimo(BigDecimal deducCelularMinimo) {
		this.deducCelularMinimo = deducCelularMinimo;
	}

	public BigDecimal getDeducEquipoFijoMinimo() {
		return this.deducEquipoFijoMinimo;
	}

	public void setDeducEquipoFijoMinimo(BigDecimal deducEquipoFijoMinimo) {
		this.deducEquipoFijoMinimo = deducEquipoFijoMinimo;
	}

	public BigDecimal getDeducEquipoFijoSiniestro() {
		return this.deducEquipoFijoSiniestro;
	}

	public void setDeducEquipoFijoSiniestro(BigDecimal deducEquipoFijoSiniestro) {
		this.deducEquipoFijoSiniestro = deducEquipoFijoSiniestro;
	}

	public BigDecimal getDeducEquipoPortatilMinimo() {
		return this.deducEquipoPortatilMinimo;
	}

	public void setDeducEquipoPortatilMinimo(BigDecimal deducEquipoPortatilMinimo) {
		this.deducEquipoPortatilMinimo = deducEquipoPortatilMinimo;
	}

	public BigDecimal getDeducEquipoPortatilSiniestro() {
		return this.deducEquipoPortatilSiniestro;
	}

	public void setDeducEquipoPortatilSiniestro(BigDecimal deducEquipoPortatilSiniestro) {
		this.deducEquipoPortatilSiniestro = deducEquipoPortatilSiniestro;
	}

	public BigDecimal getDeducExtDatosMinimo() {
		return this.deducExtDatosMinimo;
	}

	public void setDeducExtDatosMinimo(BigDecimal deducExtDatosMinimo) {
		this.deducExtDatosMinimo = deducExtDatosMinimo;
	}

	public BigDecimal getDeducExtDatosSiniestro() {
		return this.deducExtDatosSiniestro;
	}

	public void setDeducExtDatosSiniestro(BigDecimal deducExtDatosSiniestro) {
		this.deducExtDatosSiniestro = deducExtDatosSiniestro;
	}

	public BigDecimal getDeducHurtoMinimo() {
		return this.deducHurtoMinimo;
	}

	public void setDeducHurtoMinimo(BigDecimal deducHurtoMinimo) {
		this.deducHurtoMinimo = deducHurtoMinimo;
	}

	public BigDecimal getDeducHurtoSiniestro() {
		return this.deducHurtoSiniestro;
	}

	public void setDeducHurtoSiniestro(BigDecimal deducHurtoSiniestro) {
		this.deducHurtoSiniestro = deducHurtoSiniestro;
	}

	public Integer getDeducOperacionNumDias() {
		return this.deducOperacionNumDias;
	}

	public void setDeducOperacionNumDias(Integer deducOperacionNumDias) {
		this.deducOperacionNumDias = deducOperacionNumDias;
	}

	public BigDecimal getSumaAseguradaCelulares() {
		return this.sumaAseguradaCelulares;
	}

	public void setSumaAseguradaCelulares(BigDecimal sumaAseguradaCelulares) {
		this.sumaAseguradaCelulares = sumaAseguradaCelulares;
	}

	public BigDecimal getSumaAseguradaFijos() {
		return this.sumaAseguradaFijos;
	}

	public void setSumaAseguradaFijos(BigDecimal sumaAseguradaFijos) {
		this.sumaAseguradaFijos = sumaAseguradaFijos;
	}

	public BigDecimal getSumaAseguradaOtros() {
		return this.sumaAseguradaOtros;
	}

	public void setSumaAseguradaOtros(BigDecimal sumaAseguradaOtros) {
		this.sumaAseguradaOtros = sumaAseguradaOtros;
	}

	public BigDecimal getSumaAseguradaPortatil() {
		return this.sumaAseguradaPortatil;
	}

	public void setSumaAseguradaPortatil(BigDecimal sumaAseguradaPortatil) {
		this.sumaAseguradaPortatil = sumaAseguradaPortatil;
	}

	public BigDecimal getSumaAseguradaTotal() {
		return this.sumaAseguradaTotal;
	}

	public void setSumaAseguradaTotal(BigDecimal sumaAseguradaTotal) {
		this.sumaAseguradaTotal = sumaAseguradaTotal;
	}

	public BigDecimal getTasaCelulares() {
		return this.tasaCelulares;
	}

	public void setTasaCelulares(BigDecimal tasaCelulares) {
		this.tasaCelulares = tasaCelulares;
	}

	public BigDecimal getTasaEquiposFijos() {
		return this.tasaEquiposFijos;
	}

	public void setTasaEquiposFijos(BigDecimal tasaEquiposFijos) {
		this.tasaEquiposFijos = tasaEquiposFijos;
	}

	public BigDecimal getTasaEquiposPortatiles() {
		return this.tasaEquiposPortatiles;
	}

	public void setTasaEquiposPortatiles(BigDecimal tasaEquiposPortatiles) {
		this.tasaEquiposPortatiles = tasaEquiposPortatiles;
	}

	public BigDecimal getTasaExtDatos() {
		return this.tasaExtDatos;
	}

	public void setTasaExtDatos(BigDecimal tasaExtDatos) {
		this.tasaExtDatos = tasaExtDatos;
	}

	public BigDecimal getTasaHurtoEqElec() {
		return this.tasaHurtoEqElec;
	}

	public void setTasaHurtoEqElec(BigDecimal tasaHurtoEqElec) {
		this.tasaHurtoEqElec = tasaHurtoEqElec;
	}

	public BigDecimal getTasaOperacion() {
		return this.tasaOperacion;
	}

	public void setTasaOperacion(BigDecimal tasaOperacion) {
		this.tasaOperacion = tasaOperacion;
	}

	public BigDecimal getTasaOtrosEqElec() {
		return this.tasaOtrosEqElec;
	}

	public void setTasaOtrosEqElec(BigDecimal tasaOtrosEqElec) {
		this.tasaOtrosEqElec = tasaOtrosEqElec;
	}

	public List<ClausulasAddEquipo> getClausulasAddEquipos() {
		return this.clausulasAddEquipos;
	}

	public void setClausulasAddEquipos(List<ClausulasAddEquipo> clausulasAddEquipos) {
		this.clausulasAddEquipos = clausulasAddEquipos;
	}

	public ClausulasAddEquipo addClausulasAddEquipo(ClausulasAddEquipo clausulasAddEquipo) {
		getClausulasAddEquipos().add(clausulasAddEquipo);
		clausulasAddEquipo.setRamoEquipoElectronico(this);

		return clausulasAddEquipo;
	}

	public ClausulasAddEquipo removeClausulasAddEquipo(ClausulasAddEquipo clausulasAddEquipo) {
		getClausulasAddEquipos().remove(clausulasAddEquipo);
		clausulasAddEquipo.setRamoEquipoElectronico(null);

		return clausulasAddEquipo;
	}

	public List<CobertAddEquipo> getCobertAddEquipos() {
		return this.cobertAddEquipos;
	}

	public void setCobertAddEquipos(List<CobertAddEquipo> cobertAddEquipos) {
		this.cobertAddEquipos = cobertAddEquipos;
	}

	public CobertAddEquipo addCobertAddEquipo(CobertAddEquipo cobertAddEquipo) {
		getCobertAddEquipos().add(cobertAddEquipo);
		cobertAddEquipo.setRamoEquipoElectronico(this);

		return cobertAddEquipo;
	}

	public CobertAddEquipo removeCobertAddEquipo(CobertAddEquipo cobertAddEquipo) {
		getCobertAddEquipos().remove(cobertAddEquipo);
		cobertAddEquipo.setRamoEquipoElectronico(null);

		return cobertAddEquipo;
	}

	public List<CobertEquipo> getCobertEquipos() {
		return this.cobertEquipos;
	}

	public void setCobertEquipos(List<CobertEquipo> cobertEquipos) {
		this.cobertEquipos = cobertEquipos;
	}

	public CobertEquipo addCobertEquipo(CobertEquipo cobertEquipo) {
		getCobertEquipos().add(cobertEquipo);
		cobertEquipo.setRamoEquipoElectronico(this);

		return cobertEquipo;
	}

	public CobertEquipo removeCobertEquipo(CobertEquipo cobertEquipo) {
		getCobertEquipos().remove(cobertEquipo);
		cobertEquipo.setRamoEquipoElectronico(null);

		return cobertEquipo;
	}

	public List<GarantiaPoliza> getGarantiaPolizas() {
		return this.garantiaPolizas;
	}

	public void setGarantiaPolizas(List<GarantiaPoliza> garantiaPolizas) {
		this.garantiaPolizas = garantiaPolizas;
	}

	public GarantiaPoliza addGarantiaPoliza(GarantiaPoliza garantiaPoliza) {
		getGarantiaPolizas().add(garantiaPoliza);
		garantiaPoliza.setRamoEquipoElectronico(this);

		return garantiaPoliza;
	}

	public GarantiaPoliza removeGarantiaPoliza(GarantiaPoliza garantiaPoliza) {
		getGarantiaPolizas().remove(garantiaPoliza);
		garantiaPoliza.setRamoEquipoElectronico(null);

		return garantiaPoliza;
	}

	public List<ObjAsegEquipo> getObjAsegEquipos() {
		return this.objAsegEquipos;
	}

	public void setObjAsegEquipos(List<ObjAsegEquipo> objAsegEquipos) {
		this.objAsegEquipos = objAsegEquipos;
	}

	public ObjAsegEquipo addObjAsegEquipo(ObjAsegEquipo objAsegEquipo) {
		getObjAsegEquipos().add(objAsegEquipo);
		objAsegEquipo.setRamoEquipoElectronico(this);

		return objAsegEquipo;
	}

	public ObjAsegEquipo removeObjAsegEquipo(ObjAsegEquipo objAsegEquipo) {
		getObjAsegEquipos().remove(objAsegEquipo);
		objAsegEquipo.setRamoEquipoElectronico(null);

		return objAsegEquipo;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}