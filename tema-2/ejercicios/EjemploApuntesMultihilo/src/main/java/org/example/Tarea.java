package org.example;

public class Tarea extends Thread {

    Contador contador;

    public Tarea(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            contador.incrementar();
        }
    }
}