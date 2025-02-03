package org.example.EjercicioAdivinaNumero;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private int numeroAleatorio;

    public Servidor(){
        crearNumeroAleatorio();
    }

    public static void main(String[] args) throws IOException {
        Servidor servidor = new Servidor();
        servidor.crearServidor();

    }

    public void crearNumeroAleatorio(){
        this.numeroAleatorio = (int) (Math.random() * 10) + 1;
    }

    public void crearServidor() throws IOException {
        ServerSocket socketEscucha = null;

        socketEscucha = new ServerSocket(9876);
        System.out.println("Arrancando el servidor");

        //Creamos un servidor infinito (Bucle infinito)
        while (true){
            try {

                //Establezco la conexion
                Socket conexion = socketEscucha.accept();

                //Creamos un hilo que manejar la conexion con el cliente
                Peticion hilo = new Peticion(conexion);

                hilo.start();
            } catch (IOException e){
                e.printStackTrace();
                throw e;
            }
        }
    }

    public int getNumeroAleatorio() {
        return numeroAleatorio;
    }
}