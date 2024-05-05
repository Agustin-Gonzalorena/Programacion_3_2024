package tpe;

public class Tarea {
    private String id;
    private String nombre;
    private int tiempo;
    private boolean critica;
    private int prioridad;

    public Tarea(String id, String nombre, int tiempo, boolean critica, int prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.critica = critica;
        this.prioridad = prioridad;
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getTiempo() {
        return this.tiempo;
    }

    public boolean isCritica() {
        return this.critica;
    }

    public int getPrioridad() {
        return this.prioridad;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", nombre=" + nombre + ", tiempo=" + tiempo + ", critica=" + critica + ", prioridad="
                + prioridad + "]";
    }

}
