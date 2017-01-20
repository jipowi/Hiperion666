package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocAgropecuario;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;

/**
 * 
 * <b> Clase que se encarga de generar el documento PDF. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,10/03/2015
 * @since JDK1.6
 */
@Stateless
public class AgropecuarioImpl implements GenerarDocAgropecuario {

	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";
	private static String tagInicioDeducible = "<deducible>";
	private static String tagFinDeducible = "</deducible>";
	private static String tagInicioObjetoAsegurado = "<objetoAsegurado>";
	private static String tagFinObjetoAsegurado = "</objetoAsegurado>";
	private static String tagInicioValorAseguradoPlantacion = "<valorAsegurado>";
	private static String tagFinValorAseguradoPlantacion = "</valorAsegurado>";
	private static String tagFinDetallePlantacion = "</detalle>";
	private static String tagInicioUbicacion = "<ubicacion>";
	private static String tagFinUbicacion = "</ubicacion>";
	private static String tagInicioItem = "<item>";
	private static String tagFinItem = "</item>";
	private static String tagInicioNombre = "<nombre>";
	private static String tagFinNombre = "</nombre>";
	private static String tagInicioSexo = "<sexo>";
	private static String tagFinSexo = "</sexo>";
	private static String tagInicioRaza = "<raza>";
	private static String tagFinRaza = "</raza>";
	private static String tagInicioColor = "<color>";
	private static String tagFinColor = "</color>";
	private static String tagInicioEdad = "<edad>";
	private static String tagFinEdad = "</edad>";
	private static String tagInicioMontoAsegurado = "<montoAsegurado>";
	private static String tagFinMontoAsegurado = "</montoAsegurado>";
	private static String tagInicioClausulasAdicionales = "<clausulasAdicionales>";
	private static String tagFinClausulasAdicionales = "</clausulasAdicionales>";
	private static String tagInicioCoberturas = "<coberturas>";
	private static String tagFinCoberturas = "</coberturas>";
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocumentoHojaVida#generarXmlHojaVida(ec.com.avila.hiperion.emision.entities.RamoAgropecuario)
	 */
	@Override
	public String generarXmlAgropecuario(RamoAgropecuario agropecuario) throws HiperionException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioTasa).append(StringEscapeUtils.escapeXml(agropecuario.getTasaAgro().toString())).append(tagFinTasa);
		buffer.append(tagInicioDeducible).append(StringEscapeUtils.escapeXml(agropecuario.getDeducAgro().toString())).append(tagFinDeducible);
		return buffer.toString();
	}
}
