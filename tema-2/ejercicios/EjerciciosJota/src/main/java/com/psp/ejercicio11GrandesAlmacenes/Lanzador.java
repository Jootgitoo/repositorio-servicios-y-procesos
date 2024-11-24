package com.psp.ejercicio11GrandesAlmacenes;

public class Lanzador {
    public static void main(String[] args) {
        Cliente[] clientes = new Cliente[300];
        for (int i = 0; i< 300; i++){
            clientes[i] = new Cliente(i+1);
            clientes[i].start();
        }
    }
}
