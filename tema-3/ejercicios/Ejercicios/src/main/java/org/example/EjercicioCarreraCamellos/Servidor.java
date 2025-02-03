package org.example.EjercicioCarreraCamellos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

    List<Jugador> listaJuagdores = new ArrayList<>();


    public Servidor(){
        rellenarLista(listaJuagdores);
    }

    public static void main(String[] args) throws IOException {
        Servidor servidor = new Servidor();
        servidor.crearServidor();
    }

    public void rellenarLista(List<Jugador> listaJuagdores){

        Camello c1 = new Camello("Camello 1");
        Camello c2 = new Camello("Camello 2");
        Camello c3 = new Camello("Camello 3");
        Camello c4 = new Camello("Camello 4");
        Camello c5 = new Camello("Camello 5");

        Jugador j1 = new Jugador(1, "Jugador 1", c1);
        Jugador j2 = new Jugador(2, "Jugador 2", c2);
        Jugador j3 = new Jugador(3, "Jugador 3", c3);
        Jugador j4 = new Jugador(4, "Jugador 4", c4);
        Jugador j5 = new Jugador(5, "Jugador 5", c5);

        listaJuagdores.add(j1);
        listaJuagdores.add(j2);
        listaJuagdores.add(j3);
        listaJuagdores.add(j4);
        listaJuagdores.add(j5);

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
                PeticionCarrera hilo = new PeticionCarrera(conexion);

                hilo.start();
            } catch (IOException e){
                e.printStackTrace();
                throw e;
            }
        }
    }
}