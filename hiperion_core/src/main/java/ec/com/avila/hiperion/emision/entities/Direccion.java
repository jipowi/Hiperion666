package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Entity
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_direccion")
	private Long idDireccion;

	@Column(name="calle_principal")
	private String callePrincipal;

	@Column(name="calle_secundaria")
	private String calleSecundaria;

	private String numeracion;

	private String referencia;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Provincia
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_provincia")
	private Provincia provincia;

	//bi-directional many-to-one association to TipoDireccion
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_tipo_direccion")
	private TipoDireccion tipoDireccion;

	public Direccion() {
	}

	public Long getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCallePrincipal() {
		return this.callePrincipal;
	}

	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal.toUpperCase();
	}

	public String getCalleSecundaria() {
		return this.calleSecundaria;
	}

	public void setCalleSecundaria(String calleSecundaria) {
		this.calleSecundaria = calleSecundaria.toUpperCase();
	}

	public String getNumeracion() {
		return this.numeracion;
	}

	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia.toUpperCase();
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public TipoDireccion getTipoDireccion() {
		return this.tipoDireccion;
	}

	public void setTipoDireccion(TipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	
}