/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
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
 * @version 1.0,18/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoRiesgoContratistaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private BigDecimal tasa;
	private Integer periodoConstruccion;
	private Integer periodoMantenimiento;
	private String filePolizaVigente;
	private Boolean cronograma;
	private Boolean estudioSuelo;
	private Boolean formularioSeguro;

	// Tabla Clausulas Adicionales_Contratista
	private String clausula;

	// Tabla Coberturas Contratista
	private String cobertura;
	private BigDecimal valorCoberturaRamoRiesgoContratista;

	// Tabla Objeto asegurado contratista
	private String detalleObjeto;

	// Tabla Deducibles Contratista
	private BigDecimal porcentajeConstruccionA;
	private BigDecimal minimoA;
	private BigDecimal minimoB;
	private BigDecimal porcentajeConstruccionC;
	private BigDecimal minimoC;
	private BigDecimal porcentajeConstruccionD;
	private BigDecimal minimoD;
	private BigDecimal minimoG;
	private BigDecimal porcentajeB;
	private BigDecimal porcentajeG;
	
	// Cliente - Aseguradora
		private String identificacion;
		private String nombreCliente;
		private String aseguradora;
		private String contactoAseguradora;
		
		
		

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
		 * @param identificacion the identificacion to set
		 */
		public void setIdentificacion(String identificacion) {
			this.identificacion = identificacion;
		}

	/**
	 * @return the valorCoberturaRamoRiesgoContratista
	 */
	public BigDecimal getValorCoberturaRamoRiesgoContratista() {
		return valorCoberturaRamoRiesgoContratista;
	}

	/**
	 * @param valorCoberturaRamoRiesgoContratista
	 *            the valorCoberturaRamoRiesgoContratista to set
	 */
	public void setValorCoberturaRamoRiesgoContratista(BigDecimal valorCoberturaRamoRiesgoContratista) {
		this.valorCoberturaRamoRiesgoContratista = valorCoberturaRamoRiesgoContratista;
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
	 * @return the periodoConstruccion
	 */
	public Integer getPeriodoConstruccion() {
		return periodoConstruccion;
	}

	/**
	 * @param periodoConstruccion
	 *            the periodoConstruccion to set
	 */
	public void setPeriodoConstruccion(Integer periodoConstruccion) {
		this.periodoConstruccion = periodoConstruccion;
	}

	/**
	 * @return the periodoMantenimiento
	 */
	public Integer getPeriodoMantenimiento() {
		return periodoMantenimiento;
	}

	/**
	 * @param periodoMantenimiento
	 *            the periodoMantenimiento to set
	 */
	public void setPeriodoMantenimiento(Integer periodoMantenimiento) {
		this.periodoMantenimiento = periodoMantenimiento;
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
	 * @return the detalleObjeto
	 */
	public String getDetalleObjeto() {
		return detalleObjeto;
	}

	/**
	 * @param detalleObjeto
	 *            the detalleObjeto to set
	 */
	public void setDetalleObjeto(String detalleObjeto) {
		this.detalleObjeto = detalleObjeto;
	}

	/**
	 * @return the porcentajeConstruccionA
	 */
	public BigDecimal getPorcentajeConstruccionA() {
		return porcentajeConstruccionA;
	}

	/**
	 * @param porcentajeConstruccionA
	 *            the porcentajeConstruccionA to set
	 */
	public void setPorcentajeConstruccionA(BigDecimal porcentajeConstruccionA) {
		this.porcentajeConstruccionA = porcentajeConstruccionA;
	}

	/**
	 * @return the minimoA
	 */
	public BigDecimal getMinimoA() {
		return minimoA;
	}

	/**
	 * @param minimoA
	 *            the minimoA to set
	 */
	public void setMinimoA(BigDecimal minimoA) {
		this.minimoA = minimoA;
	}

	/**
	 * @return the minimoB
	 */
	public BigDecimal getMinimoB() {
		return minimoB;
	}

	/**
	 * @param minimoB
	 *            the minimoB to set
	 */
	public void setMinimoB(BigDecimal minimoB) {
		this.minimoB = minimoB;
	}

	/**
	 * @return the porcentajeConstruccionC
	 */
	public BigDecimal getPorcentajeConstruccionC() {
		return porcentajeConstruccionC;
	}

	/**
	 * @param porcentajeConstruccionC
	 *            the porcentajeConstruccionC to set
	 */
	public void setPorcentajeConstruccionC(BigDecimal porcentajeConstruccionC) {
		this.porcentajeConstruccionC = porcentajeConstruccionC;
	}

	/**
	 * @return the minimoC
	 */
	public BigDecimal getMinimoC() {
		return minimoC;
	}

	/**
	 * @param minimoC
	 *            the minimoC to set
	 */
	public void setMinimoC(BigDecimal minimoC) {
		this.minimoC = minimoC;
	}

	/**
	 * @return the porcentajeConstruccionD
	 */
	public BigDecimal getPorcentajeConstruccionD() {
		return porcentajeConstruccionD;
	}

	/**
	 * @param porcentajeConstruccionD
	 *            the porcentajeConstruccionD to set
	 */
	public void setPorcentajeConstruccionD(BigDecimal porcentajeConstruccionD) {
		this.porcentajeConstruccionD = porcentajeConstruccionD;
	}

	/**
	 * @return the minimoD
	 */
	public BigDecimal getMinimoD() {
		return minimoD;
	}

	/**
	 * @param minimoD
	 *            the minimoD to set
	 */
	public void setMinimoD(BigDecimal minimoD) {
		this.minimoD = minimoD;
	}

	/**
	 * @return the minimoG
	 */
	public BigDecimal getMinimoG() {
		return minimoG;
	}

	/**
	 * @param minimoG
	 *            the minimoG to set
	 */
	public void setMinimoG(BigDecimal minimoG) {
		this.minimoG = minimoG;
	}

	/**
	 * @return the porcentajeB
	 */
	public BigDecimal getPorcentajeB() {
		return porcentajeB;
	}

	/**
	 * @param porcentajeB
	 *            the porcentajeB to set
	 */
	public void setPorcentajeB(BigDecimal porcentajeB) {
		this.porcentajeB = porcentajeB;
	}

	/**
	 * @return the porcentajeG
	 */
	public BigDecimal getPorcentajeG() {
		return porcentajeG;
	}

	/**
	 * @param porcentajeG
	 *            the porcentajeG to set
	 */
	public void setPorcentajeG(BigDecimal porcentajeG) {
		this.porcentajeG = porcentajeG;
	}

	/**
	 * @return the cronograma
	 */
	public Boolean getCronograma() {
		return cronograma;
	}

	/**
	 * @param cronograma
	 *            the cronograma to set
	 */
	public void setCronograma(Boolean cronograma) {
		this.cronograma = cronograma;
	}

	/**
	 * @return the estudioSuelo
	 */
	public Boolean getEstudioSuelo() {
		return estudioSuelo;
	}

	/**
	 * @param estudioSuelo
	 *            the estudioSuelo to set
	 */
	public void setEstudioSuelo(Boolean estudioSuelo) {
		this.estudioSuelo = estudioSuelo;
	}

	/**
	 * @return the formularioSeguro
	 */
	public Boolean getFormularioSeguro() {
		return formularioSeguro;
	}

	/**
	 * @param formularioSeguro
	 *            the formularioSeguro to set
	 */
	public void setFormularioSeguro(Boolean formularioSeguro) {
		this.formularioSeguro = formularioSeguro;
	}

}
