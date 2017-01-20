package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the ramo_vehiculos database table.
 * 
 */
@Entity
@Table(name = "ramo_vehiculos")
@NamedQuery(name = "RamoVehiculo.findAll", query = "SELECT r FROM RamoVehiculo r")
public class RamoVehiculo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ramo_vehiculos")
	private Integer idRamoVehiculos;

	@Column(name = "amparo_patrimonial_vh")
	private BigDecimal amparoPatrimonialVh;

	@Column(name = "anio_fabricaccion_vh")
	private Integer anioFabricaccionVh;

	@Column(name = "asistencia_vehicular")
	private String asistenciaVehicular;

	@Column(name = "auto_sustituto")
	private String autoSustituto;

	@Column(name = "chasis_vh")
	private String chasisVh;

	@Column(name = "clase_vh")
	private String claseVh;

	@Column(name = "cobertura_pacto_andino")
	private BigDecimal coberturaPactoAndino;

	@Column(name = "color_vh")
	private String colorVh;

	@Column(name = "consideraciones_imp_vh")
	private String consideracionesImpVh;

	@Column(name = "deduc_minimo_siniestro_vh")
	private BigDecimal deducMinimoSiniestroVh;

	@Column(name = "deduc_porcentaje_vh")
	private BigDecimal deducPorcentajeVh;

	@Column(name = "deduc_siniestro_vh")
	private BigDecimal deducSiniestroVh;

	@Column(name = "deduc_valor_aseg_vh")
	private BigDecimal deducValorAsegVh;

	@Column(name = "detalle_modelo_vh")
	private String detalleModeloVh;

	@Column(name = "item_vh")
	private Integer itemVh;

	@Column(name = "modelo_vh")
	private String modeloVh;

	@Column(name = "motor_vh")
	private String motorVh;

	@Column(name = "placa_vh")
	private String placaVh;

	@Column(name = "propietario_vh")
	private String propietarioVh;

	@Column(name = "tasa_vh")
	private BigDecimal tasaVh;

	@Column(name = "tipo_vh")
	private String tipoVh;

	@Column(name = "uso_vh")
	private String usoVh;

	@Column(name = "valor_aseg_vh")
	private BigDecimal valorAsegVh;

	@Column(name = "valor_total_items_vh")
	private BigDecimal valorTotalItemsVh;

	// bi-directional many-to-one association to ClausulasAddVh
	@OneToMany(mappedBy = "ramoVehiculo")
	private List<ClausulasAddVh> clausulasAddVhs;

	// bi-directional many-to-one association to CondEspVh
	@OneToMany(mappedBy = "ramoVehiculo")
	private List<CondEspVh> condEspVhs;

	// bi-directional many-to-one association to ExtrasVh
	@OneToMany(mappedBy = "ramoVehiculo")
	private List<ExtrasVh> extrasVhs;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	public RamoVehiculo() {
	}

	public Integer getIdRamoVehiculos() {
		return this.idRamoVehiculos;
	}

	public void setIdRamoVehiculos(Integer idRamoVehiculos) {
		this.idRamoVehiculos = idRamoVehiculos;
	}

	public BigDecimal getAmparoPatrimonialVh() {
		return this.amparoPatrimonialVh;
	}

	public void setAmparoPatrimonialVh(BigDecimal amparoPatrimonialVh) {
		this.amparoPatrimonialVh = amparoPatrimonialVh;
	}

	public Integer getAnioFabricaccionVh() {
		return this.anioFabricaccionVh;
	}

	public void setAnioFabricaccionVh(Integer anioFabricaccionVh) {
		this.anioFabricaccionVh = anioFabricaccionVh;
	}

	public String getAsistenciaVehicular() {
		return this.asistenciaVehicular;
	}

	public void setAsistenciaVehicular(String asistenciaVehicular) {
		this.asistenciaVehicular = asistenciaVehicular;
	}

	public String getAutoSustituto() {
		return this.autoSustituto;
	}

	public void setAutoSustituto(String autoSustituto) {
		this.autoSustituto = autoSustituto;
	}

	public String getChasisVh() {
		return this.chasisVh;
	}

	public void setChasisVh(String chasisVh) {
		this.chasisVh = chasisVh;
	}

	public String getClaseVh() {
		return this.claseVh;
	}

	public void setClaseVh(String claseVh) {
		this.claseVh = claseVh;
	}

	public BigDecimal getCoberturaPactoAndino() {
		return this.coberturaPactoAndino;
	}

	public void setCoberturaPactoAndino(BigDecimal coberturaPactoAndino) {
		this.coberturaPactoAndino = coberturaPactoAndino;
	}

	public String getColorVh() {
		return this.colorVh;
	}

	public void setColorVh(String colorVh) {
		this.colorVh = colorVh;
	}

	public String getConsideracionesImpVh() {
		return this.consideracionesImpVh;
	}

	public void setConsideracionesImpVh(String consideracionesImpVh) {
		this.consideracionesImpVh = consideracionesImpVh;
	}

	public BigDecimal getDeducMinimoSiniestroVh() {
		return this.deducMinimoSiniestroVh;
	}

	public void setDeducMinimoSiniestroVh(BigDecimal deducMinimoSiniestroVh) {
		this.deducMinimoSiniestroVh = deducMinimoSiniestroVh;
	}

	public BigDecimal getDeducPorcentajeVh() {
		return this.deducPorcentajeVh;
	}

	public void setDeducPorcentajeVh(BigDecimal deducPorcentajeVh) {
		this.deducPorcentajeVh = deducPorcentajeVh;
	}

	public BigDecimal getDeducSiniestroVh() {
		return this.deducSiniestroVh;
	}

	public void setDeducSiniestroVh(BigDecimal deducSiniestroVh) {
		this.deducSiniestroVh = deducSiniestroVh;
	}

	public BigDecimal getDeducValorAsegVh() {
		return this.deducValorAsegVh;
	}

	public void setDeducValorAsegVh(BigDecimal deducValorAsegVh) {
		this.deducValorAsegVh = deducValorAsegVh;
	}

	public String getDetalleModeloVh() {
		return this.detalleModeloVh;
	}

	public void setDetalleModeloVh(String detalleModeloVh) {
		this.detalleModeloVh = detalleModeloVh;
	}

	public Integer getItemVh() {
		return this.itemVh;
	}

	public void setItemVh(Integer itemVh) {
		this.itemVh = itemVh;
	}

	public String getModeloVh() {
		return this.modeloVh;
	}

	public void setModeloVh(String modeloVh) {
		this.modeloVh = modeloVh;
	}

	public String getMotorVh() {
		return this.motorVh;
	}

	public void setMotorVh(String motorVh) {
		this.motorVh = motorVh;
	}

	public String getPlacaVh() {
		return this.placaVh;
	}

	public void setPlacaVh(String placaVh) {
		this.placaVh = placaVh;
	}

	public String getPropietarioVh() {
		return this.propietarioVh;
	}

	public void setPropietarioVh(String propietarioVh) {
		this.propietarioVh = propietarioVh;
	}

	public BigDecimal getTasaVh() {
		return this.tasaVh;
	}

	public void setTasaVh(BigDecimal tasaVh) {
		this.tasaVh = tasaVh;
	}

	public String getTipoVh() {
		return this.tipoVh;
	}

	public void setTipoVh(String tipoVh) {
		this.tipoVh = tipoVh;
	}

	public String getUsoVh() {
		return this.usoVh;
	}

	public void setUsoVh(String usoVh) {
		this.usoVh = usoVh;
	}

	public BigDecimal getValorAsegVh() {
		return this.valorAsegVh;
	}

	public void setValorAsegVh(BigDecimal valorAsegVh) {
		this.valorAsegVh = valorAsegVh;
	}

	public BigDecimal getValorTotalItemsVh() {
		return this.valorTotalItemsVh;
	}

	public void setValorTotalItemsVh(BigDecimal valorTotalItemsVh) {
		this.valorTotalItemsVh = valorTotalItemsVh;
	}

	public List<ClausulasAddVh> getClausulasAddVhs() {
		return this.clausulasAddVhs;
	}

	public void setClausulasAddVhs(List<ClausulasAddVh> clausulasAddVhs) {
		this.clausulasAddVhs = clausulasAddVhs;
	}

	public ClausulasAddVh addClausulasAddVh(ClausulasAddVh clausulasAddVh) {
		getClausulasAddVhs().add(clausulasAddVh);
		clausulasAddVh.setRamoVehiculo(this);

		return clausulasAddVh;
	}

	public ClausulasAddVh removeClausulasAddVh(ClausulasAddVh clausulasAddVh) {
		getClausulasAddVhs().remove(clausulasAddVh);
		clausulasAddVh.setRamoVehiculo(null);

		return clausulasAddVh;
	}

	public List<CondEspVh> getCondEspVhs() {
		return this.condEspVhs;
	}

	public void setCondEspVhs(List<CondEspVh> condEspVhs) {
		this.condEspVhs = condEspVhs;
	}

	public CondEspVh addCondEspVh(CondEspVh condEspVh) {
		getCondEspVhs().add(condEspVh);
		condEspVh.setRamoVehiculo(this);

		return condEspVh;
	}

	public CondEspVh removeCondEspVh(CondEspVh condEspVh) {
		getCondEspVhs().remove(condEspVh);
		condEspVh.setRamoVehiculo(null);

		return condEspVh;
	}

	public List<ExtrasVh> getExtrasVhs() {
		return this.extrasVhs;
	}

	public void setExtrasVhs(List<ExtrasVh> extrasVhs) {
		this.extrasVhs = extrasVhs;
	}

	public ExtrasVh addExtrasVh(ExtrasVh extrasVh) {
		getExtrasVhs().add(extrasVh);
		extrasVh.setRamoVehiculo(this);

		return extrasVh;
	}

	public ExtrasVh removeExtrasVh(ExtrasVh extrasVh) {
		getExtrasVhs().remove(extrasVh);
		extrasVh.setRamoVehiculo(null);

		return extrasVh;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}