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
 * The persistent class for the ramo_agropecuario database table.
 * 
 */
@Entity
@Table(name = "ramo_agropecuario")
@NamedQuery(name = "RamoAgropecuario.findAll", query = "SELECT r FROM RamoAgropecuario r")
public class RamoAgropecuario extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agropecuario")
	private Integer idAgropecuario;

	@Column(name = "deduc_agro")
	private BigDecimal deducAgro;

	@Column(name = "tasa_agro")
	private BigDecimal tasaAgro;

	// bi-directional many-to-one association to ArchivoBase
	@OneToMany(mappedBy = "ramoAgropecuario")
	private List<ArchivoBase> archivoBases;

	// bi-directional many-to-one association to ClausulasAddAgro
	@OneToMany(mappedBy = "ramoAgropecuario")
	private List<ClausulasAddAgro> clausulasAddAgros;

	// bi-directional many-to-one association to CobertAgro
	@OneToMany(mappedBy = "ramoAgropecuario")
	private List<CobertAgro> cobertAgros;

	// bi-directional many-to-one association to ObjAsegAgropecuario
	@OneToMany(mappedBy = "ramoAgropecuario")
	private List<ObjAsegAgropecuario> objAsegAgropecuarios;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoAgropecuario() {
	}

	public Integer getIdAgropecuario() {
		return this.idAgropecuario;
	}

	public void setIdAgropecuario(Integer idAgropecuario) {
		this.idAgropecuario = idAgropecuario;
	}

	public BigDecimal getDeducAgro() {
		return this.deducAgro;
	}

	public void setDeducAgro(BigDecimal deducAgro) {
		this.deducAgro = deducAgro;
	}

	public BigDecimal getTasaAgro() {
		return this.tasaAgro;
	}

	public void setTasaAgro(BigDecimal tasaAgro) {
		this.tasaAgro = tasaAgro;
	}

	public List<ArchivoBase> getArchivoBases() {
		return this.archivoBases;
	}

	public void setArchivoBases(List<ArchivoBase> archivoBases) {
		this.archivoBases = archivoBases;
	}

	public ArchivoBase addArchivoBas(ArchivoBase archivoBas) {
		getArchivoBases().add(archivoBas);
		archivoBas.setRamoAgropecuario(this);

		return archivoBas;
	}

	public ArchivoBase removeArchivoBas(ArchivoBase archivoBas) {
		getArchivoBases().remove(archivoBas);
		archivoBas.setRamoAgropecuario(null);

		return archivoBas;
	}

	public List<ClausulasAddAgro> getClausulasAddAgros() {
		return this.clausulasAddAgros;
	}

	public void setClausulasAddAgros(List<ClausulasAddAgro> clausulasAddAgros) {
		this.clausulasAddAgros = clausulasAddAgros;
	}

	public ClausulasAddAgro addClausulasAddAgro(ClausulasAddAgro clausulasAddAgro) {
		getClausulasAddAgros().add(clausulasAddAgro);
		clausulasAddAgro.setRamoAgropecuario(this);

		return clausulasAddAgro;
	}

	public ClausulasAddAgro removeClausulasAddAgro(ClausulasAddAgro clausulasAddAgro) {
		getClausulasAddAgros().remove(clausulasAddAgro);
		clausulasAddAgro.setRamoAgropecuario(null);

		return clausulasAddAgro;
	}

	public List<CobertAgro> getCobertAgros() {
		return this.cobertAgros;
	}

	public void setCobertAgros(List<CobertAgro> cobertAgros) {
		this.cobertAgros = cobertAgros;
	}

	public CobertAgro addCobertAgro(CobertAgro cobertAgro) {
		getCobertAgros().add(cobertAgro);
		cobertAgro.setRamoAgropecuario(this);

		return cobertAgro;
	}

	public CobertAgro removeCobertAgro(CobertAgro cobertAgro) {
		getCobertAgros().remove(cobertAgro);
		cobertAgro.setRamoAgropecuario(null);

		return cobertAgro;
	}

	public List<ObjAsegAgropecuario> getObjAsegAgropecuarios() {
		return this.objAsegAgropecuarios;
	}

	public void setObjAsegAgropecuarios(List<ObjAsegAgropecuario> objAsegAgropecuarios) {
		this.objAsegAgropecuarios = objAsegAgropecuarios;
	}

	public ObjAsegAgropecuario addObjAsegAgropecuario(ObjAsegAgropecuario objAsegAgropecuario) {
		getObjAsegAgropecuarios().add(objAsegAgropecuario);
		objAsegAgropecuario.setRamoAgropecuario(this);

		return objAsegAgropecuario;
	}

	public ObjAsegAgropecuario removeObjAsegAgropecuario(ObjAsegAgropecuario objAsegAgropecuario) {
		getObjAsegAgropecuarios().remove(objAsegAgropecuario);
		objAsegAgropecuario.setRamoAgropecuario(null);

		return objAsegAgropecuario;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}