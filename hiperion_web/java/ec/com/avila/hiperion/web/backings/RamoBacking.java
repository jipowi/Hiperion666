/**
 * 
 */
package ec.com.avila.hiperion.web.backings;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;

/**
 * <b> Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen ramos. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,Dec 21, 2013
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class RamoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;
	
	@EJB
	private RamoService ramoService;

	/**
	 * @return the ramoBean
	 */
	public RamoBean getRamoBean() {
		return ramoBean;
	}

	/**
	 * @param ramoBean
	 *            the ramoBean to set
	 */
	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * @return the ramoSeleccionado
	 */
	public String getRamoSeleccionado() {
		return "Hola Mundo";
	}
}
