package model.business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.data.Espectaculo;
import model.data.EspectaculoPaseMultiple;
import model.data.EspectaculoPuntual;
import model.data.EspectaculoTemporada;



public class espectaculoFactory implements Factory{

	private final static String puntual  = "PUNTUAL";
	private final static String temporada  = "TEMPORADA";
	private final static String paseMultiple  = "PASEMULTIPLE";
	
	
	@Override
	public Espectaculo crearEspectaculo(String tipoEspectaculo, LocalDate fecha, LocalTime time) {
		
		if(tipoEspectaculo == puntual) {
			EspectaculoPuntual nuevoEspectaculoPuntual = new EspectaculoPuntual((long)-1,"nuevoEspectaculo", "prueba",new ArrayList<String>(), fecha, time);
			return nuevoEspectaculoPuntual;
			
		}else if(tipoEspectaculo == temporada) {
			EspectaculoTemporada nuevoEspectaculoTemporada = new EspectaculoTemporada((long)-1, "nuevoEspectaculo", "prueba", new ArrayList<String>(), fecha,time);
			return nuevoEspectaculoTemporada;
			
		}else if(tipoEspectaculo == paseMultiple) {
			EspectaculoPaseMultiple nuevoEspectaculoPaseMultiple = new EspectaculoPaseMultiple((long)-1, "nuevoMultiple", "prueba", new ArrayList<String>(),fecha, time);
			return nuevoEspectaculoPaseMultiple;
		}
		
		return null;
		
	}
	
	

	
}
