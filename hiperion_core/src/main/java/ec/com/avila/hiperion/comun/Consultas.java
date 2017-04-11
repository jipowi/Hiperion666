package ec.com.avila.hiperion.comun;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		// COBERTURAS
		@NamedQuery(name = "CoberturaAccP.findByRamo", query = "SELECT c FROM CobertAccPer c WHERE c.ramoAccidentesPersonale.idAccidentes =:idRamo"),
		// GRUPOS
		@NamedQuery(name = "GrupoAccP.findByRamo", query = "SELECT c FROM GrupoAccPersonale c WHERE c.ramoAccidentesPersonale.idAccidentes =:idRamo"),
		// ASEGURADORA
		@NamedQuery(name = "Aseguradora.findByRuc", query = "SELECT c FROM Aseguradora c WHERE c.ruc =:ruc"),
		@NamedQuery(name = "Aseguradora.findByAseguradora", query = "SELECT c FROM Aseguradora c WHERE c.codigoAseguradora =:aseguradora"),
		@NamedQuery(name = "Aseguradora.find", query = "SELECT c FROM Aseguradora c WHERE c.ruc =:ruc AND c.codigoAseguradora =:aseguradora"),
		// CATALOGO
		@NamedQuery(name = "Catalogo.findById", query = "SELECT c FROM Catalogo c WHERE c.idCatalogo =:idCatalogo"),
		// CLIENTE
		@NamedQuery(name = "Cliente.findByIdentificacion", query = "SELECT c FROM Cliente c WHERE c.identificacionPersona =:identificacion"),
		@NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellidoPaterno like :apellido"),
		@NamedQuery(name = "Cliente.findByNombres", query = "SELECT c FROM Cliente c WHERE c.nombrePersona like :nombre"),
		@NamedQuery(name = "Cliente.findByRazonSocial", query = "SELECT c FROM Cliente c WHERE c.razonSocial like :razonSocial"),
		@NamedQuery(name = "Cliente.findByAseguradora", query = "SELECT c FROM Cliente c WHERE c.aseguradora.codigoAseguradora =:aseguradora AND c.estado =:estado"),

		// TIPO_DIRECCION
		@NamedQuery(name = "TipoDireccion.findCodigo", query = "SELECT t FROM TipoDireccion t WHERE t.codigoTipoDireccion =:codTipoDireccion"),
		@NamedQuery(name = "TipoDireccion.findDescripcion", query = "SELECT t FROM TipoDireccion t WHERE t.descTipoDireccion =:descripcion"),

		// DIRECCION
		@NamedQuery(name = "Contacto.findByCliente", query = "SELECT c FROM Contacto c WHERE c.cliente.idCliente =:idCliente"),

		// CONTACTOS
		@NamedQuery(name = "Direccion.findCliente", query = "SELECT d FROM Direccion d WHERE d.cliente.idCliente =:idCliente"),

		// DETALLE_CATALOGO
		@NamedQuery(name = "DetalleCatalogo.findByCodCatalogo", query = "SELECT d FROM DetalleCatalogo d WHERE d.catalogo.idCatalogo =:idCatalogo ORDER BY d.descDetCatalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodCatalogoAndCodDetalle", query = "SELECT d FROM DetalleCatalogo d WHERE d.catalogo.idCatalogo =:idCatalogo AND d.codDetalleCatalogo=:codDetalleCatalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodDepCatalogo", query = "SELECT d FROM DetalleCatalogo d WHERE d.codDepDetalleCatalogo =:codDepDetalleCatalogo AND d.codDepDetalleCatalogo=:codDepDetCalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodigoDetalle", query = "SELECT d FROM DetalleCatalogo d WHERE d.codDepDetalleCatalogo =:codDepDetalleCatalogo AND d.catalogo.idCatalogo=:idCatalogo"),
		// RAMO
		@NamedQuery(name = "Ramo.findByCodigoRamo", query = "SELECT r FROM Ramo r WHERE r.codigoRamo =:codigoRamo"),
		@NamedQuery(name = "RamoAccByPoliza", query = "SELECT r FROM RamoAccidentesPersonale r WHERE r.poliza.idPoliza =:idPoliza"),
		@NamedQuery(name = "Ramo.findByAseguradora", query = "SELECT r FROM RamoAseguradora r WHERE r.aseguradora.idAseguradora =:idAseguradora"),
		// USUARIO
		@NamedQuery(name = "Usuario.loginUser", query = "SELECT u FROM Usuario u WHERE u.usuario =:usuario AND u.clave =:clave"),
		// PROVINCIA
		@NamedQuery(name = "Provincia.findByCodProvincia", query = "SELECT p FROM Provincia p WHERE p.codigo =:codigo"),
		// ROL
		@NamedQuery(name = "Rol.findByUsuario", query = "SELECT r FROM Rol r WHERE r.usuario.idUsuario =:idUsuario"),
		// POLIZA
		@NamedQuery(name = "Poliza.findByCliente", query = "SELECT r FROM Poliza r WHERE r.cliente.idCliente =:idCliente"),
		// DETALLE_ANEXO
		@NamedQuery(name = "DetalleAnexo.findByRamoAndTitulo", query = "SELECT d FROM DetalleAnexo d WHERE d.ramo.idRamo=:idRamo AND d.titulo.idTitulo=:idTitulo"),
		@NamedQuery(name = "Titulo.findByIdDetalleAnexo", query = "SELECT d.titulo FROM DetalleAnexo d WHERE d.idDetalleAnexo =:idDetalleAnexo"),
		// REPORTES
		@NamedQuery(name = "Poliza.reporte1", query = "SELECT p FROM Poliza p WHERE p.fechaRegistro BETWEEN :fechaDesde AND :fechaHasta "),
		// MENU
		@NamedQuery(name = "Menu.findByRol", query = "SELECT m FROM RolMenu m WHERE m.rol.idRol =:idRol") })
public class Consultas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer comunId;

	/**
	 * 
	 * @return
	 */
	public Integer getComunId() {
		return comunId;
	}

	/**
	 * 
	 * @param comunId
	 */
	public void setComunId(Integer comunId) {
		this.comunId = comunId;
	}
}
