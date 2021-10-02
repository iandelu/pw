package Data;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funcion {

	private LocalDate fecha;
	private LocalTime hora;
	String nombre;
	
	public Funcion(LocalDate fecha, LocalTime hora, String nombre) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
