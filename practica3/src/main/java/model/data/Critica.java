  package model.data;

import java.io.Serializable;
import java.util.ArrayList;

public class Critica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idCritica;
	private String autor;
	private String titulo;
	private int puntuacion;
	private Long espectaculo;
	private String texto;
	private ArrayList<Valoracion> valoraciones;
	
	
	
	
	
	public Critica(Long idCritica, String autor, String titulo, int puntuacion, Long espectaculo, String texto,
			ArrayList<Valoracion> valoraciones) {
		super();
		this.idCritica = idCritica;
		this.autor = autor;
		this.titulo = titulo;
		this.puntuacion = puntuacion;
		this.espectaculo = espectaculo;
		this.texto = texto;
		this.valoraciones = valoraciones;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getIdCritica() {
		return idCritica;
	}
	public void setIdCritica(Long idCritica) {
		this.idCritica = idCritica;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Long getEspectaculo() {
		return espectaculo;
	}
	public void setEspectaculo(Long espectaculo) {
		this.espectaculo = espectaculo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public ArrayList<Valoracion> getValoraciones() {
		return valoraciones;
	}
	public void setValoraciones(ArrayList<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}
	
	public void addValoracion(Valoracion nuevaValoracion) {
		valoraciones.add(nuevaValoracion);
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
	
}
