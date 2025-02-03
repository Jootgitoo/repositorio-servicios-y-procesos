package es.jorge;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    //ATRIBUTOS
    Socket socket = null;

    //Para mandar los datos al servidor
    PrintWriter pw = null;

    //Para recibir los datos del servidor
    BufferedReader bfr = null;
    InputStreamReader isr = null;


    //----------------------------------------------------------------------------
    //MÉTODOS

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Cliente cliente = new Cliente();
        cliente.inicializarCliente();
    }

    public void inicializarCliente() throws IOException, InterruptedException {
        InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);

        //Inicio el socket
        socket = new Socket();

        socket.connect(direccion);
        System.out.println("Conexion con el servidor hecha");


        boolean salir = false;
        while(!salir){

        }

    }
}