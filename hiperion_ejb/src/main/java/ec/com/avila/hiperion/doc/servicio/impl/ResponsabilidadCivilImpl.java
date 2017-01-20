/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocResponsabilidadCivil;
import ec.com.avila.hiperion.emision.entities.RamoResponsabilidadCivil;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo B.
 * @version 1.0,16/05/2015
 * @since JDK1.6
 */
@Stateless
public class ResponsabilidadCivilImpl implements GenerarDocResponsabilidadCivil {

	private static String tagInicioLimiteUnicoAgregadoAnual = "<limiteUnicoagregadoAnual>";
	private static String tagFinLimiteUnicoAgregadoAnual = "</limiteUnicoagregadoAnual>";
	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";
	private static String tagInicioPorcentajeValorSiniestro = "<porcentajeValorSiniestro>";
	private static String tagFinPorcentajeValorSiniestro = "</porcentajeValorSiniestro>";
	private static String tagInicioMinimo = "<minimo>";
	private static String tagFinMinimo = "</minimo>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocResponsabilidadCivil#generarXmlResponsabilidadCivil(ec.com.avila.hiperion.emision.entities.RamoResponsabilidadCivil)
	 */
	@Override
	public String generarXmlResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil) throws HiperionException {

		StringBuffer buffer = new StringBuffer();

		buffer.append(tagInicioLimiteUnicoAgregadoAnual).append(StringEscapeUtils.escapeXml(ramoResponsabilidadCivil.getLimiteUnicoAnualResp().toString()))
				.append(tagFinLimiteUnicoAgregadoAnual);
		buffer.append(tagInicioTasa).append(StringEscapeUtils.escapeXml(ramoResponsabilidadCivil.getTasaResp().toString())).append(tagFinTasa);
		buffer.append(tagInicioPorcentajeValorSiniestro).append(StringEscapeUtils.escapeXml(ramoResponsabilidadCivil.getDeducSiniestroResp().toString()))
				.append(tagFinPorcentajeValorSiniestro);
		buffer.append(tagInicioMinimo).append(StringEscapeUtils.escapeXml(ramoResponsabilidadCivil.getDeducMinimoResp().toString())).append(tagFinMinimo);

		return buffer.toString();
	}

}
