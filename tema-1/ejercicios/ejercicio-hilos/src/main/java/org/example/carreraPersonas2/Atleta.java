package org.example.carreraPersonas2;

public class Atleta extends Thread {
    private int dorsal;
    private Pistoletazo pistoletazo;

    public Atleta(int dorsal, Pistoletazo pistoletazo) {
        this.dorsal = dorsal;
        this.pistoletazo = pistoletazo;
    }

    @Override
    public void run() {

        try {
            //esperar a dar la salida
            pistoletazo.esperar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {

            long startTime = System.currentTimeMillis();
            System.out.println("Atleta " + dorsal + " empieza a correr.");
            long tiempoCarrera = (long) (9000 + Math.random() * 2000);
            Thread.sleep(tiempoCarrera);
            long tiempoFinal = System.currentTimeMillis() - startTime;
            System.out.println("Dorsal " + dorsal + " tarda " + tiempoFinal / 1000.0 + " segundos.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}