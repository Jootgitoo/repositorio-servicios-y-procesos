package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket socketEscucha = null;

        try{

            socketEscucha = new ServerSocket(5555);
            System.out.println("Arrancando el servidor");

            PlatoComida platoComida = new PlatoComida();

            while (true){
                try {
                    Socket conexion = socketEscucha.accept();

                    Peticion hilo = new Peticion(conexion, platoComida);

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