package Data;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import business.gestorEspectaculos;
import java.time.LocalDate;
import java.time.LocalTime;

public class MainTotal2 
{
	public static void main(String args[])
	{
		System.out.println("Elige una de las siguientes opciones:\n");
		System.out.println("1. Dar de alta un espectáculo, incluyendo al menos una fecha de representación\r\n"
				+ "2. Cancelar un espectáculo (todas las sesiones o una en particular)\r\n"
				+ "3. Actualizar los datos de un espectáculo\r\n"
				+ "4. Contabilizar la venta de entradas para una sesión de un espectáculo\r\n"
				+ "5. Consultar las localidades disponibles para un espectáculo, dada una fecha de\r\n"
				+ "representación\r\n"
				+ "6. Búsqueda de espectáculos por título o por categoría\r\n"
				+ "Práctica 1: Iniciación a Java Pág. 4\r\n"
				+ "7. Búsqueda de próximos espectáculos con entradas disponibles, indicando o no una\r\n"
				+ "categoría específica\r\n"
				+ "8. Publicar una crítica para un espectáculo que ya se ha celebrado\r\n"
				+ "9. Consultar las críticas de un espectáculo, dado su título\r\n"
				+ "10.Eliminar críticas de un espectáculo, por parte del usuario que la creó\r\n"
				+ "11.Valorar la utilidad de una crítica publicada por otro usuario\n");
		Scanner entrada= new Scanner(System.in);
		int opcion=entrada.nextInt();
		int i=0;
		
		while(true)
		{
			if(i!=0)
			{
				System.out.println("Elige alguna de las siguientes opciones de nuevo.\n");
				System.out.println("1. Dar de alta un espectáculo, incluyendo al menos una fecha de representación\r\n"
						+ "2. Cancelar un espectáculo (todas las sesiones o una en particular)\r\n"
						+ "3. Actualizar los datos de un espectáculo\r\n"
						+ "4. Contabilizar la venta de entradas para una sesión de un espectáculo\r\n"
						+ "5. Consultar las localidades disponibles para un espectáculo, dada una fecha de representación\r\n"
						+ "6. Búsqueda de espectáculos por título o por categoría\r\n"
						+ "7. Búsqueda de próximos espectáculos con entradas disponibles, indicando o no una categoría específica\r\n"
						+ "8. Publicar una crítica para un espectáculo que ya se ha celebrado\r\n"
						+ "9. Consultar las críticas de un espectáculo, dado su título\r\n"
						+ "10.Eliminar críticas de un espectáculo, por parte del usuario que la creó\r\n"
						+ "11.Valorar la utilidad de una crítica publicada por otro usuario\r\n"
						+ "12.Salir del gestor de espectaculos\n");
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
					darAltaEspectaculo(idEspectaculo, fecha, time);
					
					System.out.println("\nEspectaculo dado de alta\n");
					
				case 2:
					//Cancelar un espectáculo
					System.out.println("Id del espectaculo que quieres cancelar: ");
					int idEspectaculoBorrar= entrada.nextInt();
					cancelarEspectaculo(idEspectaculoBorrar);
					System.out.println("\nEspectaculo cancelado\n");
					
				case 3:
					// Actualizar los datos de un espectáculo
					System.out.println("Introduce el id del espectaculo que quieres modificar: ");	
					int idCambio= entrada.nextInt();
					
					System.out.println("\nIntroduce la nueva fecha y la hora del espectaculo:\n");
					System.out.println("\nAño: ");
					int añoCambio=entrada.nextInt();
					System.out.println("\nMes: ");
					int mesCambio=entrada.nextInt();
					System.out.println("\ndia: ");
					int diaCambio=entrada.nextInt();
					
					LocalDate fechaCambio=LocalDate.of(año,mes,dia);//Guarda en fecha la fecha.
					
					System.out.println("\nHora:");
					int horasCambio=entrada.nextInt();
					System.out.println("\nMinutos:");
					int minutosCambio=entrada.nextInt();
					int segundosCambio=00;
					
					LocalTime timeCambio=LocalTime.of(horas,minutos,segundos);//Guarda en time la hora del espectaculo.
					actualizarDatos(idEspectaculo, fechaCambio, timeCambio);
					
					System.out.println("\nEspectaculo cambiado\n");
					
				case 4:
					//. Contabilizar la venta de entradas para una sesión de un espectáculo
					System.out.println("Introduce el id del espectaculo del cual quieres ver las entradas vendidas:");
					int idContabilizar=entrada.nextInt();
					int numeroVentas = contabilizarEntradas(idContabilizar);
					System.out.println("\n Se han vendido "+numeroVentas+" entradas.\n");
					
				case 5: 
					//Consultar las localidades disponibles para un espectáculo, dada una fecha de representación
					System.out.println("Introduce la fecha de la que quieres saber las plazas restantes:\n");
					System.out.println("\nAño: ");
					int añoLocalidadesRestantes=entrada.nextInt();
					System.out.println("\nMes: ");
					int mesLocalidadesRestantes=entrada.nextInt();
					System.out.println("\ndia: ");
					int diaLocalidadesRestantes=entrada.nextInt();
					
					LocalDate fechaLocalidadesRestantes=LocalDate.of(añoLocalidadesRestantes,mesLocalidadesRestantes,diaLocalidadesRestantes);
					int numeroLocalidadesRestantes=localidadesRestantes(fechaLocalidadesRestantes);
					
					System.out.println("\n Para esa fecha, quedan "+numeroLocalidadesRestantes+" entradas.\n");
					
				case 6:
					//. Búsqueda de espectáculos por título o por categoría
					System.out.println("Inserta 1 para introducir titulo o 2 para introducir categoria:");
					int eleccion=entrada.nextInt();
					switch(eleccion)
					{
					case 1:
						System.out.println("\nInserta el titulo:");
						String tituloBusqueda=entrada.nextLine();
						busquedaTitulo(tituloBusqueda);
						break;
						
					case 2:
						System.out.println("\nInserta la categoria:");
						String categoriaBusqueda=entrada.nextLine();
						busquedaCategoria(categoriaBusqueda);
						break;
					}
					
				case 7:
					//Búsqueda de próximos espectáculos con entradas disponibles, indicando o no una categoría específica
					espectaculosConEntradas();
					
				case 8:
					//Publicar una crítica para un espectáculo que ya se ha celebrado
					System.out.println("Inserta la fecha en la que fue el espectaculo: ");
					System.out.println("\nAño: ");
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
						
						crearCritica Cr= new crearCritica(usr,id, espect, critica, puntuacion);
						break;
					}
					break;
					
				case 9:
					//. Consultar las críticas de un espectáculo, dado su título
					//Falta la funcion pa hacerlo
				case 10:
					//.Eliminar críticas de un espectáculo, por parte del usuario que la creó
					System.out.println("\nIntroduce la id de laa critica que quieres borrar: ");
					entrada= new Scanner(System.in);
					int idBorrarCritica=entrada.nextInt();
					
					System.out.println("\nIntroduce tu nickname: ");
					entrada=new Scanner(System.in);
					String nicknameBorrarCritica=entrada.nextLine();
					
					//Aqui hay que crear una funcion para que introduciendo un nickname nos den todos los datos del usuario.
					
					borraCritica(autorSupuesto, idBorrarCritica);

				case 11:
					//.Valorar la utilidad de una crítica publicada por otro usuario
					System.out.println("\nIntroduce tu nickname: ");
					entrada=new Scanner(System.in);
					String nicknameUtilidad=entrada.nextLine();//FALTA LA FUNCION DE INTRODUCIR NICKNAME Y QUE DEVUELVA UN USUARIO
					
					System.out.println("\nIntroduce la puntuacion a la utilidad de la critica: ");
					entrada= new Scanner(System.in);
					int valoracionUtilidad=entrada.nextInt();
					
					System.out.println("\nIntroduce el id de la critica valorada: ");
					entrada= new Scanner(System.in);
					int idCriticaUtilidad=entrada.nextInt();
					
					votarUtilidad(usuarioRegistrado,valoracionUtilidad, idCriticaUtilidad);

				case 12:
					break;
				default:
					System.out.println("\nError al insertar numero, tiene que ser del 1 al 12, ni mas ni menos.\n");
					
			}
		
		}

	}
	
}
