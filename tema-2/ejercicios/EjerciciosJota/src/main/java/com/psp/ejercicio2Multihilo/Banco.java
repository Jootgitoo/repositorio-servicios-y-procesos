package com.psp.ejercicio2Multihilo;

public class Banco {
    public static void main(String[] args) {
        Ingresa i = new Ingresa();
        Cobra c =new Cobra();
        i.start();
        c.start();
    }
}
