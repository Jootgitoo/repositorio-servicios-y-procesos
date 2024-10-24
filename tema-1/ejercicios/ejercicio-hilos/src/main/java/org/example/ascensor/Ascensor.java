package org.example.ascensor;

import org.example.saludo.Saludar;

public class Ascensor {

    private int pisoActual;
    private int maxPisos;

    private static Ascensor instance = null;

        private Ascensor(){
        }

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
