package model.data;

import java.io.Serializable;

public class Valoracion implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario autor;
	private int nota;
	private String critica;
	
	public Valoracion(Usuario autor, int nota, String critica) {
		super();
		this.autor = autor;
		this.nota = nota;
		this.critica = critica;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getEspectaculo() {
		return critica;
	}

	public void setEspectaculo(String critica) {
		this.critica = critica;
	}
	
	
	
}
