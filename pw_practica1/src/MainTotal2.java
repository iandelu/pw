
import java.util.Scanner;

import DAOS.DAOManager;
import Data.Critica;
import Data.Espectaculo;
import Data.Usuario;

import java.util.ArrayList;
import java.util.Date;

import business.gestorCriticas;
import business.gestorEspectaculos;
import java.time.LocalDate;
import java.time.LocalTime;



public class MainTotal2 
{
	static ArrayList<String> categorias;
	static DAOManager gestorDAO = new DAOManager();
	
	public static void main(String args[])
	{
		Usuario usr = funcionesMain.iniciarSesion();
		
		System.out.println("Elige una de las siguientes opciones:\n");
		System.out.println("1. Dar de alta un espectaculo, incluyendo al menos una fecha de representacion\r\n"
				+ "2. Cancelar un espectaculo (todas las sesiones o una en particular)\r\n"
				+ "3. Actualizar los datos de un espectaculo\r\n"
				+ "4. Contabilizar la venta de entradas para una sesion de un espectaculo\r\n"
				+ "5. Consultar las localidades disponibles para un espectaculo, dada una fecha de\r\n"
				+ "representacion\r\n"
				+ "6. Busqueda de espectaculos por titulo o por categoria\r\n"
				+ "Practica 1: Iniciacion a Java Pag. 4\r\n"
				+ "7. Busqueda de proximos espectaculos con entradas disponibles, indicando o no una\r\n"
				+ "categoria especifica\r\n"
				+ "8. Publicar una critica para un espectaculo que ya se ha celebrado\r\n"
				+ "9. Consultar las criticas de un espectaculo, dado su titulo\r\n"
				+ "10.Eliminar criticas de un espectaculo, por parte del usuario que la crea\r\n"
				+ "11.Valorar la utilidad de una critica publicada por otro usuario\n");
		Scanner entrada= new Scanner(System.in);
		int opcion=entrada.nextInt();
		int i=0;
		
		while(true)
		{
			if(i!=0)
			{
				System.out.println("Elige una de las siguientes opciones:\n");
				System.out.println("1. Dar de alta un espectaculo, incluyendo al menos una fecha de representacion\r\n"
						+ "2. Cancelar un espectaculo (todas las sesiones o una en particular)\r\n"
						+ "3. Actualizar los datos de un espectaculo\r\n"
						+ "4. Contabilizar la venta de entradas para una sesion de un espectaculo\r\n"
						+ "5. Consultar las localidades disponibles para un espectaculo, dada una fecha de\r\n"
						+ "representacion\r\n"
						+ "6. Busqueda de espectaculos por titulo o por categoria\r\n"
						+ "Practica 1: Iniciacion a Java Pag. 4\r\n"
						+ "7. Busqueda de proximos espectaculos con entradas disponibles, indicando o no una\r\n"
						+ "categoria especifica\r\n"
						+ "8. Publicar una critica para un espectaculo que ya se ha celebrado\r\n"
						+ "9. Consultar las criticas de un espectaculo, dado su titulo\r\n"
						+ "10.Eliminar criticas de un espectaculo, por parte del usuario que la crea\r\n"
						+ "11.Valorar la utilidad de una critica publicada por otro usuario\n");
				entrada=new Scanner(System.in);
				opcion=entrada.nextInt();
			}
			i++;
			
			switch(opcion)
			{
				case 1:
					//DAR DE ALTA UN ESPECTACULO
					System.out.println("Vas a dar de alta un espectaculo.\n");
					System.out.println("\nIntroduce el id del espectaculo:");
					String idEspectaculo= entrada.nextLine();
					
					System.out.println("\nIntroduce la fecha y la hora del espectaculo:\n");
					System.out.println("\nAÃ±o: ");
					int ano=entrada.nextInt();
					System.out.println("\nMes: ");
					int mes=entrada.nextInt();
					System.out.println("\ndia: ");
					int dia=entrada.nextInt();
					
					LocalDate fecha=LocalDate.of(ano,mes,dia);//Guarda en fecha la fecha.
					
					System.out.println("\nHora:");
					int horas=entrada.nextInt();
					System.out.println("\nMinutos:");
					int minutos=entrada.nextInt();
					int segundos=00;
					
					LocalTime time=LocalTime.of(horas,minutos,segundos);//Guarda en time la hora del espectaculo.
					gestorEspectaculos.darAltaEspectaculo(idEspectaculo, fecha, time);
					
					System.out.println("\nEspectaculo dado de alta\n");
					
				case 2:
					//Cancelar un espectaculo
					System.out.println("Id del espectaculo que quieres cancelar: ");
					int idEspectaculoBorrar= entrada.nextInt();
					gestorEspectaculos.cancelarEspectaculo(idEspectaculoBorrar);//funcion en gestorEspectaculos
					System.out.println("\nEspectaculo cancelado\n");
					
				case 3:
					// Actualizar los datos de un espectaculo
					System.out.println("Introduce el id del espectaculo que quieres modificar: ");	
					int idCambio= entrada.nextInt();
					
					System.out.println("\nIntroduce nuevo titulo de la critica que quieres actualizar: ");
					entrada= new Scanner(System.in);
					String tituloNuevo=entrada.nextLine();
					
					System.out.println("\nIntroduce la nueva critica: ");
					entrada= new Scanner(System.in);
					String descripcionNueva=entrada.nextLine();
					
					
					gestorEspectaculos.actualizarDatos(idCambio, tituloNuevo, descripcionNueva, categorias);//funcion en gestorEspectaculos
					
					System.out.println("\nEspectaculo cambiado\n");
					
				case 4:
					//. Contabilizar la venta de entradas para una sesion de un espectaculo
					System.out.println("Introduce el id del espectaculo del cual quieres ver las entradas vendidas:");
					int idContabilizar=entrada.nextInt();
					int numeroVentas = gestorEspectaculos.contabilizarEntradas(idContabilizar);//hacer funcion
					System.out.println("\n Se han vendido "+numeroVentas+" entradas.\n");
					
				case 5: 
					//Consultar las localidades disponibles para un especta¡culo, dada una fecha de representacion
					System.out.println("Introduce la fecha de la que quieres saber las plazas restantes:\n");
					System.out.println("\nAÃ±o: ");
					int anoLocalidadesRestantes=entrada.nextInt();
					System.out.println("\nMes: ");
					int mesLocalidadesRestantes=entrada.nextInt();
					System.out.println("\ndia: ");
					int diaLocalidadesRestantes=entrada.nextInt();
					
					LocalDate fechaLocalidadesRestantes=LocalDate.of(anoLocalidadesRestantes,mesLocalidadesRestantes,diaLocalidadesRestantes);
					int numeroLocalidadesRestantes=gestorEspectaculos.localidadesRestantes(fechaLocalidadesRestantes);//hacer funcion
					
					System.out.println("\n Para esa fecha, quedan "+numeroLocalidadesRestantes+" entradas.\n");
					
				case 6:
					//. Busqueda de espectaculos por titulo o por categoria
					System.out.println("Inserta 1 para introducir titulo o 2 para introducir categoria:");
					int eleccion=entrada.nextInt();
					switch(eleccion)
					{
					case 1:
						System.out.println("\nInserta el titulo:");
						String tituloBusqueda=entrada.nextLine();
						gestorEspectaculos.busquedaTitulo(tituloBusqueda);//funcion en gestorEspectaculos
						break;
						
					case 2:
						System.out.println("\nInserta la categoria:");
						String categoriaBusqueda=entrada.nextLine();
						gestorEspectaculos.busquedaCategoria(categoriaBusqueda);///funcion en gestorEspectaculos
						break;
					}
					
				case 7:
					//Busqueda de proximos espectaculos con entradas disponibles, indicando o no una categoria especifica
					gestorEspectaculos.espectaculosConEntradas();//hacer funcion
					
				case 8:
					//Publicar una critica para un espectaculo que ya se ha celebrado
					System.out.println("Inserta la fecha en la que fue el espectaculo: ");
					System.out.println("\nAnio: ");
					int anoEspectaculo=entrada.nextInt();
					System.out.println("\nMes: ");
					int mesEspectaculo=entrada.nextInt();
					System.out.println("\ndia: ");
					int diaEspectaculo=entrada.nextInt();
					
					LocalDate fechaActual=LocalDate.now();
					LocalDate fechaEspectaculo=LocalDate.of(anoEspectaculo,mesEspectaculo,diaEspectaculo);
					if(fechaEspectaculo.isBefore(fechaActual)) {
						System.out.println("\nIntroduce el id de tu critica: ");
						entrada= new Scanner(System.in);
						int id=entrada.nextInt();
						
						System.out.println("\nIntroduce el titulo de tu critica: ");
						entrada= new Scanner(System.in);
						String tituloCritica=entrada.nextLine();
						
						System.out.println("\nIntroduce el id del espectaculo: ");
						entrada= new Scanner(System.in);
						int id_espectaculo=entrada.nextInt();
						
						
						Espectaculo espectaculoAux = gestorDAO.getEspectaculos().obtenerEspectaculo(id_espectaculo);
						
						
						String titulo=espectaculoAux.getTitulo();
						String descripcion=espectaculoAux.getDescripcion();
						ArrayList<String> categorias=espectaculoAux.getCategorias();
						
						Espectaculo espect= new Espectaculo(id_espectaculo, titulo,descripcion, categorias);   //***Id de espectaculo deberia ser int(numero)****
						
						System.out.println("\nIntroduce tu critica: ");
						entrada= new Scanner(System.in);
						String critica=entrada.nextLine();
						
						System.out.println("\nIntroduce la puntuacion al espectaculo: ");
						entrada= new Scanner(System.in);
						int puntuacion=entrada.nextInt();
						
						gestorCriticas.crearCritica(id, tituloCritica , usr , espect, critica ,puntuacion);//funcion gestorCriticas
						break;
					}
					break;
					
				case 9:
					
					System.out.println("\n");
					gestorCriticas.consultarCriticas();
					System.out.println("\n");
					
				case 10:
					//.Eliminar criticas de un espectaculo, por parte del usuario que la crea
					System.out.println("\nIntroduce la id de la critica que quieres borrar: ");
					entrada= new Scanner(System.in);
					int idBorrarCritica=entrada.nextInt();
					
					System.out.println("\nIntroduce tu nickname: ");
					entrada=new Scanner(System.in);
					String nicknameBorrarCritica=entrada.nextLine();
					
					Usuario usuarioAux = gestorDAO.getUsuarios().obtener(nicknameBorrarCritica);
					
					gestorCriticas.borraCritica(usuarioAux, idBorrarCritica);

				case 11:
					//.Valorar la utilidad de una critica publicada por otro usuario
					System.out.println("\nIntroduce tu nickname: ");
					entrada=new Scanner(System.in);
					String nicknameUtilidad=entrada.nextLine();
					
					Usuario usuarioAux2 = gestorDAO.getUsuarios().obtener(nicknameUtilidad);
					
					System.out.println("\nIntroduce la puntuacion a la utilidad de la critica: ");
					entrada= new Scanner(System.in);
					int valoracionUtilidad=entrada.nextInt();
					
					System.out.println("\nIntroduce el id de la critica valorada: ");
					entrada= new Scanner(System.in);
					String idCriticaUtilidad=entrada.nextLine();
					
					Critica criticaAux = gestorDAO.getCriticas().obtener(idCriticaUtilidad);
					
					gestorCriticas.votarUtilidad(usuarioAux2,valoracionUtilidad, criticaAux);

				case 12:
					break;
				default:
					System.out.println("\nError al insertar numero, tiene que ser del 1 al 12, ni mas ni menos.\n");
					
			}
		
		}

	}
	
}
