/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocCascoAereo;
import ec.com.avila.hiperion.emision.entities.RamoCascoAereo;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Avila Sistemas
 * @version 1.0,18/03/2015
 * @since JDK1.6
 */
@Stateless
public class CascoAereoImpl implements GenerarDocCascoAereo {
	private static String tagInicioItem = "<item>";
	private static String tagFinItem = "</item>";
	private static String tagInicioMatricula = "<matricula>";
	private static String tagFinMatricula = "</matricula>";
	private static String tagInicioAnioConstruccion = "<anioConstruccion>";
	private static String tagFinAnioConstruccion = "</anioConstruccion>";
	private static String tagInicioPesoMaximoTotal = "<pesoMaximoTotal>";
	private static String tagFinPesoMaximoTotal = "</pesoMaximoTotal>";
	private static String tagInicioValorCasco = "<valorCasco>";
	private static String tagFinValorCasco = "</valorCasco>";
	private static String tagInicioMarca = "<marca>";
	private static String tagFinMarca = "</marca>";
	private static String tagInicioTipoModelo = "<tipoModelo>";
	private static String tagFinTipoModelo = "</tipoModelo>";
	private static String tagInicioHorasVoladas = "<horasVoladas>";
	private static String tagFinHorasVoladas = "</horasVoladas>";
	private static String tagInicioMaximaCargaAutorizada = "<maximaCargaAutorizada>";
	private static String tagFinMaximaCargaAutorizada = "</maximaCargaAutorizada>";
	private static String tagInicioMarcaMotor = "<marcaMotor>";
	private static String tagFinMarcaMotor = "</marcaMotor>";
	private static String tagInicioTipoMotor = "<tipoMotor>";
	private static String tagFinTipoMotor = "</tipoMotor>";
	private static String tagInicioTotalAsegurado = "<totalAsegurado>";
	private static String tagFinTotalAsegurado = "</totalAsegurado>";
	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";
	//private static String tagInicioDeducibles="<deducibles>";
	//private static String tagFinDeducibles="</deducibles>";
	//Campo no existe en la base
	//private static String tagInicioPorcentajeSiniestro = "<porcentajeSiniestro>";
	//private static String tagFinPorcentajeSiniestro = "</porcentajeSiniestro>";
	//private static String tagInicioMinimoSiniestro = "<minimoSiniestro>";
	//private static String tagFinMinimoSiniestro = "</minimoSiniestro>";
	//private static String tagInicioDetalleExtra = "<detalleExtra>";
	//private static String tagFinDetalleExtra = "</detalleExtra>";
	//Agregar campo detalle extra
	//private static String tagInicioValorExtra = "<valorExtra>";
	//private static String tagFinValorExtra = "</valorExtra>";
	//No exiten tablas de coberturas
	//private static String tagInicioCoberturas = "<coberturas>";
	//private static String tagFinCoberturas = "</coberturas>";
	//private static String tagInicioNomCobertura = "<nomCoberturas>";
	//private static String tagFinNomCobertura = "</nomCoberturas>";
	//private static String tagInicioCoberturasAdicionales = "<coberturasAdicionales>";
	//private static String tagFinCoberturasAdicionales = "</coberturasAdicionales>";
	//private static String tagInicioNomCoberturasAdicional = "<nomCoberturasAdicional>";
	//private static String tagFinNomCoberturasAdicionales = "</nomCoberturasAdicionales>";
	//private static String tagInicioClausulasAdicionales = "<clausulasAdicionales>";
	//private static String tagFinClausulasAdicionales = "</clausulasAdicionales>";
	//private static String tagInicioNomClausulasAdicionales = "<nomClausulasAdicionales>";
	//private static String tagFinNomClausulasAdicionales = "</nomClausulasAdicionales>";
	//private static String tagInicioNumDiasClausulasAdicionales = "<numDiasClausulsAdicionales>";
	//sprivate static String tagFinNumDiasClausulasAdicionales = "</numDiasClausulasAdicionales>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocCascoAereo#generarXmlCascoAereo(ec.com.avila.hiperion.emision.entities.RamoCascoAereo)
	 */
	@Override
	public String generarXmlCascoAereo(RamoCascoAereo cascoAereo) throws HiperionException {

		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioItem).append(StringEscapeUtils.escapeXml(cascoAereo.getItemAereo().toString())).append(tagFinItem);
		buffer.append(tagInicioMatricula).append(StringEscapeUtils.escapeXml(cascoAereo.getMatricula().toString())).append(tagFinMatricula);
		buffer.append(tagInicioAnioConstruccion).append(StringEscapeUtils.escapeXml(cascoAereo.getAnioConstruccionAereo().toString())).append(tagFinAnioConstruccion);
		buffer.append(tagInicioPesoMaximoTotal).append(StringEscapeUtils.escapeXml(cascoAereo.getPesoMaximoAereo().toString())).append(tagFinPesoMaximoTotal);
		buffer.append(tagInicioValorCasco).append(StringEscapeUtils.escapeXml(cascoAereo.getValorCascoAereo().toString())).append(tagFinValorCasco);
		buffer.append(tagInicioMarca).append(StringEscapeUtils.escapeXml(cascoAereo.getMarcaAereo().toString())).append(tagFinMarca);
		buffer.append(tagInicioTipoModelo).append(StringEscapeUtils.escapeXml(cascoAereo.getTipoModeloAereo().toString())).append(tagFinTipoModelo);
		buffer.append(tagInicioHorasVoladas).append(StringEscapeUtils.escapeXml(cascoAereo.getHorasVoladas().toString())).append(tagFinHorasVoladas);
		buffer.append(tagInicioHorasVoladas).append(StringEscapeUtils.escapeXml(cascoAereo.getHorasVoladas().toString())).append(tagFinHorasVoladas);
		buffer.append(tagInicioMaximaCargaAutorizada).append(StringEscapeUtils.escapeXml(cascoAereo.getMaximaCargaAereo().toString())).append(tagFinMaximaCargaAutorizada);
		buffer.append(tagInicioMarcaMotor).append(StringEscapeUtils.escapeXml(cascoAereo.getMarcaMotorAereo().toString())).append(tagFinMarcaMotor);
		buffer.append(tagInicioTipoMotor).append(StringEscapeUtils.escapeXml(cascoAereo.getTipoMotorAereo().toString())).append(tagFinTipoMotor);
		buffer.append(tagInicioTotalAsegurado).append(StringEscapeUtils.escapeXml(cascoAereo.getTotalAseguradoAereo().toString())).append(tagFinTotalAsegurado);
		buffer.append(tagInicioTasa).append(StringEscapeUtils.escapeXml(cascoAereo.getTasaCascoAereo().toString())).append(tagFinTasa);
		//buffer.append(tagInicioMinimoSiniestro).append(StringEscapeUtils.escapeXml(cascoAereo.getDeducMinimoSiniestroAereo().toString())).append(tagFinMinimoSiniestro);
		//buffer.append(tagInicioDeducibles).append(StringEscapeUtils.escapeXml(cascoAereo.getDeducSiniestroAereo().toString())).append(tagFinDeducibles);
		//buffer.append(tagInicioDetalleExtra).append(StringEscapeUtils.escapeXml(cascoAereo.getExtrasCascoAereos().toString())).append(tagFinDetalleExtra);
		return buffer.toString();
	}
}
