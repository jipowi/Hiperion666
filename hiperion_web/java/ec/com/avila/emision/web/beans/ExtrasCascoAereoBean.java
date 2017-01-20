/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Mar 2, 2014
 * @since JDK1.6
 */
public class ExtrasCascoAereoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String Extra;
	private BigDecimal valor;

	public ExtrasCascoAereoBean(String extra, BigDecimal valor) {
		super();
		Extra = extra;
		this.valor = valor;
	}

	/**
	 * @return the extra
	 */
	public String getExtra() {
		return Extra;
	}

	/**
	 * @param extra
	 *            the extra to set
	 */
	public void setExtra(String extra) {
		Extra = extra;
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

}
