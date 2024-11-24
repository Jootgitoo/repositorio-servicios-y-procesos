package org.example.Filosofos;

public class Lanzador {
    public static void main(String[] args) {

        Filosofo f1 = new Filosofo(1);
        Filosofo f2 = new Filosofo(2);
        Filosofo f3 = new Filosofo(3);
        Filosofo f4 = new Filosofo(4);
        Filosofo f5 = new Filosofo(5);

        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();

        try {
            f1.join();
            f2.join();
            f3.join();
            f4.join();
            f5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
