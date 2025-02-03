package es.jorge;


import java.io.*;
import java.net.Socket;

public class Peticion extends Thread{

    Socket socket;

    public Peticion(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        //Cuando se inicia el hilo se ejecuta el método escuchar
        escuchar();
    }

    public void escuchar(){
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader bfr = null;
        ObjectInputStream ois = null;
        PrintWriter pw = null;

        System.out.println("Conexion con el cliente recibida");

        while (true){

        }
    }
}