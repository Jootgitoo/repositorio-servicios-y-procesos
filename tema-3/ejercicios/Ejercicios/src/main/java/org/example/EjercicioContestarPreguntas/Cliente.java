package org.example.EjercicioContestarPreguntas;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        Socket socket = null;

        //Para leer lo que nos ha dicho el servidor
        BufferedReader bfr = null;
        InputStreamReader isr = null;

        //Para enviar datos al servidor
        PrintWriter pw = null;


        try{
            //Direccion del servidor
            InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
            socket = new Socket();

            //Conecto el cliente al servidor
            socket.connect(direccion);
            System.out.println("Conexion cliente --> servidor hecha");

            //Lo hacemos infinito hasta que le decimos que salga
            boolean salir = false;
            Scanner scanner = new Scanner(System.in);

            while (!salir){

                //Para blaar al servidior
                pw = new PrintWriter(socket.getOutputStream(), true);

                //Para hablar al cliente
                isr = new InputStreamReader(socket.getInputStream());
                bfr = new BufferedReader(isr);


                //Pedimos al usuario que escriba la pregunta
                System.out.print("Escribe tu pregunta: ");
                String pregunta = scanner.nextLine();

                //Se la mandamos al servidor
                pw.println(pregunta);

                //Recogemos la información del servidor

                String resultado = bfr.readLine();

                System.out.println(resultado);

                if(resultado.equals("salir")){
                    salir = true;
                }

                System.out.println();
                System.out.println();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(pw);
            close(bfr);
            close(isr);
            close(socket);

        }
    }

    private static void close(Closeable socket){

        if(socket != null){
            try {
                socket.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
    }

}
