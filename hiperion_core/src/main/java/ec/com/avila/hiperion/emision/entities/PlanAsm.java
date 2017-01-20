package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the plan_asm database table.
 * 
 */
@Entity
@Table(name="plan_asm")
@NamedQuery(name="PlanAsm.findAll", query="SELECT p FROM PlanAsm p")
public class PlanAsm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_plan_am")
	private Integer idPlanAm;

	@Column(name="id_ast_medica")
	private Integer idAstMedica;

	@Column(name="nombre_plan_asm")
	private String nombrePlanAsm;

	@Column(name="valor_plan_asm")
	private BigDecimal valorPlanAsm;

	public PlanAsm() {
	}

	public Integer getIdPlanAm() {
		return this.idPlanAm;
	}

	public void setIdPlanAm(Integer idPlanAm) {
		this.idPlanAm = idPlanAm;
	}

	public Integer getIdAstMedica() {
		return this.idAstMedica;
	}

	public void setIdAstMedica(Integer idAstMedica) {
		this.idAstMedica = idAstMedica;
	}

	public String getNombrePlanAsm() {
		return this.nombrePlanAsm;
	}

	public void setNombrePlanAsm(String nombrePlanAsm) {
		this.nombrePlanAsm = nombrePlanAsm;
	}

	public BigDecimal getValorPlanAsm() {
		return this.valorPlanAsm;
	}

	public void setValorPlanAsm(BigDecimal valorPlanAsm) {
		this.valorPlanAsm = valorPlanAsm;
	}

}