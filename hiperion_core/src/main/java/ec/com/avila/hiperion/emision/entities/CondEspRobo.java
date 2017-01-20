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
 * The persistent class for the cond_esp_robo database table.
 * 
 */
@Entity
@Table(name = "cond_esp_robo")
@NamedQuery(name = "CondEspRobo.findAll", query = "SELECT c FROM CondEspRobo c")
public class CondEspRobo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cond_esp_robo")
	private Integer idCondEspRobo;

	@Column(name = "condicion_esp_robo")
	private String condicionEspRobo;

	// bi-directional many-to-one association to RamoRoboAsalto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_robo")
	private RamoRoboAsalto ramoRoboAsalto;

	public CondEspRobo() {
	}

	public Integer getIdCondEspRobo() {
		return this.idCondEspRobo;
	}

	public void setIdCondEspRobo(Integer idCondEspRobo) {
		this.idCondEspRobo = idCondEspRobo;
	}

	public String getCondicionEspRobo() {
		return this.condicionEspRobo;
	}

	public void setCondicionEspRobo(String condicionEspRobo) {
		this.condicionEspRobo = condicionEspRobo;
	}

	public RamoRoboAsalto getRamoRoboAsalto() {
		return this.ramoRoboAsalto;
	}

	public void setRamoRoboAsalto(RamoRoboAsalto ramoRoboAsalto) {
		this.ramoRoboAsalto = ramoRoboAsalto;
	}

}