package org.example.EjercicioContestarPreguntas;

import java.io.*;
import java.net.Socket;

public class Peticion extends Thread{

    Socket socket;

    public Peticion(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            escuchar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Escuchamos al cliente
    public void escuchar() throws IOException {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader bf = null;
        OutputStream os = null;
        PrintWriter pw = null;

        System.out.println("Conexion con el cliente recibida!");

        //Leemos lo que nos dice el cliente
        is = socket.getInputStream();
        isr = new InputStreamReader(is);
        bf = new BufferedReader(isr);

        //Escucho la pregunta del cliente
        String pregunta = bf.readLine();
        System.out.println("He escuchado la pregunta del cliente");

        String respuesta = responderACliente(pregunta);

        os = socket.getOutputStream();
        pw = new PrintWriter(os, true);
        pw.println(respuesta);
        pw.flush();
        System.out.println("He respondido al cliente");
    }

    private String responderACliente(String pregunta){

        String respuesta;

        switch (pregunta){
            case "¿Cual es la capital de portugal?":
                respuesta = "Lisboa";
            break;

            case "¿Quien escribio don quijote de la mancha?":
                respuesta = "Miguel de Cervantes";
            break;

            case "¿Cual es el rio mas largo del mundo ?":
                respuesta = "Amazonas";
            break;

            case "¿En que año llegó el hombre a la luna?":
                respuesta = "1969";
            break;

            case "¿Cual es el idioma más hablado en el mundo?":
                respuesta = "Chino mandarin";
            break;

            default:
                respuesta = "No entiendo la pregunta";
            break;

        }
        return respuesta;
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












