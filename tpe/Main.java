package tpe;

import java.util.List;

public class Main {

	public static void main(String args[]) {
		///
		Servicios servicios = new Servicios("./tpe/datasets/Procesadores.csv",
				// "./tpe/datasets/Tareas.csv");
				"./tpe/datasets/TareasExtended.csv");

		/*
		 * for (Tarea tarea : servicios.getTareas()) {
		 * System.out.println(tarea);
		 * }
		 */

		/*
		 * Tarea tarea = servicios.servicio1("T14500");
		 * System.out.println(tarea);
		 */

		long startTime = System.currentTimeMillis();// inicio tiempo
		List<Tarea> tareasCriticas = servicios.servicio2(true);
		System.out.println("Cantidad de tareas criticas: " + tareasCriticas.size());
		fin(startTime);// fin tiempo
		/*
		 * for (Tarea tarea : tareasCriticas) {
		 * System.out.println(tarea);
		 * }
		 */

	}

	public static void fin(long startTime) {
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Tiempo de ejecución: " + totalTime + " milisegundos");
	}

}
