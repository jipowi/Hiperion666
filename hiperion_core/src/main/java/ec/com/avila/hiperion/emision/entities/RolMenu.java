package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the rol_menu database table.
 * 
 */
@Entity
@Table(name="rol_menu")
@NamedQuery(name="RolMenu.findAll", query="SELECT r FROM RolMenu r")
public class RolMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_menu_rol")
	private Integer idMenuRol;

	//bi-directional many-to-one association to Menu
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_menu")
	private Menu menu;

	//bi-directional many-to-one association to Rol
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_rol")
	private Rol rol;

	public RolMenu() {
	}

	public Integer getIdMenuRol() {
		return this.idMenuRol;
	}

	public void setIdMenuRol(Integer idMenuRol) {
		this.idMenuRol = idMenuRol;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}