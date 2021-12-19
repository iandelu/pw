package business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.data.Espectaculo;



public interface Factory {

	public Espectaculo crearEspectaculo(String tipoEspectaculo, LocalDate fecha, LocalTime time);

	Espectaculo crearEspectaculo(String tipoEspectaculo, Long idEspectaculo, String titulo, String descripcion,
			ArrayList<String> categorias, int localidadesDisponibles);
}
