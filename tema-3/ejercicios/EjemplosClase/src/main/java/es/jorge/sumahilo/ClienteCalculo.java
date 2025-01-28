package es.jorge.sumahilo;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteCalculo {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
        Socket socket = null; //Representa la conexion con el servidor

        //Se utiliza para leer los datos recibidos por el servidor
        BufferedReader bfr = null;
        InputStreamReader isr = null;

        //Se usa para enviar datos al servidor
        PrintWriter pw = null;

        try {
            //Defino la dirección del servidor
            InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);

            socket = new Socket(); //Inicializo el Socket
            socket.connect(direccion); //Lo conecto al servidor

            //Escribe la peticion al servidor --> Hablamos al servidor
            pw = new PrintWriter(socket.getOutputStream(), true);
            pw.print("-\n");
            pw.print("20\n");
            pw.print("15\n");


            //Lee la respuesta del servidor
            isr = new InputStreamReader(socket.getInputStream());
            bfr = new BufferedReader(isr);
            String resultado = bfr.readLine();
            System.out.println("El resultado fue: " + resultado);
        }
        catch(IOException e) {
            e.printStackTrace();
            throw e;
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
