/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

/**
 * <b> Permite desplegar la lista de paises en un combo </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Apr 13, 2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class AutoCompleteBean {

	private String txt;

	private PaisesBean selectedPais;

	private List<PaisesBean> paises;

	public AutoCompleteBean() {
		paises = new ArrayList<PaisesBean>();

		paises.add(new PaisesBean("ALBANIA", "albania.gif"));
		paises.add(new PaisesBean("ALEMANIA", "alemania.gif"));
		paises.add(new PaisesBean("ANGUILA", "anguila.gif"));
		paises.add(new PaisesBean("ARABIA SAUDITA", "arabiaSaudita.gif"));
		paises.add(new PaisesBean("ARGENTINA", "argentina.gif"));
		paises.add(new PaisesBean("AUSTRALIA", "australia.gif"));
		paises.add(new PaisesBean("AUSTRIA", "austria.gif"));
		paises.add(new PaisesBean("BAHAMAS", "bahamas.gif"));
		paises.add(new PaisesBean("BANGLADESH", "bangladesh.gif"));
		paises.add(new PaisesBean("BARBADOS", "barbados.gif"));
		paises.add(new PaisesBean("BELGICA", "belgica.gif"));
		paises.add(new PaisesBean("BELICE", "belice.gif"));
		paises.add(new PaisesBean("BERMUDAS","bermuda.gif"));
		paises.add(new PaisesBean("BOSNIA", "bosnia.gif"));
		paises.add(new PaisesBean("BRASIL", "brasil.gif"));
		paises.add(new PaisesBean("BULGARIA", "bulgaria.gif"));
		paises.add(new PaisesBean("CAMERUN", "camerun.gif"));
		paises.add(new PaisesBean("CANADA", "canada.gif"));
		paises.add(new PaisesBean("CHILE", "chile.gif"));
		paises.add(new PaisesBean("CHINA", "china.gif"));
		paises.add(new PaisesBean("CHIPRE", "chipre.gif"));
		paises.add(new PaisesBean("COLOMBIA", "colombia.gif"));
		paises.add(new PaisesBean("COREA DEL SUR", "coreaDelSur.gif"));
		paises.add(new PaisesBean("COREA DEL NORTE", "corenaDelNorte.gif"));
		paises.add(new PaisesBean("COSTA RICA", "costaRica.gif"));
		paises.add(new PaisesBean("CROACIA", "croacia.gif"));
		paises.add(new PaisesBean("CUBA", "cuba.gif"));
		paises.add(new PaisesBean("DINAMARCA", "dinamarca.gif"));
		paises.add(new PaisesBean("DOMINICA", "dominica.gif"));
		paises.add(new PaisesBean("ECUADOR", "ecuador.gif"));
		paises.add(new PaisesBean("EGIPTO", "egipto.gif"));
		paises.add(new PaisesBean("EL SALVADOR", "elSalvador.gif"));
		paises.add(new PaisesBean("ESCOCIA", "escocia.gif"));
		paises.add(new PaisesBean("ESLOVAQUIA", "eslovaquia.gif"));
		paises.add(new PaisesBean("ESLOVENIA", "eslovenia.gif"));
		paises.add(new PaisesBean("ESPAÑA", "españa.gif"));
		paises.add(new PaisesBean("ESTONIA", "estonia.gif"));
		paises.add(new PaisesBean("FINLANDIA", "finlandia.gif"));
		paises.add(new PaisesBean("FRANCIA", "francia.gif"));
		paises.add(new PaisesBean("GALES", "gales.gif"));
		paises.add(new PaisesBean("GILBRALTAR", "gilbraltar.gif"));
		paises.add(new PaisesBean("GRECIA", "grecia.gif"));
		paises.add(new PaisesBean("GUYANA FRANCESA", "guyanaFrancesa.gif"));
		paises.add(new PaisesBean("GUYANA", "guyana.gif"));
		paises.add(new PaisesBean("HAITI", "haiti.gif"));
		paises.add(new PaisesBean("HONDURAS", "honduras.gif"));
		paises.add(new PaisesBean("HUNGRIA", "hungria.gif"));
		paises.add(new PaisesBean("INGLATERRA", "inglaterra.gif"));
		paises.add(new PaisesBean("IRLANDA", "irlanda.gif"));
		paises.add(new PaisesBean("ISLANDIA", "islandia.gif"));
		paises.add(new PaisesBean("ISRAEL", "israel.gif"));
		paises.add(new PaisesBean("ITALIA", "italia.gif"));
		paises.add(new PaisesBean("JAMAICA", "jamaica.gif"));
		paises.add(new PaisesBean("JAPON", "japon.gif"));
		paises.add(new PaisesBean("LETONIA", "letonia.gif"));
		paises.add(new PaisesBean("MEXICO", "mexico.gif"));
		paises.add(new PaisesBean("NIGARAGUA", "nicaragua.gif"));
		paises.add(new PaisesBean("NIGERIA", "nigeria.gif"));
		paises.add(new PaisesBean("NORUEGA","noruega.gif"));
		paises.add(new PaisesBean("NUEVA ZELANDA", "nuevaZelandia.gif"));
		paises.add(new PaisesBean("PAISES BAJOS", "paisesBajos.gif"));
		paises.add(new PaisesBean("PANAMA", "panama.gif"));
		paises.add(new PaisesBean("PANAMA", "paraguay.gif"));
		paises.add(new PaisesBean("PERU", "peru.gif"));
		paises.add(new PaisesBean("PORTUGAL", "portugal.gif"));
		paises.add(new PaisesBean("PUERTO RICO", "puerto rico.gif"));
		paises.add(new PaisesBean("QATAR", "qatar.gif"));
		paises.add(new PaisesBean("REPUBLICA CHECA", "republicaCheca.gif"));
		paises.add(new PaisesBean("REPUBLICA DOMINICANA", "republicaDominicana.gif"));
		paises.add(new PaisesBean("RUMANIA", "rumania.gif"));
		paises.add(new PaisesBean("RUSIA", "rusia.gif"));
		paises.add(new PaisesBean("SAN MARINO", "san marino.gif"));
		paises.add(new PaisesBean("SERBIA", "serbia.gif"));
		paises.add(new PaisesBean("SUDAFRICA", "sudafrica.gif"));
		paises.add(new PaisesBean("SUECIA", "suecia.gif"));
		paises.add(new PaisesBean("SUIZA", "suiza.gif"));
		paises.add(new PaisesBean("SURINAM", "surinam.gif"));
		paises.add(new PaisesBean("TAILANDIA", "tailanda.gif"));
		paises.add(new PaisesBean("TRINIDAD Y TOBAGO", "trinidadTobago.gif"));
		paises.add(new PaisesBean("UCRANIA", "ucrania.gif"));
		paises.add(new PaisesBean("URUGUAY", "uruguay.gif"));
		paises.add(new PaisesBean("ESTADOS UNIDOS", "usa.gif"));
		paises.add(new PaisesBean("VENEZUELA", "venezuela.gif"));
		paises.add(new PaisesBean("VIETNAM", "vietnam.gif"));
	}

	/**
	 * @return the selectedPais
	 */
	public PaisesBean getSelectedPais() {
		return selectedPais;
	}

	/**
	 * @param selectedPais
	 *            the selectedPais to set
	 */
	public void setSelectedPais(PaisesBean selectedPais) {
		this.selectedPais = selectedPais;
	}

	/**
	 * @return the paises
	 */
	public List<PaisesBean> getPaises() {
		return paises;
	}

	/**
	 * @param paises
	 *            the paises to set
	 */
	public void setPaises(List<PaisesBean> paises) {
		this.paises = paises;
	}

	public List<String> complete(String query) {
		List<String> results = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			results.add(query + i);
		}

		return results;
	}

	public List<PaisesBean> completePaises(String query) {
		List<PaisesBean> suggestions = new ArrayList<PaisesBean>();

		for (PaisesBean p : paises) {
			if (p.getNombre().startsWith(query))
				suggestions.add(p);
		}

		return suggestions;
	}

	public void handleSelect(SelectEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected:" + event.getObject().toString(), null);

		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * @return the txt
	 */
	public String getTxt() {
		return txt;
	}

	/**
	 * @param txt
	 *            the txt to set
	 */
	public void setTxt(String txt) {
		this.txt = txt;
	}

}
