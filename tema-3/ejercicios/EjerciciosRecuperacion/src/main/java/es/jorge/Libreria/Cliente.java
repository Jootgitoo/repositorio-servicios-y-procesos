package es.jorge.Libreria;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    Socket socket = null;

    //Para leer los datos del servidor
    ObjectInputStream ois = null;

    //Para enviar peticiones al servidor
    ObjectOutputStream oos = null;

    Scanner scanner = null;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cliente c = new Cliente();
        c.lanzarCliente();

    }

    public void lanzarCliente() throws IOException, ClassNotFoundException {

        InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);

        socket = new Socket();

        socket.connect(direccion);

        System.out.println("Cliente --> Servidor conectado correctamente");

        //Para hablar al servidor
        oos = new ObjectOutputStream( socket.getOutputStream() );

        //Recogemos la info del servidor
        ois = new ObjectInputStream( socket.getInputStream() );

        scanner = new Scanner(System.in);

        boolean salir = false;
        while(!salir){

            //Le pregunto al usuario cuantos libros va a querer
            System.out.print("Cuantos libros vas a querer: ");
            String numeroLibrosCliente = scanner.nextLine();

            //Envio la peticion al servidor
            oos.writeObject(numeroLibrosCliente);

            //Recojo los datos del servidor
            boolean leer = true;
            while (leer){
                String respuestaServidor = (String) ois.readObject();

                if( respuestaServidor.equalsIgnoreCase("fin_respuesta") ){
                    leer = false;
                } else if (respuestaServidor.equalsIgnoreCase("salir")) {
                    leer = false;
                    salir = true;
                    System.out.println("No hay más libros vuelva otro dia");
                } else {
                    System.out.println(respuestaServidor);
                }
            }
            System.out.println();
        }

        oos.close();
        ois.close();
        socket.close();
    }
}