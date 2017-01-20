/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * <b> Permiete contener metodos para el manejo de fechas en el sistema </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Oct 12, 2014
 * @since JDK1.6
 */
public class FechasUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static FechasUtil INSTANCIA = new FechasUtil();
	private static final String FORMATO_FECHA = "dd-MM-yyyy";

	// Devuelve la unica instancia de la clase
	public static FechasUtil getInstancia() {
		return INSTANCIA;
	}

	/**
	 * 
	 * <b> Permite convertir una feha a String a algo como martes 9 de julio de 2014 </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 12, 2014]
	 * </p>
	 * 
	 * @param fecha
	 * @return
	 */
	public String dateForStringFull(Date fecha) {
		DateFormat formato = DateFormat.getDateInstance(DateFormat.FULL, new Locale("es"));
		return formato.format(fecha);
	}

	/**
	 * 
	 * <b> Permite pasar una fecha tipo string a un Date con formato </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 02/02/2015]
	 * </p>
	 * 
	 * @param fecha
	 * @return
	 */
	public String dateFormated(Date fecha) {

		SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA);
		String fechaDate = null;

		fechaDate = formato.format(fecha);

		return fechaDate;
	}

	/**
	 * 
	 * <b> Permite sumar o restar dias a una fecha. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 09/07/2015]
	 * </p>
	 * 
	 * @param fecha
	 * @param dias
	 * @return
	 */
	public Date sumarRestarDiasFecha(Date fecha, int dias) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(fecha); // Configuramos la fecha que se recibe

		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o restar en caso de días<0

		return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

	}

	/**
	 * 
	 * <b> Permite sumar meses a una fecha. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 11/01/2016]
	 * </p>
	 * 
	 * @param fecha
	 * @param meses
	 * @return
	 */
	public Date sumarMeses(Date fecha, int meses) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(fecha);

		calendar.add(Calendar.MONTH, meses);

		return calendar.getTime();
	}

	/**
	 * 
	 * <b> Permite retornar el numero de dias en la diferencia entre dos fechas </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 11/01/2016]
	 * </p>
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public long restarFechas(Date fechaInicio, Date fechaFin) {

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		cal1.setTime(fechaInicio);
		cal2.setTime(fechaFin);

		// conseguir la representacion de la fecha en milisegundos
		long milis1 = cal1.getTimeInMillis();

		long milis2 = cal2.getTimeInMillis();

		// calcular la diferencia en milisengundos
		long diff = milis2 - milis1;

		// calcular la diferencia en segundos
		long diffSeconds = diff / 1000;

		// calcular la diferencia en minutos
		long diffMinutes = diff / (60 * 1000);

		// calcular la diferencia en horas
		long diffHours = diff / (60 * 60 * 1000);

		// calcular la diferencia en dias
		long diffDays = diff / (24 * 60 * 60 * 1000);

		return diffDays;
	}

}