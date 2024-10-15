package org.example.ascensor;

public class SimuladorArcensor {

    public static void main(String[] args) {

        Usuario usuario1 = new Usuario(12);
        Usuario usuario2 = new Usuario(3);
        Usuario usuario3 = new Usuario(15);
        Usuario usuario4 = new Usuario(1);

        usuario1.start();
        usuario2.start();
        usuario3.start();
        usuario4.start();
    }

}
