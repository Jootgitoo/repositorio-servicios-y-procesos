package es.jorge.MaquinaRefrescos;

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

            //Le pregunto al cliente cuantos refrescos quiere
            System.out.print("Cuantos refrescos quieres: ");
            String peticionCliente = scanner.nextLine();

            //Se lo pregunto al cliente
            oos.writeObject(peticionCliente);
            oos.flush();

            //Leo la respuesta del servidor
            String respuestaServidor;

            while (true){
                respuestaServidor = (String) ois.readObject();

                if( respuestaServidor.equalsIgnoreCase("salir") ){

                    System.out.println("Saliendo...");
                    salir = true;
                    break;

                } else if (respuestaServidor.equalsIgnoreCase("fin_respuestas")) {

                    break;

                } else {

                    System.out.println("Respuesta: " +respuestaServidor);

                }
            }
            System.out.println();
        }

        scanner.close();
        oos.close();
        ois.close();
        socket.close();
    }
}