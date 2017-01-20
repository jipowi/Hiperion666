/**
 * 
 */
package ec.com.avila.hiperion.web.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.jdom.Document;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocAgropecuario;
import ec.com.avila.hiperion.doc.servicio.GenerarDocBuenUsoAnticipo;
import ec.com.avila.hiperion.doc.servicio.GenerarDocBuenaCalidadMateriales;
import ec.com.avila.hiperion.doc.servicio.GenerarDocCascoAereo;
import ec.com.avila.hiperion.doc.servicio.GenerarDocCascoMaritimo;
import ec.com.avila.hiperion.doc.servicio.GenerarDocCumplimientoContrato;
import ec.com.avila.hiperion.doc.servicio.GenerarDocDineroValores;
import ec.com.avila.hiperion.doc.servicio.GenerarDocEquipoElectronico;
import ec.com.avila.hiperion.doc.servicio.GenerarDocEquipoMaquinaria;
import ec.com.avila.hiperion.doc.servicio.GenerarDocFidelidad;
import ec.com.avila.hiperion.doc.servicio.GenerarDocGarantiaAduanera;
import ec.com.avila.hiperion.doc.servicio.GenerarDocIncendiLineasAliadas;
import ec.com.avila.hiperion.doc.servicio.GenerarDocLuCesanIncendioLineasAliadas;
import ec.com.avila.hiperion.doc.servicio.GenerarDocLucroCesanteRoturaMaquinaria;
import ec.com.avila.hiperion.doc.servicio.GenerarDocResponsabilidadCivil;
import ec.com.avila.hiperion.doc.servicio.GenerarDocRiesgosEspeciales;
import ec.com.avila.hiperion.doc.servicio.GenerarDocRoboAsalto;
import ec.com.avila.hiperion.doc.servicio.GenerarDocRoturaMaquinaria;
import ec.com.avila.hiperion.doc.servicio.GenerarDocSoat;
import ec.com.avila.hiperion.doc.servicio.GenerarDocTodoRiesgoContratista;
import ec.com.avila.hiperion.doc.servicio.GenerarDocTodoRiesgoMontaje;
import ec.com.avila.hiperion.doc.servicio.GenerarDocTransporte;
import ec.com.avila.hiperion.doc.servicio.GenerarDocVehiculos;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;
import ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt;
import ec.com.avila.hiperion.emision.entities.RamoBuenaCalMat;
import ec.com.avila.hiperion.emision.entities.RamoCascoAereo;
import ec.com.avila.hiperion.emision.entities.RamoCascoMaritimo;
import ec.com.avila.hiperion.emision.entities.RamoCumplimientoContrato;
import ec.com.avila.hiperion.emision.entities.RamoDineroValore;
import ec.com.avila.hiperion.emision.entities.RamoEquipoElectronico;
import ec.com.avila.hiperion.emision.entities.RamoEquipoMaquinaria;
import ec.com.avila.hiperion.emision.entities.RamoFidelidad;
import ec.com.avila.hiperion.emision.entities.RamoGarantiaAduanera;
import ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada;
import ec.com.avila.hiperion.emision.entities.RamoLcIncendio;
import ec.com.avila.hiperion.emision.entities.RamoLcRotMaq;
import ec.com.avila.hiperion.emision.entities.RamoResponsabilidadCivil;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoContratista;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje;
import ec.com.avila.hiperion.emision.entities.RamoRiesgosEsp;
import ec.com.avila.hiperion.emision.entities.RamoRoboAsalto;
import ec.com.avila.hiperion.emision.entities.RamoRoturaMaquinaria;
import ec.com.avila.hiperion.emision.entities.RamoSoat;
import ec.com.avila.hiperion.emision.entities.RamoTransporte;
import ec.com.avila.hiperion.emision.entities.RamoVehiculo;
import ec.com.avila.hiperion.xsl.XSLHelper;
import ec.com.kruger.framework.common.util.TransformerUtil;

/**
 * @author jarana
 * 
 */
public class XSLUtil {

	private XSLUtil() {
	}

	private static final XSLUtil INSTANCIA = new XSLUtil();

	public static XSLUtil getInstancia() {
		return INSTANCIA;
	}

