package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the cond_esp_acc_pers database table.
 * 
 */
@Entity
@Table(name = "cond_esp_acc_pers")
@NamedQuery(name = "CondEspAccPer.findAll", query = "SELECT c FROM CondEspAccPer c")
public class CondEspAccPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_condicion_esp_acc")
	private Integer idCondicionEspAcc;

	@Column(name = "condicion_acc")
	private String condicionAcc;

	// bi-directional many-to-one association to RamoAccidentesPersonale
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_accidentes")
	private RamoAccidentesPersonale ramoAccidentesPersonale;

	public CondEspAccPer() {
	}

	public Integer getIdCondicionEspAcc() {
		return this.idCondicionEspAcc;
	}

	public void setIdCondicionEspAcc(Integer idCondicionEspAcc) {
		this.idCondicionEspAcc = idCondicionEspAcc;
	}

	public String getCondicionAcc() {
		return this.condicionAcc;
	}

	public void setCondicionAcc(String condicionAcc) {
		this.condicionAcc = condicionAcc;
	}

	/**
	 * @return the ramoAccidentesPersonale
	 */
	public RamoAccidentesPersonale getRamoAccidentesPersonale() {
		return ramoAccidentesPersonale;
	}

	/**
	 * @param ramoAccidentesPersonale
	 *            the ramoAccidentesPersonale to set
	 */
	public void setRamoAccidentesPersonale(RamoAccidentesPersonale ramoAccidentesPersonale) {
		this.ramoAccidentesPersonale = ramoAccidentesPersonale;
	}

}