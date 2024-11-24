package org.example.Boxeo;

public class Lanzador {
    public static void main(String[] args) {

        Boxeador b1 = new Boxeador(1);
        Boxeador b2 = new Boxeador(2);
        Boxeador b3 = new Boxeador(3);
        Boxeador b4 = new Boxeador(4);

        System.out.println("El rival del Boxeador 1 es boxeador " +b1.getRival());
        System.out.println("El rival del Boxeador 2 es boxeador " +b2.getRival());
        System.out.println("El rival del Boxeador 3 es boxeador " +b3.getRival());
        System.out.println("El rival del Boxeador 4 es boxeador " +b4.getRival());

        b1.start();
        b2.start();
        b3.start();
        b4.start();


    }

}
