package model.daos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface DAO<T, K> {
	
	void insertar(T j) throws DAOException;
    
    void modificar(T j) throws DAOException;
    
    void eliminar(T j) throws DAOException;
    
    List<T> obtenerTodos() throws DAOException, Exception;
    
    T obtener(K id) throws Exception;
    
    void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException;
    
    void guardarFichero() throws FileNotFoundException, IOException;

	//Junta obtener(LocalDate fecha, LocalTime hora);
}
