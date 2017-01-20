/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.CorrespondenciaBean;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.html.UtilsHtml;
import ec.com.avila.hiperion.mail.MailUtil;
import ec.com.avila.hiperion.web.resources.Utils;
import ec.com.avila.hiperion.web.util.FechasUtil;

/**
 * 
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Oct 4, 2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class CorrespondenciaBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{correspondenciaBean}")
	private CorrespondenciaBean correspondenciaBean;
	
	private Boolean destinatarioAseguradora;
	
	Logger log = Logger.getLogger(CorrespondenciaBacking.class);

	/**
	 * 
	 * <b> permtie saber que tipo de destinario selecciono el usuario </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 4, 2014]
	 * </p>
	 *
	 */
	public void seleccionarDestinatario() {
		if (correspondenciaBean.getDestinatario() == 1) {
			destinatarioAseguradora = true;
		} else {
			destinatarioAseguradora = false;
		}
	}

	public void enviarMailII() {
		Cliente persona = new Cliente();
		persona.setNombrePersona("FRANKLIN POZO");

		String fechaActual = FechasUtil.getInstancia().dateForStringFull(new Date());
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String url = Utils.getInstancia().obtenerPathCompleto(req);

		String mensaje = UtilsHtml.getInstancia().obtenerContenidoHTML("formatoInformacionCliente.html").replace("#{FechaActual}", fechaActual)
				.replace("#{NombreCliente}", persona.getNombrePersona()).replace("#{direccion.app}", url);

		log.info(mensaje);

		String correo1 = "paulitochevere999@gmail.com";
		String correo2 = "paul_jimenez777@hotmail.com";
		String correo3 = "pjimenez@kruger.com.ec";
		String de = "paulitochevere999@gmail.com";
		String subject = "Esto es una prueba";

		try {
			MailUtil.getInstancia().envioMailBasico(new String[] { correo1, correo2, correo3 }, de, subject, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enviarMail() {
		try {
			// Propiedades de la conexión
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.user", "paulitochevere999@gmail.com");
			props.setProperty("mail.smtp.auth", "true");

			// Preparamos la sesion
			Session session = Session.getDefaultInstance(props);

			// Construimos el mensaje
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("paul_jimenez@hotmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("paulitochevere999@gmail.com"));
			message.setSubject("Hola");
			message.setText("Mensajito con Java Mail" + "de los buenos." + "poque si");

			// Lo enviamos.
			Transport t = session.getTransport("smtp");
			t.connect("paulitochevere999@gmail.com", "qvvkemkiidmhnerw");
			t.sendMessage(message, message.getAllRecipients());

			// Cierre.
			t.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the correspondenciaBean
	 */
	public CorrespondenciaBean getCorrespondenciaBean() {
		return correspondenciaBean;
	}

	/**
	 * @param correspondenciaBean
	 *            the correspondenciaBean to set
	 */
	public void setCorrespondenciaBean(CorrespondenciaBean correspondenciaBean) {
		this.correspondenciaBean = correspondenciaBean;
	}

	/**
	 * @return the destinatarioAseguradora
	 */
	public Boolean getDestinatarioAseguradora() {
		return destinatarioAseguradora;
	}

	/**
	 * @param destinatarioAseguradora
	 *            the destinatarioAseguradora to set
	 */
	public void setDestinatarioAseguradora(Boolean destinatarioAseguradora) {
		this.destinatarioAseguradora = destinatarioAseguradora;
	}

}
