package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ramo_aseguradora database table.
 * 
 */
@Entity
@Table(name="ramo_aseguradora")
@NamedQuery(name="RamoAseguradora.findAll", query="SELECT r FROM RamoAseguradora r")
public class RamoAseguradora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ramo_aseguradora")
	private Integer idRamoAseguradora;

	private BigDecimal comision;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(name="id_usuario_actualizacion")
	private Integer idUsuarioActualizacion;

	@Column(name="id_usuario_creacion")
	private Integer idUsuarioCreacion;

	//bi-directional many-to-one association to Aseguradora
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aseguradora")
	private Aseguradora aseguradora;

	//bi-directional many-to-one association to Ramo
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_ramo")
	private Ramo ramo;

	public RamoAseguradora() {
	}

	public Integer getIdRamoAseguradora() {
		return this.idRamoAseguradora;
	}

	public void setIdRamoAseguradora(Integer idRamoAseguradora) {
		this.idRamoAseguradora = idRamoAseguradora;
	}

	public BigDecimal getComision() {
		return this.comision;
	}

	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getIdUsuarioActualizacion() {
		return this.idUsuarioActualizacion;
	}

	public void setIdUsuarioActualizacion(Integer idUsuarioActualizacion) {
		this.idUsuarioActualizacion = idUsuarioActualizacion;
	}

	public Integer getIdUsuarioCreacion() {
		return this.idUsuarioCreacion;
	}

	public void setIdUsuarioCreacion(Integer idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

	public Aseguradora getAseguradora() {
		return this.aseguradora;
	}

	public void setAseguradora(Aseguradora aseguradora) {
		this.aseguradora = aseguradora;
	}

	public Ramo getRamo() {
		return this.ramo;
	}

	public void setRamo(Ramo ramo) {
		this.ramo = ramo;
	}

}