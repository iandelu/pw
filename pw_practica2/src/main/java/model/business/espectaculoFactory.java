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
	public Espectaculo crearEspectaculo(String tipoEspectaculo, Long idEspectaculo, String titulo, String descripcion, ArrayList<String> categorias, int localidadesDisponibles) {
		
		if(tipoEspectaculo == puntual) {
			EspectaculoPuntual nuevoEspectaculoPuntual = new EspectaculoPuntual(idEspectaculo,titulo, 
					descripcion,new ArrayList<String>(),localidadesDisponibles);
			return nuevoEspectaculoPuntual;
			
		}else if(tipoEspectaculo == temporada) {
			EspectaculoTemporada nuevoEspectaculoTemporada = new EspectaculoTemporada(idEspectaculo,titulo, 
					descripcion,new ArrayList<String>(),localidadesDisponibles);
			return nuevoEspectaculoTemporada;
			
		}else if(tipoEspectaculo == paseMultiple) {
			EspectaculoPaseMultiple nuevoEspectaculoPaseMultiple = new EspectaculoPaseMultiple(idEspectaculo,titulo, 
					descripcion,new ArrayList<String>(),localidadesDisponibles);
			return nuevoEspectaculoPaseMultiple;
		}
		
		return null;
		
	}


	@Override
	public Espectaculo crearEspectaculo(String tipoEspectaculo, LocalDate fecha, LocalTime time) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
