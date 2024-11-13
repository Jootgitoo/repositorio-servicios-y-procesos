package org.example.Banco;

public class Banco {
    public static void main(String[] args) throws InterruptedException {

        Ingresa i = new Ingresa();
        Cobra c = new Cobra();

        i.start();
        c.start();

        i.join();
        c.join();





    }

}
