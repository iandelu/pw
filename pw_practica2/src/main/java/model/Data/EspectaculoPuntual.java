package model.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class EspectaculoPuntual extends Espectaculo{

	private Funcion funcionPuntual;
	
	public EspectaculoPuntual(int idEspectaculo, String titulo,String descripcion, 
					ArrayList<String> categorias, LocalDate fecha, LocalTime hora) {
		super(idEspectaculo, titulo, descripcion, categorias);
		// TODO Auto-generated constructor stub
		this.funcionPuntual = new Funcion(fecha,hora,super.getLocalidadesDisponibles(),super.getTitulo());
	}

	public Funcion getFuncionPuntual() {
		return funcionPuntual;
	}

	public void setFuncionPuntual(Funcion funcionPuntual) {
		this.funcionPuntual = funcionPuntual;
	}

	

	
}