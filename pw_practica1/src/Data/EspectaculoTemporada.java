package Data;

import java.time.LocalDate;
import java.util.ArrayList;

public class EspectaculoTemporada extends Espectaculo{

	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private String diaSemana;
	public EspectaculoTemporada(int idEspectaculo, String titulo, String descripcion, ArrayList<String> categorias,
			LocalDate fechaInicio, LocalDate fechaFinal, String diaSemana) {
		super(idEspectaculo, titulo, descripcion, categorias);
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.diaSemana = diaSemana;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	
	
	
}
