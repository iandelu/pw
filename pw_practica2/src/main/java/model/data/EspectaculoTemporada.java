package model.data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class EspectaculoTemporada extends Espectaculo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String diaWeek;
	
	public EspectaculoTemporada(Long idEspectaculo, String titulo, String descripcion, ArrayList<String> categorias,
			LocalDate fechaInicio, LocalTime hora) {
		super(idEspectaculo, titulo, descripcion, categorias);
		
		this.addFuncion(fechaInicio, hora);
		this.diaWeek = fechaInicio.getDayOfWeek().name();
		super.setTipoEspectaculo("Temporada");
		
	}
	
	public void addFuncion(LocalDate fecha, LocalTime hora) {
		if(fecha.getDayOfWeek().name()==diaWeek) {
			Funcion nuevaFuncion = new Funcion((long)-1,fecha, hora, super.getLocalidadesDisponibles());
			super.getFunciones().add(nuevaFuncion);
		}
	}

	public String getDiaWeek() {
		return diaWeek;
	}

	public void setDiaWeek(String diaWeek) {
		this.diaWeek = diaWeek;
	}
	
}
