package org.example.EjercicioAdivinaNumero;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    Socket socket;

    //Para hablar al servidor
    PrintWriter pw;

    //Para recoger informacion
    InputStreamReader isr = null;
    BufferedReader bf = null;

    //Para interactuar con el usuario
    Scanner scanner = null;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        cliente.iniciarCliente();
    }


    public void iniciarCliente() throws IOException{
        InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);

        socket = new Socket();

        socket.connect(direccion);
        System.out.println("Conexion cliente --> servidor");

        //Pedimos un numero al usuario y se lo mandamos al cliente
        scanner = new Scanner(System.in);

        boolean salir = false;
        while(!salir){

            //Para que mande informacion
            pw = new PrintWriter(socket.getOutputStream(), true);

            //Para que reciba informacion
            isr = new InputStreamReader( socket.getInputStream() );
            bf = new BufferedReader(isr);


            System.out.print("> Inidique un numero: ");

            String numeroUsuario = scanner.nextLine();

            //Envio el numero al servidor
            pw.println(numeroUsuario);

            String respuestaServidor;

            while (true){
                respuestaServidor = bf.readLine();

                if(respuestaServidor.equalsIgnoreCase("fin_juego")){
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                }
                System.out.println(respuestaServidor);

            }
            System.out.println();

        }
        pw.close();
        bf.close();
        isr.close();
        socket.close();
    }
}















