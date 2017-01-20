package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * s
 * 
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,12/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoAccidentesPersonalesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Tabla RamoAccidentesPersonales
	private BigDecimal primaNetaPersona;
	private BigDecimal primaTotalPersona;
	private Integer facturacion;
	private BigDecimal deducible;

	// Tabla ClausulasAddAccPer
	private String clausula;

	// Tabla miembros grupo
	private String nombre;
	private String cedula;
	private Date fechaNacimiento;
	private String parentezco;
	private String sexo;
	private Integer edad;
	private String grupo;

	// Coberturas grupo
	private String cebertura;
	private BigDecimal valorCobertura;

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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 *            the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}

	/**
	 * @param edad
	 *            the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
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
	 * @return the valorCobertura
	 */
	public BigDecimal getValorCobertura() {
		return valorCobertura;
	}

	/**
	 * @param valorCobertura
	 *            the valorCobertura to set
	 */
	public void setValorCobertura(BigDecimal valorCobertura) {
		this.valorCobertura = valorCobertura;
	}

	public Integer getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(Integer facturacion) {
		this.facturacion = facturacion;
	}

	public BigDecimal getDeducible() {
		return deducible;
	}

	public void setDeducible(BigDecimal deducible) {
		this.deducible = deducible;
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
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

}
