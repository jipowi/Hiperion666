/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Mar 2, 2014
 * @since JDK1.6
 */
public class ObjetoAseguradoTransporteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer item;
	private Integer limiteMovilizacionAnual;
	private Integer limiteEmbarque;
	private String medioTransporte;
	private String trayectoDesde;
	private String trayectoHasta;
	private String tipoEmbalaje;
	private BigDecimal valuacion;

	public ObjetoAseguradoTransporteDTO(Integer item, Integer limiteMovilizacionAnual, Integer limiteEmbarque, String medioTransporte,
			String trayectoDesde, String trayectoHasta, String tipoEmbalaje, BigDecimal valuacion) {
		super();
		this.item = item;
		this.limiteMovilizacionAnual = limiteMovilizacionAnual;
		this.limiteEmbarque = limiteEmbarque;
		this.medioTransporte = medioTransporte;
		this.trayectoDesde = trayectoDesde;
		this.trayectoHasta = trayectoHasta;
		this.tipoEmbalaje = tipoEmbalaje;
		this.valuacion = valuacion;
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
	 * @return the limiteMovilizacionAnual
	 */
	public Integer getLimiteMovilizacionAnual() {
		return limiteMovilizacionAnual;
	}

	/**
	 * @param limiteMovilizacionAnual
	 *            the limiteMovilizacionAnual to set
	 */
	public void setLimiteMovilizacionAnual(Integer limiteMovilizacionAnual) {
		this.limiteMovilizacionAnual = limiteMovilizacionAnual;
	}

	/**
	 * @return the limiteEmbarque
	 */
	public Integer getLimiteEmbarque() {
		return limiteEmbarque;
	}

	/**
	 * @param limiteEmbarque
	 *            the limiteEmbarque to set
	 */
	public void setLimiteEmbarque(Integer limiteEmbarque) {
		this.limiteEmbarque = limiteEmbarque;
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
	 * @return the tipoEmbalaje
	 */
	public String getTipoEmbalaje() {
		return tipoEmbalaje;
	}

	/**
	 * @param tipoEmbalaje
	 *            the tipoEmbalaje to set
	 */
	public void setTipoEmbalaje(String tipoEmbalaje) {
		this.tipoEmbalaje = tipoEmbalaje;
	}

	/**
	 * @return the valuacion
	 */
	public BigDecimal getValuacion() {
		return valuacion;
	}

	/**
	 * @param valuacion
	 *            the valuacion to set
	 */
	public void setValuacion(BigDecimal valuacion) {
		this.valuacion = valuacion;
	}

}
