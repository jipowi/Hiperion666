package ec.com.avila.emision.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;
import ec.com.avila.hiperion.web.util.StringField;

/**
 * <b> Validador para el formato de un m�mero de RUC. </b>
 * 
 * @author gyandun
 * @version 1.0,12/07/2012
 * @since JDK1.6
 */
@FacesValidator("validatorRUC")
public class ValidatorRuc implements javax.faces.validator.Validator {

	// Unica instancia de la clase
	private static final ValidatorRuc INSTANCIA = new ValidatorRuc();

	public static ValidatorRuc getInstancia() {
		return INSTANCIA;
	}

	/**
	 * Funcion q permite validar un ruc en ecuador
	 * 
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
		String ruc = null;

		if (object instanceof String) {
			ruc = (String) object;
		} else if (object instanceof StringField) {
			ruc = (String) ((StringField) object).getValue();
		}

		if (ruc.length() == 10 || ruc.length() == 13) {

			// log.info("EL VALOR DEL RUC FUE: "+ruc);

			// si el RUC no es valido para una empresa ecuatoriana
			if (ruc != null && !validateRUC(ruc)) {
				FacesMessage message = new FacesMessage();
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensage.error.numeroRUCNoValido ") + ruc);
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		} else {
			FacesMessage message = new FacesMessage();
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensage.error.identificacionNoValido ") + ruc);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

	}

	/**
	 * Valida si un n&uacute;mero de RUC es v&aacute;lido
	 * 
	 * @param ruc
	 *            N&uacute;mero de RUC a validar.
	 * @return
	 */
	public boolean validateRUC(String ruc) {
		return !validateTipoRUC(ruc).equals("NO_VALIDA");
	}

	/**
	 * <b> Valida el tipo de Ruc a devolver. </b>
	 * <p>
	 * [Author: gyandun, Date: 12/07/2012]
	 * </p>
	 * 
	 * @param ruc
	 * @return
	 */
	public String validateTipoRUC(String ruc) {
		Integer suma = 0;
		Integer ayuda = 0;
		Integer P1, P2, P3, P4, P5, P6, P7, P8, P9, P10;

		/*
		 * if (!ruc.matches("^[0-2][0-9]{9}001$") ){ return TipoEmpresaEnum.NOVALIDA; } if(ruc.startsWith("00")){ return TipoEmpresaEnum.NOVALIDA; }
		 */

		// Empresas Publicas
		if (ruc.substring(2, 3).equals("6")) {
			P1 = Integer.parseInt(ruc.substring(0, 1)) * 3;
			P2 = Integer.parseInt(ruc.substring(1, 2)) * 2;
			P3 = Integer.parseInt(ruc.substring(2, 3)) * 7;
			P4 = Integer.parseInt(ruc.substring(3, 4)) * 6;
			P5 = Integer.parseInt(ruc.substring(4, 5)) * 5;
			P6 = Integer.parseInt(ruc.substring(5, 6)) * 4;
			P7 = Integer.parseInt(ruc.substring(6, 7)) * 3;
			P8 = Integer.parseInt(ruc.substring(7, 8)) * 2;
			P9 = Integer.parseInt(ruc.substring(8, 9));

			suma = P1 + P2 + P3 + P4 + P5 + P6 + P7 + P8;

			if (suma % 11 == 0) {
				ayuda = 0;
			} else {
				ayuda = 11 - (suma % 11);
			}

			if (P9 == ayuda) {
				return "PUBLICA";
			}
		}

		// Empresas Privadas
		if ("789".indexOf(ruc.substring(2, 3)) >= 0) {
			P1 = Integer.parseInt(ruc.substring(0, 1)) * 4;
			P2 = Integer.parseInt(ruc.substring(1, 2)) * 3;
			P3 = Integer.parseInt(ruc.substring(2, 3)) * 2;
			P4 = Integer.parseInt(ruc.substring(3, 4)) * 7;
			P5 = Integer.parseInt(ruc.substring(4, 5)) * 6;
			P6 = Integer.parseInt(ruc.substring(5, 6)) * 5;
			P7 = Integer.parseInt(ruc.substring(6, 7)) * 4;
			P8 = Integer.parseInt(ruc.substring(7, 8)) * 3;
			P9 = Integer.parseInt(ruc.substring(8, 9)) * 2;
			P10 = Integer.parseInt(ruc.substring(9, 10));

			suma = P1 + P2 + P3 + P4 + P5 + P6 + P7 + P8 + P9;

			if (suma % 11 == 0) {
				ayuda = 0;
			} else {
				ayuda = 11 - (suma % 11);
			}
			if (P10 == ayuda) {
				return "PRIVADA";
			}
		}
		// Empresa Naturales
		if ("012345".indexOf(ruc.substring(2, 3)) >= 0) {
			if (ValidatorCedula.getInstancia().validateCedula(ruc.substring(0, 10))) {
				return "NATURAL";
			}
		}

		return "NO_VALIDA";
	}
}
