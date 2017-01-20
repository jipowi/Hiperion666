package ec.com.avila.hiperion.mail;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <b> Clase que permite configurar un mensaje de correo electr&oacute;nico: Cabecera -> Cuerpo -> Archivos Adjuntos -> Envio EMail </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Oct 9, 2014
 * @since JDK1.6
 */
public class MailManager {

	private Log log = LogFactory.getLog(MailManager.class);

	private String nombreClase = MailManager.class.getName();
	/**
	 * <p>
	 * from: String. Direcci&oacute;n fuente
	 * </p>
	 * <p>
	 * cc: String. Direcci&oacute;n de copia e-mail
	 * </p>
	 * <p>
	 * bcc: String. Direcci&oacute;n de segunda copia e-mail
	 * </p>
	 * <p>
	 * subject: String. Motivo de e-mail
	 * </p>
	 * <p>
	 * message: String. Mensaje de e-mail
	 * </p>
	 * <p>
	 * filePathA: String[]. Path(s) archivo(s) adjunto(s)
	 * </p>
	 * <p>
	 * SMTPHost: String. Direcci&oacute;n IP de la m&aacute;quina con servicio SMTP
	 * </p>
	 * <p>
	 * to: javax.mail.internet.InternetAddress. Direcci&oacute;n(es) destino(s)
	 * </p>
	 * <p>
	 * props: java.util.Properties. Propiedad(es) envio e-mail
	 * </p>
	 * <p>
	 * sess: javax.mail.Session
	 * </p>
	 * <p>
	 * messageM: javax.mail.Message. Objeto donde se arma e-mail
	 * </p>
	 * <p>
	 * multPartMail: javax.mail.Multipart. Objeto que permite separar en partes e-mail
	 * </p>
	 * <p>
	 * bodyPartMail: javax.mail.BodyPart. Objeto con la parte del cuerpo del e-mail
	 * </p>
	 * <p>
	 * enviarComoHTML: boolean. Si es true, el texto ser&aacute; enviado como HTML
	 */

	// prueba inputStream
	private String from = null;
	// Password de la cuenta de correo
	private String password = null;
	private InternetAddress[] cc = null;
	private InternetAddress[] bcc = null;
	private String subject = null;
	private String message = null;
	private String[] filePathA = null;
	private String SMTPHost = null;
	private InternetAddress[] to = null;
	private Properties props = null;
	private Session sess = null;
	private Message messageM = null;
	private Multipart multPartMail = null;
	private BodyPart bodyPartMail = null;
	private String smtpPort = "25";
	private boolean enviarComoHTML = false; // determina si enviar o no como HTML

	/**
	 * Constructor
	 * 
	 * @param to
	 *            - Direcciones de correo a donde quiero enviar correo
	 * @param from
	 *            - Direcci&oacute;n de correo desde la que voy a enviar correo
	 * @param cc
	 *            - Direcci&oacute;n de correo a la que envio una primera copia del correo
	 * @param bcc
	 *            - Direcci&oacute;n de correo a la que envio una segunda copia del correo
	 * @param subject
	 *            - Motivo del correo
	 * @param message
	 *            - Mensaje del correo (formateado)
	 * @param enviarComoHTML
	 *            - Si es true, el mensaje ser&oacute; interpretado como HTML, y por lo mismo, requerir&oacute; incluir etiquetas
	 * @param filePathA
	 *            - Paths de archivos adjuntos
	 * @param SMTPHost
	 *            - Direcci&oacute;n de servidor SMTP
	 * @param SMTPPort
	 *            - Puerto de comunicaci&oacute;n
	 * @throws AddressException
	 */
	public MailManager(String to, String from, String cc, String bcc, String subject, String message, boolean enviarComoHTML, String[] filePathA,
			String SMTPHost, String SMTPPort) throws AddressException {
		try {
			this.enviarComoHTML = enviarComoHTML;
			this.from = from;

			if (cc != null) {
				this.cc = new InternetAddress[] { new InternetAddress(cc) };
			}

			if (bcc != null) {
				this.bcc = new InternetAddress[] { new InternetAddress(bcc) };
			}

			this.message = message;
			this.subject = subject;
			this.filePathA = filePathA;
			this.SMTPHost = SMTPHost;
			this.smtpPort = SMTPPort;
			this.to = new InternetAddress[] { new InternetAddress(to) };
			this.multPartMail = new MimeMultipart();
		} catch (AddressException e) {
			throw new AddressException("Una o mas direcciones de correo no son validas");
		}
	}

