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
 * The persistent class for the obj_aseg_lc_rot_maq database table.
 * 
 */
@Entity
@Table(name = "obj_aseg_lc_rot_maq")
@NamedQuery(name = "ObjAsegLcRotMaq.findAll", query = "SELECT o FROM ObjAsegLcRotMaq o")
public class ObjAsegLcRotMaq extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_objeto_aseg_cesante")
	private Integer idObjetoAsegCesante;

	@Column(name = "des_obj_lc_rotura")
	private String desObjLcRotura;

	@Column(name = "item_obj_lc_rotura")
	private Integer itemObjLcRotura;

	@Column(name = "ubicacion_obj_lc_rotura")
	private String ubicacionObjLcRotura;

	@Column(name = "valor_aseg_obj_lc_rotura")
	private BigDecimal valorAsegObjLcRotura;

	// bi-directional many-to-one association to RamoLcRotMaq
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cesante")
	private RamoLcRotMaq ramoLcRotMaq;

	public ObjAsegLcRotMaq() {
	}

	public Integer getIdObjetoAsegCesante() {
		return this.idObjetoAsegCesante;
	}

	public void setIdObjetoAsegCesante(Integer idObjetoAsegCesante) {
		this.idObjetoAsegCesante = idObjetoAsegCesante;
	}

	public String getDesObjLcRotura() {
		return this.desObjLcRotura;
	}

	public void setDesObjLcRotura(String desObjLcRotura) {
		this.desObjLcRotura = desObjLcRotura;
	}

	public Integer getItemObjLcRotura() {
		return this.itemObjLcRotura;
	}

	public void setItemObjLcRotura(Integer itemObjLcRotura) {
		this.itemObjLcRotura = itemObjLcRotura;
	}

	public String getUbicacionObjLcRotura() {
		return this.ubicacionObjLcRotura;
	}

	public void setUbicacionObjLcRotura(String ubicacionObjLcRotura) {
		this.ubicacionObjLcRotura = ubicacionObjLcRotura;
	}

	public BigDecimal getValorAsegObjLcRotura() {
		return this.valorAsegObjLcRotura;
	}

	public void setValorAsegObjLcRotura(BigDecimal valorAsegObjLcRotura) {
		this.valorAsegObjLcRotura = valorAsegObjLcRotura;
	}

	public RamoLcRotMaq getRamoLcRotMaq() {
		return this.ramoLcRotMaq;
	}

	public void setRamoLcRotMaq(RamoLcRotMaq ramoLcRotMaq) {
		this.ramoLcRotMaq = ramoLcRotMaq;
	}

}