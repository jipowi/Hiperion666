package ec.com.avila.hiperion.web.util;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

public class JsfUtil {

	/**
	 * Permite obtener el contexto de la instancia actual del facesContext.
	 */
	public static FacesContext getCurrentInstanceFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Permite obtener el contexto de la instancia actual del request.
	 */
	public static RequestContext getCurrentInstanceRequestContext() {
		return RequestContext.getCurrentInstance();
	}

	public static void removeManagedBean(String pManagedBean) {
		getCurrentInstanceFacesContext().getExternalContext().getSessionMap().remove(pManagedBean);
	}

	public static void invalidateSession() {
		getCurrentInstanceFacesContext().getExternalContext().invalidateSession();
	}

	

	public static HttpServletRequest getHttpServletRequest() {
		HttpServletRequest httpServletRequest = (HttpServletRequest) getCurrentInstanceFacesContext().getExternalContext().getRequest();

		return httpServletRequest;
	}

	public static String getContextPath() {
		String contextPath = getHttpServletRequest().getContextPath();

		return contextPath;
	}

	public static ServletContext getServletContext() {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

		return servletContext;
	}

	public static String getRealPath() {
		String realPath = getServletContext().getRealPath(ConstantesUtil.SLASH);

		return realPath;
	}

	public static String getRealPath(String pDirectorio) {
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//" + pDirectorio);

		return realPath;
	}

	public static StringBuffer getRequestURL() {
		StringBuffer requestURL = ((HttpServletRequest) getCurrentInstanceFacesContext().getExternalContext().getRequest()).getRequestURL();

		return requestURL;
	}

	public static String getRemoteAddr() {
		return getHttpServletRequest().getRemoteAddr();
	}

	/**
	 * Permite obtener el contexto del path de la imagen para generar el codigo de barras.
	 * 
	 * @throws IOException
	 */
	public static String getContextPathImagen() {
		String[] contextPath = getRequestURL().toString().split(getContextPath());
		String contextPathImagen = contextPath[0].toString() + getContextPath();

		return contextPathImagen;
	}

	/**
	 * Permite llamar al metodo CallBackParam.
	 */
	public static void addCallbackParam(Boolean pParametro) {
		getCurrentInstanceRequestContext().addCallbackParam(ConstantesUtil.PARAM_ACEPTABLE, Boolean.valueOf(pParametro));
	}

	public static String getParameter(String pParametro) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) getCurrentInstanceFacesContext().getExternalContext().getRequest();

		return httpServletRequest.getParameter(pParametro);
	}

	public static void setSessionAttribute(String pNombreParametro, Object pValorParametro) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) getCurrentInstanceFacesContext().getExternalContext().getRequest();
		httpServletRequest.getSession().setAttribute(pNombreParametro, pValorParametro);
	}

	/**
	 * Permite descargar el tipo de comprobante
	 * 
	 * @param pTipoComprobante
	 * @throws IOException
	 */
	public static void downloadFile() throws IOException {
		getCurrentInstanceFacesContext().getExternalContext().redirect(getCurrentInstanceFacesContext().getExternalContext().getRequestContextPath() + ConstantesUtil.DESCARGADOR_SERVLET);
		getCurrentInstanceFacesContext().responseComplete();
	}
}
