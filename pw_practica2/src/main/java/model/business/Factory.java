package model.business;

import java.time.LocalDate;
import java.time.LocalTime;

import model.data.Espectaculo;



public interface Factory {

	public Espectaculo crearEspectaculo(String tipoEspectaculo, LocalDate fecha, LocalTime time);
}
