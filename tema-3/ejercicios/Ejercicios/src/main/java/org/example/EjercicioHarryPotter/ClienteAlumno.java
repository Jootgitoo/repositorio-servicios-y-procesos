package org.example.EjercicioHarryPotter;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteAlumno {
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
        ClienteAlumno cliente = new ClienteAlumno();
        cliente.inicializarCliente();
    }

    public void inicializarCliente() throws IOException, ClassNotFoundException, InterruptedException {
        InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);

        //Inicio el socket
        socket = new Socket();

        socket.connect(direccion);
        System.out.println("Conexion con el servidor hecha");


        boolean salir = false;
        while(!salir){

            //Hablamos al servidor
            pw = new PrintWriter( socket.getOutputStream(), true );
            pw.println("Quiero una varita");

            //Recogemos la info del servidor
            isr = new InputStreamReader(socket.getInputStream());
            bfr = new BufferedReader(isr);

            String respuesta = bfr.readLine();

            if( respuesta != null ){
                System.out.println(respuesta);

                if (respuesta.equalsIgnoreCase("No quedan mas baritas")){
                    salir = true;
                    System.out.println("saliendo...");
                }
            }
            System.out.println();
            Thread.sleep(2000);
        }
        bfr.close();
        isr.close();
        pw.close();
        socket.close();
    }

}