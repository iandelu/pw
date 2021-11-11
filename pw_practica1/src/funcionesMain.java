import java.util.Scanner;

import DAOS.DAOManager;
import Data.Usuario;

public class funcionesMain {

	private static DAOManager gestorDAO = new DAOManager();
	
	
	public static Usuario iniciarSesion() {
			
		Usuario usuarioRegistrado  = null;
		while(usuarioRegistrado == null) {
			
			System.out.println("---BIENVENIDO AL GESTOR DE CRITICAS---\n");
			System.out.println("Introduce tu nombre: ");
			Scanner entrada= new Scanner(System.in);
			String usr=entrada.nextLine();
			
			usuarioRegistrado = gestorDAO.getUsuarios().obtener(usr);
		}
		
		return usuarioRegistrado;
	}
	
	public static Usuario registrarse() {
		
		String nickname =entrada.nextLine();
		if(gestorDAO.getUsuarios().obtener(nickname) == null) {
			
			
		}
		
		
		Usuario usuarioNuevo new Usuario();
		gestorDAO.getUsuarios().insertar(usuarioNuevo);
		
		
	}
	
	
}
