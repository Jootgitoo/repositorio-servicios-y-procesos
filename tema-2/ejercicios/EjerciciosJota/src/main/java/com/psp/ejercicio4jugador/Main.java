package com.psp.ejercicio4jugador;

public class Main {
    public static void main(String[] args) {
        Jugador j1 = new Jugador(1);
        Jugador j2 = new Jugador(2);
        Jugador j3 = new Jugador(3);
        j1.start();j2.start();j3.start();
        System.out.println("Número a adivinar: "+Arbitro.getInstance().getNumeroGanador());
    }
}
