package Data;
import business.gestorCriticas;


import java.util.ArrayList;
import java.util.Scanner;
import Data.Critica;
import Data.Espectaculo;
import Data.Usuario;
import Data.Valoracion;
import DAOS.DAOManager;

public class MainTotal 
{
	public static void main(String [] args)
	{
		System.out.println("---BIENVENIDO AL GESTOR DE CRITICAS---\n");
		//Entrada de datos(scan)
		//Nombre
		System.out.println("Introduce tu nombre: ");
		
		Scanner entrada= new Scanner(System.in);
		String nombre=entrada.nextLine();
		
		//Apellidos
		System.out.println("\nIntroduce tus apellidos con _(Rovira_Dominguez: ");
		entrada=new Scanner(System.in);
		String apellidos=entrada.nextLine();
		
		//Email
		System.out.println("\nIntroduce tu email: ");
		entrada=new Scanner(System.in);
		String aux=entrada.next();
		Email email = null;
		try {
			email = new Email(aux);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Nickname
		System.out.println("\nIntroduce tu nickname: ");
		entrada=new Scanner(System.in);
		String nickname=entrada.nextLine();
		
		Usuario usr= new Usuario(nombre, apellidos, email, nickname);
		
		System.out.println("\nTus datos son:");
		System.out.println("\nNombre="+usr.getNombre()+", apellidos: "+usr.getApellidos());
		System.out.println("\nEmail="+usr.getEmail()+", y Nickname="+usr.getNickname()+"\n");
		
		System.out.println("Elige una de las siguientes opciones:\n");
		System.out.println("1.Crear una critica\r\n"
				+ "2. Mostrar todas las criticas\r\n"
				+ "3. Borrar una critica\r\n"
				+ "4. Votar utilidad de una critica de otro usuario\r\n"
				+ "5. Buscar las criticas de un usario registrado\r\n"
				+ "6.Salir del programa");
		
		entrada=new Scanner(System.in);
		int opcion=entrada.nextInt();
		int i=0;
		
		while(true)
		{
			if(i!=0)
			{
				System.out.println("Elige alguna de las siguientes opciones de nuevo.\n");
				System.out.println("1.Crear una critica\r\n"
						+ "2. Mostrar todas las criticas\r\n"
						+ "3. Borrar una critica\r\n"
						+ "4. Votar utilidad de una critica de otro usuario\r\n"
						+ "5. Buscar las criticas de un usario registrado\r\n"
						+ "6.Salir del programa");
				entrada=new Scanner(System.in);
				opcion=entrada.nextInt();
			}
			i++;
		
		
			switch(opcion)
			{
				case 1:
					//1. CREAR UNA CRITICA POR PARTE DEL USUARIO REGISTRADO
					System.out.println("\nIntroduce el id de tu critica: ");
					entrada= new Scanner(System.in);
					int id=entrada.nextInt();
					
					System.out.println("\nIntroduce el id del espectaculo: ");
					entrada= new Scanner(System.in);
					int id_espectaculo=entrada.nextInt();
					//Aqui cuando nos dan el id, lo asociamos con el titulo,la descripcion y las categorias.FALTA FUNCION PARA ELLO
					
					String titulo=id.titulo(id_espectaculo);
					String descripcion=id.descripcion(id_espectaculo);
					ArrayList<String> categorias=id.categorias(id_espectaculo);
					
					Espectaculo espect= new Espectaculo(id_espectaculo, titulo,descripcion, categorias);   //***Id de espectaculo deberia ser int(numero)****
					
					System.out.println("\nIntroduce tu critica: ");
					entrada= new Scanner(System.in);
					String critica=entrada.nextLine();
					
					System.out.println("\nIntroduce la puntuacion al espectaculo: ");
					entrada= new Scanner(System.in);
					int puntuacion=entrada.nextInt();
					
					crearCritica Cr= new crearCritica(usr,id, espect, critica, puntuacion);
					
				case 2:
					//2.MOSTRAR TODAS LAS CRITICAS DISPONIBLES
					System.out.println("\nEstas son todas las criticas disponibles:\n");
					ArrayList<Critica> lista_criticas= consultarCriticas();
					//********falta mostrar la lista por pantalla que me rayo**********
					
				case 3:
					//3.BORRAR CRITICA SI EL USUARIO LA ESCRIBIÓ 
					System.out.println("\nCritica creada, si tenias alguna otra critica se borrara.\n");
					borraCritica(usr,id);
					
				case 4:
					//4.VOTAR UTILIDAD DE UNA CRITICA DE OTRO USUARIO REGISTRADO
					System.out.println("Puntuación de la critica que has leido:");
					entrada=new Scanner(System.in);
					int valoracion_critica=entrada.nextInt();
					votarUtilidad votar= new votarUtilidad(usr, valoracion_critica, Cr);
					System.out.println("\nPuntuación dada correctamente...\n");
					
				case 5:
					//5.BUSCAR LAS CRITICAS DE UN USUARIO REGISTRADO.
					System.out.println("\nIntroduce el nickname de la persona cuya critica quieras encontrar: ");
					entrada=new Scanner(System.in);
					String nickname_buscar=entrada.nextLine();
					ArrayList<Critica> Buscador_criticas= buscarCriticasUsuario(nickname_buscar);
					
				default:
					System.out.println("Has elegido salir del programa, adios\n");
					break;	
			}
		}
		//FALTA leer y escribir datos del gestor de criticas en un fichero plano y inicializar funciones del CRUD y de busqueda del gestor d criticas	
	}
}
