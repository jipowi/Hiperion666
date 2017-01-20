package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the extras_vh database table.
 * 
 */
@Entity
@Table(name = "extras_vh")
@NamedQuery(name = "ExtrasVh.findAll", query = "SELECT e FROM ExtrasVh e")
public class ExtrasVh extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_extra_vehiculo")
	private Integer idExtraVehiculo;

	@Column(name = "cantidad_extra_vh")
	private Integer cantidadExtraVh;

	@Column(name = "extra_vh")
	private String extraVh;

	@Column(name = "valor_extra_vh")
	private BigDecimal valorExtraVh;

	// bi-directional many-to-one association to RamoVehiculo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ramo_vehiculos")
	private RamoVehiculo ramoVehiculo;

	public ExtrasVh() {
	}

	public Integer getIdExtraVehiculo() {
		return this.idExtraVehiculo;
	}

	public void setIdExtraVehiculo(Integer idExtraVehiculo) {
		this.idExtraVehiculo = idExtraVehiculo;
	}

	public Integer getCantidadExtraVh() {
		return this.cantidadExtraVh;
	}

	public void setCantidadExtraVh(Integer cantidadExtraVh) {
		this.cantidadExtraVh = cantidadExtraVh;
	}

	public String getExtraVh() {
		return this.extraVh;
	}

	public void setExtraVh(String extraVh) {
		this.extraVh = extraVh;
	}

	public BigDecimal getValorExtraVh() {
		return this.valorExtraVh;
	}

	public void setValorExtraVh(BigDecimal valorExtraVh) {
		this.valorExtraVh = valorExtraVh;
	}

	public RamoVehiculo getRamoVehiculo() {
		return this.ramoVehiculo;
	}

	public void setRamoVehiculo(RamoVehiculo ramoVehiculo) {
		this.ramoVehiculo = ramoVehiculo;
	}

}