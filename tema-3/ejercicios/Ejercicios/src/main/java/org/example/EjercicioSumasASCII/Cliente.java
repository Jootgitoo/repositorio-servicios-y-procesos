package org.example.EjercicioSumasASCII;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.Closeable;

public class Cliente {
    public static void main(String[] args) {
        Socket socket = null;

        //Leemos los datos recibidos por el servidor
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
            System.out.println("conexion cliente hecha");

            //Hablamos al servidor
            pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("3");
            pw.println("ABC");
            pw.println("ZZ");
            pw.println("AAA");


            //Recogemos la información del servidor
            isr = new InputStreamReader(socket.getInputStream());
            bfr = new BufferedReader(isr);
            String resultado;
            while ( (resultado = bfr.readLine()) != null){
                System.out.println("Resultado de la suma de los caracteres ASCII: " +resultado);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            close(pw);
            close(bfr);
            close(isr);
            close(socket);
        }

    }


    /**
     * Método para cerrar el socket
     * @param socket Socket que vamos a cerrar
     */
    private static void close(Closeable socket) {
        try {
            if (null != socket) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
