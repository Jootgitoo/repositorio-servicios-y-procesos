package es.jorge.Libreria;

import java.io.Serializable;

public class Libro implements Serializable {

    private String nombre;
    private int unidades;

    public Libro(String nombre, int unidades){
        this.nombre = nombre;
        this.unidades = unidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}