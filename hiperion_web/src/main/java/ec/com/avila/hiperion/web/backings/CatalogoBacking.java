package ec.com.avila.hiperion.web.backings;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.web.beans.CatalogoBean;

@ManagedBean
@RequestScoped
public class CatalogoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{catalogoBean}")
	private CatalogoBean catalogoBean;

	@EJB
	private CatalogoService catalogoService;

	private List<Catalogo> catalogos;

	@PostConstruct
	public void inicializar() throws HiperionException {
		setCatalogos(catalogoService.consultarCatalogos());
	}

	public List<Catalogo> getCatalogos() {
		return catalogos;
	}

	public void onEdit(RowEditEvent event) throws HiperionException {
		Catalogo catalogo = (Catalogo) event.getObject();
		catalogoService.modificarCatalogo(catalogo);
		FacesMessage msg = new FacesMessage("Catalogo Editado", catalogo.getDescripcionCatalogo());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Catalogo Cancelado", ((Catalogo) event.getObject()).getDescripcionCatalogo());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b>
	 * Permite Guardar un nuevo Catalogo.
	 * </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 9, 2014]
	 * </p>
	 * @throws HiperionException 
	 * 
	 */
	public void guardarCatalogo(ActionEvent event) throws HiperionException {
		Catalogo catalogo = new Catalogo();
		catalogo.setDescripcionCatalogo(catalogoBean.getDescripcion());
		catalogoService.guardarCatalogo(catalogo);

		String msg = "Guardado";
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		setCatalogos(catalogoService.consultarCatalogos());
	}

	/**
	 * 
	 * <b>
	 * Incluir aqui� la descripcion del metodo.
	 * </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 5, 2014]
	 * </p>
	 * 
	 * @param catalogos
	 */
	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	public CatalogoBean getCatalogoBean() {
		return catalogoBean;
	}

	public void setCatalogoBean(CatalogoBean catalogoBean) {
		this.catalogoBean = catalogoBean;
	}
}
