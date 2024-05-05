import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class InteradorArco<T> implements Iterator<Arco<T>> {
    private HashMap<Integer, ArrayList<Arco<T>>> vertices;
    private int v;

    public InteradorArco(HashMap<Integer, ArrayList<Arco<T>>> vertices, int v) {
        this.vertices = vertices;
        this.v = v;
    }

    @Override
    public boolean hasNext() {
        if (vertices.get(v).size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Arco<T> next() {
        Arco<T> arco = vertices.get(v).get(0);
        vertices.get(v).remove(arco);
        return arco;
    }
}
