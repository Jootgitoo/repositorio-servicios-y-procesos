package org.example.puente;

import org.example.ascensor.Ascensor;

public class Puente {

    //ATRIBUTOS
    private int turno = 1;

//-------------------------------------------------------------------------
    //PATRON SINGLETON

    //1. Instanciamos una varibale tipo Puente a null
    private static Puente instance = null;

    //2. Constructor privado y vacio
    private Puente(){
    }

    //3. Creamos la instancia
    private static synchronized void createInstace(){

        if(instance == null){
            instance = new Puente();
        }
    }

    //4. Comprobamos que tenga instancia, si no la tiene se crea
    public static Puente getInstance(){

        if (instance == null){
            createInstace();
        }
        return instance;
    }


    public synchronized void puedePasar(int numeroTurno){
        if (numeroTurno != turno){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void avisar(){
        turno++;
        notifyAll();
    }
}
