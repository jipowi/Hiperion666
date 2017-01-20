package ec.com.avila.hiperion.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * <b> Bean que permite encampsular siertos atributos de la clase Ramo. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,Dec 21, 2013
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigoRamo;
	private String aseguradora;
	private String ramo;
	private BigDecimal comision;

	public String getCodigoRamo() {
		return codigoRamo;
	}

	public void setCodigoRamo(String codigoRamo) {
		this.codigoRamo = codigoRamo;
	}

	public String getAseguradora() {
		return aseguradora;
	}

	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public BigDecimal getComision() {
		return comision;
	}

	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}
}
