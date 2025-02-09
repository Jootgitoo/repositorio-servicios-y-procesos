package es.jorge;

import java.io.*;

public class BuscarPalabra {

    public static int buscarPalabra(String fichero, String palabra) throws IOException {

        int contadorPalabra = 0;

        InputStreamReader isr = new InputStreamReader( new FileInputStream(fichero));
        BufferedReader bfr = new BufferedReader(isr);

        String linea;
        while ( (linea = bfr.readLine()) != null){
            String[] listaPalabras = linea.split(" ");

            for(String p : listaPalabras){

                if(p.equals(palabra)){
                    contadorPalabra++;
                }
            }
        }

        return contadorPalabra;
    }

    public static void main(String[] args) throws IOException {
        String fichero = args[0];
        String palabra = args[1];

        int numeroVeces = BuscarPalabra.buscarPalabra(fichero, palabra);

        System.out.println("Se ha encontrado " +numeroVeces+ " veces la palabra " +palabra);
    }
}

















