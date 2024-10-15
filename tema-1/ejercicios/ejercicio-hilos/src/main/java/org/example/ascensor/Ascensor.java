package org.example.ascensor;

import org.example.saludo.Saludar;

public class Ascensor {

    private int pisoActual;
    private int maxPisos;

    private static  Ascensor instance = null;

    //El constructor es privado para que no se creen varias instancias
    private Ascensor(){

    }

    //De aqui hasta la siguiente marca se hace siempre igual pero obviamente poniendo el nombre que toque
    private synchronized static void createInstance(){

        if (instance == null){
            instance = new Ascensor();
        }

    }

    public static Ascensor getInstance(){

        if (instance == null){

            createInstance();
        }
        return instance;
    }

    /**
     * Este método te lleva del piso actual al piso destino
     * @param pisoDestino
     */
    public synchronized void moverArcensor(int pisoDestino){
        try{
            Thread.sleep(1000);
            System.out.println("Usuario movido al piso " +pisoDestino);

        }catch (InterruptedException ex){
            System.out.println(ex);
        }

    }

}
