package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the contacto database table.
 * 
 */
@Entity
@NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")
public class Contacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contacto")
	private Integer idContacto;

	@Column(name = "descripcion_contacto")
	private String descripcionContacto;

	@Column(name = "tipo_contacto")
	private String tipoContacto;

	// bi-directional many-to-one association to Cliente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Contacto() {
	}

	public Integer getIdContacto() {
		return this.idContacto;
	}

	public void setIdContacto(Integer idContacto) {
		this.idContacto = idContacto;
	}

	public String getDescripcionContacto() {
		return this.descripcionContacto;
	}

	public void setDescripcionContacto(String descripcionContacto) {
		this.descripcionContacto = descripcionContacto;
	}

	public String getTipoContacto() {
		return this.tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}