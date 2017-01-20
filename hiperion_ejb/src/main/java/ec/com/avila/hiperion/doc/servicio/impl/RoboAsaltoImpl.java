/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocRoboAsalto;
import ec.com.avila.hiperion.emision.entities.RamoRoboAsalto;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo B.
 * @version 1.0,25/05/2015
 * @since JDK1.6
 */
@Stateless
public class RoboAsaltoImpl implements GenerarDocRoboAsalto {

	private static String tagInicioTasaRoboAsalto = "<tasaRoboAsalto>";
	private static String tagFinTasaRoboAsalto = "</tasaRoboAsalto>";
	private static String tagInicioTasaHurto = "<tasaHurto>";
	private static String tagFinTasaHurto = "</tasaHurto>";
	private static String tagInicioTasaPropiedadEmpleados = "<tasaPropiedadEmpleados>";
	private static String tagFinTasaPropiedadEmpleados = "</tasaPropiedadEmpleados>";
	private static String tagInicioTasaContenidos = "<tasaContenidos>";
	private static String tagFinTasaContenidos = "</tasaContenidos>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocRoboAsalto#generarXmlRoboAsalto(ec.com.avila.hiperion.emision.entities.RamoRoboAsalto)
	 */
	@Override
	public String generarXmlRoboAsalto(RamoRoboAsalto ramoRoboAsalto) throws HiperionException {

		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioTasaRoboAsalto).append(StringEscapeUtils.escapeXml(ramoRoboAsalto.getTasaRoboAsalto().toString())).append(tagFinTasaRoboAsalto);
		buffer.append(tagInicioTasaHurto).append(StringEscapeUtils.escapeXml(ramoRoboAsalto.getTasaHurtoRobo().toString())).append(tagFinTasaHurto);
		buffer.append(tagInicioTasaPropiedadEmpleados).append(StringEscapeUtils.escapeXml(ramoRoboAsalto.getTasaPropiedad().toString())).append(tagFinTasaPropiedadEmpleados);
		buffer.append(tagInicioTasaContenidos).append(StringEscapeUtils.escapeXml(ramoRoboAsalto.getTasaContenidos().toString())).append(tagFinTasaContenidos);
		

		return buffer.toString();
	}

}
