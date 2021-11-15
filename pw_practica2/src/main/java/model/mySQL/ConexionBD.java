package model.mySQL;

import java.sql.Connection; 
import java.sql.DriverManager;


public class ConexionBD {
	
	public ConexionBD(){
		
	}

	public Connection getConnection(String url, String usuario, String password) throws Exception {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://oracle.uco.es:3306/i92lupua","i92lupua","pwuco2021");
			
		} catch (final Exception e) {
			
			System.out.println(e);
		}
		
		return con;
	}
}
