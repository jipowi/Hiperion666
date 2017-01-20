package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the cobert_acc_per database table.
 * 
 */
@Entity
@Table(name = "cobert_acc_per")
@NamedQuery(name = "CobertAccPer.findAll", query = "SELECT c FROM CobertAccPer c")
public class CobertAccPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobertura")
	private Integer idCobertura;

	@Column(name = "cobertura_acc_personales")
	private String coberturaAccPersonales;

	// bi-directional many-to-one association to RamoAccidentesPersonale
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_accidentes")
	private RamoAccidentesPersonale ramoAccidentesPersonale;

	public CobertAccPer() {
	}

	public Integer getIdCobertura() {
		return this.idCobertura;
	}

	public void setIdCobertura(Integer idCobertura) {
		this.idCobertura = idCobertura;
	}

	public String getCoberturaAccPersonales() {
		return this.coberturaAccPersonales;
	}

	public void setCoberturaAccPersonales(String coberturaAccPersonales) {
		this.coberturaAccPersonales = coberturaAccPersonales;
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