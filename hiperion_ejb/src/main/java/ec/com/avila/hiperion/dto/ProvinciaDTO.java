/**
 * 
 */
package ec.com.avila.hiperion.dto;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza.
 * @version 1.0,06/07/2014
 * @since JDK1.6
 */
public class ProvinciaDTO {

	private String codProvincia;
	private String nombre;

	public ProvinciaDTO() {
	}

	/**
	 * @param codProvincia
	 * @param provincia
	 */
	public ProvinciaDTO(String codProvincia, String nombre) {
		this.codProvincia = codProvincia;
		this.nombre = nombre;
	}

	/**
	 * @return the codProvincia
	 */
	public String getCodProvincia() {
		return codProvincia;
	}

	/**
	 * @param codProvincia
	 *            the codProvincia to set
	 */
	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
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
