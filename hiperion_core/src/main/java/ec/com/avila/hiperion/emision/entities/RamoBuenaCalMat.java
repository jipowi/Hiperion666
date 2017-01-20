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
 * The persistent class for the ramo_buena_cal_mat database table.
 * 
 */
@Entity
@Table(name = "ramo_buena_cal_mat")
@NamedQuery(name = "RamoBuenaCalMat.findAll", query = "SELECT r FROM RamoBuenaCalMat r")
public class RamoBuenaCalMat extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_material")
	private Integer idMaterial;

	@Column(name = "obj_aseg_cal_mat")
	private String objAsegCalMat;

	@Column(name = "sector_cal_mat")
	private String sectorCalMat;

	@Column(name = "valor_contrato_materiales")
	private BigDecimal valorContratoMateriales;

	@Column(name = "valor_poliza_materiales")
	private BigDecimal valorPolizaMateriales;

	// bi-directional many-to-one association to CobertMateriale
	@OneToMany(mappedBy = "ramoBuenaCalMat")
	private List<CobertMateriale> cobertMateriales;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoBuenaCalMat() {
	}

	public Integer getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getObjAsegCalMat() {
		return this.objAsegCalMat;
	}

	public void setObjAsegCalMat(String objAsegCalMat) {
		this.objAsegCalMat = objAsegCalMat;
	}

	public String getSectorCalMat() {
		return this.sectorCalMat;
	}

	public void setSectorCalMat(String sectorCalMat) {
		this.sectorCalMat = sectorCalMat;
	}

	public BigDecimal getValorContratoMateriales() {
		return this.valorContratoMateriales;
	}

	public void setValorContratoMateriales(BigDecimal valorContratoMateriales) {
		this.valorContratoMateriales = valorContratoMateriales;
	}

	public BigDecimal getValorPolizaMateriales() {
		return this.valorPolizaMateriales;
	}

	public void setValorPolizaMateriales(BigDecimal valorPolizaMateriales) {
		this.valorPolizaMateriales = valorPolizaMateriales;
	}

	public List<CobertMateriale> getCobertMateriales() {
		return this.cobertMateriales;
	}

	public void setCobertMateriales(List<CobertMateriale> cobertMateriales) {
		this.cobertMateriales = cobertMateriales;
	}

	public CobertMateriale addCobertMateriale(CobertMateriale cobertMateriale) {
		getCobertMateriales().add(cobertMateriale);
		cobertMateriale.setRamoBuenaCalMat(this);

		return cobertMateriale;
	}

	public CobertMateriale removeCobertMateriale(CobertMateriale cobertMateriale) {
		getCobertMateriales().remove(cobertMateriale);
		cobertMateriale.setRamoBuenaCalMat(null);

		return cobertMateriale;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}