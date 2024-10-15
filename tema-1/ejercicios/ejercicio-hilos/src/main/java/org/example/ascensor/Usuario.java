package org.example.ascensor;

public class Usuario extends Thread {

    private int pisoDestino;

    private Ascensor ascensor;

    public Usuario (int pisoDestino){

        this.pisoDestino = pisoDestino;
        ascensor = Ascensor.getInstance();
    }

    @Override
    public void run(){

        ascensor.moverArcensor(pisoDestino);

    }

}
