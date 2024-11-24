package com.psp.ejercicio10Cola;

public class Lanzador {

    public static void main(String[] args) {
        Productor p = new Productor();
        Lector l = new Lector();

        p.start();l.start();
    }
}
