package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;

	@Column(name = "actividad_profesion")
	private String actividadProfesion;

	@Column(name = "apellido_materno")
	private String apellidoMaterno;

	@Column(name = "apellido_paterno")
	private String apellidoPaterno;

	@Column(name = "codigo_cliente")
	private String codigoCliente;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name = "identificacion_persona")
	private String identificacionPersona;

	@Column(name = "nombre_persona")
	private String nombrePersona;

	@Column(name = "razon_social")
	private String razonSocial;

	@Column(name = "tipo_identificacion")
	private String tipoIdentificacion;

	@Column(name = "tipo_persona")
	private String tipoPersona;

	// bi-directional many-to-one association to Aseguradora
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aseguradora")
	private Aseguradora aseguradora;

	// bi-directional many-to-one association to Contacto
	@OneToMany(mappedBy = "cliente")
	private List<Contacto> contactos;

	// bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy = "cliente")
	private List<Direccion> direccions;

	// bi-directional many-to-one association to Poliza
	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	private List<Poliza> polizas;

	public Cliente() {
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getActividadProfesion() {
		return this.actividadProfesion;
	}

	public void setActividadProfesion(String actividadProfesion) {
		this.actividadProfesion = actividadProfesion.toUpperCase();
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno.toUpperCase();
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno.toUpperCase();
	}

	public String getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getIdentificacionPersona() {
		return this.identificacionPersona;
	}

	public void setIdentificacionPersona(String identificacionPersona) {
		this.identificacionPersona = identificacionPersona;
	}

	public String getNombrePersona() {
		return this.nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona.toUpperCase();
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial.toUpperCase();
	}

	public String getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getTipoPersona() {
		return this.tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Aseguradora getAseguradora() {
		return this.aseguradora;
	}

	public void setAseguradora(Aseguradora aseguradora) {
		this.aseguradora = aseguradora;
	}

	public List<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto addContacto(Contacto contacto) {
		getContactos().add(contacto);
		contacto.setCliente(this);

		return contacto;
	}

	public Contacto removeContacto(Contacto contacto) {
		getContactos().remove(contacto);
		contacto.setCliente(null);

		return contacto;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setCliente(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setCliente(null);

		return direccion;
	}

	/**
	 * @return the polizas
	 */
	public List<Poliza> getPolizas() {
		return polizas;
	}

	/**
	 * @param polizas
	 *            the polizas to set
	 */
	public void setPolizas(List<Poliza> polizas) {
		this.polizas = polizas;
	}

}