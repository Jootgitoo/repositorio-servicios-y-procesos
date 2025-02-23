package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    Socket socket = null;

    PrintWriter pw = null;

    BufferedReader bfr = null;
    InputStreamReader isr = null;


    public static void main(String[] args) throws IOException, InterruptedException {
        Cliente cliente = new Cliente();
        cliente.inicializarCliente();
    }

    public void inicializarCliente() throws IOException, InterruptedException {
        InetSocketAddress direccion = new InetSocketAddress("localhost", 5555);

        socket = new Socket();

        socket.connect(direccion);
        System.out.println("Conexion con el servidor hecha");


        isr = new InputStreamReader(socket.getInputStream());
        bfr = new BufferedReader(isr);



        //Le pido al servidor el nombre de los eventos disponibles
        pw = new PrintWriter( socket.getOutputStream(), true );
        pw.println("listar eventos");

        //Leo la respuesta del servidor
        String respuesta;
        boolean finRespuesta = false;
        System.out.println("Lista de los eventos");
        while (finRespuesta){
            respuesta = bfr.readLine();

            if(respuesta.equalsIgnoreCase("fin_peticion")){
                finRespuesta = true;
            } else{
                System.out.println(" - " +respuesta);
            }
        }
        System.out.println("=======================================================================");
        System.out.println();


        //Numero aleatorio entre 0 y 3 (incluidos)
        int numeroEvento = (int) (Math.random() * 3);
        System.out.println("Solicito entradas para el evento: " +numeroEvento);
        //Envio el numero del evento
        pw.println(numeroEvento);

        //Numero entradas entre 1 y 10 (incluidos)
        int numeroEntradas = (int) (Math.random() * 10) + 1;
        System.out.println("Solicito " +numeroEntradas+ " entradas");
        //Envio el numero de entradas
        pw.println(numeroEntradas);

        //Escucho la respuesta del servidor(si hay o no entradas)
        finRespuesta = false;
        while (finRespuesta){
            respuesta = bfr.readLine();

            if(respuesta.equalsIgnoreCase("fin_peticion")){
                finRespuesta = true;
            } else{
                System.out.println(respuesta);
            }
        }


        isr.close();
        bfr.close();
        socket.close();
    }
}