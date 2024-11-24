package com.psp.ejercicio8Filosofos;

public class Lanzador {
    public static void main(String[] args) {

        Filosofo [] filosofos = new Filosofo[5];

        for (int i = 0; i< filosofos.length;i++){
            filosofos[i] = new Filosofo(i);
            filosofos[i].start();
        }
    }
}
