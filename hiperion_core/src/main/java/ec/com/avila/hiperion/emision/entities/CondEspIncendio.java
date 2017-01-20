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
 * The persistent class for the cond_esp_incendio database table.
 * 
 */
@Entity
@Table(name = "cond_esp_incendio")
@NamedQuery(name = "CondEspIncendio.findAll", query = "SELECT c FROM CondEspIncendio c")
public class CondEspIncendio extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_condicion_esp_incendio")
	private Integer idCondicionEspIncendio;

	@Column(name = "condicion_esp_incendio")
	private String condicionEspIncendio;

	// bi-directional many-to-one association to RamoIncendioLineasAliada
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_incendio")
	private RamoIncendioLineasAliada ramoIncendioLineasAliada;

	public CondEspIncendio() {
	}

	public Integer getIdCondicionEspIncendio() {
		return this.idCondicionEspIncendio;
	}

	public void setIdCondicionEspIncendio(Integer idCondicionEspIncendio) {
		this.idCondicionEspIncendio = idCondicionEspIncendio;
	}

	public String getCondicionEspIncendio() {
		return this.condicionEspIncendio;
	}

	public void setCondicionEspIncendio(String condicionEspIncendio) {
		this.condicionEspIncendio = condicionEspIncendio;
	}

	public RamoIncendioLineasAliada getRamoIncendioLineasAliada() {
		return this.ramoIncendioLineasAliada;
	}

	public void setRamoIncendioLineasAliada(RamoIncendioLineasAliada ramoIncendioLineasAliada) {
		this.ramoIncendioLineasAliada = ramoIncendioLineasAliada;
	}

}