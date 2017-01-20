/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoFidelidadBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private String sector;
	private Integer idModalidad;
	private BigDecimal valorColusorio;
	private BigDecimal valorIndividual;
	private BigDecimal tasa;
	private String filePolizaVigente;
	private String cargo;
	private String nombreFuncionario;

	// Tabla Clausulas Adicionales Fidelidad
	private String clausula;

	// Tabla Coberturas fidelidad
	private String cebertura;
	private BigDecimal valor;

	// Deducibles

	private BigDecimal porcentajeValorSiniestro;
	private BigDecimal minimoSiniestro;

	// Cliente - Aseguradora
	private String identificacion;
	private String nombreCliente;
	private String aseguradora;
	private String contactoAseguradora;

	// Getters and Setters
	
	

	/**
	 * @return the porcentajeValorSiniestro
	 */
	public BigDecimal getPorcentajeValorSiniestro() {
		return porcentajeValorSiniestro;
	}

	/**
	 * @return the contactoAseguradora
	 */
	public String getContactoAseguradora() {
		return contactoAseguradora;
	}

	/**
	 * @param contactoAseguradora the contactoAseguradora to set
	 */
	public void setContactoAseguradora(String contactoAseguradora) {
		this.contactoAseguradora = contactoAseguradora;
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
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion
	 *            the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @param porcentajeValorSiniestro
	 *            the porcentajeValorSiniestro to set
	 */
	public void setPorcentajeValorSiniestro(BigDecimal porcentajeValorSiniestro) {
		this.porcentajeValorSiniestro = porcentajeValorSiniestro;
	}

	/**
	 * @return the minimoSiniestro
	 */
	public BigDecimal getMinimoSiniestro() {
		return minimoSiniestro;
	}

	/**
	 * @param minimoSiniestro
	 *            the minimoSiniestro to set
	 */
	public void setMinimoSiniestro(BigDecimal minimoSiniestro) {
		this.minimoSiniestro = minimoSiniestro;
	}

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
	 * @return the idModalidad
	 */
	public Integer getIdModalidad() {
		return idModalidad;
	}

	/**
	 * @param idModalidad
	 *            the idModalidad to set
	 */
	public void setIdModalidad(Integer idModalidad) {
		this.idModalidad = idModalidad;
	}

	/**
	 * @return the valorColusorio
	 */
	public BigDecimal getValorColusorio() {
		return valorColusorio;
	}

	/**
	 * @param valorColusorio
	 *            the valorColusorio to set
	 */
	public void setValorColusorio(BigDecimal valorColusorio) {
		this.valorColusorio = valorColusorio;
	}

	/**
	 * @return the valorIndividual
	 */
	public BigDecimal getValorIndividual() {
		return valorIndividual;
	}

	/**
	 * @param valorIndividual
	 *            the valorIndividual to set
	 */
	public void setValorIndividual(BigDecimal valorIndividual) {
		this.valorIndividual = valorIndividual;
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
	 * @return the clausula
	 */
	public String getClausula() {
		return clausula;
	}

	/**
	 * @param clausula
	 *            the clausula to set
	 */
	public void setClausula(String clausula) {
		this.clausula = clausula;
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
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the nombreFuncionario
	 */
	public String getNombreFuncionario() {
		return nombreFuncionario;
	}

	/**
	 * @param nombreFuncionario
	 *            the nombreFuncionario to set
	 */
	public void setNombreFuncionario(String nombreFuncionario) {
		this.nombreFuncionario = nombreFuncionario;
	}

}
