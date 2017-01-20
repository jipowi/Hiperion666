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
import javax.persistence.Table;

/**
 * The persistent class for the cond_esp_vh database table.
 * 
 */
@Entity
@Table(name = "cond_esp_vh")
@NamedQuery(name = "CondEspVh.findAll", query = "SELECT c FROM CondEspVh c")
public class CondEspVh extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_condicion_esp_vehiculo")
	private Integer idCondicionEspVehiculo;

	@Column(name = "condicion_esp_vh")
	private String condicionEspVh;

	// bi-directional many-to-one association to RamoVehiculo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ramo_vehiculos")
	private RamoVehiculo ramoVehiculo;

	public CondEspVh() {
	}

	public Integer getIdCondicionEspVehiculo() {
		return this.idCondicionEspVehiculo;
	}

	public void setIdCondicionEspVehiculo(Integer idCondicionEspVehiculo) {
		this.idCondicionEspVehiculo = idCondicionEspVehiculo;
	}

	public String getCondicionEspVh() {
		return this.condicionEspVh;
	}

	public void setCondicionEspVh(String condicionEspVh) {
		this.condicionEspVh = condicionEspVh;
	}

	public RamoVehiculo getRamoVehiculo() {
		return this.ramoVehiculo;
	}

	public void setRamoVehiculo(RamoVehiculo ramoVehiculo) {
		this.ramoVehiculo = ramoVehiculo;
	}

}