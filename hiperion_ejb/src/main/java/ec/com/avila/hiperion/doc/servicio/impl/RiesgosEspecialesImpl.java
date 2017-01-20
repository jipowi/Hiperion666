/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocRiesgosEspeciales;
import ec.com.avila.hiperion.emision.entities.RamoRiesgosEsp;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo B.
 * @version 1.0,25/05/2015
 * @since JDK1.6
 */
@Stateless
public class RiesgosEspecialesImpl implements GenerarDocRiesgosEspeciales {

	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";
	// private static String tagInicioDeducible = "<deducible>";
	// private static String tagFinDeducible = "</deducible>";
	private static String tagInicioCondicionesImportantes = "<condicionesImportantes>";
	private static String tagFinCondicionesImportantes = "</condicionesImportantes>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocRiesgosEspeciales#generarXmlRiesgosEspeciales(ec.com.avila.hiperion.emision.entities.RamoRiesgosEsp)
	 */
	@Override
	public String generarXmlRiesgosEspeciales(RamoRiesgosEsp ramoRiesgosEsp) throws HiperionException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioTasa).append(StringEscapeUtils.escapeXml(ramoRiesgosEsp.getTasaRiesgosEsp().toString())).append(tagFinTasa);
		buffer.append(tagInicioCondicionesImportantes).append(StringEscapeUtils.escapeXml(ramoRiesgosEsp.getCondImpRiesgos().toString())).append(tagFinCondicionesImportantes);

		return buffer.toString();
	}

}
