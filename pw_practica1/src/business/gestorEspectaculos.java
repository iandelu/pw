package business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import DAOS.DAOManager;
import Data.Critica;
import Data.Espectaculo;

public class gestorEspectaculos {

	private espectaculoFactory factoria = new espectaculoFactory();
	
	private static gestorEspectaculos instance = null;
	DAOManager gestor = new DAOManager();
	
	
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
		return gestor.getEspectaculos().obtenerTodos();
	}
	
	public Boolean cancelarEspectaculo(int idEspectaculo) 
	{
		for(int i=0;i<)//Crea una funcion que vaya guardando todos los espectaculos, la recorres con el for y si esta el id se borra.
		
	}
	
	public void actualizarDatos(String idEspectaculo, LocalDate fecha, LocalTime time) {
		//Buscas el espectaculo en la lista creada, lo borras y metes uno nuevo con los datos que introduzca el usuario por el main
	}
	
	public int contabilizarEntradas(int idEspectaculo) {
		//Cuenta las entradas que tiene cada espectaculo. Como tenemos la variable privada localidadesRestantes, creamos una funcion que reste esta
		//variable x si le compran x entradas, y el resto entre las entradas iniciales y localidadesRestantes son las vendidas.
		//Devuelve el numero de entradas restantes
	}
	
	public int compraEntrada(int idEspectaculo, int numeroEntradas) {
		//restar numeroEntradas a idEspectaculo.
	}
	
	public int localidadesRestantes(LocalDate fecha) {
		//Funcion que al darle una fecha te devuelva las localidades restantes que quedan del espectaculo de ese dia
	}
	
	public void busquedaTitulo(string tituloEspectaculo) {
		//Introducimos un titulo y muestra da los datos de los espectaculos que tengan ese titulo
	}
	
	public void busquedaCategoria(//Aqui va una categoria) {
		//Introducimos una categoria y te da los datos de los espectaculos que sean de esa categoria
	}

	public void espectaculosConEntradas() {
		//Buscar en la lista donde hemos guardado todos los espectaculos dados de alta, los que las localidadesrestantes>0, y mostrarlos en pantalla.
	}
	
		//Faltan funciones del 9 al 12 por po er


	
	
	
	
	
}
