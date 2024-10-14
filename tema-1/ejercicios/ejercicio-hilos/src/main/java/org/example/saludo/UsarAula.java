package org.example.saludo;

public class UsarAula {

    public static void main(String[] args) {

        Aula alumno1 = new Aula("Jorge", true);
        Aula alumno2 = new Aula("Jota", false);
        Aula alumno3 = new Aula("Mateo", false);

        alumno2.start();
        alumno3.start();
        alumno1.start();

    }
}
