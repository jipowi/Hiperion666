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
 * The persistent class for the limites_costos_asm database table.
 * 
 */
@Entity
@Table(name = "limites_costos_asm")
@NamedQuery(name = "LimitesCostosAsm.findAll", query = "SELECT l FROM LimitesCostosAsm l")
public class LimitesCostosAsm extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_limite_costo_asm")
	private Integer idLimiteCostoAsm;

	@Column(name = "limite_costo")
	private String limiteCosto;

	@Column(name = "tipo_limite")
	private Integer tipoLimite;

	// bi-directional many-to-one association to RamoAsistenciaMedica
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ast_medica")
	private RamoAsistenciaMedica ramoAsistenciaMedica;

	public LimitesCostosAsm() {
	}

	
	public Integer getIdLimiteCostoAsm() {
		return this.idLimiteCostoAsm;
	}

	public void setIdLimiteCostoAsm(Integer idLimiteCostoAsm) {
		this.idLimiteCostoAsm = idLimiteCostoAsm;
	}

	public String getLimiteCosto() {
		return this.limiteCosto;
	}

	public void setLimiteCosto(String limiteCosto) {
		this.limiteCosto = limiteCosto;
	}

	public Integer getTipoLimite() {
		return this.tipoLimite;
	}

	public void setTipoLimite(Integer tipoLimite) {
		this.tipoLimite = tipoLimite;
	}

	public RamoAsistenciaMedica getRamoAsistenciaMedica() {
		return this.ramoAsistenciaMedica;
	}

	public void setRamoAsistenciaMedica(RamoAsistenciaMedica ramoAsistenciaMedica) {
		this.ramoAsistenciaMedica = ramoAsistenciaMedica;
	}

}