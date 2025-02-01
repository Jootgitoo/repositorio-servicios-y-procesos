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
        scanner = new Scanner(System.in);
        while (!salir){

            //Pregunto al cliente que libro quiere
            System.out.print("Que libro quieres coger: ");
            String nombreLibro = scanner.nextLine();

            //Pregunto al cliente cuantos libros quiere obtener
            System.out.print("Cuantos libros quieres coger de la libreria: ");
            String numeroLibros = scanner.nextLine();

            //Envio ambas lineas al servidor
            pw = new PrintWriter( socket.getOutputStream(), true);
            pw.println(nombreLibro);
            pw.println(numeroLibros);

            //Leo todas las respuestas del servidor
            isr = new InputStreamReader(socket.getInputStream());
            bfr = new BufferedReader(isr);

            String respuesta;

            while (true) {
                respuesta = bfr.readLine();
                if (respuesta.equalsIgnoreCase("FIN_RESPUESTA")) {
                    break;
                }
                System.out.println(respuesta);

                if (respuesta.equalsIgnoreCase("No hay mas libros disponibles. Vuelva otro dia")) {
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                }
            }
            System.out.println("======================================================================");
        }
        bfr.close();
        isr.close();
        pw.close();
        socket.close();

    }
}