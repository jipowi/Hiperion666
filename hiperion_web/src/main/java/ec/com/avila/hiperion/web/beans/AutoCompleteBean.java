/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
@ViewScoped
public class AutoCompleteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MarcasDto selectedMarcaLiviano;
	private MarcasDto selectedMarcaPesado;
	private MarcasDto selectedMarcaMoto;
	private MarcasDto selectedPais;

	private List<MarcasDto> marcasLivianos;
	private List<MarcasDto> marcasPesados;
	private List<MarcasDto> marcasMotos;
	private List<PaisDto> paises;

	public AutoCompleteBean() {
		marcasLivianos = MarcasConverter.marcasLivianos;
		marcasPesados = MarcasConverter.marcasPesados;
		marcasMotos = MarcasConverter.marcasMotos;
		paises = PaisConverter.paises;
	}

	public List<String> complete(String query) {
		List<String> results = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			results.add(query + i);
		}

		return results;
	}

	public List<MarcasDto> completeMarcaLivianos(String query) {
		List<MarcasDto> suggestions = new ArrayList<MarcasDto>();

		for (MarcasDto p : marcasLivianos) {
			if (p.getMarca().startsWith(query))
				suggestions.add(p);
		}

		return suggestions;
	}

	public List<MarcasDto> completeMarcaPesados(String query) {
		List<MarcasDto> suggestions = new ArrayList<MarcasDto>();

		for (MarcasDto p : marcasPesados) {
			if (p.getMarca().startsWith(query))
				suggestions.add(p);
		}

		return suggestions;
	}

	public List<MarcasDto> completeMarcaMotos(String query) {
		List<MarcasDto> suggestions = new ArrayList<MarcasDto>();

		for (MarcasDto p : marcasMotos) {
			if (p.getMarca().startsWith(query))
				suggestions.add(p);
		}

		return suggestions;
	}

	public List<PaisDto> completePaises(String query) {
		List<PaisDto> suggestions = new ArrayList<PaisDto>();

		for (PaisDto p : paises) {
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
	 * @return the selectedMarcaLiviano
	 */
	public MarcasDto getSelectedMarcaLiviano() {
		return selectedMarcaLiviano;
	}

	/**
	 * @param selectedMarcaLiviano
	 *            the selectedMarcaLiviano to set
	 */
	public void setSelectedMarcaLiviano(MarcasDto selectedMarcaLiviano) {
		this.selectedMarcaLiviano = selectedMarcaLiviano;
	}

	/**
	 * @return the selectedMarcaPesado
	 */
	public MarcasDto getSelectedMarcaPesado() {
		return selectedMarcaPesado;
	}

	/**
	 * @param selectedMarcaPesado
	 *            the selectedMarcaPesado to set
	 */
	public void setSelectedMarcaPesado(MarcasDto selectedMarcaPesado) {
		this.selectedMarcaPesado = selectedMarcaPesado;
	}

	/**
	 * @return the selectedMarcaMoto
	 */
	public MarcasDto getSelectedMarcaMoto() {
		return selectedMarcaMoto;
	}

	/**
	 * @param selectedMarcaMoto
	 *            the selectedMarcaMoto to set
	 */
	public void setSelectedMarcaMoto(MarcasDto selectedMarcaMoto) {
		this.selectedMarcaMoto = selectedMarcaMoto;
	}

	/**
	 * @return the selectedPais
	 */
	public MarcasDto getSelectedPais() {
		return selectedPais;
	}

	/**
	 * @param selectedPais
	 *            the selectedPais to set
	 */
	public void setSelectedPais(MarcasDto selectedPais) {
		this.selectedPais = selectedPais;
	}

	/**
	 * @return the marcasLivianos
	 */
	public List<MarcasDto> getMarcasLivianos() {
		return marcasLivianos;
	}

	/**
	 * @param marcasLivianos
	 *            the marcasLivianos to set
	 */
	public void setMarcasLivianos(List<MarcasDto> marcasLivianos) {
		this.marcasLivianos = marcasLivianos;
	}

	/**
	 * @return the marcasPesados
	 */
	public List<MarcasDto> getMarcasPesados() {
		return marcasPesados;
	}

	/**
	 * @param marcasPesados
	 *            the marcasPesados to set
	 */
	public void setMarcasPesados(List<MarcasDto> marcasPesados) {
		this.marcasPesados = marcasPesados;
	}

	/**
	 * @return the marcasMotos
	 */
	public List<MarcasDto> getMarcasMotos() {
		return marcasMotos;
	}

	/**
	 * @param marcasMotos
	 *            the marcasMotos to set
	 */
	public void setMarcasMotos(List<MarcasDto> marcasMotos) {
		this.marcasMotos = marcasMotos;
	}

	/**
	 * @return the paises
	 */
	public List<PaisDto> getPaises() {
		return paises;
	}

	/**
	 * @param paises
	 *            the paises to set
	 */
	public void setPaises(List<PaisDto> paises) {
		this.paises = paises;
	}

}
