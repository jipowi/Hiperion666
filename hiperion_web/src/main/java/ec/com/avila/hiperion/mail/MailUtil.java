/**
 * Ministerio de Educacion del Ecuador
 * 
 * Producto: Sistema de Gestion de Docentes
 * Creado:  15/08/2014
 * 
 * Todos los Derechos Reservados 2014
 */
package ec.com.avila.hiperion.mail;

import java.util.Collection;

import javax.mail.MessagingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <b> Utilitario para el envio y recepcion de correo electronico </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Oct 9, 2014
 * @since JDK1.6
 */
public class MailUtil {

	private Log log = LogFactory.getLog(MailManager.class);

	private static MailUtil INSTANCIA = new MailUtil();

	private MailUtil() {

	}

	public static MailUtil getInstancia() {
		return INSTANCIA;
	}

	/**
	 * 
	 * <b> Envia los datos de correo sin copia. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 9, 2014]
	 * </p>
	 *
	 * @param para
	 *            Lista de mails a quien va dirigido el correo
	 * @param de
	 *            Direccion que emite el correo
	 * @param subject
	 *            Asunto de mail
	 * @param message
	 *            Mensaje de mail
	 * @throws Exception
	 *             En caso de error en el proceso
	 */
	public void envioMailBasico(String[] para, String de, String subject, String message) throws Exception {
		envioMail(para, de, null, null, subject, message, null);
	}

	/**
	 * 
	 * <b> Se encarga de generar los datos de correo electronico para su envio. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 9, 2014]
	 * </p>
	 *
	 * @param para
	 *            Lista de mails a quien va dirigido el correo
	 * @param de
	 *            Direcci&oacute;n que emite el correo
	 * @param cc
	 *            Lista de direcciones electr&oacute;nicas para copia
	 * @param bcc
	 *            Lista de direcciones electr&oacute;nicas para copia
	 * @param subject
	 *            Asunto de mail
	 * @param message
	 * @param archivos
	 *            Lista de archivo
	 * @throws MessagingException
	 *             En caso de error
	 */
	public void envioMail(String[] para, String de, String[] cc, String bcc, String subject, String message, Collection<ArchivoAdjunto> archivos)
			throws Exception {
		try {
			// buscar el evento
			MailMensaje mailMensajeEST = new MailMensaje();
			mailMensajeEST.setDe(de);
			mailMensajeEST.setPara(para);
			mailMensajeEST.setPassword(Utils.getInstancia().obtenerPropiedad("mail.adm.pass"));
			mailMensajeEST.setCc(cc);
			mailMensajeEST.setAsunto(subject);
			mailMensajeEST.setMensaje(message);
			mailMensajeEST.setHost(Utils.getInstancia().obtenerPropiedad("mail.host"));
			mailMensajeEST.setPuerto(Utils.getInstancia().obtenerPropiedad("mail.puerto"));
			mailMensajeEST.setFormatoHTML(true);
			if (archivos != null) {
				mailMensajeEST.setArchivosAdjuntosEST(archivos);
			}
			envioAutomaticoMail(mailMensajeEST);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * 
	 * <b> Procesa el envio automatico del mail </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 9, 2014]
	 * </p>
	 *
	 * @param mailMensaje
	 *            Objeto con datos del correo
	 * @throws Exception
	 *             En caso de error en el proceso
	 */
	private void envioAutomaticoMail(MailMensaje mailMensaje) throws Exception {
		try {
			log.info(":.******************************");
			log.info("{}:.Iniciando envioAutomaticoMail");
			log.info(":.******************************");

			// registrar el historial del mensaje enviado
			log.info("{}:.No ha seleccionado registrar mensaje.....");

			MailManager mail = null;
			// Si servidor de mail necesita de autenticacion mediante una cuenta para el envio
			if (Utils.getInstancia().obtenerPropiedad("mail.serverHost.needAutentication").equals("1")) {
				// Aqui se usa autenticacion se envia el password
				mail = new MailManager(mailMensaje.getPara(), mailMensaje.getDe(), mailMensaje.getPassword(), mailMensaje.getCc(),
						mailMensaje.getCco(), mailMensaje.getAsunto(), mailMensaje.getMensaje(), mailMensaje.isFormatoHTML(),
						mailMensaje.getArchivosAdjuntos(), mailMensaje.getHost(), mailMensaje.getPuerto());
			} else {
				// No necesita autenticacion
				mail = new MailManager(mailMensaje.getPara(), mailMensaje.getDe(), mailMensaje.getCc(), mailMensaje.getCco(),
						mailMensaje.getAsunto(), mailMensaje.getMensaje(), mailMensaje.isFormatoHTML(), mailMensaje.getArchivosAdjuntos(),
						mailMensaje.getHost(), mailMensaje.getPuerto());
			}

			mail.mailHead();

			// verifico si el mail incluye logo de la empresa
			if (mailMensaje.getImagenMensaje() != null && !mailMensaje.getImagenMensaje().equals("")) {
				mail.mailBody(mailMensaje.getImagenMensaje());
			}
			// Verifica si existen imagenes integradas al correo
			else if (mailMensaje.getImagenesIntegradas() != null && mailMensaje.getImagenesIntegradas().length > 0) {
				mail.mailBody(mailMensaje.getImagenesIntegradas());
			} else {
				mail.mailBody();
			}
			mail.mailAttachment();

			try {
				mail.mailSend();
			} catch (MessagingException e) {
				log.error(e.getStackTrace());
				throw e;
			}

		} catch (Exception e) {
			log.error(e.getStackTrace());
			throw e;
		}

	}

}
