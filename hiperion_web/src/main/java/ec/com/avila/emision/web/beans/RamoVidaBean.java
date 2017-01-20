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

import ec.com.avila.hiperion.dto.AseguradoVidaDTO;
import ec.com.avila.hiperion.dto.BeneficiarioVidaDTO;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,19/01/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class RamoVidaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Cabecera de poliza
	private BigDecimal primaNetaPersona;
	private BigDecimal primaTotalPersona;
	private Integer totalAsegurados;
	private BigDecimal tasaVida;
	private BigDecimal tasaMuerte;
	private BigDecimal tasaIncapacidad;
	private String filePolizaVigente;

	// Campos para los grupos de vida
	private String nombreAsegurado;
	private String apellidoAsegurado;
	private String cedulaAsegurado;
	private int edadAsegurado;
	private static final ArrayList<AseguradoVidaDTO> aseguradoList = new ArrayList<AseguradoVidaDTO>();

	private String nombreBeneficiario;
	private String apellidoBeneficiario;
	private int edadBeneficiario;
	private String parentezco;
	private BigDecimal porcentajeDesignado;
	private static final ArrayList<BeneficiarioVidaDTO> beneficiarioList = new ArrayList<BeneficiarioVidaDTO>();
	
	// Cliente - Aseguradora
		private String identificacion;
		private String aseguradora;
		private String nombreCliente;
		private String contactoAseguradora;

	// Getters and Setters
		
		
	/**
	 * @return the primaNetaPersona
	 */
	public BigDecimal getPrimaNetaPersona() {
		return primaNetaPersona;
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
	 * @param primaNetaPersona
	 *            the primaNetaPersona to set
	 */
	public void setPrimaNetaPersona(BigDecimal primaNetaPersona) {
		this.primaNetaPersona = primaNetaPersona;
	}

	/**
	 * @return the primaTotalPersona
	 */
	public BigDecimal getPrimaTotalPersona() {
		return primaTotalPersona;
	}

	/**
	 * @param primaTotalPersona
	 *            the primaTotalPersona to set
	 */
	public void setPrimaTotalPersona(BigDecimal primaTotalPersona) {
		this.primaTotalPersona = primaTotalPersona;
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
	 * @return the totalAsegurados
	 */
	public Integer getTotalAsegurados() {
		return totalAsegurados;
	}

	/**
	 * @param totalAsegurados
	 *            the totalAsegurados to set
	 */
	public void setTotalAsegurados(Integer totalAsegurados) {
		this.totalAsegurados = totalAsegurados;
	}

	/**
	 * @return the tasaVida
	 */
	public BigDecimal getTasaVida() {
		return tasaVida;
	}

	/**
	 * @param tasaVida
	 *            the tasaVida to set
	 */
	public void setTasaVida(BigDecimal tasaVida) {
		this.tasaVida = tasaVida;
	}

	/**
	 * @return the tasaMuerte
	 */
	public BigDecimal getTasaMuerte() {
		return tasaMuerte;
	}

	/**
	 * @param tasaMuerte
	 *            the tasaMuerte to set
	 */
	public void setTasaMuerte(BigDecimal tasaMuerte) {
		this.tasaMuerte = tasaMuerte;
	}

	/**
	 * @return the tasaIncapacidad
	 */
	public BigDecimal getTasaIncapacidad() {
		return tasaIncapacidad;
	}

	/**
	 * @param tasaIncapacidad
	 *            the tasaIncapacidad to set
	 */
	public void setTasaIncapacidad(BigDecimal tasaIncapacidad) {
		this.tasaIncapacidad = tasaIncapacidad;
	}

	/**
	 * @return the nombreAsegurado
	 */
	public String getNombreAsegurado() {
		return nombreAsegurado;
	}

	/**
	 * @param nombreAsegurado
	 *            the nombreAsegurado to set
	 */
	public void setNombreAsegurado(String nombreAsegurado) {
		this.nombreAsegurado = nombreAsegurado;
	}

	/**
	 * @return the apellidoAsegurado
	 */
	public String getApellidoAsegurado() {
		return apellidoAsegurado;
	}

	/**
	 * @param apellidoAsegurado
	 *            the apellidoAsegurado to set
	 */
	public void setApellidoAsegurado(String apellidoAsegurado) {
		this.apellidoAsegurado = apellidoAsegurado;
	}

	/**
	 * @return the cedulaAsegurado
	 */
	public String getCedulaAsegurado() {
		return cedulaAsegurado;
	}

	/**
	 * @param cedulaAsegurado
	 *            the cedulaAsegurado to set
	 */
	public void setCedulaAsegurado(String cedulaAsegurado) {
		this.cedulaAsegurado = cedulaAsegurado;
	}

	/**
	 * @return the edadAsegurado
	 */
	public int getEdadAsegurado() {
		return edadAsegurado;
	}

	/**
	 * @param edadAsegurado
	 *            the edadAsegurado to set
	 */
	public void setEdadAsegurado(int edadAsegurado) {
		this.edadAsegurado = edadAsegurado;
	}

	/**
	 * @return the nombreBeneficiario
	 */
	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}

	/**
	 * @param nombreBeneficiario
	 *            the nombreBeneficiario to set
	 */
	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}

	/**
	 * @return the apellidoBeneficiario
	 */
	public String getApellidoBeneficiario() {
		return apellidoBeneficiario;
	}

	/**
	 * @param apellidoBeneficiario
	 *            the apellidoBeneficiario to set
	 */
	public void setApellidoBeneficiario(String apellidoBeneficiario) {
		this.apellidoBeneficiario = apellidoBeneficiario;
	}

	/**
	 * @return the edadBeneficiario
	 */
	public int getEdadBeneficiario() {
		return edadBeneficiario;
	}

	/**
	 * @param edadBeneficiario
	 *            the edadBeneficiario to set
	 */
	public void setEdadBeneficiario(int edadBeneficiario) {
		this.edadBeneficiario = edadBeneficiario;
	}

	/**
	 * @return the parentezco
	 */
	public String getParentezco() {
		return parentezco;
	}

	/**
	 * @param parentezco
	 *            the parentezco to set
	 */
	public void setParentezco(String parentezco) {
		this.parentezco = parentezco;
	}

	/**
	 * @return the porcentajeDesignado
	 */
	public BigDecimal getPorcentajeDesignado() {
		return porcentajeDesignado;
	}

	/**
	 * @param porcentajeDesignado
	 *            the porcentajeDesignado to set
	 */
	public void setPorcentajeDesignado(BigDecimal porcentajeDesignado) {
		this.porcentajeDesignado = porcentajeDesignado;
	}

	/**
	 * @return the beneficiariolist
	 */
	public ArrayList<BeneficiarioVidaDTO> getBeneficiariolist() {
		return beneficiarioList;
	}

	/**
	 * 
	 * <b> Permite agregar un asegurado a los grupos de vida </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 8, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addAsegurado() {
		AseguradoVidaDTO orderitem = new AseguradoVidaDTO(this.nombreAsegurado, this.apellidoAsegurado, this.cedulaAsegurado, this.edadAsegurado);
		aseguradoList.add(orderitem);

		nombreAsegurado = "";
		apellidoAsegurado = "";
		cedulaAsegurado = "";
		edadAsegurado = 0;

		return null;
	}

	/**
	 * 
	 * <b> Permite agregar un beneficiario a los grupos de vida </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 8, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addBeneficiario() {
		BeneficiarioVidaDTO orderitem = new BeneficiarioVidaDTO(this.nombreBeneficiario, this.apellidoBeneficiario, this.edadAsegurado, this.parentezco,
				this.porcentajeDesignado);
		beneficiarioList.add(orderitem);

		nombreBeneficiario = "";
		apellidoBeneficiario = "";
		edadAsegurado = 0;
		parentezco = "";
		porcentajeDesignado = new BigDecimal(0.0);

		return null;
	}

	/**
	 * @return the aseguradolist
	 */
	public ArrayList<AseguradoVidaDTO> getAseguradolist() {
		return aseguradoList;
	}

	/**
	 * 
	 * <b> Permite editar un asegurado </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 8, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditAsegurado(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((AseguradoVidaDTO) event.getObject()).getNombres().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite editar un beneficiario </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 8, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditBeneficiario(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((BeneficiarioVidaDTO) event.getObject()).getNombres().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite remover un asegurado </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 8, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelAsegurado(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		aseguradoList.remove((AseguradoVidaDTO) event.getObject());
	}

	/**
	 * 
	 * <b> Permite remover un beneficiario </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 8, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelBeneficiario(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		beneficiarioList.remove((BeneficiarioVidaDTO) event.getObject());
	}
}
