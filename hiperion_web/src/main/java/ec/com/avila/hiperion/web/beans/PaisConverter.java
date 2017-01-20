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
@FacesConverter("pais")
public class PaisConverter implements Converter {
	
	public static List<PaisDto> paises;

	static {
		paises = new ArrayList<PaisDto>();

		paises.add(new PaisDto("ALBANIA", "albania.gif"));
		paises.add(new PaisDto("ALEMANIA", "alemania.gif"));
		paises.add(new PaisDto("ANGUILA", "anguila.gif"));
		paises.add(new PaisDto("ARABIA SAUDITA", "arabiaSaudita.gif"));
		paises.add(new PaisDto("ARGENTINA", "argentina.gif"));
		paises.add(new PaisDto("AUSTRALIA", "australia.gif"));
		paises.add(new PaisDto("AUSTRIA", "austria.gif"));
		paises.add(new PaisDto("BAHAMAS", "bahamas.gif"));
		paises.add(new PaisDto("BANGLADESH", "bangladesh.gif"));
		paises.add(new PaisDto("BARBADOS", "barbados.gif"));
		paises.add(new PaisDto("BELGICA", "belgica.gif"));
		paises.add(new PaisDto("BELICE", "belice.gif"));
		paises.add(new PaisDto("BERMUDAS", "bermuda.gif"));
		paises.add(new PaisDto("BOSNIA", "bosnia.gif"));
		paises.add(new PaisDto("BRASIL", "brasil.gif"));
		paises.add(new PaisDto("BULGARIA", "bulgaria.gif"));
		paises.add(new PaisDto("CAMERUN", "camerun.gif"));
		paises.add(new PaisDto("CANADA", "canada.gif"));
		paises.add(new PaisDto("CHILE", "chile.gif"));
		paises.add(new PaisDto("CHINA", "china.gif"));
		paises.add(new PaisDto("CHIPRE", "chipre.gif"));
		paises.add(new PaisDto("COLOMBIA", "colombia.gif"));
		paises.add(new PaisDto("COREA DEL SUR", "coreaDelSur.gif"));
		paises.add(new PaisDto("COREA DEL NORTE", "corenaDelNorte.gif"));
		paises.add(new PaisDto("COSTA RICA", "costaRica.gif"));
		paises.add(new PaisDto("CROACIA", "croacia.gif"));
		paises.add(new PaisDto("CUBA", "cuba.gif"));
		paises.add(new PaisDto("DINAMARCA", "dinamarca.gif"));
		paises.add(new PaisDto("DOMINICA", "dominica.gif"));
		paises.add(new PaisDto("ECUADOR", "ecuador.gif"));
		paises.add(new PaisDto("EGIPTO", "egipto.gif"));
		paises.add(new PaisDto("EL SALVADOR", "elSalvador.gif"));
		paises.add(new PaisDto("ESCOCIA", "escocia.gif"));
		paises.add(new PaisDto("ESLOVAQUIA", "eslovaquia.gif"));
		paises.add(new PaisDto("ESLOVENIA", "eslovenia.gif"));
		paises.add(new PaisDto("ESPAÑA", "espania.gif"));
		paises.add(new PaisDto("ESTONIA", "estonia.gif"));
		paises.add(new PaisDto("FINLANDIA", "finlandia.gif"));
		paises.add(new PaisDto("FRANCIA", "francia.gif"));
		paises.add(new PaisDto("GALES", "gales.gif"));
		paises.add(new PaisDto("GILBRALTAR", "gilbraltar.gif"));
		paises.add(new PaisDto("GRECIA", "grecia.gif"));
		paises.add(new PaisDto("GUYANA FRANCESA", "guyanaFrancesa.gif"));
		paises.add(new PaisDto("GUYANA", "guyana.gif"));
		paises.add(new PaisDto("HAITI", "haiti.gif"));
		paises.add(new PaisDto("HONDURAS", "honduras.gif"));
		paises.add(new PaisDto("HUNGRIA", "hungria.gif"));
		paises.add(new PaisDto("INGLATERRA", "inglaterra.gif"));
		paises.add(new PaisDto("IRLANDA", "irlanda.gif"));
		paises.add(new PaisDto("ISLANDIA", "islandia.gif"));
		paises.add(new PaisDto("ISRAEL", "israel.gif"));
		paises.add(new PaisDto("ITALIA", "italia.gif"));
		paises.add(new PaisDto("JAMAICA", "jamaica.gif"));
		paises.add(new PaisDto("JAPON", "japon.gif"));
		paises.add(new PaisDto("LETONIA", "letonia.gif"));
		paises.add(new PaisDto("MEXICO", "mexico.gif"));
		paises.add(new PaisDto("NIGARAGUA", "nicaragua.gif"));
		paises.add(new PaisDto("NIGERIA", "nigeria.gif"));
		paises.add(new PaisDto("NORUEGA", "noruega.gif"));
		paises.add(new PaisDto("NUEVA ZELANDA", "nuevaZelandia.gif"));
		paises.add(new PaisDto("PAISES BAJOS", "paisesBajos.gif"));
		paises.add(new PaisDto("PANAMA", "panama.gif"));
		paises.add(new PaisDto("PANAMA", "paraguay.gif"));
		paises.add(new PaisDto("PERU", "peru.gif"));
		paises.add(new PaisDto("PORTUGAL", "portugal.gif"));
		paises.add(new PaisDto("PUERTO RICO", "puerto rico.gif"));
		paises.add(new PaisDto("QATAR", "qatar.gif"));
		paises.add(new PaisDto("REPUBLICA CHECA", "republicaCheca.gif"));
		paises.add(new PaisDto("REPUBLICA DOMINICANA", "republicaDominicana.gif"));
		paises.add(new PaisDto("RUMANIA", "rumania.gif"));
		paises.add(new PaisDto("RUSIA", "rusia.gif"));
		paises.add(new PaisDto("SAN MARINO", "san marino.gif"));
		paises.add(new PaisDto("SERBIA", "serbia.gif"));
		paises.add(new PaisDto("SUDAFRICA", "sudafrica.gif"));
		paises.add(new PaisDto("SUECIA", "suecia.gif"));
		paises.add(new PaisDto("SUIZA", "suiza.gif"));
		paises.add(new PaisDto("SURINAM", "surinam.gif"));
		paises.add(new PaisDto("TAILANDIA", "tailanda.gif"));
		paises.add(new PaisDto("TRINIDAD Y TOBAGO", "trinidadTobago.gif"));
		paises.add(new PaisDto("UCRANIA", "ucrania.gif"));
		paises.add(new PaisDto("URUGUAY", "uruguay.gif"));
		paises.add(new PaisDto("ESTADOS UNIDOS", "usa.gif"));
		paises.add(new PaisDto("VENEZUELA", "venezuela.gif"));
		paises.add(new PaisDto("VIETNAM", "vietnam.gif"));
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

				for (PaisDto p : paises) {
					if (p.getNombre().equals(submittedValue)) {
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
			return String.valueOf(((PaisDto) value).getNombre());
		}
	}


}
