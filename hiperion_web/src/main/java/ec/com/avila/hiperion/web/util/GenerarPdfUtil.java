package ec.com.avila.hiperion.web.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.xml.transform.TransformerException;

import org.jdom.JDOMException;

import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;
import ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt;
import ec.com.avila.hiperion.emision.entities.RamoBuenaCalMat;
import ec.com.avila.hiperion.emision.entities.RamoCascoAereo;
import ec.com.avila.hiperion.emision.entities.RamoCascoMaritimo;
import ec.com.avila.hiperion.emision.entities.RamoCumplimientoContrato;
import ec.com.avila.hiperion.emision.entities.RamoDineroValore;
import ec.com.avila.hiperion.emision.entities.RamoEquipoElectronico;
import ec.com.avila.hiperion.emision.entities.RamoEquipoMaquinaria;
import ec.com.avila.hiperion.emision.entities.RamoFidelidad;
import ec.com.avila.hiperion.emision.entities.RamoGarantiaAduanera;
import ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada;
import ec.com.avila.hiperion.emision.entities.RamoLcIncendio;
import ec.com.avila.hiperion.emision.entities.RamoLcRotMaq;
import ec.com.avila.hiperion.emision.entities.RamoResponsabilidadCivil;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoContratista;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje;
import ec.com.avila.hiperion.emision.entities.RamoRiesgosEsp;
import ec.com.avila.hiperion.emision.entities.RamoRoboAsalto;
import ec.com.avila.hiperion.emision.entities.RamoRoturaMaquinaria;
import ec.com.avila.hiperion.emision.entities.RamoSoat;
import ec.com.avila.hiperion.emision.entities.RamoTransporte;
import ec.com.avila.hiperion.emision.entities.RamoVehiculo;
import ec.com.kruger.framework.common.util.pdf.HtmltoPDF;

