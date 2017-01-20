/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
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
 * <b> Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Casco Maritimo. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,18/02/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class CascoMaritimoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private RamoService ramoService;

	private List<SelectItem> embarcacionItems;
	private List<SelectItem> zonasItems;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

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
	 * <b> Permite consultar el catalogo de embarcaciones </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Apr 12, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getEmbarcacionItems() throws HiperionException {
		this.embarcacionItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(9);
		List<DetalleCatalogo> embarcaciones = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : embarcaciones) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescripcion());
			embarcacionItems.add(selectItem);
		}

		return embarcacionItems;
	}

	/**
	 * 
	 * <b> Permite consultar las zonas de navegacion </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Apr 12, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getZonasItems() throws HiperionException {
		this.zonasItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(10);
		List<DetalleCatalogo> zonas = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : zonas) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescripcion());
			zonasItems.add(selectItem);
		}

		return zonasItems;
	}

}
