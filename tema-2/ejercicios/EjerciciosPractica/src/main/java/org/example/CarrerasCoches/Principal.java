package org.example.CarrerasCoches;

public class Principal {
    public static void main(String[] args) {
        Coche c1 = new Coche("Opel");
        Coche c2 = new Coche("Ford");
        Coche c3 = new Coche("Seat");

        c1.start();
        c2.start();
        c3.start();

        try {
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}