	/**
	 * Constructor
	 * 
	 * @param to
	 *            - Direcciones de correo a donde quiero enviar correo
	 * @param from
	 *            - Direcci&oacute;n de correo desde la que voy a enviar correo
	 * @param cc
	 *            - Direcci&oacute;n de correo a la que envio una primera copia del correo
	 * @param bcc
	 *            - Direcci&oacute;n de correo a la que envio una segunda copia del correo
	 * @param subject
	 *            - Motivo del correo
	 * @param message
	 *            - Mensaje del correo (formateado)
	 * @param enviarComoHTML
	 *            - Si es true, el mensaje ser&iacute; interpretado como HTML, y por lo mismo, requerir&aacute; incluir etiquetas
	 * @param filePathA
	 *            - Paths de archivos adjuntos
	 * @param SMTPHost
	 *            - Direcci&oacute;n de servidor SMTP
	 * @param SMTPPort
	 *            - Puerto de comunicacion
	 * @throws AddressException
	 */
	public MailManager(String[] to, String from, String[] cc, String[] bcc, String subject, String message, boolean enviarComoHTML,
			String[] filePathA, String SMTPHost, String SMTPPort) throws AddressException {

		try {
			this.enviarComoHTML = enviarComoHTML;

			if (to != null && to.length > 0 && to[0] != null) {
				InternetAddress address[] = new InternetAddress[to.length];
				for (int i = 0; i < address.length; i++)
					address[i] = new InternetAddress(to[i]);

				this.to = address;
			}

			if (cc != null && cc.length > 0 && cc[0] != null) {
				InternetAddress addressCC[] = new InternetAddress[cc.length];
				for (int i = 0; i < addressCC.length; i++)
					addressCC[i] = new InternetAddress(cc[i]);

				this.cc = addressCC;
			}
			if (bcc != null && bcc.length > 0 && bcc[0] != null) {
				InternetAddress addressBCC[] = new InternetAddress[bcc.length];
				for (int i = 0; i < addressBCC.length; i++)
					addressBCC[i] = new InternetAddress(bcc[i]);
				this.bcc = addressBCC;
			}
		} catch (AddressException e) {
			throw new AddressException("Una o mas direcciones de correo no son validas");
		}
		this.from = from;
		this.message = message;
		this.subject = subject;
		this.filePathA = filePathA;
		this.SMTPHost = SMTPHost;
		this.smtpPort = SMTPPort;
		this.multPartMail = new MimeMultipart();
	}

	/**
	 * Constructor usado para servidores de correo como Gmail en los cuales es necesario autenticarse mediante una cuenta que envia el correo para que
	 * el campo From llegue correctamente.
	 * 
	 * @param to
	 *            - Direcciones de correo a donde quiero enviar correo
	 * @param from
	 *            - Direcci&oacute;n de correo desde la que voy a enviar correo
	 * @param password
	 *            - Contrasenia de la cuenta de correo
	 * @param cc
	 *            - Direcci&oacute;n de correo a la que envio una primera copia del correo
	 * @param bcc
	 *            - Direcci&oacute;n de correo a la que envio una segunda copia del correo
	 * @param subject
	 *            - Motivo del correo
	 * @param message
	 *            - Mensaje del correo (formateado)
	 * @param enviarComoHTML
	 *            - Si es true, el mensaje ser&oacute; interpretado como HTML, y por lo mismo, requerir&oacute; incluir etiquetas
	 * @param filePathA
	 *            - Paths de archivos adjuntos
	 * @param SMTPHost
	 *            - Direcci&oacute;n de servidor SMTP
	 * @param SMTPPort
	 *            - Puerto de comunicaci&oacute;n
	 * @throws AddressException
	 */
	public MailManager(String[] to, String from, String password, String[] cc, String[] bcc, String subject, String message, boolean enviarComoHTML,
			String[] filePathA, String SMTPHost, String SMTPPort) throws AddressException {
		this(to, from, cc, bcc, subject, message, enviarComoHTML, filePathA, SMTPHost, SMTPPort);
		this.password = password;
	}