	private static final String tagInicioDocumento = "<documento>";
	private static final String tagFinDocumento = "</documento>";

	Logger log = Logger.getLogger(XSLUtil.class);

	/**
	 * 
	 * <b> Permite generar un contenido XML. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 01/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @return
	 */
	public String generarXmlAgropecuario(RamoAgropecuario agropecuario) {
		StringBuilder xml = new StringBuilder();

		try {
			xml.append(tagInicioDocumento);

			try {
				String nombreClase = "java:app/hiperion_web/AgropecuarioImpl";
				GenerarDocAgropecuario generarDocumento = (GenerarDocAgropecuario) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlAgropecuario(agropecuario));

			} catch (Exception e) {
				log.error("Error, generacion xml reporte, e{}", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {
			log.error("Error", e);

		}
		return xml.toString();
	}

	public String generarXmlGarantiaAduanera(RamoGarantiaAduanera garantiaAduanera) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);

			try {
				String nombreClase = "java:app/hiperion_web/AgropecuarioImpl";
				GenerarDocGarantiaAduanera generarDocumento = (GenerarDocGarantiaAduanera) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlGarantiaAduanera(garantiaAduanera));

			} catch (Exception e) {
				log.error("Error, generacion xml reporte, e{}", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {
			log.error("Error", e);
		}

		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite guardar un contenido XML </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 08/05/2015]
	 * </p>
	 * 
	 * @param fidelidad
	 * @return
	 */

	public String generarXmlFidelidad(RamoFidelidad fidelidad) {
		StringBuilder xml = new StringBuilder();

		try {
			xml.append(tagInicioDocumento);

			try {
				String nombreClase = "java:app/hiperion_web/FidelidadImpl";
				GenerarDocFidelidad generarDocumento = (GenerarDocFidelidad) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlFidelidad(fidelidad));

			} catch (Exception e) {
				log.error("Error, generacion xml reporte, e{}", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {
			log.error("Error", e);

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite guardar un contenido XML </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/04/2015]
	 * </p>
	 * 
	 * @param equipoElectronico
	 * @return
	 */
	public String generarXmlEquipoElectronico(RamoEquipoElectronico equipoElectronico) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);

			try {
				String nombreClase = "java:app/hiperion_web/EquipoElectronicoImpl";
				GenerarDocEquipoElectronico generarDocumento = (GenerarDocEquipoElectronico) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlEquipoElectronico(equipoElectronico));

			} catch (Exception e) {
				log.error("Error, generacion xml reporte, e{}", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {
			log.error("Error", e);
		}

		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite guardar un contenido XML </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/04/2015]
	 * </p>
	 * 
	 * @param equipoMaquinaria
	 * @return
	 */
	public String generarXmlEquipoMaquinaria(RamoEquipoMaquinaria equipoMaquinaria) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);

			try {
				String nombreClase = "java:app/hiperion_web/EquipoMaquinariaImpl";
				GenerarDocEquipoMaquinaria generarDocumento = (GenerarDocEquipoMaquinaria) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlEquipoMaquinaria(equipoMaquinaria));

			} catch (Exception e) {
				log.error("Error, generacion xml reporte, e{}", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {
			log.error("Error", e);
		}

		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar un contenedor XML </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 13/04/2015]
	 * </p>
	 * 
	 * @param buenaCalMat
	 * @return
	 */
	public String generarXmlBuenaCalMat(RamoBuenaCalMat buenaCalMat) {
		StringBuilder xml = new StringBuilder();

		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/BuenaCalidadMaterialesImpl";
				GenerarDocBuenaCalidadMateriales generarDocumento = (GenerarDocBuenaCalidadMateriales) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlBuenaCalidadMateriales(buenaCalMat));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar un contenedor XML. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 15/04/2015]
	 * </p>
	 * 
	 * @param buenUsoAnt
	 * @return
	 */
	public String generarXmlBuenUsoAnt(RamoBuenUsoAnt buenUsoAnt) {

		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/BuenUsoAnticipoImpl";
				GenerarDocBuenUsoAnticipo generarDocumento = (GenerarDocBuenUsoAnticipo) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlBuenUsoAnticipo(buenUsoAnt));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar el contenedor XML </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 25/05/2015]
	 * </p>
	 * 
	 * @param ramoRiesgosEsp
	 * @return
	 */
	public String generarXmlRiesgosEspeciales(RamoRiesgosEsp ramoRiesgosEsp) {
		StringBuilder xml = new StringBuilder();

		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/RiesgosEspecialesImpl";
				GenerarDocRiesgosEspeciales generarDocumento = (GenerarDocRiesgosEspeciales) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlRiesgosEspeciales(ramoRiesgosEsp));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}

		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar el contenedor XML </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 02/06/2015]
	 * </p>
	 * 
	 * @param ramoRiesgoContratista
	 * @return
	 */
	public String generarXmlTodoRiesgoContratista(RamoRiesgoContratista ramoRiesgoContratista) {

		StringBuilder xml = new StringBuilder();

		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/RiesgosEspecialesImpl";
				GenerarDocTodoRiesgoContratista generarDocumento = (GenerarDocTodoRiesgoContratista) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlTodoRiesgoContratista(ramoRiesgoContratista));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}

		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar el contenedor XML </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 02/06/2015]
	 * </p>
	 * 
	 * @param ramoRiesgoMontaje
	 * @return
	 */
	public String generarXmlTodoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) {

		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/TodoRiesgoMontajeImpl";
				GenerarDocTodoRiesgoMontaje generarDocumento = (GenerarDocTodoRiesgoMontaje) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlTodoRiesgoMontaje(ramoRiesgoMontaje));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}

		return xml.toString();

	}

	public String generarXmlVehiculos(RamoVehiculo ramoVehiculo) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/VehiculosImpl";
				GenerarDocVehiculos generarDocumento = (GenerarDocVehiculos) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlVehiculos(ramoVehiculo));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}

		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar el contenedor XML </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 03/06/2015]
	 * </p>
	 * 
	 * @param ramoTransporte
	 * @return
	 */
	public String generarXmlTransporte(RamoTransporte ramoTransporte) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/TransporteImpl";
				GenerarDocTransporte generarDocumento = (GenerarDocTransporte) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlTransporte(ramoTransporte));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar el contenedor XML </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 28/05/2015]
	 * </p>
	 * 
	 * @param ramoSoat
	 * @return
	 */
	public String generarXmlSoat(RamoSoat ramoSoat) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/RiesgosEspecialesImpl";
				GenerarDocSoat generarDocumento = (GenerarDocSoat) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlSoat(ramoSoat));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}

		return xml.toString();

	}

	/**
	 * 
	 * <b> Permite generar el contenedor XML </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 27/05/2015]
	 * </p>
	 * 
	 * @param ramoRoturaMaquinaria
	 * @return
	 */
	public String generarXmlRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) {
		StringBuilder xml = new StringBuilder();

		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/RiesgosEspecialesImpl";
				GenerarDocRoturaMaquinaria generarDocumento = (GenerarDocRoturaMaquinaria) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlRoturaMaquinaria(ramoRoturaMaquinaria));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}

		return xml.toString();

	}

	/**
	 * 
	 * <b> Permite generar el contenedor XML </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 25/05/2015]
	 * </p>
	 * 
	 * @param ramoRoboAsalto
	 * @return
	 */
	public String generarXmlRoboAsalto(RamoRoboAsalto ramoRoboAsalto) {

		StringBuilder xml = new StringBuilder();

		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/RoboAsaltoImpl";
				GenerarDocRoboAsalto generarDocumento = (GenerarDocRoboAsalto) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlRoboAsalto(ramoRoboAsalto));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}

		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar un contenedor XML.. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 15/04/2015]
	 * </p>
	 * 
	 * @param cascoAereo
	 * @return
	 */
	public String generarXmlCascoAereo(RamoCascoAereo cascoAereo) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/CascoAereoImpl";
				GenerarDocCascoAereo generarDocumento = (GenerarDocCascoAereo) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlCascoAereo(cascoAereo));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar un contenedor XML. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 20/04/2015]
	 * </p>
	 * 
	 * @param cascoMaritimo
	 * @return
	 */
	public String generarXmlCascoMaritimo(RamoCascoMaritimo cascoMaritimo) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/CascoAereoImpl";
				GenerarDocCascoMaritimo generarDocumento = (GenerarDocCascoMaritimo) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlCascoMaritimo(cascoMaritimo));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();

	}

	/**
	 * 
	 * <b> Permite generar un contenedor XML. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 11/05/2015]
	 * </p>
	 * 
	 * @param cumplimientoContrato
	 * @return
	 */
	public String generarXmlCumplimientoContrato(RamoCumplimientoContrato cumplimientoContrato) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/CumplimientoContratoImpl";
				GenerarDocCumplimientoContrato generarDocumento = (GenerarDocCumplimientoContrato) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlCumplimientoContrato(cumplimientoContrato));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();
	}

	public String generarXmlResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil) {

		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/CumplimientoContratoImpl";
				GenerarDocResponsabilidadCivil generarDocumento = (GenerarDocResponsabilidadCivil) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlResponsabilidadCivil(ramoResponsabilidadCivil));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}

		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar un contenedor XML </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 13/05/2015]
	 * </p>
	 * 
	 * @param ramoLcIncendio
	 * @return
	 */
	public String generarXmlLucCesIncendioLineasAliadas(RamoLcIncendio ramoLcIncendio) {

		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/LucCesanteIncendioLineasAliadasImpl";
				GenerarDocLuCesanIncendioLineasAliadas generarDocumento = (GenerarDocLuCesanIncendioLineasAliadas) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlLucCesIncendioLineasAliadas(ramoLcIncendio));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();

	}

	/**
	 * 
	 * <b> Permite generar un contenedor XML. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 12/05/2015]
	 * </p>
	 * 
	 * @param ramoLcRotMaq
	 * @return
	 */
	public String generarXmlLucroCesanteRoturaMaquinaria(RamoLcRotMaq ramoLcRotMaq) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/CumplimientoContratoImpl";
				GenerarDocLucroCesanteRoturaMaquinaria generarDocumento = (GenerarDocLucroCesanteRoturaMaquinaria) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlLucroCesanteRoturaMaquinaria(ramoLcRotMaq));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar un contenedor XML. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 11/05/2015]
	 * </p>
	 * 
	 * @param incendioLineasAliada
	 */
	public String generarXmlIncendioLineasAliada(RamoIncendioLineasAliada incendioLineasAliada) {

		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/IncendioLineasAliadasImpl";
				GenerarDocIncendiLineasAliadas generarDocumento = (GenerarDocIncendiLineasAliadas) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlIncendioLineasAliadas(incendioLineasAliada));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}

		return xml.toString();
	}

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 02/06/2015]
	 * </p>
	 * 
	 * @param dineroValore
	 * @return
	 */
	public String generarXmlDineroValores(RamoDineroValore dineroValore) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/DineroValoresImpl";
				GenerarDocDineroValores generarDocumento = (GenerarDocDineroValores) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlDineroValores(dineroValore));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Agropecuario. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 09/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @param formacionesC
	 * @param formacionesA
	 * @return
	 */
	public String obtenerHtmlAgropecuario(RamoAgropecuario agropecuario) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("AgropecuarioHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();

			}

			String contenidoXSL = sb.toString();

			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlAgropecuario(agropecuario);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);

		}

		return html;
	}

	/**
	 * 
	 * <b> Permite Obtener el HTML del ramo Garantia aduanera </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 08/05/2015]
	 * </p>
	 * 
	 * @param garantiaAduanera
	 * @return
	 */
	public String obtenerHtmlGarantiaAduanera(RamoGarantiaAduanera garantiaAduanera) {
		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("GarantiaAduaneraHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();

			}

			String contenidoXSL = sb.toString();

			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlGarantiaAduanera(garantiaAduanera);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;
	}

	/**
	 * 
	 * <b> ermite generar el HTML del Fidelidad </b>
	 * <p>
	 * [Author: Franklin Pozo B., Date: 08/05/2015]
	 * </p>
	 * 
	 * @param fidelidad
	 * @return
	 */
	public String obtenerHtmlFidelidad(RamoFidelidad fidelidad) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("FidelidadHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();

			}

			String contenidoXSL = sb.toString();

			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlFidelidad(fidelidad);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);

		}
		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Equipo Electronico </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/04/2015]
	 * </p>
	 * 
	 * @param equipoElectronico
	 * @return
	 */
	public String obtenerHtmlEquipoElectronico(RamoEquipoElectronico equipoElectronico) {

		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("EquipoElectronicoHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();

			}

			String contenidoXSL = sb.toString();

			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlEquipoElectronico(equipoElectronico);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);
		}
		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Equipo Maquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/04/2015]
	 * </p>
	 * 
	 * @param equipoMaquinaria
	 * @return
	 */
	public String obtenerHtmlEquipoMaquinaria(RamoEquipoMaquinaria equipoMaquinaria) {
		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("EquipoElectronicoHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();

			}

			String contenidoXSL = sb.toString();

			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlEquipoMaquinaria(equipoMaquinaria);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);
		}
		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Buena Calidad de Materiales. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 13/04/2015]
	 * </p>
	 * 
	 * @param buenaCalMat
	 * @return
	 */
	public String obtenerHtmlBuenaCalidadMat(RamoBuenaCalMat buenaCalMat) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("BuenaCalMatHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();

			}
			String contenidoXSL = sb.toString();

			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlBuenaCalMat(buenaCalMat);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);

		}
		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Buen Uso de Anticipo. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 13/04/2015]
	 * </p>
	 * 
	 * @param buenUsoAnt
	 * @return
	 */
	public String obtenerHtmlBuenUsoAnticipo(RamoBuenUsoAnt buenUsoAnt) {

		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("BuenUsoAntHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlBuenUsoAnt(buenUsoAnt);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");
		} catch (Exception e) {
			log.error("Error ", e);
		}
		return html;

	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Riesgos Especiales. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 25/05/2015]
	 * </p>
	 * 
	 * @param ramoRiesgosEsp
	 * @return
	 */
	public String obtenerHtmlRiesgosEspeciales(RamoRiesgosEsp ramoRiesgosEsp) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("RiesgosEspecialesHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlRiesgosEspeciales(ramoRiesgosEsp);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");
		} catch (Exception e) {
			log.error("Error ", e);
		}
		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Todo Riesgo Contratista </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 02/06/2015]
	 * </p>
	 * 
	 * @param ramoRiesgoContratista
	 * @return
	 */
	public String obtenerHtmlRiesgoContratista(RamoRiesgoContratista ramoRiesgoContratista) {
		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("TodoRiesgoContratistaHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlTodoRiesgoContratista(ramoRiesgoContratista);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");
		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Todo Riesgo Montaje </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 02/06/2015]
	 * </p>
	 * 
	 * @param ramoRiesgoMontaje
	 * @return
	 */
	public String obtenerHtmlRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("TodoRiesgoMontajeHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlTodoRiesgoMontaje(ramoRiesgoMontaje);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");
		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;

	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo vehiculos </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 07/06/2015]
	 * </p>
	 * 
	 * @param ramoVehiculo
	 * @return
	 */
	public String obtenerHtmlVehiculo(RamoVehiculo ramoVehiculo) {

		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("VehiculosHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlVehiculos(ramoVehiculo);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");
		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Transporte </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 03/06/2015]
	 * </p>
	 * 
	 * @param ramoTransporte
	 * @return
	 */
	public String obtenerHtmlTransporte(RamoTransporte ramoTransporte) {
		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("TransporteHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlTransporte(ramoTransporte);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");
		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;

	}

	/**
	 * 
	 * <b> ermite generar el HTML del ramo Soat </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 28/05/2015]
	 * </p>
	 * 
	 * @param ramoSoat
	 * @return
	 */
	public String obtenerHtmlSoat(RamoSoat ramoSoat) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("SoatHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlSoat(ramoSoat);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");
		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Rotura de Maquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo B., Date: 27/05/2015]
	 * </p>
	 * 
	 * @param ramoRoturaMaquinaria
	 * @return
	 */
	public String obtenerHtmlRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) {

		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("RoturaMaquinariaHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlRoturaMaquinaria(ramoRoturaMaquinaria);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");
		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Robo y/o Asalto </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 25/05/2015]
	 * </p>
	 * 
	 * @param ramoRoboAsalto
	 * @return
	 */
	public String obtenerHtmlRoboAsalto(RamoRoboAsalto ramoRoboAsalto) {

		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("RoboAsaltoHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlRoboAsalto(ramoRoboAsalto);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");
		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Casco Aereo. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 20/04/2015]
	 * </p>
	 * 
	 * @param cascoAereo
	 * @return
	 */

	public String obtenerHtmlCascoAereo(RamoCascoAereo cascoAereo) {

		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("CascoAereoHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlCascoAereo(cascoAereo);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");
		} catch (Exception e) {
			log.error("Error ", e);
		}
		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Casco Maritimo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 20/04/2015]
	 * </p>
	 * 
	 * @param cascoMaritimo
	 * @return
	 */
	public String obtenerHtmlCascoMaritimo(RamoCascoMaritimo cascoMaritimo) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("CascoMaritimoHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlCascoMaritimo(cascoMaritimo);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Cumplimiento Contrato </b>
	 * <p>
	 * [Author:Franklin Pozo B, Date: 21/04/2015]
	 * </p>
	 * 
	 * @param cumplimientoContrato
	 * @return
	 */
	public String obtenerHtmlCumplimientoContrato(RamoCumplimientoContrato cumplimientoContrato) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("CumplimientoContratoHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlCumplimientoContrato(cumplimientoContrato);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;

	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Responsabilidad Civil </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 21/05/2015]
	 * </p>
	 * 
	 * @param ramoResponsabilidadCivil
	 * @return
	 */
	public String obtenerHtmlResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil) {

		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("ResponsabilidadCivilHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlResponsabilidadCivil(ramoResponsabilidadCivil);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);
		}
		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Lucro Cesante Incendio Lineas Aliadas </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 13/05/2015]
	 * </p>
	 * 
	 * @param ramoLcIncendio
	 * @return
	 */
	public String obtenerHtmlLucCesIncendioLineasAliadas(RamoLcIncendio ramoLcIncendio) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("LucCesanIncendioLineasAliadas.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlLucCesIncendioLineasAliadas(ramoLcIncendio);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Lucro Cesante Rotura de maquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 12/05/2015]
	 * </p>
	 * 
	 * @param ramoLcRotMaq
	 * @return
	 */
	public String obtenerHtmlLucroCesanteRoturaMaquinaria(RamoLcRotMaq ramoLcRotMaq) {

		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("LucroCesanteRoturaMaquinariaHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlLucroCesanteRoturaMaquinaria(ramoLcRotMaq);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Incendio Lineas Aliadas </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 11/05/2015]
	 * </p>
	 * 
	 * @param incendioLineasAliada
	 * @return
	 */
	public String obtenerHtmlIncendioLineasAliadas(RamoIncendioLineasAliada incendioLineasAliada) {
		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("IncendioLineasAliadasHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlIncendioLineasAliada(incendioLineasAliada);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Cumplimiento Contrato. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 27/04/2015]
	 * </p>
	 * 
	 * @param cumplimientoContrato
	 * @return
	 */
	public String obtenerHtmlDineroValores(RamoDineroValore dineroValore) {

		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("DineroValoresHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			String contenidoXSL = sb.toString();
			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlDineroValores(dineroValore);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);
		}

		return html;
	}

	/**
	 * <b>Obtiene el servicio de Seguridad del sistema de mercado de valores</b>
	 * <p>
	 * [Author: gyandun, Date: 07/05/2014]
	 * </p>
	 * 
	 * @return
	 * @throws MercadoValoresException
	 *             En caso de no encontrar el EJB
	 */
	public Object getObjectByJndi(String jndiName) throws HiperionException {
		try {
			return getContext().lookup(jndiName);
		} catch (Exception e) {
			throw new HiperionException(e);
		}
	}

	/**
	 * <b> Permite inicializar el InitialContext. </b>
	 * <p>
	 * [Author: gyandun, Date: 16/03/2014]
	 * </p>
	 * 
	 * @return Context
	 * @throws NamingException
	 *             NamingException
	 */
	public Context getContext() throws NamingException {
		return new InitialContext();
	}

}
