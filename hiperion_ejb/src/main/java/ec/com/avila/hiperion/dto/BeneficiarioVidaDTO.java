/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Jul 8, 2014
 * @since JDK1.6
 */
public class BeneficiarioVidaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombres;
	private String apellidos;
	private int edad;
	private String parentezco;
	private BigDecimal porcentajeDesignado;

	/**
	 * @param nombres
	 * @param apellidos
	 * @param edad
	 * @param parentezco
	 * @param porcentajeDesignado
	 */
	public BeneficiarioVidaDTO(String nombres, String apellidos, int edad, String parentezco, BigDecimal porcentajeDesignado) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.parentezco = parentezco;
		this.porcentajeDesignado = porcentajeDesignado;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres
	 *            the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad
	 *            the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
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

}
