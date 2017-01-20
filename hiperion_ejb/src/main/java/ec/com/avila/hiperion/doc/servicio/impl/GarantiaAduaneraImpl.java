/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocGarantiaAduanera;
import ec.com.avila.hiperion.emision.entities.RamoGarantiaAduanera;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,06/05/2015
 * @since JDK1.6
 */
@Stateless
public class GarantiaAduaneraImpl implements GenerarDocGarantiaAduanera {

	private static String tagInicioObjetoAsegurado = "<objetoAsegurado>";
	private static String tagFinObjetoAsegurado = "</objetoAsegurado>";
	private static String tagInicioValorContrato = "<valorContrato>";
	private static String tagFinValorContrato = "</valorContrato>";
	private static String tagInicioValorPoliza = "<valorPoliza>";
	private static String tagFinValorPoliza = "</valorPoliza>";
	private static String tagInicioSector = "<sector>";
	private static String tagFinSector = "</sector>";
	private static String tagInicioTipoContraGarantia = "<contraGarantia>";
	private static String tagFinTipoContraGarantia = "</contraGarantia>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocGarantiaAduanera#generarXmlGarantiaAduanera(ec.com.avila.hiperion.emision.entities.RamoGarantiaAduanera)
	 */
	@Override
	public String generarXmlGarantiaAduanera(RamoGarantiaAduanera garantiaAduanera) throws HiperionException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioObjetoAsegurado).append(StringEscapeUtils.escapeXml(garantiaAduanera.getObjAsgAduanera().toString())).append(tagFinObjetoAsegurado);
		buffer.append(tagInicioValorContrato).append(StringEscapeUtils.escapeXml(garantiaAduanera.getValorContratoAduanera().toString())).append(tagFinValorContrato);
		buffer.append(tagInicioSector).append(StringEscapeUtils.escapeXml(garantiaAduanera.getSectorAduanera().toString())).append(tagFinSector);
		buffer.append(tagInicioValorPoliza).append(StringEscapeUtils.escapeXml(garantiaAduanera.getValorPolizaAduanera().toString())).append(tagFinValorPoliza);
		buffer.append(tagInicioTipoContraGarantia).append(StringEscapeUtils.escapeXml(garantiaAduanera.getTipoContragarantiaAduanera().toString()))
				.append(tagFinTipoContraGarantia);

		return buffer.toString();
	}

}
