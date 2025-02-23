package es.jorge.ContestarPreguntas;

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

        //Para leer al usuario
        scanner = new Scanner(System.in);

        boolean salir = false;
        while(!salir){

            //El cliente hace su pregunta
            System.out.print("Escribe tu pregunta: ");
            String preguntaCliente = scanner.nextLine();

            //Le mandamos la pregunta al servidor
            oos.writeObject(preguntaCliente);
            oos.flush();

            //Escuchamos la respuesta y se la muestro al usuario
            String respuestaServidor;

            if( (respuestaServidor = (String) ois.readObject()).equalsIgnoreCase("salir") ){

                System.out.println("Saliendo...");
                salir = true;

            } else {
                System.out.println("La respuesta es: " +respuestaServidor);

            }

        }

        oos.close();
        ois.close();
        socket.close();
    }
}