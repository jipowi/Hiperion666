/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.math.BigDecimal;
import java.util.Date;

/** 
 * <b>
 * Permite manejar la informacion del cliente
 * </b>
 *  
 * @author Franklin Pozo B
 * @version 1.0,16/02/2016
 * @since JDK1.6
 */
public class ClientesPolizaDTO {
	
	
	//Datos Póliza
	private String numPoliza;
	private String aseguradora;
	private String numFactura;
	private String anexo;
	private String primaNeta;
	private Date vigenciaDesde;
	private Date vigenciaHasta;
	
	//Pagos
	private String formaPago;
	private String numeroPago;
	private BigDecimal valor;
	/**
	 * @return the numPoliza
	 */
	public String getNumPoliza() {
		return numPoliza;
	}
	/**
	 * @param numPoliza the numPoliza to set
	 */
	public void setNumPoliza(String numPoliza) {
		this.numPoliza = numPoliza;
	}
	/**
	 * @return the aseguradora
	 */
	public String getAseguradora() {
		return aseguradora;
	}
	/**
	 * @param aseguradora the aseguradora to set
	 */
	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}
	/**
	 * @return the numFactura
	 */
	public String getNumFactura() {
		return numFactura;
	}
	/**
	 * @param numFactura the numFactura to set
	 */
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	/**
	 * @return the anexo
	 */
	public String getAnexo() {
		return anexo;
	}
	/**
	 * @param anexo the anexo to set
	 */
	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	/**
	 * @return the primaNeta
	 */
	public String getPrimaNeta() {
		return primaNeta;
	}
	/**
	 * @param primaNeta the primaNeta to set
	 */
	public void setPrimaNeta(String primaNeta) {
		this.primaNeta = primaNeta;
	}
	/**
	 * @return the vigenciaDesde
	 */
	public Date getVigenciaDesde() {
		return vigenciaDesde;
	}
	/**
	 * @param vigenciaDesde the vigenciaDesde to set
	 */
	public void setVigenciaDesde(Date vigenciaDesde) {
		this.vigenciaDesde = vigenciaDesde;
	}
	/**
	 * @return the vigenciaHasta
	 */
	public Date getVigenciaHasta() {
		return vigenciaHasta;
	}
	/**
	 * @param vigenciaHasta the vigenciaHasta to set
	 */
	public void setVigenciaHasta(Date vigenciaHasta) {
		this.vigenciaHasta = vigenciaHasta;
	}
	/**
	 * @return the formaPago
	 */
	public String getFormaPago() {
		return formaPago;
	}
	/**
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	/**
	 * @return the numeroPago
	 */
	public String getNumeroPago() {
		return numeroPago;
	}
	/**
	 * @param numeroPago the numeroPago to set
	 */
	public void setNumeroPago(String numeroPago) {
		this.numeroPago = numeroPago;
	}
	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
	
	

}
