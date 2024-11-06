package org.example.CarrerasCoches;

import java.util.Random;

public class Coche extends Thread{

    private String nombre;
    private int numeroMetrosActual;


    Carrera carrera;

    public Coche(String nombreCche){
        this.nombre = nombreCche;
        this.numeroMetrosActual = 0;

    }

    public synchronized int avanzaCoche() throws InterruptedException {


        Random random = new Random();
        this.numeroMetrosActual = numeroMetrosActual + random.nextInt(51) +1; //Saca un numero aleatorio entre el 1 y el 50
        Thread.sleep(1000);
        return numeroMetrosActual;
    }

    public synchronized void comprobarGanador()
    {

        if(carrera.getLongitudCarrera() < this.numeroMetrosActual){
            System.out.println("El coche " + this.nombre + "ha ganado la carrera");
        } else {

            int distanciaRecorrida = ( (this.numeroMetrosActual * 100) / carrera.getLongitudCarrera());
            System.out.println("El coche " + this.nombre + "lleva recorrida el " +distanciaRecorrida+ "% de la distancia");

        }

    }

    @Override
    public void run(){
        try {
            carrera.longitudCarrera();
            avanzaCoche();
            comprobarGanador();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
