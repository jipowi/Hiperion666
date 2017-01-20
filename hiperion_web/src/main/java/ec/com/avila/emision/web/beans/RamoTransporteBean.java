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

import ec.com.avila.hiperion.dto.ObjetoAseguradoTransporteDTO;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,13/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoTransporteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Tabla RamoTransporte
	private BigDecimal tasa;
	private BigDecimal porcentajeSiniestro;
	private BigDecimal porcentajeEmbarque;
	private BigDecimal minimoSiniestro;
	private BigDecimal minimoEmbarque;
	private String condImportantes;
	private String filePolizaVigente;
	private String fileNotaPedido;
	private String fileCondicionesParticulares;

	// Objeto Asegurado
	private Integer item;
	private Integer limiteMovilizacionAnual;
	private Integer limiteEmbarque;
	private String medioTransporte;
	private String trayectoDesde;
	private String trayectoHasta;
	private String tipoEmbalaje;
	private BigDecimal valuacion;

	private static final ArrayList<ObjetoAseguradoTransporteDTO> objetoAseguradoList = new ArrayList<ObjetoAseguradoTransporteDTO>();

	// Tabla Clausulas adicionales Transporte
	private String clausula;

	// Tabla Condiciones especiales transporte
	private String condicion;

	// Tabla cobertura Transporte
	private String cebertura;
	private BigDecimal valor;

	// Cliente - Aseguradora
	private String identificacion;
	private String aseguradora;
	private String nombreCliente;
	private String contactoAseguradora;

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

	// Getters and Setters
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
	 * @return the minimoEmbarque
	 */
	public BigDecimal getMinimoEmbarque() {
		return minimoEmbarque;
	}

	/**
	 * @param minimoEmbarque
	 *            the minimoEmbarque to set
	 */
	public void setMinimoEmbarque(BigDecimal minimoEmbarque) {
		this.minimoEmbarque = minimoEmbarque;
	}

	/**
	 * @return the condImportantes
	 */
	public String getCondImportantes() {
		return condImportantes;
	}

	/**
	 * @param condImportantes
	 *            the condImportantes to set
	 */
	public void setCondImportantes(String condImportantes) {
		this.condImportantes = condImportantes;
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
	 * @return the fileNotaPedido
	 */
	public String getFileNotaPedido() {
		return fileNotaPedido;
	}

	/**
	 * @param fileNotaPedido
	 *            the fileNotaPedido to set
	 */
	public void setFileNotaPedido(String fileNotaPedido) {
		this.fileNotaPedido = fileNotaPedido;
	}

	/**
	 * @return the fileCondicionesParticulares
	 */
	public String getFileCondicionesParticulares() {
		return fileCondicionesParticulares;
	}

	/**
	 * @param fileCondicionesParticulares
	 *            the fileCondicionesParticulares to set
	 */
	public void setFileCondicionesParticulares(String fileCondicionesParticulares) {
		this.fileCondicionesParticulares = fileCondicionesParticulares;
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
	 * @return the cebertura
	 */
	public String getCebertura() {
		return cebertura;
	}

	/**
	 * @param cebertura
	 *            the cebertura to set
	 */
	public void setCebertura(String cebertura) {
		this.cebertura = cebertura;
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
	 * @return the limiteMovilizacionAnual
	 */
	public Integer getLimiteMovilizacionAnual() {
		return limiteMovilizacionAnual;
	}

	/**
	 * @param limiteMovilizacionAnual
	 *            the limiteMovilizacionAnual to set
	 */
	public void setLimiteMovilizacionAnual(Integer limiteMovilizacionAnual) {
		this.limiteMovilizacionAnual = limiteMovilizacionAnual;
	}

	/**
	 * @return the limiteEmbarque
	 */
	public Integer getLimiteEmbarque() {
		return limiteEmbarque;
	}

	/**
	 * @param limiteEmbarque
	 *            the limiteEmbarque to set
	 */
	public void setLimiteEmbarque(Integer limiteEmbarque) {
		this.limiteEmbarque = limiteEmbarque;
	}

	/**
	 * @return the medioTransporte
	 */
	public String getMedioTransporte() {
		return medioTransporte;
	}

	/**
	 * @param medioTransporte
	 *            the medioTransporte to set
	 */
	public void setMedioTransporte(String medioTransporte) {
		this.medioTransporte = medioTransporte;
	}

	/**
	 * @return the trayectoDesde
	 */
	public String getTrayectoDesde() {
		return trayectoDesde;
	}

	/**
	 * @param trayectoDesde
	 *            the trayectoDesde to set
	 */
	public void setTrayectoDesde(String trayectoDesde) {
		this.trayectoDesde = trayectoDesde;
	}

	/**
	 * @return the trayectoHasta
	 */
	public String getTrayectoHasta() {
		return trayectoHasta;
	}

	/**
	 * @param trayectoHasta
	 *            the trayectoHasta to set
	 */
	public void setTrayectoHasta(String trayectoHasta) {
		this.trayectoHasta = trayectoHasta;
	}

	/**
	 * @return the tipoEmbalaje
	 */
	public String getTipoEmbalaje() {
		return tipoEmbalaje;
	}

	/**
	 * @param tipoEmbalaje
	 *            the tipoEmbalaje to set
	 */
	public void setTipoEmbalaje(String tipoEmbalaje) {
		this.tipoEmbalaje = tipoEmbalaje;
	}

	/**
	 * @return the valuacion
	 */
	public BigDecimal getValuacion() {
		return valuacion;
	}

	/**
	 * @param valuacion
	 *            the valuacion to set
	 */
	public void setValuacion(BigDecimal valuacion) {
		this.valuacion = valuacion;
	}

	/**
	 * @return the objetoaseguradolist
	 */
	public ArrayList<ObjetoAseguradoTransporteDTO> getObjetoaseguradolist() {
		return objetoAseguradoList;
	}

	/**
	 * @return the porcentajeEmbarque
	 */
	public BigDecimal getPorcentajeEmbarque() {
		return porcentajeEmbarque;
	}

	/**
	 * @param porcentajeEmbarque
	 *            the porcentajeEmbarque to set
	 */
	public void setPorcentajeEmbarque(BigDecimal porcentajeEmbarque) {
		this.porcentajeEmbarque = porcentajeEmbarque;
	}

	/**
	 * 
	 * <b> Permite agregar un objeto asegurado a la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public void addObjeto() {

		ObjetoAseguradoTransporteDTO objeto = new ObjetoAseguradoTransporteDTO(this.item, this.limiteMovilizacionAnual, this.limiteEmbarque,
				this.medioTransporte, this.trayectoDesde, this.trayectoHasta, this.tipoEmbalaje, this.valuacion);
		objetoAseguradoList.add(objeto);

		

	}

	/**
	 * 
	 * <b> Permite editar un objeto asegurado </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void editObjeto(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoTransporteDTO) event.getObject()).getItem().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite remover un objeto asegurado de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void cancelObjeto(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		objetoAseguradoList.remove((ObjetoAseguradoTransporteDTO) event.getObject());
	}
}
