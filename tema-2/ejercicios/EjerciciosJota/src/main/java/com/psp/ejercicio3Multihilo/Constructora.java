package com.psp.ejercicio3Multihilo;

public class Constructora {
    public static void main(String[] args) {
        Fabrica f = new Fabrica();
        Obra o1 = new Obra(1,200,4);
        Obra o2 = new Obra(2,400,2);
        o2.start();o1.start();f.start();
    }
}
