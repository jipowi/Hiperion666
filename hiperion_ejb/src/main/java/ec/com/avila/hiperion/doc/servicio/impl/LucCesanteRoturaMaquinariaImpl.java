/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocLucroCesanteRoturaMaquinaria;
import ec.com.avila.hiperion.emision.entities.RamoLcRotMaq;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,12/05/2015
 * @since JDK1.6
 */
@Stateless
public class LucCesanteRoturaMaquinariaImpl implements GenerarDocLucroCesanteRoturaMaquinaria {

	private static String tagInicioUtilidadBrutaEstimadaAnual = "<utilidadBrutaEstimadaAnual>";
	private static String tagFinUtilidadBrutaEstimadaAnual = "</utilidadBrutaEstimadaAnual>";
	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";
	private static String tagInicioPeriodoIndemnizacion = "<periodoIndemnizacion>";
	private static String tagFinPeriodoIndemnizacion = "</periodoIndemnizacion>";
	//private static String tagInicioNumeroDias = "<numeroDias>";
	//private static String tagFinNumeroDias = "</numeroDias>";
	//private static String tagInicioMinimoPorcentajeValAseg = "<minimoPorcentajeValorAsegurado>";
	//private static String tagFinMinimoPorcentajeValAseg = "</minimoPorcentajeValorAsegurado>";
	//private static String tagInicioMinimo = "<minimo>";
	//private static String tagFinMinimo = "</minimo>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocLucroCesanteRoturaMaquinaria#generarXmlLucroCesanteRoturaMaquinaria(ec.com.avila.hiperion.emision.entities.RamoLcRotMaq)
	 */
	@Override
	public String generarXmlLucroCesanteRoturaMaquinaria(RamoLcRotMaq ramoLcRotMaq) throws HiperionException {

		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioUtilidadBrutaEstimadaAnual).append(StringEscapeUtils.escapeXml(ramoLcRotMaq.getUtilidadBrutaLcRotura().toString()))
				.append(tagFinUtilidadBrutaEstimadaAnual);
		buffer.append(tagInicioTasa).append(StringEscapeUtils.escapeXml(ramoLcRotMaq.getTasaLcRotura().toString())).append(tagFinTasa);
		buffer.append(tagInicioPeriodoIndemnizacion).append(StringEscapeUtils.escapeXml(ramoLcRotMaq.getPeriodIndemnizacionLc().toString())).append(tagFinPeriodoIndemnizacion);
		//buffer.append(tagInicioNumeroDias).append(StringEscapeUtils.escapeXml(ramoLcRotMaq.getDeducNumDias().toString())).append(tagFinNumeroDias);
		//buffer.append(tagInicioMinimoPorcentajeValAseg).append(StringEscapeUtils.escapeXml(ramoLcRotMaq.getDeducMinimoAsegLcRotura().toString()))	.append(tagFinMinimoPorcentajeValAseg);
		//buffer.append(tagInicioMinimo).append(StringEscapeUtils.escapeXml(ramoLcRotMaq.getDeducMinimoLcRotura().toString())).append(tagFinMinimo);

		return buffer.toString();
	}

}
