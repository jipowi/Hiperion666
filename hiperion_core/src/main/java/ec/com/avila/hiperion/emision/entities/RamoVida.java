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
 * The persistent class for the ramo_vida database table.
 * 
 */
@Entity
@Table(name = "ramo_vida")
@NamedQuery(name = "RamoVida.findAll", query = "SELECT r FROM RamoVida r")
public class RamoVida extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vida")
	private Integer idVida;

	@Column(name = "prima_neta_persona_vida")
	private BigDecimal primaNetaPersonaVida;

	@Column(name = "prima_total_persona_vida")
	private BigDecimal primaTotalPersonaVida;

	@Column(name = "tasa_incapicidad")
	private BigDecimal tasaIncapicidad;

	@Column(name = "tasa_muerte")
	private BigDecimal tasaMuerte;

	@Column(name = "tasa_vida")
	private BigDecimal tasaVida;

	@Column(name = "total_asegurados")
	private Integer totalAsegurados;

	// bi-directional many-to-one association to GrupoVida
	@OneToMany(mappedBy = "ramoVida")
	private List<GrupoVida> grupoVidas;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoVida() {
	}

	public Integer getIdVida() {
		return this.idVida;
	}

	public void setIdVida(Integer idVida) {
		this.idVida = idVida;
	}

	public BigDecimal getPrimaNetaPersonaVida() {
		return this.primaNetaPersonaVida;
	}

	public void setPrimaNetaPersonaVida(BigDecimal primaNetaPersonaVida) {
		this.primaNetaPersonaVida = primaNetaPersonaVida;
	}

	public BigDecimal getPrimaTotalPersonaVida() {
		return this.primaTotalPersonaVida;
	}

	public void setPrimaTotalPersonaVida(BigDecimal primaTotalPersonaVida) {
		this.primaTotalPersonaVida = primaTotalPersonaVida;
	}

	public BigDecimal getTasaIncapicidad() {
		return this.tasaIncapicidad;
	}

	public void setTasaIncapicidad(BigDecimal tasaIncapicidad) {
		this.tasaIncapicidad = tasaIncapicidad;
	}

	public BigDecimal getTasaMuerte() {
		return this.tasaMuerte;
	}

	public void setTasaMuerte(BigDecimal tasaMuerte) {
		this.tasaMuerte = tasaMuerte;
	}

	public BigDecimal getTasaVida() {
		return this.tasaVida;
	}

	public void setTasaVida(BigDecimal tasaVida) {
		this.tasaVida = tasaVida;
	}

	public Integer getTotalAsegurados() {
		return this.totalAsegurados;
	}

	public void setTotalAsegurados(Integer totalAsegurados) {
		this.totalAsegurados = totalAsegurados;
	}

	public List<GrupoVida> getGrupoVidas() {
		return this.grupoVidas;
	}

	public void setGrupoVidas(List<GrupoVida> grupoVidas) {
		this.grupoVidas = grupoVidas;
	}

	public GrupoVida addGrupoVida(GrupoVida grupoVida) {
		getGrupoVidas().add(grupoVida);
		grupoVida.setRamoVida(this);

		return grupoVida;
	}

	public GrupoVida removeGrupoVida(GrupoVida grupoVida) {
		getGrupoVidas().remove(grupoVida);
		grupoVida.setRamoVida(null);

		return grupoVida;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}