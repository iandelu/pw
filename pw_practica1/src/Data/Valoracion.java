package Data;

import java.io.Serializable;

public class Valoracion implements Serializable{
	
	
	private Usuario autor;
	private int nota;
	private int espectaculo;
	
	public Valoracion(Usuario autor, int nota, int espectaculo) {
		super();
		this.autor = autor;
		this.nota = nota;
		this.espectaculo = espectaculo;
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

	public int getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(int espectaculo) {
		this.espectaculo = espectaculo;
	}
	
	
	
}
