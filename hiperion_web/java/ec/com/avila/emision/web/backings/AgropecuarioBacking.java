/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ec.com.avila.emision.web.beans.DetalleAnexoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.DetalleAnexo;
import ec.com.avila.hiperion.entities.Ramo;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.model.AnexosDataModel;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Agropecuario. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class AgropecuarioBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private RamoService ramoService;

	private AnexosDataModel anexosDataModel;
	private List<DetalleAnexo> anexos;

	private List<DetalleAnexoBean> clausulasAdicionales;
	private List<DetalleAnexoBean> coberturasTransporte;
	private List<DetalleAnexoBean> coberturasVida;
	private DetalleAnexoBean[] selectClausulasAdicionales;
	private DetalleAnexoBean[] selectCoberturasTransporte;
	private DetalleAnexoBean[] selectCoberturasVida;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@PostConstruct
	public void inicializar() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("AGP");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Clausulas Adicionales del Ramo Accidentes Personales. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerClausulasAdicionales() {
		clausulasAdicionales = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1)
					clausulasAdicionales.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(clausulasAdicionales);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: DARVIN, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCoberturasTransporte() {
		coberturasTransporte = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2 && anexo.getTitulo().getIdTitulo() == 1)
					coberturasTransporte.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(coberturasTransporte);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: DARVIN, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCoberturasVida() {
		coberturasVida = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2 && anexo.getTitulo().getIdTitulo() == 2)
					coberturasVida.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(coberturasVida);
		}

		return anexosDataModel;
	}

	public void guardar() {
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * @return the selectClausulasAdicionales
	 */
	public DetalleAnexoBean[] getSelectClausulasAdicionales() {
		return selectClausulasAdicionales;
	}

	/**
	 * @param selectClausulasAdicionales
	 *            the selectClausulasAdicionales to set
	 */
	public void setSelectClausulasAdicionales(DetalleAnexoBean[] selectClausulasAdicionales) {
		this.selectClausulasAdicionales = selectClausulasAdicionales;
	}

	/**
	 * @return the selectCoberturasTransporte
	 */
	public DetalleAnexoBean[] getSelectCoberturasTransporte() {
		return selectCoberturasTransporte;
	}

	/**
	 * @param selectCoberturasTransporte
	 *            the selectCoberturasTransporte to set
	 */
	public void setSelectCoberturasTransporte(DetalleAnexoBean[] selectCoberturasTransporte) {
		this.selectCoberturasTransporte = selectCoberturasTransporte;
	}

	/**
	 * @return the selectCoberturasVida
	 */
	public DetalleAnexoBean[] getSelectCoberturasVida() {
		return selectCoberturasVida;
	}

	/**
	 * @param selectCoberturasVida
	 *            the selectCoberturasVida to set
	 */
	public void setSelectCoberturasVida(DetalleAnexoBean[] selectCoberturasVida) {
		this.selectCoberturasVida = selectCoberturasVida;
	}
}
