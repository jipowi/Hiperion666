package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * 
 * <b> Clase Bean del Cliente, tiene todas las variables del cliente. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,22/10/2014
 * @since JDK1.6
 */
@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigoCliente;
	private String identificacion;
	private String ruc;
	private String tipoIdentificacion;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;
	private String nombreJuridico;
	private String apePaternoJuridico;
	private String apeMaternoJuridico;
	private String emailPerNatural;
	private String emailPerJuridica;
	private String razonSocial;
	private String actividadProfecion;
	private String giroNegocio;
	private String ejecutivo;
	private boolean activarCedula;
	private boolean activarRuc;
	private boolean activarNombre;
	private boolean activarApellido;
	private boolean activarRazonSocial;

	private Integer tipoPersona;
	private Integer longitudIdentificacion;

	private Date fechaNacimiento;

	public Integer getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(Integer tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno.toUpperCase();
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno.toUpperCase();
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial.toUpperCase();
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getActividadProfecion() {
		return actividadProfecion;
	}

	public void setActividadProfecion(String actividadProfecion) {
		this.actividadProfecion = actividadProfecion;
	}

	public String getGiroNegocio() {
		return giroNegocio;
	}

	public void setGiroNegocio(String giroNegocio) {
		this.giroNegocio = giroNegocio;
	}

	public String getEmailPerNatural() {
		return emailPerNatural;
	}

	public void setEmailPerNatural(String emailPerNatural) {
		this.emailPerNatural = emailPerNatural;
	}

	public String getEmailPerJuridica() {
		return emailPerJuridica;
	}

	public void setEmailPerJuridica(String emailPerJuridica) {
		this.emailPerJuridica = emailPerJuridica;
	}

	/**
	 * @return the ejecutivo
	 */
	public String getEjecutivo() {
		return ejecutivo;
	}

	/**
	 * @param ejecutivo
	 *            the ejecutivo to set
	 */
	public void setEjecutivo(String ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	/**
	 * @return the codigoCliente
	 */
	public String getCodigoCliente() {
		return codigoCliente;
	}

	/**
	 * @param codigoCliente
	 *            the codigoCliente to set
	 */
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	/**
	 * @return the longitudIdentificacion
	 */
	public Integer getLongitudIdentificacion() {
		return longitudIdentificacion;
	}

	/**
	 * @param longitudIdentificacion
	 *            the longitudIdentificacion to set
	 */
	public void setLongitudIdentificacion(Integer longitudIdentificacion) {
		this.longitudIdentificacion = longitudIdentificacion;
	}

	/**
	 * @return the activarCedula
	 */
	public boolean isActivarCedula() {
		return activarCedula;
	}

	/**
	 * @param activarCedula
	 *            the activarCedula to set
	 */
	public void setActivarCedula(boolean activarCedula) {
		this.activarCedula = activarCedula;
	}

	/**
	 * @return the activarNombre
	 */
	public boolean isActivarNombre() {
		return activarNombre;
	}

	/**
	 * @param activarNombre
	 *            the activarNombre to set
	 */
	public void setActivarNombre(boolean activarNombre) {
		this.activarNombre = activarNombre;
	}

	/**
	 * @return the activarApellido
	 */
	public boolean isActivarApellido() {
		return activarApellido;
	}

	/**
	 * @param activarApellido
	 *            the activarApellido to set
	 */
	public void setActivarApellido(boolean activarApellido) {
		this.activarApellido = activarApellido;
	}

	/**
	 * @return the activarRuc
	 */
	public boolean isActivarRuc() {
		return activarRuc;
	}

	/**
	 * @param activarRuc
	 *            the activarRuc to set
	 */
	public void setActivarRuc(boolean activarRuc) {
		this.activarRuc = activarRuc;
	}

	/**
	 * @return the activarRazonSocial
	 */
	public boolean isActivarRazonSocial() {
		return activarRazonSocial;
	}

	/**
	 * @param activarRazonSocial
	 *            the activarRazonSocial to set
	 */
	public void setActivarRazonSocial(boolean activarRazonSocial) {
		this.activarRazonSocial = activarRazonSocial;
	}

	/**
	 * @return the ruc
	 */
	public String getRuc() {
		return ruc;
	}

	/**
	 * @param ruc
	 *            the ruc to set
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	/**
	 * @return the nombreJuridico
	 */
	public String getNombreJuridico() {
		return nombreJuridico;
	}

	/**
	 * @param nombreJuridico
	 *            the nombreJuridico to set
	 */
	public void setNombreJuridico(String nombreJuridico) {
		this.nombreJuridico = nombreJuridico;
	}

	/**
	 * @return the apePaternoJuridico
	 */
	public String getApePaternoJuridico() {
		return apePaternoJuridico;
	}

	/**
	 * @param apePaternoJuridico
	 *            the apePaternoJuridico to set
	 */
	public void setApePaternoJuridico(String apePaternoJuridico) {
		this.apePaternoJuridico = apePaternoJuridico;
	}

	/**
	 * @return the apeMaternoJuridico
	 */
	public String getApeMaternoJuridico() {
		return apeMaternoJuridico;
	}

	/**
	 * @param apeMaternoJuridico
	 *            the apeMaternoJuridico to set
	 */
	public void setApeMaternoJuridico(String apeMaternoJuridico) {
		this.apeMaternoJuridico = apeMaternoJuridico;
	}

}
