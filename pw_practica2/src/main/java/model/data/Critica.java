package model.data;

import java.io.Serializable;
import java.util.ArrayList;

public class Critica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idCritica;
	private Usuario autor;
	private int puntuacion;
	private Espectaculo espectaculo;
	private String texto;
	private ArrayList<Valoracion> valoraciones;
	
	
	public Critica(String idCritica, Usuario autor, Espectaculo espectaculo, String texto, int puntuacion) {
		super();
		this.idCritica = idCritica;
		this.autor = autor;
		this.espectaculo = espectaculo;
		this.texto = texto;
	}
	
	public String getIdCritica() {
		return idCritica;
	}
	public void setIdCritica(String idCritica) {
		this.idCritica = idCritica;
	}
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public Espectaculo getEspectaculo() {
		return espectaculo;
	}
	public void setEspectaculo(Espectaculo espectaculo) {
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
	
	public void añadirValoracion(Valoracion nuevaValoracion) {
		valoraciones.add(nuevaValoracion);
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
	
}
