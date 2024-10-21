package com.psp.dos;

import java.io.IOException;
import java.io.InputStream;

public class Ejemplo2 {

    public static void main(String[] args) throws Exception {

        //Variable que se utilizará para lanzar el proceso
        ProcessBuilder pb;

        //Variable para leer lo que devuelva el proceso que lancemos
        InputStream is = null;

        try {
            // Ejecutamos el proceso dir
            //"cmd" --> ejecuta la consola de windows
            //"/C" --> Indica que el comando se ejecutará y luego se cierra la consola
            //"dir" --> Comando que se va a ejecutar el la consola. Este comando muestra los directorios / ficheros que hay dentro de la ruta especificada
            pb = new ProcessBuilder("CMD", "/C", "DIR");

            //Iniciamos el proceso
            Process p = pb.start();

            //Guardamos la salida del proceso
            is = p.getInputStream();
            int c;
            while( (c = is.read()) != -1) {
                System.out.print((char) c);
            }

            //recoger la salida de System.exit();
            int exitVal = p.waitFor();
            System.out.println(" ");
            System.out.println("Valor de salida: "+ exitVal);

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (null != is) {
                is.close();
            }
        }
    }

}