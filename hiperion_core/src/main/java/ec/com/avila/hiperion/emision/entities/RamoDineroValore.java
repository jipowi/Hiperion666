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
 * The persistent class for the ramo_dinero_valores database table.
 * 
 */
@Entity
@Table(name = "ramo_dinero_valores")
@NamedQuery(name = "RamoDineroValore.findAll", query = "SELECT r FROM RamoDineroValore r")
public class RamoDineroValore extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dinero")
	private Integer idDinero;

	@Column(name = "deduc_minimo_dinero")
	private BigDecimal deducMinimoDinero;

	@Column(name = "deduc_por_siniestro_dinero")
	private BigDecimal deducPorSiniestroDinero;

	@Column(name = "porcentaje_embarque_dinero")
	private BigDecimal porcentajeEmbarqueDinero;

	@Column(name = "tasa_dinero")
	private BigDecimal tasaDinero;

	// bi-directional many-to-one association to ClausulasAddDinero
	@OneToMany(mappedBy = "ramoDineroValore")
	private List<ClausulasAddDinero> clausulasAddDineros;

	// bi-directional many-to-one association to CobertDineroVal
	@OneToMany(mappedBy = "ramoDineroValore")
	private List<CobertDineroVal> cobertDineroVals;

	// bi-directional many-to-one association to ObjAsegDineroVal
	@OneToMany(mappedBy = "ramoDineroValore")
	private List<ObjAsegDineroVal> objAsegDineroVals;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoDineroValore() {
	}

	public Integer getIdDinero() {
		return this.idDinero;
	}

	public void setIdDinero(Integer idDinero) {
		this.idDinero = idDinero;
	}

	public BigDecimal getDeducMinimoDinero() {
		return this.deducMinimoDinero;
	}

	public void setDeducMinimoDinero(BigDecimal deducMinimoDinero) {
		this.deducMinimoDinero = deducMinimoDinero;
	}

	public BigDecimal getDeducPorSiniestroDinero() {
		return this.deducPorSiniestroDinero;
	}

	public void setDeducPorSiniestroDinero(BigDecimal deducPorSiniestroDinero) {
		this.deducPorSiniestroDinero = deducPorSiniestroDinero;
	}

	public BigDecimal getPorcentajeEmbarqueDinero() {
		return this.porcentajeEmbarqueDinero;
	}

	public void setPorcentajeEmbarqueDinero(BigDecimal porcentajeEmbarqueDinero) {
		this.porcentajeEmbarqueDinero = porcentajeEmbarqueDinero;
	}

	public BigDecimal getTasaDinero() {
		return this.tasaDinero;
	}

	public void setTasaDinero(BigDecimal tasaDinero) {
		this.tasaDinero = tasaDinero;
	}

	public List<ClausulasAddDinero> getClausulasAddDineros() {
		return this.clausulasAddDineros;
	}

	public void setClausulasAddDineros(List<ClausulasAddDinero> clausulasAddDineros) {
		this.clausulasAddDineros = clausulasAddDineros;
	}

	public ClausulasAddDinero addClausulasAddDinero(ClausulasAddDinero clausulasAddDinero) {
		getClausulasAddDineros().add(clausulasAddDinero);
		clausulasAddDinero.setRamoDineroValore(this);

		return clausulasAddDinero;
	}

	public ClausulasAddDinero removeClausulasAddDinero(ClausulasAddDinero clausulasAddDinero) {
		getClausulasAddDineros().remove(clausulasAddDinero);
		clausulasAddDinero.setRamoDineroValore(null);

		return clausulasAddDinero;
	}

	public List<CobertDineroVal> getCobertDineroVals() {
		return this.cobertDineroVals;
	}

	public void setCobertDineroVals(List<CobertDineroVal> cobertDineroVals) {
		this.cobertDineroVals = cobertDineroVals;
	}

	public CobertDineroVal addCobertDineroVal(CobertDineroVal cobertDineroVal) {
		getCobertDineroVals().add(cobertDineroVal);
		cobertDineroVal.setRamoDineroValore(this);

		return cobertDineroVal;
	}

	public CobertDineroVal removeCobertDineroVal(CobertDineroVal cobertDineroVal) {
		getCobertDineroVals().remove(cobertDineroVal);
		cobertDineroVal.setRamoDineroValore(null);

		return cobertDineroVal;
	}

	public List<ObjAsegDineroVal> getObjAsegDineroVals() {
		return this.objAsegDineroVals;
	}

	public void setObjAsegDineroVals(List<ObjAsegDineroVal> objAsegDineroVals) {
		this.objAsegDineroVals = objAsegDineroVals;
	}

	public ObjAsegDineroVal addObjAsegDineroVal(ObjAsegDineroVal objAsegDineroVal) {
		getObjAsegDineroVals().add(objAsegDineroVal);
		objAsegDineroVal.setRamoDineroValore(this);

		return objAsegDineroVal;
	}

	public ObjAsegDineroVal removeObjAsegDineroVal(ObjAsegDineroVal objAsegDineroVal) {
		getObjAsegDineroVals().remove(objAsegDineroVal);
		objAsegDineroVal.setRamoDineroValore(null);

		return objAsegDineroVal;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}