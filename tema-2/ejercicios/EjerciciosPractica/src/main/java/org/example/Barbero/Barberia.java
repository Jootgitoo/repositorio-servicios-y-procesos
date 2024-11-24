package org.example.Barbero;

public class Barberia {
    public static void main(String[] args) {

        for (int i=0; i<= 50; i++){
            Clientes cliente = new Clientes(i+1);
            cliente.start();
        }

        for (int i=0; i<= 5; i++){
            Barbero barbero = new Barbero(i+1);
            barbero.start();
        }

    }
}