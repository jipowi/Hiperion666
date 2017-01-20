/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.primefaces.event.FlowEvent;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,May 4, 2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class EquipoElectronicoWizard {

	private DeducibleEquipoElectronicoBean deducible = new DeducibleEquipoElectronicoBean();

	private static Logger logger = Logger.getLogger(EquipoElectronicoWizard.class.getName());
	private boolean skip;

	/**
	 * @return the deducible
	 */
	public DeducibleEquipoElectronicoBean getDeducible() {
		return deducible;
	}

	/**
	 * @param deducible
	 *            the deducible to set
	 */
	public void setDeducible(DeducibleEquipoElectronicoBean deducible) {
		this.deducible = deducible;
	}

	/**
	 * @return the skip
	 */
	public boolean isSkip() {
		return skip;
	}

	/**
	 * @param skip
	 *            the skip to set
	 */
	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		logger.info("Current wizard step:" + event.getOldStep());
		logger.info("Next step:" + event.getNewStep());

		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}
}
