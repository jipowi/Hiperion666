/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import ec.com.avila.emision.web.beans.DetalleAnexoBean;

/**
 * <b>Permite seleccionar una o varias Coberturas en la p&acute;ginas web que requieran esta selecci&oacute;n.</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,09/03/2014
 * @since JDK1.6
 */
public class AnexosDataModel extends ListDataModel<DetalleAnexoBean> implements SelectableDataModel<DetalleAnexoBean> {

	public AnexosDataModel() {
	}

	public AnexosDataModel(List<DetalleAnexoBean> anexos) {
		super(anexos);
	}

	@SuppressWarnings("unchecked")
	public DetalleAnexoBean getRowData(String rowKey) {
		List<DetalleAnexoBean> anexos = (List<DetalleAnexoBean>) getWrappedData();
		for (DetalleAnexoBean anexo : anexos) {
			String idAnexo = String.valueOf(anexo.getIdAnexo());
			if (idAnexo.equals(rowKey)) {
				return anexo;
			}
		}

		return null;
	}

	public Object getRowKey(DetalleAnexoBean object) {
		return object.getIdAnexo();
	}
}
