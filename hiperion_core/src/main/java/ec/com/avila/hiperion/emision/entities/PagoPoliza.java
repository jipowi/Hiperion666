package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the pago_poliza database table.
 * 
 */
@Entity
@Table(name = "pago_poliza")
@NamedQuery(name = "PagoPoliza.findAll", query = "SELECT p FROM PagoPoliza p")
public class PagoPoliza extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pago_poliza")
	private Integer idPagoPoliza;

	@Column(name = "adicional_seg_campesino")
	private BigDecimal adicionalSegCampesino;

	@Column(name = "cuota_inicial")
	private BigDecimal cuotaInicial;

	private BigDecimal iva;

	@Column(name = "numero_factura")
	private String numeroFactura;

	private BigDecimal subtotal;

	@Column(name = "numero_meses")
	private BigDecimal numeroMeses;

	@Column(name = "tarjeta")
	private String tarjeta;

	@Column(name = "tipo_pago")
	private String tipoPago;

	@Column(name = "valor_total_pago_poliza")
	private BigDecimal valorTotalPagoPoliza;

	// bi-directional many-to-one association to Financiamiento
	@OneToMany(mappedBy = "pagoPoliza")
	private List<Financiamiento> financiamientos;

	// bi-directional many-to-one association to Poliza
	@OneToMany(mappedBy = "pagoPoliza")
	private List<Poliza> polizas;

	public PagoPoliza() {
	}

	public Integer getIdPagoPoliza() {
		return this.idPagoPoliza;
	}

	public void setIdPagoPoliza(Integer idPagoPoliza) {
		this.idPagoPoliza = idPagoPoliza;
	}

	public BigDecimal getAdicionalSegCampesino() {
		return this.adicionalSegCampesino;
	}

	public void setAdicionalSegCampesino(BigDecimal adicionalSegCampesino) {
		this.adicionalSegCampesino = adicionalSegCampesino;
	}

	public BigDecimal getCuotaInicial() {
		return this.cuotaInicial;
	}

	public void setCuotaInicial(BigDecimal cuotaInicial) {
		this.cuotaInicial = cuotaInicial;
	}

	public BigDecimal getIva() {
		return this.iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public String getNumeroFactura() {
		return this.numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getValorTotalPagoPoliza() {
		return this.valorTotalPagoPoliza;
	}

	public void setValorTotalPagoPoliza(BigDecimal valorTotalPagoPoliza) {
		this.valorTotalPagoPoliza = valorTotalPagoPoliza;
	}

	public List<Financiamiento> getFinanciamientos() {
		return this.financiamientos;
	}

	public void setFinanciamientos(List<Financiamiento> financiamientos) {
		this.financiamientos = financiamientos;
	}

	public Financiamiento addFinanciamiento(Financiamiento financiamiento) {
		getFinanciamientos().add(financiamiento);
		financiamiento.setPagoPoliza(this);

		return financiamiento;
	}

	public Financiamiento removeFinanciamiento(Financiamiento financiamiento) {
		getFinanciamientos().remove(financiamiento);
		financiamiento.setPagoPoliza(null);

		return financiamiento;
	}

	public List<Poliza> getPolizas() {
		return this.polizas;
	}

	public void setPolizas(List<Poliza> polizas) {
		this.polizas = polizas;
	}

	public Poliza addPoliza(Poliza poliza) {
		getPolizas().add(poliza);
		poliza.setPagoPoliza(this);

		return poliza;
	}

	public Poliza removePoliza(Poliza poliza) {
		getPolizas().remove(poliza);
		poliza.setPagoPoliza(null);

		return poliza;
	}

	/**
	 * @return the numeroMeses
	 */
	public BigDecimal getNumeroMeses() {
		return numeroMeses;
	}

	/**
	 * @param numeroMeses
	 *            the numeroMeses to set
	 */
	public void setNumeroMeses(BigDecimal numeroMeses) {
		this.numeroMeses = numeroMeses;
	}

	/**
	 * @return the tarjeta
	 */
	public String getTarjeta() {
		return tarjeta;
	}

	/**
	 * @param tarjeta
	 *            the tarjeta to set
	 */
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	/**
	 * @return the tipoPago
	 */
	public String getTipoPago() {
		return tipoPago;
	}

	/**
	 * @param tipoPago
	 *            the tipoPago to set
	 */
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

}