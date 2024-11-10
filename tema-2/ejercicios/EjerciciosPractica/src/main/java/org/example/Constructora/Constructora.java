package org.example.Constructora;

public class Constructora {
    public static void main(String[] args) throws InterruptedException {

        Fabrica fabrica = new Fabrica();
        Obras obr1 = new Obras(1);
        Obras obr2 = new Obras(2);

        fabrica.start();
        obr1.start();
        obr2.start();

        fabrica.join();
        obr1.join();
        obr2.join();


    }
}
