package model.mySQL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.daos.MySQLDAOManager;
import model.data.Critica;
import model.data.Usuario;
import model.data.Valoracion;

public class ConexionBD {

	public static void main(String[] args) {

		try {
		//1. Crear conexion
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92lupua", "i92lupua", "pwuco2021");
		//2. Crear objeto statement
			Statement miStatement=miConexion.createStatement();
			
		//3. Sentencias SQL
			MySQLDAOManager man=new MySQLDAOManager("oraclepr.uco.es:3306", "i92lupua", "pwuco2021", "i92lupua");
			//List <Critica> criticas=new ArrayList<>();
			//Valoracion v=new Valoracion((long)12,"autor",5,(long)2);
			//valoraciones.add(null);
			//Critica c=new Critica((long)12, "autor12", "titulo12", 2, (long)2, "texto", valoraciones);
			//man.getCriticas().modificar(c);
			//Critica c= man.getCriticas().obtener((long)2);
			Critica c= man.getValoraciones().obtenerValoracionesCritica((long)2);
			 
			
		//4. Imprimimos el output de las sentencias SQL
				System.out.println(c);
				/*for(Valoracion v1:criticas) {
					
					System.out.println(v1);
				}*/
		
		//5. Cerramos la conexión
			miConexion.close();
			
		}catch(Exception e) {
			System.out.println("Error, no se pudo establecer la conexión con la base de datos.");
			e.printStackTrace();
		}	
	}
}

