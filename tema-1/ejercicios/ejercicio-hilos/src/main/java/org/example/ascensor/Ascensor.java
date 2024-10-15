package org.example.ascensor;

public class Ascensor {

    private int pisoActual;
    private int maxPisos;

    /**
     * Este método te lleva del piso actual al piso destino
     * @param pisoDestino
     */
    public synchronized void moverPiso(int pisoDestino){
        Thread.sleep(1000);
    }

    //El constructor es privado para que no se creen varias instancias
}
