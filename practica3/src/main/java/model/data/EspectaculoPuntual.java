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
					ArrayList<String> categorias, int localidadesDisponibles) {
		super(idEspectaculo, titulo, descripcion, categorias, localidadesDisponibles, descripcion);
		// TODO Auto-generated constructor stub
		super.setTipoEspectaculo("Puntual");
	}
	
	
}
