package es.jorge.Libreria;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket socketEscucha = null;

        try{

            socketEscucha = new ServerSocket(9876);
            System.out.println("Arrancando el servidor");

            Libreria libreria = new Libreria();

            while (true){
                try {
                    Socket conexion = socketEscucha.accept();

                    Peticion hilo = new Peticion(conexion, libreria);

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