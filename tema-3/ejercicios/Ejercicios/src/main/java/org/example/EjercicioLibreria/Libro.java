package org.example.EjercicioLibreria;

import java.io.Serializable;
import java.util.List;

public class Libro implements Serializable {

    //ATRIBUTOS

    private int cantidad;
    private String titulo;
//-----------------------------------------------------------------------------------------
    //CONSTRUCTORES

    public Libro(){

    }

    public Libro(int cantidad, String titulo){
        this.cantidad = cantidad;
        this.titulo = titulo;
    }

//-----------------------------------------------------------------------------------------
    //MÉTODOS

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString(){
        return "Nombre libro: " +getTitulo();
    }
}