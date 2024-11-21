package org.example.Barbero;

public class Sillas {

    int contadorSillasOcupadas = 0;
    private final static int SILLAS_MAXIMO = 10;
    private static Sillas instance = null;

    private Sillas(){
    }

    private synchronized static void createInstance(){

        if (instance == null){
            instance = new Sillas();
        }

    }

    public static Sillas getInstance(){

        if (instance == null){

            createInstance();
        }
        return instance;
    }

    public synchronized void elegirSilla(int idCLiente) throws InterruptedException {
        if (contadorSillasOcupadas < 10){
            contadorSillasOcupadas++;
            System.out.println("Cliente "+idCLiente+ " ha encontrado la silla " +contadorSillasOcupadas);
            Thread.sleep(250);
        } else {
            Thread.interrupted();
            System.out.println("Cliente " +idCLiente+ " me marcho, no hay sillas libres");
            
        }
    }

    public synchronized void cortarPelo(int idBarbero){

        System.out.println("Barbero: " +idBarbero +"cortando el pelo...");
        System.out.println("El cliente se va");
        contadorSillasOcupadas--;
    }
}
