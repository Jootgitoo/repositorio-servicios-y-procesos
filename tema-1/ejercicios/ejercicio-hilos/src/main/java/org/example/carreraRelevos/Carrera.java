package org.example.carreraRelevos;

public class Carrera {

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


    public synchronized void correr(int dorsal) {



        System.out.println("Corriendo corredor número: " + dorsal);
        try {
            Thread.sleep(2000);  // Simula el tiempo de correr

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("Dorsal " + dorsal + " ha terminado de correr");
        avisar();
    }

    public synchronized void avisar() {
        System.out.println("Avisando a un hilo para que corra");
        notify();  // Notifica a uno de los hilos en espera
    }

}

