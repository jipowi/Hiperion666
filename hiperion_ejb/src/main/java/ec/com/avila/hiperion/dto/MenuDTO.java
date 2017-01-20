/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.io.Serializable;

/**
 * <b>Permite manejar la informacion de la tabla menu</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,11/01/2015
 * @since JDK1.6
 */
public class MenuDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idMenu;
	private String estadoMenu;
	private Integer idPadre;
	private String nombreMenu;
	private String url;
	private Boolean selected;

	/**
	 * @return the idMenu
	 */
	public Integer getIdMenu() {
		return idMenu;
	}

	/**
	 * @param idMenu
	 *            the idMenu to set
	 */
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	/**
	 * @return the estadoMenu
	 */
	public String getEstadoMenu() {
		return estadoMenu;
	}

	/**
	 * @param estadoMenu
	 *            the estadoMenu to set
	 */
	public void setEstadoMenu(String estadoMenu) {
		this.estadoMenu = estadoMenu;
	}

	/**
	 * @return the idPadre
	 */
	public Integer getIdPadre() {
		return idPadre;
	}

	/**
	 * @param idPadre
	 *            the idPadre to set
	 */
	public void setIdPadre(Integer idPadre) {
		this.idPadre = idPadre;
	}

	/**
	 * @return the nombreMenu
	 */
	public String getNombreMenu() {
		return nombreMenu;
	}

	/**
	 * @param nombreMenu
	 *            the nombreMenu to set
	 */
	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the selected
	 */
	public Boolean getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

}
