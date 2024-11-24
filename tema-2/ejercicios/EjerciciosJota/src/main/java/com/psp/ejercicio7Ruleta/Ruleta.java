package com.psp.ejercicio7Ruleta;

public class Ruleta {
    public static void main(String[] args) {
        Jugador j1 = new Jugador(1);
        Jugador j2 = new Jugador(2);
        Jugador j3 = new Jugador(3);
        Jugador j4 = new Jugador(4);
        Croupier c = new Croupier();

        j1.start();
        j2.start();
        j3.start();
        j4.start();
        c.start();

        try {
            j1.join();
            j2.join();
            j3.join();
            j4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        c.interrupt();


    }
}
