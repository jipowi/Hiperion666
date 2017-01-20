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
 * The persistent class for the cobert_agro database table.
 * 
 */
@Entity
@Table(name = "cobert_agro")
@NamedQuery(name = "CobertAgro.findAll", query = "SELECT c FROM CobertAgro c")
public class CobertAgro extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cobert_agro")
	private Integer idCobertAgro;

	@Column(name = "cobertura_agro")
	private String coberturaAgro;

	// bi-directional many-to-one association to RamoAgropecuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_agropecuario")
	private RamoAgropecuario ramoAgropecuario;

	@Column(name = "tipo_cobertura_agro")
	private String tipoCoberturaAgro;

	public CobertAgro() {
	}

	public Integer getIdCobertAgro() {
		return this.idCobertAgro;
	}

	public void setIdCobertAgro(Integer idCobertAgro) {
		this.idCobertAgro = idCobertAgro;
	}

	public String getCoberturaAgro() {
		return this.coberturaAgro;
	}

	public void setCoberturaAgro(String coberturaAgro) {
		this.coberturaAgro = coberturaAgro;
	}

	public RamoAgropecuario getRamoAgropecuario() {
		return this.ramoAgropecuario;
	}

	public void setRamoAgropecuario(RamoAgropecuario ramoAgropecuario) {
		this.ramoAgropecuario = ramoAgropecuario;
	}

	/**
	 * @return the tipoCoberturaAgro
	 */
	public String getTipoCoberturaAgro() {
		return tipoCoberturaAgro;
	}

	/**
	 * @param tipoCoberturaAgro
	 *            the tipoCoberturaAgro to set
	 */
	public void setTipoCoberturaAgro(String tipoCoberturaAgro) {
		this.tipoCoberturaAgro = tipoCoberturaAgro;
	}

}