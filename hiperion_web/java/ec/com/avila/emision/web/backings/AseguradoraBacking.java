/**
 * 
 */
package ec.com.avila.emision.web.backings;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.com.avila.emision.web.beans.AseguradoraBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Aseguradora;
import ec.com.avila.hiperion.servicio.AseguradoraService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author kruger
 * @version 1.0,Dec 21, 2013
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class AseguradoraBacking {

	@ManagedProperty(value = "#{aseguradoraBean}")
	private AseguradoraBean aseguradoraBean;

	@EJB
	private AseguradoraService aseguradoraService;

	public void guardarAseguradora() throws HiperionException {
		aseguradoraService.guardarAseguradora(setearAseguradora());
	}

	public Aseguradora setearAseguradora() {
		Aseguradora aseguradora = new Aseguradora();
		aseguradora.setCodigoAseguradora(aseguradoraBean.getCodigoAseguradora());
		// aseguradora.setNombre(aseguradoraBean.getNombre());
		aseguradora.setRuc(aseguradora.getRuc());
		aseguradora.setDirecion(aseguradoraBean.getDirecion());
		aseguradora.setTelefono(aseguradoraBean.getTelefono());

		return aseguradora;
	}

}
