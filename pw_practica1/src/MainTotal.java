package Data;
import business.gestorCriticas;
import business.gestorEspectaculos;

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
		/*GESTORES */
		DAOManager gestorDAO = new DAOManager();
		gestorCriticas gestorCriticas = new gestorCriticas();
		gestorEspectaculos gestorEspectaculos = new gestorEspectaculos();
		
		/*Variables globales*/
		Usuario usuarioRegistrado = funcionesMain.iniciarSesion();
		
		
		//Nickname
		System.out.println("\nIntroduce tu nickname: ");
		Scanner entrada = new Scanner(System.in);
		String nickname=entrada.nextLine();
		
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
					
					
					ArrayList<Espectaculo> espectaculosDisponibles = gestorEspectaculos.consultarEspectaculos();
					for(Espectaculo espectaculoAux: espectaculosDisponibles) {
						System.out.println(espectaculoAux.toString());
					}
					
					System.out.println("\nIntroduce el id del espectaculo que desea criticar: ");
					entrada= new Scanner(System.in);
					String id_espectaculo=entrada.nextLine();
					Espectaculo espectaculoSeleccionado = gestorDAO.getEspectaculos().obtener(id_espectaculo);
					
					//***Id de espectaculo deberia ser int(numero)****
					System.out.println("\nIntroduce tu critica: ");
					entrada= new Scanner(System.in);
					String texto=entrada.nextLine();
					
					System.out.println("\nIntroduce la puntuacion al espectaculo: ");
					entrada= new Scanner(System.in);
					int puntuacion=entrada.nextInt();
				
					gestorCriticas.crearCritica(usuarioRegistrado, id_espectaculo, espectaculoSeleccionado, texto, puntuacion);
					
				case 2:
					//2.MOSTRAR TODAS LAS CRITICAS DISPONIBLES
					System.out.println("\nEstas son todas las criticas disponibles:\n");
					ArrayList<Critica> criticasDisponibles = gestorEspectaculos.consultarCriticas();
					for(Critica criticaAux : criticasDisponibles) {
						System.out.println(criticaAux.toString());
					}
					
				case 3:
					//3.BORRAR CRITICA SI EL USUARIO LA ESCRIBIÓ 
					ArrayList<Critica> criticasDisponibles1 = gestorEspectaculos.consultarCriticas();
					for(Critica criticaAux : criticasDisponibles1) {
						System.out.println(criticaAux.toString());
					}
			
					System.out.println("\nEstas son todas las criticas disponibles, "
										+ "seleccione la ID de la que desea borrar\n");
					entrada= new Scanner(System.in);
					String idCritica=entrada.nextLine();
					gestorCriticas.borraCritica(usuarioRegistrado, idCritica);
					
				case 4:
					//4.VOTAR UTILIDAD DE UNA CRITICA DE OTRO USUARIO REGISTRADO
					
					System.out.println("Puntuación de la critica que has leido:");
					entrada=new Scanner(System.in);
					String idCriticaValorar=entrada.nextLine();
					Critica criticaSeleccionada = gestorDAO.getCriticas().obtener(idCriticaValorar);
					
					System.out.println("Puntuación de la critica que has leido:");
					entrada=new Scanner(System.in);
					int valoracionCritica=entrada.nextInt();
					gestorEspectaculos.votarUtilidad(usuarioRegistrado, valoracionCritica, criticaSeleccionada);
					System.out.println("\nPuntuación dada correctamente...\n");
					
				case 5:
					//5.BUSCAR LAS CRITICAS DE UN USUARIO REGISTRADO.
					System.out.println("\nIntroduce el nickname de la persona cuya critica quieras encontrar: ");
					entrada=new Scanner(System.in);
					String nicknameUsuario = entrada.nextLine();
					ArrayList<Critica> buscarCriticas = gestorEspectaculos.buscarCriticasUsuario(nicknameUsuario);
					
				default:
					System.out.println("Has elegido salir del programa, adios\n");
					break;	
			}
		}
		//FALTA leer y escribir datos del gestor de criticas en un fichero plano y inicializar funciones del CRUD y de busqueda del gestor d criticas	
	}
}
