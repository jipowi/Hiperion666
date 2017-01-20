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

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,16/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoEquipoElectronicoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String filePolizaVigente;

	// Tabla Objeto asegurado Equipo
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private String descripcion;
	private String detalle;
	private BigDecimal valorObjeto;

	// Tasa Equipo Electronico
	private BigDecimal tasaFijos;
	private BigDecimal tasaDatos;
	private BigDecimal tasaOperacion;
	private BigDecimal tasaPortatiles;
	private BigDecimal tasaCelulares;
	private BigDecimal tasaHurto;

	private static final ArrayList<ObjetoAseguradoEquipoElectronicoBean> orderList = new ArrayList<ObjetoAseguradoEquipoElectronicoBean>();

	/**
	 * @return the tasaFijos
	 */
	public BigDecimal getTasaFijos() {
		return tasaFijos;
	}

	/**
	 * @param tasaFijos
	 *            the tasaFijos to set
	 */
	public void setTasaFijos(BigDecimal tasaFijos) {
		this.tasaFijos = tasaFijos;
	}

	/**
	 * @return the tasaDatos
	 */
	public BigDecimal getTasaDatos() {
		return tasaDatos;
	}

	/**
	 * @param tasaDatos
	 *            the tasaDatos to set
	 */
	public void setTasaDatos(BigDecimal tasaDatos) {
		this.tasaDatos = tasaDatos;
	}

	/**
	 * @return the tasaOperacion
	 */
	public BigDecimal getTasaOperacion() {
		return tasaOperacion;
	}

	/**
	 * @param tasaOperacion
	 *            the tasaOperacion to set
	 */
	public void setTasaOperacion(BigDecimal tasaOperacion) {
		this.tasaOperacion = tasaOperacion;
	}

	/**
	 * @return the tasaPortatiles
	 */
	public BigDecimal getTasaPortatiles() {
		return tasaPortatiles;
	}

	/**
	 * @param tasaPortatiles
	 *            the tasaPortatiles to set
	 */
	public void setTasaPortatiles(BigDecimal tasaPortatiles) {
		this.tasaPortatiles = tasaPortatiles;
	}

	/**
	 * @return the tasaCelulares
	 */
	public BigDecimal getTasaCelulares() {
		return tasaCelulares;
	}

	/**
	 * @param tasaCelulares
	 *            the tasaCelulares to set
	 */
	public void setTasaCelulares(BigDecimal tasaCelulares) {
		this.tasaCelulares = tasaCelulares;
	}

	/**
	 * @return the tasaHurto
	 */
	public BigDecimal getTasaHurto() {
		return tasaHurto;
	}

	/**
	 * @param tasaHurto
	 *            the tasaHurto to set
	 */
	public void setTasaHurto(BigDecimal tasaHurto) {
		this.tasaHurto = tasaHurto;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the valorObjeto
	 */
	public BigDecimal getValorObjeto() {
		return valorObjeto;
	}

	/**
	 * @param valorObjeto
	 *            the valorObjeto to set
	 */
	public void setValorObjeto(BigDecimal valorObjeto) {
		this.valorObjeto = valorObjeto;
	}

	/**
	 * @return the orderlist
	 */
	public ArrayList<ObjetoAseguradoEquipoElectronicoBean> getOrderlist() {
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
		ObjetoAseguradoEquipoElectronicoBean orderitem = new ObjetoAseguradoEquipoElectronicoBean(this.numeroItem, this.ubicacionRiesgo,
				this.descripcion, this.detalle, this.valorObjeto);
		orderList.add(orderitem);

		numeroItem = 0;
		ubicacionRiesgo = "";
		descripcion = "";
		detalle = "";
		valorObjeto = new BigDecimal(0);

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
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoEquipoElectronicoBean) event.getObject()).getNumeroItem().toString());
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
		orderList.remove((ObjetoAseguradoEquipoElectronicoBean) event.getObject());
	}
}
