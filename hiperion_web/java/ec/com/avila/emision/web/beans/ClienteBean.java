package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer tipoPersona;
	private String tipoIdentificacion;
	private String identificacion;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;
	private String emailPerNatural;
	private String emailPerJuridica;
	private Date fechaNacimiento;
	private String razonSocial;
	private String actividadProfecion;
	private String giroNegocio;
	private String codigoProvincia;
	private String codigoCiudad;
	private String ejecutivo;

	// Direccion del Cliente
	private String tipoDireccion;
	private String callePrincipalCobro;
	private String calleSecundariaCobro;
	private String celularCobro;
	private String numeracionCobro;
	private String referenciaCobro;
	private String telefonoCobro;

	private String callePrincipalDomicilio;
	private String calleSecundariaDomicilio;
	private String celularDomicilio;
	private String numeracionDomicilio;
	private String referenciaDomicilio;
	private String telefonoDomicilio;

	private String callePrincipalOficina;
	private String calleSecundariaOficina;
	private String celularOficina;
	private String numeracionOficina;
	private String referenciaOficina;
	private String telefonoOficina;

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
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
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
		this.razonSocial = razonSocial;
	}

	public String getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getCodigoCiudad() {
		return codigoCiudad;
	}

	public void setCodigoCiudad(String codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
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
	 * @return the callePrincipalCobro
	 */
	public String getCallePrincipalCobro() {
		return callePrincipalCobro;
	}

	/**
	 * @param callePrincipalCobro
	 *            the callePrincipalCobro to set
	 */
	public void setCallePrincipalCobro(String callePrincipalCobro) {
		this.callePrincipalCobro = callePrincipalCobro;
	}

	/**
	 * @return the calleSecundariaCobro
	 */
	public String getCalleSecundariaCobro() {
		return calleSecundariaCobro;
	}

	/**
	 * @param calleSecundariaCobro
	 *            the calleSecundariaCobro to set
	 */
	public void setCalleSecundariaCobro(String calleSecundariaCobro) {
		this.calleSecundariaCobro = calleSecundariaCobro;
	}

	/**
	 * @return the celularCobro
	 */
	public String getCelularCobro() {
		return celularCobro;
	}

	/**
	 * @param celularCobro
	 *            the celularCobro to set
	 */
	public void setCelularCobro(String celularCobro) {
		this.celularCobro = celularCobro;
	}

	/**
	 * @return the numeracionCobro
	 */
	public String getNumeracionCobro() {
		return numeracionCobro;
	}

	/**
	 * @param numeracionCobro
	 *            the numeracionCobro to set
	 */
	public void setNumeracionCobro(String numeracionCobro) {
		this.numeracionCobro = numeracionCobro;
	}

	/**
	 * @return the referenciaCobro
	 */
	public String getReferenciaCobro() {
		return referenciaCobro;
	}

	/**
	 * @param referenciaCobro
	 *            the referenciaCobro to set
	 */
	public void setReferenciaCobro(String referenciaCobro) {
		this.referenciaCobro = referenciaCobro;
	}

	/**
	 * @return the telefonoCobro
	 */
	public String getTelefonoCobro() {
		return telefonoCobro;
	}

	/**
	 * @param telefonoCobro
	 *            the telefonoCobro to set
	 */
	public void setTelefonoCobro(String telefonoCobro) {
		this.telefonoCobro = telefonoCobro;
	}

	/**
	 * @return the callePrincipalDomicilio
	 */
	public String getCallePrincipalDomicilio() {
		return callePrincipalDomicilio;
	}

	/**
	 * @param callePrincipalDomicilio
	 *            the callePrincipalDomicilio to set
	 */
	public void setCallePrincipalDomicilio(String callePrincipalDomicilio) {
		this.callePrincipalDomicilio = callePrincipalDomicilio;
	}

	/**
	 * @return the calleSecundariaDomicilio
	 */
	public String getCalleSecundariaDomicilio() {
		return calleSecundariaDomicilio;
	}

	/**
	 * @param calleSecundariaDomicilio
	 *            the calleSecundariaDomicilio to set
	 */
	public void setCalleSecundariaDomicilio(String calleSecundariaDomicilio) {
		this.calleSecundariaDomicilio = calleSecundariaDomicilio;
	}

	/**
	 * @return the celularDomicilio
	 */
	public String getCelularDomicilio() {
		return celularDomicilio;
	}

	/**
	 * @param celularDomicilio
	 *            the celularDomicilio to set
	 */
	public void setCelularDomicilio(String celularDomicilio) {
		this.celularDomicilio = celularDomicilio;
	}

	/**
	 * @return the numeracionDomicilio
	 */
	public String getNumeracionDomicilio() {
		return numeracionDomicilio;
	}

	/**
	 * @param numeracionDomicilio
	 *            the numeracionDomicilio to set
	 */
	public void setNumeracionDomicilio(String numeracionDomicilio) {
		this.numeracionDomicilio = numeracionDomicilio;
	}

	/**
	 * @return the referenciaDomicilio
	 */
	public String getReferenciaDomicilio() {
		return referenciaDomicilio;
	}

	/**
	 * @param referenciaDomicilio
	 *            the referenciaDomicilio to set
	 */
	public void setReferenciaDomicilio(String referenciaDomicilio) {
		this.referenciaDomicilio = referenciaDomicilio;
	}

	/**
	 * @return the telefonoDomicilio
	 */
	public String getTelefonoDomicilio() {
		return telefonoDomicilio;
	}

	/**
	 * @param telefonoDomicilio
	 *            the telefonoDomicilio to set
	 */
	public void setTelefonoDomicilio(String telefonoDomicilio) {
		this.telefonoDomicilio = telefonoDomicilio;
	}

	/**
	 * @return the callePrincipalOficina
	 */
	public String getCallePrincipalOficina() {
		return callePrincipalOficina;
	}

	/**
	 * @param callePrincipalOficina
	 *            the callePrincipalOficina to set
	 */
	public void setCallePrincipalOficina(String callePrincipalOficina) {
		this.callePrincipalOficina = callePrincipalOficina;
	}

	/**
	 * @return the calleSecundariaOficina
	 */
	public String getCalleSecundariaOficina() {
		return calleSecundariaOficina;
	}

	/**
	 * @param calleSecundariaOficina
	 *            the calleSecundariaOficina to set
	 */
	public void setCalleSecundariaOficina(String calleSecundariaOficina) {
		this.calleSecundariaOficina = calleSecundariaOficina;
	}

	/**
	 * @return the celularOficina
	 */
	public String getCelularOficina() {
		return celularOficina;
	}

	/**
	 * @param celularOficina
	 *            the celularOficina to set
	 */
	public void setCelularOficina(String celularOficina) {
		this.celularOficina = celularOficina;
	}

	/**
	 * @return the numeracionOficina
	 */
	public String getNumeracionOficina() {
		return numeracionOficina;
	}

	/**
	 * @param numeracionOficina
	 *            the numeracionOficina to set
	 */
	public void setNumeracionOficina(String numeracionOficina) {
		this.numeracionOficina = numeracionOficina;
	}

	/**
	 * @return the referenciaOficina
	 */
	public String getReferenciaOficina() {
		return referenciaOficina;
	}

	/**
	 * @param referenciaOficina
	 *            the referenciaOficina to set
	 */
	public void setReferenciaOficina(String referenciaOficina) {
		this.referenciaOficina = referenciaOficina;
	}

	/**
	 * @return the telefonoOficina
	 */
	public String getTelefonoOficina() {
		return telefonoOficina;
	}

	/**
	 * @param telefonoOficina
	 *            the telefonoOficina to set
	 */
	public void setTelefonoOficina(String telefonoOficina) {
		this.telefonoOficina = telefonoOficina;
	}

	/**
	 * @return the tipoDireccion
	 */
	public String getTipoDireccion() {
		return tipoDireccion;
	}

	/**
	 * @param tipoDireccion
	 *            the tipoDireccion to set
	 */
	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}
}
