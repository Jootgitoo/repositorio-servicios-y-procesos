package es.jorge.socketStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetSocketAddress;

public class ServidorSocketStream {

    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Creando socket servidor");
            ServerSocket serverSocket = new ServerSocket();
            System.out.println("Realizando el bind");

            InetSocketAddress addr = new InetSocketAddress ("localhost", 5555);
            serverSocket.bind(addr);
            System.out.println("Aceptando conexiones");

            //El servidor espera hasta que llega la coxeion del cliente
            Socket newSocket = serverSocket.accept();

            System.out.println("Conexión recibida");

            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();

            byte[] mensaje = new byte[25];

            //Relleno el array mensje la informacion que tiene is
            is.read(mensaje);
            System.out.println("Mensaje recibido: " + new String(mensaje));

            //Cierro la comunicacion con el cliente
            System.out.println("Cerrando el nuevo socket");
            newSocket.close();

            //Cierro el servidor
            System.out.println("Cerrando el socket servidor");
            serverSocket.close();

            System.out.println("Terminado");

        } catch(IOException e) {
            e.printStackTrace();
            throw e;
        }

    }

}
