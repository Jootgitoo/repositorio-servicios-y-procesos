package org.example.EjercicioMaquinaRefrescos;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        Socket socket = null;

        //Leemos los datos recibidos del servidor
        BufferedReader bfr = null;
        InputStreamReader isr = null;

        //Para enviar datos al servidor
        PrintWriter pw = null;

        try {
            //Dirección del servidor
            InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);

            //Inicio el socket
            socket = new Socket();

            //Lo conecto al servidor
            socket.connect(direccion);

            boolean salir = false;
            while (!salir){
                //Hablamos al servidor
                pw = new PrintWriter(socket.getOutputStream(), true);
                pw.println("9");
                System.out.println("Pido 9 refrescos");


                //Recogemos la información del servidor
                isr = new InputStreamReader(socket.getInputStream());
                bfr = new BufferedReader(isr);

                String respuestaServidor = bfr.readLine(); //Recibimos la respuesta del servidor sobre los refrescos
                System.out.println(respuestaServidor);

                String refrescosRestantes = bfr.readLine(); //Recibimos cuantos refrescos quedan
                System.out.println(refrescosRestantes);

                String salimos = bfr.readLine(); //Si el cliente recibe una segunda linea diciendo salir salimos del bucle
                if(salimos.equalsIgnoreCase("salir")){
                    salir = true;
                    System.out.println();
                    System.out.println("Apagando la maquina...");
                }
                Thread.sleep(1000);

                System.out.println();
            }
            bfr.close();
            isr.close();
            pw.close();
            socket.close();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
