/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Catalogo;
import ec.com.avila.hiperion.entities.DetalleCatalogo;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Lucro Cesante Incendio
 * Lineas Aliadas. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class LucroCesanteIncendioBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<SelectItem> formaSeguroItems;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	@EJB
	private RamoService ramoService;

	public void guardar() {
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * 
	 * <b> Permite obtener las formas de suguro almacenadas en la base </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 30, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getFormaSeguroItems() throws HiperionException {
		this.formaSeguroItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(8);
		List<DetalleCatalogo> formasSeguro = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : formasSeguro) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescripcion());
			formaSeguroItems.add(selectItem);
		}

		return formaSeguroItems;
	}

	/**
	 * @param formaSeguroItems
	 *            the formaSeguroItems to set
	 */
	public void setFormaSeguroItems(List<SelectItem> formaSeguroItems) {
		this.formaSeguroItems = formaSeguroItems;
	}

}