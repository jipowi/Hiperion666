/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import ec.com.avila.emision.web.beans.ContactoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ContactoDTO;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario VInueza
 * @version 1.0,31/10/2014
 * @since JDK1.6
 */
@ManagedBean(name = "contactoBacking")
@ViewScoped
public class ContactoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{contactoBean}")
	private ContactoBean contactoBean;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	private List<SelectItem> tipoContactosItems;
	private boolean activarCelular;
	private boolean activarMail;
	private boolean activarTelefono;
	private boolean activarSkype;

	@PostConstruct
	public void inicializar() {
		contactoBean.setContactosDTO(new ArrayList<ContactoDTO>());
		obtenerContactos();
	}

	/**
	 * 
	 * <b> Permite obtener la lista de contactos. </b>
	 * <p>
	 * [Author: kruger, Date: 17/11/2016]
	 * </p>
	 * 
	 * @return
	 */
	public List<SelectItem> obtenerContactos() {
		try {
			List<DetalleCatalogo> detalleCatalogos = detalleCatalogoService.consultarDetalleCatalogoByCodCatalogo(new Long(23));
			if (detalleCatalogos != null && detalleCatalogos.size() > 0) {
				tipoContactosItems = new ArrayList<SelectItem>();
				for (DetalleCatalogo detalleCatalogo : detalleCatalogos) {
					SelectItem selectItem = new SelectItem(detalleCatalogo.getCodDetalleCatalogo(), detalleCatalogo.getDescDetCatalogo());
					tipoContactosItems.add(selectItem);
				}
			}
		} catch (HiperionException e) {
			e.printStackTrace();
		}

		return tipoContactosItems;
	}

	/**
	 * 
	 * <b> Permite saber el contacto seleccionado. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 29/08/2015]
	 * </p>
	 * 
	 */
	public void validarContacto() {

		if (contactoBean.getTipoContacto().equals("CELULAR")) {
			activarCelular = true;
		}
		if (contactoBean.getTipoContacto().equals("EMAIL")) {
			activarMail = true;
		}
		if (contactoBean.getTipoContacto().equals("TELEFONO")) {
			activarTelefono = true;
		}
		if (contactoBean.getTipoContacto().equals("SKYPE")) {
			activarSkype = true;
		}
	}

	/**
	 * 
	 * <b> Permite guardar el contacto del cliente. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 29/08/2015]
	 * </p>
	 * 
	 */
	public void agregarContacto() {
		ContactoDTO contactoDTO = new ContactoDTO();
		contactoDTO.setTipoContacto(contactoBean.getTipoContacto());
		contactoDTO.setDescripcionContacto(contactoBean.getDescripcionContacto());

		contactoBean.getContactosDTO().add(contactoDTO);

		activarCelular = false;
		activarMail = false;
		activarSkype = false;
		activarTelefono = false;

		contactoBean.setDescripcionContacto(null);
	}

	/**
	 * 
	 * <b> Permite editar un contacto. </b>
	 * <p>
	 * [Author: kruger, Date: 17/11/2016]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditContacto(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Contacto Editado", ((ContactoDTO) event.getObject()).getDescripcionContacto());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un contacto. </b>
	 * <p>
	 * [Author: kruger, Date: 17/11/2016]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Contacto Eliminado");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		contactoBean.getContactosDTO().remove((ContactoDTO) event.getObject());
	}

	public void cancelarContactos() {
		contactoBean.setContactosDTO(new ArrayList<ContactoDTO>());
	}

	/**
	 * @return the contactoBean
	 */
	public ContactoBean getContactoBean() {
		return contactoBean;
	}

	/**
	 * @param contactoBean
	 *            the contactoBean to set
	 */
	public void setContactoBean(ContactoBean contactoBean) {
		this.contactoBean = contactoBean;
	}

	/**
	 * @return the tipoContactosItems
	 */
	public List<SelectItem> getTipoContactosItems() {
		return tipoContactosItems;
	}

	/**
	 * @param tipoContactosItems
	 *            the tipoContactosItems to set
	 */
	public void setTipoContactosItems(List<SelectItem> tipoContactosItems) {
		this.tipoContactosItems = tipoContactosItems;
	}

	/**
	 * @return the activarCelular
	 */
	public boolean isActivarCelular() {
		return activarCelular;
	}

	/**
	 * @param activarCelular
	 *            the activarCelular to set
	 */
	public void setActivarCelular(boolean activarCelular) {
		this.activarCelular = activarCelular;
	}

	/**
	 * @return the activarMail
	 */
	public boolean isActivarMail() {
		return activarMail;
	}

	/**
	 * @param activarMail
	 *            the activarMail to set
	 */
	public void setActivarMail(boolean activarMail) {
		this.activarMail = activarMail;
	}

	/**
	 * @return the activarTelefono
	 */
	public boolean isActivarTelefono() {
		return activarTelefono;
	}

	/**
	 * @param activarTelefono
	 *            the activarTelefono to set
	 */
	public void setActivarTelefono(boolean activarTelefono) {
		this.activarTelefono = activarTelefono;
	}

	/**
	 * @return the activarSkype
	 */
	public boolean isActivarSkype() {
		return activarSkype;
	}

	/**
	 * @param activarSkype
	 *            the activarSkype to set
	 */
	public void setActivarSkype(boolean activarSkype) {
		this.activarSkype = activarSkype;
	}

}
