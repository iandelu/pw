package business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import DAOS.DAOManager;
import Data.Critica;
import Data.Espectaculo;
import Data.Usuario;
import Data.Valoracion;

public class gestorEspectaculos {

	private espectaculoFactory factoria = new espectaculoFactory();
	
	private static gestorEspectaculos instance = null;
	private DAOManager gestor = new DAOManager();
	private gestorCriticas gestorCriticas = new gestorCriticas();
	
	public static gestorEspectaculos getInstance() {
		if(instance ==  null) {
			instance = new gestorEspectaculos();
		}
		return instance;
	}
	
	public void darAltaEspectaculo(String idEspectaculo, LocalDate fecha, LocalTime time) {
	
		Espectaculo nuevoEspectaculo = factoria.crearEspectaculo(idEspectaculo, fecha, time);
		//añadir espectaculo a los ficheros
		
	}
	
	public ArrayList<Espectaculo> consultarEspectaculos(){
		return (ArrayList<Espectaculo>) gestor.getEspectaculos().obtenerTodos();
	}
	
	public void cancelarEspectaculo(String idEspectaculo) 
	{
		Espectaculo espectaculoBuscado = gestor.getEspectaculos().obtener(idEspectaculo);
		gestor.getEspectaculos().eliminar(espectaculoBuscado);
		
	}
	
	public void actualizarDatos(String idEspectaculo, String tituloNuevo, String descripcionNueva, ArrayList<String> Categorias) {
		Espectaculo nuevoEspectaculo = gestor.getEspectaculos().obtener(idEspectaculo);
		nuevoEspectaculo.setLocalidadesDisponibles(0);
		nuevoEspectaculo.setCategorias(Categorias );
		nuevoEspectaculo.setTitulo(tituloNuevo);
		nuevoEspectaculo.setDescripcion(tituloNuevo);
		
	}
	
	public int contabilizarEntradas(int idEspectaculo) {
		//Cuenta las entradas que tiene cada espectaculo. Como tenemos la variable privada localidadesRestantes, creamos una funcion que reste esta
		//variable x si le compran x entradas, y el resto entre las entradas iniciales y localidadesRestantes son las vendidas.
		//Devuelve el numero de entradas restantes
	}
	
	public void compraEntrada(String idEspectaculo, LocalDate Fecha) {
		
		
		
	}
	
	public int localidadesRestantes(LocalDate fecha) {
		//Funcion que al darle una fecha te devuelva las localidades restantes que quedan del espectaculo de ese dia
	}
	
	public ArrayList<Espectaculo> busquedaTitulo(String tituloEspectaculo) {
		ArrayList<Espectaculo> listaEspectaculos = new ArrayList<Espectaculo>();
		ArrayList<Espectaculo> todos = (ArrayList<Espectaculo>) gestor.getEspectaculos().obtenerTodos();
		for(Espectaculo e:todos) {
			
			if(e.getTitulo().contains(tituloEspectaculo)) {
				listaEspectaculos.add(e);
			}
			
		}
		
		return listaEspectaculos;
		
	}
	
	public ArrayList<Espectaculo> busquedaCategoria(String Categoria) {
		ArrayList<Espectaculo> listaEspectaculos = new ArrayList<Espectaculo>();
		ArrayList<Espectaculo> todos = (ArrayList<Espectaculo>) gestor.getEspectaculos().obtenerTodos();
		for(Espectaculo e:todos) {
			
			if(e.getCategorias().contains(Categoria)) {
				listaEspectaculos.add(e);
			}
			
		}
		
		return listaEspectaculos;
		
	}
	

	public void espectaculosConEntradas() {
		//Buscar en la lista donde hemos guardado todos los espectaculos dados de alta, los que las localidadesrestantes>0, y mostrarlos en pantalla.
	}
	
		//Faltan funciones del 9 al 12 por po er


	
	public void crearCritica(Usuario usuarioRegistrado, String idCritica, Espectaculo espectaculo, String texto, int puntuacion) {
		gestorCriticas.crearCritica(usuarioRegistrado, idCritica, espectaculo, texto, puntuacion);

	}
	
	public ArrayList<Critica> consultarCriticas(){
		return gestorCriticas.consultarCriticas();
	}
	
	public boolean borraCritica(Usuario autorSupuesto, String idCritica) {
		
		return gestorCriticas.borraCritica(autorSupuesto, idCritica);
	}
	
	public boolean votarUtilidad(Usuario usuarioRegistrado, int valoracionCritica, Critica critica) {
		
		return gestorCriticas.votarUtilidad(usuarioRegistrado, valoracionCritica, critica);
	}
	
	public ArrayList<Critica> buscarCriticasUsuario(String nickname){
		
		return gestorCriticas.buscarCriticasUsuario(nickname);
	}
	
	
	
	
}
