package model.Data;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funcion {

	private LocalDate fecha;
	private LocalTime hora;
	private int localidadesRestantes;
	private String idFuncion;
	
	public Funcion(LocalDate fecha, LocalTime hora, int localidadesDisponibles,String nombre) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.localidadesRestantes = localidadesDisponibles;
		this.idFuncion = fecha.toString()+"-Espectaculo-"+nombre;
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

	public int getLocalidadesRestantes() {
		return localidadesRestantes;
	}

	public void setLocalidadesRestantes(int localidadesRestantes) {
		this.localidadesRestantes = localidadesRestantes;
	}

	public String getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(String idFuncion) {
		this.idFuncion = idFuncion;
	}
	
	
	
}
