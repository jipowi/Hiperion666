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
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,12/01/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class RamoIncendioLineasAliadaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Tabla RAMO INCENDIO LINEAS ALIADAS
	private BigDecimal valorItems;
	private String consideracionesImp;
	private String filePolizaVigente;
	private String fileCondicionesGenerales;

	// Tabla Condiciones Particulares Incedio
	private String condicionPaticularesIncendio;

	// Tabla Clausulas Adicionales incedio
	private String clausula;

	// Tabla Incendio coberturas
	private String cebertura;
	private BigDecimal valorCoberturasIncendio;

	// Tabla Objeto asegurado Incendio
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private String detalleObjeto;
	private BigDecimal valor;

	private static final ArrayList<ObjetoAseguradoIlaBean> objetoList = new ArrayList<ObjetoAseguradoIlaBean>();

	// Tabla Detalle Objeto Incendio
	private String detalle;
	private BigDecimal valorDetalleObjetoAseguradoIncendio;

	// Tabla Codiciones Especiales Incendio
	private String condicionEsoecialesIncendio;

	// Campos aumentados tasa
	private BigDecimal tasaComprensiva;
	private BigDecimal tasaRemocionEscombros;
	private BigDecimal tasaDocumentosModelos;
	private BigDecimal tasaHonorarios;
	private BigDecimal tasaClausulaElectrica;
	private BigDecimal tasaAutoexplosion;
	private BigDecimal tasaVidrios;
	// Deducibles
	private BigDecimal porcentajeTerremoto;
	private BigDecimal porcentajeLluvia;
	private BigDecimal porcentajeVidrios;
	private BigDecimal porcentajeOtrosEventos;
	private BigDecimal minimoTerremoto;
	private BigDecimal minimoLluvia;
	private BigDecimal minimoOtrosEventos;
	private BigDecimal minimoVidriosCristaes;
	private static final ArrayList<DeducibleIncendioLineasAliadasBean> deducibleList = new ArrayList<DeducibleIncendioLineasAliadasBean>();

	// Getters and Setters

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
	 * @return the tasaRemocionEscombros
	 */
	public BigDecimal getTasaRemocionEscombros() {
		return tasaRemocionEscombros;
	}

	/**
	 * @param tasaRemocionEscombros
	 *            the tasaRemocionEscombros to set
	 */
	public void setTasaRemocionEscombros(BigDecimal tasaRemocionEscombros) {
		this.tasaRemocionEscombros = tasaRemocionEscombros;
	}

	/**
	 * @return the tasaDocumentosModelos
	 */
	public BigDecimal getTasaDocumentosModelos() {
		return tasaDocumentosModelos;
	}

	/**
	 * @param tasaDocumentosModelos
	 *            the tasaDocumentosModelos to set
	 */
	public void setTasaDocumentosModelos(BigDecimal tasaDocumentosModelos) {
		this.tasaDocumentosModelos = tasaDocumentosModelos;
	}

	/**
	 * @return the porcentajeTerremoto
	 */
	public BigDecimal getPorcentajeTerremoto() {
		return porcentajeTerremoto;
	}

	/**
	 * @param porcentajeTerremoto
	 *            the porcentajeTerremoto to set
	 */
	public void setPorcentajeTerremoto(BigDecimal porcentajeTerremoto) {
		this.porcentajeTerremoto = porcentajeTerremoto;
	}

	/**
	 * @return the porcentajeLluvia
	 */
	public BigDecimal getPorcentajeLluvia() {
		return porcentajeLluvia;
	}

	/**
	 * @param porcentajeLluvia
	 *            the porcentajeLluvia to set
	 */
	public void setPorcentajeLluvia(BigDecimal porcentajeLluvia) {
		this.porcentajeLluvia = porcentajeLluvia;
	}

	/**
	 * @return the porcentajeVidrios
	 */
	public BigDecimal getPorcentajeVidrios() {
		return porcentajeVidrios;
	}

	/**
	 * @param porcentajeVidrios
	 *            the porcentajeVidrios to set
	 */
	public void setPorcentajeVidrios(BigDecimal porcentajeVidrios) {
		this.porcentajeVidrios = porcentajeVidrios;
	}

	/**
	 * @return the porcentajeOtrosEventos
	 */
	public BigDecimal getPorcentajeOtrosEventos() {
		return porcentajeOtrosEventos;
	}

	/**
	 * @param porcentajeOtrosEventos
	 *            the porcentajeOtrosEventos to set
	 */
	public void setPorcentajeOtrosEventos(BigDecimal porcentajeOtrosEventos) {
		this.porcentajeOtrosEventos = porcentajeOtrosEventos;
	}

	/**
	 * @return the minimoTerremoto
	 */
	public BigDecimal getMinimoTerremoto() {
		return minimoTerremoto;
	}

	/**
	 * @param minimoTerremoto
	 *            the minimoTerremoto to set
	 */
	public void setMinimoTerremoto(BigDecimal minimoTerremoto) {
		this.minimoTerremoto = minimoTerremoto;
	}

	/**
	 * @return the minimoLluvia
	 */
	public BigDecimal getMinimoLluvia() {
		return minimoLluvia;
	}

	/**
	 * @param minimoLluvia
	 *            the minimoLluvia to set
	 */
	public void setMinimoLluvia(BigDecimal minimoLluvia) {
		this.minimoLluvia = minimoLluvia;
	}

	/**
	 * @return the minimoOtrosEventos
	 */
	public BigDecimal getMinimoOtrosEventos() {
		return minimoOtrosEventos;
	}

	/**
	 * @param minimoOtrosEventos
	 *            the minimoOtrosEventos to set
	 */
	public void setMinimoOtrosEventos(BigDecimal minimoOtrosEventos) {
		this.minimoOtrosEventos = minimoOtrosEventos;
	}

	/**
	 * @return the minimoVidriosCristaes
	 */
	public BigDecimal getMinimoVidriosCristaes() {
		return minimoVidriosCristaes;
	}

	/**
	 * @param minimoVidriosCristaes
	 *            the minimoVidriosCristaes to set
	 */
	public void setMinimoVidriosCristaes(BigDecimal minimoVidriosCristaes) {
		this.minimoVidriosCristaes = minimoVidriosCristaes;
	}

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
	 * @return the tasaHonorarios
	 */
	public BigDecimal getTasaHonorarios() {
		return tasaHonorarios;
	}

	/**
	 * @param tasaHonorarios
	 *            the tasaHonorarios to set
	 */
	public void setTasaHonorarios(BigDecimal tasaHonorarios) {
		this.tasaHonorarios = tasaHonorarios;
	}

	/**
	 * @return the tasaClausulaElectrica
	 */
	public BigDecimal getTasaClausulaElectrica() {
		return tasaClausulaElectrica;
	}

	/**
	 * @param tasaClausulaElectrica
	 *            the tasaClausulaElectrica to set
	 */
	public void setTasaClausulaElectrica(BigDecimal tasaClausulaElectrica) {
		this.tasaClausulaElectrica = tasaClausulaElectrica;
	}

	/**
	 * @return the tasaAutoexplosion
	 */
	public BigDecimal getTasaAutoexplosion() {
		return tasaAutoexplosion;
	}

	/**
	 * @param tasaAutoexplosion
	 *            the tasaAutoexplosion to set
	 */
	public void setTasaAutoexplosion(BigDecimal tasaAutoexplosion) {
		this.tasaAutoexplosion = tasaAutoexplosion;
	}

	/**
	 * @return the tasaVidrios
	 */
	public BigDecimal getTasaVidrios() {
		return tasaVidrios;
	}

	/**
	 * @param tasaVidrios
	 *            the tasaVidrios to set
	 */
	public void setTasaVidrios(BigDecimal tasaVidrios) {
		this.tasaVidrios = tasaVidrios;
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
	 * @return the condicionPaticularesIncendio
	 */
	public String getCondicionPaticularesIncendio() {
		return condicionPaticularesIncendio;
	}

	/**
	 * @param condicionPaticularesIncendio
	 *            the condicionPaticularesIncendio to set
	 */
	public void setCondicionPaticularesIncendio(String condicionPaticularesIncendio) {
		this.condicionPaticularesIncendio = condicionPaticularesIncendio;
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
	 * @return the valorCoberturasIncendio
	 */
	public BigDecimal getValorCoberturasIncendio() {
		return valorCoberturasIncendio;
	}

	/**
	 * @param valorCoberturasIncendio
	 *            the valorCoberturasIncendio to set
	 */
	public void setValorCoberturasIncendio(BigDecimal valorCoberturasIncendio) {
		this.valorCoberturasIncendio = valorCoberturasIncendio;
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
	 * @return the valorDetalleObjetoAseguradoIncendio
	 */
	public BigDecimal getValorDetalleObjetoAseguradoIncendio() {
		return valorDetalleObjetoAseguradoIncendio;
	}

	/**
	 * @param valorDetalleObjetoAseguradoIncendio
	 *            the valorDetalleObjetoAseguradoIncendio to set
	 */
	public void setValorDetalleObjetoAseguradoIncendio(BigDecimal valorDetalleObjetoAseguradoIncendio) {
		this.valorDetalleObjetoAseguradoIncendio = valorDetalleObjetoAseguradoIncendio;
	}

	/**
	 * @return the condicionEsoecialesIncendio
	 */
	public String getCondicionEsoecialesIncendio() {
		return condicionEsoecialesIncendio;
	}

	/**
	 * @param condicionEsoecialesIncendio
	 *            the condicionEsoecialesIncendio to set
	 */
	public void setCondicionEsoecialesIncendio(String condicionEsoecialesIncendio) {
		this.condicionEsoecialesIncendio = condicionEsoecialesIncendio;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the detalleObjeto
	 */
	public String getDetalleObjeto() {
		return detalleObjeto;
	}

	/**
	 * @param detalleObjeto
	 *            the detalleObjeto to set
	 */
	public void setDetalleObjeto(String detalleObjeto) {
		this.detalleObjeto = detalleObjeto;
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
	 * @return the objetolist
	 */
	public ArrayList<ObjetoAseguradoIlaBean> getObjetolist() {
		return objetoList;
	}

	/**
	 * @return the deduciblelist
	 */
	public ArrayList<DeducibleIncendioLineasAliadasBean> getDeduciblelist() {
		return deducibleList;
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
	public String addActionObjeto() {
		ObjetoAseguradoIlaBean orderitem = new ObjetoAseguradoIlaBean(this.numeroItem, this.ubicacionRiesgo, this.detalle, this.valor);
		objetoList.add(orderitem);

		numeroItem = 0;
		ubicacionRiesgo = "";
		detalle = "";
		valor = new BigDecimal(0);

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
	public void onEditObjeto(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoIlaBean) event.getObject()).getNumeroItem().toString());
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
	public void onCancelObjeto(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		objetoList.remove((ObjetoAseguradoIlaBean) event.getObject());
	}

	/**
	 * 
	 * <b> Permite agregar un deducible </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 08/03/2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addActionDeducible() {
		DeducibleIncendioLineasAliadasBean deducibleItem = new DeducibleIncendioLineasAliadasBean(this.porcentajeTerremoto, this.porcentajeLluvia,
				this.porcentajeVidrios, this.porcentajeOtrosEventos, this.minimoTerremoto, this.minimoLluvia, this.minimoOtrosEventos,
				this.minimoVidriosCristaes);

		deducibleList.add(deducibleItem);

		porcentajeTerremoto = new BigDecimal(0);
		porcentajeLluvia = new BigDecimal(0);
		porcentajeVidrios = new BigDecimal(0);
		porcentajeOtrosEventos = new BigDecimal(0);
		minimoTerremoto = new BigDecimal(0);
		minimoLluvia = new BigDecimal(0);
		minimoOtrosEventos = new BigDecimal(0);
		minimoVidriosCristaes = new BigDecimal(0);

		return null;
	}

	/**
	 * 
	 * <b> Permite Editar el deducible. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 08/03/2014]
	 * </p>
	 * 
	 * @param event
	 */

	public void onEditDeducible(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((DeducibleIncendioLineasAliadasBean) event.getObject()).getPorcentajeTerremoto()
				.toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Eliminar campo deducible </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 08/03/2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelDeducible(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		deducibleList.remove((DeducibleIncendioLineasAliadasBean) event.getObject());
	}

}
