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
 * The persistent class for the cond_esp_trans database table.
 * 
 */
@Entity
@Table(name = "cond_esp_trans")
@NamedQuery(name = "CondEspTran.findAll", query = "SELECT c FROM CondEspTran c")
public class CondEspTran extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_condicion_esp_transporte")
	private Integer idCondicionEspTransporte;

	@Column(name = "condicion_esp_trans")
	private String condicionEspTrans;

	@Column(name = "descripcion_cond_esp_trans")
	private String descripcionCondEspTrans;

	// bi-directional many-to-one association to RamoTransporte
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_transporte")
	private RamoTransporte ramoTransporte;

	public CondEspTran() {
	}

	public Integer getIdCondicionEspTransporte() {
		return this.idCondicionEspTransporte;
	}

	public void setIdCondicionEspTransporte(Integer idCondicionEspTransporte) {
		this.idCondicionEspTransporte = idCondicionEspTransporte;
	}

	public String getCondicionEspTrans() {
		return this.condicionEspTrans;
	}

	public void setCondicionEspTrans(String condicionEspTrans) {
		this.condicionEspTrans = condicionEspTrans;
	}

	public String getDescripcionCondEspTrans() {
		return this.descripcionCondEspTrans;
	}

	public void setDescripcionCondEspTrans(String descripcionCondEspTrans) {
		this.descripcionCondEspTrans = descripcionCondEspTrans;
	}

	public RamoTransporte getRamoTransporte() {
		return this.ramoTransporte;
	}

	public void setRamoTransporte(RamoTransporte ramoTransporte) {
		this.ramoTransporte = ramoTransporte;
	}

}