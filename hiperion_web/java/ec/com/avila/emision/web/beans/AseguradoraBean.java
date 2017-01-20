/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.util.List;

import ec.com.avila.hiperion.entities.Persona;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author kruger
 * @version 1.0,Dec 21, 2013
 * @since JDK1.6
 */
public class AseguradoraBean {

	private String codigoAseguradora;
	private String direcion;
	private String email;
	private String nombre;
	private String ruc;
	private String telefono;
	private List<Persona> personas;

	public String getCodigoAseguradora() {
		return codigoAseguradora;
	}

	public void setCodigoAseguradora(String codigoAseguradora) {
		this.codigoAseguradora = codigoAseguradora;
	}

	public String getDirecion() {
		return direcion;
	}

	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}
