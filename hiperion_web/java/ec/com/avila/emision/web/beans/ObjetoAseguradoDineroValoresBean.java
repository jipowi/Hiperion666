/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b> Permite administrar la informacion del objeto asegurado para dinero y valores. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,May 3, 2014
 * @since JDK1.6
 */
public class ObjetoAseguradoDineroValoresBean implements Serializable {


	private static final long serialVersionUID = 1L;
	private Integer item;
	private String dineroValores;
	private BigDecimal limiteEstimadoAnual;
	private BigDecimal limiteEmbarque;
	private String trayectoDesde;
	private String trayectoHasta;
	private String medioTransporte;
	
	//Contructor
	

	/**
	 * @param item
	 * @param dineroValores
	 * @param limiteEstimadoAnual
	 * @param limiteEmbarque
	 * @param trayectoDesde
	 * @param trayectoHasta
	 * @param medioTransporte
	 */
	public ObjetoAseguradoDineroValoresBean(Integer item, String dineroValores, BigDecimal limiteEstimadoAnual, BigDecimal limiteEmbarque,
			String trayectoDesde, String trayectoHasta, String medioTransporte) {
		super();
		this.item = item;
		this.dineroValores = dineroValores;
		this.limiteEstimadoAnual = limiteEstimadoAnual;
		this.limiteEmbarque = limiteEmbarque;
		this.trayectoDesde = trayectoDesde;
		this.trayectoHasta = trayectoHasta;
		this.medioTransporte = medioTransporte;
	}

	/**
	 * @return the item
	 */
	public Integer getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(Integer item) {
		this.item = item;
	}

	/**
	 * @return the dineroValores
	 */
	public String getDineroValores() {
		return dineroValores;
	}

	/**
	 * @param dineroValores
	 *            the dineroValores to set
	 */
	public void setDineroValores(String dineroValores) {
		this.dineroValores = dineroValores;
	}

	/**
	 * @return the limiteEmbarque
	 */
	public BigDecimal getLimiteEmbarque() {
		return limiteEmbarque;
	}

	/**
	 * @param limiteEmbarque
	 *            the limiteEmbarque to set
	 */
	public void setLimiteEmbarque(BigDecimal limiteEmbarque) {
		this.limiteEmbarque = limiteEmbarque;
	}

	/**
	 * @return the limiteEstimadoAnual
	 */
	public BigDecimal getLimiteEstimadoAnual() {
		return limiteEstimadoAnual;
	}

	/**
	 * @param limiteEstimadoAnual
	 *            the limiteEstimadoAnual to set
	 */
	public void setLimiteEstimadoAnual(BigDecimal limiteEstimadoAnual) {
		this.limiteEstimadoAnual = limiteEstimadoAnual;
	}

	/**
	 * @return the trayectoDesde
	 */
	public String getTrayectoDesde() {
		return trayectoDesde;
	}

	/**
	 * @param trayectoDesde
	 *            the trayectoDesde to set
	 */
	public void setTrayectoDesde(String trayectoDesde) {
		this.trayectoDesde = trayectoDesde;
	}

	/**
	 * @return the trayectoHasta
	 */
	public String getTrayectoHasta() {
		return trayectoHasta;
	}

	/**
	 * @param trayectoHasta
	 *            the trayectoHasta to set
	 */
	public void setTrayectoHasta(String trayectoHasta) {
		this.trayectoHasta = trayectoHasta;
	}

	/**
	 * @return the medioTransporte
	 */
	public String getMedioTransporte() {
		return medioTransporte;
	}

	/**
	 * @param medioTransporte
	 *            the medioTransporte to set
	 */
	public void setMedioTransporte(String medioTransporte) {
		this.medioTransporte = medioTransporte;
	}

}
