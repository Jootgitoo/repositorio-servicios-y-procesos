package org.example.carreraRelevos;

public class Carrera {

    private static Carrera instance = null;
    private int turnoActual=1;

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


    public synchronized void esperarRelevo(int dorsal) {


        while(dorsal!=turnoActual){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public synchronized void avisar() {
        System.out.println("Pasamos relevo");
        turnoActual++;
        notifyAll();  // Notifica a uno de los hilos en espera
    }

}

