package ec.com.avila.hiperion.mail;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;

/**
 * Encapsula mensaje de correo electr&oacute;nico
 * @author gyandun
 */
public class MailMensaje implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 9130823274020966071L;
	private String[] para;
    private String de;
    //Contrasenia de la cuenta de envio de correo
    private String password;
    private String ccS;
    private String[] cc;
    private String ccoS;
	private String[] cco;
    private String asunto;
	private String mensaje;
	private String[] archivosAdjuntos;
	private ArchivoAdjunto[] archivosAdjuntosEST;
	private String host;
	private String puerto;
	private boolean formatoHTML=Boolean.TRUE;
	private Collection<ArchivoAdjunto> archivosAdjuntosCol;
	private String archvivosAduntosTag;
	
	// para adjuntar imagenes al mensaje
	private File imagenMensaje;
	File[] imagenesIntegradas;
	
    public boolean isFormatoHTML() {
		return formatoHTML;
	}
	public void setFormatoHTML(boolean formatoHTML) {
		this.formatoHTML = formatoHTML;
	}
	
	/**
     * @return Devuelve archivosAdjuntos.
     */
    public String[] getArchivosAdjuntos() {
        return archivosAdjuntos;
    }
    /**
     * @param archivosAdjuntos El archivosAdjuntos a establecer.
     */
    public void setArchivosAdjuntos(String[] archivosAdjuntos) {
        this.archivosAdjuntos = archivosAdjuntos;
    }   
    
    /**
	 * @return el archivosAdjuntosEST
	 */
	public ArchivoAdjunto[] getArchivosAdjuntosEST() {
		return archivosAdjuntosEST;
	}
	/**
	 * @param archivosAdjuntosEST el archivosAdjuntosEST a establecer
	 */
	public void setArchivosAdjuntosEST(ArchivoAdjunto[] archivosAdjuntosEST) {
		this.archivosAdjuntosEST = archivosAdjuntosEST;
	}
	
	/**
	 * @param archivosAdjuntosEST el archivosAdjuntosEST a establecer
	 */
	public void setArchivosAdjuntosEST(Collection<ArchivoAdjunto> archivosAdjuntosEST) {
		this.archivosAdjuntosEST = new ArchivoAdjunto[archivosAdjuntosEST.size()];
		this.archivosAdjuntosEST = archivosAdjuntosEST.toArray(this.archivosAdjuntosEST);
	}
	/**
     * @return Devuelve archivosAdjuntosCol.
     */
    public Collection<ArchivoAdjunto> getArchivosAdjuntosCol() {
        return archivosAdjuntosCol;
    }
    /**
     * @param archivosAdjuntosCol El archivosAdjuntosCol a establecer.
     */
    public void setArchivosAdjuntosCol(Collection<ArchivoAdjunto> archivosAdjuntosCol) {
        this.archivosAdjuntosCol = archivosAdjuntosCol;
    }
    /**
     * @return Devuelve asunto.
     */
    public String getAsunto() {
        return asunto;
    }
    /**
     * @param asunto El asunto a establecer.
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    /**
     * @return Devuelve cc.
     */
    public String[] getCc() {        
        return cc;
    }
    /**
     * @param cc El cc a establecer.
     */
    public void setCc(String[] cc) {
        this.cc = cc;
    }
	/**
     * @return Devuelve cco.
     */
    public String[] getCco() {
        return cco;
    }
    /**
     * @param cco El cco a establecer.
     */
    public void setCco(String[] cco) {
        this.cco = cco;
    }
	/**
     * @return Devuelve de.
     */
    public String getDe() {
        return de;
    }
    /**
     * @param de El de a establecer.
     */
    public void setDe(String de) {
        this.de = de;
    }
    /**
     * @return Devuelve host.
     */
    public String getHost() {
        return host;
    }
    /**
     * @param host El host a establecer.
     */
    public void setHost(String host) {
        this.host = host;
    }
    /**
     * @return Devuelve mensaje.
     */
    public String getMensaje() {
        return mensaje;
    }
    /**
     * @param mensaje El mensaje a establecer.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    /**
     * @return Devuelve para.
     */
    public String[] getPara() {
        return para;
    }
    /**
     * @param para El para a establecer.
     */
    public void setPara(String[] para) {
        this.para = para;
    }    
	/**
     * @return Devuelve puerto.
     */
    public String getPuerto() {
        return puerto;
    }
    /**
     * @param puerto El puerto a establecer.
     */
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }
    /**
     * @return Devuelve ccoS.
     */
    public String getCcoS() {
        return ccoS;
    }
    /**
     * @param ccoS El ccoS a establecer.
     */
    public void setCcoS(String ccoS) {
        this.ccoS = ccoS;
    }
    /**
     * @return Devuelve ccS.
     */
    public String getCcS() {
        return ccS;
    }
    /**
     * @param ccS El ccS a establecer.
     */
    public void setCcS(String ccS) {
        this.ccS = ccS;
    }
	/**
	 * @return el archvivosAduntosTag
	 */
	public String getArchvivosAduntosTag() {
		return this.archvivosAduntosTag;
	}
	/**
	 * @param archvivosAduntosTag el archvivosAduntosTag a establecer
	 */
	public void setArchvivosAduntosTag(String archvivosAduntosTag) {
		this.archvivosAduntosTag = archvivosAduntosTag;
	}
	
	/**
	 * Obtiene la imagen del mensaje
	 * 
	 * @return el imagenMensaje
	 */
	public File getImagenMensaje() {
		return imagenMensaje;
	}
	/**
	 * Establece la imagen del mensaje
	 * 
	 * @param imagenMensaje el imagenMensaje a establecer
	 */
	public void setImagenMensaje(File imagenMensaje) {
		this.imagenMensaje = imagenMensaje;
	}
	
	/**
	 * @return el imagenesIntegradas
	 */
	public File[] getImagenesIntegradas() {
		return imagenesIntegradas;
	}
	/**
	 * @param imagenesIntegradas el imagenesIntegradas a establecer
	 */
	public void setImagenesIntegradas(File[] imagenesIntegradas) {
		this.imagenesIntegradas = imagenesIntegradas;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
