package com.psp.dos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo4 {

    public static void main(String[] args) {

        Process p;
        InputStream inputStream = null;

        try {

            //Lanzas el proceso
            p = new ProcessBuilder("ping", "www.google.es").start();

            //Guardas la salida --> UN PROCESO SIEMPRE DEVUELVE UN INPUTSTREAM
            inputStream = p.getInputStream();

            //Escribes la salida caracter a caracater
            int c;
            while ( (c = inputStream.read()) != -1 ){
                System.out.print( (char) c);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}