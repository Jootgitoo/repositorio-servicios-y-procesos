package es.jorge.CarreraCamellos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {

    Socket socket = null;

    //Para leer los datos del servidor
    ObjectInputStream ois = null;

    //Para enviar peticiones al servidor
    ObjectOutputStream oos = null;

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

            //Enviamos un mensaje al servidor para que empiece la carrera
            oos.writeObject("Que empiece la carrera");
            oos.flush();

            boolean leer = true;
            while(leer){
                String respuesta = (String) ois.readObject();

                if( respuesta.equalsIgnoreCase("fin_juego") ){

                    leer = false;
                    salir = true;

                    System.out.println("Fin del juego");

                } else if ( respuesta.equalsIgnoreCase("fin_peticion") ) {

                    leer = false;
                } else {

                    System.out.println(respuesta);

                }
                System.out.println();

            }

        }

        oos.close();
        ois.close();
        socket.close();
    }
}