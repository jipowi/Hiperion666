/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Apr 13, 2014
 * @since JDK1.6
 */
@FacesConverter("marca")
public class MarcasConverter implements Converter {

	public static List<MarcasDto> marcasLivianos;
	public static List<MarcasDto> marcasPesados;
	public static List<MarcasDto> marcasMotos;
	

	static {

		marcasLivianos = new ArrayList<MarcasDto>();

		marcasLivianos.add(new MarcasDto("ACURA", "acura.jpg"));
		marcasLivianos.add(new MarcasDto("ALFA ROMEO", "alfaromeo.gif"));
		marcasLivianos.add(new MarcasDto("AUDI", "audi.gif"));
		marcasLivianos.add(new MarcasDto("BAW", "baw.png"));
		marcasLivianos.add(new MarcasDto("BMW", "bmw.gif"));
		marcasLivianos.add(new MarcasDto("BRILLANCE", "brillance.png"));
		marcasLivianos.add(new MarcasDto("BYD", "byd.jpg"));
		marcasLivianos.add(new MarcasDto("CHERY", "chery.jpg"));
		marcasLivianos.add(new MarcasDto("CHEVROLET", "chevrolet.gif"));
		marcasLivianos.add(new MarcasDto("CITROEN", "citroen.jpg"));
		marcasLivianos.add(new MarcasDto("DACIA", "dacia.jpg"));
		marcasLivianos.add(new MarcasDto("DAEWOO", "daewoo.jpg"));
		marcasLivianos.add(new MarcasDto("DAIHATSU", "daihatsu.gif"));
		marcasLivianos.add(new MarcasDto("FERRARI", "ferrari.gif"));
		marcasLivianos.add(new MarcasDto("FIAT", "fiat.gif"));
		marcasLivianos.add(new MarcasDto("FORD", "ford.gif"));
		marcasLivianos.add(new MarcasDto("HONDA", "honda.gif"));
		marcasLivianos.add(new MarcasDto("HUMMER", "hummer.jpg"));
		marcasLivianos.add(new MarcasDto("HYUNDAI", "hyundai.gif"));
		marcasLivianos.add(new MarcasDto("ISUZU", "isuzu.gif"));
		marcasLivianos.add(new MarcasDto("JAGUAR", "jaguar.gif"));
		marcasLivianos.add(new MarcasDto("JEEP", "jeep.gif"));
		marcasLivianos.add(new MarcasDto("KIA", "kia.gif"));
		marcasLivianos.add(new MarcasDto("LADA", "lada.gif"));
		marcasLivianos.add(new MarcasDto("LANDROVER", "landrover.gif"));
		marcasLivianos.add(new MarcasDto("LEXUS", "lexus.gif"));
		marcasLivianos.add(new MarcasDto("LIFAN", "lifan.png"));
		marcasLivianos.add(new MarcasDto("MAHINDRA", "mahindra.gif"));
		marcasLivianos.add(new MarcasDto("MASERATI", "maserati.gif"));
		marcasLivianos.add(new MarcasDto("MAZDA", "mazda.gif"));
		marcasLivianos.add(new MarcasDto("MERCEDES", "mercedes.gif"));
		marcasLivianos.add(new MarcasDto("MINI", "mini.gif"));
		marcasLivianos.add(new MarcasDto("MITSUBISHI", "mitsubishi.gif"));
		marcasLivianos.add(new MarcasDto("NISSAN", "nissan.gif"));
		marcasLivianos.add(new MarcasDto("OPEL", "opel.gif"));
		marcasLivianos.add(new MarcasDto("PEUGEOT", "peugeot.gif"));
		marcasLivianos.add(new MarcasDto("PORSCHE", "porsche.gif"));
		marcasLivianos.add(new MarcasDto("RENAULT", "renault.png"));
		marcasLivianos.add(new MarcasDto("SKODA", "skoda.gif"));
		marcasLivianos.add(new MarcasDto("SUBARU", "subaru.gif"));
		marcasLivianos.add(new MarcasDto("SUZUKI", "suzuki.gif"));
		marcasLivianos.add(new MarcasDto("TATA", "tata.gif"));
		marcasLivianos.add(new MarcasDto("TOYOTA", "toyota.gif"));
		marcasLivianos.add(new MarcasDto("VOLKSWAGEN", "volkswagen.gif"));
		marcasLivianos.add(new MarcasDto("VOLVO", "volvo.gif"));
		
		
		
		marcasPesados = new ArrayList<MarcasDto>();

		marcasPesados.add(new MarcasDto("CHEVROLET", "chevrolet.gif"));
		marcasPesados.add(new MarcasDto("DAIHATSU", "daihatsu.gif"));
		marcasPesados.add(new MarcasDto("DONG FENG", "dongFeng.jpg"));
		marcasPesados.add(new MarcasDto("FORD", "ford.gif"));
		marcasPesados.add(new MarcasDto("FREIGHTLINER", "freightliner.jpg"));
		marcasPesados.add(new MarcasDto("HINO", "hino.jpg"));
		marcasPesados.add(new MarcasDto("HYUNDAI", "hyundai.gif"));
		marcasPesados.add(new MarcasDto("INTERNATIONAL", "international.jpg"));
		marcasPesados.add(new MarcasDto("ISUZU", "isuzu.gif"));
		marcasPesados.add(new MarcasDto("IVECO", "iveco.png"));
		marcasPesados.add(new MarcasDto("JAC", "jac.jpg"));
		marcasPesados.add(new MarcasDto("KENWORTH", "kenworth.jpg"));
		marcasPesados.add(new MarcasDto("KIA", "kia.gif"));
		marcasPesados.add(new MarcasDto("MACK", "mack.png"));
		marcasPesados.add(new MarcasDto("MAN", "man.jpg"));
		marcasPesados.add(new MarcasDto("MERCEDES", "mercedes.gif"));
		marcasPesados.add(new MarcasDto("MITSUBISHI", "mitsubishi.gif"));
		marcasPesados.add(new MarcasDto("NISSAN", "nissan.gif"));
		marcasPesados.add(new MarcasDto("QMC", "QMC.jpg"));
		marcasPesados.add(new MarcasDto("SCANIA", "scania.png"));
		marcasPesados.add(new MarcasDto("WESTER", "wester.jpg"));
		
		marcasMotos = new ArrayList<MarcasDto>();

		marcasMotos.add(new MarcasDto("BAJAJ", "bajaj.jpg"));
		marcasMotos.add(new MarcasDto("BMW", "bmw.gif"));
		marcasMotos.add(new MarcasDto("DAYANG", "dayang.jpg"));
		marcasMotos.add(new MarcasDto("DUCATI", "ducati.gif"));
		marcasMotos.add(new MarcasDto("HARLEY DAVIDSON", "harley-davidson.gif"));
		marcasMotos.add(new MarcasDto("HM", "hm.jpg"));
		marcasMotos.add(new MarcasDto("HONDA", "honda.jpg"));
		marcasMotos.add(new MarcasDto("HUSABERG", "husaberg.jpg"));
		marcasMotos.add(new MarcasDto("HUSQVARNA", "husqvarna.jpg"));
		marcasMotos.add(new MarcasDto("KAWASAKI", "kawasaki.jpg"));
		marcasMotos.add(new MarcasDto("KTM", "dayang.jpg"));
		marcasMotos.add(new MarcasDto("DUCATI", "ducati.gif"));
		marcasMotos.add(new MarcasDto("MOTOR UNO", "motor_uno.png"));
		marcasMotos.add(new MarcasDto("POLARIS", "polaris.jpg"));
		marcasMotos.add(new MarcasDto("RANGER", "ranger.png"));
		marcasMotos.add(new MarcasDto("ROYAL", "royal.jpg"));
		marcasMotos.add(new MarcasDto("SHINERAY", "shineray.gif"));
		marcasMotos.add(new MarcasDto("SUKIDA", "sukida.jpg"));
		marcasMotos.add(new MarcasDto("SUZUKI", "suzuki.jpg"));
		marcasMotos.add(new MarcasDto("THUNDER", "thunder.jpg"));
		marcasMotos.add(new MarcasDto("UM", "um.jpg"));
		marcasMotos.add(new MarcasDto("YAMAHA", "yamaha.gif"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String submittedValue) {
		if (submittedValue.trim().equals("")) {
			return null;
		} else {
			try {

				for (MarcasDto p : marcasLivianos) {
					if (p.getMarca().equals(submittedValue)) {
						return p;
					}
				}
				for (MarcasDto p : marcasPesados) {
					if (p.getMarca().equals(submittedValue)) {
						return p;
					}
				}

				for (MarcasDto p : marcasMotos) {
					if (p.getMarca().equals(submittedValue)) {
						return p;
					}
				}

			} catch (NumberFormatException exception) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		if (value == null || value.equals("")) {
			return "";
		} else {
			return String.valueOf(((MarcasDto) value).getMarca());
		}
	}

}
