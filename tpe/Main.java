package tpe;

import java.util.List;

public class Main {

	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		///
		Servicios servicios = new Servicios("./tpe/datasets/Procesadores.csv", "./tpe/datasets/Tareas.csv");

		/*
		 * for (Tarea tarea : servicios.getTareas()) {
		 * System.out.println(tarea);
		 * }
		 */

		/*
		 * Tarea tarea = servicios.servicio1("T14500");
		 * System.out.println(tarea);
		 */

		List<Tarea> tareasCriticas = servicios.servicio2(true);
		for (Tarea tarea : tareasCriticas) {
			System.out.println(tarea);
		}

		fin(startTime);

	}

	public static void fin(long startTime) {
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Tiempo de ejecución: " + totalTime + " milisegundos");
	}

}
