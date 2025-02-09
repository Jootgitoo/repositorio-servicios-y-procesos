package es.jorge;

import java.io.*;

public class CuentaPalabras {

    public static int contarPalabras(String fileName) throws IOException {
        int numeroPalabras = 0;

        File fichero = new File(fileName);

        FileReader fr = new FileReader(fichero);

        BufferedReader bfr = new BufferedReader(fr);

        String linea;
        String[] arrayPalabras;

        while( (linea = bfr.readLine()) != null ){

            arrayPalabras = linea.split(" ");

            numeroPalabras += arrayPalabras.length;
        }

        return numeroPalabras;
    }

    public static void main(String[] args) throws IOException {
        String fichero = args[0];
        int numeroPalabras = CuentaPalabras.contarPalabras(fichero);
        System.out.println("Hay " + numeroPalabras+ " palabras en el fichero");
    }
}