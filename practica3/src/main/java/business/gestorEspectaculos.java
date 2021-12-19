package model.business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.daos.MySQLDAOManager;
import model.data.Critica;
import model.data.Espectaculo;

public class gestorEspectaculos {

	private static EspectaculoFactory factoria = new EspectaculoFactory();
	
	private static gestorEspectaculos instance = null;
	private static MySQLDAOManager gestor = new MySQLDAOManager(null, null, null, null);
	private gestorCriticas gestorCriticas = new gestorCriticas();
	
	public static gestorEspectaculos getInstance() {
		if(instance ==  null) {
			instance = new gestorEspectaculos();
		}
		return instance;
	}
	
	public static void darAltaEspectaculo(String idEspectaculo, LocalDate fecha, LocalTime time) {
	
		Espectaculo nuevoEspectaculo = factoria.crearEspectaculo(idEspectaculo, fecha, time);
		//aniadir espectaculo a los ficheros
		
	}
	
	public ArrayList<Espectaculo> consultarEspectaculos(){
		return (ArrayList<Espectaculo>) gestor.getEspectaculos().obtenerTodos();
	}
	
	public static void cancelarEspectaculo(int idEspectaculo) 
	{
		Espectaculo espectaculoBuscado = gestor.getEspectaculos().obtenerEspectaculo(idEspectaculo);
		gestor.getEspectaculos().eliminar(espectaculoBuscado);
		
	}
	
	public static void actualizarDatos(int idEspectaculo, String tituloNuevo, String descripcionNueva, ArrayList<String> Categorias) {
		Espectaculo nuevoEspectaculo = gestor.getEspectaculos().obtenerEspectaculo(idEspectaculo);
		nuevoEspectaculo.setLocalidadesDisponibles(0);
		nuevoEspectaculo.setCategorias(Categorias );
		nuevoEspectaculo.setTitulo(tituloNuevo);
		nuevoEspectaculo.setDescripcion(tituloNuevo);
		
	}
	
	public static int contabilizarEntradas(int idEspectaculo) {
		return 1;//hayq ue recorrer todos los espectaculos y que nos de las entradas vendidas
		
	}
	
	public void compraEntrada(String idEspectaculo, LocalDate Fecha) {
		
		
		
	}
	
	public static int localidadesRestantes(LocalDate fecha) {
		return 1;//Funcion que al darle una fecha te devuelva las localidades restantes que quedan del espectaculo de ese dia
	}
	
	public static ArrayList<Espectaculo> busquedaTitulo(String tituloEspectaculo) {
		ArrayList<Espectaculo> listaEspectaculos = new ArrayList<Espectaculo>();
		ArrayList<Espectaculo> todos = (ArrayList<Espectaculo>) gestor.getEspectaculos().obtenerTodos();
		for(Espectaculo e:todos) {
			
			if(e.getTitulo().contains(tituloEspectaculo)) {
				listaEspectaculos.add(e);
			}
			
		}
		
		return listaEspectaculos;
		
	}
	
	public static ArrayList<Espectaculo> busquedaCategoria(String Categoria) {
		ArrayList<Espectaculo> listaEspectaculos = new ArrayList<Espectaculo>();
		ArrayList<Espectaculo> todos = (ArrayList<Espectaculo>) gestor.getEspectaculos().obtenerTodos();
		for(Espectaculo e:todos) {
			
			if(e.getCategorias().contains(Categoria)) {
				listaEspectaculos.add(e);
			}
			
		}
		
		return listaEspectaculos;
		
	}
	

	public static void espectaculosConEntradas() {
		//Buscar en la lista donde hemos guardado todos los espectaculos dados de alta, los que las localidadesrestantes>0, y mostrarlos en pantalla.
	}
	
		//Faltan funciones del 9 al 12 por po er
	
	public ArrayList<Critica> consultarCriticas(){
		return gestorCriticas.consultarCriticas();
	}
	
	public boolean borraCritica(Usuario autorSupuesto, int idCritica) {
		
		return gestorCriticas.borraCritica(autorSupuesto, idCritica);
	}
	
	public boolean votarUtilidad(Usuario usuarioRegistrado, int valoracionCritica, Critica critica) {
		
		return gestorCriticas.votarUtilidad(usuarioRegistrado, valoracionCritica, critica);
	}
	
	public ArrayList<Critica> buscarCriticasUsuario(String nickname){
		
		return gestorCriticas.buscarCriticasUsuario(nickname);
	}
	
	
	
	
}
