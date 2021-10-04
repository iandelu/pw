package business;

import java.time.LocalDate;
import java.time.LocalTime;

import DAOS.DAOManager;
import Data.Espectaculo;

public class gestorEspectaculos {

	private espectaculoFactory factoria = new espectaculoFactory();
	
	private static gestorEspectaculos instance = null;
	DAOManager gestor = new DAOManager();
	
	
	public static gestorEspectaculos getInstance() {
		if(instance ==  null) {
			instance = new gestorEspectaculos();
		}
		return instance;
	}
	
	public void darAltaEspectaculo(String tipoEspectaculo, LocalDate fecha, LocalTime time) {
	
		Espectaculo nuevoEspectaculo = factoria.crearEspectaculo(tipoEspectaculo, fecha, time);
		//añadir espectaculo a los ficheros
		
	}
	
	public void cancelarEspectaculo(int idEspectaculo) {
		
	}
	
	public void actualizarDatos(int idEspectaculo) {
		
	}
	
	
}
