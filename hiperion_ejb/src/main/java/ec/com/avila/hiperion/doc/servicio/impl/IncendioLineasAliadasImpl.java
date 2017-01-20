/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocIncendiLineasAliadas;
import ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo B.
 * @version 1.0,11/05/2015
 * @since JDK1.6
 */
@Stateless
public class IncendioLineasAliadasImpl implements GenerarDocIncendiLineasAliadas {

	private static String tagInicioValorItems = "<valorItems>";
	private static String tagFinValorItems = "</valorItems>";
	private static String tagInicioConsideracionesImportantes = "<consideracionesImportantes>";
	private static String tagFinConsideracionesImportantes = "</consideracionesImportantes>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocIncendiLineasAliadas#generarXmlIncendioLineasAliadas(ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada)
	 */
	@Override
	public String generarXmlIncendioLineasAliadas(RamoIncendioLineasAliada incendioLineasAliada) throws HiperionException {

		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioValorItems).append(StringEscapeUtils.escapeXml(incendioLineasAliada.getValorItemsIncendio().toString())).append(tagFinValorItems);
		buffer.append(tagInicioConsideracionesImportantes).append(StringEscapeUtils.escapeXml(incendioLineasAliada.getConsideracionesImpIncendio().toString()))
				.append(tagFinConsideracionesImportantes);

		return buffer.toString();
	}

}
