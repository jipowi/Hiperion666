package ec.com.avila.hiperion.web.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class DetalleCatalogoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos del Catalogo
	private Long codigoCatalogo;
	private String descripcionCatalogo;

	// Atributos del Detalle de un Catalogo
	private String codDetalleCatalogo;
	private String descripcionDetCatalogo;

	public String getCodDetalleCatalogo() {
		return codDetalleCatalogo;
	}

	public void setCodDetalleCatalogo(String codDetalleCatalogo) {
		this.codDetalleCatalogo = codDetalleCatalogo;
	}

	public String getDescripcionCatalogo() {
		return descripcionCatalogo;
	}

	public void setDescripcionCatalogo(String descripcionCatalogo) {
		this.descripcionCatalogo = descripcionCatalogo;
	}

	public String getDescripcionDetCatalogo() {
		return descripcionDetCatalogo;
	}

	public void setDescripcionDetCatalogo(String descripcionDetCatalogo) {
		this.descripcionDetCatalogo = descripcionDetCatalogo;
	}

	public Long getCodigoCatalogo() {
		return codigoCatalogo;
	}

	public void setCodigoCatalogo(Long codigoCatalogo) {
		this.codigoCatalogo = codigoCatalogo;
	}
}
