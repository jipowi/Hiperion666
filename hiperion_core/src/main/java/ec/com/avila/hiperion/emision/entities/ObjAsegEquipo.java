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
 * The persistent class for the obj_aseg_equipo database table.
 * 
 */
@Entity
@Table(name = "obj_aseg_equipo")
@NamedQuery(name = "ObjAsegEquipo.findAll", query = "SELECT o FROM ObjAsegEquipo o")
public class ObjAsegEquipo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_objeto_aseg_equipo")
	private Integer idObjetoAsegEquipo;

	@Column(name = "desc_obj_eq_elec")
	private String descObjEqElec;

	@Column(name = "detalle_objeto_eq_elec")
	private String detalleObjetoEqElec;

	@Column(name = "item_obj_eq_elec")
	private Integer itemObjEqElec;

	@Column(name = "ubicacion_obj_eq_elec")
	private String ubicacionObjEqElec;

	@Column(name = "valor_obj_eq_elec")
	private BigDecimal valorObjEqElec;

	// bi-directional many-to-one association to RamoEquipoElectronico
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_equipo")
	private RamoEquipoElectronico ramoEquipoElectronico;

	public ObjAsegEquipo() {
	}

	public Integer getIdObjetoAsegEquipo() {
		return this.idObjetoAsegEquipo;
	}

	public void setIdObjetoAsegEquipo(Integer idObjetoAsegEquipo) {
		this.idObjetoAsegEquipo = idObjetoAsegEquipo;
	}

	public String getDescObjEqElec() {
		return this.descObjEqElec;
	}

	public void setDescObjEqElec(String descObjEqElec) {
		this.descObjEqElec = descObjEqElec;
	}

	public String getDetalleObjetoEqElec() {
		return this.detalleObjetoEqElec;
	}

	public void setDetalleObjetoEqElec(String detalleObjetoEqElec) {
		this.detalleObjetoEqElec = detalleObjetoEqElec;
	}

	public Integer getItemObjEqElec() {
		return this.itemObjEqElec;
	}

	public void setItemObjEqElec(Integer itemObjEqElec) {
		this.itemObjEqElec = itemObjEqElec;
	}

	public String getUbicacionObjEqElec() {
		return this.ubicacionObjEqElec;
	}

	public void setUbicacionObjEqElec(String ubicacionObjEqElec) {
		this.ubicacionObjEqElec = ubicacionObjEqElec;
	}

	public BigDecimal getValorObjEqElec() {
		return this.valorObjEqElec;
	}

	public void setValorObjEqElec(BigDecimal valorObjEqElec) {
		this.valorObjEqElec = valorObjEqElec;
	}

	public RamoEquipoElectronico getRamoEquipoElectronico() {
		return this.ramoEquipoElectronico;
	}

	public void setRamoEquipoElectronico(RamoEquipoElectronico ramoEquipoElectronico) {
		this.ramoEquipoElectronico = ramoEquipoElectronico;
	}

}