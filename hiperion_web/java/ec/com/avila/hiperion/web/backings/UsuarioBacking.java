package ec.com.avila.hiperion.web.backings;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import ec.com.avila.hiperion.servicio.UsuarioService;
import ec.com.avila.hiperion.web.beans.UsuarioBean;

@ManagedBean
@SessionScoped
public class UsuarioBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private UsuarioService usuarioServicioLocal;

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public void login(ActionEvent actionEvent) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage msg = null;
		boolean loggedIn;

		if (usuarioBean.getUsuario() != null && usuarioBean.getUsuario().equals("admin") && usuarioBean.getPassword() != null
				&& usuarioBean.getPassword().equals("admin")) {
			loggedIn = true;
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioBean.getUsuario());
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", usuarioBean.getUsuario());
		} else {
			loggedIn = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
		context.addCallbackParam("loggedIn", loggedIn);
	}
}
