/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * 
 * <b> Permite interactuar con la pantalla de correspondecia </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Oct 4, 2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class CorrespondenciaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer destinatario;
	private String subject;
	private String text;

	/**
	 * @return the destinatario
	 */
	public Integer getDestinatario() {
		return destinatario;
	}

	/**
	 * @param destinatario
	 *            the destinatario to set
	 */
	public void setDestinatario(Integer destinatario) {
		this.destinatario = destinatario;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
