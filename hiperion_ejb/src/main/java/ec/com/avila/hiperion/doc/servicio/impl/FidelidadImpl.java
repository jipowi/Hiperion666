/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocFidelidad;
import ec.com.avila.hiperion.emision.entities.RamoFidelidad;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,04/05/2015
 * @since JDK1.6
 */
@Stateless
public class FidelidadImpl implements GenerarDocFidelidad {

	private static String tagInicioSector = "<sector>";
	private static String tagFinSector = "</sector>";
	private static String tagInicioValorColusorio = "<valorColusorio>";
	private static String tagFinValorColusorio = "</valorColusorio>";
	private static String tagInicioValorIndividual = "<valorIndividual>";
	private static String tagFinValorIndividual = "</valorIndividual>";
	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";
	private static String tagInicioPorcentajeValorSiniestro = "<porcentajeValorSiniestro>";
	private static String tagFinPorcentajeValorSiniestro = "</porcentajeValorSiniestro>";
	private static String tagInicioMinimo = "<minimo>";
	private static String tagFinMinimo = "</minimo>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocFidelidad#generarXmlFidelidad(ec.com.avila.hiperion.emision.entities.RamoFidelidad)
	 */
	@Override
	public String generarXmlFidelidad(RamoFidelidad fidelidad) throws HiperionException {
		StringBuffer buffer = new StringBuffer();

		buffer.append(tagInicioSector).append(StringEscapeUtils.escapeXml(fidelidad.getSectorFidelidad().toString())).append(tagFinSector);
		buffer.append(tagInicioValorColusorio).append(StringEscapeUtils.escapeXml(fidelidad.getValorColusorio().toString())).append(tagFinValorColusorio);
		buffer.append(tagInicioValorIndividual).append(StringEscapeUtils.escapeXml(fidelidad.getValorIndividual().toString())).append(tagFinValorIndividual);
		buffer.append(tagInicioTasa).append(StringEscapeUtils.escapeXml(fidelidad.getTasaFidelidad().toString())).append(tagFinTasa);
		buffer.append(tagInicioPorcentajeValorSiniestro).append(StringEscapeUtils.escapeXml(fidelidad.getDeducSiniestroFidelidad().toString()))
				.append(tagFinPorcentajeValorSiniestro);
		buffer.append(tagInicioMinimo).append(StringEscapeUtils.escapeXml(fidelidad.getDeducMinimoFidelidad().toString())).append(tagFinMinimo);

		return buffer.toString();
	}

}
