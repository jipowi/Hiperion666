/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.com.avila.hiperion.dto.AseguradoraDTO;

/**
 * 
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Aug 3, 2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class AseguradoraBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codAseguradora;
	private String ruc;
	private String direccion;
	private String telefono;
	private String mailAseguradora;
	private List<AseguradoraDTO> aseguradorasList;
	private Long idRamo;

	private Boolean activarTabla = false;
	private Boolean activarNewAseguradora = false;

	/**
	 * @return the codAseguradora
	 */
	public Integer getCodAseguradora() {
		return codAseguradora;
	}

	/**
	 * @param codAseguradora
	 *            the codAseguradora to set
	 */
	public void setCodAseguradora(Integer codAseguradora) {
		this.codAseguradora = codAseguradora;
	}

	/**
	 * @return the ruc
	 */
	public String getRuc() {
		return ruc;
	}

	/**
	 * @param ruc
	 *            the ruc to set
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the mailAseguradora
	 */
	public String getMailAseguradora() {
		return mailAseguradora;
	}

	/**
	 * @param mailAseguradora
	 *            the mailAseguradora to set
	 */
	public void setMailAseguradora(String mailAseguradora) {
		this.mailAseguradora = mailAseguradora;
	}

	/**
	 * @return the aseguradorasList
	 */
	public List<AseguradoraDTO> getAseguradorasList() {
		return aseguradorasList;
	}

	/**
	 * @param aseguradorasList
	 *            the aseguradorasList to set
	 */
	public void setAseguradorasList(List<AseguradoraDTO> aseguradorasList) {
		this.aseguradorasList = aseguradorasList;
	}

	/**
	 * @return the activarTabla
	 */
	public Boolean getActivarTabla() {
		return activarTabla;
	}

	/**
	 * @param activarTabla
	 *            the activarTabla to set
	 */
	public void setActivarTabla(Boolean activarTabla) {
		this.activarTabla = activarTabla;
	}

	/**
	 * @return the activarNewAseguradora
	 */
	public Boolean getActivarNewAseguradora() {
		return activarNewAseguradora;
	}

	/**
	 * @param activarNewAseguradora
	 *            the activarNewAseguradora to set
	 */
	public void setActivarNewAseguradora(Boolean activarNewAseguradora) {
		this.activarNewAseguradora = activarNewAseguradora;
	}

	/**
	 * @return the idRamo
	 */
	public Long getIdRamo() {
		return idRamo;
	}

	/**
	 * @param idRamo
	 *            the idRamo to set
	 */
	public void setIdRamo(Long idRamo) {
		this.idRamo = idRamo;
	}

}
