package org.example.leerContenidoFichero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class leerContenido {

    public static void leerFichero() {

        // Ruta del fichero a leer
        String rutaArchivo = "ruta/del/archivo.txt";

        // Variable para contar el número de palabras
        int numeroDePalabras = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en palabras usando espacios como delimitador
                String[] palabras = linea.split("\\s+");

                // Contar el número de palabras en la línea
                numeroDePalabras += palabras.length;
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Mostrar el número total de palabras
        System.out.println("Número total de palabras en el archivo: " + numeroDePalabras);
    }

}

