package ec.com.avila.hiperion.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Catalogo;
import ec.com.avila.hiperion.entities.DetalleCatalogo;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.web.beans.DetalleCatalogoBean;

@ManagedBean
@RequestScoped
public class DetalleCatalogoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{detalleCatalogoBean}")
	private DetalleCatalogoBean detalleCatalogoBean;

	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	private List<DetalleCatalogo> detallesCatalogo;
	private List<SelectItem> catalogosItems;

	private Boolean activarDetCatalogoPanel;
	private static Catalogo catalogo;
	private static Integer newCodDetCatalogo;

	@PostConstruct
	public void inicializar() throws HiperionException {
		if (catalogo != null) {
			setDetallesCatalogo(detalleCatalogoService.consultarDetalleCatalogoByCodCatalogo(catalogo.getIdCatalogo()));
			setActivarDetCatalogoPanel(true);
		} else {
			setActivarDetCatalogoPanel(false);
		}
	}

	/**
	 * 
	 * <b>
	 * Incluir aqui­ la descripcion del metodo.
	 * </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 10, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException 
	 */
	public List<SelectItem> getCatalogosItems() throws HiperionException {
		this.catalogosItems = new ArrayList<SelectItem>();
		List<Catalogo> catalogos = catalogoService.consultarCatalogos();
		if (catalogos != null) {
			for (Catalogo catalogo : catalogos) {
				SelectItem selectItem = new SelectItem(catalogo.getIdCatalogo(), catalogo.getDescripcion());
				catalogosItems.add(selectItem);
			}
		}

		return catalogosItems;
	}

	/**
	 * 
	 * <b>
	 * Incluir aqui­ la descripcion del metodo.
	 * </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 10, 2014]
	 * </p>
	 * @throws HiperionException 
	 * 
	 */
	public void selectCatalogo() throws HiperionException {
		Integer codigoCatalogo = detalleCatalogoBean.getCodigoCatalogo();
		catalogo = catalogoService.consultarCatalogoById(codigoCatalogo);
		detallesCatalogo = detalleCatalogoService.consultarDetalleCatalogoByCodCatalogo(codigoCatalogo);
		if (detallesCatalogo != null) {
			setDetallesCatalogo(detallesCatalogo);
			setActivarDetCatalogoPanel(true);
			detalleCatalogoBean.setDescripcionCatalogo(catalogo.getDescripcion());
		}
	}

	/**
	 * 
	 * <b>
	 * Incluir aqui­ la descripcion del metodo.
	 * </b>
	 * <p>
	 * [Author: KRUGER-DARVIN, Date: Jan 10, 2014]
	 * </p>
	 * 
	 * @param event
	 * @throws HiperionException 
	 */
	public void guardarDetalleCatalogo(ActionEvent event) throws HiperionException {
		newCodDetCatalogo = detalleCatalogoService.consultarDetalleCatalogoByCodCatalogo(catalogo.getIdCatalogo()).size() + 1;
		DetalleCatalogo detalleCatalogo = new DetalleCatalogo();
		detalleCatalogo.setCatalogo(catalogo);
		detalleCatalogo.setDescripcion(detalleCatalogoBean.getDescripcionCatalogo());
		detalleCatalogo.setCodDetalleCatalogo(String.valueOf(newCodDetCatalogo));
		detalleCatalogoService.guardarDetalleCatalogo(detalleCatalogo);

		detalleCatalogoBean.setDescripcionCatalogo(catalogo.getDescripcion());
		setDetallesCatalogo(detalleCatalogoService.consultarDetalleCatalogoByCodCatalogo(catalogo.getIdCatalogo()));
		setActivarDetCatalogoPanel(true);
	}

	public void onEdit(RowEditEvent event) throws HiperionException {
		DetalleCatalogo detCatalogo = (DetalleCatalogo) event.getObject();
		detalleCatalogoService.modificarDetalleCatalogo(detCatalogo);
		FacesMessage msg = new FacesMessage("Detalle Catalogo", detCatalogo.getDescripcion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Detalle Catalogo Cancelado", ((DetalleCatalogo) event.getObject()).getDescripcion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public DetalleCatalogoBean getDetalleCatalogoBean() {
		return detalleCatalogoBean;
	}

	public void setDetalleCatalogoBean(DetalleCatalogoBean detalleCatalogoBean) {
		this.detalleCatalogoBean = detalleCatalogoBean;
	}

	public List<DetalleCatalogo> getDetallesCatalogo() {
		return detallesCatalogo;
	}

	public void setDetallesCatalogo(List<DetalleCatalogo> detallesCatalogo) {
		this.detallesCatalogo = detallesCatalogo;
	}

	public Boolean getActivarDetCatalogoPanel() {
		return activarDetCatalogoPanel;
	}

	public void setActivarDetCatalogoPanel(Boolean activarDetCatalogoPanel) {
		this.activarDetCatalogoPanel = activarDetCatalogoPanel;
	}
}