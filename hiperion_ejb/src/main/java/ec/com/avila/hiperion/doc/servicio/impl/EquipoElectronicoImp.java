/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocEquipoElectronico;
import ec.com.avila.hiperion.emision.entities.RamoEquipoElectronico;

/**
 * <b> Clase que se encarga de generar el documento PDF. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,28/04/2015
 * @since JDK1.6
 */
@Stateless
public class EquipoElectronicoImp implements GenerarDocEquipoElectronico {

	private static String tagInicioEquiposFijosPorcentaje = "<equiposFijos>";
	private static String tagFinEquiposFijosPorcentaje = "</equiposFijos>";
	private static String tagInicioEquiposPortatilesPorcentaje = "<equiposPortatiles>";
	private static String tagFinEquiposPortatilesPorcentaje = "</equiposPortatiles>";
	private static String tagInicioCelularesPorcentaje = "<celulares>";
	private static String tagFinCelularesPorcentaje = "</celulares>";
	private static String tagInicioTasaOtrosPorcentaje = "<tasaOtros>";
	private static String tagFinTasaOtrosPorcentaje = "</tasaOtros>";
	private static String tagInicioPortadoresExternosDatos = "<portadoresExternosDatos>";
	private static String tagFinPortadoresExternosDatos = "</portadoresExternosDatos>";
	private static String tagInicioIncrementoCostoOperacion = "<incrementoCostoOperacion>";
	private static String tagFinIncrementoCostoOperacion = "</incrementoCostoOperacion>";
	private static String tagInicioHurto = "<hurto>";
	private static String tagFinHurto = "</hurto>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocEquipoElectronico#generarXmlEquipoElectronico(ec.com.avila.hiperion.emision.entities.RamoEquipoElectronico)
	 */
	@Override
	public String generarXmlEquipoElectronico(RamoEquipoElectronico equipoElectronico) throws HiperionException {

		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioEquiposFijosPorcentaje).append(StringEscapeUtils.escapeXml(equipoElectronico.getTasaEquiposFijos().toString())).append(tagFinEquiposFijosPorcentaje);
		buffer.append(tagInicioEquiposPortatilesPorcentaje).append(StringEscapeUtils.escapeXml(equipoElectronico.getTasaEquiposPortatiles().toString()))
				.append(tagFinEquiposPortatilesPorcentaje);
		buffer.append(tagInicioCelularesPorcentaje).append(StringEscapeUtils.escapeXml(equipoElectronico.getTasaCelulares().toString())).append(tagFinCelularesPorcentaje);
		buffer.append(tagInicioTasaOtrosPorcentaje).append(StringEscapeUtils.escapeXml(equipoElectronico.getTasaOtrosEqElec().toString())).append(tagFinTasaOtrosPorcentaje);
		buffer.append(tagInicioPortadoresExternosDatos).append(StringEscapeUtils.escapeXml(equipoElectronico.getTasaExtDatos().toString())).append(tagFinPortadoresExternosDatos);
		buffer.append(tagInicioIncrementoCostoOperacion).append(StringEscapeUtils.escapeXml(equipoElectronico.getTasaOperacion().toString()))
				.append(tagFinIncrementoCostoOperacion);
		buffer.append(tagInicioHurto).append(StringEscapeUtils.escapeXml(equipoElectronico.getTasaHurtoEqElec().toString())).append(tagFinHurto);
		
		return buffer.toString();
	}

}
