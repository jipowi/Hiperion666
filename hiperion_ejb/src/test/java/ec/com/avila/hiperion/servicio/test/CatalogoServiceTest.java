package ec.com.avila.hiperion.servicio.test;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.test.utilitario.ClientUtility;

public class CatalogoServiceTest {

	private Context context;

	@Before
	public void iniciarContexto() throws NamingException {
		context = ClientUtility.getInitialContext();
	}

	//@Test
	public void consultarCatalogoById() throws NamingException, HiperionException {
		CatalogoService remoto = (CatalogoService) context
				.lookup("ejb:/hiperion_ejb-1.0/CatalogoServiceImpl!ec.com.avila.hiperion.servicio.CatalogoService");
		Catalogo catalogo = remoto.consultarCatalogoById(new Long(1));
		if (catalogo != null) {
			System.out.println(catalogo.getDescripcionCatalogo());
			List<DetalleCatalogo> detalles = catalogo.getDetalleCatalogos();
			for (DetalleCatalogo detalleCatalogo : detalles)
				System.out.println(detalleCatalogo);
		}
	}
}
