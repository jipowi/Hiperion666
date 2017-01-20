/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocEquipoMaquinaria;
import ec.com.avila.hiperion.emision.entities.RamoEquipoMaquinaria;

/**
 * <b> Clase que se encarga de generar el documento PDF. </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,29/04/2015
 * @since JDK1.6
 */
@Stateless
public class EquipoMaquinariaImp implements GenerarDocEquipoMaquinaria {

	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";
	private static String tagInicioPorcentajeValorSiniestro = "<porcentajeValorSiniestro>";
	private static String tagFinPorcentajeValorSiniestro = "</porcentajeValorSiniestro>";
	private static String tagInicioMinimoPorcentajeValorAseg = "<minimoPorcentajeValorAsegurado>";
	private static String tagFinMinimoPorcentajeValorAseg = "</minimoPorcentajeValorAsegurado>";
	private static String tagInicioMinimoSiniestro = "<minimoSiniestro>";
	private static String tagFinMinimoSiniestro = "</minimoSiniestro>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocEquipoMaquinaria#generarXmlEquipoMaquinaria(ec.com.avila.hiperion.emision.entities.RamoEquipoMaquinaria, java.util.List,
	 * java.util.List, java.util.List)
	 */
	@Override
	public String generarXmlEquipoMaquinaria(RamoEquipoMaquinaria equipoMaquinaria) throws HiperionException {
		StringBuffer buffer = new StringBuffer();

		buffer.append(tagInicioTasa).append(StringEscapeUtils.escapeXml(equipoMaquinaria.getTasaEquipoMaq().toString())).append(tagFinTasa);
		buffer.append(tagInicioPorcentajeValorSiniestro).append(StringEscapeUtils.escapeXml(equipoMaquinaria.getDeducPorcSiniestroMaq().toString()))
				.append(tagFinPorcentajeValorSiniestro);
		buffer.append(tagInicioMinimoPorcentajeValorAseg).append(StringEscapeUtils.escapeXml(equipoMaquinaria.getDeducMinAsegMaq().toString()))
				.append(tagFinMinimoPorcentajeValorAseg);
		buffer.append(tagInicioMinimoSiniestro).append(StringEscapeUtils.escapeXml(equipoMaquinaria.getDeducMinimoSiniestroMaq().toString())).append(tagFinMinimoSiniestro);

		return buffer.toString();
	}

}
