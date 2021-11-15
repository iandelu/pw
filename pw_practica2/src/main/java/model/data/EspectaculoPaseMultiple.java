package model.data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class EspectaculoPaseMultiple extends Espectaculo{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EspectaculoPaseMultiple(Long idEspectaculo, String titulo, String descripcion, ArrayList<String> categorias, int localidadesDisponibles) {
		super(idEspectaculo, titulo, descripcion, categorias, localidadesDisponibles, descripcion);
		super.setTipoEspectaculo("PaseMultiple");
		
	}

	
	
	
	
}
