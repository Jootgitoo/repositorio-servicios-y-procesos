package org.example.CarrerasCoches;

import java.util.Random;

public class Carrera {

    private int longitudCarrera;
    private boolean carreraFinalizada;

    private static Carrera instance = null;

    private Carrera(){
        Random random = new Random();
        this.longitudCarrera = random.nextInt(1001) +1; //Saca un numero aleatorio entre el 1 y el 1000
        System.out.println("La longitud de la carrera es: " +this.longitudCarrera);

        carreraFinalizada = false;
    }

    private synchronized static void createInstance(){

        if (instance == null){
            instance = new Carrera();
        }

    }

    public static Carrera getInstance(){

        if (instance == null){

            createInstance();
        }
        return instance;
    }

    public int getLongitudCarrera() {
        return longitudCarrera;
    }
    public boolean getCarreraFinalizada(){
        return carreraFinalizada;
    }


    public synchronized void avanzaCoche(int distanciaRecorrida, String nombreCoche) throws InterruptedException {


            comprobarGanador(distanciaRecorrida, nombreCoche);
            Thread.sleep(1000);


    }

    public synchronized void comprobarGanador(int distanciaRecorrida, String nombreCoche)
    {

        if(distanciaRecorrida > this.longitudCarrera){
            carreraFinalizada = true;
            System.out.println("El coche " + nombreCoche + "ha ganado la carrera");

        } else {

            int porcentajeRecorrido = ( (distanciaRecorrida * 100) / this.longitudCarrera);
            System.out.println("El coche " + nombreCoche + "lleva recorrida el " +porcentajeRecorrido+ "% de la distancia");

        }


    }


}




