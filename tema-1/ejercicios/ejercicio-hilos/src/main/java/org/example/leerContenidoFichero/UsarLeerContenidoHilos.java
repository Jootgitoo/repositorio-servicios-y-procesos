package org.example.leerContenidoFichero;

import java.io.File;

public class UsarLeerContenidoHilos {

    public static void main(String[] args) {

        File archivoALeer = new File("src/main/java/org/example/leerContenidoFichero/enuncaido.txt");

        for (int i=0; i<archivoALeer.length(); i++ ) {
            System.out.println("Creando hilo numero " + (i + 1));
            leerContenidoHilos hilo = new leerContenidoHilos();
            System.out.println("Hilo creado");
            System.out.println("");


            hilo.start();
        }
    }
}
