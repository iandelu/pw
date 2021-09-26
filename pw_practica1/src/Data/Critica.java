package Data;

import java.io.Serializable;
import java.util.ArrayList;

public class Critica implements Serializable {

	private int idCritica;
	private Usuario autor;
	private Espectaculo espectaculo;
	private String texto;
	private ArrayList<Valoracion> valoraciones;
	
	
	public Critica(int idCritica, Usuario autor, Espectaculo espectaculo, String texto, ArrayList<Valoracion> valoraciones) {
		super();
		this.idCritica = idCritica;
		this.autor = autor;
		this.espectaculo = espectaculo;
		this.texto = texto;
		this.valoraciones = valoraciones;
	}
	
	public int getIdCritica() {
		return idCritica;
	}
	public void setIdCritica(int idCritica) {
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
	
	
	
}
