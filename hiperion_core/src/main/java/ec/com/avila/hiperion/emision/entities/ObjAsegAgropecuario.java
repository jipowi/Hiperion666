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
 * The persistent class for the obj_aseg_agropecuario database table.
 * 
 */
@Entity
@Table(name = "obj_aseg_agropecuario")
@NamedQuery(name = "ObjAsegAgropecuario.findAll", query = "SELECT o FROM ObjAsegAgropecuario o")
public class ObjAsegAgropecuario extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_obj_agropecuario")
	private Integer idObjAgropecuario;

	@Column(name = "color_obj_agro")
	private String colorObjAgro;

	@Column(name = "edad_obj_agro")
	private Integer edadObjAgro;

	@Column(name = "item_obj_agro")
	private Integer itemObjAgro;

	@Column(name = "monto_aseg_obj_agro")
	private BigDecimal montoAsegObjAgro;

	@Column(name = "nombre_obj_agro")
	private String nombreObjAgro;

	@Column(name = "raza_obj_agro")
	private String razaObjAgro;

	@Column(name = "sexo_obj_agro")
	private String sexoObjAgro;

	@Column(name = "valor_asegurado_agro")
	private BigDecimal valorAseguradoAgro;

	@Column(name = "detalle_agro")
	private String detalleAgro;

	@Column(name = "ubicacion_agro")
	private String ubicacion;

	@Column(name = "tipo_objeto_agro")
	private Integer tipoObjeto;

	// bi-directional many-to-one association to RamoAgropecuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_agropecuario")
	private RamoAgropecuario ramoAgropecuario;

	public ObjAsegAgropecuario() {
	}

	public Integer getIdObjAgropecuario() {
		return this.idObjAgropecuario;
	}

	public void setIdObjAgropecuario(Integer idObjAgropecuario) {
		this.idObjAgropecuario = idObjAgropecuario;
	}

	public String getColorObjAgro() {
		return this.colorObjAgro;
	}

	public void setColorObjAgro(String colorObjAgro) {
		this.colorObjAgro = colorObjAgro;
	}

	public Integer getEdadObjAgro() {
		return this.edadObjAgro;
	}

	public void setEdadObjAgro(Integer edadObjAgro) {
		this.edadObjAgro = edadObjAgro;
	}

	public Integer getItemObjAgro() {
		return this.itemObjAgro;
	}

	public void setItemObjAgro(Integer itemObjAgro) {
		this.itemObjAgro = itemObjAgro;
	}

	public BigDecimal getMontoAsegObjAgro() {
		return this.montoAsegObjAgro;
	}

	public void setMontoAsegObjAgro(BigDecimal montoAsegObjAgro) {
		this.montoAsegObjAgro = montoAsegObjAgro;
	}

	public String getNombreObjAgro() {
		return this.nombreObjAgro;
	}

	public void setNombreObjAgro(String nombreObjAgro) {
		this.nombreObjAgro = nombreObjAgro;
	}

	public String getRazaObjAgro() {
		return this.razaObjAgro;
	}

	public void setRazaObjAgro(String razaObjAgro) {
		this.razaObjAgro = razaObjAgro;
	}

	public String getSexoObjAgro() {
		return this.sexoObjAgro;
	}

	public void setSexoObjAgro(String sexoObjAgro) {
		this.sexoObjAgro = sexoObjAgro;
	}

	public RamoAgropecuario getRamoAgropecuario() {
		return this.ramoAgropecuario;
	}

	public void setRamoAgropecuario(RamoAgropecuario ramoAgropecuario) {
		this.ramoAgropecuario = ramoAgropecuario;
	}

	/**
	 * @return the valorAseguradoAgro
	 */
	public BigDecimal getValorAseguradoAgro() {
		return valorAseguradoAgro;
	}

	/**
	 * @param valorAseguradoAgro
	 *            the valorAseguradoAgro to set
	 */
	public void setValorAseguradoAgro(BigDecimal valorAseguradoAgro) {
		this.valorAseguradoAgro = valorAseguradoAgro;
	}

	/**
	 * @return the detalleAgro
	 */
	public String getDetalleAgro() {
		return detalleAgro;
	}

	/**
	 * @param detalleAgro
	 *            the detalleAgro to set
	 */
	public void setDetalleAgro(String detalleAgro) {
		this.detalleAgro = detalleAgro;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion
	 *            the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the tipoObjeto
	 */
	public Integer getTipoObjeto() {
		return tipoObjeto;
	}

	/**
	 * @param tipoObjeto
	 *            the tipoObjeto to set
	 */
	public void setTipoObjeto(Integer tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}

}