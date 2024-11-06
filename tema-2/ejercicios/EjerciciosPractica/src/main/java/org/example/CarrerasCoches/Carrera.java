package org.example.CarrerasCoches;

import java.util.Random;

public class Carrera {

    private int longitudCarrera;
    private static Carrera instance = null;

    private Carrera(){
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

    public void longitudCarrera(){

        Random random = new Random();
        this.longitudCarrera = random.nextInt(1001) +1; //Saca un numero aleatorio entre el 1 y el 1000

        System.out.println("Longitud de la carrera: " +this.longitudCarrera);

    }


    public int getLongitudCarrera() {
        return longitudCarrera;
    }
}




