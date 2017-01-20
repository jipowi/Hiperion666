/**
 * 
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClausulaAddAgroDao;
import ec.com.avila.hiperion.dao.CoberturaAgroDao;
import ec.com.avila.hiperion.dao.DetalleAnexoDao;
import ec.com.avila.hiperion.dao.FinanciamientoDao;
import ec.com.avila.hiperion.dao.ObjAsegAgropecuarioDao;
import ec.com.avila.hiperion.dao.PagoPolizaDao;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.dao.RamoAgropecuarioDao;
import ec.com.avila.hiperion.emision.entities.ArchivoBase;
import ec.com.avila.hiperion.emision.entities.ClausulasAddAgro;
import ec.com.avila.hiperion.emision.entities.CobertAgro;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.ObjAsegAgropecuario;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;
import ec.com.avila.hiperion.servicio.RamoAgropecuarioService;

/**
 * <b>Permite implementar los metodos de las interfaces y llamar a los metodos del DAO</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Jul 15, 2014
 * @since JDK1.6
 */
@Stateless
public class RamoAgropecuarioServiceImpl implements RamoAgropecuarioService {

	@EJB
	private RamoAgropecuarioDao ramoAgropecuarioDao;
	@EJB
	private ObjAsegAgropecuarioDao objAsegAgropecuarioDao;
	@EJB
	private ClausulaAddAgroDao clausulaAddAgroDao;
	@EJB
	private CoberturaAgroDao coberturaAgroDao;
	@EJB
	private DetalleAnexoDao detalleAnexoDao;
	@EJB
	private PolizaDao polizaDao;
	@EJB
	private PagoPolizaDao pagoPolizaDao;
	@EJB
	private FinanciamientoDao financiamientoDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoAgropecuarioService#guardarAgropecuario(ec.com.avila.hiperion.emision.entities.RamoAgropecuario)
	 */
	@Override
	public void guardarAgropecuario(RamoAgropecuario ramoAgropecuario, Poliza poliza) throws HiperionException {

		PagoPoliza pagoPoliza = poliza.getPagoPoliza();
		pagoPolizaDao.persist(pagoPoliza);

		for (Financiamiento financiamiento : pagoPoliza.getFinanciamientos()) {
			financiamiento.setPagoPoliza(pagoPoliza);
			financiamientoDao.persist(financiamiento);
		}
		
		polizaDao.persist(poliza);

		ramoAgropecuario.setPoliza(poliza);

		ramoAgropecuarioDao.persist(ramoAgropecuario);

		for (ObjAsegAgropecuario objeto : ramoAgropecuario.getObjAsegAgropecuarios()) {
			objeto.setRamoAgropecuario(ramoAgropecuario);
			objAsegAgropecuarioDao.persist(objeto);
		}

		for (ClausulasAddAgro clausula : ramoAgropecuario.getClausulasAddAgros()) {
			clausula.setRamoAgropecuario(ramoAgropecuario);
			clausulaAddAgroDao.persist(clausula);
		}

		for (CobertAgro cobertura : ramoAgropecuario.getCobertAgros()) {
			cobertura.setRamoAgropecuario(ramoAgropecuario);
			coberturaAgroDao.persist(cobertura);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoAgropecuarioService#guardarArchivoPoliza(ec.com.avila.hiperion.emision.entities.ArchivoBase)
	 */
	@Override
	public void guardarArchivoPoliza(ArchivoBase file) throws HiperionException {
		ramoAgropecuarioDao.guardarArchivoPoliza(file);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoAgropecuarioService#consultarDetalleAnexoById(java.lang.Long)
	 */
	@Override
	public DetalleAnexo consultarDetalleAnexoById(Long idDetalle) throws HiperionException {
		return detalleAnexoDao.findById(idDetalle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoAgropecuarioService#consultarDetallesByTitulo(java.lang.Long, java.lang.Integer)
	 */
	@Override
	public List<DetalleAnexo> consultarDetallesByTitulo(Long idRamo, Long idTitulo) throws HiperionException {
		return detalleAnexoDao.consultarDetallesByTitulo(idRamo, idTitulo);
	}

}
