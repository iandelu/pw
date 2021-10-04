package business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Data.Espectaculo;
import Data.EspectaculoPaseMultiple;
import Data.EspectaculoPuntual;
import Data.EspectaculoTemporada;

public class espectaculoFactory implements Factory{

	private final static String puntual  = "PUNTUAL";
	private final static String temporada  = "TEMPORADA";
	private final static String paseMultiple  = "PASEMULTIPLE";
	
	
	@Override
	public Espectaculo crearEspectaculo(String tipoEspectaculo, LocalDate fecha, LocalTime time) {
		
		if(tipoEspectaculo == puntual) {
			EspectaculoPuntual nuevoEspectaculoPuntual = new EspectaculoPuntual("as","nuevoEspectaculo", "prueba",new ArrayList<String>(), fecha, time);
			return nuevoEspectaculoPuntual;
			
		}else if(tipoEspectaculo == temporada) {
			EspectaculoTemporada nuevoEspectaculoTemporada = new EspectaculoTemporada("s", "nuevoEspectaculo", "prueba", new ArrayList<String>(), fecha, fecha, "lunes");
			return nuevoEspectaculoTemporada;
			
		}else if(tipoEspectaculo == paseMultiple) {
			EspectaculoPaseMultiple nuevoEspectaculoPaseMultiple = new EspectaculoPaseMultiple("as", "nuevoMultiple", "prueba", new ArrayList<String>(),fecha, time);
			return nuevoEspectaculoPaseMultiple;
		}
		
		return null;
		
	}
	
	

	
}
