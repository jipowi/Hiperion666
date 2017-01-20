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
 * The persistent class for the obj_aseg_incendio database table.
 * 
 */
@Entity
@Table(name = "obj_aseg_incendio")
@NamedQuery(name = "ObjAsegIncendio.findAll", query = "SELECT o FROM ObjAsegIncendio o")
public class ObjAsegIncendio extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_objeto_aseg_incendio")
	private Integer idObjetoAsegIncendio;

	@Column(name = "detalle_incendio")
	private String detalleIncendio;

	@Column(name = "forma_seguro_incendio")
	private BigDecimal formaSeguroIncendio;

	@Column(name = "item_incendio")
	private String itemIncendio;

	@Column(name = "ubicacion_incendio")
	private String ubicacionIncendio;

	@Column(name = "utilidad_bruta_incendio_la")
	private BigDecimal utilidadBrutaIncendioLa;

	@Column(name = "valor_obj_aseg_incendio")
	private BigDecimal valorObjAsegIncendio;

	// bi-directional many-to-one association to RamoIncendioLineasAliada
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_incendio")
	private RamoIncendioLineasAliada ramoIncendioLineasAliada;

	public ObjAsegIncendio() {
	}

	public Integer getIdObjetoAsegIncendio() {
		return this.idObjetoAsegIncendio;
	}

	public void setIdObjetoAsegIncendio(Integer idObjetoAsegIncendio) {
		this.idObjetoAsegIncendio = idObjetoAsegIncendio;
	}

	public String getDetalleIncendio() {
		return this.detalleIncendio;
	}

	public void setDetalleIncendio(String detalleIncendio) {
		this.detalleIncendio = detalleIncendio;
	}

	public BigDecimal getFormaSeguroIncendio() {
		return this.formaSeguroIncendio;
	}

	public void setFormaSeguroIncendio(BigDecimal formaSeguroIncendio) {
		this.formaSeguroIncendio = formaSeguroIncendio;
	}

	public String getItemIncendio() {
		return this.itemIncendio;
	}

	public void setItemIncendio(String itemIncendio) {
		this.itemIncendio = itemIncendio;
	}

	public String getUbicacionIncendio() {
		return this.ubicacionIncendio;
	}

	public void setUbicacionIncendio(String ubicacionIncendio) {
		this.ubicacionIncendio = ubicacionIncendio;
	}

	public BigDecimal getUtilidadBrutaIncendioLa() {
		return this.utilidadBrutaIncendioLa;
	}

	public void setUtilidadBrutaIncendioLa(BigDecimal utilidadBrutaIncendioLa) {
		this.utilidadBrutaIncendioLa = utilidadBrutaIncendioLa;
	}

	public BigDecimal getValorObjAsegIncendio() {
		return this.valorObjAsegIncendio;
	}

	public void setValorObjAsegIncendio(BigDecimal valorObjAsegIncendio) {
		this.valorObjAsegIncendio = valorObjAsegIncendio;
	}

	public RamoIncendioLineasAliada getRamoIncendioLineasAliada() {
		return this.ramoIncendioLineasAliada;
	}

	public void setRamoIncendioLineasAliada(RamoIncendioLineasAliada ramoIncendioLineasAliada) {
		this.ramoIncendioLineasAliada = ramoIncendioLineasAliada;
	}

}