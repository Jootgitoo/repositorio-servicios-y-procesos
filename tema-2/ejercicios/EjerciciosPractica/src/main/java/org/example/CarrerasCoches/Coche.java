package org.example.CarrerasCoches;

import java.util.Random;

public class Coche extends Thread{

    private String nombre;
    private int numeroMetrosActual;
    private int numeroMetrosAnterior;

    Carrera carrera;

    public Coche(String nombreCche){
        this.nombre = nombreCche;
        this.numeroMetrosActual = 0;
        this.numeroMetrosAnterior = 0;
    }

    public int metrosAvanza(){
        this.numeroMetrosAnterior = this.numeroMetrosActual;

        Random random = new Random();
        this.numeroMetrosActual = numeroMetrosActual + random.nextInt(51) +1; //Saca un numero aleatorio entre el 1 y el 51

        return numeroMetrosActual;
    }

    public int getNumeroMetrosActual() {
        return numeroMetrosActual;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run(){

    }
}
