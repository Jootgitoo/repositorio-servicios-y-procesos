package es.jorge.sumahilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculoHilo {

    public static void main(String[] args) throws Exception {
        ServerSocket socketEscucha = null; //Creamos un socket SERVIDOR
        try {
            socketEscucha = new ServerSocket(9876); //Puerto del que va a escuchar (tiene q ser el mismo que el cliente para que funcione)
            System.out.println("Arrancado el servidor");

            //Buble infinito para que el servidor siempre esté escuchando y no se pare
            while (true){
                try {
                    //.accept() --> Bloquea la ejecución hasta que un cliente intenta conectarse.
                    //conexion = A la conexion establecida con el cliente
                    Socket conexion = socketEscucha.accept();

                    //Creamos un hilo que va a manejar la conexión con el cliente
                    Peticion hilo = new Peticion(conexion);
                    //Iniciamos el hilo para manejar la conexión
                    hilo.start();
                }
                catch(IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
            throw e;
        }
        finally {
            //Cerramos la conexion
            try {
                if (null != socketEscucha) {
                    socketEscucha.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
