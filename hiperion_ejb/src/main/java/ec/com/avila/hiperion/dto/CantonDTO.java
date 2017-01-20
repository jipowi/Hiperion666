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
public class CantonDTO {

	private Integer codCanton;
	private String nombre;

	public CantonDTO() {
	}

	/**
	 * @param codCanton
	 * @param nombre
	 */
	public CantonDTO(Integer codCanton, String nombre) {
		this.codCanton = codCanton;
		this.nombre = nombre;
	}

	/**
	 * @return the codCanton
	 */
	public Integer getCodCanton() {
		return codCanton;
	}

	/**
	 * @param codCanton
	 *            the codCanton to set
	 */
	public void setCodCanton(Integer codCanton) {
		this.codCanton = codCanton;
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
