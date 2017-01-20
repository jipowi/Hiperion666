/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dto;

import java.math.BigDecimal;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Jun 21, 2014
 * @since JDK1.6
 */
public class ExtraVehiculosDTO {

	private String extra;
	private BigDecimal valorExtra;
	private Integer cantidadExtra;

	/**
	 * @param extra
	 * @param valorExtra
	 * @param cantidadExtra
	 */
	public ExtraVehiculosDTO(String extra, BigDecimal valorExtra, Integer cantidadExtra) {
		super();
		this.extra = extra;
		this.valorExtra = valorExtra;
		this.cantidadExtra = cantidadExtra;
	}

	/**
	 * @return the extra
	 */
	public String getExtra() {
		return extra;
	}

	/**
	 * @param extra
	 *            the extra to set
	 */
	public void setExtra(String extra) {
		this.extra = extra;
	}

	/**
	 * @return the valorExtra
	 */
	public BigDecimal getValorExtra() {
		return valorExtra;
	}

	/**
	 * @param valorExtra
	 *            the valorExtra to set
	 */
	public void setValorExtra(BigDecimal valorExtra) {
		this.valorExtra = valorExtra;
	}

	/**
	 * @return the cantidadExtra
	 */
	public Integer getCantidadExtra() {
		return cantidadExtra;
	}

	/**
	 * @param cantidadExtra
	 *            the cantidadExtra to set
	 */
	public void setCantidadExtra(Integer cantidadExtra) {
		this.cantidadExtra = cantidadExtra;
	}

}
