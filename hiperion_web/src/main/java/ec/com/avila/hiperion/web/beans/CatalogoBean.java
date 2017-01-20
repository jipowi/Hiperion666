package ec.com.avila.hiperion.web.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ec.com.avila.hiperion.emision.entities.Catalogo;

@ManagedBean
@RequestScoped
public class CatalogoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private String descripcion;

	private Catalogo selectCatalogo;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Catalogo getSelectCatalogo() {
		return selectCatalogo;
	}

	public void setSelectCatalogo(Catalogo selectCatalogo) {
		this.selectCatalogo = selectCatalogo;
	}
}
