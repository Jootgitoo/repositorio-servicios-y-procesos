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
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bf = new BufferedReader(isr);
        OutputStream os = null;
        PrintWriter pw = null;

        System.out.println("Conexion con el cliente recibida!");

        while(true){

            //Leemos la pregunta del cliente
            String pregunta = bf.readLine();


            //Buscamos cual es la respuesta a la pregunta
            String respuesta = responderACliente(pregunta);

            //Respondemos al cliente
            os =  new ObjectOutputStream( socket.getOutputStream() );
            pw = new PrintWriter(os, true);

            pw.println(respuesta);
            System.out.println("He respondido al cliente");
        }

    }

    private String responderACliente(String pregunta){

        String respuesta;

        switch (pregunta){
            case "¿Cual es la capital de portugal?":
                respuesta = "Lisboa \n";
            break;

            case "¿Quien escribio don quijote de la mancha?":
                respuesta = "Miguel de Cervantes \n";
            break;

            case "¿Cual es el rio mas largo del mundo ?":
                respuesta = "Amazonas \n";
            break;

            case "¿En que año llegó el hombre a la luna?":
                respuesta = "1969 \n";
            break;

            case "¿Cual es el idioma más hablado en el mundo?":
                respuesta = "Chino mandarin \n";
            break;

            case "salir":
                respuesta = "saliendo... \n";
            break;

            default:
                respuesta = "No entiendo la pregunta";
            break;

        }
        return respuesta;
    }

}












