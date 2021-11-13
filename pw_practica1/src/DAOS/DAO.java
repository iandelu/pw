package DAOS;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import Data.Critica;
import Data.Espectaculo;

public interface DAO<T, K> {
	
	void insertar(T j);
    
    void modificar(T j);
    
    void eliminar(T j);
    
    List<T> obtenerTodos();
    
    T obtener(K id);
    
    void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException;
    
    void guardarFichero() throws FileNotFoundException, IOException;

	Critica obtenerCritica(int id);

	Espectaculo obtenerEspectaculo(int id);

	//Junta obtener(LocalDate fecha, LocalTime hora);
}
