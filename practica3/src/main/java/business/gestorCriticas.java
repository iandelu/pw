package business;

import java.util.ArrayList;

import model.daos.MySQLDAOManager;
import model.data.Critica;
import model.data.Espectaculo;
import model.data.Usuario;
import model.data.Valoracion;

public class gestorCriticas {

	private static gestorCriticas instance = null;
	static MySQLDAOManager gestor = new MySQLDAOManager(null, null, null, null);
	
	public static gestorCriticas getInstance() {
		if(instance ==  null) {
			instance = new gestorCriticas();
		}
		return instance;
	}
	
	public static void crearCritica(Long idCritica,String usuarioRegistrado, Espectaculo espectaculo, String texto, int puntuacion) {
		
		Critica nuevaCritica = new Critica( idCritica ,usuarioRegistrado,  espectaculo,  texto, puntuacion);
		gestor.getCriticas().insertar(nuevaCritica);

	}
	
	public static ArrayList<Critica> consultarCriticas(){
		return (ArrayList<Critica>) gestor.getCriticas().obtenerTodos();
	}
	
	public static boolean borraCritica(String autorSupuesto, Long idCritica) {
		
		Critica criticaAuxiliar = gestor.getCriticas().obtener(idCritica);
		if(criticaAuxiliar.getAutor() == autorSupuesto) {
			gestor.getCriticas().eliminar(criticaAuxiliar);
			return true;
		}
		
		//si no es el autor no hace nada
		return false;
	}
	
	public static boolean votarUtilidad(Usuario usuarioRegistrado, int valoracionCritica, Long critica) {
		
		Valoracion nuevaValoracion = new Valoracion(usuarioRegistrado, valoracionCritica, critica.getTexto());
		if(usuarioRegistrado == critica.getAutor()) {
			//no se pueden valorar tus propias criticas
			return false;
		}
		critica.añadirValoracion(nuevaValoracion);
		return true;
	}
	
	public ArrayList<Critica> buscarCriticasUsuario(String nickname){
		
		ArrayList<Critica> listaCriticasAuxiliar = new ArrayList<Critica>();
		ArrayList<Critica> todas = gestor.getCriticas().obtenerTodos();
		for(Critica v : todas) {
			
			if(v.getAutor().getNickname() == nickname) {
				listaCriticasAuxiliar.add(v);
			}
			
		}
		
		return listaCriticasAuxiliar;
	}
	
}
