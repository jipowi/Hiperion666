/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * <b> <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples </b> </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,15/02/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class RamoBuenUsoAnticipoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private String sector;
	private String fileContrato;
	private BigDecimal valorPoliza;
	private BigDecimal valorContrato;
	private String tipoContragarantia;
	private String fileCondicionesGenerales;
	private String filePolizaVigente;

	// Tabla Objeto Asegurado
	public String objetoAsegurado;

	// Tabla Coberturas
	private String cobertura;
	private BigDecimal valor;

	// Getters and Setters
	/**
	 * @return the sector
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * @param sector
	 *            the sector to set
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}

	/**
	 * @return the fileContrato
	 */
	public String getFileContrato() {
		return fileContrato;
	}

	/**
	 * @param fileContrato
	 *            the fileContrato to set
	 */
	public void setFileContrato(String fileContrato) {
		this.fileContrato = fileContrato;
	}

	/**
	 * @return the valorPoliza
	 */
	public BigDecimal getValorPoliza() {
		return valorPoliza;
	}

	/**
	 * @param valorPoliza
	 *            the valorPoliza to set
	 */
	public void setValorPoliza(BigDecimal valorPoliza) {
		this.valorPoliza = valorPoliza;
	}

	/**
	 * @return the valorContrato
	 */
	public BigDecimal getValorContrato() {
		return valorContrato;
	}

	/**
	 * @param valorContrato
	 *            the valorContrato to set
	 */
	public void setValorContrato(BigDecimal valorContrato) {
		this.valorContrato = valorContrato;
	}

	/**
	 * @return the tipoContragarantia
	 */
	public String getTipoContragarantia() {
		return tipoContragarantia;
	}

	/**
	 * @param tipoContragarantia
	 *            the tipoContragarantia to set
	 */
	public void setTipoContragarantia(String tipoContragarantia) {
		this.tipoContragarantia = tipoContragarantia;
	}

	/**
	 * @return the fileCondicionesGenerales
	 */
	public String getFileCondicionesGenerales() {
		return fileCondicionesGenerales;
	}

	/**
	 * @param fileCondicionesGenerales
	 *            the fileCondicionesGenerales to set
	 */
	public void setFileCondicionesGenerales(String fileCondicionesGenerales) {
		this.fileCondicionesGenerales = fileCondicionesGenerales;
	}

	/**
	 * @return the filePolizaVigente
	 */
	public String getFilePolizaVigente() {
		return filePolizaVigente;
	}

	/**
	 * @param filePolizaVigente
	 *            the filePolizaVigente to set
	 */
	public void setFilePolizaVigente(String filePolizaVigente) {
		this.filePolizaVigente = filePolizaVigente;
	}

	/**
	 * @return the cobertura
	 */
	public String getCobertura() {
		return cobertura;
	}

	/**
	 * @param cobertura
	 *            the cobertura to set
	 */
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * @return the objetoAsegurado
	 */
	public String getObjetoAsegurado() {
		return objetoAsegurado;
	}

	/**
	 * @param objetoAsegurado
	 *            the objetoAsegurado to set
	 */
	public void setObjetoAsegurado(String objetoAsegurado) {
		this.objetoAsegurado = objetoAsegurado;
	}

}
