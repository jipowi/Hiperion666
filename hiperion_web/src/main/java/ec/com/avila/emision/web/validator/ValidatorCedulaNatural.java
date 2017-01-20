
package ec.com.avila.emision.web.validator;

import java.text.MessageFormat;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.StringField;

/**
 * 
 * <b> Validador para el formato de un numero de cedula para una persona natural </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Apr 9, 2014
 * @since JDK1.6
 */
@FacesValidator("validatorCedulaNatural")
public class ValidatorCedulaNatural implements javax.faces.validator.Validator {

	/**
	 * Funcion que permite validar un ruc de una persona Natural en Ecuador
	 */
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
		String cedula = null;

		if (object instanceof String) {
			cedula = (String) object;
		} else if (object instanceof StringField) {
			cedula = (String) ((StringField) object).getValue();
		}

		if (cedula.length() == 10) {
			
			if (cedula != null && !validateCedula(cedula)) {
				FacesMessage message = new FacesMessage();
				message.setSummary(MessageFormat.format(HiperionMensajes.getInstancia().getString("hiperion.mensage.error.numeroCedulaNoValida"), cedula));
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		} else {
			FacesMessage message = new FacesMessage();
			message.setSummary(MessageFormat.format(HiperionMensajes.getInstancia().getString("hiperion.mensage.error.tamanioCedula"), cedula));
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

	}

	/**
	 * Valida si un numero de cedula es valido
	 * 
	 * @param ruc
	 *            Numero de cedula a validar.
	 * @return
	 */
	public boolean validateCedula(String cedula) {
		return !validateTipoCedula(cedula).equals("NO_VALIDA");
	}

	/**
	 * 
	 * <b> Valida el tipo de cedula a devolver. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Apr 9, 2014]
	 * </p>
	 * 
	 * @param ruc
	 * @return
	 */
	public String validateTipoCedula(String cedula) {

		if ("012345".indexOf(cedula.substring(2, 3)) >= 0) {
			if (ValidatorCedula.getInstancia().validateCedula(cedula.substring(0, 10))) {
				return "NATURAL";
			}
		}

		return "NO_VALIDA";
	}
}
