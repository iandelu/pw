package model.mySQL;
import java.sql.*;


public class ConexionBD {

	Connection miConexion;
	Statement miStatement;
	public static void main(String[] args) {

		try {     
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");     
			System.out.println("Driver OK"); } 
		catch (ClassNotFoundException e) {     
			System.out.println(e); }
	}
}
