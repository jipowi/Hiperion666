/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocRoturaMaquinaria;
import ec.com.avila.hiperion.emision.entities.RamoRoturaMaquinaria;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,27/05/2015
 * @since JDK1.6
 */
@Stateless
public class RoturaMaquinariaImpl implements GenerarDocRoturaMaquinaria {

	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";
	private static String tagInicioPorcentajeValorSiniestro = "<porcentajeValorSiniestro>";
	private static String tagFinPorcentajeValorSiniestro = "</porcentajeValorSiniestro>";
	private static String tagInicioMinimoPorcentajeValorAsegurado = "<minimoPorcentajeValorAsegurado>";
	private static String tagFinMinimoPorcentajeValorAsegurado = "</minimoPorcentajeValorAsegurado>";
	private static String tagInicioMinimo = "<minimo>";
	private static String tagFinMinimo = "</minimo>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocRoturaMaquinaria#generarXmlRoturaMaquinaria(ec.com.avila.hiperion.emision.entities.RamoRoturaMaquinaria)
	 */
	@Override
	public String generarXmlRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) throws HiperionException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioTasa).append(StringEscapeUtils.escapeXml(ramoRoturaMaquinaria.getTasaRotMaq().toString())).append(tagFinTasa);
		buffer.append(tagInicioPorcentajeValorSiniestro).append(StringEscapeUtils.escapeXml(ramoRoturaMaquinaria.getDeducSiniestroRotMaq().toString()))
				.append(tagFinPorcentajeValorSiniestro);
		buffer.append(tagInicioMinimoPorcentajeValorAsegurado).append(StringEscapeUtils.escapeXml(ramoRoturaMaquinaria.getDeducMinimoSiniestroRot().toString()))
				.append(tagFinMinimoPorcentajeValorAsegurado);
		buffer.append(tagInicioMinimo).append(StringEscapeUtils.escapeXml(ramoRoturaMaquinaria.getDeducMinimoAsegRotMaq().toString())).append(tagFinMinimo);

		return buffer.toString();
	}

}
