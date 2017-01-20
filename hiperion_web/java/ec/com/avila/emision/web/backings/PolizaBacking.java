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

import ec.com.avila.emision.web.beans.PolizaBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Catalogo;
import ec.com.avila.hiperion.entities.DetalleCatalogo;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.PolizaService;
import ec.com.avila.hiperion.servicio.UsuarioService;

/**
 * <b> Clase que�sirve�de�soporte�para�un�objeto manejado�dentro�de�la�aplicacion se�codifican�los�comportamientos
 * especificos�asociados�a�cada�control�del�Managed�Bean�representado�por�la�pagina</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class PolizaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{polizaBean}")
	private PolizaBean polizaBean;

	@EJB
	private PolizaService polizaService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private UsuarioService usuarioService;

	private List<SelectItem> formasPagoItems;
	private List<SelectItem> tarjetasCreditoItems;
	private List<SelectItem> ramosItems;
	private List<SelectItem> usuariosItems;
	private List<SelectItem> derechosEmisionItems;

	private Boolean activarPanelPagoContado = false;
	private Boolean activarPanelPagoFinanciado = false;
	private Boolean activarPanelPagoTarjetaCredito = false;
	private Boolean activarPanelPagoDebitoBancario = false;

	/**
	 * 
	 * <b> Permite obtener una lista de formas de Pago. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Feb 2, 2014]
	 * </p>
	 * 
	 * @return - Lista de las Formas de Pago
	 * @throws HiperionException
	 */
	public List<SelectItem> getFormasPagoItems() throws HiperionException {
		this.formasPagoItems = new ArrayList<SelectItem>();
		// Busqueda por el Codigo de Formas de Pago (5)
		Catalogo catalogo = catalogoService.consultarCatalogoById(5);
		List<DetalleCatalogo> formasPago = catalogo.getDetalleCatalogos();
		for (DetalleCatalogo detalle : formasPago) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescripcion());
			formasPagoItems.add(selectItem);
		}

		return formasPagoItems;
	}

	/**
	 * 
	 * <b> Permite obtener una lista de las Tarjetas de Credito. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Feb 2, 2014]
	 * </p>
	 * 
	 * @return - Lista de nombres de Tarjetas de Credito
	 * @throws HiperionException
	 */
	public List<SelectItem> getTarjetasCreditoItems() throws HiperionException {
		this.tarjetasCreditoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(7);
		List<DetalleCatalogo> formasPago = catalogo.getDetalleCatalogos();
		for (DetalleCatalogo detalle : formasPago) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescripcion());
			tarjetasCreditoItems.add(selectItem);
		}

		return tarjetasCreditoItems;
	}

	/**
	 * 
	 * <b> Lista de Ramos del Broker. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 25, 2014]
	 * </p>
	 * 
	 * @return - Lista de Ramos
	 * @throws HiperionException
	 */
	public List<SelectItem> getRamosItems() throws HiperionException {
		this.ramosItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(4);
		List<DetalleCatalogo> ramos = catalogo.getDetalleCatalogos();
		for (DetalleCatalogo detalle : ramos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescripcion());
			ramosItems.add(selectItem);
		}

		return ramosItems;
	}

	/**
	 * 
	 * <b> Lista de Usuarios del Broker. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 25, 2014]
	 * </p>
	 * 
	 * @return - Lista de Usuarios
	 * @throws HiperionException
	 */
	public List<SelectItem> getUsuariosItems() throws HiperionException {
		this.usuariosItems = new ArrayList<SelectItem>();
		// List<Usuario> usuarios = usuarioService.consultarUsuarios();
		// for (Usuario usuario : usuarios) {
		// SelectItem selectItem = new SelectItem(usuario.getNombreUsuario(), usuario.getPersona().getNombre() + " "
		// + usuario.getPersona().getApellidoPaterno());
		// usuariosItems.add(selectItem);
		// }

		return usuariosItems;
	}

	/**
	 * 
	 * <b> Lista de Derechos de Emisi&oacute;n. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Feb 1, 2014]
	 * </p>
	 * 
	 * @return - Lista de Derechos de Emisi&oacute;n
	 * @throws HiperionException
	 */
	public List<SelectItem> getDerechosEmisionItems() throws HiperionException {
		this.derechosEmisionItems = new ArrayList<SelectItem>();
		// Busqueda por el Codigo de Derechos de Emision (4)
		Catalogo catalogo = catalogoService.consultarCatalogoById(4);
		List<DetalleCatalogo> derechosEmision = catalogo.getDetalleCatalogos();
		for (DetalleCatalogo detalle : derechosEmision) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescripcion());
			derechosEmisionItems.add(selectItem);
		}

		return derechosEmisionItems;
	}

	/**
	 * 
	 * <b> Permite activar los paneles segun la forma de pago que selecciono el usuario. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Feb 3, 2014]
	 * </p>
	 * 
	 */
	public void selectFormaDePago() {
		if (polizaBean.getIdFormaPago() == 1) {
			setActivarPanelPagoContado(true);
		} else if (polizaBean.getIdFormaPago() == 2) {
			setActivarPanelPagoFinanciado(true);
		} else if (polizaBean.getIdFormaPago() == 3) {
			setActivarPanelPagoTarjetaCredito(true);
		} else if (polizaBean.getIdFormaPago() == 4) {
			setActivarPanelPagoDebitoBancario(true);
		}
	}

	public PolizaBean getPolizaBean() {
		return polizaBean;
	}

	public void setPolizaBean(PolizaBean polizaBean) {
		this.polizaBean = polizaBean;
	}

	/**
	 * @return the activarPanelPagoContado
	 */
	public Boolean getActivarPanelPagoContado() {
		return activarPanelPagoContado;
	}

	/**
	 * @param activarPanelPagoContado
	 *            the activarPanelPagoContado to set
	 */
	public void setActivarPanelPagoContado(Boolean activarPanelPagoContado) {
		this.activarPanelPagoContado = activarPanelPagoContado;
	}

	/**
	 * @return the activarPanelPagoFinanciado
	 */
	public Boolean getActivarPanelPagoFinanciado() {
		return activarPanelPagoFinanciado;
	}

	/**
	 * @param activarPanelPagoFinanciado
	 *            the activarPanelPagoFinanciado to set
	 */
	public void setActivarPanelPagoFinanciado(Boolean activarPanelPagoFinanciado) {
		this.activarPanelPagoFinanciado = activarPanelPagoFinanciado;
	}

	/**
	 * @return the activarPanelPagoTarjetaCredito
	 */
	public Boolean getActivarPanelPagoTarjetaCredito() {
		return activarPanelPagoTarjetaCredito;
	}

	/**
	 * @param activarPanelPagoTarjetaCredito
	 *            the activarPanelPagoTarjetaCredito to set
	 */
	public void setActivarPanelPagoTarjetaCredito(Boolean activarPanelPagoTarjetaCredito) {
		this.activarPanelPagoTarjetaCredito = activarPanelPagoTarjetaCredito;
	}

	/**
	 * @return the activarPanelPagoDebitoBancario
	 */
	public Boolean getActivarPanelPagoDebitoBancario() {
		return activarPanelPagoDebitoBancario;
	}

	/**
	 * @param activarPanelPagoDebitoBancario
	 *            the activarPanelPagoDebitoBancario to set
	 */
	public void setActivarPanelPagoDebitoBancario(Boolean activarPanelPagoDebitoBancario) {
		this.activarPanelPagoDebitoBancario = activarPanelPagoDebitoBancario;
	}
}