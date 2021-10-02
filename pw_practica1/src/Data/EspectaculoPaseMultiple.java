package Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class EspectaculoPaseMultiple extends Espectaculo{

	private ArrayList<Funcion> funciones;

	public EspectaculoPaseMultiple(int idEspectaculo, String titulo, String descripcion, ArrayList<String> categorias) {
		super(idEspectaculo, titulo, descripcion, categorias);
		
	}

	public ArrayList<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	public void añadirFuncion(LocalDate fecha, LocalTime hora) {
		Funcion nuevaFuncion = new Funcion(fecha, hora, "Espectaculo"+super.getTitulo()+fecha.toString()+hora.toString());
		funciones.add(nuevaFuncion);
	}
	
	
}
