package org.example.EjercicioContestarPreguntas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        ServerSocket socketEscucha = null;

        try {
            //Puerto por el que va a escuchar el servidor
            socketEscucha = new ServerSocket(9876);
            System.out.println("Arrancando el servidor");

            while(true){ //Creo un servidor infinito

                //Acepto la conexion
                Socket conexion = socketEscucha.accept();

                //Creamos un hilo para manejar la conexion con el cliente
                Peticion hilo = new Peticion(conexion);

                hilo.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(socketEscucha != null){
                try {
                    socketEscucha.close(); //Cerramos la conexion
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
