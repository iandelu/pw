import java.util.Scanner;

import DAOS.DAOManager;
import Data.Email;
import Data.Usuario;

public class funcionesMain {

	private static DAOManager gestorDAO = new DAOManager();
	
	
	public static Usuario iniciarSesion() {
			
		Usuario usuarioNew  = null;
		while(usuarioNew == null) {
			
			System.out.println("---BIENVENIDO AL GESTOR DE CRITICAS---\n");
			System.out.println("Introduce tu nickname: ");
			Scanner entrada= new Scanner(System.in);
			String nickname=entrada.nextLine();
			
			usuarioNew = gestorDAO.getUsuarios().obtener(nickname);
		}
		
		return usuarioNew;
	}
	
	
	public static Usuario registrarse(String nickname) throws Exception {
		

		//if(gestorDAO.getUsuarios().obtener(nickname) == null) {
			
			System.out.println("\nTe vas a registrar.: ");
			
			System.out.println("\nIntroduce tu nombre: ");
			Scanner entrada= new Scanner(System.in);
			String nombre=entrada.nextLine();
			
			System.out.println("\nIntroduce tus apellidos con guion intermedio(ejemplo: Fernandez_Jimenez): ");
			entrada= new Scanner(System.in);
			String apellidos=entrada.nextLine();
			
			System.out.println("\nIntroduce tu email: ");
			entrada= new Scanner(System.in);
			String email=entrada.nextLine();
			Email emailnuevo= new Email(email);
			
			Usuario usuarioNew = new Usuario(nombre,apellidos,emailnuevo,nickname);
			gestorDAO.getUsuarios().insertar(usuarioNew);
			return usuarioNew;
		//m}
		
	}
	
	
}
