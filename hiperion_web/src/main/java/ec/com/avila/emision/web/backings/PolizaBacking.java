/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.PolizaBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.PolizaService;
import ec.com.avila.hiperion.servicio.UsuarioService;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;

/**
 * <b> Clase Backing que permite gestionar la informacion que se maneje en las paginas web</b>
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
	@EJB
	private ClienteService clienteService;

	private List<SelectItem> ramosItems;
	private List<SelectItem> cuotaIniacialItems;
	private List<SelectItem> pagoTarjetaItems;
	private List<SelectItem> aseguradorasItems;

	private List<SelectItem> tarjetaCreditoItems;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	Logger log = Logger.getLogger(PolizaBacking.class);

	/**
	 * 
	 * <b> Permite visualizar el nombre del ejecutivo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 12/01/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	@PostConstruct
	public void inicializar() throws HiperionException {
		Usuario usuario = usuarioBean.getSessionUser();
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
		Catalogo catalogo = catalogoService.consultarCatalogoById(new Long(4));
		List<DetalleCatalogo> ramos = catalogo.getDetalleCatalogos();
		for (DetalleCatalogo detalle : ramos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			ramosItems.add(selectItem);
		}

		return ramosItems;
	}

	public PolizaBean getPolizaBean() {
		return polizaBean;
	}

	public void setPolizaBean(PolizaBean polizaBean) {
		this.polizaBean = polizaBean;
	}

	/**
	 * @return the usuarioBean
	 */
	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	/**
	 * @param usuarioBean
	 *            the usuarioBean to set
	 */
	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	/**
	 * 
	 * <b> Crea el metodo combo cuota inicial </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 14/01/2015]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getCuotaIniacialItems() throws HiperionException {
		this.cuotaIniacialItems = new ArrayList<SelectItem>();

		SelectItem selectItem20 = new SelectItem(1, "20%");
		cuotaIniacialItems.add(selectItem20);
		SelectItem selectItem30 = new SelectItem(2, "30%");
		cuotaIniacialItems.add(selectItem30);
		return cuotaIniacialItems;
	}

	/**
	 * @param cuotaIniacialItems
	 *            the cuotaIniacialItems to set
	 */
	public void setCuotaIniacialItems(List<SelectItem> cuotaIniacialItems) {
		this.cuotaIniacialItems = cuotaIniacialItems;
	}

	/**
	 * @return the pagoTarjetaItems
	 */
	public List<SelectItem> getPagoTarjetaItems() throws HiperionException {
		this.pagoTarjetaItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoPagoTarjeta"));
		List<DetalleCatalogo> pagoTarjeta = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : pagoTarjeta) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			pagoTarjetaItems.add(selectItem);
		}

		return pagoTarjetaItems;
	}

	/**
	 * 
	 * <b> metodo que epermite crear el combo pago tarjeta </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 14/01/2015]
	 * </p>
	 * 
	 * @param pagoTarjetaItems
	 * @throws HiperionException
	 */
	public void setPagoTarjetaItems(List<SelectItem> pagoTarjetaItems) throws HiperionException {
		this.pagoTarjetaItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoPagoTarjeta"));
		List<DetalleCatalogo> pagoTarjeta = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : pagoTarjeta) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			pagoTarjetaItems.add(selectItem);
		}

		this.pagoTarjetaItems = pagoTarjetaItems;
	}

	/**
	 * 
	 * <b> Metodo que me permite generar el combo de tarjetas de credito. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 03/02/2015]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getTarjetaCreditoItems() throws HiperionException {
		this.tarjetaCreditoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoTipoTarjetaCredito"));

		List<DetalleCatalogo> tarjetaCredito = catalogo.getDetalleCatalogos();
		for (DetalleCatalogo detalle : tarjetaCredito) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tarjetaCreditoItems.add(selectItem);
		}
		return tarjetaCreditoItems;
	}

	/**
	 * @param tarjetaCreditoItems
	 *            the tarjetaCreditoItems to set
	 */
	public void setTarjetaCreditoItems(List<SelectItem> tarjetaCreditoItems) {
		this.tarjetaCreditoItems = tarjetaCreditoItems;
	}

	/**
	 * @return the aseguradorasItems
	 */
	public List<SelectItem> getAseguradorasItems() {
		return aseguradorasItems;
	}

	/**
	 * @param aseguradorasItems
	 *            the aseguradorasItems to set
	 */
	public void setAseguradorasItems(List<SelectItem> aseguradorasItems) {
		this.aseguradorasItems = aseguradorasItems;
	}

}