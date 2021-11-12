package Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class EspectaculoTemporada extends Espectaculo{

	private ArrayList<Funcion> funciones;
	private String diaWeek;
	
	public EspectaculoTemporada(String idEspectaculo, String titulo, String descripcion, ArrayList<String> categorias,
			LocalDate fechaInicio, LocalTime hora) {
		super(idEspectaculo, titulo, descripcion, categorias);
		
		this.añadirFuncion(fechaInicio, hora);
		this.setTipoEspectaculo("Temporada");
		this.diaWeek = fechaInicio.getDayOfWeek().name();
		
	}
	
	public void setFunciones(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	public ArrayList<Funcion> getFunciones(){
		return this.funciones;
	}
	
	public void añadirFuncion(LocalDate fecha, LocalTime hora) {
		if(fecha.getDayOfWeek().name()==diaWeek) {
			Funcion nuevaFuncion = new Funcion(fecha, hora, super.getLocalidadesDisponibles(),super.getTitulo());
			funciones.add(nuevaFuncion);
		}
	}

	public String getDiaWeek() {
		return diaWeek;
	}

	public void setDiaWeek(String diaWeek) {
		this.diaWeek = diaWeek;
	}
	
}
