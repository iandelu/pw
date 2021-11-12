package Data;

import java.io.Serializable;
import java.util.ArrayList;

public class Espectaculo implements Serializable{

	private String idEspectaculo;
	private String titulo;
	private String descripcion;
	private ArrayList<String> categorias;
	private int localidadesDisponibles;
	private String tipoEspectaculo;
	
	public Espectaculo(String idEspectaculo, String titulo, String descripcion, ArrayList<String> categorias) {
		super();
		this.idEspectaculo = idEspectaculo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categorias = categorias;
	}
	
	public String getIdEspectaculo() {
		return idEspectaculo;
	}
	public void setIdEspectaculo(String idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ArrayList<String> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<String> categorias) {
		this.categorias = categorias;
	}
	public int getLocalidadesDisponibles() {
		return localidadesDisponibles;
	}
	public void setLocalidadesDisponibles(int localidadesRestantes) {
		this.localidadesDisponibles = localidadesRestantes;
	}
	public String getTipoEspectaculo() {
		return tipoEspectaculo;
	}

	public void setTipoEspectaculo(String tipoEspectaculo) {
		this.tipoEspectaculo = tipoEspectaculo;
	}

	@Override
	public String toString() {
		return "Espectaculo [idEspectaculo=" + idEspectaculo + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", categorias=" + categorias + ", localidadesDisponibles=" + localidadesDisponibles + "]";
	}
	
	
}
