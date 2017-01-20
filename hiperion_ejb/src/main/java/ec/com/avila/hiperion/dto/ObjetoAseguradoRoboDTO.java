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
public class ObjetoAseguradoRoboDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private BigDecimal valorDetalleObjeto;
	private BigDecimal mueblesEnseresEquipos;
	private BigDecimal joyasObrasArte;
	private BigDecimal maquinaria;
	private BigDecimal dineroPermanencia;
	private BigDecimal mercaderia;
	private String detalleObjeto;

	public ObjetoAseguradoRoboDTO(Integer numeroItem, String ubicacionRiesgo, BigDecimal valorDetalleObjeto, BigDecimal mueblesEnseresEquipos,
			BigDecimal joyasObrasArte, BigDecimal maquinaria, BigDecimal dineroPermanencia, BigDecimal mercaderia, String detalleObjeto) {
		super();
		this.numeroItem = numeroItem;
		this.ubicacionRiesgo = ubicacionRiesgo;
		this.valorDetalleObjeto = valorDetalleObjeto;
		this.mueblesEnseresEquipos = mueblesEnseresEquipos;
		this.joyasObrasArte = joyasObrasArte;
		this.maquinaria = maquinaria;
		this.dineroPermanencia = dineroPermanencia;
		this.mercaderia = mercaderia;
		this.detalleObjeto = detalleObjeto;
	}

	/**
	 * @return the numeroItem
	 */
	public Integer getNumeroItem() {
		return numeroItem;
	}

	/**
	 * @param numeroItem
	 *            the numeroItem to set
	 */
	public void setNumeroItem(Integer numeroItem) {
		this.numeroItem = numeroItem;
	}

	/**
	 * @return the ubicacionRiesgo
	 */
	public String getUbicacionRiesgo() {
		return ubicacionRiesgo;
	}

	/**
	 * @param ubicacionRiesgo
	 *            the ubicacionRiesgo to set
	 */
	public void setUbicacionRiesgo(String ubicacionRiesgo) {
		this.ubicacionRiesgo = ubicacionRiesgo;
	}

	/**
	 * @return the mueblesEnseresEquipos
	 */
	public BigDecimal getMueblesEnseresEquipos() {
		return mueblesEnseresEquipos;
	}

	/**
	 * @param mueblesEnseresEquipos
	 *            the mueblesEnseresEquipos to set
	 */
	public void setMueblesEnseresEquipos(BigDecimal mueblesEnseresEquipos) {
		this.mueblesEnseresEquipos = mueblesEnseresEquipos;
	}

	/**
	 * @return the joyasObrasArte
	 */
	public BigDecimal getJoyasObrasArte() {
		return joyasObrasArte;
	}

	/**
	 * @param joyasObrasArte
	 *            the joyasObrasArte to set
	 */
	public void setJoyasObrasArte(BigDecimal joyasObrasArte) {
		this.joyasObrasArte = joyasObrasArte;
	}

	/**
	 * @return the maquinaria
	 */
	public BigDecimal getMaquinaria() {
		return maquinaria;
	}

	/**
	 * @param maquinaria
	 *            the maquinaria to set
	 */
	public void setMaquinaria(BigDecimal maquinaria) {
		this.maquinaria = maquinaria;
	}

	/**
	 * @return the dineroPermanencia
	 */
	public BigDecimal getDineroPermanencia() {
		return dineroPermanencia;
	}

	/**
	 * @param dineroPermanencia
	 *            the dineroPermanencia to set
	 */
	public void setDineroPermanencia(BigDecimal dineroPermanencia) {
		this.dineroPermanencia = dineroPermanencia;
	}

	/**
	 * @return the mercaderia
	 */
	public BigDecimal getMercaderia() {
		return mercaderia;
	}

	/**
	 * @param mercaderia
	 *            the mercaderia to set
	 */
	public void setMercaderia(BigDecimal mercaderia) {
		this.mercaderia = mercaderia;
	}

	/**
	 * @return the valorDetalleObjeto
	 */
	public BigDecimal getValorDetalleObjeto() {
		return valorDetalleObjeto;
	}

	/**
	 * @param valorDetalleObjeto
	 *            the valorDetalleObjeto to set
	 */
	public void setValorDetalleObjeto(BigDecimal valorDetalleObjeto) {
		this.valorDetalleObjeto = valorDetalleObjeto;
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

}
