package org.example.EjercicioMaquinaRefrescos;

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

            //Hablamos al servidor
            pw = new PrintWriter(socket.getOutputStream());
            pw.println("50");
            System.out.println("Peticion de 50 refrescos");
            //pw.println("25");
            //pw.println("25");

            //Recogemos la información del servidor
            isr = new InputStreamReader(socket.getInputStream());
            bfr = new BufferedReader(isr);
            System.out.println(bfr.readLine());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
