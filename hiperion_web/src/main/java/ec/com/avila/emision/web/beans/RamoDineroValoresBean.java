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

import ec.com.avila.hiperion.dto.ObjetoAseguradoDineroValoresDTO;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,16/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoDineroValoresBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera poliza
	private BigDecimal tasa;
	private String consideracionesImp;
	private String filePolizaVigente;
	private String fileNotaPedido;
	private String fileCondicionesGenerales;

	// Tabla Clausulas Adicionales dinero
	private String clausula;
	private Integer numeroDias;
	private BigDecimal valorClausula;

	// Tabla cobertura dinero y valores
	private String cebertura;
	private BigDecimal valor;

	// Tabla Deducibles
	private BigDecimal porcentajeSiniestro;
	private BigDecimal valorMinimo;
	private BigDecimal porcentajeEmbarque;
	private BigDecimal minimoPorcentaje;

	// Tabla Objeto Asegurado
	private Integer item;
	private BigDecimal dineroValores;
	private BigDecimal limiteEstimadoAnual;
	private BigDecimal limiteEmbarque;
	private String trayectoDesde;
	private String trayectoHasta;
	private String medioTransporte;
	private static final ArrayList<ObjetoAseguradoDineroValoresDTO> objetoAseguradoList = new ArrayList<ObjetoAseguradoDineroValoresDTO>();

	// Cliente - Aseguradora
	private String identificacion;
	private String aseguradora;
	private String nombreCliente;
	private String contactoAseguradora;

	// Getters and Setters

	/**
	 * @return the porcentajeSiniestro
	 */
	public BigDecimal getPorcentajeSiniestro() {
		return porcentajeSiniestro;
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
	 * @return the dineroValores
	 */
	public BigDecimal getDineroValores() {
		return dineroValores;
	}

	/**
	 * @param dineroValores
	 *            the dineroValores to set
	 */
	public void setDineroValores(BigDecimal dineroValores) {
		this.dineroValores = dineroValores;
	}

	/**
	 * @return the limiteEstimadoAnual
	 */
	public BigDecimal getLimiteEstimadoAnual() {
		return limiteEstimadoAnual;
	}

	/**
	 * @param limiteEstimadoAnual
	 *            the limiteEstimadoAnual to set
	 */
	public void setLimiteEstimadoAnual(BigDecimal limiteEstimadoAnual) {
		this.limiteEstimadoAnual = limiteEstimadoAnual;
	}

	/**
	 * @return the limiteEmbarque
	 */
	public BigDecimal getLimiteEmbarque() {
		return limiteEmbarque;
	}

	/**
	 * @param limiteEmbarque
	 *            the limiteEmbarque to set
	 */
	public void setLimiteEmbarque(BigDecimal limiteEmbarque) {
		this.limiteEmbarque = limiteEmbarque;
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
	 * @return the numeroDias
	 */
	public Integer getNumeroDias() {
		return numeroDias;
	}

	/**
	 * @param numeroDias
	 *            the numeroDias to set
	 */
	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	/**
	 * @return the valorClausula
	 */
	public BigDecimal getValorClausula() {
		return valorClausula;
	}

	/**
	 * @param valorClausula
	 *            the valorClausula to set
	 */
	public void setValorClausula(BigDecimal valorClausula) {
		this.valorClausula = valorClausula;
	}

	/**
	 * @return the valorMinimo
	 */
	public BigDecimal getValorMinimo() {
		return valorMinimo;
	}

	/**
	 * @param valorMinimo
	 *            the valorMinimo to set
	 */
	public void setValorMinimo(BigDecimal valorMinimo) {
		this.valorMinimo = valorMinimo;
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
	 * @return the minimoPorcentaje
	 */
	public BigDecimal getMinimoPorcentaje() {
		return minimoPorcentaje;
	}

	/**
	 * @param minimoPorcentaje
	 *            the minimoPorcentaje to set
	 */
	public void setMinimoPorcentaje(BigDecimal minimoPorcentaje) {
		this.minimoPorcentaje = minimoPorcentaje;
	}

	/**
	 * @param porcentajeSiniestro
	 *            the porcentajeSiniestro to set
	 */
	public void setPorcentajeSiniestro(BigDecimal porcentajeSiniestro) {
		this.porcentajeSiniestro = porcentajeSiniestro;
	}

	/**
	 * @return the consideracionesImp
	 */
	public String getConsideracionesImp() {
		return consideracionesImp;
	}

	/**
	 * @param consideracionesImp
	 *            the consideracionesImp to set
	 */
	public void setConsideracionesImp(String consideracionesImp) {
		this.consideracionesImp = consideracionesImp;
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
	 * @return the fileCondicionesGenerales
	 */
	public String getFileCondicionesGenerales() {
		return fileCondicionesGenerales;
	}

	/**
	 * @param fileCondicionesGenerales
	 *            the fileCondicionesGenerales to set
	 */
	public void setFileCondicionesGenerales(String fileCondicionesGenerales) {
		this.fileCondicionesGenerales = fileCondicionesGenerales;
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
	 * @return the objetoaseguradolist
	 */
	public ArrayList<ObjetoAseguradoDineroValoresDTO> getObjetoaseguradolist() {
		return objetoAseguradoList;
	}

	/**
	 * 
	 * <b> Permite agregar un objeto asegurado </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 03/05/2014]
	 * </p>
	 * 
	 * @return
	 */

	public String addActionObjetoAsegurado() {
		ObjetoAseguradoDineroValoresDTO objetoAseguradoItem = new ObjetoAseguradoDineroValoresDTO(this.item, this.dineroValores,
				this.limiteEstimadoAnual, this.limiteEmbarque, this.trayectoDesde, this.trayectoHasta, this.medioTransporte);
		objetoAseguradoList.add(objetoAseguradoItem);

		item = 0;
		dineroValores = new BigDecimal(0);
		limiteEstimadoAnual = new BigDecimal(0);
		limiteEmbarque = new BigDecimal(0);
		trayectoDesde = "";
		trayectoHasta = "";
		medioTransporte = "";

		return null;
	}

	/**
	 * 
	 * <b> Permite modificar un objeto ya ingresado </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 03/05/2014]
	 * </p>
	 * 
	 * @param event
	 */

	public void onEditObjetoAsegurado(RowEditEvent event) {

		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoDineroValoresDTO) event.getObject()).getItem().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	/**
	 * 
	 * <b> Permite eliminar un objeto asegurado ingresado </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 03/05/2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelObjetoAsegurado(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		objetoAseguradoList.remove((ObjetoAseguradoDineroValoresDTO) event.getObject());

	}
}