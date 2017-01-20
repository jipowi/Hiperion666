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
 * The persistent class for the ramo_buen_uso_ant database table.
 * 
 */
@Entity
@Table(name = "ramo_buen_uso_ant")
@NamedQuery(name = "RamoBuenUsoAnt.findAll", query = "SELECT r FROM RamoBuenUsoAnt r")
public class RamoBuenUsoAnt extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ind_buen_uso_ant")
	private Integer indBuenUsoAnt;

	@Column(name = "obj_aseg_anticipo")
	private String objAsegAnticipo;

	@Column(name = "sector_anticipo")
	private String sectorAnticipo;

	@Column(name = "tipo_contragarantia_buen_ant")
	private String tipoContragarantiaBuenAnt;

	@Column(name = "valor_contrato_anticipo")
	private BigDecimal valorContratoAnticipo;

	@Column(name = "valor_poliza_anticipo")
	private BigDecimal valorPolizaAnticipo;

	// bi-directional many-to-one association to CobertBuenUsoAnt
	@OneToMany(mappedBy = "ramoBuenUsoAnt")
	private List<CobertBuenUsoAnt> cobertBuenUsoAnts;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoBuenUsoAnt() {
	}

	public Integer getIndBuenUsoAnt() {
		return this.indBuenUsoAnt;
	}

	public void setIndBuenUsoAnt(Integer indBuenUsoAnt) {
		this.indBuenUsoAnt = indBuenUsoAnt;
	}

	public String getObjAsegAnticipo() {
		return this.objAsegAnticipo;
	}

	public void setObjAsegAnticipo(String objAsegAnticipo) {
		this.objAsegAnticipo = objAsegAnticipo;
	}

	public String getSectorAnticipo() {
		return this.sectorAnticipo;
	}

	public void setSectorAnticipo(String sectorAnticipo) {
		this.sectorAnticipo = sectorAnticipo;
	}

	public String getTipoContragarantiaBuenAnt() {
		return this.tipoContragarantiaBuenAnt;
	}

	public void setTipoContragarantiaBuenAnt(String tipoContragarantiaBuenAnt) {
		this.tipoContragarantiaBuenAnt = tipoContragarantiaBuenAnt;
	}

	public BigDecimal getValorContratoAnticipo() {
		return this.valorContratoAnticipo;
	}

	public void setValorContratoAnticipo(BigDecimal valorContratoAnticipo) {
		this.valorContratoAnticipo = valorContratoAnticipo;
	}

	public BigDecimal getValorPolizaAnticipo() {
		return this.valorPolizaAnticipo;
	}

	public void setValorPolizaAnticipo(BigDecimal valorPolizaAnticipo) {
		this.valorPolizaAnticipo = valorPolizaAnticipo;
	}

	public List<CobertBuenUsoAnt> getCobertBuenUsoAnts() {
		return this.cobertBuenUsoAnts;
	}

	public void setCobertBuenUsoAnts(List<CobertBuenUsoAnt> cobertBuenUsoAnts) {
		this.cobertBuenUsoAnts = cobertBuenUsoAnts;
	}

	public CobertBuenUsoAnt addCobertBuenUsoAnt(CobertBuenUsoAnt cobertBuenUsoAnt) {
		getCobertBuenUsoAnts().add(cobertBuenUsoAnt);
		cobertBuenUsoAnt.setRamoBuenUsoAnt(this);

		return cobertBuenUsoAnt;
	}

	public CobertBuenUsoAnt removeCobertBuenUsoAnt(CobertBuenUsoAnt cobertBuenUsoAnt) {
		getCobertBuenUsoAnts().remove(cobertBuenUsoAnt);
		cobertBuenUsoAnt.setRamoBuenUsoAnt(null);

		return cobertBuenUsoAnt;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}