package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Conector {
    public static void main(String[] args) throws Exception {
        String url = "www.google.es";
        int puerto = 443; //HTTPS

        SSLSocketFactory factory = null;
        SSLSocket socket = null;
        FileWriter fWriter = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            //Abrimos un canal seguro de comunicación
            factory = (SSLSocketFactory) SSLSocketFactory.getDefault(); //Creas objetos de la clase implementada
            socket = (SSLSocket) factory.createSocket(url, puerto); //SSLSocket crea una comunicacion segura

            // Escribo peticion a google
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            //out.println("GET /index.html");
            //out.println("GET /?hl=es");
            out.println("GET /search?q=java");
            out.println();
            //out.flush(); //Los ultimos datos terminan de ser enviados para asegurarnos

            /*
             * Comprobar que no ha ocurrido ning�n error
             */
            if (out.checkError()) { //Este método hace el flush y si no se ha cerrado comprueba si hay una excepcion en la comunicación
                System.out.println("SSLSocketClient:  java.io.PrintWriter error");
            }

            /* leer respuesta */
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;
            fWriter = new FileWriter("resultado.html");
            while ((inputLine = in.readLine()) != null) {
                fWriter.write(inputLine);
            }

        } catch (IOException e) {
            System.out.println("No se pudo establecer la conexion o hubo un fallo al leer datos. " + e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            if (null != in) {
                in.close();
            }
            if (null != out) {
                out.close();
            }
            if (null != fWriter) {
                fWriter.close();
            }
            if (null != socket) {
                socket.close();
            }
        }
    } // Fin del main
} // Fin de la clase Conector