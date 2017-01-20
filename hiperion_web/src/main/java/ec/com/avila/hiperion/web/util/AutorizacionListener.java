package ec.com.avila.hiperion.web.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AutorizacionListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	public void afterPhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		String currentPage = facesContext.getViewRoot().getViewId();
		boolean isLoginPage = (currentPage.lastIndexOf("index.html") > -1) ? true : false;
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		Object usuario = session.getAttribute("usuario");

		if (!isLoginPage && usuario == null) {
			NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
			navigationHandler.handleNavigation(facesContext, null, "/index.html");
		}
	}

	public void beforePhase(PhaseEvent arg0) {
	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
