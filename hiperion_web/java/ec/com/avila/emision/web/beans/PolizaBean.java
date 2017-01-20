/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * <b> Permite encapsular varios objetos en un único objeto, para hacer uso de un solo objeto en lugar de varios más
 * simples. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class PolizaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codigoRamo;

	// Cabecera de la poliza
	private Double derechoEmision;
	private Double diasCobertura;
	private String ejecutivo;
	private String horaDesde;
	private String horaHasta;
	private String numeroAnexo;
	private Double numeroPoliza;
	private Double primaNeta;
	private String ramo;
	private Double seguroCampesino;
	private Double sumaAsegurada;
	private BigDecimal superBanSeguros;
	private Date vigenciaDesde;
	private Date vigenciaHasta;

	// Pago de Poliza
	private String formaPago;
	private BigDecimal adicionalSegCampesino;
	private BigDecimal cuotaInicial;
	private Integer idFormaPago;
	private BigDecimal iva;
	private String numeroFactura;
	private BigDecimal subtotal;
	private BigDecimal total;

	// Financiamiento
	private BigDecimal numeroCuota;
	private BigDecimal valor;
	private Date fechaVencimiento;

	// Tarjeta de credito
	private Integer idTarjetaCredito;
	private String tipoPago;
	private BigDecimal valorPago;
	private BigDecimal numeroMeses;

	public Double getDerechoEmision() {
		return derechoEmision;
	}

	public void setDerechoEmision(Double derechoEmision) {
		this.derechoEmision = derechoEmision;
	}

	public Double getDiasCobertura() {
		return diasCobertura;
	}

	public void setDiasCobertura(Double diasCobertura) {
		this.diasCobertura = diasCobertura;
	}

	public String getEjecutivo() {
		return ejecutivo;
	}

	public void setEjecutivo(String ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public String getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(String horaDesde) {
		this.horaDesde = horaDesde;
	}

	public String getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(String horaHasta) {
		this.horaHasta = horaHasta;
	}

	public String getNumeroAnexo() {
		return numeroAnexo;
	}

	public void setNumeroAnexo(String numeroAnexo) {
		this.numeroAnexo = numeroAnexo;
	}

	public Double getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Double numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public Double getPrimaNeta() {
		return primaNeta;
	}

	public void setPrimaNeta(Double primaNeta) {
		this.primaNeta = primaNeta;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public Double getSeguroCampesino() {
		return seguroCampesino;
	}

	public void setSeguroCampesino(Double seguroCampesino) {
		this.seguroCampesino = seguroCampesino;
	}

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public BigDecimal getSuperBanSeguros() {
		return superBanSeguros;
	}

	public void setSuperBanSeguros(BigDecimal superBanSeguros) {
		this.superBanSeguros = superBanSeguros;
	}

	public Date getVigenciaDesde() {
		return vigenciaDesde;
	}

	public void setVigenciaDesde(Date vigenciaDesde) {
		this.vigenciaDesde = vigenciaDesde;
	}

	public Date getVigenciaHasta() {
		return vigenciaHasta;
	}

	public void setVigenciaHasta(Date vigenciaHasta) {
		this.vigenciaHasta = vigenciaHasta;
	}

	public BigDecimal getAdicionalSegCampesino() {
		return adicionalSegCampesino;
	}

	public void setAdicionalSegCampesino(BigDecimal adicionalSegCampesino) {
		this.adicionalSegCampesino = adicionalSegCampesino;
	}

	public BigDecimal getCuotaInicial() {
		return cuotaInicial;
	}

	public void setCuotaInicial(BigDecimal cuotaInicial) {
		this.cuotaInicial = cuotaInicial;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getNumeroCuota() {
		return numeroCuota;
	}

	public void setNumeroCuota(BigDecimal numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public BigDecimal getNumeroMeses() {
		return numeroMeses;
	}

	public void setNumeroMeses(BigDecimal numeroMeses) {
		this.numeroMeses = numeroMeses;
	}

	public Integer getIdFormaPago() {
		return idFormaPago;
	}

	public void setIdFormaPago(Integer idFormaPago) {
		this.idFormaPago = idFormaPago;
	}

	public Integer getIdTarjetaCredito() {
		return idTarjetaCredito;
	}

	public void setIdTarjetaCredito(Integer idTarjetaCredito) {
		this.idTarjetaCredito = idTarjetaCredito;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Integer getCodigoRamo() {
		return codigoRamo;
	}

	public void setCodigoRamo(Integer codigoRamo) {
		this.codigoRamo = codigoRamo;
	}

}
