
import java.util.Scanner;

import Data.Critica;
import Data.Espectaculo;
import Data.Usuario;

import java.util.ArrayList;
import java.util.Date;
import business.gestorEspectaculos;
import java.time.LocalDate;
import java.time.LocalTime;



public class MainTotal2 
{
	static ArrayList<String> categorias;
	
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
					System.out.println("\nAño: ");
					int año=entrada.nextInt();
					System.out.println("\nMes: ");
					int mes=entrada.nextInt();
					System.out.println("\ndia: ");
					int dia=entrada.nextInt();
					
					LocalDate fecha=LocalDate.of(año,mes,dia);//Guarda en fecha la fecha.
					
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
					//. Contabilizar la venta de entradas para una sesiÃ³n de un espectÃ¡culo
					System.out.println("Introduce el id del espectaculo del cual quieres ver las entradas vendidas:");
					int idContabilizar=entrada.nextInt();
					int numeroVentas = contabilizarEntradas(idContabilizar);//hacer funcion
					System.out.println("\n Se han vendido "+numeroVentas+" entradas.\n");
					
				case 5: 
					//Consultar las localidades disponibles para un espectÃ¡culo, dada una fecha de representaciÃ³n
					System.out.println("Introduce la fecha de la que quieres saber las plazas restantes:\n");
					System.out.println("\nAño: ");
					int añoLocalidadesRestantes=entrada.nextInt();
					System.out.println("\nMes: ");
					int mesLocalidadesRestantes=entrada.nextInt();
					System.out.println("\ndia: ");
					int diaLocalidadesRestantes=entrada.nextInt();
					
					LocalDate fechaLocalidadesRestantes=LocalDate.of(añoLocalidadesRestantes,mesLocalidadesRestantes,diaLocalidadesRestantes);
					int numeroLocalidadesRestantes=localidadesRestantes(fechaLocalidadesRestantes);//hacer funcion
					
					System.out.println("\n Para esa fecha, quedan "+numeroLocalidadesRestantes+" entradas.\n");
					
				case 6:
					//. Busqueda de espectÃ¡culos por tÃ­tulo o por categorÃ­a
					System.out.println("Inserta 1 para introducir titulo o 2 para introducir categoria:");
					int eleccion=entrada.nextInt();
					switch(eleccion)
					{
					case 1:
						System.out.println("\nInserta el titulo:");
						String tituloBusqueda=entrada.nextLine();
						busquedaTitulo(tituloBusqueda);//funcion en gestorEspectaculos
						break;
						
					case 2:
						System.out.println("\nInserta la categoria:");
						String categoriaBusqueda=entrada.nextLine();
						busquedaCategoria(categoriaBusqueda);///funcion en gestorEspectaculos
						break;
					}
					
				case 7:
					//BÃºsqueda de prÃ³ximos espectÃ¡culos con entradas disponibles, indicando o no una categorÃ­a especÃ­fica
					espectaculosConEntradas();//hacer funcion
					
				case 8:
					//Publicar una crÃ­tica para un espectÃ¡culo que ya se ha celebrado
					System.out.println("Inserta la fecha en la que fue el espectaculo: ");
					System.out.println("\nAÃ±o: ");
					int añoEspectaculo=entrada.nextInt();
					System.out.println("\nMes: ");
					int mesEspectaculo=entrada.nextInt();
					System.out.println("\ndia: ");
					int diaEspectaculo=entrada.nextInt();
					
					LocalDate fechaActual=LocalDate.now();
					LocalDate fechaEspectaculo=LocalDate.of(añoEspectaculo,mesEspectaculo,diaEspectaculo);
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
						//Aqui cuando nos dan el id, lo asociamos con el titulo,la descripcion y las categorias.FALTA FUNCION PARA ELLO
						
						String titulo=id.titulo(id_espectaculo);
						String descripcion=id.descripcion(id_espectaculo);
						ArrayList<String> categorias=id.categorias(id_espectaculo);
						
						Espectaculo espect= new Espectaculo(id_espectaculo, titulo,descripcion, categorias)   //***Id de espectaculo deberia ser int(numero)****
						
						System.out.println("\nIntroduce tu critica: ");
						entrada= new Scanner(System.in);
						String critica=entrada.nextLine();
						
						System.out.println("\nIntroduce la puntuacion al espectaculo: ");
						entrada= new Scanner(System.in);
						int puntuacion=entrada.nextInt();
						
						crearCritica(id, tituloCritica , usr , espect, critica ,puntuacion);//funcion gestorCriticas
						break;
					}
					break;
					
				case 9:
					
					System.out.println("\n");
					consultarCriticas();
					System.out.println("\n");
					
				case 10:
					//.Eliminar criticas de un espectaculo, por parte del usuario que la crea
					System.out.println("\nIntroduce la id de la critica que quieres borrar: ");
					entrada= new Scanner(System.in);
					int idBorrarCritica=entrada.nextInt();
					
					System.out.println("\nIntroduce tu nickname: ");
					entrada=new Scanner(System.in);
					String nicknameBorrarCritica=entrada.nextLine();
					
					//Aqui hay que crear una funcion para que introduciendo un nickname nos den todos los datos del usuario.
					
					borraCritica(autorSupuesto, idBorrarCritica);

				case 11:
					//.Valorar la utilidad de una critica publicada por otro usuario
					System.out.println("\nIntroduce tu nickname: ");
					entrada=new Scanner(System.in);
					String nicknameUtilidad=entrada.nextLine();//FALTA LA FUNCION DE INTRODUCIR NICKNAME Y QUE DEVUELVA UN USUARIO
					
					System.out.println("\nIntroduce la puntuacion a la utilidad de la critica: ");
					entrada= new Scanner(System.in);
					int valoracionUtilidad=entrada.nextInt();
					
					System.out.println("\nIntroduce el id de la critica valorada: ");
					entrada= new Scanner(System.in);
					int idCriticaUtilidad=entrada.nextInt();
					
					votarUtilidad(usuarioNickname,valoracionUtilidad, idCriticaUtilidad);

				case 12:
					break;
				default:
					System.out.println("\nError al insertar numero, tiene que ser del 1 al 12, ni mas ni menos.\n");
					
			}
		
		}

	}
	
}
