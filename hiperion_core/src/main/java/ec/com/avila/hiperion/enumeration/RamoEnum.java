/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.enumeration;

/**
 * 
 * <b> Enumeracion que contiene la lista de ramos </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Nov 24, 2014
 * @since JDK1.6
 */
public enum RamoEnum {

	R1("ACCIDENTES PERSONALES"), 
	R2("AGROPECUARIO"),
	R3("ASISTENCIA MEDICA"),
	R4("BUEN USO DE ANTICIPO"),
	R5("BUENA CALIDAD DE MATERIALES"),
	R6("CASCO AEREO"),
	R7("CASCO MARITIMO"),
	R8("CUMPLIMIENTO DE CONTRATO"),
	R9("DINERO Y VALORES"),
	R10("EQUIPO ELECTRONICO"),
	R11("EQUIPO Y MAQUINARIA"),
	R12("FIDELIDAD"),
	R13("GARANTIA ADUANERA"),
	R14("INCENDIO Y/O LINEAS ALIADAS"),
	R15("LUCRO CESANTE POR ROTURA DE MAQUINARIA"),
	R16("LUCRO CESANTE INCENDIO Y LINEAS ALIADAS"),
	R17("RESPONSABILIDAD CIVIL"),
	R18("RIESGOS ESPECIALES"),
	R19("ROBO Y/O ASALTO"),
	R20("ROTURA DE MAQUINARIA"),
	R21("SOAT"),
	R22("TODO RIESGO CONTRATISTA"),
	R23("TODO RIESGO MONTAJE"),
	R24("TRANSPORTE"),
	R25("VEHÍCULOS"),
	R26("VIDA");
	

	private String label;

	RamoEnum(String label) {
		this.label = label;
	}

	/**
	 * @return el valor de la variable label
	 */
	public String getLabel() {
		return label;
	}

}
