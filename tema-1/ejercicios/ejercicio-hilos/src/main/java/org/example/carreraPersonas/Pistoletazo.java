package org.example.carreraPersonas;

public class Pistoletazo {

    //Implementaci�n de Singleton
    private static Pistoletazo instance = null;

    // Poner el constructor privado para que no se puedan crear más instancias
    private Pistoletazo(){
    }

    // creador sincronizado para protegerse de posibles problemas multi-hilo
    // garantizar que solo habrá una única instancia
    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new Pistoletazo();
        }
    }

    // crear metodo publico y estatico que me permita obtener la referencia a la
    // clase
    public static Pistoletazo getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    public synchronized void esperar() throws InterruptedException {
        this.wait();
    }

    public synchronized void avisar() {
        notifyAll();
    }

}