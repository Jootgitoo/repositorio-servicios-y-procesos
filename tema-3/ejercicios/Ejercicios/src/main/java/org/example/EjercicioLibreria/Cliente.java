package org.example.EjercicioLibreria;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    //ATRIBUTOS
    Socket socket = null;

    //Para mandar los datos al servidor
    PrintWriter pw = null;
    Scanner scanner = null;

    //Para recibir los datos del servidor
    BufferedReader bfr = null;
    InputStreamReader isr = null;
    ObjectInputStream ois = null;
//--------------------------------------------------------------------------------------
    //MÉTODOS

    public static void main(String[] args) throws IOException {
        Cliente cliente = new Cliente();
        cliente.inicializarCliente();
    }

    public void inicializarCliente() throws IOException {

        InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);

        //Inicio el socket
        socket = new Socket();

        //Me conecto al servidor
        socket.connect(direccion);
        System.out.println("Cliente conectado al servidor");

        boolean salir = false;
        while (!salir){

            //Pregunto al cliente cuantos libros quiere obtener
            System.out.print("Cuantos libros quieres coger de la libreria: ");
            scanner = new Scanner(System.in);

            String numeroLibros = scanner.nextLine();

            pw = new PrintWriter( socket.getOutputStream(), true);
            //Envio el numero de libros que quiere el cliente al servidor
            pw.println(numeroLibros);

            //Recojo la informacion del servidor
            isr = new InputStreamReader(socket.getInputStream());
            bfr = new BufferedReader(isr);

            //Leo todas las respuestas del servidor
            String respuesta;
            while ( (respuesta = bfr.readLine()) != null){
                System.out.println(respuesta);

                if(respuesta.equalsIgnoreCase("No hay mas libros disponibles. Vuelva otro dia")){
                    salir = true;
                    System.out.println("saliendo...");
                }
            }

            bfr.close();
            isr.close();
            pw.close();
            socket.close();
        }

    }
}