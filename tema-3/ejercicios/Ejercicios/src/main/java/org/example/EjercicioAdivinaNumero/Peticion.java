package org.example.EjercicioAdivinaNumero;

import java.io.*;
import java.net.Socket;

public class Peticion extends Thread{

    Socket socket;
    Servidor srv;

    //Para enviar cosas al cliente
   PrintWriter pw = null;

    //Para recibir cosas del cliente
    InputStream is = null;
    InputStreamReader isr = null;
    BufferedReader bfr = null;

    public Peticion(Socket socket){
        this.socket = socket;
        srv = new Servidor();
    }

    @Override
    public void run(){
        //Cuando se inicia el hilo se ejecuta el método escuchar
        try {
            escuchar();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void escuchar() throws IOException, ClassNotFoundException {

        while(true) {

            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            bfr = new BufferedReader( isr );

            //Escuchamos el numero
            String SnumeroUsuario = bfr.readLine();

            //Lo tranformamos a int
            int numeroUsuario = Integer.parseInt(SnumeroUsuario);

            pw = new PrintWriter( socket.getOutputStream(), true);
            //Lo comparamos con el numero del servidor
            if (numeroUsuario < srv.getNumeroAleatorio()) {

                pw.println("El numero indicado es menor al que tienes que adivinar");

            } else if (numeroUsuario == srv.getNumeroAleatorio()) {
                pw.println("Has acertado el numero!");
                pw.println("fin_juego");

            } else if (numeroUsuario > srv.getNumeroAleatorio()) {

                pw.println("El numero indicado es menor");

            }
        }
    }
}




















