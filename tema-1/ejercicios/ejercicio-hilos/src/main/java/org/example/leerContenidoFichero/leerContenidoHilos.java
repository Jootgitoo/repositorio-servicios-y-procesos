package org.example.leerContenidoFichero;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class leerContenidoHilos extends Thread{

    public void leerArchivo(){

        File archivoALeer = new File("src/main/java/org/example/leerContenidoFichero/enuncaido.txt");

        BufferedReader lectura = new BufferedReader( new FileReader(archivoALeer) );

        String linea;

        if ( (  linea = lectura.readLine()) != null){

            String[] aux = linea.split(" ");

            for (int j=0; j<aux.length; j++){
                conta++;
            }
        }
    }


    public void run(){

        try{


            int conta = 0;









        } catch (FileNotFoundException exception) {
            System.out.println("Excepcion: " + exception);

        } catch (IOException exception) {
            System.out.println("Excepcion: " + exception);
        }

    }

}
