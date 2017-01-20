/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ec.com.avila.emision.web.domain.ClausulaAdicional;
import ec.com.avila.emision.web.domain.Cobertura;
import ec.com.avila.emision.web.domain.CondicionEspecial;
import ec.com.avila.hiperion.entities.DetalleAnexo;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza.
 * @version 1.0,31/05/2014
 * @since JDK1.6
 */
@ManagedBean
@ApplicationScoped
public class AnexosRamoBean {

	private List<ClausulaAdicional> clausulasAdicionales;
	private List<Cobertura> coberturas;
	private List<CondicionEspecial> condicionesEspeciales;

	/**
	 * 
	 * <b> Permite obtener las Clausulas Adicionales del Anexo de una Ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/05/2014]
	 * </p>
	 * 
	 * @return
	 */
	public List<ClausulaAdicional> obtenerClausulasAdicionales(List<DetalleAnexo> anexos) {
		clausulasAdicionales = new ArrayList<ClausulaAdicional>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					clausulasAdicionales.add(new ClausulaAdicional(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
				}
			}
		}

		return clausulasAdicionales;
	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas del Anexo de un Ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public List<Cobertura> obtenerCoberturas(List<DetalleAnexo> anexos) {
		coberturas = new ArrayList<Cobertura>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2)
					coberturas.add(new Cobertura(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}
		}

		return coberturas;
	}

	/**
	 * 
	 * <b> Permite obtener las Condiciones Especiales del Anexo de un Ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public List<CondicionEspecial> obtenerCondicionesEspeciales(List<DetalleAnexo> anexos) {
		condicionesEspeciales = new ArrayList<CondicionEspecial>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3)
					condicionesEspeciales.add(new CondicionEspecial(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}
		}

		return condicionesEspeciales;
	}
}