	/**
	 * Constructor
	 * 
	 * @param to
	 *            - Direcciones de correo a donde quiero enviar correo
	 * @param from
	 *            - Direcci&oacute;n de correo desde la que voy a enviar correo
	 * @param cc
	 *            - Direcci&oacute;n de correo a la que envio una primera copia del correo
	 * @param bcc
	 *            - Direcci&oacute;n de correo a la que envio una segunda copia del correo
	 * @param subject
	 *            - Motivo del correo
	 * @param message
	 *            - Mensaje del correo (formateado)
	 * @param enviarComoHTML
	 *            - Si es true, el mensaje ser&iacute; interpretado como HTML, y por lo mismo, requerir&aacute; incluir etiquetas
	 * @param filePathA
	 *            - Paths de archivos adjuntos
	 * @param SMTPHost
	 *            - Direcci&oacute;n de servidor SMTP
	 * @param SMTPPort
	 *            - Puerto de comunicaci&oacute;n
	 * @throws AddressException
	 */
	public MailManager(String to, String from, String[] cc, String[] bcc, String subject, String message, boolean enviarComoHTML, String[] filePathA,
			String SMTPHost, String SMTPPort) throws AddressException {
		try {
			this.enviarComoHTML = enviarComoHTML;
			if (cc != null && cc.length > 0 && cc[0] != null) {
				InternetAddress addressCC[] = new InternetAddress[cc.length];
				for (int i = 0; i < addressCC.length; i++)
					addressCC[i] = new InternetAddress(cc[i]);

				this.cc = addressCC;
			} else {
				log.info("{}:.No hay cc =( " + nombreClase);
			}
			if (bcc != null && bcc.length > 0 && bcc[0] != null) {
				InternetAddress addressBCC[] = new InternetAddress[bcc.length];
				for (int i = 0; i < addressBCC.length; i++)
					addressBCC[i] = new InternetAddress(bcc[i]);
				this.bcc = addressBCC;
			} else {
				log.info("{}:.No hay bcc =( " + nombreClase);
			}
		} catch (AddressException e) {
			throw new AddressException("Una o mas direcciones de correo no son validas");
		}

		this.to = new InternetAddress[] { new InternetAddress(to) };
		this.from = from;
		this.message = message;
		this.subject = subject;
		this.filePathA = filePathA;
		this.SMTPHost = SMTPHost;
		this.smtpPort = SMTPPort;
		this.multPartMail = new MimeMultipart();
	}

	/**
	 * Constructor
	 * 
	 * @param to
	 *            - Direcciones de correo a donde quiero enviar correo
	 * @param from
	 *            - Direcci&oacute;n de correo desde la que voy a enviar correo
	 * @param cc
	 *            - Direcci&oacute;n de correo a la que envio una primera copia del correo
	 * @param bcc
	 *            - Direcci&oacute;n de correo a la que envio una segunda copia del correo
	 * @param subject
	 *            - Motivo del correo
	 * @param message
	 *            - Mensaje del correo
	 * @param enviarComoHTML
	 *            - Si es true, el mensaje ser&oacute; interpretado como HTML, y por lo mismo, requerir&aacute; incluir etiquetas
	 * @param fiA
	 *            - Paths de archivos adjuntos
	 * @param SMTPHost
	 *            - Direcci&oacute;n de servidor SMTP
	 * @param SMTPPort
	 *            - Puerto de comunicaci&oacute;n
	 * @throws AddressException
	 */
	public MailManager(String to, String from, String cc, String bcc, String subject, String message, boolean enviarComoHTML, String SMTPHost,
			String SMTPPort) throws AddressException {

		try {
			this.enviarComoHTML = enviarComoHTML;
			this.from = from;
			this.cc = new InternetAddress[] { new InternetAddress(cc) };
			this.bcc = new InternetAddress[] { new InternetAddress(bcc) };
			this.message = message;
			this.subject = subject;
			this.SMTPHost = SMTPHost;
			this.smtpPort = SMTPPort;
			this.to = new InternetAddress[] { new InternetAddress(to) };
			this.multPartMail = new MimeMultipart();
		} catch (AddressException e) {
			throw new AddressException("Una o mas direcciones de correo no son validas");
		}

	}

