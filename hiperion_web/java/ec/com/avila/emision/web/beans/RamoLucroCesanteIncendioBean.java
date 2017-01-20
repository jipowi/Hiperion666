/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

/**
 * <b>Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples</b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/01/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class RamoLucroCesanteIncendioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de la poliza
	private BigDecimal valorItems;
	private Integer periodoIndemnizacion;
	private BigDecimal tasaComprensiva;
	private BigDecimal deducibleCatastrofico;
	private BigDecimal deducibleOtros;
	private String filePolizaVigente;

	// Objeto Aseurado LucroCesanteIncendio
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private String formaSeguro;
	private BigDecimal utilidadBruta;
	private String detalle;

	private static final ArrayList<ObjetoAseguradoCesanteILABean> orderList = new ArrayList<ObjetoAseguradoCesanteILABean>();

	// Tabla Clasulas Adicionales Lucro
	private String clausula;
	private Integer numeroDias;
	private BigDecimal valorClasulaAddLucro;

	// Tabla Coberturas lucro
	private String cebertura;
	private BigDecimal valorCoberturaLucro;

	// Getters and Setters

	/**
	 * @return the valorItems
	 */
	public BigDecimal getValorItems() {
		return valorItems;
	}

	/**
	 * @param valorItems
	 *            the valorItems to set
	 */
	public void setValorItems(BigDecimal valorItems) {
		this.valorItems = valorItems;
	}

	/**
	 * @return the periodoIndemnizacion
	 */
	public Integer getPeriodoIndemnizacion() {
		return periodoIndemnizacion;
	}

	/**
	 * @param periodoIndemnizacion
	 *            the periodoIndemnizacion to set
	 */
	public void setPeriodoIndemnizacion(Integer periodoIndemnizacion) {
		this.periodoIndemnizacion = periodoIndemnizacion;
	}

	/**
	 * @return the tasaComprensiva
	 */
	public BigDecimal getTasaComprensiva() {
		return tasaComprensiva;
	}

	/**
	 * @param tasaComprensiva
	 *            the tasaComprensiva to set
	 */
	public void setTasaComprensiva(BigDecimal tasaComprensiva) {
		this.tasaComprensiva = tasaComprensiva;
	}

	/**
	 * @return the deducibleCatastrofico
	 */
	public BigDecimal getDeducibleCatastrofico() {
		return deducibleCatastrofico;
	}

	/**
	 * @param deducibleCatastrofico
	 *            the deducibleCatastrofico to set
	 */
	public void setDeducibleCatastrofico(BigDecimal deducibleCatastrofico) {
		this.deducibleCatastrofico = deducibleCatastrofico;
	}

	/**
	 * @return the deducibleOtros
	 */
	public BigDecimal getDeducibleOtros() {
		return deducibleOtros;
	}

	/**
	 * @param deducibleOtros
	 *            the deducibleOtros to set
	 */
	public void setDeducibleOtros(BigDecimal deducibleOtros) {
		this.deducibleOtros = deducibleOtros;
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
	 * @return the numeroItem
	 */
	public Integer getNumeroItem() {
		return numeroItem;
	}

	/**
	 * @param numeroItem
	 *            the numeroItem to set
	 */
	public void setNumeroItem(Integer numeroItem) {
		this.numeroItem = numeroItem;
	}

	/**
	 * @return the ubicacionRiesgo
	 */
	public String getUbicacionRiesgo() {
		return ubicacionRiesgo;
	}

	/**
	 * @param ubicacionRiesgo
	 *            the ubicacionRiesgo to set
	 */
	public void setUbicacionRiesgo(String ubicacionRiesgo) {
		this.ubicacionRiesgo = ubicacionRiesgo;
	}

	/**
	 * @return the formaSeguro
	 */
	public String getFormaSeguro() {
		return formaSeguro;
	}

	/**
	 * @param formaSeguro
	 *            the formaSeguro to set
	 */
	public void setFormaSeguro(String formaSeguro) {
		this.formaSeguro = formaSeguro;
	}

	/**
	 * @return the utilidadBruta
	 */
	public BigDecimal getUtilidadBruta() {
		return utilidadBruta;
	}

	/**
	 * @param utilidadBruta
	 *            the utilidadBruta to set
	 */
	public void setUtilidadBruta(BigDecimal utilidadBruta) {
		this.utilidadBruta = utilidadBruta;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle
	 *            the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
	 * @return the valorClasulaAddLucro
	 */
	public BigDecimal getValorClasulaAddLucro() {
		return valorClasulaAddLucro;
	}

	/**
	 * @param valorClasulaAddLucro
	 *            the valorClasulaAddLucro to set
	 */
	public void setValorClasulaAddLucro(BigDecimal valorClasulaAddLucro) {
		this.valorClasulaAddLucro = valorClasulaAddLucro;
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
	 * @return the valorCoberturaLucro
	 */
	public BigDecimal getValorCoberturaLucro() {
		return valorCoberturaLucro;
	}

	/**
	 * @param valorCoberturaLucro
	 *            the valorCoberturaLucro to set
	 */
	public void setValorCoberturaLucro(BigDecimal valorCoberturaLucro) {
		this.valorCoberturaLucro = valorCoberturaLucro;
	}

	/**
	 * @return the orderlist
	 */
	public ArrayList<ObjetoAseguradoCesanteILABean> getOrderlist() {
		return orderList;
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
	public String addAction() {
		ObjetoAseguradoCesanteILABean orderitem = new ObjetoAseguradoCesanteILABean(this.numeroItem, this.ubicacionRiesgo, this.formaSeguro,
				this.utilidadBruta, this.detalle);
		orderList.add(orderitem);

		numeroItem = 0;
		ubicacionRiesgo = "";
		formaSeguro = "";
		utilidadBruta = new BigDecimal(0);
		detalle = "";

		return null;
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
	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoCesanteILABean) event.getObject()).getNumeroItem().toString());
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
	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		orderList.remove((ObjetoAseguradoCesanteILABean) event.getObject());
	}
}
