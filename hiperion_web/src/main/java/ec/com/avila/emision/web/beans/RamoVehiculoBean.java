/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ec.com.avila.hiperion.dto.ExtraVehiculosDTO;
import ec.com.avila.hiperion.web.beans.MarcasDto;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,15/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoVehiculoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Cabecera de la poliza
	private Integer item;
	private String propietario;
	private String tipoVehiculo;
	private String claseVehiculo;
	private String marca;
	private MarcasDto selectedMarcas;
	private String modelo;
	private String detalleModelo;
	private String color;
	private String placa;
	private String motor;
	private String chasis;
	private Integer anio;
	private String uso;
	private BigDecimal valorAsegurado;
	private BigDecimal valorTotalItem;
	private BigDecimal tasa;
	private BigDecimal porcentajeDeducible;
	private BigDecimal porcentajeSiniestro;
	private BigDecimal minimoSiniestro;
	private BigDecimal porcentajeValorAsegurado;
	private String consideraciones;
	private BigDecimal amparoPatrimonial;
	private BigDecimal coberturaPactoAndino;
	private String asistenciaVehicular;
	private String autoSustituto;
	private String filePolizaVigente;
	private static final ArrayList<ExtraVehiculosDTO> extrasList = new ArrayList<ExtraVehiculosDTO>();
	private String extra;
	private BigDecimal valorExtra;
	private Integer cantidadExtra;

	// Tabla Coberturas vehiculos
	private String ceberturaVehiculo;
	private BigDecimal valorVehiculo;

	// Tabla Clausulas Adicional Vehiculos
	private String clausula;

	// Tabla condiciones especiales vehiculos
	private String condicion;

	// Tabla extras vehiculos
	private BigDecimal valor;

	// Cliente - Aseguradora
	private String identificacion;
	private String ruc;
	private String aseguradora;
	private String nombreCliente;
	private String contactoAseguradora;
	
	private boolean activarCedula;
	private boolean activarRuc;

	// Getters and Setters
	/**
	 * @return the item
	 */
	public Integer getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(Integer item) {
		this.item = item;
	}

	/**
	 * @return the propietario
	 */
	public String getPropietario() {
		return propietario;
	}

	/**
	 * @param propietario
	 *            the propietario to set
	 */
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	/**
	 * @return the tipoVehiculo
	 */
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	/**
	 * @param tipoVehiculo
	 *            the tipoVehiculo to set
	 */
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	/**
	 * @return the claseVehiculo
	 */
	public String getClaseVehiculo() {
		return claseVehiculo;
	}

	/**
	 * @param claseVehiculo
	 *            the claseVehiculo to set
	 */
	public void setClaseVehiculo(String claseVehiculo) {
		this.claseVehiculo = claseVehiculo;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca
	 *            the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 *            the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the detalleModelo
	 */
	public String getDetalleModelo() {
		return detalleModelo;
	}

	/**
	 * @param detalleModelo
	 *            the detalleModelo to set
	 */
	public void setDetalleModelo(String detalleModelo) {
		this.detalleModelo = detalleModelo;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color.toUpperCase();
	}

	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa
	 *            the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa.toUpperCase();
	}

	/**
	 * @return the motor
	 */
	public String getMotor() {
		return motor;
	}

	/**
	 * @param motor
	 *            the motor to set
	 */
	public void setMotor(String motor) {
		this.motor = motor.toUpperCase();
	}

	/**
	 * @return the chasis
	 */
	public String getChasis() {
		return chasis;
	}

	/**
	 * @param chasis
	 *            the chasis to set
	 */
	public void setChasis(String chasis) {
		this.chasis = chasis.toUpperCase();
	}

	/**
	 * @return the anio
	 */
	public Integer getAnio() {
		return anio;
	}

	/**
	 * @param anio
	 *            the anio to set
	 */
	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	/**
	 * @return the uso
	 */
	public String getUso() {
		return uso;
	}

	/**
	 * @param uso
	 *            the uso to set
	 */
	public void setUso(String uso) {
		this.uso = uso;
	}

	/**
	 * @return the valorAsegurado
	 */
	public BigDecimal getValorAsegurado() {
		return valorAsegurado;
	}

	/**
	 * @param valorAsegurado
	 *            the valorAsegurado to set
	 */
	public void setValorAsegurado(BigDecimal valorAsegurado) {
		this.valorAsegurado = valorAsegurado;
	}

	/**
	 * @return the valorTotalItem
	 */
	public BigDecimal getValorTotalItem() {
		return valorTotalItem;
	}

	/**
	 * @param valorTotalItem
	 *            the valorTotalItem to set
	 */
	public void setValorTotalItem(BigDecimal valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
	}

	/**
	 * @return the tasa
	 */
	public BigDecimal getTasa() {
		return tasa;
	}

	/**
	 * @param tasa
	 *            the tasa to set
	 */
	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
	}

	/**
	 * @return the porcentajeDeducible
	 */
	public BigDecimal getPorcentajeDeducible() {
		return porcentajeDeducible;
	}

	/**
	 * @param porcentajeDeducible
	 *            the porcentajeDeducible to set
	 */
	public void setPorcentajeDeducible(BigDecimal porcentajeDeducible) {
		this.porcentajeDeducible = porcentajeDeducible;
	}

	/**
	 * @return the porcentajeSiniestro
	 */
	public BigDecimal getPorcentajeSiniestro() {
		return porcentajeSiniestro;
	}

	/**
	 * @param porcentajeSiniestro
	 *            the porcentajeSiniestro to set
	 */
	public void setPorcentajeSiniestro(BigDecimal porcentajeSiniestro) {
		this.porcentajeSiniestro = porcentajeSiniestro;
	}

	/**
	 * @return the minimoSiniestro
	 */
	public BigDecimal getMinimoSiniestro() {
		return minimoSiniestro;
	}

	/**
	 * @param minimoSiniestro
	 *            the minimoSiniestro to set
	 */
	public void setMinimoSiniestro(BigDecimal minimoSiniestro) {
		this.minimoSiniestro = minimoSiniestro;
	}

	/**
	 * @return the porcentajeValorAsegurado
	 */
	public BigDecimal getPorcentajeValorAsegurado() {
		return porcentajeValorAsegurado;
	}

	/**
	 * @param porcentajeValorAsegurado
	 *            the porcentajeValorAsegurado to set
	 */
	public void setPorcentajeValorAsegurado(BigDecimal porcentajeValorAsegurado) {
		this.porcentajeValorAsegurado = porcentajeValorAsegurado;
	}

	/**
	 * @return the consideraciones
	 */
	public String getConsideraciones() {
		return consideraciones;
	}

	/**
	 * @param consideraciones
	 *            the consideraciones to set
	 */
	public void setConsideraciones(String consideraciones) {
		this.consideraciones = consideraciones;
	}

	/**
	 * @return the amparoPatrimonial
	 */
	public BigDecimal getAmparoPatrimonial() {
		return amparoPatrimonial;
	}

	/**
	 * @param amparoPatrimonial
	 *            the amparoPatrimonial to set
	 */
	public void setAmparoPatrimonial(BigDecimal amparoPatrimonial) {
		this.amparoPatrimonial = amparoPatrimonial;
	}

	/**
	 * @return the coberturaPactoAndino
	 */
	public BigDecimal getCoberturaPactoAndino() {
		return coberturaPactoAndino;
	}

	/**
	 * @param coberturaPactoAndino
	 *            the coberturaPactoAndino to set
	 */
	public void setCoberturaPactoAndino(BigDecimal coberturaPactoAndino) {
		this.coberturaPactoAndino = coberturaPactoAndino;
	}

	/**
	 * @return the asistenciaVehicular
	 */
	public String getAsistenciaVehicular() {
		return asistenciaVehicular;
	}

	/**
	 * @param asistenciaVehicular
	 *            the asistenciaVehicular to set
	 */
	public void setAsistenciaVehicular(String asistenciaVehicular) {
		this.asistenciaVehicular = asistenciaVehicular;
	}

	/**
	 * @return the autoSustituto
	 */
	public String getAutoSustituto() {
		return autoSustituto;
	}

	/**
	 * @param autoSustituto
	 *            the autoSustituto to set
	 */
	public void setAutoSustituto(String autoSustituto) {
		this.autoSustituto = autoSustituto;
	}

	/**
	 * @return the filePolizaVigente
	 */
	public String getFilePolizaVigente() {
		return filePolizaVigente;
	}

	/**
	 * @param filePolizaVigente
	 *            the filePolizaVigente to set
	 */
	public void setFilePolizaVigente(String filePolizaVigente) {
		this.filePolizaVigente = filePolizaVigente;
	}

	/**
	 * @return the ceberturaVehiculo
	 */
	public String getCeberturaVehiculo() {
		return ceberturaVehiculo;
	}

	/**
	 * @param ceberturaVehiculo
	 *            the ceberturaVehiculo to set
	 */
	public void setCeberturaVehiculo(String ceberturaVehiculo) {
		this.ceberturaVehiculo = ceberturaVehiculo;
	}

	/**
	 * @return the valorVehiculo
	 */
	public BigDecimal getValorVehiculo() {
		return valorVehiculo;
	}

	/**
	 * @param valorVehiculo
	 *            the valorVehiculo to set
	 */
	public void setValorVehiculo(BigDecimal valorVehiculo) {
		this.valorVehiculo = valorVehiculo;
	}

	/**
	 * @return the clausula
	 */
	public String getClausula() {
		return clausula;
	}

	/**
	 * @param clausula
	 *            the clausula to set
	 */
	public void setClausula(String clausula) {
		this.clausula = clausula;
	}

	/**
	 * @return the condicion
	 */
	public String getCondicion() {
		return condicion;
	}

	/**
	 * @param condicion
	 *            the condicion to set
	 */
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * @return the extra
	 */
	public String getExtra() {
		return extra;
	}

	/**
	 * @param extra
	 *            the extra to set
	 */
	public void setExtra(String extra) {
		this.extra = extra;
	}

	/**
	 * @return the valorExtra
	 */
	public BigDecimal getValorExtra() {
		return valorExtra;
	}

	/**
	 * @param valorExtra
	 *            the valorExtra to set
	 */
	public void setValorExtra(BigDecimal valorExtra) {
		this.valorExtra = valorExtra;
	}

	/**
	 * @return the cantidadExtra
	 */
	public Integer getCantidadExtra() {
		return cantidadExtra;
	}

	/**
	 * @param cantidadExtra
	 *            the cantidadExtra to set
	 */
	public void setCantidadExtra(Integer cantidadExtra) {
		this.cantidadExtra = cantidadExtra;
	}

	/**
	 * @return the extraslist
	 */
	public ArrayList<ExtraVehiculosDTO> getExtraslist() {
		return extrasList;
	}

	/**
	 * 
	 * <b> Permite agregar un nuevo extra </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 21, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addExtras() {

		ExtraVehiculosDTO newExtra = new ExtraVehiculosDTO(this.extra, this.valorExtra, this.cantidadExtra);
		extrasList.add(newExtra);

		extra = "";
		valor = new BigDecimal(0);
		cantidadExtra = 0;

		return null;
	}

	/**
	 * 
	 * <b> Permite editar un extra </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 21, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void editExtra(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ExtraVehiculosDTO) event.getObject()).getExtra());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un extra </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 21, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void cancelExtra(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		extrasList.remove((ExtraVehiculosDTO) event.getObject());
	}

	/**
	 * @return the selectedMarcas
	 */
	public MarcasDto getSelectedMarcas() {
		return selectedMarcas;
	}

	/**
	 * @param selectedMarcas
	 *            the selectedMarcas to set
	 */
	public void setSelectedMarcas(MarcasDto selectedMarcas) {
		this.selectedMarcas = selectedMarcas;
	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion
	 *            the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the aseguradora
	 */
	public String getAseguradora() {
		return aseguradora;
	}

	/**
	 * @param aseguradora
	 *            the aseguradora to set
	 */
	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}

	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente
	 *            the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return the contactoAseguradora
	 */
	public String getContactoAseguradora() {
		return contactoAseguradora;
	}

	/**
	 * @param contactoAseguradora
	 *            the contactoAseguradora to set
	 */
	public void setContactoAseguradora(String contactoAseguradora) {
		this.contactoAseguradora = contactoAseguradora;
	}

	/**
	 * @return the ruc
	 */
	public String getRuc() {
		return ruc;
	}

	/**
	 * @param ruc the ruc to set
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	/**
	 * @return the activarCedula
	 */
	public boolean isActivarCedula() {
		return activarCedula;
	}

	/**
	 * @param activarCedula the activarCedula to set
	 */
	public void setActivarCedula(boolean activarCedula) {
		this.activarCedula = activarCedula;
	}

	/**
	 * @return the activarRuc
	 */
	public boolean isActivarRuc() {
		return activarRuc;
	}

	/**
	 * @param activarRuc the activarRuc to set
	 */
	public void setActivarRuc(boolean activarRuc) {
		this.activarRuc = activarRuc;
	}
	
	

}
