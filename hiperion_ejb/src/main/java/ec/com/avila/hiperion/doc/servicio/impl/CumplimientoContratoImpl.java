/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocCumplimientoContrato;
import ec.com.avila.hiperion.emision.entities.RamoCumplimientoContrato;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/03/2015
 * @since JDK1.6
 */
@Stateless
public class CumplimientoContratoImpl implements GenerarDocCumplimientoContrato {

	private static String tagInicioObjetoAsegurado = "<objetoAsegurado>";
	private static String tagFinObjetoAsegurado = "</objetoAsegurado>";
	private static String tagInicioValorContrato = "<valorContrato>";
	private static String tagFinValorContrato = "</valorContrato>";
	private static String tagInicioValorAsegurado = "<valorAsegurado>";
	private static String tagFinValorAsegurado = "</valorAsegurado>";
	private static String tagInicioTipoContraGarantia = "<tipoContraGaranta>";
	private static String tagFinTipoContraGarantia = "</tipoContraGarantia>";
	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocCumplimientoContrato#generarXmlCumplimientoContrato(ec.com.avila.hiperion.emision.entities.RamoCumplimientoContrato)
	 */
	@Override
	public String generarXmlCumplimientoContrato(RamoCumplimientoContrato cumplimientoContrato) throws HiperionException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioObjetoAsegurado).append(StringEscapeUtils.escapeXml(cumplimientoContrato.getObjetoAsegContrato().toString())).append(tagFinObjetoAsegurado);
		buffer.append(tagInicioValorContrato).append(StringEscapeUtils.escapeXml(cumplimientoContrato.getValorContrato().toString())).append(tagFinValorContrato);
		buffer.append(tagInicioValorAsegurado).append(StringEscapeUtils.escapeXml(cumplimientoContrato.getValorContrato().toString())).append(tagFinValorAsegurado);
		buffer.append(tagInicioTipoContraGarantia).append(StringEscapeUtils.escapeXml(cumplimientoContrato.getTipoContragarantiaContrato().toString()))
				.append(tagFinTipoContraGarantia);

		/**
		 * for (CobertContrato cobertura : coberturas) { buffer.append(tagInicioCoberturas);
		 * buffer.append(tagInicioNomCoberturas).append(StringEscapeUtils.escapeXml(cobertura.getCoberturaContrato())).append(tagFinNomCoberturas); buffer.append(tagFinCoberturas);
		 * }
		 */

		return buffer.toString();
	}

	// private static String tagInicioCoberturas = "<coberturas>";
	// private static String tagFinCoberturas = "</coberturas>";
	// private static String tagInicioNomCoberturas = "<nomCoberturas>";
	// private static String tagFinNomCoberturas = "</nomCoberturas>";


}
