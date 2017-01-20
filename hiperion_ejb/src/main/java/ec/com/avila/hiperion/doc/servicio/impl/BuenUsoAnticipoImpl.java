/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocBuenUsoAnticipo;
import ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,17/03/2015
 * @since JDK1.6
 */
@Stateless
public class BuenUsoAnticipoImpl implements GenerarDocBuenUsoAnticipo {

	private static String tagInicioSector = "<sector>";
	private static String tagFinSector = "</sector>";

	private static String tagInicioValorContrato = "<valorContrato>";
	private static String tagFinValorContrato = "</valorContrato>";
	private static String tagInicioValorPoliza = "<valorPoliza>";
	private static String tagFinValorPoliza = "</valorPoliza>";
	private static String tagInicioObjetoAsegurado = "<objetoAsegurado>";
	private static String tagFinObjetoAsegurado = "</objetoAsegurado>";
	//private static String tagInicioCoberturas = "<coberturas>";
	//private static String tagFinCoberturas = "</coberturas>";
	//private static String tagInicioNomCobertura = "<nomCobertura>";
	//private static String tagFinNomCobertura = "</nomCobertura>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocBuenUsoAnticipo#generarXmlBuenUsoAnticipo(ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt)
	 */
	@Override
	public String generarXmlBuenUsoAnticipo(RamoBuenUsoAnt buenUsoAnt) throws HiperionException {

		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioSector).append(StringEscapeUtils.escapeXml(buenUsoAnt.getSectorAnticipo().toString())).append(tagFinSector);
		buffer.append(tagInicioValorContrato).append(StringEscapeUtils.escapeXml(buenUsoAnt.getValorContratoAnticipo().toString())).append(tagFinValorContrato);
		buffer.append(tagInicioValorPoliza).append(StringEscapeUtils.escapeXml(buenUsoAnt.getValorPolizaAnticipo().toString())).append(tagFinValorPoliza);
		buffer.append(tagInicioObjetoAsegurado).append(StringEscapeUtils.escapeXml(buenUsoAnt.getObjAsegAnticipo().toString())).append(tagFinObjetoAsegurado);
		//buffer.append(tagInicioCoberturas).append(StringEscapeUtils.escapeXml(buenUsoAnt.getCobertBuenUsoAnts().toString())).append(tagFinCoberturas);

		/*
		for (CobertBuenUsoAnt cobertura : coberturas) {
			buffer.append(tagInicioNomCobertura);
			buffer.append(tagInicioNomCobertura).append(StringEscapeUtils.escapeXml(cobertura.getCoberturaAnticipo())).append(tagFinNomCobertura);
			buffer.append(tagFinNomCobertura);
		}
		*/

		return buffer.toString();
	}

}
