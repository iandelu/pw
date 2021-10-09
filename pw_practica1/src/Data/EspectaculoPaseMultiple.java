package Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class EspectaculoPaseMultiple extends Espectaculo{

	private ArrayList<Funcion> funciones;

	public EspectaculoPaseMultiple(String idEspectaculo, String titulo, String descripcion, ArrayList<String> categorias, LocalDate fecha, LocalTime tiempo) {
		super(idEspectaculo, titulo, descripcion, categorias);
		this.añadirFuncion(fecha, tiempo);
		
	}

	public ArrayList<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	public void añadirFuncion(LocalDate fecha, LocalTime hora) {
		Funcion nuevaFuncion = new Funcion(fecha, hora, super.getLocalidadesDisponibles(),super.getTitulo());
		funciones.add(nuevaFuncion);
	}
	
	
}
