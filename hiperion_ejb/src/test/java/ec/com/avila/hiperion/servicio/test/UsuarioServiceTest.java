package ec.com.avila.hiperion.servicio.test;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.servicio.UsuarioService;
import ec.com.avila.hiperion.servicio.test.utilitario.ClientUtility;

public class UsuarioServiceTest {

	private Context context;

	@Before
	public void iniciarContexto() throws NamingException {
		context = ClientUtility.getInitialContext();
	}

	// @Test
	public void consultarUsuariosTest() throws NamingException, HiperionException {
		UsuarioService remoto = (UsuarioService) context
				.lookup("ejb:/hiperion_ejb-1.0/UsuarioServicioImpl!ec.com.avila.hiperion.servicio.UsuarioService");
		List<Usuario> usuarios = remoto.consultarUsuarios();
		if (usuarios != null && usuarios.size() != 0) {
			for (Usuario usuario : usuarios)
				System.out.println(usuario);
		} else {
			System.out.println("No existen Usuarios..");
		}
	}

//	@Test
//	public void consultarUsuarioByAliasTest() throws NamingException, HiperionException {
//		UsuarioService remoto = (UsuarioService) context
//				.lookup("ejb:/hiperion_ejb-1.0/UsuarioServicioImpl!ec.com.avila.hiperion.servicio.UsuarioService");
//		Usuario usuario = remoto.consultarUsuarioByAlias("dvinueza");
//		System.out.println(usuario);
//	}
}
