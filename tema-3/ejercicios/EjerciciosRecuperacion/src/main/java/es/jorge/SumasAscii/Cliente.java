package es.jorge.SumasAscii;

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

        //Inicio el socket
        socket = new Socket();

        socket.connect(direccion);

        System.out.println("Cliente --> Servidor conectado correctamente");

        //Para hablar al servidor
        oos = new ObjectOutputStream( socket.getOutputStream() );

        //Recogemos la info del servidor
        ois = new ObjectInputStream( socket.getInputStream() );

        boolean salir = false;
        while(!salir){

            //Pedimos al cliente lo que quiere
            scanner = new Scanner(System.in);
            System.out.print("Caracteres de los que quieres sacar la suma: ");
            String respuesta = scanner.nextLine();

            //Se lo mandamos al servidor
            oos.writeObject(respuesta);
            oos.flush();

            String respuestaServidor;
            if( (respuestaServidor = (String) ois.readObject()).equalsIgnoreCase("salir") ){ //Si el servidor devuelve salir

                //Salimos
                System.out.println("saliendo...");
                salir = true;

            } else{ //Si no devuelve salir es q devuelve una linea
                System.out.println(respuestaServidor);
            }
        }

        oos.close();
        ois.close();
        socket.close();
    }
}


















