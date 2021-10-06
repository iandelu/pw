package Data;
import java.util.Scanner;
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
					System.out.println("\nIntroduce el tipo de espectaculo:");
					String tipoEspectaculo= entrada.nextLine();
					
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
					darAltaEspectaculo(tipoEspectaculo, fecha, time);
					
					System.out.println("\nEspectaculo dado de alta\n");
					
				case 2:
					//Cancelar un espectáculo
					System.out.println("Id del espectaculo que quieres cancelar: ");
					int idEspectaculo= entrada.nextInt();
					cancelarEspectaculo(idEspectaculo);
					System.out.println("\nEspectaculo cancelado\n");
					
				case 3:
					// Actualizar los datos de un espectáculo
					
				case 4:
				case 5: 
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				case 11:
				case 12:
			}
		
		
		
	}

}
