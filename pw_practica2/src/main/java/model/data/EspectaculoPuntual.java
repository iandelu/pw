package model.data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class EspectaculoPuntual extends Espectaculo{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EspectaculoPuntual(Long idEspectaculo, String titulo,String descripcion, 
					ArrayList<String> categorias, LocalDate fecha, LocalTime hora) {
		super(idEspectaculo, titulo, descripcion, categorias);
		// TODO Auto-generated constructor stub
		Funcion funcionAux = new Funcion(fecha,hora,super.getLocalidadesDisponibles(),(Long)1213);
		super.addFuncion(funcionAux);
		super.setTipoEspectaculo("Puntual");
	}
	
	
}
