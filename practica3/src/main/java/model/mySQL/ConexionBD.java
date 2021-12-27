package model.mySQL;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class ConexionBD {
     Connection miConexion;
     Statement miStatement;

    public static void main(String[] args) {

        try {
        //1. Crear conexion
        	Class.forName("com.mysql.jdbc.Driver");
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92lupua", "i92lupua", "pwuco2021");

        //2. Crear objeto statement
            Statement miStatement=miConexion.createStatement();

        //3. Sentencias SQL
            ResultSet miResultset=miStatement.executeQuery("SELECT * FROM Critica");

        //4. Imprimimos el output de las sentencias SQL
            while(miResultset.next()) {
                System.out.println(miResultset.getString("id")+" "+miResultset.getString("titulo"));
            }

        //5. Cerramos la conexión
            miConexion.close();

        }catch(Exception e) {
            System.out.println("Error, no se pudo establecer la conexión con la base de datos.");
            e.printStackTrace();
        }
    }
}