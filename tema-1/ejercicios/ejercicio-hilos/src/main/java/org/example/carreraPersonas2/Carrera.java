package org.example.carreraPersonas2;

public class Carrera {
    public static void main(String[] args) {
        Pistoletazo pistoletazo = new Pistoletazo();
        Atleta[] atletas = new Atleta[8];
        for (int i = 0; i < 8; i++) {
            atletas[i] = new Atleta(i + 1, pistoletazo);
            atletas[i].start();
        }

        System.out.println("Preparados...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Listos...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ya!");
        //avisar que empieza la carrera
        pistoletazo.avisar();
    }
}