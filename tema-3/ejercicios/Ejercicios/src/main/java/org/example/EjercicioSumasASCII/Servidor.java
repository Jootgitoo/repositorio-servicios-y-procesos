package org.example.EjercicioSumasASCII;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
    public static void main(String[] args) throws IOException {

            ServerSocket socketEscucha = null;

            try{
                //Puerto por el que va a escuchar nuestro servidor
                socketEscucha = new ServerSocket(9876);
                System.out.println("Arrancando el servidor");

                //Creamos un servidor infinito (Bucle infinito)
                while (true){
                    try {
                        //Establezco la conexion
                        Socket conexion = socketEscucha.accept();

                        //Creamos un hilo que manejar la conexion con el cliente
                        Peticion hilo = new Peticion(conexion);

                        hilo.start();
                    } catch (IOException e){
                        e.printStackTrace();
                        throw e;
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
                throw e;
            } finally {
                //Cerramos la conexion
                try{
                    if (socketEscucha != null){
                        socketEscucha.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }


}
