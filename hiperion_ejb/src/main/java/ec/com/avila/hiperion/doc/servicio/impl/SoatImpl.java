/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocSoat;
import ec.com.avila.hiperion.emision.entities.RamoSoat;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,28/05/2015
 * @since JDK1.6
 */
@Stateless
public class SoatImpl implements GenerarDocSoat {

	private static String tagInicioTipoVehiculo = "<tipoVehiculo>";
	private static String tagFinTipoVehiculo = "</tipoVehiculo>";
	private static String tagInicioModelo = "<modelo>";
	private static String tagFinoModelo = "</modelo>";
	private static String tagInicioNombreAsegurado = "<nombreAsegurado>";
	private static String tagFinNombreAsegurado = "</nombreAsegurado>";
	private static String tagInicioColor = "<color>";
	private static String tagFinColor = "</color>";
	private static String tagInicioPlaca = "<placa>";
	private static String tagFinPlaca = "</placa>";
	private static String tagInicioChasis = "<chasis>";
	private static String tagFinChasis = "</chasis>";
	private static String tagInicioAnio = "<anio>";
	private static String tagFinAnio = "</anio>";
	private static String tagInicioCilindraje = "<clindraje>";
	private static String tagFinCilindraje = "</clindraje>";

	// Agregar campo pasajeros base de datos
	// private static String tagInicioPasajeros = "<pasajeros>";
	// private static String tagFinPasajeros = "</pasajeros>";
	// agregar campo Tipo Soat a la base
	// private static String tagInicioTipoSoat = "<tipoSoat>";
	// private static String tagFinTipoSoat = "</tipoSoat>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocSoat#generarXmlSoat(ec.com.avila.hiperion.emision.entities.RamoSoat)
	 */
	@Override
	public String generarXmlSoat(RamoSoat ramoSoat) throws HiperionException {

		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioTipoVehiculo).append(StringEscapeUtils.escapeXml(ramoSoat.getTipoVehiculoSoat().toString())).append(tagFinTipoVehiculo);
		buffer.append(tagInicioModelo).append(StringEscapeUtils.escapeXml(ramoSoat.getModeloSoat().toString())).append(tagFinoModelo);
		buffer.append(tagInicioNombreAsegurado).append(StringEscapeUtils.escapeXml(ramoSoat.getAsegurado().toString())).append(tagFinNombreAsegurado);
		buffer.append(tagInicioColor).append(StringEscapeUtils.escapeXml(ramoSoat.getColorSoat().toString())).append(tagFinColor);
		buffer.append(tagInicioPlaca).append(StringEscapeUtils.escapeXml(ramoSoat.getPlacaSoat().toString())).append(tagFinPlaca);
		buffer.append(tagInicioChasis).append(StringEscapeUtils.escapeXml(ramoSoat.getChasisSoat().toString())).append(tagFinChasis);
		buffer.append(tagInicioAnio).append(StringEscapeUtils.escapeXml(ramoSoat.getAnioSoat().toString())).append(tagFinAnio);
		buffer.append(tagInicioCilindraje).append(StringEscapeUtils.escapeXml(ramoSoat.getCilindrajeSoat().toString())).append(tagFinCilindraje);

		return buffer.toString();
	}

}
