package model.data;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funcion {

	private Long idFuncion;
	private LocalDate fecha;
	private LocalTime hora;
	private int localidadesRestantes;
	private Long espectaculo;
	
	public Funcion(Long idFuncion, LocalDate fecha, LocalTime hora, int localidadesDisponibles) {
		this.fecha = fecha;
		this.hora = hora;
		this.localidadesRestantes = localidadesDisponibles;
		this.idFuncion = idFuncion;
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

	public Long getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(Long idFuncion) {
		this.idFuncion = idFuncion;
	}

	public Long getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(Long espectaculo) {
		this.espectaculo = espectaculo;
	}
	
	
	
}
