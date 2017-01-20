/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocCascoMaritimo;
import ec.com.avila.hiperion.emision.entities.ClausulasAddCasco;
import ec.com.avila.hiperion.emision.entities.CobertAddCasco;
import ec.com.avila.hiperion.emision.entities.RamoCascoMaritimo;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/03/2015
 * @since JDK1.6
 */
@Stateless
public class CascoMaritimoImpl implements GenerarDocCascoMaritimo {

	private static String tagInicioNombreNave = "<nombreNave>";
	private static String tagFinNombreNave = "/nombreNave";
	private static String tagInicioRegistroNumero = "registroNumero";
	private static String tagFinRegistroNumero = "/registroNumero";
	private static String tagInicioTonelajeBruto = "<tonelajeBruto>";
	private static String tagFinTonelajeBruto = "</tonelajeBruto>";
	private static String tagInicioClaseEmbarcacion = "<claseEmbarcacion>";
	private static String tagFinClaseEmbarcacion = "</claseEmbarcacion>";
	private static String tagInicioBandera = "<bandera>";
	private static String tagFinBandera = "</bandera>";
	private static String tagInicioZonaNavegacion = "<zonaNavegacion>";
	private static String tagFinZonaNavegaciob = "<zonaNavegacion>";
	private static String tagInicioEslora = "<eslora>";
	private static String tagFinEslora = "</eslora>";
	private static String tagInicioPuntal = "<puntal>";
	private static String tagFinPuntal = "</puntal>";
	private static String tagInicioAnioConstruccion = "<anioConstruccion>";
	private static String tagFinAnioContruccion = "</anioContrucción>";
	private static String tagInicioManga = "<manga>";
	private static String tagFinManga = "</manga>";
	private static String tagInicioMarcaMotor = "<marcaMotor>";
	private static String tagFinMarcaMotor = "</marcaMotor>";
	private static String tagInicioAvaluo = "<avlauo>";
	private static String tagFinAvaluo = "</avaluo>";
	private static String tagInicioValorCasco = "<valorCasco>";
	private static String tagFinValorCasco = "</valorCasco>";
	private static String tagInicioValorMaquinaria = "<valorMaquinaria>";
	private static String tagFinValorMaquinaria = "</valorMaquinaria>";
	private static String tagInicioValorRedes = "<valorRedes>";
	private static String tagFinValorRedes = "</valorRedes>";
	private static String tagInicioOtros = "<otros>";
	private static String tagFinOtros = "</otros>";
	private static String tagInicioTotal = "<total>";
	private static String tagFinTotal = "</total>";
	// No cosnta en la base definir bien campos deducibles
	/*private static String tagInicioPorcentajeSiniestro = "<porcentajeSiniestro>";
	private static String tagFinPorcentajeSiniestro = "</porcentajeSiniestro>";
	private static String tagInicioMinimoSiniestro = "<minimoSiniestro>";
	private static String tagFinMinimoSiniestro = "</minimoSiniestro>";
	private static String tagInicioCoberturas = "<coberturas>";
	private static String tagFinCoberturas = "</coberturas>";
	private static String tagInicioNomCobertura = "<nombreCobertura>";
	private static String tagFinNomCobertura = "</nombreCobertura>";
	private static String tagInicioCoberturasAdicionales = "<coberturasAdicionales>";
	private static String tagFinCoberturasAdicionales = "</coberturasAdicionales>";
	private static String tagInicioNomCobertAdicional = "<nombreCoberturasAdicionales>";
	private static String tagFinNomCobertAdicional = "</nombreCoberturasAdicionales>";
	private static String tagInicioClausulasAdicionales = "<clausulasAdicionales>";
	private static String tagFinClausulasAdicionales = "</clausulasAdicionales>";
	private static String tagInicioNomClausulasAdicionales = "<nombreClasulasAdicionales>";
	private static String tagFinNomClausulasAdicionales = "</nombreClausulasadicionales>";
	private static String tagInicioNumDiasClauAdd = "<numeroDiasClausulasAdicionales>";
	private static String tagFinNumDiasClauAdd = "</numeroDiasClausulasAdicionales>";*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocCascoMaritimo#generarXmlCascoMaritimo(ec.com.avila.hiperion.emision.entities.RamoCascoMaritimo)
	 */
	@Override
	public String generarXmlCascoMaritimo(RamoCascoMaritimo cascoMaritimo) throws HiperionException {

		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioNombreNave).append(StringEscapeUtils.escapeXml(cascoMaritimo.getNombreNave().toString())).append(tagFinNombreNave);
		buffer.append(tagInicioRegistroNumero).append(StringEscapeUtils.escapeXml(cascoMaritimo.getNumeroRegistro().toString())).append(tagFinRegistroNumero);
		buffer.append(tagInicioTonelajeBruto).append(StringEscapeUtils.escapeXml(cascoMaritimo.getTonelajeBruto().toString())).append(tagFinTonelajeBruto);
		buffer.append(tagInicioClaseEmbarcacion).append(StringEscapeUtils.escapeXml(cascoMaritimo.getClaseEmbarcacion().toString())).append(tagFinClaseEmbarcacion);
		buffer.append(tagInicioBandera).append(StringEscapeUtils.escapeXml(cascoMaritimo.getBandera().toString())).append(tagFinBandera);
		buffer.append(tagInicioZonaNavegacion).append(StringEscapeUtils.escapeXml(cascoMaritimo.getZonaNavegacion().toString())).append(tagFinZonaNavegaciob);
		buffer.append(tagInicioEslora).append(StringEscapeUtils.escapeXml(cascoMaritimo.getEslora().toString())).append(tagFinEslora);
		buffer.append(tagInicioPuntal).append(StringEscapeUtils.escapeXml(cascoMaritimo.getPuntal().toString())).append(tagFinPuntal);
		buffer.append(tagInicioAnioConstruccion).append(StringEscapeUtils.escapeXml(cascoMaritimo.getAnioConstrMaritimo().toString())).append(tagFinAnioContruccion);
		buffer.append(tagInicioManga).append(StringEscapeUtils.escapeXml(cascoMaritimo.getManga().toString())).append(tagFinManga);
		buffer.append(tagInicioMarcaMotor).append(StringEscapeUtils.escapeXml(cascoMaritimo.getMarcaMotorMaritimo().toString())).append(tagFinMarcaMotor);
		buffer.append(tagInicioAvaluo).append(StringEscapeUtils.escapeXml(cascoMaritimo.getAvaluo().toString())).append(tagFinAvaluo);
		buffer.append(tagInicioValorCasco).append(StringEscapeUtils.escapeXml(cascoMaritimo.getValorCascoMaritimo().toString())).append(tagFinValorCasco);
		buffer.append(tagInicioValorMaquinaria).append(StringEscapeUtils.escapeXml(cascoMaritimo.getValorMaquinariaMaritimo().toString())).append(tagFinValorMaquinaria);
		buffer.append(tagInicioValorRedes).append(StringEscapeUtils.escapeXml(cascoMaritimo.getValorRedes().toString())).append(tagFinValorRedes);
		buffer.append(tagInicioOtros).append(StringEscapeUtils.escapeXml(cascoMaritimo.getOtrosMaritimo().toString())).append(tagFinOtros);
		buffer.append(tagInicioTotal).append(StringEscapeUtils.escapeXml(cascoMaritimo.getTotalMaritimo().toString())).append(tagFinTotal);
		
		/*
		for (CobertAddCasco coberturaAdd : coberturasAdd) {
			buffer.append(tagInicioCoberturasAdicionales);
			buffer.append(tagInicioNomCobertAdicional).append(StringEscapeUtils.escapeXml(coberturaAdd.getCoberturaCasco())).append(tagFinNomCobertAdicional);
			buffer.append(tagFinCoberturasAdicionales);

		}

		for (ClausulasAddCasco clasulaAdd : clausulasAdd) {
			buffer.append(tagInicioClausulasAdicionales);
			buffer.append(tagInicioNomClausulasAdicionales).append(StringEscapeUtils.escapeXml(clasulaAdd.getClausulaAddMaritimo())).append(tagFinNomClausulasAdicionales);
			buffer.append(tagInicioNumDiasClauAdd).append(StringEscapeUtils.escapeXml(clasulaAdd.getNumDiasMaritimo().toString())).append(tagFinNumDiasClauAdd);
			buffer.append(tagFinClausulasAdicionales);
		}*/

		return null;
	}

}
