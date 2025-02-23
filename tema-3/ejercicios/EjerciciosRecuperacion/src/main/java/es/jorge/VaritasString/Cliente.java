package es.jorge.VaritasString;

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

            //Pedimos una varita al servidor
            oos.writeObject("Quiero una varita");
            oos.flush();

            //Recojo la info del servidor
            Varitas varita = (Varitas) ois.readObject();

            if( varita == null ){
                salir = true;
                System.out.println("No hay varitas");
                System.out.println("Saliendo...");

            }else {
                System.out.println("Nombre varita: " +varita.getNombre());
            }

        }

        oos.close();
        ois.close();
        socket.close();
    }
}