	/**
	 * M&eacute;todo que me prepara la cabecera del correo
	 * 
	 * @throws MessagingException
	 */
	public void mailHead() throws MessagingException {
		try {

			log.info(":.**************************");
			log.info("VALORES DEL EMAIL" + nombreClase);
			log.info(":.**************************");

			log.info("SMTPHost: " + nombreClase + " " + SMTPHost);
			log.info("smtpPort: {}" + smtpPort);
			log.info("{}:.to: {}" + to);
			log.info("{}:.from: {}" + from);
			log.info("{}:.cc: {}" + cc);
			log.info("{}:.bcc: {}" + bcc);

			props = new Properties();
			props.put("mail.smtp.host", SMTPHost);
			props.put("mail.smtp.port", smtpPort);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.timeout", Utils.getInstancia().obtenerPropiedad("mail.timeout"));
			props.put("mail.smtp.user", "paulitochevere999@gmail.com");
			props.put("mail.smtp.auth", "true");
			log.info("Antes de getDefault");
			// Si el servidor de mail necesita de autenticacion mediante una cuenta para el envio
			if (Utils.getInstancia().obtenerPropiedad("mail.serverHost.needAutentication").equals("1")) {
				// props.put("mail.smtp.auth", "true");
				// props.put("mail.smtp.socketFactory.port", smtpPort);
				// props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

				sess = Session.getInstance(props, new javax.mail.Authenticator() {
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication("paulitochevere999@gmail.com", password);
					}
				});
			} else {
				sess = Session.getDefaultInstance(props);
			}

			log.info("Antes de crear la instancia MimeMessage");
			messageM = new MimeMessage(sess);
			log.info("Antes de from");
			messageM.setFrom(new InternetAddress(from));
			log.info("Antes de to");
			messageM.setRecipients(Message.RecipientType.TO, to);
			log.info("Antes de subject");
			messageM.setSubject(subject);
			log.info("Antes de cc");
			messageM.addRecipients(Message.RecipientType.CC, cc);
			log.info("Antes de bcc");
			messageM.addRecipients(Message.RecipientType.BCC, bcc);

		} catch (MessagingException e) {
			throw new MessagingException("No se pudo crear la cabecera del mensaje");
		}
	}

	/**
	 * M&eacute;todo que me pone el Mensaje del correo
	 * 
	 * @throws MessagingException
	 */
	public void mailBody() throws MessagingException {
		try {
			bodyPartMail = new MimeBodyPart();
			// Agregado soporte para HTML
			bodyPartMail.setContent(message, this.enviarComoHTML ? "text/html" : "text/plain");
			multPartMail.addBodyPart(bodyPartMail);
		} catch (MessagingException e) {
			throw new MessagingException("No se pudo crear el cuerpo del mensaje");
		}
	}

	/**
	 * M&eacute;todo que me pone el Mensaje del correo, e inserta imagenes al mensaje
	 * 
	 * @throws MessagingException
	 */
	public void mailBody(File imagenMensaje) throws MessagingException {
		try {
			bodyPartMail = new MimeBodyPart();
			// Agregado soporte para HTML

			if (this.enviarComoHTML) {
				bodyPartMail.setContent(message, "text/html");

				multPartMail = new MimeMultipart("related");
				multPartMail.addBodyPart(bodyPartMail);

				bodyPartMail = new MimeBodyPart();

				// Procesar la imagen
				String nombreImagen = imagenMensaje.getName().substring(0, imagenMensaje.getName().indexOf("."));

				DataSource fds = new FileDataSource(imagenMensaje);
				bodyPartMail.setDataHandler(new DataHandler(fds));
				bodyPartMail.setHeader("Content-ID", "<" + nombreImagen + ">");
				bodyPartMail.setDisposition("inline");

				multPartMail.addBodyPart(bodyPartMail);
				messageM.setContent(multPartMail);
			}

			else
				mailBody();

		} catch (MessagingException e) {
			throw new MessagingException("No se pudo crear el cuerpo del mensaje");
		}
	}

	/**
	 * M&oacute;todo que me pone el Mensaje del correo, e inserta imagenes al mensaje
	 * 
	 * @throws MessagingException
	 */
	public void mailBody(File[] imagenesIntegradas) throws MessagingException {
		try {

			// Agregado soporte para HTML
			bodyPartMail = new MimeBodyPart();
			bodyPartMail.setContent(message, "text/html");
			multPartMail = new MimeMultipart("related");
			multPartMail.addBodyPart(bodyPartMail);

			if (this.enviarComoHTML) {

				for (int i = 0; i < imagenesIntegradas.length; i++) {
					bodyPartMail = new MimeBodyPart();

					String nombreImagen = imagenesIntegradas[i].getName().substring(0, imagenesIntegradas[i].getName().indexOf("."));
					DataSource fds = new FileDataSource(imagenesIntegradas[i]);
					bodyPartMail.setDataHandler(new DataHandler(fds));

					bodyPartMail.setHeader("Content-ID", "<" + nombreImagen + ">");
					bodyPartMail.setDisposition("inline");

					multPartMail.addBodyPart(bodyPartMail);
				}

				// Procesar la imagen
				messageM.setContent(multPartMail);
			}

			else
				mailBody();

		} catch (MessagingException e) {
			throw new MessagingException("No se pudo crear el cuerpo del mensaje");
		}
	}

	/**
	 * M&oacute;todo para adjuntar archivos al correo
	 * 
	 * @throws MessagingException
	 */
	public void mailAttachment() throws MessagingException {
		try {
			if (filePathA != null)
				for (int i = 0; i < filePathA.length; i++) {
					DataSource source = null;
					File archivo = new File(filePathA[i]);
					bodyPartMail = new MimeBodyPart();
					source = new FileDataSource(archivo);
					bodyPartMail.setDataHandler(new DataHandler(source));
					bodyPartMail.setFileName(archivo.getName());
					multPartMail.addBodyPart(bodyPartMail);
				}

		} catch (MessagingException e) {
			throw new MessagingException("No se pudo adjuntar el/los archivo(s) al mensaje");
		}
	}

	/**
	 * M&oacute;todo para enviar el correo configurado
	 * 
	 * @throws MessagingException
	 */
	public void mailSend() throws MessagingException {

		// verificar si se puede conectar al smtp
		Transport transport = sess.getTransport("smtp");

		try {

			Long teAntes = System.currentTimeMillis();
			log.info("tiempo de espera antes: " + teAntes);
			transport.connect();

			Long teDespues = System.currentTimeMillis();

			log.info("tiempo de espera despues: " + teDespues);

			log.info("Enviar");

			messageM.setContent(multPartMail);
			Transport.send(messageM);

			Long teDif = teDespues - teAntes;
			log.info("tiempo de espera diferencia despues de enviar: " + teDif);

			log.info("{}:.Mail enviado satisfactoriamente" + nombreClase);
		} catch (SendFailedException e) {

			if (e.getNextException() != null)
				try {
					throw new MessagingException(((MessagingException) e.getNextException()).getNextException().getMessage());

				} catch (Exception e1) {
					throw (e);
				}
			else
				throw (e);
		} catch (MessagingException e) {
			e.printStackTrace();
			log.info("mailSend, clase: " + e.getClass());
			log.info("No se11: " + ((e.getNextException() != null) ? ": " + e.getNextException().getMessage() : ""));
			if (e.getNextException().getMessage().equals("Read timed out")) {
				throw new MessagingException("No se puedo enviar el mensaje, no se puede conectar al servidor smtp" + SMTPHost);
			}

			else {
				throw new MessagingException("No se puedo enviar el mensaje a las direcciones adjuntas "
						+ ((e.getNextException() != null) ? ": " + e.getNextException().getMessage() : ""));
			}
		} finally {
			transport.close();
		}
	}
}