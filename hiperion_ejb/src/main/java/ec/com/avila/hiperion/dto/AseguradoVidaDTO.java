/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;

/**
 * <b> Permite manejar la informacion del objeto Asegurado</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Jul 8, 2014
 * @since JDK1.6
 */
public class AseguradoVidaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombres;
	private String apellidos;
	private String cedula;
	private int edad;

	/**
	 * @param nombres
	 * @param apellidos
	 * @param cedula
	 * @param edad
	 */
	public AseguradoVidaDTO(String nombres, String apellidos, String cedula, int edad) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.edad = edad;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres
	 *            the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad
	 *            the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

}
