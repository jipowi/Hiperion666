/**
 * 
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddRcDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.ObjAsegResponsabilidadDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoResponsabilidadCivilDao;
import ec.com.avila.hiperion.emision.entities.ClausulasAddResp;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.ObjAsegResponsabilidad;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoResponsabilidadCivil;
import ec.com.avila.hiperion.servicio.RamoResponsabilidadCivilService;

/**
 * <b> Permite implementar las operaciones necesarias para el ramo de responsabilidad civil </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,03/08/2014
 * @since JDK1.6
 */
@Stateless
public class RamoResponsabilidadCivilServiceImpl implements RamoResponsabilidadCivilService {

	@EJB
	private RamoResponsabilidadCivilDao ramoResponsabilidadCivilDao;
	@EJB
	private ObjAsegResponsabilidadDao objAsegResponsabilidadDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;
	@EJB
	private ClausulaAddRcDao clausulaAddRcDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoResponsabilidadCivilService#guardarRamoResponsabilidadCivil(ec.com.avila.hiperion.emision.entities.RamoResponsabilidadCivil)
	 */
	@Override
	public void guardarRamoResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil, Poliza poliza) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}

		polizaDao.persist(poliza);

		ramoResponsabilidadCivil.setPoliza(poliza);

		ramoResponsabilidadCivilDao.persist(ramoResponsabilidadCivil);
		for (ObjAsegResponsabilidad objeto : ramoResponsabilidadCivil.getObjAsegResponsabilidads()) {
			objAsegResponsabilidadDao.persist(objeto);
		}

		for (ClausulasAddResp clausula : ramoResponsabilidadCivil.getClausulasAddResps()) {
			clausula.setRamoResponsabilidadCivil(ramoResponsabilidadCivil);
			clausulaAddRcDao.persist(clausula);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoResponsabilidadCivilService#consultarRamoResponsabilidadCivil()
	 */
	@Override
	public List<RamoResponsabilidadCivil> consultarRamoResponsabilidadCivil() throws HiperionException {
		return ramoResponsabilidadCivilDao.findAll();
	}

}
