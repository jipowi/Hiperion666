package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.MenuDao;
import ec.com.avila.hiperion.dao.RolDao;
import ec.com.avila.hiperion.dao.RolMenuDao;
import ec.com.avila.hiperion.dao.UsuarioDao;
import ec.com.avila.hiperion.emision.entities.Menu;
import ec.com.avila.hiperion.emision.entities.Rol;
import ec.com.avila.hiperion.emision.entities.RolMenu;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.UsuarioService;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

	// @EJB(lookup =
	// "java:global/hiperion_core-1.0/UsuarioDaoImpl!ec.com.avila.hiperion.dao.UsuarioDao")
	@EJB
	private UsuarioDao usuarioDao;

	@EJB
	private RolDao rolDao;

	@EJB
	private MenuDao menuDao;
	
	@EJB
	private RolMenuDao rolMenuDao;
	

	public void guardarUsuario(Usuario usuario, Rol rol, List<Menu> menus) throws HiperionException {
		
		usuarioDao.persist(usuario);
		rol.setUsuario(usuario);
		rol.setEstadoRol(EstadoEnum.A);
		rol.setDescripcionRol(rol.getDescripcionRol());
		rolDao.persist(rol);
		
		for(Menu menu: menus){
			RolMenu rolMenu = new RolMenu();
			menu.getEstadoMenu();
			rolMenu.setMenu(menu);
			rolMenu.setRol(rol);
			rolMenuDao.persist(rolMenu);
		}
		
	}

	public List<Usuario> consultarUsuarios() throws HiperionException {
		return usuarioDao.findAll();
	}

	public Usuario loginUser(String nombreUsuario, String clave) throws HiperionException {
		return usuarioDao.loginUser(nombreUsuario, clave);
	}

	public void modificarUsuario(Usuario usuario) throws HiperionException {
		usuarioDao.modificarUsuario(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarRolByUsuario(ec.com.avila.hiperion.emision.entities.Usuario)
	 */
	@Override
	public List<Rol> consultarRolByUsuario(Usuario usuario) throws HiperionException {
		return rolDao.consultarRolByUsuario(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarMenuByRol(ec.com.avila.hiperion.emision.entities.Rol)
	 */
	@Override
	public List<RolMenu> consultarRolMenus(Rol rol) throws HiperionException {
		return menuDao.consultarMenuByRol(rol);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarMenu(java.lang.Integer)
	 */
	@Override
	public Menu consultarMenu(Integer idMenu) throws HiperionException {
		return menuDao.findById(new Long(idMenu));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarRoles()
	 */
	@Override
	public List<Rol> consultarRoles() throws HiperionException {
		return rolDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultaMenus()
	 */
	@Override
	public List<Menu> consultaMenus() throws HiperionException {
		return menuDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarRolById()
	 */
	@Override
	public Rol consultarRolById(Long idRol) throws HiperionException {
		return rolDao.findById(idRol);
	}
}
