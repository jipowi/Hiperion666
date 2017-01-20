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
 * The persistent class for the ramo_robo_asalto database table.
 * 
 */
@Entity
@Table(name = "ramo_robo_asalto")
@NamedQuery(name = "RamoRoboAsalto.findAll", query = "SELECT r FROM RamoRoboAsalto r")
public class RamoRoboAsalto extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_robo")
	private Integer idRobo;

	@Column(name = "tasa_contenidos")
	private BigDecimal tasaContenidos;

	@Column(name = "tasa_hurto_robo")
	private BigDecimal tasaHurtoRobo;

	@Column(name = "tasa_propiedad")
	private BigDecimal tasaPropiedad;

	@Column(name = "tasa_robo_asalto")
	private BigDecimal tasaRoboAsalto;

	// bi-directional many-to-one association to ClausulasAddRobo
	@OneToMany(mappedBy = "ramoRoboAsalto")
	private List<ClausulasAddRobo> clausulasAddRobos;

	// bi-directional many-to-one association to CobertAddRobo
	@OneToMany(mappedBy = "ramoRoboAsalto")
	private List<CobertAddRobo> cobertAddRobos;

	// bi-directional many-to-one association to CoberturaRobo
	@OneToMany(mappedBy = "ramoRoboAsalto")
	private List<CoberturaRobo> coberturaRobos;

	// bi-directional many-to-one association to CondEspRobo
	@OneToMany(mappedBy = "ramoRoboAsalto")
	private List<CondEspRobo> condEspRobos;

	// bi-directional many-to-one association to ObjAsegRobo
	@OneToMany(mappedBy = "ramoRoboAsalto")
	private List<ObjAsegRobo> objAsegRobos;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoRoboAsalto() {
	}

	public Integer getIdRobo() {
		return this.idRobo;
	}

	public void setIdRobo(Integer idRobo) {
		this.idRobo = idRobo;
	}

	public BigDecimal getTasaContenidos() {
		return this.tasaContenidos;
	}

	public void setTasaContenidos(BigDecimal tasaContenidos) {
		this.tasaContenidos = tasaContenidos;
	}

	public BigDecimal getTasaHurtoRobo() {
		return this.tasaHurtoRobo;
	}

	public void setTasaHurtoRobo(BigDecimal tasaHurtoRobo) {
		this.tasaHurtoRobo = tasaHurtoRobo;
	}

	public BigDecimal getTasaPropiedad() {
		return this.tasaPropiedad;
	}

	public void setTasaPropiedad(BigDecimal tasaPropiedad) {
		this.tasaPropiedad = tasaPropiedad;
	}

	public BigDecimal getTasaRoboAsalto() {
		return this.tasaRoboAsalto;
	}

	public void setTasaRoboAsalto(BigDecimal tasaRoboAsalto) {
		this.tasaRoboAsalto = tasaRoboAsalto;
	}

	public List<ClausulasAddRobo> getClausulasAddRobos() {
		return this.clausulasAddRobos;
	}

	public void setClausulasAddRobos(List<ClausulasAddRobo> clausulasAddRobos) {
		this.clausulasAddRobos = clausulasAddRobos;
	}

	public ClausulasAddRobo addClausulasAddRobo(ClausulasAddRobo clausulasAddRobo) {
		getClausulasAddRobos().add(clausulasAddRobo);
		clausulasAddRobo.setRamoRoboAsalto(this);

		return clausulasAddRobo;
	}

	public ClausulasAddRobo removeClausulasAddRobo(ClausulasAddRobo clausulasAddRobo) {
		getClausulasAddRobos().remove(clausulasAddRobo);
		clausulasAddRobo.setRamoRoboAsalto(null);

		return clausulasAddRobo;
	}

	public List<CobertAddRobo> getCobertAddRobos() {
		return this.cobertAddRobos;
	}

	public void setCobertAddRobos(List<CobertAddRobo> cobertAddRobos) {
		this.cobertAddRobos = cobertAddRobos;
	}

	public CobertAddRobo addCobertAddRobo(CobertAddRobo cobertAddRobo) {
		getCobertAddRobos().add(cobertAddRobo);
		cobertAddRobo.setRamoRoboAsalto(this);

		return cobertAddRobo;
	}

	public CobertAddRobo removeCobertAddRobo(CobertAddRobo cobertAddRobo) {
		getCobertAddRobos().remove(cobertAddRobo);
		cobertAddRobo.setRamoRoboAsalto(null);

		return cobertAddRobo;
	}

	public List<CoberturaRobo> getCoberturaRobos() {
		return this.coberturaRobos;
	}

	public void setCoberturaRobos(List<CoberturaRobo> coberturaRobos) {
		this.coberturaRobos = coberturaRobos;
	}

	public CoberturaRobo addCoberturaRobo(CoberturaRobo coberturaRobo) {
		getCoberturaRobos().add(coberturaRobo);
		coberturaRobo.setRamoRoboAsalto(this);

		return coberturaRobo;
	}

	public CoberturaRobo removeCoberturaRobo(CoberturaRobo coberturaRobo) {
		getCoberturaRobos().remove(coberturaRobo);
		coberturaRobo.setRamoRoboAsalto(null);

		return coberturaRobo;
	}

	public List<CondEspRobo> getCondEspRobos() {
		return this.condEspRobos;
	}

	public void setCondEspRobos(List<CondEspRobo> condEspRobos) {
		this.condEspRobos = condEspRobos;
	}

	public CondEspRobo addCondEspRobo(CondEspRobo condEspRobo) {
		getCondEspRobos().add(condEspRobo);
		condEspRobo.setRamoRoboAsalto(this);

		return condEspRobo;
	}

	public CondEspRobo removeCondEspRobo(CondEspRobo condEspRobo) {
		getCondEspRobos().remove(condEspRobo);
		condEspRobo.setRamoRoboAsalto(null);

		return condEspRobo;
	}

	public List<ObjAsegRobo> getObjAsegRobos() {
		return this.objAsegRobos;
	}

	public void setObjAsegRobos(List<ObjAsegRobo> objAsegRobos) {
		this.objAsegRobos = objAsegRobos;
	}

	public ObjAsegRobo addObjAsegRobo(ObjAsegRobo objAsegRobo) {
		getObjAsegRobos().add(objAsegRobo);
		objAsegRobo.setRamoRoboAsalto(this);

		return objAsegRobo;
	}

	public ObjAsegRobo removeObjAsegRobo(ObjAsegRobo objAsegRobo) {
		getObjAsegRobos().remove(objAsegRobo);
		objAsegRobo.setRamoRoboAsalto(null);

		return objAsegRobo;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}