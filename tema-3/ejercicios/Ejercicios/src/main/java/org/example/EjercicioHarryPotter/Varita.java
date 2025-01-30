package org.example.EjercicioHarryPotter;

import java.io.Serializable;
import java.util.HashMap;

public class Varita implements Serializable {

    //ATRIBUTOS
    private int numero;
    private String nombre;

//------------------------------------------------------------------------------------
    //CONSTRUCTORES

    public Varita(int numeroVaritas, String nombreVarita){
        this.numero = numeroVaritas;
        this.nombre = nombreVarita;
    }

//--------------------------------------------------------------------------------------
    //MÉTODOS

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return "Nombre varita: "+getNombre();
    }
}