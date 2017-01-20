/**
 * 
 */
package ec.com.avila.hiperion.dto;

/**
 * <b> Permite manejar los campos de la tabla persona y funcionar como contacto en las aseguradoras </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Aug 3, 2014
 * @since JDK1.6
 */
public class PersonaContactoAseguradoraDTO {

	private String nombre;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String identificacion;
	private String cargo;
	private String email;
	private String telefonoContacto;

	/**
	 * @param nombre
	 * @param apellidoMaterno
	 * @param apellidoPaterno
	 * @param identificacion
	 * @param cargo
	 * @param email
	 * @param telefonoContacto
	 */
	public PersonaContactoAseguradoraDTO(String nombre, String apellidoMaterno, String apellidoPaterno, String identificacion, String cargo, String email, String telefonoContacto) {
		super();
		this.nombre = nombre;
		this.apellidoMaterno = apellidoMaterno;
		this.apellidoPaterno = apellidoPaterno;
		this.identificacion = identificacion;
		this.cargo = cargo;
		this.email = email;
		this.telefonoContacto = telefonoContacto;
	}

	/**
	 * 
	 */
	public PersonaContactoAseguradoraDTO() {
		super();
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

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno
	 *            the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno
	 *            the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion
	 *            the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefonoContacto
	 */
	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	/**
	 * @param telefonoContacto
	 *            the telefonoContacto to set
	 */
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
}
