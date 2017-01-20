/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocVehiculos;
import ec.com.avila.hiperion.emision.entities.RamoVehiculo;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,05/06/2015
 * @since JDK1.6
 */
@Stateless
public class VehiculosImpl implements GenerarDocVehiculos {

	private static String tagInicioClaseVehiculo = "<claseVehiculo>";
	private static String tagFinClaseVehiculo = "</claseVehiculo>";
	private static String tagInicioTipoVehiculo = "<tipoVehiculo>";
	private static String tagFinTipoVehiculo = "</tipoVehiculo>";
	private static String tagInicioUso = "<uso>";
	private static String tagFinUso = "</uso>";
	// Agregar Marca en la base de datos
	// private static String tagInicioMarca = "<marca>";
	// private static String tagFinMarca = "</marca>";
	private static String tagInicioModelo = "<modelo>";
	private static String tagFinModelo = "</modelo>";
	private static String tagInicioDetalleModelo = "<detalleModelo>";
	private static String tagFinDetalleModelo = "</detalleModelo>";
	private static String tagInicioItem = "<item>";
	private static String tagFinItem = "</item>";
	private static String tagInicioNombrePropietario = "<nombrePropietario>";
	private static String tagFinNombrePropietario = "</nombrePropietario>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocVehiculos#generarXmlVehiculos(ec.com.avila.hiperion.emision.entities.RamoVehiculo)
	 */
	@Override
	public String generarXmlVehiculos(RamoVehiculo ramoVehiculo) throws HiperionException {

		StringBuffer buffer = new StringBuffer();

		buffer.append(tagInicioClaseVehiculo).append(StringEscapeUtils.escapeXml(ramoVehiculo.getClaseVh().toString())).append(tagFinClaseVehiculo);
		buffer.append(tagInicioTipoVehiculo).append(StringEscapeUtils.escapeXml(ramoVehiculo.getTipoVh().toString())).append(tagFinTipoVehiculo);
		buffer.append(tagInicioUso).append(StringEscapeUtils.escapeXml(ramoVehiculo.getUsoVh().toString())).append(tagFinUso);
		buffer.append(tagInicioModelo).append(StringEscapeUtils.escapeXml(ramoVehiculo.getModeloVh().toString())).append(tagFinModelo);
		buffer.append(tagInicioDetalleModelo).append(StringEscapeUtils.escapeXml(ramoVehiculo.getDetalleModeloVh().toString())).append(tagFinDetalleModelo);
		buffer.append(tagInicioItem).append(StringEscapeUtils.escapeXml(ramoVehiculo.getItemVh().toString())).append(tagFinItem);
		buffer.append(tagInicioNombrePropietario).append(StringEscapeUtils.escapeXml(ramoVehiculo.getPropietarioVh().toString())).append(tagFinNombrePropietario);

		return buffer.toString();
	}

}
