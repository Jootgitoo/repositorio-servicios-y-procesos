package org.example.Barbero;

public class Sillas {

    int contadorSillasOcupadas = 0;
    private final static int NUMERO_SILLAS_MAXIMO = 10;
    private static Sillas instance = null;

    public int getContadorSillasOcupadas() {
        return contadorSillasOcupadas;
    }

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
        if (contadorSillasOcupadas < NUMERO_SILLAS_MAXIMO){
            contadorSillasOcupadas++;
            System.out.println("Cliente "+idCLiente+ ": Ha encontrado la silla " +contadorSillasOcupadas);

        } else {
            System.out.println("Cliente " +idCLiente+ ": Me marcho, no hay sillas libres");
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void cortarPelo(int idBarbero) throws InterruptedException{

        if (contadorSillasOcupadas > 0) {
            System.out.println("Barbero: " + idBarbero + " cortando el pelo...");
            Thread.sleep(250);
            System.out.println("El cliente se va");
            contadorSillasOcupadas--;
        }

    }
}
