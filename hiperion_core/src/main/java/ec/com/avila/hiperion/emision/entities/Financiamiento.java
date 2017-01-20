package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the financiamiento database table.
 * 
 */
@Entity
@NamedQuery(name="Financiamiento.findAll", query="SELECT f FROM Financiamiento f")
public class Financiamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_financiamiento")
	private Integer idFinanciamiento;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vencimiento")
	private Date fechaVencimiento;

	@Column(name="numero_cuota")
	private Integer numeroCuota;
	
	@Column(name="valor_letra")
	private BigDecimal valorLetra;

	//bi-directional many-to-one association to PagoPoliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pago_poliza")
	private PagoPoliza pagoPoliza;

	public Financiamiento() {
	}

	public Integer getIdFinanciamiento() {
		return this.idFinanciamiento;
	}

	public void setIdFinanciamiento(Integer idFinanciamiento) {
		this.idFinanciamiento = idFinanciamiento;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Integer getNumeroCuota() {
		return this.numeroCuota;
	}

	public void setNumeroCuota(Integer numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public PagoPoliza getPagoPoliza() {
		return this.pagoPoliza;
	}

	public void setPagoPoliza(PagoPoliza pagoPoliza) {
		this.pagoPoliza = pagoPoliza;
	}

	/**
	 * @return the valorLetra
	 */
	public BigDecimal getValorLetra() {
		return valorLetra;
	}

	/**
	 * @param valorLetra the valorLetra to set
	 */
	public void setValorLetra(BigDecimal valorLetra) {
		this.valorLetra = valorLetra;
	}

	
}