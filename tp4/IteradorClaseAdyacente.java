import java.util.Iterator;

public class IteradorClaseAdyacente<T> implements Iterator<Integer> {
    private Iterator<Arco<T>> iterador;

    public IteradorClaseAdyacente(Iterator<Arco<T>> iterador) {
        this.iterador = iterador;
    }

    @Override
    public boolean hasNext() {
        return iterador.hasNext();
    }

    @Override
    public Integer next() {
        return iterador.next().getVerticeDestino();
    }

}
