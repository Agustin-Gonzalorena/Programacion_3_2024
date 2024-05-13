import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class IteradorAdyacentes<T> implements Iterator<Integer> {
    private HashMap<Integer, ArrayList<Arco<T>>> vertices;

    private int v;

    public IteradorAdyacentes(HashMap<Integer, ArrayList<Arco<T>>> vertices, int v) {
        this.vertices = vertices;
        this.v = v;
    }

    @Override
    public boolean hasNext() {
        // Retorna true si el verticeId tiene adyacentes
        if (vertices.containsKey(v)) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        Arco<T> arco = vertices.get(v).get(0);
        Integer verticeTmp = arco.getVerticeDestino();
        vertices.get(v).remove(arco);
        return verticeTmp;
    }

    public T getEtiqueta() {
        return vertices.get(v).get(0).getEtiqueta();
    }
}