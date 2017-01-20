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
 * The persistent class for the obj_aseg_rotura database table.
 * 
 */
@Entity
@Table(name="obj_aseg_rotura")
@NamedQuery(name="ObjAsegRotura.findAll", query="SELECT o FROM ObjAsegRotura o")
public class ObjAsegRotura extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto_rotura")
	private Integer idObjetoRotura;

	@Column(name="descripcion_obj_rotura")
	private String descripcionObjRotura;

	
	@Column(name="item_obj_rotura")
	private Integer itemObjRotura;

	@Column(name="total_obj_rotura")
	private BigDecimal totalObjRotura;

	@Column(name="ubicacion_obj_rotura")
	private String ubicacionObjRotura;

	//bi-directional many-to-one association to RamoRoturaMaquinaria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rotura")
	private RamoRoturaMaquinaria ramoRoturaMaquinaria;

	public ObjAsegRotura() {
	}

	public Integer getIdObjetoRotura() {
		return this.idObjetoRotura;
	}

	public void setIdObjetoRotura(Integer idObjetoRotura) {
		this.idObjetoRotura = idObjetoRotura;
	}

	public String getDescripcionObjRotura() {
		return this.descripcionObjRotura;
	}

	public void setDescripcionObjRotura(String descripcionObjRotura) {
		this.descripcionObjRotura = descripcionObjRotura;
	}


	public Integer getItemObjRotura() {
		return this.itemObjRotura;
	}

	public void setItemObjRotura(Integer itemObjRotura) {
		this.itemObjRotura = itemObjRotura;
	}

	public BigDecimal getTotalObjRotura() {
		return this.totalObjRotura;
	}

	public void setTotalObjRotura(BigDecimal totalObjRotura) {
		this.totalObjRotura = totalObjRotura;
	}

	public String getUbicacionObjRotura() {
		return this.ubicacionObjRotura;
	}

	public void setUbicacionObjRotura(String ubicacionObjRotura) {
		this.ubicacionObjRotura = ubicacionObjRotura;
	}

	public RamoRoturaMaquinaria getRamoRoturaMaquinaria() {
		return this.ramoRoturaMaquinaria;
	}

	public void setRamoRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) {
		this.ramoRoturaMaquinaria = ramoRoturaMaquinaria;
	}

}