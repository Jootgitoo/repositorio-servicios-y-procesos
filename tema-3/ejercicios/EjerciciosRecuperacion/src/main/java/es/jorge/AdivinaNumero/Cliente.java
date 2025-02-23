package es.jorge.AdivinaNumero;


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

    Scanner scanner = new Scanner(System.in);

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

        boolean salir = false;
        while(!salir){

            //Leo la peticion del cliente
            System.out.print("El numero a adivinar es: ");
            String peticionCliente = scanner.nextLine();

            //Se la envio al servidor
            oos.writeObject(peticionCliente);

            //Escucho la respuesta del servidor
            boolean leerRespuesta = true;
            while(leerRespuesta){

                String respuesta = (String) ois.readObject();

                if( respuesta.contains("acertado") ){

                    leerRespuesta = false;
                    salir = true;
                    System.out.println(respuesta);

                } else if (respuesta.equalsIgnoreCase("fin_peticion")) {

                    leerRespuesta = false;

                } else {
                    System.out.println(respuesta);
                }
            }

        }

        oos.close();
        ois.close();
        socket.close();
    }
}













