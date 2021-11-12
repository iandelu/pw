package model.mySQL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import model.daos.EspectaculoDAO;
import model.data.Espectaculo;

public class MySQLEspectaculoDAO implements EspectaculoDAO{

	
	 /*
	    *   ------------------------------------
	    *   SENTENCIAS PARA LAS TABLAS DE JUGADOR
	    *   ------------------------------------_
	    */
	    
	    final String INSERT = "INSERT INTO jugadores( usuario, nombre, email, apellidos, fechaNacimiento, contraseña,telefono, valoracionMedia) VALUES (?,?,?,?,?,?,?,?)"; 
	    final String UPDATE = "UPDATE jugadores SET usuario = ? , nombre = ?, email = ?, apellidos = ?, fechaNacimiento = ?, contraseña = ?,telefono = ? WHERE email = ?";
	    final String DELETE = "DELETE FROM jugadores WHERE idJugador = ?";
	    final String GETALL = "SELECT idJugador, usuario, nombre, email, apellidos, fechaNacimiento, contraseña,telefono, valoracionMedia FROM jugadores";
	    final String GETONE = "SELECT * FROM jugadores WHERE idJugador = ?";
	    final String BUSCARPOREMAIL = "SELECT * FROM jugadores WHERE email = ?";
	    
	    
	    private Connection conn;
	    
	    public MySQLEspectaculoDAO(Connection conn) {
	        
	        this.conn = conn;
	        
	    }
	
	
	@Override
	public void insertar(Espectaculo j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Espectaculo j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Espectaculo j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Espectaculo> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Espectaculo obtener(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	
}
