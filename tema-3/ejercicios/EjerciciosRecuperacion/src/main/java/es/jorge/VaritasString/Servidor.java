package es.jorge.VaritasString;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket socketEscucha = null;

        try{

            socketEscucha = new ServerSocket(9876);
            System.out.println("Arrancando el servidor");

            while (true){
                try {
                    Socket conexion = socketEscucha.accept();

                    //Suma suma = new Suma();
                    Varitas varitas = new Varitas();

                    Peticion hilo = new Peticion(conexion, varitas);

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