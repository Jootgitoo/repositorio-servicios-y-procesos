package org.example.CarrerasCoches;

import java.util.Random;

public class Coche extends Thread{

    private String nombre;
    private int distanciaRecorrida;
    private int metrosAvance;


    Carrera carrera;

    public Coche(String nombreCche){
        this.nombre = nombreCche;
        this.distanciaRecorrida = 0;
        this.metrosAvance = 0;
        carrera = Carrera.getInstance();

    }

    public void metrosAvanza(){
        Random random = new Random();
        this.metrosAvance = random.nextInt(51) +1; //Saca un numero aleatorio entre el 1 y el 50
        System.out.println("El coche " +this.nombre + "ha avanzado: " +this.metrosAvance+" metros");

    }


    @Override
    public void run(){
        try {
            metrosAvanza();
            while (!carrera.getCarreraFinalizada()){
               carrera.avanzaCoche(this.distanciaRecorrida,  this.nombre);

            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }
}
