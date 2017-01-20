/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocTodoRiesgoContratista;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoContratista;

/**
 * <b> Clase que se encarga de generar el documento PDF. </b>
 * 
 * @author Franklin Pozo B.
 * @version 1.0,29/05/2015
 * @since JDK1.6
 */
@Stateless
public class TodoRiesgoContratistaImpl implements GenerarDocTodoRiesgoContratista {

	private static String tagInicioTasaPeriodoConstruccion = "<tasaPeriodoConstruccion>";
	private static String tagFinTasaPeriodoConstruccion = "</tasaPeriodoConstruccion>";
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

	// Aumentar objeto asegurado en la base
	// private static String tagInicioObjetoAsegurado = "<periodoMantenimiento>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocTodoRiesgoContratista#generarXmlTodoRiesgoContratista(ec.com.avila.hiperion.emision.entities.RamoRiesgoContratista)
	 */
	@Override
	public String generarXmlTodoRiesgoContratista(RamoRiesgoContratista ramoRiesgoContratista) throws HiperionException {
		StringBuffer buffer = new StringBuffer();

		buffer.append(tagInicioTasaPeriodoConstruccion).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getTasaPeridConst().toString()))
				.append(tagFinTasaPeriodoConstruccion);
		buffer.append(tagInicioPeriodoConstruccion).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getPeriodConstruccionContratista().toString()))
				.append(tagFinPeriodoConstruccion);
		buffer.append(tagInicioPeriodoMantenimiento).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getPeriodMantContratista().toString()))
				.append(tagFinPeriodoMantenimiento);
		buffer.append(tagInicioAporcentaje).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getAmparoAContratista().toString())).append(tagFinAporcentaje);
		buffer.append(tagInicioAMinimo).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getMinimoAmparoA().toString())).append(tagFinAMinimo);
		buffer.append(tagInicioBTerremoto).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getAmparoBContratista().toString())).append(tagFinBTerremoto);
		buffer.append(tagInicioBTerremotoMinimo).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getMinimoAmparoB().toString())).append(tagFinBTerremotoMinimo);
		buffer.append(tagInicioCAguaInundacion).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getAmparoCContratista().toString())).append(tagFinCAguaInundacion);
		buffer.append(tagInicioCAguaInundacionMinimo).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getMinimoAmparoC().toString())).append(tagFinCAguaInundacionMinimo);
		buffer.append(tagInicioDMantenimientoSimple).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getAmparoDContratista().toString()))
				.append(tagFinDMantenimientoSimple);
		buffer.append(tagInicioDMantenimientoSimpleMinimo).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getMinimoAmparoD().toString()))
				.append(tagFinDMantenimientoSimpleMinimo);
		buffer.append(tagInicioGRemocionEscombros).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getAmparoGContratista().toString())).append(tagFinGRemocionEscombros);
		buffer.append(tagInicioGRemocionEscombrosMinimo).append(StringEscapeUtils.escapeXml(ramoRiesgoContratista.getMinimoAmparoG().toString()))
				.append(tagFinGRemocionEscombrosMinimo);

		return buffer.toString();
	}

}
