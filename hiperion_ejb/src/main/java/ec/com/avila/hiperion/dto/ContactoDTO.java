/**
 * 
 */
package ec.com.avila.hiperion.dto;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,28/09/2014
 * @since JDK1.6
 */
public class ContactoDTO {

	private String tipoContacto;
	private String descripcionContacto;
	private Integer idContacto;

	/**
	 * @return the tipoContacto
	 */
	public String getTipoContacto() {
		return tipoContacto;
	}

	/**
	 * @param tipoContacto
	 *            the tipoContacto to set
	 */
	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	/**
	 * @return the descripcionContacto
	 */
	public String getDescripcionContacto() {
		return descripcionContacto;
	}

	/**
	 * @param descripcionContacto
	 *            the descripcionContacto to set
	 */
	public void setDescripcionContacto(String descripcionContacto) {
		this.descripcionContacto = descripcionContacto;
	}

	/**
	 * @return the idContacto
	 */
	public Integer getIdContacto() {
		return idContacto;
	}

	/**
	 * @param idContacto
	 *            the idContacto to set
	 */
	public void setIdContacto(Integer idContacto) {
		this.idContacto = idContacto;
	}

}
