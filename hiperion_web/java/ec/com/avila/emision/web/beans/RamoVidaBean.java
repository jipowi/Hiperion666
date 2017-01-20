/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,19/01/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class RamoVidaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de poliza
	private BigDecimal primaNetaPersona;
	private BigDecimal primaTotalPersona;
	private Integer totalAsegurados;
	private BigDecimal tasa;
	private String filePolizaVigente;
	private String fileCondGenerales;

	// Tabla Cobetura Vida
	private String cebertura;
	private BigDecimal valor;

	// Getters and Setters
	/**
	 * @return the primaNetaPersona
	 */
	public BigDecimal getPrimaNetaPersona() {
		return primaNetaPersona;
	}

	/**
	 * @param primaNetaPersona
	 *            the primaNetaPersona to set
	 */
	public void setPrimaNetaPersona(BigDecimal primaNetaPersona) {
		this.primaNetaPersona = primaNetaPersona;
	}

	/**
	 * @return the primaTotalPersona
	 */
	public BigDecimal getPrimaTotalPersona() {
		return primaTotalPersona;
	}

	/**
	 * @param primaTotalPersona
	 *            the primaTotalPersona to set
	 */
	public void setPrimaTotalPersona(BigDecimal primaTotalPersona) {
		this.primaTotalPersona = primaTotalPersona;
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
	 * @return the fileCondGenerales
	 */
	public String getFileCondGenerales() {
		return fileCondGenerales;
	}

	/**
	 * @param fileCondGenerales
	 *            the fileCondGenerales to set
	 */
	public void setFileCondGenerales(String fileCondGenerales) {
		this.fileCondGenerales = fileCondGenerales;
	}

	/**
	 * @return the cebertura
	 */
	public String getCebertura() {
		return cebertura;
	}

	/**
	 * @param cebertura
	 *            the cebertura to set
	 */
	public void setCebertura(String cebertura) {
		this.cebertura = cebertura;
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
	 * @return the totalAsegurados
	 */
	public Integer getTotalAsegurados() {
		return totalAsegurados;
	}

	/**
	 * @param totalAsegurados
	 *            the totalAsegurados to set
	 */
	public void setTotalAsegurados(Integer totalAsegurados) {
		this.totalAsegurados = totalAsegurados;
	}

	/**
	 * @return the tasa
	 */
	public BigDecimal getTasa() {
		return tasa;
	}

	/**
	 * @param tasa
	 *            the tasa to set
	 */
	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
	}

}
