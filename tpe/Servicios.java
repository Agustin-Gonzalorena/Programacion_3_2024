package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tpe.utils.CSVReader;

/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {
	private HashMap<String, Tarea> tareas;

	/*
	 * Expresar la complejidad temporal del constructor.
	 */
	public Servicios(String pathProcesadores, String pathTareas) {
		CSVReader reader = new CSVReader();
		reader.readProcessors(pathProcesadores);
		this.tareas = reader.readTasks(pathTareas);
	}

	// borrar metodo
	public ArrayList<Tarea> getTareas() {
		return new ArrayList<Tarea>(this.tareas.values());
	}

	/*
	 * Expresar la complejidad temporal del servicio 1.
	 */
	public Tarea servicio1(String ID) { // O(1)
		return this.tareas.get(ID);
	}

	/*
	 * Expresar la complejidad temporal del servicio 2.
	 */
	public List<Tarea> servicio2(boolean esCritica) { // O(n)
		List<Tarea> tareasCriticas = new ArrayList<Tarea>();
		for (Tarea tarea : this.tareas.values()) {
			if (tarea.isCritica() == esCritica) {
				tareasCriticas.add(tarea);
			}
		}
		return tareasCriticas;
	}

	/*
	 * Expresar la complejidad temporal del servicio 3.
	 */
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) { // O(n)
		List<Tarea> tareas = new ArrayList<Tarea>();
		for (Tarea tarea : this.tareas.values()) {
			if (tarea.getPrioridad() >= prioridadInferior && tarea.getPrioridad() <= prioridadSuperior) {
				tareas.add(tarea);
			}
		}
		return tareas;
	}

}
