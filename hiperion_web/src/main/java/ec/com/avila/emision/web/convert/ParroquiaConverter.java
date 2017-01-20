/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.convert;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ec.com.avila.emision.web.backings.DireccionBacking;
import ec.com.avila.hiperion.dto.ParroquiaDTO;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author DARVIN
 * @version 1.0,06/07/2014
 * @since JDK1.6
 */
@FacesConverter("parroquiaConvert")
public class ParroquiaConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			DireccionBacking direccionBacking = (DireccionBacking) fc.getViewRoot().getViewMap().get("direccionBacking");
			List<ParroquiaDTO> parroquiasDto = direccionBacking.getParroquiasDTO();
			for (ParroquiaDTO parroquiaDto : parroquiasDto) {
				if (parroquiaDto.getCodParroquia() == Integer.parseInt(value)) {
					return parroquiaDto;
				}
			}
		}

		return null;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((ParroquiaDTO) object).getCodParroquia());
		} else {
			return null;
		}
	}
}
