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
import ec.com.avila.hiperion.dto.CantonDTO;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author DARVIN
 * @version 1.0,06/07/2014
 * @since JDK1.6
 */
@FacesConverter("cantonConverter")
public class CantonConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			DireccionBacking direccionBacking = (DireccionBacking) fc.getViewRoot().getViewMap().get("direccionBacking");
			List<CantonDTO> cantonesDto = direccionBacking.getCantonesDTO();
			for (CantonDTO cantonDto : cantonesDto) {
				if (cantonDto.getCodCanton() == Integer.parseInt(value)) {
					return cantonDto;
				}
			}
		}

		return null;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((CantonDTO) object).getCodCanton());
		} else {
			return null;
		}
	}
}
