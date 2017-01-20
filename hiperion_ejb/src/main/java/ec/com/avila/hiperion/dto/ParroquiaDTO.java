/**
 * 
 */
package ec.com.avila.hiperion.dto;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author DARVIN
 * @version 1.0,06/07/2014
 * @since JDK1.6
 */
public class ParroquiaDTO {

	private Integer codParroquia;
	private String nombre;

	public ParroquiaDTO() {
	}

	/**
	 * @param codProvincia
	 * @param provincia
	 */
	public ParroquiaDTO(Integer codParroquia, String nombre) {
		this.codParroquia = codParroquia;
		this.nombre = nombre;
	}

	public Integer getCodParroquia() {
		return codParroquia;
	}

	public void setCodParroquia(Integer codParroquia) {
		this.codParroquia = codParroquia;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
