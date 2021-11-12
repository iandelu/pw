package model.DAOS;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.mySQL.MySQLCriticaDAO;
import model.mySQL.MySQLEspectaculoDAO;
import model.mySQL.MySQLUsuarioDAO;

public class MySQLDAOManager {

	private Connection conn;
	
	private MySQLUsuarioDAO usuarios = null;
	private MySQLCriticaDAO criticas = null;
	private MySQLEspectaculoDAO espectaculos;

	public MySQLDAOManager(String host, String username, String password , String database) throws SQLException{
        
        String url = "jdbc:mysql://" + host + "/" + database;
        conn = DriverManager.getConnection(url , username, password);
        
    }    

	public MySQLUsuarioDAO getUsuarios() {
		if(usuarios == null){
            usuarios = new MySQLUsuarioDAO(conn);
		}
		return usuarios;
	}

	public MySQLCriticaDAO getCriticas() {
		if(criticas == null){
			criticas = new MySQLCriticaDAO(conn);
        }
		return criticas;
	}

	public MySQLEspectaculoDAO getEspectaculos() {
		
		if(espectaculos == null) {
			espectaculos = new MySQLEspectaculoDAO(conn);
		}
		return espectaculos;
	}
	
	public void guardarFicheros() throws IOException, IOException {

		
	}
	
}
