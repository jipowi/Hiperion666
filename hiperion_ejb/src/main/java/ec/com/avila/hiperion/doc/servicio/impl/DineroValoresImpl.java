/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocDineroValores;
import ec.com.avila.hiperion.emision.entities.RamoDineroValore;

/**
 * <b> Clase que se encarga de generar el documento PDF. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/03/2015
 * @since JDK1.6
 */
@Stateless
public class DineroValoresImpl implements GenerarDocDineroValores {

	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";
	private static String tagInicioPorcentajeSiniestro = "<porcentajeSiniestro>";
	private static String tagFinPorcentajeSiniestro = "</porcentajeSiniestro>";
	private static String tagInicioValorMinimoSiniestro = "<valorMinimoSiniestro>";
	private static String tagFinValorMinimoSiniestro = "</valorMinimoSiniestro>";
	private static String tagInicioPorcentajeEmbarque = "<porcentajeEmbarque>";
	private static String tagFinPorcentajeEmbarque = "</porcentajeEmbarque>";
	// Objeto Asegurado
	/**
	private static String tagInicioObjetoAsegurado = "<objetoAsegurado>";
	private static String tagFinObjetoAsegurado = "</objetoAsegurado>";
	private static String tagInicioItem = "<item>";
	private static String tagFinItem = "</item>";
	private static String tagInicioDineroValores = "<dineroValores>";
	private static String tagFinDineroValores = "</dineroValores>";
	private static String tagInicioLimiteEstimadoAnual = "<limiteEstimadoAnual>";
	private static String tagFinLimiteEstimadoAnual = "</limiteEstimadoAnual>";
	private static String tagInicioLimiteEmbarque = "<limiteEmbarque>";
	private static String tagFinLimiteEmbarque = "</limiteEmbarque>";
	private static String tagInicioTrayectoriaDesde = "<trayectoriaDesde>";
	private static String tagFinTrayectoriaDesde = "</trayectoriaDesde>";
	private static String tagInicioTrayectoriaHasta = "<trayectoriaHasta>";
	private static String tagFinTrayectoriaHasta = "</trayectoriaHasta>";
	private static String tagInicioMedioTransporte = "<medioTransporte>";
	private static String tagFinMedioTransporte = "</medioTransporte>";
	private static String tagInicioCoberturas = "<cobertras>";
	private static String tagFinCoberturas = "</coberturas>";
	private static String tagInicioNomCoberturas = "<coberturas>";
	private static String tagFinNomCoberturas = "</coberturas>";
	private static String tagInicioClausulasAdicionales = "<clausulasAdicionales>";
	private static String tagFinClausulasAdicionales = "</clausulasAdicionales>";
	private static String tagInicioNomClausulasAdd = "<clausulasAdicionales>";
	private static String tagFinNomClausulasAdd = "</clausulasAdicionales>";
	private static String tagInicioNumDias = "<numeroDias>";
	private static String tagFinNumDias = "</numeroDias>";**/
	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocDineroValores#generarXmlDineroValores(ec.com.avila.hiperion.emision.entities.RamoDineroValore)
	 */
	@Override
	public String generarXmlDineroValores(RamoDineroValore dineroValore) throws HiperionException {
		StringBuffer buffer = new StringBuffer();

		buffer.append(tagInicioTasa).append(StringEscapeUtils.escapeXml(dineroValore.getTasaDinero().toString())).append(tagFinTasa);
		buffer.append(tagInicioPorcentajeSiniestro).append(StringEscapeUtils.escapeXml(dineroValore.getDeducPorSiniestroDinero().toString())).append(tagFinPorcentajeSiniestro);
		buffer.append(tagInicioValorMinimoSiniestro).append(StringEscapeUtils.escapeXml(dineroValore.getDeducMinimoDinero().toString())).append(tagFinValorMinimoSiniestro);
		buffer.append(tagInicioPorcentajeEmbarque).append(StringEscapeUtils.escapeXml(dineroValore.getPorcentajeEmbarqueDinero().toString())).append(tagFinPorcentajeEmbarque);
		
		/*
		for (ObjAsegDineroVal objetoAsegurado : objetoAseg) {
			buffer.append(tagInicioObjetoAsegurado);
			buffer.append(tagInicioItem).append(StringEscapeUtils.escapeXml(objetoAsegurado.getItemObjDinero().toString())).append(tagFinItem);
			buffer.append(tagInicioDineroValores).append(StringEscapeUtils.escapeXml(objetoAsegurado.getDineroValores().toString())).append(tagFinDineroValores);
			buffer.append(tagInicioLimiteEstimadoAnual).append(StringEscapeUtils.escapeXml(objetoAsegurado.getLimiteEstimado().toString())).append(tagFinLimiteEstimadoAnual);
			buffer.append(tagInicioLimiteEmbarque).append(StringEscapeUtils.escapeXml(objetoAsegurado.getLimiteEmbarqueObjDinero().toString())).append(tagFinLimiteEmbarque);
			buffer.append(tagInicioItem).append(StringEscapeUtils.escapeXml(objetoAsegurado.getItemObjDinero().toString())).append(tagFinItem);
			buffer.append(tagInicioTrayectoriaDesde).append(StringEscapeUtils.escapeXml(objetoAsegurado.getDesde().toString())).append(tagFinTrayectoriaDesde);
			buffer.append(tagInicioTrayectoriaHasta).append(StringEscapeUtils.escapeXml(objetoAsegurado.getHasta().toString())).append(tagFinTrayectoriaHasta);
			buffer.append(tagInicioMedioTransporte).append(StringEscapeUtils.escapeXml(objetoAsegurado.getMedioTransporteDinero().toString())).append(tagFinMedioTransporte);
			buffer.append(tagFinObjetoAsegurado);
		}

		for (CobertDineroVal coberturas : cobertura) {
			buffer.append(tagInicioCoberturas);
			buffer.append(tagInicioNomCoberturas).append(StringEscapeUtils.escapeXml(coberturas.getCoberturaDinero().toString())).append(tagFinNomCoberturas);
			buffer.append(tagFinCoberturas);
		}

		for (ClausulasAddDinero clausulas : clausulasAdd) {
			buffer.append(tagInicioClausulasAdicionales);
			buffer.append(tagInicioNomClausulasAdd).append(StringEscapeUtils.escapeXml(clausulas.getClausulaAddDinero().toString())).append(tagFinNomClausulasAdd);
			buffer.append(tagInicioNumDias).append(StringEscapeUtils.escapeXml(clausulas.getNumDiasDinero().toString())).append(tagFinNumDias);
			buffer.append(tagFinClausulasAdicionales);
		}*/

		return buffer.toString();
	}


}
