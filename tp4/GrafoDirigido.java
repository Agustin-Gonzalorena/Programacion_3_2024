
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, ArrayList<Arco<T>>> vertices;

	public GrafoDirigido() {
		this.vertices = new HashMap<>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		if (!contieneVertice(verticeId)) {
			vertices.put(verticeId, new ArrayList<Arco<T>>());
		}

	}

	@Override
	public void borrarVertice(int verticeId) {
		// Si el vertice verticeId existe en el grafo
		if (contieneVertice(verticeId)) {
			vertices.remove(verticeId);
			// Recorro todos los vertices del grafo
			for (int vertice : vertices.keySet()) {
				// Recorro los arcos del vertice vertice
				for (Arco<T> arco : vertices.get(vertice)) {
					// Si el vertice destino del arco es igual a verticeId
					if (arco.getVerticeDestino() == verticeId) {
						// Del vertice recorrido borro el arco que tiene como destino el vertice
						// verticeId
						vertices.get(vertice).remove(arco);
						break;
					}
				}
			}
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		// Si el vertice verticeId1 existe en el grafo
		if (contieneVertice(verticeId1)) {
			// Creo un arco con los vertices y la etiqueta
			Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
			// Agrego el arco a la lista de arcos del vertice verticeId1
			vertices.get(verticeId1).add(arco);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		// Si existe un arco entre los vertices verticeId1 y verticeId2
		if (existeArco(verticeId1, verticeId2)) {
			// Recorro los arcos del vertice verticeId1
			for (Arco<T> arco : vertices.get(verticeId1)) {
				// Si el vertice destino del arco es igual a verticeId2
				if (arco.getVerticeDestino() == verticeId2) {
					// Borro el arco de la lista de arcos del vertice verticeId1
					vertices.get(verticeId1).remove(arco);
					break;
				}
			}
		}

	}

	@Override
	public boolean contieneVertice(int verticeId) {
		// metodo .containsKey() de HashMap que devuelve true si la clave verticeId
		// existe en el HashMap
		if (vertices.containsKey(verticeId))
			return true;
		else
			return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		// Si el vertice verticeId1 existe en el grafo
		if (contieneVertice(verticeId1)) {
			// Recorro los arcos del vertice verticeId1
			// vertices.get(verticeId1) me devuelve la lista de arcos del vertice verticeId1
			for (Arco<T> arco : vertices.get(verticeId1)) {
				// Si el vertice destino del arco es igual a verticeId2
				if (arco.getVerticeDestino() == verticeId2) {
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// Si existe un arco entre los vertices verticeId1 y verticeId2
		if (existeArco(verticeId1, verticeId2)) {
			// Recorro los arcos del vertice verticeId1
			for (Arco<T> arco : vertices.get(verticeId1)) {
				// Si el vertice destino del arco es igual a verticeId2
				if (arco.getVerticeDestino() == verticeId2) {
					return arco;
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int cantidadArcos = 0;
		// Recorro todos los vertices del grafo
		for (int v : vertices.keySet()) {
			// Sumo la cantidad de arcos del vertice v
			cantidadArcos += vertices.get(v).size();
		}
		return cantidadArcos;
	}
	// vertices.get(v) me devuelve la lista de arcos del vertice v y
	// con size() obtengo la cantidad de arcos de la lista

	@Override
	public Iterator<Integer> obtenerVertices() {
		// metodo .keySet() de HashMap que devuelve un Set con las claves del HashMap
		return vertices.keySet().iterator();
		// resultados que devuelve: vertices.keySet().iterator() = [verticeId1,
		// verticeId2, verticeId3, ...]

	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		return new IteradorAdyacentes<T>(this.vertices, verticeId);
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		return new InteradorArco<T>(this.vertices, verticeId);
	}

}
