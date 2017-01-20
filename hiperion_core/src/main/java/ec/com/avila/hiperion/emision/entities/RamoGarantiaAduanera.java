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
 * The persistent class for the ramo_garantia_aduanera database table.
 * 
 */
@Entity
@Table(name = "ramo_garantia_aduanera")
@NamedQuery(name = "RamoGarantiaAduanera.findAll", query = "SELECT r FROM RamoGarantiaAduanera r")
public class RamoGarantiaAduanera extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aduanera")
	private Integer idAduanera;

	@Column(name = "obj_asg_aduanera")
	private String objAsgAduanera;

	@Column(name = "sector_aduanera")
	private String sectorAduanera;

	@Column(name = "tipo_contragarantia_aduanera")
	private String tipoContragarantiaAduanera;

	@Column(name = "valor_contrato_aduanera")
	private BigDecimal valorContratoAduanera;

	@Column(name = "valor_poliza_aduanera")
	private BigDecimal valorPolizaAduanera;

	// bi-directional many-to-one association to CobertAduanera
	@OneToMany(mappedBy = "ramoGarantiaAduanera")
	private List<CobertAduanera> cobertAduaneras;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoGarantiaAduanera() {
	}

	public Integer getIdAduanera() {
		return this.idAduanera;
	}

	public void setIdAduanera(Integer idAduanera) {
		this.idAduanera = idAduanera;
	}

	public String getObjAsgAduanera() {
		return this.objAsgAduanera;
	}

	public void setObjAsgAduanera(String objAsgAduanera) {
		this.objAsgAduanera = objAsgAduanera;
	}

	public String getSectorAduanera() {
		return this.sectorAduanera;
	}

	public void setSectorAduanera(String sectorAduanera) {
		this.sectorAduanera = sectorAduanera;
	}

	public String getTipoContragarantiaAduanera() {
		return this.tipoContragarantiaAduanera;
	}

	public void setTipoContragarantiaAduanera(String tipoContragarantiaAduanera) {
		this.tipoContragarantiaAduanera = tipoContragarantiaAduanera;
	}

	public BigDecimal getValorContratoAduanera() {
		return this.valorContratoAduanera;
	}

	public void setValorContratoAduanera(BigDecimal valorContratoAduanera) {
		this.valorContratoAduanera = valorContratoAduanera;
	}

	public BigDecimal getValorPolizaAduanera() {
		return this.valorPolizaAduanera;
	}

	public void setValorPolizaAduanera(BigDecimal valorPolizaAduanera) {
		this.valorPolizaAduanera = valorPolizaAduanera;
	}

	public List<CobertAduanera> getCobertAduaneras() {
		return this.cobertAduaneras;
	}

	public void setCobertAduaneras(List<CobertAduanera> cobertAduaneras) {
		this.cobertAduaneras = cobertAduaneras;
	}

	public CobertAduanera addCobertAduanera(CobertAduanera cobertAduanera) {
		getCobertAduaneras().add(cobertAduanera);
		cobertAduanera.setRamoGarantiaAduanera(this);

		return cobertAduanera;
	}

	public CobertAduanera removeCobertAduanera(CobertAduanera cobertAduanera) {
		getCobertAduaneras().remove(cobertAduanera);
		cobertAduanera.setRamoGarantiaAduanera(null);

		return cobertAduanera;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}