/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;

/**
 * <b> Permite manejar la informacion de los grupos para el ramo de accidentes personales. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
public class GrupoAccPersonalesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer numGrupo;
	private String nomGrupo;
	private Integer numPersonas;
	private String actividad;
	private Double valorGrupo;

	/**
	 * @param numGrupo
	 * @param nomGrupo
	 * @param numPersonas
	 * @param actividad
	 * @param valorGrupo
	 */
	public GrupoAccPersonalesDTO(Integer numGrupo, String nomGrupo, Integer numPersonas, String actividad, Double valorGrupo) {
		super();
		this.numGrupo = numGrupo;
		this.nomGrupo = nomGrupo;
		this.numPersonas = numPersonas;
		this.actividad = actividad;
		this.valorGrupo = valorGrupo;
	}

	/**
	 * @return the numGrupo
	 */
	public Integer getNumGrupo() {
		return numGrupo;
	}

	/**
	 * @param numGrupo
	 *            the numGrupo to set
	 */
	public void setNumGrupo(Integer numGrupo) {
		this.numGrupo = numGrupo;
	}

	/**
	 * @return the nomGrupo
	 */
	public String getNomGrupo() {
		return nomGrupo;
	}

	/**
	 * @param nomGrupo
	 *            the nomGrupo to set
	 */
	public void setNomGrupo(String nomGrupo) {
		this.nomGrupo = nomGrupo;
	}

	/**
	 * @return the numPersonas
	 */
	public Integer getNumPersonas() {
		return numPersonas;
	}

	/**
	 * @param numPersonas
	 *            the numPersonas to set
	 */
	public void setNumPersonas(Integer numPersonas) {
		this.numPersonas = numPersonas;
	}

	/**
	 * @return the actividad
	 */
	public String getActividad() {
		return actividad;
	}

	/**
	 * @param actividad
	 *            the actividad to set
	 */
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	/**
	 * @return the valorGrupo
	 */
	public Double getValorGrupo() {
		return valorGrupo;
	}

	/**
	 * @param valorGrupo
	 *            the valorGrupo to set
	 */
	public void setValorGrupo(Double valorGrupo) {
		this.valorGrupo = valorGrupo;
	}

	
}
