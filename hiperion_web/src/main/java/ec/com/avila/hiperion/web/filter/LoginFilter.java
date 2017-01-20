package ec.com.avila.hiperion.web.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.FactoryFinder;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.com.avila.hiperion.emision.entities.Menu;
import ec.com.avila.hiperion.web.backings.UsuarioBacking;
import ec.com.avila.hiperion.web.beans.UsuarioBean;

/**
 * Filtro que valida las p&aacute;ginas a las que tiene acceso un usuario, haciendo login por token si es necesario.
 * 
 * @author cbarahona
 * 
 */
public class LoginFilter implements Filter {
	private static final String PAGINA_MENSAJE_AUTORIZACION = "/pages/notAutorizedPage.jsf";
	private static final String PAGINA_MENSAJE_LOGIN = "/pages/login.jsf";
	private static final String PAGINA_MENSAJE_ERROR = "/pages/error.jsf";
	private static final String PAGINA_MAIN = "/pages/hiperion.jsf";
	private static final String RES_NOT_FOUND = "RES_NOT_FOUND";
	private Set<String> paginasNoFiltradas;
	private final String SESSION_DATAMANAGER_ID = "sessionBacking";
	private final String LOGIN_CONTROLLER_ID = "usuarioBacking";
	private final String LOGIN_DTAMANAGER_ID = "usuarioBean";

	/**
	 * Inicializa el filtro
	 * 
	 * @param filterConfig
	 */

	public void init(FilterConfig filterConfig) {
		paginasNoFiltradas = new HashSet<String>();
		String paramName;
		Enumeration<String> paramNames = filterConfig.getInitParameterNames();
		while (paramNames.hasMoreElements()) {
			paramName = paramNames.nextElement();
			paginasNoFiltradas.add(filterConfig.getInitParameter(paramName));
		}

	}

	/**
	 * Finaliza el filtro
	 */
	public void destroy() {
	}

	/**
	 * M&eacute;todo que se ejecuta al llamar una nueva URL en la aplicaci&oacute;n.
	 * 
	 * @param request
	 *            Petici&oacute;n
	 * @param response
	 *            Respuesta.
	 * @param chain
	 *            Cambio de URL
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		boolean permiso = false;
		String pagina = PAGINA_MENSAJE_AUTORIZACION;
		String url = request.getRequestURL().toString();
		String urlContexto = request.getContextPath();
		FacesContext facesContext = getFacesContext(req, resp);
		if (url.indexOf("?") > 0) {
			url = url.substring(0, url.indexOf("?"));
		}
		if (url.indexOf(PAGINA_MENSAJE_LOGIN) != -1) {
			chain.doFilter(req, resp);
		} else if (url.endsWith(RES_NOT_FOUND)) {
			return;
		}
		// Se verifica si la pagina solicitada este entre las permitidas por defecto en la aplicacion
		else if (isFilterRequired(request) && isValid(url)) {
			try {
				UsuarioBacking SessionBacking = null;
				try {
					SessionBacking = (UsuarioBacking) getManagedBean("usuarioBacking", facesContext);
				} catch (Exception e) {
					chain.doFilter(req, resp);
					return;
				}
				List<Menu> menus = SessionBacking.getMenuList();
				// Verifica si hay un usuario conectado
				if (SessionBacking.getUsuarioBean() == null) {
					getManagedBean(LOGIN_CONTROLLER_ID, facesContext);
				}
				//Se recorren todos los items uno por unour
				if(menus!=null && !menus.isEmpty() ){
					if(url.indexOf(PAGINA_MAIN)!=-1){
						permiso=true;
					}
					else{
						for(Menu viewAccIteDTO:menus){
							String urldef= viewAccIteDTO.getUrl();
							if(urldef != null && urldef.indexOf("?")!=-1){
								urldef= urldef.substring(0,urldef.indexOf("?"));
							}
		
							if(urldef!=null &&  !urldef.trim().equals("") && url.indexOf(urldef)!=-1){
								permiso=true;
							}
							if(permiso){
								break;
							}
						}
					}
	
				}else{
					permiso=false;
				}
				// Si no tiene los permisos niega el acceso a la pagina y envia a pagina de login
				if (!permiso) {
					if (pagina.startsWith("/") && !pagina.startsWith(urlContexto)) {
						pagina = urlContexto + pagina;
					}
					if (SessionBacking.getUsuarioBean() == null) {
						// log.info("Pagina no autorizada:'{" + url+ "}' del contexto '"+urlContexto+ "'");
						pagina = urlContexto + PAGINA_MENSAJE_LOGIN;
					} else {
						// log.info("Pagina no autorizada:'{"+url+"}' del contexto '{"+urlContexto+"}',para el usuario:"+SessionBacking.getUserDto().getUserId());
					}

					response.sendRedirect(pagina);
					return;
				}
				chain.doFilter(req, resp);
			} catch (Exception e) {
				try {
					// log.error("Error ",e);
					// log.info(e);
					e.printStackTrace();
					try {
						UsuarioBean loginController = (UsuarioBean) getManagedBean(LOGIN_DTAMANAGER_ID, facesContext);
						loginController.setException(e);
						pagina = urlContexto + PAGINA_MENSAJE_ERROR;
					} catch (Exception ex1) {
						chain.doFilter(req, resp);
						return;
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					pagina = urlContexto + PAGINA_MENSAJE_LOGIN;
				}
				response.sendRedirect(pagina);
				return;
			}
		} else {
			chain.doFilter(req, resp);
		}

	}

	private boolean isValid(String url) {
		return url.endsWith(".jsf") || url.contains(".jsf?");
	}

	
	public Boolean isFilterRequired(HttpServletRequest request) {
		String url = request.getRequestURL().toString();

		if (url.indexOf("?") > 0) {
			url = url.substring(0, url.indexOf("?"));
		}

		for (String paginaNoFiltrada : paginasNoFiltradas) {
			if (url.endsWith(paginaNoFiltrada)) {
				return Boolean.FALSE;
			}
		}

		return Boolean.TRUE;
	}

	public FacesContext getFacesContext(final ServletRequest request, final ServletResponse response) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (facesContext == null) {
			FacesContextFactory contextFactory = (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
			LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
			Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

			ServletContext servletContext = ((HttpServletRequest) request).getSession().getServletContext();
			facesContext = contextFactory.getFacesContext(servletContext, request, response, lifecycle);
			InnerFacesContext.setFacesContextAsCurrentInstance(facesContext);

			if (null == facesContext.getViewRoot()) {
				try {
					// UIViewRoot view = facesContext.getApplication().getViewHandler().createView(facesContext, "/login/main.jsf");
					facesContext.setViewRoot(new UIViewRoot());
				} catch (Exception e) {
					// log.error("Error al restaurar vista",e);
					e.printStackTrace();
				}
			}
		}
		return facesContext;
	}

	private abstract static class InnerFacesContext extends FacesContext {
		protected static void setFacesContextAsCurrentInstance(final FacesContext facesContext) {
			FacesContext.setCurrentInstance(facesContext);
		}
	}

	protected Object getManagedBean(String beanName, FacesContext facesContext) throws Exception {
		return facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, beanName);
	}

}
