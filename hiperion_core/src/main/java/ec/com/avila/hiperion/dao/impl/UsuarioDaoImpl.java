package ec.com.avila.hiperion.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.avila.hiperion.dao.UsuarioDao;
import ec.com.avila.hiperion.emision.entities.Usuario;

/**
 * 
 * <b> Permite implementar las operaciones de la tabla Usuarios </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Stateless
public class UsuarioDaoImpl extends GenericDAOImpl<Usuario, Long> implements UsuarioDao {

	@PersistenceContext(unitName = "sgs_pu")
	private EntityManager em;

	public UsuarioDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public Usuario loginUser(String nombreUsuario, String clave) {
		Query query = em.createNamedQuery("Usuario.loginUser");
		query.setParameter("usuario", nombreUsuario);
		query.setParameter("clave", clave);
		List<Usuario> usuarios = query.getResultList();
		return usuarios.get(0);
	}

	public void modificarUsuario(Usuario usuario) {
		em.merge(usuario);
	}
}
