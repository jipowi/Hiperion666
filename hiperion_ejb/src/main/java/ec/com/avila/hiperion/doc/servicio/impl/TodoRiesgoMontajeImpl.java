/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocTodoRiesgoMontaje;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,02/06/2015
 * @since JDK1.6
 */
@Stateless
public class TodoRiesgoMontajeImpl implements GenerarDocTodoRiesgoMontaje {

	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";
	private static String tagInicioPeriodoConstruccion = "<periodoConstruccion>";
	private static String tagFinPeriodoConstruccion = "</periodoConstruccion>";
	private static String tagInicioPeriodoMantenimiento = "<periodoMantenimiento>";
	private static String tagFinPeriodoMantenimiento = "</periodoMantenimiento>";
	private static String tagInicioAporcentaje = "<porcentajeAmparoA>";
	private static String tagFinAporcentaje = "</porcentajeAmparoA>";
	private static String tagInicioAMinimo = "<minimoAmparoA>";
	private static String tagFinAMinimo = "</minimoAmparoA>";
	private static String tagInicioBTerremoto = "<terremotoB>";
	private static String tagFinBTerremoto = "</terremotoB>";
	private static String tagInicioBTerremotoMinimo = "<terremotoMinimoB>";
	private static String tagFinBTerremotoMinimo = "</terremotoMinimoB>";
	private static String tagInicioCAguaInundacion = "<aguaInundacionC>";
	private static String tagFinCAguaInundacion = "</aguaInundacionC>";
	private static String tagInicioCAguaInundacionMinimo = "<aguaInundacionMinimoC>";
	private static String tagFinCAguaInundacionMinimo = "</aguaInundacionMinimoC>";
	private static String tagInicioDMantenimientoSimple = "<mantenimientoSimpleD>";
	private static String tagFinDMantenimientoSimple = "</mantenimientoSimpleD>";
	private static String tagInicioDMantenimientoSimpleMinimo = "<mantenimientoSimpleMinimoD>";
	private static String tagFinDMantenimientoSimpleMinimo = "</mantenimientoSimpleMinimoD>";
	private static String tagInicioGRemocionEscombros = "<remosionEscombrosG>";
	private static String tagFinGRemocionEscombros = "</remosionEscombrosG>";
	private static String tagInicioGRemocionEscombrosMinimo = "<remosionEscombrosMinimoG>";
	private static String tagFinGRemocionEscombrosMinimo = "</remosionEscombrosMinimoG>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocTodoRiesgoMontaje#generarXmlTodoRiesgoMontaje(ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje)
	 */
	@Override
	public String generarXmlTodoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) throws HiperionException {

		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioTasa).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getTasaMontaje().toString())).append(tagFinTasa);
		buffer.append(tagInicioPeriodoConstruccion).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getPeriodoConstrucMontaje().toString())).append(tagFinPeriodoConstruccion);
		buffer.append(tagInicioPeriodoMantenimiento).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getPeriodoMantMontaje().toString())).append(tagFinPeriodoMantenimiento);
		buffer.append(tagInicioAporcentaje).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getAmparoAMontaje().toString())).append(tagFinAporcentaje);
		buffer.append(tagInicioAMinimo).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getMinimoAmparoAMontaje().toString())).append(tagFinAMinimo);
		buffer.append(tagInicioBTerremoto).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getAmparoBMontaje().toString())).append(tagFinBTerremoto);
		buffer.append(tagInicioBTerremotoMinimo).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getMinimoAmparoBMontaje().toString())).append(tagFinBTerremotoMinimo);
		buffer.append(tagInicioCAguaInundacion).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getAmparoCMontaje().toString())).append(tagFinCAguaInundacion);
		buffer.append(tagInicioCAguaInundacionMinimo).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getMinimoAmparoCMontaje().toString()))
				.append(tagFinCAguaInundacionMinimo);
		buffer.append(tagInicioDMantenimientoSimple).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getAmparoDMontaje().toString())).append(tagFinDMantenimientoSimple);
		buffer.append(tagInicioDMantenimientoSimpleMinimo).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getMinimoAmparoDMontaje().toString()))
				.append(tagFinDMantenimientoSimpleMinimo);
		buffer.append(tagInicioGRemocionEscombros).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getAmparoGMontaje().toString())).append(tagFinGRemocionEscombros);
		buffer.append(tagInicioGRemocionEscombrosMinimo).append(StringEscapeUtils.escapeXml(ramoRiesgoMontaje.getMinimoAmparoGMontaje().toString()))
				.append(tagFinGRemocionEscombrosMinimo);

		return buffer.toString();
	}

}
