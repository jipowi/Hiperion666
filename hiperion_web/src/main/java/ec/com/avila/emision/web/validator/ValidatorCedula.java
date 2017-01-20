package ec.com.avila.emision.web.validator;

import java.text.MessageFormat;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.commons.lang.StringUtils;

import ec.com.avila.hiperion.web.util.HiperionMensajes;

/**
 * 
 * <b> Permite validar el numero de cedula </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,13/01/2015
 * @since JDK1.6
 */
@FacesValidator("validatorCedula")
public class ValidatorCedula implements Validator {
	// Unica instancia de la clase
	private static final ValidatorCedula INSTANCIA = new ValidatorCedula();

	public static ValidatorCedula getInstancia() {
		return INSTANCIA;
	}

	/*
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
		String CI = (String) object;
		if (!(validateCedula(CI))) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			if (!StringUtils.isNumeric(CI)) {
				message.setSummary(MessageFormat.format(HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.campoNumerico"), "C�dula"));
			} else if (CI.length() != 10) {
				message.setSummary(HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.longitudCI"));
			} else {
				message.setSummary("Cedula " + CI + " no valida");
			}
			throw new ValidatorException(message);
		}
	}

	/**
	 * <b>Valida si una cedula es o no valida.</b>
	 * <p>
	 * [Author: gyandun, Date: 12/07/2012]
	 * </p>
	 * 
	 * @param cedula
	 * @return
	 */
	public boolean validateCedula(String cedula) {
		boolean result = false;
		int suma = 0;
		int ayuda;
		if (cedula.length() != 10)
			result = false;
		else {
			try {
				int i = 0;
				while (i < cedula.length() - 1) {

					if (i % 2 == 0) {
						ayuda = Integer.parseInt(cedula.substring(i, i + 1)) * 2;
						if (ayuda >= 10)
							ayuda -= 9;
						suma = suma + ayuda;
					} else {
						suma = suma + Integer.parseInt(cedula.substring(i, i + 1));
					}
					i++;
				}
				if (Integer.parseInt(cedula.substring(0, 1)) < 1 || Integer.parseInt(cedula.substring(0, 1)) > 22) {
					result = false;
				}
			} catch (NumberFormatException e) {
				result = false;
			}
			int val = 0;
			for (int j = 0; j < 100; j += 10) {
				if (suma >= j && suma < (j + 10)) {
					val = j += 10;
					break;
				}
			}
			try {
				if (Integer.parseInt(cedula.substring(9)) != (val - suma) && Integer.parseInt(cedula.substring(9)) != (val - (suma + 10)))
					result = false;
				else
					result = true;
			} catch (NumberFormatException e) {
				result = false;
			}
		}
		return result;
	}
}
