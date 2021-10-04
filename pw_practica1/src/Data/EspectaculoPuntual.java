package Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class EspectaculoPuntual extends Espectaculo{

	private LocalDate fecha;
	private LocalTime hora;
	
	public EspectaculoPuntual(String idEspectaculo, String titulo,String descripcion, 
					ArrayList<String> categorias, LocalDate fecha, LocalTime hora) {
		super(idEspectaculo, titulo, descripcion, categorias);
		// TODO Auto-generated constructor stub
		this.fecha = fecha;
		this.hora = hora;
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

	
}
