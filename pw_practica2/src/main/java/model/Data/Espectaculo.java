package model.Data;

import java.io.Serializable;
import java.util.ArrayList;

public class Espectaculo implements Serializable{

	private int idEspectaculo;
	private String titulo;
	private String descripcion;
	private ArrayList<String> categorias;
	private int localidadesDisponibles;
	
	
	public Espectaculo(int idEspectaculo, String titulo, String descripcion, ArrayList<String> categorias) {
		super();
		this.idEspectaculo = idEspectaculo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categorias = categorias;
	}
	
	public int getIdEspectaculo() {
		return idEspectaculo;
	}
	public void setIdEspectaculo(int idEspectaculo) {
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
	
}
