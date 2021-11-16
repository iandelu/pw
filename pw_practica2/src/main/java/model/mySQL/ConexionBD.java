package model.mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
	
	protected static Connection con = null;
	
	protected String url = "jdbc:mysql://oraclepr.uco.es:3306/i92lupua";

	protected String user = "i92lupua";

	protected String password = "pw2021uco";
	
	public ConexionBD(){
		
	}

	public static Connection getConnection() throws Exception {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92lupua","i92lupua","pw2021uco");
			
		} catch (final Exception e) {
			
			System.out.println(e);
		}
		
		return con;
	}
	
	public void closeConnection() {
		try {
			if(this.con != null && !this.con.isClosed()) {
				this.con.close();
				System.out.println("Database connection successfully closed!");
			}
		} catch (SQLException e) {
			System.err.println("Error while trying to close the connection.");
			e.printStackTrace();
		}
	}
}
