/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocLuCesanIncendioLineasAliadas;
import ec.com.avila.hiperion.emision.entities.RamoLcIncendio;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,13/05/2015
 * @since JDK1.6
 */
@Stateless
public class LucCesanteIncendioLineasAliadasImpl implements GenerarDocLuCesanIncendioLineasAliadas {

	private static String tagInicioValorItems = "<valorItems>";
	private static String tagFinValorItems = "</valorItems>";
	private static String tagInicioPeriodoIndemnizacion = "<peridoIndemnizacion>";
	private static String tagFinPeriodoIndemnizacion = "</peridoIndemnizacion>";
	private static String tagInicioTasaComprensiva = "<tasaComprensiva>";
	private static String tagFinTasaComprensiva = "</tasaComprensiva>";
	private static String tagInicioDeducibleCastastrofico = "<deducibleCatastrofico>";
	private static String tagFinDeducibleCastastrofico = "</deducibleCatastrofico>";
	private static String tagInicioDeducibleOtrosEventos = "<deducibleOtrosEventos>";
	private static String tagFinDeducibleOtrosEventos = "</deducibleOtrosEventos>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocLuCesanIncendioLineasAliadas#generarXmlLucCesIncendioLineasAliadas(ec.com.avila.hiperion.emision.entities.RamoLcIncendio)
	 */
	@Override
	public String generarXmlLucCesIncendioLineasAliadas(RamoLcIncendio lcIncendio) throws HiperionException {

		StringBuffer buffer = new StringBuffer();

		buffer.append(tagInicioValorItems).append(StringEscapeUtils.escapeXml(lcIncendio.getValorItemsLc().toString())).append(tagFinValorItems);
		buffer.append(tagInicioPeriodoIndemnizacion).append(StringEscapeUtils.escapeXml(lcIncendio.getPeriodoIndemnizacion().toString())).append(tagFinPeriodoIndemnizacion);
		buffer.append(tagInicioTasaComprensiva).append(StringEscapeUtils.escapeXml(lcIncendio.getValorItemsLc().toString())).append(tagFinTasaComprensiva);
		buffer.append(tagInicioDeducibleCastastrofico).append(StringEscapeUtils.escapeXml(lcIncendio.getDeducCatastroficoLc().toString())).append(tagFinDeducibleCastastrofico);
		buffer.append(tagInicioDeducibleOtrosEventos).append(StringEscapeUtils.escapeXml(lcIncendio.getDeducOtrosLc().toString())).append(tagFinDeducibleOtrosEventos);

		return buffer.toString();
	}

}