public class GenerarPdfUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * <b> Permite generar el documento ramo agropecuario PDF. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 10/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @param formacionesA
	 * @param formacionesC
	 * @param experiencias
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFAgropecuario(RamoAgropecuario agropecuario) throws Exception {
		String HTML = XSLUtil.getInstancia().obtenerHtmlAgropecuario(agropecuario);

		byte[] contenido = obtenerCadenaBytes(HTML);

		// Agregar marca de agua al Pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento ramo Garantia Aduanera PDF </b>
	 * <p>
	 * [Author: Franklin Pozo , Date: 08/05/2015]
	 * </p>
	 * 
	 * @param garantiaAduanera
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFGarantiaAduanera(RamoGarantiaAduanera garantiaAduanera) throws Exception {
		String HTML = XSLUtil.getInstancia().obtenerHtmlGarantiaAduanera(garantiaAduanera);

		byte[] contenido = obtenerCadenaBytes(HTML);

		// Agregar marca de agua al Pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento ramo Fidelidad PDF. </b>
	 * <p>
	 * [Author: Franklin PozoB, Date: 04/05/2015]
	 * </p>
	 * 
	 * @param fidelidad
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFFidelidad(RamoFidelidad fidelidad) throws Exception {
		String HTML = XSLUtil.getInstancia().obtenerHtmlFidelidad(fidelidad);

		byte[] contenido = obtenerCadenaBytes(HTML);

		// Agregar marca de agua al Pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);

	}

	/**
	 * 
	 * <b> Permite generar el documento ramo equipo electronico PDF. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/04/2015]
	 * </p>
	 * 
	 * @param equipoElectronico
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFEquipoElectronico(RamoEquipoElectronico equipoElectronico) throws Exception {
		String HTML = XSLUtil.getInstancia().obtenerHtmlEquipoElectronico(equipoElectronico);

		byte[] contenido = obtenerCadenaBytes(HTML);

		// Agregar marca de agua al Pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);

	}

	/**
	 * 
	 * <b> Permite generar el documento ramo equipo maquinaria PDF. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/04/2015]
	 * </p>
	 * 
	 * @param equipoMaquinaria
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFEquipoMaquinaria(RamoEquipoMaquinaria equipoMaquinaria) throws Exception {
		String HTML = XSLUtil.getInstancia().obtenerHtmlEquipoMaquinaria(equipoMaquinaria);

		byte[] contenido = obtenerCadenaBytes(HTML);

		// Agregar marca de agua al Pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);

	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Buena Calidad Materiales. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 07/04/2015]
	 * </p>
	 * 
	 * @param buenaCalMat
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFBuenaCalidadMat(RamoBuenaCalMat buenaCalMat) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlBuenaCalidadMat(buenaCalMat);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Buen Uso de Anticipo. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 13/04/2015]
	 * </p>
	 * 
	 * @param buenUsoAnt
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFBuenUsoAnticipo(RamoBuenUsoAnt buenUsoAnt) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlBuenUsoAnticipo(buenUsoAnt);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Riesgos especiales </b>
	 * <p>
	 * [Author: Franklin Pozo B., Date: 25/05/2015]
	 * </p>
	 * 
	 * @param ramoRiesgosEsp
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFRiesgosEspeciales(RamoRiesgosEsp ramoRiesgosEsp) throws Exception {

		String pHtml = XSLUtil.getInstancia().obtenerHtmlRiesgosEspeciales(ramoRiesgosEsp);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento Ramo Todo Riesgo Contratista </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 02/06/2015]
	 * </p>
	 * 
	 * @param ramoRiesgoContratista
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFRiesgosContratista(RamoRiesgoContratista ramoRiesgoContratista) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlRiesgoContratista(ramoRiesgoContratista);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);

	}

	/**
	 * 
	 * <b> Permite generar el documento Ramo Todo Riesgo Montaje </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 02/06/2015]
	 * </p>
	 * 
	 * @param ramoRiesgoMontaje
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFTodoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlRiesgoMontaje(ramoRiesgoMontaje);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);

	}
	
	/**
	 * 
	 * <b>
	 *  Permite generar el documento Ramo Vehiculos
	 * </b>
	 * <p>[Author: Franklin Pozo B, Date: 07/06/2015]</p>
	 *
	 * @param ramoVehiculo
	 * @return
	 * @throws Exception
	 */
	public static byte[]generarArchivoPDFVehiculos(RamoVehiculo ramoVehiculo)throws Exception{
		String pHtml = XSLUtil.getInstancia().obtenerHtmlVehiculo(ramoVehiculo);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
		
	}

	/**
	 * 
	 * <b> Permite generar el documento Ramo Todo Riesgo Contratista </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 03/06/2015]
	 * </p>
	 * 
	 * @param ramoTransporte
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFTransporte(RamoTransporte ramoTransporte) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlTransporte(ramoTransporte);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Soat </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 28/05/2015]
	 * </p>
	 * 
	 * @param ramoSoat
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFSoat(RamoSoat ramoSoat) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlSoat(ramoSoat);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);

	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Rotura de Maquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 27/05/2015]
	 * </p>
	 * 
	 * @param ramoRoturaMaquinaria
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlRoturaMaquinaria(ramoRoturaMaquinaria);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);

	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Robo y/o Asalto </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 25/05/2015]
	 * </p>
	 * 
	 * @param ramoRoboAsalto
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFRoboAsalto(RamoRoboAsalto ramoRoboAsalto) throws Exception {

		String pHtml = XSLUtil.getInstancia().obtenerHtmlRoboAsalto(ramoRoboAsalto);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Casco Aereo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 20/04/2015]
	 * </p>
	 * 
	 * @param cascoAereo
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFCascoAereo(RamoCascoAereo cascoAereo) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlCascoAereo(cascoAereo);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Casco Maritimo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 20/04/2015]
	 * </p>
	 * 
	 * @param cascoMaritimo
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFCascoMaritimo(RamoCascoMaritimo cascoMaritimo) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlCascoMaritimo(cascoMaritimo);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);

	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Cumplimiento Contrato. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 21/04/2015]
	 * </p>
	 * 
	 * @param cumplimientoContrato
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFCumplimientoContrato(RamoCumplimientoContrato cumplimientoContrato) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlCumplimientoContrato(cumplimientoContrato);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Responsabilidad Civil </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 21/05/2015]
	 * </p>
	 * 
	 * @param ramoResponsabilidadCivil
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlResponsabilidadCivil(ramoResponsabilidadCivil);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Lucro Cesante Incendio Lineas Aliadas </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 13/05/2015]
	 * </p>
	 * 
	 * @param ramoLcIncendio
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFLucCesIncendioLineasAliadas(RamoLcIncendio ramoLcIncendio) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlLucCesIncendioLineasAliadas(ramoLcIncendio);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Lucro Cesante Rotura de maquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo B., Date: 12/05/2015]
	 * </p>
	 * 
	 * @param ramoLcRotMaq
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFLucroCesanteRoturaMaquinaria(RamoLcRotMaq ramoLcRotMaq) throws Exception {

		String pHtml = XSLUtil.getInstancia().obtenerHtmlLucroCesanteRoturaMaquinaria(ramoLcRotMaq);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Cumplimiento Contrato </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 11/05/2015]
	 * </p>
	 * 
	 * @param incendioLineasAliada
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFIncendioLineaAliada(RamoIncendioLineasAliada incendioLineasAliada) throws Exception {

		String pHtml = XSLUtil.getInstancia().obtenerHtmlIncendioLineasAliadas(incendioLineasAliada);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);

	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Dinero y valores </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/04/2015]
	 * </p>
	 * 
	 * @param dineroValore
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFDineroValores(RamoDineroValore dineroValore) throws Exception {

		String pHtml = XSLUtil.getInstancia().obtenerHtmlDineroValores(dineroValore);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * <b> Permite obtener la cadena de bytes del archivo HTML. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 10/03/2015]
	 * </p>
	 * 
	 * @param pHtml
	 * @return
	 * @throws FileNotFoundException
	 * @throws JDOMException
	 * @throws IOException
	 * @throws TransformerException
	 */
	private static byte[] obtenerCadenaBytes(String pHtml) throws FileNotFoundException, JDOMException, IOException, TransformerException {

		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_ISO_XML, "");
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_XML, "");
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_XML_STANDALONE, "");
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_XML, "");

		HtmltoPDF htmltoPDF = new HtmltoPDF(FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath(ConstantesUtil.DIRECTORIO_PLANTILLA_XHTML2FO));

		HashMap<String, String> parametros = new HashMap<String, String>();

		byte contenido[] = htmltoPDF.convertir(pHtml, "", "", parametros, null);

		return contenido;
	}
}
