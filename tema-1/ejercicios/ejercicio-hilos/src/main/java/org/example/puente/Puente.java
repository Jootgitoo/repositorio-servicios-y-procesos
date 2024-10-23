package org.example.puente;

import org.example.ascensor.Ascensor;

public class Puente {

    //PATRON SINGLETON

    //1. Atributo
    private static Puente instance = null;

    //2. Constructor vacio
    private Puente(){

    }

    //3. Métodos
    private synchronized static void createInstance(){
        if (instance == null){
            instance = new Puente();
        }
    }

    public static Puente getInstance(){

        if (instance == null){
            createInstance();
        }
        return instance;
    }

//----------------------------------------------------------------------------
    private int turno = 1;
    public synchronized void pasoVehiculos(String sitioEntrada, int idVehiculo){

        while (turno != idVehiculo){

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try{


            System.out.println("Pasando vehiculo " +idVehiculo + " por la entrada " +sitioEntrada);
            Thread.sleep(2000);
            System.out.println("Vehiculo saliendo del puente");
            System.out.println();

            turno++;
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
