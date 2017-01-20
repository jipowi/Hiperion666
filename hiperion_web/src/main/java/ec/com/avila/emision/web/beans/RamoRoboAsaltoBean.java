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

import ec.com.avila.hiperion.dto.ObjetoAseguradoRoboDTO;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoRoboAsaltoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabera de la poliza
	private BigDecimal tasaRobo;
	private BigDecimal tasaHurto;
	private BigDecimal tasaPropiedad;
	private BigDecimal tasaContenidos;
	private String filePolizaVigente;

	// Tabla Condicines Especiales Robo
	private String condicion;
	private BigDecimal valor;

	// Tabla Clasulas Adicionales Robo
	private String clausula;
	private BigDecimal valorClauslasAddRobo;
	private Integer numeroDias;

	// Tabla Objeto Asegurado Robo
	private Integer numeroItem;
	private String ubicacionRiesgo;
	private BigDecimal valorDetalleObjeto;
	private BigDecimal mueblesEnseresEquipos;
	private BigDecimal joyasObrasArte;
	private BigDecimal maquinaria;
	private BigDecimal dineroPermanencia;
	private BigDecimal mercaderia;
	private String detalleObjeto;
	private static final ArrayList<ObjetoAseguradoRoboDTO> objetoAseguradoList = new ArrayList<ObjetoAseguradoRoboDTO>();

	// Tabla coberturas robo
	private BigDecimal valorCoberturaRoboAsalto;
	private String cobertura;

	// Tabla Robo Cobertura adicionales robo
	private BigDecimal valorCoberturaAddRoboAsalto;
	private String coberturaAddRoboAsalto;

	// Deducibles
	private BigDecimal porcentajeSiniestroRobo;
	private BigDecimal porcentajeSiniestroHurto;
	private BigDecimal porcentajeSiniestroPropiedad;
	private BigDecimal minimoRobo;
	private BigDecimal minimoHurto;
	private BigDecimal minimoPropiedad;
	private static final ArrayList<DeducibleRoboBean> deducibleList = new ArrayList<DeducibleRoboBean>();
	
	// Cliente - Aseguradora
		private String identificacion;
		private String aseguradora;
		private String nombreCliente;
		private String contactoAseguradora;

	// Getters and Setters
		
		
		

	/**
	 * @return the valorCoberturaRoboAsalto
	 */
	public BigDecimal getValorCoberturaRoboAsalto() {
		return valorCoberturaRoboAsalto;
	}

	/**
	 * @return the contactoAseguradora
	 */
	public String getContactoAseguradora() {
		return contactoAseguradora;
	}

	/**
	 * @param contactoAseguradora the contactoAseguradora to set
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
	 * @param aseguradora the aseguradora to set
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
	 * @param nombreCliente the nombreCliente to set
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
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @param valorCoberturaRoboAsalto
	 *            the valorCoberturaRoboAsalto to set
	 */
	public void setValorCoberturaRoboAsalto(BigDecimal valorCoberturaRoboAsalto) {
		this.valorCoberturaRoboAsalto = valorCoberturaRoboAsalto;
	}

	/**
	 * @return the cobertura
	 */
	public String getCobertura() {
		return cobertura;
	}

	/**
	 * @param cobertura
	 *            the cobertura to set
	 */
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	/**
	 * @return the valorCoberturaAddRoboAsalto
	 */
	public BigDecimal getValorCoberturaAddRoboAsalto() {
		return valorCoberturaAddRoboAsalto;
	}

	/**
	 * @param valorCoberturaAddRoboAsalto
	 *            the valorCoberturaAddRoboAsalto to set
	 */
	public void setValorCoberturaAddRoboAsalto(BigDecimal valorCoberturaAddRoboAsalto) {
		this.valorCoberturaAddRoboAsalto = valorCoberturaAddRoboAsalto;
	}

	/**
	 * @return the coberturaAddRoboAsalto
	 */
	public String getCoberturaAddRoboAsalto() {
		return coberturaAddRoboAsalto;
	}

	/**
	 * @param coberturaAddRoboAsalto
	 *            the coberturaAddRoboAsalto to set
	 */
	public void setCoberturaAddRoboAsalto(String coberturaAddRoboAsalto) {
		this.coberturaAddRoboAsalto = coberturaAddRoboAsalto;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return the porcentajeSiniestroPropiedad
	 */
	public BigDecimal getPorcentajeSiniestroPropiedad() {
		return porcentajeSiniestroPropiedad;
	}

	/**
	 * @param porcentajeSiniestroPropiedad
	 *            the porcentajeSiniestroPropiedad to set
	 */
	public void setPorcentajeSiniestroPropiedad(BigDecimal porcentajeSiniestroPropiedad) {
		this.porcentajeSiniestroPropiedad = porcentajeSiniestroPropiedad;
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
	 * @return the valorClauslasAddRobo
	 */
	public BigDecimal getValorClauslasAddRobo() {
		return valorClauslasAddRobo;
	}

	/**
	 * @param valorClauslasAddRobo
	 *            the valorClauslasAddRobo to set
	 */
	public void setValorClauslasAddRobo(BigDecimal valorClauslasAddRobo) {
		this.valorClauslasAddRobo = valorClauslasAddRobo;
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
	 * @return the valorDetalleObjeto
	 */
	public BigDecimal getValorDetalleObjeto() {
		return valorDetalleObjeto;
	}

	/**
	 * @param valorDetalleObjeto
	 *            the valorDetalleObjeto to set
	 */
	public void setValorDetalleObjeto(BigDecimal valorDetalleObjeto) {
		this.valorDetalleObjeto = valorDetalleObjeto;
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
	 * @return the porcentajeSiniestroRobo
	 */
	public BigDecimal getPorcentajeSiniestroRobo() {
		return porcentajeSiniestroRobo;
	}

	/**
	 * @param porcentajeSiniestroRobo
	 *            the porcentajeSiniestroRobo to set
	 */
	public void setPorcentajeSiniestroRobo(BigDecimal porcentajeSiniestroRobo) {
		this.porcentajeSiniestroRobo = porcentajeSiniestroRobo;
	}

	/**
	 * @return the porcentajeSiniestroHurto
	 */
	public BigDecimal getPorcentajeSiniestroHurto() {
		return porcentajeSiniestroHurto;
	}

	/**
	 * @param porcentajeSiniestroHurto
	 *            the porcentajeSiniestroHurto to set
	 */
	public void setPorcentajeSiniestroHurto(BigDecimal porcentajeSiniestroHurto) {
		this.porcentajeSiniestroHurto = porcentajeSiniestroHurto;
	}

	/**
	 * @return the mueblesEnseresEquipos
	 */
	public BigDecimal getMueblesEnseresEquipos() {
		return mueblesEnseresEquipos;
	}

	/**
	 * @param mueblesEnseresEquipos
	 *            the mueblesEnseresEquipos to set
	 */
	public void setMueblesEnseresEquipos(BigDecimal mueblesEnseresEquipos) {
		this.mueblesEnseresEquipos = mueblesEnseresEquipos;
	}

	/**
	 * @return the joyasObrasArte
	 */
	public BigDecimal getJoyasObrasArte() {
		return joyasObrasArte;
	}

	/**
	 * @param joyasObrasArte
	 *            the joyasObrasArte to set
	 */
	public void setJoyasObrasArte(BigDecimal joyasObrasArte) {
		this.joyasObrasArte = joyasObrasArte;
	}

	/**
	 * @return the maquinaria
	 */
	public BigDecimal getMaquinaria() {
		return maquinaria;
	}

	/**
	 * @param maquinaria
	 *            the maquinaria to set
	 */
	public void setMaquinaria(BigDecimal maquinaria) {
		this.maquinaria = maquinaria;
	}

	/**
	 * @return the dineroPermanencia
	 */
	public BigDecimal getDineroPermanencia() {
		return dineroPermanencia;
	}

	/**
	 * @param dineroPermanencia
	 *            the dineroPermanencia to set
	 */
	public void setDineroPermanencia(BigDecimal dineroPermanencia) {
		this.dineroPermanencia = dineroPermanencia;
	}

	/**
	 * @return the mercaderia
	 */
	public BigDecimal getMercaderia() {
		return mercaderia;
	}

	/**
	 * @param mercaderia
	 *            the mercaderia to set
	 */
	public void setMercaderia(BigDecimal mercaderia) {
		this.mercaderia = mercaderia;
	}

	/**
	 * @return the minimoRobo
	 */
	public BigDecimal getMinimoRobo() {
		return minimoRobo;
	}

	/**
	 * @param minimoRobo
	 *            the minimoRobo to set
	 */
	public void setMinimoRobo(BigDecimal minimoRobo) {
		this.minimoRobo = minimoRobo;
	}

	/**
	 * @return the minimoHurto
	 */
	public BigDecimal getMinimoHurto() {
		return minimoHurto;
	}

	/**
	 * @param minimoHurto
	 *            the minimoHurto to set
	 */
	public void setMinimoHurto(BigDecimal minimoHurto) {
		this.minimoHurto = minimoHurto;
	}

	/**
	 * @return the minimoPropiedad
	 */
	public BigDecimal getMinimoPropiedad() {
		return minimoPropiedad;
	}

	/**
	 * @return the tasaRobo
	 */
	public BigDecimal getTasaRobo() {
		return tasaRobo;
	}

	/**
	 * @param tasaRobo
	 *            the tasaRobo to set
	 */
	public void setTasaRobo(BigDecimal tasaRobo) {
		this.tasaRobo = tasaRobo;
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
	 * @return the tasaPropiedad
	 */
	public BigDecimal getTasaPropiedad() {
		return tasaPropiedad;
	}

	/**
	 * @param tasaPropiedad
	 *            the tasaPropiedad to set
	 */
	public void setTasaPropiedad(BigDecimal tasaPropiedad) {
		this.tasaPropiedad = tasaPropiedad;
	}

	/**
	 * @param minimoPropiedad
	 *            the minimoPropiedad to set
	 */
	public void setMinimoPropiedad(BigDecimal minimoPropiedad) {
		this.minimoPropiedad = minimoPropiedad;
	}

	/**
	 * @return the objetoaseguradolist
	 */
	public ArrayList<ObjetoAseguradoRoboDTO> getObjetoaseguradolist() {
		return objetoAseguradoList;
	}

	/**
	 * @return the deduciblelist
	 */
	public ArrayList<DeducibleRoboBean> getDeduciblelist() {
		return deducibleList;
	}

	/**
	 * @return the tasaContenidos
	 */
	public BigDecimal getTasaContenidos() {
		return tasaContenidos;
	}

	/**
	 * @param tasaContenidos
	 *            the tasaContenidos to set
	 */
	public void setTasaContenidos(BigDecimal tasaContenidos) {
		this.tasaContenidos = tasaContenidos;
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
		ObjetoAseguradoRoboDTO orderitem = new ObjetoAseguradoRoboDTO(this.numeroItem, this.ubicacionRiesgo, this.valorDetalleObjeto,
				this.mueblesEnseresEquipos, this.joyasObrasArte, this.maquinaria, this.dineroPermanencia, this.mercaderia, this.detalleObjeto);

		objetoAseguradoList.add(orderitem);

		numeroItem = 0;
		ubicacionRiesgo = "";
		valorDetalleObjeto = new BigDecimal(0);
		mueblesEnseresEquipos = new BigDecimal(0);
		joyasObrasArte = new BigDecimal(0);
		maquinaria = new BigDecimal(0);
		dineroPermanencia = new BigDecimal(0);
		mercaderia = new BigDecimal(0);
		detalleObjeto = "";

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
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetoAseguradoRoboDTO) event.getObject()).getNumeroItem().toString());
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
		objetoAseguradoList.remove((ObjetoAseguradoRoboDTO) event.getObject());
	}

	/**
	 * 
	 * <b> Incluir aqui� la descripcion del metodo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 8, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addActionDeducile() {
		DeducibleRoboBean deducibleItem = new DeducibleRoboBean(this.porcentajeSiniestroRobo, this.porcentajeSiniestroHurto,
				this.porcentajeSiniestroPropiedad, this.minimoRobo, this.minimoHurto, this.minimoPropiedad);

		deducibleList.add(deducibleItem);

		porcentajeSiniestroRobo = new BigDecimal(0);
		porcentajeSiniestroHurto = new BigDecimal(0);
		porcentajeSiniestroPropiedad = new BigDecimal(0);
		minimoRobo = new BigDecimal(0);
		minimoHurto = new BigDecimal(0);
		minimoPropiedad = new BigDecimal(0);

		return null;
	}

	/**
	 * 
	 * <b> Incluir aqui� la descripcion del metodo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 8, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditDeducible(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((DeducibleRoboBean) event.getObject()).getPorcentajeSiniestroRobo().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Incluir aqui� la descripcion del metodo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 8, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelDeducible(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		deducibleList.remove((DeducibleRoboBean) event.getObject());
	}
}
